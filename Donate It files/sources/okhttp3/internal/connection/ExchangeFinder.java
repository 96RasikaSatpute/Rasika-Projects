package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ImagesContract;
import com.miniproject.bhojanamv3.utils.Constants;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ0\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%H\u0002J8\u0010&\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%2\u0006\u0010'\u001a\u00020%H\u0002J\u0006\u0010(\u001a\u00020%J\b\u0010)\u001a\u00020%H\u0002J\u000e\u0010*\u001a\u00020%2\u0006\u0010+\u001a\u00020,J\u000e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lokhttp3/internal/connection/ExchangeFinder;", "", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "address", "Lokhttp3/Address;", "call", "Lokhttp3/internal/connection/RealCall;", "eventListener", "Lokhttp3/EventListener;", "(Lokhttp3/internal/connection/RealConnectionPool;Lokhttp3/Address;Lokhttp3/internal/connection/RealCall;Lokhttp3/EventListener;)V", "getAddress$okhttp", "()Lokhttp3/Address;", "connectingConnection", "Lokhttp3/internal/connection/RealConnection;", "connectionShutdownCount", "", "nextRouteToTry", "Lokhttp3/Route;", "otherFailureCount", "refusedStreamCount", "routeSelection", "Lokhttp3/internal/connection/RouteSelector$Selection;", "routeSelector", "Lokhttp3/internal/connection/RouteSelector;", "find", "Lokhttp3/internal/http/ExchangeCodec;", "client", "Lokhttp3/OkHttpClient;", "chain", "Lokhttp3/internal/http/RealInterceptorChain;", "findConnection", "connectTimeout", "readTimeout", "writeTimeout", "pingIntervalMillis", "connectionRetryEnabled", "", "findHealthyConnection", "doExtensiveHealthChecks", "retryAfterFailure", "retryCurrentRoute", "sameHostAndPort", "url", "Lokhttp3/HttpUrl;", "trackFailure", "", "e", "Ljava/io/IOException;", "okhttp"}, k = 1, mv = {1, 1, 16})
/* compiled from: ExchangeFinder.kt */
public final class ExchangeFinder {
    private final Address address;
    private final RealCall call;
    private RealConnection connectingConnection;
    private final RealConnectionPool connectionPool;
    private int connectionShutdownCount;
    private final EventListener eventListener;
    private Route nextRouteToTry;
    private int otherFailureCount;
    private int refusedStreamCount;
    private RouteSelector.Selection routeSelection;
    private RouteSelector routeSelector;

