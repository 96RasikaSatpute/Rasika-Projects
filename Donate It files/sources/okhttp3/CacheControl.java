package okhttp3;

import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u0000 !2\u00020\u0001:\u0002 !Bq\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\r\u0010\u000f\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0015J\r\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0016J\r\u0010\u000b\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0017J\r\u0010\f\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0018J\r\u0010\n\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0019J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001aJ\r\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001bJ\r\u0010\u000e\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001cJ\r\u0010\r\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001dJ\r\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u001eJ\b\u0010\u001f\u001a\u00020\u0011H\u0016R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u000f\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0013R\u0013\u0010\u0005\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0014R\u0013\u0010\u000b\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0014R\u0013\u0010\f\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0014R\u0013\u0010\n\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0013R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0013R\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0013R\u0013\u0010\u000e\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0013R\u0013\u0010\r\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0013R\u0013\u0010\u0007\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0014¨\u0006\""}, d2 = {"Lokhttp3/CacheControl;", "", "noCache", "", "noStore", "maxAgeSeconds", "", "sMaxAgeSeconds", "isPrivate", "isPublic", "mustRevalidate", "maxStaleSeconds", "minFreshSeconds", "onlyIfCached", "noTransform", "immutable", "headerValue", "", "(ZZIIZZZIIZZZLjava/lang/String;)V", "()Z", "()I", "-deprecated_immutable", "-deprecated_maxAgeSeconds", "-deprecated_maxStaleSeconds", "-deprecated_minFreshSeconds", "-deprecated_mustRevalidate", "-deprecated_noCache", "-deprecated_noStore", "-deprecated_noTransform", "-deprecated_onlyIfCached", "-deprecated_sMaxAgeSeconds", "toString", "Builder", "Companion", "okhttp"}, k = 1, mv = {1, 1, 16})
/* compiled from: CacheControl.kt */
public final class CacheControl {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final CacheControl FORCE_CACHE = new Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS).build();
    public static final CacheControl FORCE_NETWORK = new Builder().noCache().build();
    private String headerValue;
    private final boolean immutable;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;

    @JvmStatic
    public static final CacheControl parse(Headers headers) {
        return Companion.parse(headers);
    }

    private CacheControl(boolean noCache2, boolean noStore2, int maxAgeSeconds2, int sMaxAgeSeconds2, boolean isPrivate2, boolean isPublic2, boolean mustRevalidate2, int maxStaleSeconds2, int minFreshSeconds2, boolean onlyIfCached2, boolean noTransform2, boolean immutable2, String headerValue2) {
        this.noCache = noCache2;
        this.noStore = noStore2;
        this.maxAgeSeconds = maxAgeSeconds2;
        this.sMaxAgeSeconds = sMaxAgeSeconds2;
        this.isPrivate = isPrivate2;
        this.isPublic = isPublic2;
        this.mustRevalidate = mustRevalidate2;
        this.maxStaleSeconds = maxStaleSeconds2;
        this.minFreshSeconds = minFreshSeconds2;
        this.onlyIfCached = onlyIfCached2;
        this.noTransform = noTransform2;
        this.immutable = immutable2;
        this.headerValue = headerValue2;
    }

    public /* synthetic */ CacheControl(boolean noCache2, boolean noStore2, int maxAgeSeconds2, int sMaxAgeSeconds2, boolean isPrivate2, boolean isPublic2, boolean mustRevalidate2, int maxStaleSeconds2, int minFreshSeconds2, boolean onlyIfCached2, boolean noTransform2, boolean immutable2, String headerValue2, DefaultConstructorMarker $constructor_marker) {
        this(noCache2, noStore2, maxAgeSeconds2, sMaxAgeSeconds2, isPrivate2, isPublic2, mustRevalidate2, maxStaleSeconds2, minFreshSeconds2, onlyIfCached2, noTransform2, immutable2, headerValue2);
    }

    public final boolean noCache() {
        return this.noCache;
    }

    public final boolean noStore() {
        return this.noStore;
    }

    public final int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public final int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public final boolean isPrivate() {
        return this.isPrivate;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    public final boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    public final int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    public final int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    public final boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    public final boolean noTransform() {
        return this.noTransform;
    }

    public final boolean immutable() {
        return this.immutable;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "noCache", imports = {}))
    /* renamed from: -deprecated_noCache  reason: not valid java name */
    public final boolean m1027deprecated_noCache() {
        return this.noCache;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "noStore", imports = {}))
    /* renamed from: -deprecated_noStore  reason: not valid java name */
    public final boolean m1028deprecated_noStore() {
        return this.noStore;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "maxAgeSeconds", imports = {}))
    /* renamed from: -deprecated_maxAgeSeconds  reason: not valid java name */
    public final int m1023deprecated_maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sMaxAgeSeconds", imports = {}))
    /* renamed from: -deprecated_sMaxAgeSeconds  reason: not valid java name */
    public final int m1031deprecated_sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "mustRevalidate", imports = {}))
    /* renamed from: -deprecated_mustRevalidate  reason: not valid java name */
    public final boolean m1026deprecated_mustRevalidate() {
        return this.mustRevalidate;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "maxStaleSeconds", imports = {}))
    /* renamed from: -deprecated_maxStaleSeconds  reason: not valid java name */
    public final int m1024deprecated_maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "minFreshSeconds", imports = {}))
    /* renamed from: -deprecated_minFreshSeconds  reason: not valid java name */
    public final int m1025deprecated_minFreshSeconds() {
        return this.minFreshSeconds;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "onlyIfCached", imports = {}))
    /* renamed from: -deprecated_onlyIfCached  reason: not valid java name */
    public final boolean m1030deprecated_onlyIfCached() {
        return this.onlyIfCached;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "noTransform", imports = {}))
    /* renamed from: -deprecated_noTransform  reason: not valid java name */
    public final boolean m1029deprecated_noTransform() {
        return this.noTransform;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "immutable", imports = {}))
    /* renamed from: -deprecated_immutable  reason: not valid java name */
    public final boolean m1022deprecated_immutable() {
        return this.immutable;
    }

    public String toString() {
        String result = this.headerValue;
        if (result != null) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder $this$buildString = sb;
        if (this.noCache) {
            $this$buildString.append("no-cache, ");
        }
        if (this.noStore) {
            $this$buildString.append("no-store, ");
        }
        if (this.maxAgeSeconds != -1) {
            $this$buildString.append("max-age=").append(this.maxAgeSeconds).append(", ");
        }
        if (this.sMaxAgeSeconds != -1) {
            $this$buildString.append("s-maxage=").append(this.sMaxAgeSeconds).append(", ");
        }
        if (this.isPrivate) {
            $this$buildString.append("private, ");
        }
        if (this.isPublic) {
            $this$buildString.append("public, ");
        }
        if (this.mustRevalidate) {
            $this$buildString.append("must-revalidate, ");
        }
        if (this.maxStaleSeconds != -1) {
            $this$buildString.append("max-stale=").append(this.maxStaleSeconds).append(", ");
        }
        if (this.minFreshSeconds != -1) {
            $this$buildString.append("min-fresh=").append(this.minFreshSeconds).append(", ");
        }
        if (this.onlyIfCached) {
            $this$buildString.append("only-if-cached, ");
        }
        if (this.noTransform) {
            $this$buildString.append("no-transform, ");
        }
        if (this.immutable) {
            $this$buildString.append("immutable, ");
        }
        if ($this$buildString.length() == 0) {
            return "";
        }
        $this$buildString.delete($this$buildString.length() - 2, $this$buildString.length());
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
        String result2 = sb2;
        this.headerValue = result2;
        return result2;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u0003\u001a\u00020\u0000J\u0016\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\t\u001a\u00020\u0000J\u0006\u0010\n\u001a\u00020\u0000J\u0006\u0010\u000b\u001a\u00020\u0000J\u0006\u0010\f\u001a\u00020\u0000J\f\u0010\u0014\u001a\u00020\u0006*\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lokhttp3/CacheControl$Builder;", "", "()V", "immutable", "", "maxAgeSeconds", "", "maxStaleSeconds", "minFreshSeconds", "noCache", "noStore", "noTransform", "onlyIfCached", "build", "Lokhttp3/CacheControl;", "maxAge", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "maxStale", "minFresh", "clampToInt", "", "okhttp"}, k = 1, mv = {1, 1, 16})
    /* compiled from: CacheControl.kt */
    public static final class Builder {
        private boolean immutable;
        private int maxAgeSeconds = -1;
        private int maxStaleSeconds = -1;
        private int minFreshSeconds = -1;
        private boolean noCache;
        private boolean noStore;
        private boolean noTransform;
        private boolean onlyIfCached;

        public final Builder noCache() {
            this.noCache = true;
            return this;
        }

        public final Builder noStore() {
            this.noStore = true;
            return this;
        }

        public final Builder maxAge(int maxAge, TimeUnit timeUnit) {
            Intrinsics.checkParameterIsNotNull(timeUnit, "timeUnit");
            Builder $this$apply = this;
            if (maxAge >= 0) {
                $this$apply.maxAgeSeconds = $this$apply.clampToInt(timeUnit.toSeconds((long) maxAge));
                return this;
            }
            throw new IllegalArgumentException(("maxAge < 0: " + maxAge).toString());
        }

        public final Builder maxStale(int maxStale, TimeUnit timeUnit) {
            Intrinsics.checkParameterIsNotNull(timeUnit, "timeUnit");
            Builder $this$apply = this;
            if (maxStale >= 0) {
                $this$apply.maxStaleSeconds = $this$apply.clampToInt(timeUnit.toSeconds((long) maxStale));
                return this;
            }
            throw new IllegalArgumentException(("maxStale < 0: " + maxStale).toString());
        }

        public final Builder minFresh(int minFresh, TimeUnit timeUnit) {
            Intrinsics.checkParameterIsNotNull(timeUnit, "timeUnit");
            Builder $this$apply = this;
            if (minFresh >= 0) {
                $this$apply.minFreshSeconds = $this$apply.clampToInt(timeUnit.toSeconds((long) minFresh));
                return this;
            }
            throw new IllegalArgumentException(("minFresh < 0: " + minFresh).toString());
        }

        public final Builder onlyIfCached() {
            this.onlyIfCached = true;
            return this;
        }

        public final Builder noTransform() {
            this.noTransform = true;
            return this;
        }

        public final Builder immutable() {
            this.immutable = true;
            return this;
        }

        private final int clampToInt(long $this$clampToInt) {
            if ($this$clampToInt > ((long) Integer.MAX_VALUE)) {
                return Integer.MAX_VALUE;
            }
            return (int) $this$clampToInt;
        }

        public final CacheControl build() {
            return new CacheControl(this.noCache, this.noStore, this.maxAgeSeconds, -1, false, false, false, this.maxStaleSeconds, this.minFreshSeconds, this.onlyIfCached, this.noTransform, this.immutable, (String) null, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u001e\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\nH\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lokhttp3/CacheControl$Companion;", "", "()V", "FORCE_CACHE", "Lokhttp3/CacheControl;", "FORCE_NETWORK", "parse", "headers", "Lokhttp3/Headers;", "indexOfElement", "", "", "characters", "startIndex", "okhttp"}, k = 1, mv = {1, 1, 16})
    /* compiled from: CacheControl.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        /* JADX WARNING: Removed duplicated region for block: B:47:0x012a  */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x0138  */
        @kotlin.jvm.JvmStatic
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final okhttp3.CacheControl parse(okhttp3.Headers r36) {
            /*
                r35 = this;
                r0 = r36
                java.lang.String r1 = "headers"
                kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r0, r1)
                r1 = 0
                r2 = 0
                r3 = -1
                r4 = -1
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = -1
                r9 = -1
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 1
                r14 = 0
                r15 = r14
                java.lang.String r15 = (java.lang.String) r15
                int r14 = r36.size()
                r16 = 0
                r34 = r16
                r16 = r12
                r12 = r34
            L_0x0024:
                if (r12 >= r14) goto L_0x0283
                r17 = r14
                java.lang.String r14 = r0.name(r12)
                r32 = r11
                java.lang.String r11 = r0.value(r12)
                java.lang.String r0 = "Cache-Control"
                r33 = r10
                r10 = 1
                boolean r0 = kotlin.text.StringsKt.equals(r14, r0, r10)
                if (r0 == 0) goto L_0x0044
                if (r15 == 0) goto L_0x0042
                r13 = 0
                goto L_0x004d
            L_0x0042:
                r15 = r11
                goto L_0x004d
            L_0x0044:
                java.lang.String r0 = "Pragma"
                boolean r0 = kotlin.text.StringsKt.equals(r14, r0, r10)
                if (r0 == 0) goto L_0x0276
                r13 = 0
            L_0x004d:
                r0 = 0
            L_0x004f:
                int r10 = r11.length()
                if (r0 >= r10) goto L_0x0263
                r10 = r0
                r19 = r1
                r1 = r35
                okhttp3.CacheControl$Companion r1 = (okhttp3.CacheControl.Companion) r1
                r20 = r2
                java.lang.String r2 = "=,;"
                int r0 = r1.indexOfElement(r11, r2, r0)
                java.lang.String r1 = "null cannot be cast to non-null type java.lang.String"
                if (r11 == 0) goto L_0x025d
                java.lang.String r2 = r11.substring(r10, r0)
                r21 = r3
                java.lang.String r3 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
                r22 = r4
                java.lang.String r4 = "null cannot be cast to non-null type kotlin.CharSequence"
                if (r2 == 0) goto L_0x0257
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                java.lang.CharSequence r2 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r2)
                java.lang.String r2 = r2.toString()
                r23 = 0
                r24 = r5
                int r5 = r11.length()
                if (r0 == r5) goto L_0x0113
                char r5 = r11.charAt(r0)
                r25 = r6
                r6 = 44
                if (r5 == r6) goto L_0x0110
                char r5 = r11.charAt(r0)
                r6 = 59
                if (r5 != r6) goto L_0x00a3
                r26 = r7
                goto L_0x0117
            L_0x00a3:
                int r0 = r0 + 1
                int r0 = okhttp3.internal.Util.indexOfNonWhitespace(r11, r0)
                int r5 = r11.length()
                if (r0 >= r5) goto L_0x00e1
                char r5 = r11.charAt(r0)
                r6 = 34
                if (r5 != r6) goto L_0x00e1
                int r0 = r0 + 1
                r4 = r0
                r26 = r11
                java.lang.CharSequence r26 = (java.lang.CharSequence) r26
                r27 = 34
                r29 = 0
                r30 = 4
                r31 = 0
                r28 = r0
                int r0 = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) r26, (char) r27, (int) r28, (boolean) r29, (int) r30, (java.lang.Object) r31)
                if (r11 == 0) goto L_0x00db
                java.lang.String r1 = r11.substring(r4, r0)
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r3)
                int r0 = r0 + 1
                r26 = r7
                goto L_0x011e
            L_0x00db:
                kotlin.TypeCastException r3 = new kotlin.TypeCastException
                r3.<init>(r1)
                throw r3
            L_0x00e1:
                r5 = r0
                r6 = r35
                okhttp3.CacheControl$Companion r6 = (okhttp3.CacheControl.Companion) r6
                r26 = r7
                java.lang.String r7 = ",;"
                int r0 = r6.indexOfElement(r11, r7, r0)
                if (r11 == 0) goto L_0x010a
                java.lang.String r1 = r11.substring(r5, r0)
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r3)
                if (r1 == 0) goto L_0x0104
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                java.lang.CharSequence r1 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r1)
                java.lang.String r1 = r1.toString()
                goto L_0x011e
            L_0x0104:
                kotlin.TypeCastException r1 = new kotlin.TypeCastException
                r1.<init>(r4)
                throw r1
            L_0x010a:
                kotlin.TypeCastException r3 = new kotlin.TypeCastException
                r3.<init>(r1)
                throw r3
            L_0x0110:
                r26 = r7
                goto L_0x0117
            L_0x0113:
                r25 = r6
                r26 = r7
            L_0x0117:
                int r0 = r0 + 1
                r1 = 0
                r3 = r1
                java.lang.String r3 = (java.lang.String) r3
                r1 = r3
            L_0x011e:
                java.lang.String r3 = "no-cache"
                r5 = 1
                boolean r3 = kotlin.text.StringsKt.equals(r3, r2, r5)
                if (r3 == 0) goto L_0x0138
                r3 = 1
                r1 = r3
                r2 = r20
                r3 = r21
                r4 = r22
                r6 = r25
                r7 = r26
                goto L_0x0251
            L_0x0138:
                java.lang.String r3 = "no-store"
                boolean r3 = kotlin.text.StringsKt.equals(r3, r2, r5)
                if (r3 == 0) goto L_0x014e
                r3 = 1
                r2 = r3
                r1 = r19
                r3 = r21
                r4 = r22
                r6 = r25
                r7 = r26
                goto L_0x0251
            L_0x014e:
                java.lang.String r3 = "max-age"
                boolean r3 = kotlin.text.StringsKt.equals(r3, r2, r5)
                r4 = -1
                if (r3 == 0) goto L_0x0167
                int r3 = okhttp3.internal.Util.toNonNegativeInt(r1, r4)
                r1 = r19
                r2 = r20
                r4 = r22
                r6 = r25
                r7 = r26
                goto L_0x0251
            L_0x0167:
                java.lang.String r3 = "s-maxage"
                boolean r3 = kotlin.text.StringsKt.equals(r3, r2, r5)
                if (r3 == 0) goto L_0x0180
                int r3 = okhttp3.internal.Util.toNonNegativeInt(r1, r4)
                r4 = r3
                r1 = r19
                r2 = r20
                r3 = r21
                r6 = r25
                r7 = r26
                goto L_0x0251
            L_0x0180:
                java.lang.String r3 = "private"
                boolean r3 = kotlin.text.StringsKt.equals(r3, r2, r5)
                if (r3 == 0) goto L_0x0199
                r3 = 1
                r24 = r3
                r1 = r19
                r2 = r20
                r3 = r21
                r4 = r22
                r6 = r25
                r7 = r26
                goto L_0x0251
            L_0x0199:
                java.lang.String r3 = "public"
                boolean r3 = kotlin.text.StringsKt.equals(r3, r2, r5)
                if (r3 == 0) goto L_0x01af
                r3 = 1
                r6 = r3
                r1 = r19
                r2 = r20
                r3 = r21
                r4 = r22
                r7 = r26
                goto L_0x0251
            L_0x01af:
                java.lang.String r3 = "must-revalidate"
                boolean r3 = kotlin.text.StringsKt.equals(r3, r2, r5)
                if (r3 == 0) goto L_0x01c5
                r3 = 1
                r7 = r3
                r1 = r19
                r2 = r20
                r3 = r21
                r4 = r22
                r6 = r25
                goto L_0x0251
            L_0x01c5:
                java.lang.String r3 = "max-stale"
                boolean r3 = kotlin.text.StringsKt.equals(r3, r2, r5)
                if (r3 == 0) goto L_0x01e3
                r3 = 2147483647(0x7fffffff, float:NaN)
                int r3 = okhttp3.internal.Util.toNonNegativeInt(r1, r3)
                r8 = r3
                r1 = r19
                r2 = r20
                r3 = r21
                r4 = r22
                r6 = r25
                r7 = r26
                goto L_0x0251
            L_0x01e3:
                java.lang.String r3 = "min-fresh"
                boolean r3 = kotlin.text.StringsKt.equals(r3, r2, r5)
                if (r3 == 0) goto L_0x01fd
                int r3 = okhttp3.internal.Util.toNonNegativeInt(r1, r4)
                r9 = r3
                r1 = r19
                r2 = r20
                r3 = r21
                r4 = r22
                r6 = r25
                r7 = r26
                goto L_0x0251
            L_0x01fd:
                java.lang.String r3 = "only-if-cached"
                boolean r3 = kotlin.text.StringsKt.equals(r3, r2, r5)
                if (r3 == 0) goto L_0x0215
                r3 = 1
                r33 = r3
                r1 = r19
                r2 = r20
                r3 = r21
                r4 = r22
                r6 = r25
                r7 = r26
                goto L_0x0251
            L_0x0215:
                java.lang.String r3 = "no-transform"
                boolean r3 = kotlin.text.StringsKt.equals(r3, r2, r5)
                if (r3 == 0) goto L_0x022d
                r3 = 1
                r32 = r3
                r1 = r19
                r2 = r20
                r3 = r21
                r4 = r22
                r6 = r25
                r7 = r26
                goto L_0x0251
            L_0x022d:
                java.lang.String r3 = "immutable"
                boolean r3 = kotlin.text.StringsKt.equals(r3, r2, r5)
                if (r3 == 0) goto L_0x0245
                r3 = 1
                r16 = r3
                r1 = r19
                r2 = r20
                r3 = r21
                r4 = r22
                r6 = r25
                r7 = r26
                goto L_0x0251
            L_0x0245:
                r1 = r19
                r2 = r20
                r3 = r21
                r4 = r22
                r6 = r25
                r7 = r26
            L_0x0251:
                r10 = r5
                r5 = r24
                goto L_0x004f
            L_0x0257:
                kotlin.TypeCastException r1 = new kotlin.TypeCastException
                r1.<init>(r4)
                throw r1
            L_0x025d:
                kotlin.TypeCastException r2 = new kotlin.TypeCastException
                r2.<init>(r1)
                throw r2
            L_0x0263:
                r19 = r1
                r20 = r2
                r21 = r3
                r22 = r4
                r24 = r5
                r25 = r6
                r26 = r7
                r11 = r32
                r10 = r33
                goto L_0x027a
            L_0x0276:
                r11 = r32
                r10 = r33
            L_0x027a:
                int r12 = r12 + 1
                r0 = r36
                r14 = r17
                goto L_0x0024
            L_0x0283:
                r33 = r10
                r32 = r11
                if (r13 != 0) goto L_0x028d
                r0 = 0
                r15 = r0
                java.lang.String r15 = (java.lang.String) r15
            L_0x028d:
                okhttp3.CacheControl r0 = new okhttp3.CacheControl
                r31 = 0
                r17 = r0
                r18 = r1
                r19 = r2
                r20 = r3
                r21 = r4
                r22 = r5
                r23 = r6
                r24 = r7
                r25 = r8
                r26 = r9
                r27 = r33
                r28 = r32
                r29 = r16
                r30 = r15
                r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.CacheControl.Companion.parse(okhttp3.Headers):okhttp3.CacheControl");
        }

        static /* synthetic */ int indexOfElement$default(Companion companion, String str, String str2, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return companion.indexOfElement(str, str2, i);
        }

        private final int indexOfElement(String $this$indexOfElement, String characters, int startIndex) {
            int length = $this$indexOfElement.length();
            for (int i = startIndex; i < length; i++) {
                if (StringsKt.contains$default((CharSequence) characters, $this$indexOfElement.charAt(i), false, 2, (Object) null)) {
                    return i;
                }
            }
            return $this$indexOfElement.length();
        }
    }
}
