package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.CertificatePinner;
import okhttp3.Dispatcher;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;
import okio.AsyncTimeout;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001)\u0018\u00002\u00020\u0001:\u0002`aB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010,\u001a\u00020-2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010.\u001a\u00020-H\u0002J\b\u0010/\u001a\u00020-H\u0016J\b\u00100\u001a\u00020\u0000H\u0016J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0002J\u0010\u00105\u001a\u00020-2\u0006\u00106\u001a\u000207H\u0016J\u0016\u00108\u001a\u00020-2\u0006\u00109\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u0007J\b\u0010;\u001a\u00020<H\u0016J\u0015\u0010=\u001a\u00020-2\u0006\u0010>\u001a\u00020\u0007H\u0000¢\u0006\u0002\b?J\r\u0010@\u001a\u00020<H\u0000¢\u0006\u0002\bAJ\u0015\u0010B\u001a\u00020\u00192\u0006\u0010C\u001a\u00020DH\u0000¢\u0006\u0002\bEJ\b\u0010F\u001a\u00020\u0007H\u0016J\b\u0010G\u001a\u00020\u0007H\u0016J)\u0010H\u001a\u0002HI\"\n\b\u0000\u0010I*\u0004\u0018\u00010J2\u0006\u0010K\u001a\u0002HI2\u0006\u0010L\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010MJ;\u0010N\u001a\u0002HI\"\n\b\u0000\u0010I*\u0004\u0018\u00010J2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010O\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u00072\u0006\u0010K\u001a\u0002HIH\u0000¢\u0006\u0004\bQ\u0010RJ\u0019\u0010%\u001a\u0004\u0018\u00010J2\b\u0010K\u001a\u0004\u0018\u00010JH\u0000¢\u0006\u0002\bSJ\r\u0010T\u001a\u00020UH\u0000¢\u0006\u0002\bVJ\u000f\u0010W\u001a\u0004\u0018\u00010XH\u0000¢\u0006\u0002\bYJ\b\u00109\u001a\u00020\u0005H\u0016J\u0006\u0010Z\u001a\u00020\u0007J\b\u0010(\u001a\u00020[H\u0016J\u0006\u0010+\u001a\u00020-J!\u0010\\\u001a\u0002HI\"\n\b\u0000\u0010I*\u0004\u0018\u00010J2\u0006\u0010]\u001a\u0002HIH\u0002¢\u0006\u0002\u0010^J\b\u0010_\u001a\u00020UH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u0004\u0018\u00010\u00192\b\u0010!\u001a\u0004\u0018\u00010\u0019@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0010\u0010(\u001a\u00020)X\u0004¢\u0006\u0004\n\u0002\u0010*R\u000e\u0010+\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006b"}, d2 = {"Lokhttp3/internal/connection/RealCall;", "Lokhttp3/Call;", "client", "Lokhttp3/OkHttpClient;", "originalRequest", "Lokhttp3/Request;", "forWebSocket", "", "(Lokhttp3/OkHttpClient;Lokhttp3/Request;Z)V", "callStackTrace", "", "canceled", "getClient", "()Lokhttp3/OkHttpClient;", "connection", "Lokhttp3/internal/connection/RealConnection;", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "setConnection", "(Lokhttp3/internal/connection/RealConnection;)V", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "eventListener", "Lokhttp3/EventListener;", "exchange", "Lokhttp3/internal/connection/Exchange;", "exchangeFinder", "Lokhttp3/internal/connection/ExchangeFinder;", "exchangeRequestDone", "exchangeResponseDone", "executed", "getForWebSocket", "()Z", "<set-?>", "interceptorScopedExchange", "getInterceptorScopedExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "noMoreExchanges", "getOriginalRequest", "()Lokhttp3/Request;", "timeout", "okhttp3/internal/connection/RealCall$timeout$1", "Lokhttp3/internal/connection/RealCall$timeout$1;", "timeoutEarlyExit", "acquireConnectionNoEvents", "", "callStart", "cancel", "clone", "createAddress", "Lokhttp3/Address;", "url", "Lokhttp3/HttpUrl;", "enqueue", "responseCallback", "Lokhttp3/Callback;", "enterNetworkInterceptorExchange", "request", "newExchangeFinder", "execute", "Lokhttp3/Response;", "exitNetworkInterceptorExchange", "closeExchange", "exitNetworkInterceptorExchange$okhttp", "getResponseWithInterceptorChain", "getResponseWithInterceptorChain$okhttp", "initExchange", "chain", "Lokhttp3/internal/http/RealInterceptorChain;", "initExchange$okhttp", "isCanceled", "isExecuted", "maybeReleaseConnection", "E", "Ljava/io/IOException;", "e", "force", "(Ljava/io/IOException;Z)Ljava/io/IOException;", "messageDone", "requestDone", "responseDone", "messageDone$okhttp", "(Lokhttp3/internal/connection/Exchange;ZZLjava/io/IOException;)Ljava/io/IOException;", "noMoreExchanges$okhttp", "redactedUrl", "", "redactedUrl$okhttp", "releaseConnectionNoEvents", "Ljava/net/Socket;", "releaseConnectionNoEvents$okhttp", "retryAfterFailure", "Lokio/AsyncTimeout;", "timeoutExit", "cause", "(Ljava/io/IOException;)Ljava/io/IOException;", "toLoggableString", "AsyncCall", "CallReference", "okhttp"}, k = 1, mv = {1, 1, 16})
/* compiled from: RealCall.kt */
public final class RealCall implements Call {
    private Object callStackTrace;
    private boolean canceled;
    private final OkHttpClient client;
    private RealConnection connection;
    private final RealConnectionPool connectionPool;
    private final EventListener eventListener;
    private Exchange exchange;
    private ExchangeFinder exchangeFinder;
    private boolean exchangeRequestDone;
    private boolean exchangeResponseDone;
    private boolean executed;
    private final boolean forWebSocket;
    private Exchange interceptorScopedExchange;
    private boolean noMoreExchanges;
    private final Request originalRequest;
    /* access modifiers changed from: private */
    public final RealCall$timeout$1 timeout;
    private boolean timeoutEarlyExit;

    public RealCall(OkHttpClient client2, Request originalRequest2, boolean forWebSocket2) {
        Intrinsics.checkParameterIsNotNull(client2, "client");
        Intrinsics.checkParameterIsNotNull(originalRequest2, "originalRequest");
        this.client = client2;
        this.originalRequest = originalRequest2;
        this.forWebSocket = forWebSocket2;
        this.connectionPool = client2.connectionPool().getDelegate$okhttp();
        this.eventListener = client2.eventListenerFactory().create(this);
        RealCall$timeout$1 $this$apply = new RealCall$timeout$1(this);
        $this$apply.timeout((long) client2.callTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.timeout = $this$apply;
    }

    public final OkHttpClient getClient() {
        return this.client;
    }

    public final Request getOriginalRequest() {
        return this.originalRequest;
    }

    public final boolean getForWebSocket() {
        return this.forWebSocket;
    }

    public final RealConnection getConnection() {
        return this.connection;
    }

    public final void setConnection(RealConnection realConnection) {
        this.connection = realConnection;
    }

    public final Exchange getInterceptorScopedExchange$okhttp() {
        return this.interceptorScopedExchange;
    }

    public AsyncTimeout timeout() {
        return this.timeout;
    }

    public RealCall clone() {
        return new RealCall(this.client, this.originalRequest, this.forWebSocket);
    }

    public Request request() {
        return this.originalRequest;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0023, code lost:
        if (r0 == null) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0025, code lost:
        r0.cancel();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0029, code lost:
        if (r1 == null) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002b, code lost:
        r1.cancel();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002e, code lost:
        r5.eventListener.canceled(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0036, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void cancel() {
        /*
            r5 = this;
            r0 = 0
            r1 = 0
            okhttp3.internal.connection.RealConnectionPool r2 = r5.connectionPool
            monitor-enter(r2)
            r3 = 0
            boolean r4 = r5.canceled     // Catch:{ all -> 0x0037 }
            if (r4 == 0) goto L_0x000c
            monitor-exit(r2)
            return
        L_0x000c:
            r4 = 1
            r5.canceled = r4     // Catch:{ all -> 0x0037 }
            okhttp3.internal.connection.Exchange r4 = r5.exchange     // Catch:{ all -> 0x0037 }
            r0 = r4
            okhttp3.internal.connection.ExchangeFinder r4 = r5.exchangeFinder     // Catch:{ all -> 0x0037 }
            if (r4 == 0) goto L_0x001d
            okhttp3.internal.connection.RealConnection r4 = r4.connectingConnection()     // Catch:{ all -> 0x0037 }
            if (r4 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            okhttp3.internal.connection.RealConnection r4 = r5.connection     // Catch:{ all -> 0x0037 }
        L_0x001f:
            r1 = r4
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0037 }
            monitor-exit(r2)
            if (r0 == 0) goto L_0x0029
            r0.cancel()
            goto L_0x002e
        L_0x0029:
            if (r1 == 0) goto L_0x002e
            r1.cancel()
        L_0x002e:
            okhttp3.EventListener r2 = r5.eventListener
            r3 = r5
            okhttp3.Call r3 = (okhttp3.Call) r3
            r2.canceled(r3)
            return
        L_0x0037:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealCall.cancel():void");
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this.connectionPool) {
            z = this.canceled;
        }
        return z;
    }

    public Response execute() {
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
                Unit unit = Unit.INSTANCE;
            } else {
                throw new IllegalStateException("Already Executed".toString());
            }
        }
        this.timeout.enter();
        callStart();
        try {
            this.client.dispatcher().executed$okhttp(this);
            return getResponseWithInterceptorChain$okhttp();
        } finally {
            this.client.dispatcher().finished$okhttp(this);
        }
    }

    public void enqueue(Callback responseCallback) {
        Intrinsics.checkParameterIsNotNull(responseCallback, "responseCallback");
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
                Unit unit = Unit.INSTANCE;
            } else {
                throw new IllegalStateException("Already Executed".toString());
            }
        }
        callStart();
        this.client.dispatcher().enqueue$okhttp(new AsyncCall(this, responseCallback));
    }

    public synchronized boolean isExecuted() {
        return this.executed;
    }

    private final void callStart() {
        this.callStackTrace = Platform.Companion.get().getStackTraceForCloseable("response.body().close()");
        this.eventListener.callStart(this);
    }

    public final Response getResponseWithInterceptorChain$okhttp() throws IOException {
        List interceptors = new ArrayList();
        CollectionsKt.addAll(interceptors, this.client.interceptors());
        interceptors.add(new RetryAndFollowUpInterceptor(this.client));
        interceptors.add(new BridgeInterceptor(this.client.cookieJar()));
        interceptors.add(new CacheInterceptor(this.client.cache()));
        interceptors.add(ConnectInterceptor.INSTANCE);
        if (!this.forWebSocket) {
            CollectionsKt.addAll(interceptors, this.client.networkInterceptors());
        }
        interceptors.add(new CallServerInterceptor(this.forWebSocket));
        try {
            Response response = new RealInterceptorChain(this, interceptors, 0, (Exchange) null, this.originalRequest, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis()).proceed(this.originalRequest);
            if (!isCanceled()) {
                noMoreExchanges$okhttp((IOException) null);
                return response;
            }
            Util.closeQuietly((Closeable) response);
            throw new IOException("Canceled");
        } catch (IOException e) {
            IOException noMoreExchanges$okhttp = noMoreExchanges$okhttp(e);
            throw (noMoreExchanges$okhttp == null ? new TypeCastException("null cannot be cast to non-null type kotlin.Throwable") : noMoreExchanges$okhttp);
        } catch (Throwable th) {
            if (1 == 0) {
                noMoreExchanges$okhttp((IOException) null);
            }
            throw th;
        }
    }

    public final void enterNetworkInterceptorExchange(Request request, boolean newExchangeFinder) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        boolean z = true;
        if (this.interceptorScopedExchange == null) {
            if (this.exchange != null) {
                z = false;
            }
            if (!z) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
            } else if (newExchangeFinder) {
                this.exchangeFinder = new ExchangeFinder(this.connectionPool, createAddress(request.url()), this, this.eventListener);
            }
        } else {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    public final Exchange initExchange$okhttp(RealInterceptorChain chain) {
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        synchronized (this.connectionPool) {
            boolean z = true;
            if (!this.noMoreExchanges) {
                if (this.exchange != null) {
                    z = false;
                }
                if (z) {
                    Unit unit = Unit.INSTANCE;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            } else {
                throw new IllegalStateException("released".toString());
            }
        }
        ExchangeFinder exchangeFinder2 = this.exchangeFinder;
        if (exchangeFinder2 == null) {
            Intrinsics.throwNpe();
        }
        ExchangeCodec codec = exchangeFinder2.find(this.client, chain);
        EventListener eventListener2 = this.eventListener;
        ExchangeFinder exchangeFinder3 = this.exchangeFinder;
        if (exchangeFinder3 == null) {
            Intrinsics.throwNpe();
        }
        Exchange result = new Exchange(this, eventListener2, exchangeFinder3, codec);
        this.interceptorScopedExchange = result;
        synchronized (this.connectionPool) {
            this.exchange = result;
            this.exchangeRequestDone = false;
            this.exchangeResponseDone = false;
        }
        return result;
    }

    public final void acquireConnectionNoEvents(RealConnection connection2) {
        Intrinsics.checkParameterIsNotNull(connection2, "connection");
        Object $this$assertThreadHoldsLock$iv = this.connectionPool;
        if (!Util.assertionsEnabled || Thread.holdsLock($this$assertThreadHoldsLock$iv)) {
            if (this.connection == null) {
                this.connection = connection2;
                connection2.getCalls().add(new CallReference(this, this.callStackTrace));
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        StringBuilder append = new StringBuilder().append("Thread ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        throw new AssertionError(append.append(currentThread.getName()).append(" MUST hold lock on ").append($this$assertThreadHoldsLock$iv).toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0052, code lost:
        if (r1 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return maybeReleaseConnection(r0, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <E extends java.io.IOException> E messageDone$okhttp(okhttp3.internal.connection.Exchange r9, boolean r10, boolean r11, E r12) {
        /*
            r8 = this;
            java.lang.String r0 = "exchange"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r9, r0)
            r0 = r12
            r1 = 0
            okhttp3.internal.connection.RealConnectionPool r2 = r8.connectionPool
            monitor-enter(r2)
            r3 = 0
            okhttp3.internal.connection.Exchange r4 = r8.exchange     // Catch:{ all -> 0x005a }
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r4)     // Catch:{ all -> 0x005a }
            r5 = 1
            r4 = r4 ^ r5
            if (r4 == 0) goto L_0x0018
            monitor-exit(r2)
            return r0
        L_0x0018:
            r4 = 0
            if (r10 == 0) goto L_0x0022
            boolean r6 = r8.exchangeRequestDone     // Catch:{ all -> 0x005a }
            if (r6 != 0) goto L_0x0020
            r4 = 1
        L_0x0020:
            r8.exchangeRequestDone = r5     // Catch:{ all -> 0x005a }
        L_0x0022:
            if (r11 == 0) goto L_0x002b
            boolean r6 = r8.exchangeResponseDone     // Catch:{ all -> 0x005a }
            if (r6 != 0) goto L_0x0029
            r4 = 1
        L_0x0029:
            r8.exchangeResponseDone = r5     // Catch:{ all -> 0x005a }
        L_0x002b:
            boolean r6 = r8.exchangeRequestDone     // Catch:{ all -> 0x005a }
            if (r6 == 0) goto L_0x004e
            boolean r6 = r8.exchangeResponseDone     // Catch:{ all -> 0x005a }
            if (r6 == 0) goto L_0x004e
            if (r4 == 0) goto L_0x004e
            r1 = 1
            okhttp3.internal.connection.Exchange r6 = r8.exchange     // Catch:{ all -> 0x005a }
            if (r6 != 0) goto L_0x003d
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x005a }
        L_0x003d:
            okhttp3.internal.connection.RealConnection r6 = r6.getConnection$okhttp()     // Catch:{ all -> 0x005a }
            int r7 = r6.getSuccessCount$okhttp()     // Catch:{ all -> 0x005a }
            int r7 = r7 + r5
            r6.setSuccessCount$okhttp(r7)     // Catch:{ all -> 0x005a }
            r5 = 0
            okhttp3.internal.connection.Exchange r5 = (okhttp3.internal.connection.Exchange) r5     // Catch:{ all -> 0x005a }
            r8.exchange = r5     // Catch:{ all -> 0x005a }
        L_0x004e:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x005a }
            monitor-exit(r2)
            if (r1 == 0) goto L_0x0059
            r2 = 0
            java.io.IOException r0 = r8.maybeReleaseConnection(r0, r2)
        L_0x0059:
            return r0
        L_0x005a:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealCall.messageDone$okhttp(okhttp3.internal.connection.Exchange, boolean, boolean, java.io.IOException):java.io.IOException");
    }

    public final IOException noMoreExchanges$okhttp(IOException e) {
        synchronized (this.connectionPool) {
            this.noMoreExchanges = true;
            Unit unit = Unit.INSTANCE;
        }
        return maybeReleaseConnection(e, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x001d A[Catch:{ all -> 0x0017 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0090  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <E extends java.io.IOException> E maybeReleaseConnection(E r11, boolean r12) {
        /*
            r10 = this;
            r0 = r11
            r1 = 0
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            r3 = 0
            okhttp3.internal.connection.RealConnectionPool r4 = r10.connectionPool
            monitor-enter(r4)
            r5 = 0
            r6 = 0
            r7 = 1
            if (r12 == 0) goto L_0x001a
            okhttp3.internal.connection.Exchange r8 = r10.exchange     // Catch:{ all -> 0x0017 }
            if (r8 != 0) goto L_0x0015
            goto L_0x001a
        L_0x0015:
            r8 = r6
            goto L_0x001b
        L_0x0017:
            r5 = move-exception
            goto L_0x009f
        L_0x001a:
            r8 = r7
        L_0x001b:
            if (r8 == 0) goto L_0x0090
            okhttp3.internal.connection.RealConnection r8 = r10.connection     // Catch:{ all -> 0x0017 }
            okhttp3.Connection r8 = (okhttp3.Connection) r8     // Catch:{ all -> 0x0017 }
            r2.element = r8     // Catch:{ all -> 0x0017 }
            okhttp3.internal.connection.RealConnection r8 = r10.connection     // Catch:{ all -> 0x0017 }
            r9 = 0
            if (r8 == 0) goto L_0x0037
            okhttp3.internal.connection.Exchange r8 = r10.exchange     // Catch:{ all -> 0x0017 }
            if (r8 != 0) goto L_0x0037
            if (r12 != 0) goto L_0x0032
            boolean r8 = r10.noMoreExchanges     // Catch:{ all -> 0x0017 }
            if (r8 == 0) goto L_0x0037
        L_0x0032:
            java.net.Socket r8 = r10.releaseConnectionNoEvents$okhttp()     // Catch:{ all -> 0x0017 }
            goto L_0x0038
        L_0x0037:
            r8 = r9
        L_0x0038:
            r1 = r8
            okhttp3.internal.connection.RealConnection r8 = r10.connection     // Catch:{ all -> 0x0017 }
            if (r8 == 0) goto L_0x0041
            okhttp3.Connection r9 = (okhttp3.Connection) r9     // Catch:{ all -> 0x0017 }
            r2.element = r9     // Catch:{ all -> 0x0017 }
        L_0x0041:
            boolean r8 = r10.noMoreExchanges     // Catch:{ all -> 0x0017 }
            if (r8 == 0) goto L_0x004b
            okhttp3.internal.connection.Exchange r8 = r10.exchange     // Catch:{ all -> 0x0017 }
            if (r8 != 0) goto L_0x004b
            r8 = r7
            goto L_0x004c
        L_0x004b:
            r8 = r6
        L_0x004c:
            r3 = r8
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0017 }
            monitor-exit(r4)
            if (r1 == 0) goto L_0x0055
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r1)
        L_0x0055:
            T r4 = r2.element
            okhttp3.Connection r4 = (okhttp3.Connection) r4
            if (r4 == 0) goto L_0x006c
            okhttp3.EventListener r4 = r10.eventListener
            r5 = r10
            okhttp3.Call r5 = (okhttp3.Call) r5
            T r8 = r2.element
            okhttp3.Connection r8 = (okhttp3.Connection) r8
            if (r8 != 0) goto L_0x0069
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0069:
            r4.connectionReleased(r5, r8)
        L_0x006c:
            if (r3 == 0) goto L_0x008e
            if (r0 == 0) goto L_0x0071
            r6 = r7
        L_0x0071:
            r4 = r6
            java.io.IOException r0 = r10.timeoutExit(r0)
            if (r4 == 0) goto L_0x0086
            okhttp3.EventListener r5 = r10.eventListener
            r6 = r10
            okhttp3.Call r6 = (okhttp3.Call) r6
            if (r0 != 0) goto L_0x0082
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0082:
            r5.callFailed(r6, r0)
            goto L_0x008e
        L_0x0086:
            okhttp3.EventListener r5 = r10.eventListener
            r6 = r10
            okhttp3.Call r6 = (okhttp3.Call) r6
            r5.callEnd(r6)
        L_0x008e:
            return r0
        L_0x0090:
            r6 = 0
            java.lang.String r7 = "cannot release connection while it is in use"
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0017 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0017 }
            r6.<init>(r7)     // Catch:{ all -> 0x0017 }
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x0017 }
            throw r6     // Catch:{ all -> 0x0017 }
        L_0x009f:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealCall.maybeReleaseConnection(java.io.IOException, boolean):java.io.IOException");
    }

    public final Socket releaseConnectionNoEvents$okhttp() {
        Object $this$assertThreadHoldsLock$iv = this.connectionPool;
        if (!Util.assertionsEnabled || Thread.holdsLock($this$assertThreadHoldsLock$iv)) {
            RealConnection realConnection = this.connection;
            if (realConnection == null) {
                Intrinsics.throwNpe();
            }
            int index$iv = 0;
            Iterator<Reference<RealCall>> it = realConnection.getCalls().iterator();
            while (true) {
                if (!it.hasNext()) {
                    index$iv = -1;
                    break;
                } else if (Intrinsics.areEqual((Object) (RealCall) it.next().get(), (Object) this)) {
                    break;
                } else {
                    index$iv++;
                }
            }
            int index = index$iv;
            if (index != -1) {
                RealConnection released = this.connection;
                if (released == null) {
                    Intrinsics.throwNpe();
                }
                released.getCalls().remove(index);
                this.connection = null;
                if (released.getCalls().isEmpty()) {
                    released.setIdleAtNs$okhttp(System.nanoTime());
                    if (this.connectionPool.connectionBecameIdle(released)) {
                        return released.socket();
                    }
                }
                return null;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        StringBuilder append = new StringBuilder().append("Thread ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        throw new AssertionError(append.append(currentThread.getName()).append(" MUST hold lock on ").append($this$assertThreadHoldsLock$iv).toString());
    }

    private final <E extends IOException> E timeoutExit(E cause) {
        if (this.timeoutEarlyExit || !this.timeout.exit()) {
            return cause;
        }
        E interruptedIOException = new InterruptedIOException("timeout");
        if (cause != null) {
            interruptedIOException.initCause((Throwable) cause);
        }
        return (IOException) interruptedIOException;
    }

    public final void timeoutEarlyExit() {
        if (!this.timeoutEarlyExit) {
            this.timeoutEarlyExit = true;
            this.timeout.exit();
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final void exitNetworkInterceptorExchange$okhttp(boolean closeExchange) {
        boolean z = true;
        if (!this.noMoreExchanges) {
            if (closeExchange) {
                Exchange exchange2 = this.exchange;
                if (exchange2 != null) {
                    exchange2.detachWithViolence();
                }
                if (this.exchange != null) {
                    z = false;
                }
                if (!z) {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
            this.interceptorScopedExchange = null;
            return;
        }
        throw new IllegalStateException("released".toString());
    }

    private final Address createAddress(HttpUrl url) {
        SSLSocketFactory sslSocketFactory = null;
        HostnameVerifier hostnameVerifier = null;
        CertificatePinner certificatePinner = null;
        if (url.isHttps()) {
            sslSocketFactory = this.client.sslSocketFactory();
            hostnameVerifier = this.client.hostnameVerifier();
            certificatePinner = this.client.certificatePinner();
        }
        return new Address(url.host(), url.port(), this.client.dns(), this.client.socketFactory(), sslSocketFactory, hostnameVerifier, certificatePinner, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
    }

    public final boolean retryAfterFailure() {
        ExchangeFinder exchangeFinder2 = this.exchangeFinder;
        if (exchangeFinder2 == null) {
            Intrinsics.throwNpe();
        }
        return exchangeFinder2.retryAfterFailure();
    }

    /* access modifiers changed from: private */
    public final String toLoggableString() {
        return (isCanceled() ? "canceled " : "") + (this.forWebSocket ? "web socket" : NotificationCompat.CATEGORY_CALL) + " to " + redactedUrl$okhttp();
    }

    public final String redactedUrl$okhttp() {
        return this.originalRequest.url().redact();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0012\u0010\u001a\u001a\u00020\u00172\n\u0010\u001b\u001a\u00060\u0000R\u00020\u0006J\b\u0010\u001c\u001a\u00020\u0017H\u0016R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lokhttp3/internal/connection/RealCall$AsyncCall;", "Ljava/lang/Runnable;", "responseCallback", "Lokhttp3/Callback;", "(Lokhttp3/internal/connection/RealCall;Lokhttp3/Callback;)V", "call", "Lokhttp3/internal/connection/RealCall;", "getCall", "()Lokhttp3/internal/connection/RealCall;", "<set-?>", "Ljava/util/concurrent/atomic/AtomicInteger;", "callsPerHost", "getCallsPerHost", "()Ljava/util/concurrent/atomic/AtomicInteger;", "host", "", "getHost", "()Ljava/lang/String;", "request", "Lokhttp3/Request;", "getRequest", "()Lokhttp3/Request;", "executeOn", "", "executorService", "Ljava/util/concurrent/ExecutorService;", "reuseCallsPerHostFrom", "other", "run", "okhttp"}, k = 1, mv = {1, 1, 16})
    /* compiled from: RealCall.kt */
    public final class AsyncCall implements Runnable {
        private volatile AtomicInteger callsPerHost = new AtomicInteger(0);
        private final Callback responseCallback;
        final /* synthetic */ RealCall this$0;

        public AsyncCall(RealCall $outer, Callback responseCallback2) {
            Intrinsics.checkParameterIsNotNull(responseCallback2, "responseCallback");
            this.this$0 = $outer;
            this.responseCallback = responseCallback2;
        }

        public final AtomicInteger getCallsPerHost() {
            return this.callsPerHost;
        }

        public final void reuseCallsPerHostFrom(AsyncCall other) {
            Intrinsics.checkParameterIsNotNull(other, "other");
            this.callsPerHost = other.callsPerHost;
        }

        public final String getHost() {
            return this.this$0.getOriginalRequest().url().host();
        }

        public final Request getRequest() {
            return this.this$0.getOriginalRequest();
        }

        public final RealCall getCall() {
            return this.this$0;
        }

        public final void executeOn(ExecutorService executorService) {
            Intrinsics.checkParameterIsNotNull(executorService, "executorService");
            Object $this$assertThreadDoesntHoldLock$iv = this.this$0.getClient().dispatcher();
            if (!Util.assertionsEnabled || !Thread.holdsLock($this$assertThreadDoesntHoldLock$iv)) {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e) {
                    InterruptedIOException ioException = new InterruptedIOException("executor rejected");
                    ioException.initCause(e);
                    this.this$0.noMoreExchanges$okhttp(ioException);
                    this.responseCallback.onFailure(this.this$0, ioException);
                    this.this$0.getClient().dispatcher().finished$okhttp(this);
                } catch (Throwable th) {
                    this.this$0.getClient().dispatcher().finished$okhttp(this);
                    throw th;
                }
            } else {
                StringBuilder append = new StringBuilder().append("Thread ");
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
                throw new AssertionError(append.append(currentThread.getName()).append(" MUST NOT hold lock on ").append($this$assertThreadDoesntHoldLock$iv).toString());
            }
        }

        public void run() {
            Dispatcher dispatcher;
            Thread currentThread$iv = Thread.currentThread();
            Intrinsics.checkExpressionValueIsNotNull(currentThread$iv, "currentThread");
            String oldName$iv = currentThread$iv.getName();
            currentThread$iv.setName("OkHttp " + this.this$0.redactedUrl$okhttp());
            boolean signalledCallback = false;
            try {
                this.this$0.timeout.enter();
                signalledCallback = true;
                this.responseCallback.onResponse(this.this$0, this.this$0.getResponseWithInterceptorChain$okhttp());
                dispatcher = this.this$0.getClient().dispatcher();
            } catch (IOException e) {
                if (signalledCallback) {
                    Platform.Companion.get().log("Callback failure for " + this.this$0.toLoggableString(), 4, e);
                } else {
                    this.responseCallback.onFailure(this.this$0, e);
                }
                dispatcher = this.this$0.getClient().dispatcher();
            } catch (Throwable th) {
                currentThread$iv.setName(oldName$iv);
                throw th;
            }
            dispatcher.finished$okhttp(this);
            currentThread$iv.setName(oldName$iv);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lokhttp3/internal/connection/RealCall$CallReference;", "Ljava/lang/ref/WeakReference;", "Lokhttp3/internal/connection/RealCall;", "referent", "callStackTrace", "", "(Lokhttp3/internal/connection/RealCall;Ljava/lang/Object;)V", "getCallStackTrace", "()Ljava/lang/Object;", "okhttp"}, k = 1, mv = {1, 1, 16})
    /* compiled from: RealCall.kt */
    public static final class CallReference extends WeakReference<RealCall> {
        private final Object callStackTrace;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CallReference(RealCall referent, Object callStackTrace2) {
            super(referent);
            Intrinsics.checkParameterIsNotNull(referent, "referent");
            this.callStackTrace = callStackTrace2;
        }

        public final Object getCallStackTrace() {
            return this.callStackTrace;
        }
    }
}