    public ExchangeFinder(RealConnectionPool connectionPool2, Address address2, RealCall call2, EventListener eventListener2) {
        Intrinsics.checkParameterIsNotNull(connectionPool2, "connectionPool");
        Intrinsics.checkParameterIsNotNull(address2, Constants.ADDRESS);
        Intrinsics.checkParameterIsNotNull(call2, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(eventListener2, "eventListener");
        this.connectionPool = connectionPool2;
        this.address = address2;
        this.call = call2;
        this.eventListener = eventListener2;
    }

    public final Address getAddress$okhttp() {
        return this.address;
    }

    public final ExchangeCodec find(OkHttpClient client, RealInterceptorChain chain) {
        Intrinsics.checkParameterIsNotNull(client, "client");
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        try {
            return findHealthyConnection(chain.getConnectTimeoutMillis$okhttp(), chain.getReadTimeoutMillis$okhttp(), chain.getWriteTimeoutMillis$okhttp(), client.pingIntervalMillis(), client.retryOnConnectionFailure(), !Intrinsics.areEqual((Object) chain.getRequest$okhttp().method(), (Object) "GET")).newCodec$okhttp(client, chain);
        } catch (RouteException e) {
            trackFailure(e.getLastConnectException());
            throw e;
        } catch (IOException e2) {
            trackFailure(e2);
            throw new RouteException(e2);
        }
    }

    private final RealConnection findHealthyConnection(int connectTimeout, int readTimeout, int writeTimeout, int pingIntervalMillis, boolean connectionRetryEnabled, boolean doExtensiveHealthChecks) throws IOException {
        while (true) {
            RealConnection candidate = findConnection(connectTimeout, readTimeout, writeTimeout, pingIntervalMillis, connectionRetryEnabled);
            if (candidate.isHealthy(doExtensiveHealthChecks)) {
                return candidate;
            }
            candidate.noNewExchanges();
            synchronized (this.connectionPool) {
                if (this.nextRouteToTry == null) {
                    RouteSelector.Selection selection = this.routeSelection;
                    boolean routesSelectionLeft = true;
                    if (!(selection != null ? selection.hasNext() : true)) {
                        RouteSelector routeSelector2 = this.routeSelector;
                        if (routeSelector2 != null) {
                            routesSelectionLeft = routeSelector2.hasNext();
                        }
                        if (!routesSelectionLeft) {
                            throw new IOException("exhausted all routes");
                        }
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00d3, code lost:
        if (r8.hasNext() == false) goto L_0x00d5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final okhttp3.internal.connection.RealConnection findConnection(int r21, int r22, int r23, int r24, boolean r25) throws java.io.IOException {
        /*
            r20 = this;
            r1 = r20
            r2 = 0
            r0 = 0
            r3 = r0
            okhttp3.internal.connection.RealConnection r3 = (okhttp3.internal.connection.RealConnection) r3
            r4 = r0
            okhttp3.Route r4 = (okhttp3.Route) r4
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            r6 = 0
            okhttp3.internal.connection.RealConnectionPool r7 = r1.connectionPool
            monitor-enter(r7)
            r8 = 0
            okhttp3.internal.connection.RealCall r9 = r1.call     // Catch:{ all -> 0x0220 }
            boolean r9 = r9.isCanceled()     // Catch:{ all -> 0x0220 }
            if (r9 != 0) goto L_0x0216
            okhttp3.internal.connection.RealCall r9 = r1.call     // Catch:{ all -> 0x0220 }
            okhttp3.internal.connection.RealConnection r9 = r9.getConnection()     // Catch:{ all -> 0x0220 }
            r5.element = r9     // Catch:{ all -> 0x0220 }
            if (r9 == 0) goto L_0x0046
            boolean r10 = r9.getNoNewExchanges()     // Catch:{ all -> 0x0220 }
            if (r10 != 0) goto L_0x003f
            okhttp3.Route r10 = r9.route()     // Catch:{ all -> 0x0220 }
            okhttp3.Address r10 = r10.address()     // Catch:{ all -> 0x0220 }
            okhttp3.HttpUrl r10 = r10.url()     // Catch:{ all -> 0x0220 }
            boolean r10 = r1.sameHostAndPort(r10)     // Catch:{ all -> 0x0220 }
            if (r10 != 0) goto L_0x0046
        L_0x003f:
            okhttp3.internal.connection.RealCall r10 = r1.call     // Catch:{ all -> 0x0220 }
            java.net.Socket r10 = r10.releaseConnectionNoEvents$okhttp()     // Catch:{ all -> 0x0220 }
            goto L_0x0047
        L_0x0046:
            r10 = r0
        L_0x0047:
            r6 = r10
            okhttp3.internal.connection.RealCall r10 = r1.call     // Catch:{ all -> 0x0220 }
            okhttp3.internal.connection.RealConnection r10 = r10.getConnection()     // Catch:{ all -> 0x0220 }
            if (r10 == 0) goto L_0x005c
            okhttp3.internal.connection.RealCall r10 = r1.call     // Catch:{ all -> 0x0220 }
            okhttp3.internal.connection.RealConnection r10 = r10.getConnection()     // Catch:{ all -> 0x0220 }
            r3 = r10
            r10 = r0
            okhttp3.internal.connection.RealConnection r10 = (okhttp3.internal.connection.RealConnection) r10     // Catch:{ all -> 0x0220 }
            r5.element = r10     // Catch:{ all -> 0x0220 }
        L_0x005c:
            r10 = 0
            if (r3 != 0) goto L_0x0084
            r1.refusedStreamCount = r10     // Catch:{ all -> 0x0220 }
            r1.connectionShutdownCount = r10     // Catch:{ all -> 0x0220 }
            r1.otherFailureCount = r10     // Catch:{ all -> 0x0220 }
            okhttp3.internal.connection.RealConnectionPool r11 = r1.connectionPool     // Catch:{ all -> 0x0220 }
            okhttp3.Address r12 = r1.address     // Catch:{ all -> 0x0220 }
            okhttp3.internal.connection.RealCall r13 = r1.call     // Catch:{ all -> 0x0220 }
            boolean r11 = r11.callAcquirePooledConnection(r12, r13, r0, r10)     // Catch:{ all -> 0x0220 }
            if (r11 == 0) goto L_0x007a
            r2 = 1
            okhttp3.internal.connection.RealCall r11 = r1.call     // Catch:{ all -> 0x0220 }
            okhttp3.internal.connection.RealConnection r11 = r11.getConnection()     // Catch:{ all -> 0x0220 }
            r3 = r11
            goto L_0x0084
        L_0x007a:
            okhttp3.Route r11 = r1.nextRouteToTry     // Catch:{ all -> 0x0220 }
            if (r11 == 0) goto L_0x0084
            r4 = r11
            r11 = r0
            okhttp3.Route r11 = (okhttp3.Route) r11     // Catch:{ all -> 0x0220 }
            r1.nextRouteToTry = r11     // Catch:{ all -> 0x0220 }
        L_0x0084:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0220 }
            monitor-exit(r7)
            if (r6 == 0) goto L_0x008e
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r6)
        L_0x008e:
            T r7 = r5.element
            okhttp3.internal.connection.RealConnection r7 = (okhttp3.internal.connection.RealConnection) r7
            if (r7 == 0) goto L_0x00a8
            okhttp3.EventListener r7 = r1.eventListener
            okhttp3.internal.connection.RealCall r8 = r1.call
            okhttp3.Call r8 = (okhttp3.Call) r8
            T r9 = r5.element
            okhttp3.internal.connection.RealConnection r9 = (okhttp3.internal.connection.RealConnection) r9
            if (r9 != 0) goto L_0x00a3
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x00a3:
            okhttp3.Connection r9 = (okhttp3.Connection) r9
            r7.connectionReleased(r8, r9)
        L_0x00a8:
            if (r2 == 0) goto L_0x00bb
            okhttp3.EventListener r7 = r1.eventListener
            okhttp3.internal.connection.RealCall r8 = r1.call
            okhttp3.Call r8 = (okhttp3.Call) r8
            if (r3 != 0) goto L_0x00b5
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x00b5:
            r9 = r3
            okhttp3.Connection r9 = (okhttp3.Connection) r9
            r7.connectionAcquired(r8, r9)
        L_0x00bb:
            if (r3 == 0) goto L_0x00c3
            if (r3 != 0) goto L_0x00c2
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x00c2:
            return r3
        L_0x00c3:
            r7 = 0
            if (r4 != 0) goto L_0x00fa
            okhttp3.internal.connection.RouteSelector$Selection r8 = r1.routeSelection
            if (r8 == 0) goto L_0x00d5
            if (r8 != 0) goto L_0x00cf
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x00cf:
            boolean r8 = r8.hasNext()
            if (r8 != 0) goto L_0x00fa
        L_0x00d5:
            okhttp3.internal.connection.RouteSelector r8 = r1.routeSelector
            if (r8 != 0) goto L_0x00f3
            okhttp3.internal.connection.RouteSelector r9 = new okhttp3.internal.connection.RouteSelector
            okhttp3.Address r11 = r1.address
            okhttp3.internal.connection.RealCall r12 = r1.call
            okhttp3.OkHttpClient r12 = r12.getClient()
            okhttp3.internal.connection.RouteDatabase r12 = r12.getRouteDatabase()
            okhttp3.internal.connection.RealCall r13 = r1.call
            okhttp3.Call r13 = (okhttp3.Call) r13
            okhttp3.EventListener r14 = r1.eventListener
            r9.<init>(r11, r12, r13, r14)
            r8 = r9
            r1.routeSelector = r8
        L_0x00f3:
            r7 = 1
            okhttp3.internal.connection.RouteSelector$Selection r9 = r8.next()
            r1.routeSelection = r9
        L_0x00fa:
            r8 = r0
            java.util.List r8 = (java.util.List) r8
            okhttp3.internal.connection.RealConnectionPool r9 = r1.connectionPool
            monitor-enter(r9)
            r11 = 0
            okhttp3.internal.connection.RealCall r12 = r1.call     // Catch:{ all -> 0x0213 }
            boolean r12 = r12.isCanceled()     // Catch:{ all -> 0x0213 }
            if (r12 != 0) goto L_0x0209
            if (r7 == 0) goto L_0x012b
            okhttp3.internal.connection.RouteSelector$Selection r12 = r1.routeSelection     // Catch:{ all -> 0x0213 }
            if (r12 != 0) goto L_0x0112
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x0213 }
        L_0x0112:
            java.util.List r12 = r12.getRoutes()     // Catch:{ all -> 0x0213 }
            r8 = r12
            okhttp3.internal.connection.RealConnectionPool r12 = r1.connectionPool     // Catch:{ all -> 0x0213 }
            okhttp3.Address r13 = r1.address     // Catch:{ all -> 0x0213 }
            okhttp3.internal.connection.RealCall r14 = r1.call     // Catch:{ all -> 0x0213 }
            boolean r10 = r12.callAcquirePooledConnection(r13, r14, r8, r10)     // Catch:{ all -> 0x0213 }
            if (r10 == 0) goto L_0x012b
            r2 = 1
            okhttp3.internal.connection.RealCall r10 = r1.call     // Catch:{ all -> 0x0213 }
            okhttp3.internal.connection.RealConnection r10 = r10.getConnection()     // Catch:{ all -> 0x0213 }
            r3 = r10
        L_0x012b:
            if (r2 != 0) goto L_0x014a
            if (r4 != 0) goto L_0x013b
            okhttp3.internal.connection.RouteSelector$Selection r10 = r1.routeSelection     // Catch:{ all -> 0x0213 }
            if (r10 != 0) goto L_0x0136
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x0213 }
        L_0x0136:
            okhttp3.Route r10 = r10.next()     // Catch:{ all -> 0x0213 }
            r4 = r10
        L_0x013b:
            okhttp3.internal.connection.RealConnection r10 = new okhttp3.internal.connection.RealConnection     // Catch:{ all -> 0x0213 }
            okhttp3.internal.connection.RealConnectionPool r12 = r1.connectionPool     // Catch:{ all -> 0x0213 }
            if (r4 != 0) goto L_0x0144
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x0213 }
        L_0x0144:
            r10.<init>(r12, r4)     // Catch:{ all -> 0x0213 }
            r3 = r10
            r1.connectingConnection = r3     // Catch:{ all -> 0x0213 }
        L_0x014a:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0213 }
            monitor-exit(r9)
            if (r2 == 0) goto L_0x0166
            okhttp3.EventListener r0 = r1.eventListener
            okhttp3.internal.connection.RealCall r9 = r1.call
            okhttp3.Call r9 = (okhttp3.Call) r9
            if (r3 != 0) goto L_0x015a
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x015a:
            r10 = r3
            okhttp3.Connection r10 = (okhttp3.Connection) r10
            r0.connectionAcquired(r9, r10)
            if (r3 != 0) goto L_0x0165
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0165:
            return r3
        L_0x0166:
            if (r3 != 0) goto L_0x016b
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x016b:
            okhttp3.internal.connection.RealCall r9 = r1.call
            r18 = r9
            okhttp3.Call r18 = (okhttp3.Call) r18
            okhttp3.EventListener r9 = r1.eventListener
            r12 = r3
            r13 = r21
            r14 = r22
            r15 = r23
            r16 = r24
            r17 = r25
            r19 = r9
            r12.connect(r13, r14, r15, r16, r17, r18, r19)
            okhttp3.internal.connection.RealCall r9 = r1.call
            okhttp3.OkHttpClient r9 = r9.getClient()
            okhttp3.internal.connection.RouteDatabase r9 = r9.getRouteDatabase()
            if (r3 != 0) goto L_0x0197
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0197:
            okhttp3.Route r10 = r3.route()
            r9.connected(r10)
            r9 = r0
            java.net.Socket r9 = (java.net.Socket) r9
            okhttp3.internal.connection.RealConnectionPool r10 = r1.connectionPool
            monitor-enter(r10)
            r11 = 0
            okhttp3.internal.connection.RealConnection r0 = (okhttp3.internal.connection.RealConnection) r0     // Catch:{ all -> 0x0206 }
            r1.connectingConnection = r0     // Catch:{ all -> 0x0206 }
            okhttp3.internal.connection.RealConnectionPool r0 = r1.connectionPool     // Catch:{ all -> 0x0206 }
            okhttp3.Address r12 = r1.address     // Catch:{ all -> 0x0206 }
            okhttp3.internal.connection.RealCall r13 = r1.call     // Catch:{ all -> 0x0206 }
            r14 = 1
            boolean r0 = r0.callAcquirePooledConnection(r12, r13, r8, r14)     // Catch:{ all -> 0x0206 }
            if (r0 == 0) goto L_0x01d2
            if (r3 != 0) goto L_0x01bb
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x0206 }
        L_0x01bb:
            r3.setNoNewExchanges(r14)     // Catch:{ all -> 0x0206 }
            if (r3 != 0) goto L_0x01c3
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x0206 }
        L_0x01c3:
            java.net.Socket r0 = r3.socket()     // Catch:{ all -> 0x0206 }
            r9 = r0
            okhttp3.internal.connection.RealCall r0 = r1.call     // Catch:{ all -> 0x0206 }
            okhttp3.internal.connection.RealConnection r0 = r0.getConnection()     // Catch:{ all -> 0x0206 }
            r3 = r0
            r1.nextRouteToTry = r4     // Catch:{ all -> 0x0206 }
            goto L_0x01e6
        L_0x01d2:
            okhttp3.internal.connection.RealConnectionPool r0 = r1.connectionPool     // Catch:{ all -> 0x0206 }
            if (r3 != 0) goto L_0x01d9
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x0206 }
        L_0x01d9:
            r0.put(r3)     // Catch:{ all -> 0x0206 }
            okhttp3.internal.connection.RealCall r0 = r1.call     // Catch:{ all -> 0x0206 }
            if (r3 != 0) goto L_0x01e3
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x0206 }
        L_0x01e3:
            r0.acquireConnectionNoEvents(r3)     // Catch:{ all -> 0x0206 }
        L_0x01e6:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0206 }
            monitor-exit(r10)
            if (r9 == 0) goto L_0x01ef
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r9)
        L_0x01ef:
            okhttp3.EventListener r0 = r1.eventListener
            okhttp3.internal.connection.RealCall r10 = r1.call
            okhttp3.Call r10 = (okhttp3.Call) r10
            if (r3 != 0) goto L_0x01fa
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x01fa:
            r11 = r3
            okhttp3.Connection r11 = (okhttp3.Connection) r11
            r0.connectionAcquired(r10, r11)
            if (r3 != 0) goto L_0x0205
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0205:
            return r3
        L_0x0206:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        L_0x0209:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0213 }
            java.lang.String r10 = "Canceled"
            r0.<init>(r10)     // Catch:{ all -> 0x0213 }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x0213 }
            throw r0     // Catch:{ all -> 0x0213 }
        L_0x0213:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        L_0x0216:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0220 }
            java.lang.String r9 = "Canceled"
            r0.<init>(r9)     // Catch:{ all -> 0x0220 }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x0220 }
            throw r0     // Catch:{ all -> 0x0220 }
        L_0x0220:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.ExchangeFinder.findConnection(int, int, int, int, boolean):okhttp3.internal.connection.RealConnection");
    }

    public final RealConnection connectingConnection() {
        Object $this$assertThreadHoldsLock$iv = this.connectionPool;
        if (!Util.assertionsEnabled || Thread.holdsLock($this$assertThreadHoldsLock$iv)) {
            return this.connectingConnection;
        }
        StringBuilder append = new StringBuilder().append("Thread ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        throw new AssertionError(append.append(currentThread.getName()).append(" MUST hold lock on ").append($this$assertThreadHoldsLock$iv).toString());
    }

    public final void trackFailure(IOException e) {
        Intrinsics.checkParameterIsNotNull(e, "e");
        Object $this$assertThreadDoesntHoldLock$iv = this.connectionPool;
        if (!Util.assertionsEnabled || !Thread.holdsLock($this$assertThreadDoesntHoldLock$iv)) {
            synchronized (this.connectionPool) {
                this.nextRouteToTry = null;
                if ((e instanceof StreamResetException) && ((StreamResetException) e).errorCode == ErrorCode.REFUSED_STREAM) {
                    this.refusedStreamCount++;
                } else if (e instanceof ConnectionShutdownException) {
                    this.connectionShutdownCount++;
                } else {
                    this.otherFailureCount++;
                }
            }
            return;
        }
        StringBuilder append = new StringBuilder().append("Thread ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        throw new AssertionError(append.append(currentThread.getName()).append(" MUST NOT hold lock on ").append($this$assertThreadDoesntHoldLock$iv).toString());
    }

    public final boolean retryAfterFailure() {
        synchronized (this.connectionPool) {
            if (this.refusedStreamCount == 0 && this.connectionShutdownCount == 0 && this.otherFailureCount == 0) {
                return false;
            }
            if (this.nextRouteToTry != null) {
                return true;
            }
            if (retryCurrentRoute()) {
                RealConnection connection = this.call.getConnection();
                if (connection == null) {
                    Intrinsics.throwNpe();
                }
                this.nextRouteToTry = connection.route();
                return true;
            }
            RouteSelector.Selection selection = this.routeSelection;
            if (selection != null && selection.hasNext()) {
                return true;
            }
            RouteSelector localRouteSelector = this.routeSelector;
            if (localRouteSelector == null) {
                return true;
            }
            boolean hasNext = localRouteSelector.hasNext();
            return hasNext;
        }
    }

    private final boolean retryCurrentRoute() {
        RealConnection connection;
        if (this.refusedStreamCount > 1 || this.connectionShutdownCount > 1 || this.otherFailureCount > 0 || (connection = this.call.getConnection()) == null || connection.getRouteFailureCount$okhttp() != 0 || !Util.canReuseConnectionFor(connection.route().address().url(), this.address.url())) {
            return false;
        }
        return true;
    }

    public final boolean sameHostAndPort(HttpUrl url) {
        Intrinsics.checkParameterIsNotNull(url, ImagesContract.URL);
        HttpUrl routeUrl = this.address.url();
        return url.port() == routeUrl.port() && Intrinsics.areEqual((Object) url.host(), (Object) routeUrl.host());
    }
}
