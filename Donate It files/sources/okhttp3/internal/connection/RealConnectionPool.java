package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import com.miniproject.bhojanamv3.utils.Constants;
import java.lang.ref.Reference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.ConnectionPool;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.platform.Platform;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u000e\u0018\u0000 (2\u00020\u0001:\u0001(B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ.\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u0015J\u000e\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007J\u000e\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u0012J\u0006\u0010\"\u001a\u00020\u0005J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020\u0005J\u0018\u0010&\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0007H\u0002J\u000e\u0010'\u001a\u00020$2\u0006\u0010!\u001a\u00020\u0012R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lokhttp3/internal/connection/RealConnectionPool;", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "maxIdleConnections", "", "keepAliveDuration", "", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "(Lokhttp3/internal/concurrent/TaskRunner;IJLjava/util/concurrent/TimeUnit;)V", "cleanupQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "cleanupTask", "okhttp3/internal/connection/RealConnectionPool$cleanupTask$1", "Lokhttp3/internal/connection/RealConnectionPool$cleanupTask$1;", "connections", "Ljava/util/ArrayDeque;", "Lokhttp3/internal/connection/RealConnection;", "keepAliveDurationNs", "callAcquirePooledConnection", "", "address", "Lokhttp3/Address;", "call", "Lokhttp3/internal/connection/RealCall;", "routes", "", "Lokhttp3/Route;", "requireMultiplexed", "cleanup", "now", "connectionBecameIdle", "connection", "connectionCount", "evictAll", "", "idleConnectionCount", "pruneAndGetAllocationCount", "put", "Companion", "okhttp"}, k = 1, mv = {1, 1, 16})
/* compiled from: RealConnectionPool.kt */
public final class RealConnectionPool {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final TaskQueue cleanupQueue;
    private final RealConnectionPool$cleanupTask$1 cleanupTask = new RealConnectionPool$cleanupTask$1(this, Util.okHttpName + " ConnectionPool");
    private final ArrayDeque<RealConnection> connections = new ArrayDeque<>();
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;

    public RealConnectionPool(TaskRunner taskRunner, int maxIdleConnections2, long keepAliveDuration, TimeUnit timeUnit) {
        Intrinsics.checkParameterIsNotNull(taskRunner, "taskRunner");
        Intrinsics.checkParameterIsNotNull(timeUnit, "timeUnit");
        this.maxIdleConnections = maxIdleConnections2;
        this.keepAliveDurationNs = timeUnit.toNanos(keepAliveDuration);
        this.cleanupQueue = taskRunner.newQueue();
        if (!(keepAliveDuration > 0)) {
            throw new IllegalArgumentException(("keepAliveDuration <= 0: " + keepAliveDuration).toString());
        }
    }

    public final synchronized int idleConnectionCount() {
        int count$iv;
        Iterable<RealConnection> $this$count$iv = this.connections;
        if (!($this$count$iv instanceof Collection) || !((Collection) $this$count$iv).isEmpty()) {
            count$iv = 0;
            for (RealConnection it : $this$count$iv) {
                if (it.getCalls().isEmpty() && (count$iv = count$iv + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        } else {
            count$iv = 0;
        }
        return count$iv;
    }

    public final synchronized int connectionCount() {
        return this.connections.size();
    }

    public final boolean callAcquirePooledConnection(Address address, RealCall call, List<Route> routes, boolean requireMultiplexed) {
        Intrinsics.checkParameterIsNotNull(address, Constants.ADDRESS);
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        if (!Util.assertionsEnabled || Thread.holdsLock(this)) {
            Iterator<RealConnection> it = this.connections.iterator();
            while (it.hasNext()) {
                RealConnection connection = it.next();
                if ((!requireMultiplexed || connection.isMultiplexed()) && connection.isEligible$okhttp(address, routes)) {
                    Intrinsics.checkExpressionValueIsNotNull(connection, "connection");
                    call.acquireConnectionNoEvents(connection);
                    return true;
                }
            }
            return false;
        }
        StringBuilder append = new StringBuilder().append("Thread ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        throw new AssertionError(append.append(currentThread.getName()).append(" MUST hold lock on ").append(this).toString());
    }

    public final void put(RealConnection connection) {
        Intrinsics.checkParameterIsNotNull(connection, "connection");
        if (!Util.assertionsEnabled || Thread.holdsLock(this)) {
            this.connections.add(connection);
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, (Object) null);
            return;
        }
        StringBuilder append = new StringBuilder().append("Thread ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        throw new AssertionError(append.append(currentThread.getName()).append(" MUST hold lock on ").append(this).toString());
    }

    public final boolean connectionBecameIdle(RealConnection connection) {
        Intrinsics.checkParameterIsNotNull(connection, "connection");
        if (Util.assertionsEnabled && !Thread.holdsLock(this)) {
            StringBuilder append = new StringBuilder().append("Thread ");
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
            throw new AssertionError(append.append(currentThread.getName()).append(" MUST hold lock on ").append(this).toString());
        } else if (connection.getNoNewExchanges() || this.maxIdleConnections == 0) {
            this.connections.remove(connection);
            if (this.connections.isEmpty()) {
                this.cleanupQueue.cancelAll();
            }
            return true;
        } else {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, (Object) null);
            return false;
        }
    }

    public final void evictAll() {
        List<RealConnection> evictedConnections = new ArrayList<>();
        synchronized (this) {
            Iterator i = this.connections.iterator();
            Intrinsics.checkExpressionValueIsNotNull(i, "connections.iterator()");
            while (i.hasNext()) {
                RealConnection connection = i.next();
                if (connection.getCalls().isEmpty()) {
                    connection.setNoNewExchanges(true);
                    Intrinsics.checkExpressionValueIsNotNull(connection, "connection");
                    evictedConnections.add(connection);
                    i.remove();
                }
            }
            if (this.connections.isEmpty()) {
                this.cleanupQueue.cancelAll();
            }
            Unit unit = Unit.INSTANCE;
        }
        for (RealConnection connection2 : evictedConnections) {
            Util.closeQuietly(connection2.socket());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0069, code lost:
        if (r2 != null) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x006b, code lost:
        kotlin.jvm.internal.Intrinsics.throwNpe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x006e, code lost:
        okhttp3.internal.Util.closeQuietly(r2.socket());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0077, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long cleanup(long r12) {
        /*
            r11 = this;
            r0 = 0
            r1 = 0
            r2 = 0
            okhttp3.internal.connection.RealConnection r2 = (okhttp3.internal.connection.RealConnection) r2
            r3 = -9223372036854775808
            monitor-enter(r11)
            r5 = 0
            java.util.ArrayDeque<okhttp3.internal.connection.RealConnection> r6 = r11.connections     // Catch:{ all -> 0x0078 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0078 }
        L_0x000f:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x0078 }
            if (r7 == 0) goto L_0x0038
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x0078 }
            okhttp3.internal.connection.RealConnection r7 = (okhttp3.internal.connection.RealConnection) r7     // Catch:{ all -> 0x0078 }
            java.lang.String r8 = "connection"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r8)     // Catch:{ all -> 0x0078 }
            int r8 = r11.pruneAndGetAllocationCount(r7, r12)     // Catch:{ all -> 0x0078 }
            if (r8 <= 0) goto L_0x0029
            int r0 = r0 + 1
            goto L_0x000f
        L_0x0029:
            int r1 = r1 + 1
            long r8 = r7.getIdleAtNs$okhttp()     // Catch:{ all -> 0x0078 }
            long r8 = r12 - r8
            int r10 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r10 <= 0) goto L_0x000f
            r3 = r8
            r2 = r7
            goto L_0x000f
        L_0x0038:
            long r6 = r11.keepAliveDurationNs     // Catch:{ all -> 0x0078 }
            int r8 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x0053
            int r8 = r11.maxIdleConnections     // Catch:{ all -> 0x0078 }
            if (r1 <= r8) goto L_0x0045
            goto L_0x0053
        L_0x0045:
            if (r1 <= 0) goto L_0x004a
            long r6 = r6 - r3
            monitor-exit(r11)
            return r6
        L_0x004a:
            if (r0 <= 0) goto L_0x004f
            monitor-exit(r11)
            return r6
        L_0x004f:
            r5 = -1
            monitor-exit(r11)
            return r5
        L_0x0053:
            java.util.ArrayDeque<okhttp3.internal.connection.RealConnection> r6 = r11.connections     // Catch:{ all -> 0x0078 }
            r6.remove(r2)     // Catch:{ all -> 0x0078 }
            java.util.ArrayDeque<okhttp3.internal.connection.RealConnection> r6 = r11.connections     // Catch:{ all -> 0x0078 }
            boolean r6 = r6.isEmpty()     // Catch:{ all -> 0x0078 }
            if (r6 == 0) goto L_0x0065
            okhttp3.internal.concurrent.TaskQueue r6 = r11.cleanupQueue     // Catch:{ all -> 0x0078 }
            r6.cancelAll()     // Catch:{ all -> 0x0078 }
        L_0x0065:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0078 }
            monitor-exit(r11)
            if (r2 != 0) goto L_0x006e
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x006e:
            java.net.Socket r5 = r2.socket()
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r5)
            r5 = 0
            return r5
        L_0x0078:
            r5 = move-exception
            monitor-exit(r11)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnectionPool.cleanup(long):long");
    }

    private final int pruneAndGetAllocationCount(RealConnection connection, long now) {
        List references = connection.getCalls();
        int i = 0;
        while (i < references.size()) {
            Reference reference = references.get(i);
            if (reference.get() != null) {
                i++;
            } else if (reference != null) {
                Platform.Companion.get().logCloseableLeak("A connection to " + connection.route().address().url() + " was leaked. " + "Did you forget to close a response body?", ((RealCall.CallReference) reference).getCallStackTrace());
                references.remove(i);
                connection.setNoNewExchanges(true);
                if (references.isEmpty()) {
                    connection.setIdleAtNs$okhttp(now - this.keepAliveDurationNs);
                    return 0;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type okhttp3.internal.connection.RealCall.CallReference");
            }
        }
        return references.size();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lokhttp3/internal/connection/RealConnectionPool$Companion;", "", "()V", "get", "Lokhttp3/internal/connection/RealConnectionPool;", "connectionPool", "Lokhttp3/ConnectionPool;", "okhttp"}, k = 1, mv = {1, 1, 16})
    /* compiled from: RealConnectionPool.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final RealConnectionPool get(ConnectionPool connectionPool) {
            Intrinsics.checkParameterIsNotNull(connectionPool, "connectionPool");
            return connectionPool.getDelegate$okhttp();
        }
    }
}
