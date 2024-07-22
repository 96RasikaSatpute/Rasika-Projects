package okhttp3.internal.platform.android;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.tls.CertificateChainCleaner;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lokhttp3/internal/platform/android/AndroidCertificateChainCleaner;", "Lokhttp3/internal/tls/CertificateChainCleaner;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "x509TrustManagerExtensions", "", "checkServerTrusted", "Ljava/lang/reflect/Method;", "(Ljavax/net/ssl/X509TrustManager;Ljava/lang/Object;Ljava/lang/reflect/Method;)V", "clean", "", "Ljava/security/cert/Certificate;", "chain", "hostname", "", "equals", "", "other", "hashCode", "", "Companion", "okhttp"}, k = 1, mv = {1, 1, 16})
/* compiled from: AndroidCertificateChainCleaner.kt */
public final class AndroidCertificateChainCleaner extends CertificateChainCleaner {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Method checkServerTrusted;
    private final X509TrustManager trustManager;
    private final Object x509TrustManagerExtensions;

    public AndroidCertificateChainCleaner(X509TrustManager trustManager2, Object x509TrustManagerExtensions2, Method checkServerTrusted2) {
        Intrinsics.checkParameterIsNotNull(trustManager2, "trustManager");
        Intrinsics.checkParameterIsNotNull(x509TrustManagerExtensions2, "x509TrustManagerExtensions");
        Intrinsics.checkParameterIsNotNull(checkServerTrusted2, "checkServerTrusted");
        this.trustManager = trustManager2;
        this.x509TrustManagerExtensions = x509TrustManagerExtensions2;
        this.checkServerTrusted = checkServerTrusted2;
    }

    public List<Certificate> clean(List<? extends Certificate> chain, String hostname) throws SSLPeerUnverifiedException {
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        Intrinsics.checkParameterIsNotNull(hostname, "hostname");
        try {
            Object array = chain.toArray(new X509Certificate[0]);
            if (array != null) {
                Object invoke = this.checkServerTrusted.invoke(this.x509TrustManagerExtensions, new Object[]{(X509Certificate[]) array, "RSA", hostname});
                if (invoke != null) {
                    return (List) invoke;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<java.security.cert.Certificate>");
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (InvocationTargetException e) {
            Throwable $this$apply = new SSLPeerUnverifiedException(e.getMessage());
            $this$apply.initCause(e);
            throw $this$apply;
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        }
    }

    public boolean equals(Object other) {
        return (other instanceof AndroidCertificateChainCleaner) && ((AndroidCertificateChainCleaner) other).trustManager == this.trustManager;
    }

    public int hashCode() {
        return System.identityHashCode(this.trustManager);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lokhttp3/internal/platform/android/AndroidCertificateChainCleaner$Companion;", "", "()V", "build", "Lokhttp3/internal/platform/android/AndroidCertificateChainCleaner;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "okhttp"}, k = 1, mv = {1, 1, 16})
    /* compiled from: AndroidCertificateChainCleaner.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final AndroidCertificateChainCleaner build(X509TrustManager trustManager) {
            Intrinsics.checkParameterIsNotNull(trustManager, "trustManager");
            try {
                Class extensionsClass = Class.forName("android.net.http.X509TrustManagerExtensions");
                Object extensions = extensionsClass.getConstructor(new Class[]{X509TrustManager.class}).newInstance(new Object[]{trustManager});
                Method checkServerTrusted = extensionsClass.getMethod("checkServerTrusted", new Class[]{X509Certificate[].class, String.class, String.class});
                Intrinsics.checkExpressionValueIsNotNull(extensions, "extensions");
                Intrinsics.checkExpressionValueIsNotNull(checkServerTrusted, "checkServerTrusted");
                return new AndroidCertificateChainCleaner(trustManager, extensions, checkServerTrusted);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
