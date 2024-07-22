package okhttp3.internal.ws;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cBE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003JN\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\u000e\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\b\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lokhttp3/internal/ws/WebSocketExtensions;", "", "perMessageDeflate", "", "clientMaxWindowBits", "", "clientNoContextTakeover", "serverMaxWindowBits", "serverNoContextTakeover", "unknownValues", "(ZLjava/lang/Integer;ZLjava/lang/Integer;ZZ)V", "Ljava/lang/Integer;", "component1", "component2", "()Ljava/lang/Integer;", "component3", "component4", "component5", "component6", "copy", "(ZLjava/lang/Integer;ZLjava/lang/Integer;ZZ)Lokhttp3/internal/ws/WebSocketExtensions;", "equals", "other", "hashCode", "noContextTakeover", "clientOriginated", "toString", "", "Companion", "okhttp"}, k = 1, mv = {1, 1, 16})
/* compiled from: WebSocketExtensions.kt */
public final class WebSocketExtensions {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String HEADER_WEB_SOCKET_EXTENSION = "Sec-WebSocket-Extensions";
    public final Integer clientMaxWindowBits;
    public final boolean clientNoContextTakeover;
    public final boolean perMessageDeflate;
    public final Integer serverMaxWindowBits;
    public final boolean serverNoContextTakeover;
    public final boolean unknownValues;

    public WebSocketExtensions() {
        this(false, (Integer) null, false, (Integer) null, false, false, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ WebSocketExtensions copy$default(WebSocketExtensions webSocketExtensions, boolean z, Integer num, boolean z2, Integer num2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            z = webSocketExtensions.perMessageDeflate;
        }
        if ((i & 2) != 0) {
            num = webSocketExtensions.clientMaxWindowBits;
        }
        Integer num3 = num;
        if ((i & 4) != 0) {
            z2 = webSocketExtensions.clientNoContextTakeover;
        }
        boolean z5 = z2;
        if ((i & 8) != 0) {
            num2 = webSocketExtensions.serverMaxWindowBits;
        }
        Integer num4 = num2;
        if ((i & 16) != 0) {
            z3 = webSocketExtensions.serverNoContextTakeover;
        }
        boolean z6 = z3;
        if ((i & 32) != 0) {
            z4 = webSocketExtensions.unknownValues;
        }
        return webSocketExtensions.copy(z, num3, z5, num4, z6, z4);
    }

    public final boolean component1() {
        return this.perMessageDeflate;
    }

    public final Integer component2() {
        return this.clientMaxWindowBits;
    }

    public final boolean component3() {
        return this.clientNoContextTakeover;
    }

    public final Integer component4() {
        return this.serverMaxWindowBits;
    }

    public final boolean component5() {
        return this.serverNoContextTakeover;
    }

    public final boolean component6() {
        return this.unknownValues;
    }

    public final WebSocketExtensions copy(boolean z, Integer num, boolean z2, Integer num2, boolean z3, boolean z4) {
        return new WebSocketExtensions(z, num, z2, num2, z3, z4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebSocketExtensions)) {
            return false;
        }
        WebSocketExtensions webSocketExtensions = (WebSocketExtensions) obj;
        return this.perMessageDeflate == webSocketExtensions.perMessageDeflate && Intrinsics.areEqual((Object) this.clientMaxWindowBits, (Object) webSocketExtensions.clientMaxWindowBits) && this.clientNoContextTakeover == webSocketExtensions.clientNoContextTakeover && Intrinsics.areEqual((Object) this.serverMaxWindowBits, (Object) webSocketExtensions.serverMaxWindowBits) && this.serverNoContextTakeover == webSocketExtensions.serverNoContextTakeover && this.unknownValues == webSocketExtensions.unknownValues;
    }

    public int hashCode() {
        boolean z = this.perMessageDeflate;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        Integer num = this.clientMaxWindowBits;
        int i2 = 0;
        int hashCode = (i + (num != null ? num.hashCode() : 0)) * 31;
        boolean z3 = this.clientNoContextTakeover;
        if (z3) {
            z3 = true;
        }
        int i3 = (hashCode + (z3 ? 1 : 0)) * 31;
        Integer num2 = this.serverMaxWindowBits;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i4 = (i3 + i2) * 31;
        boolean z4 = this.serverNoContextTakeover;
        if (z4) {
            z4 = true;
        }
        int i5 = (i4 + (z4 ? 1 : 0)) * 31;
        boolean z5 = this.unknownValues;
        if (!z5) {
            z2 = z5;
        }
        return i5 + (z2 ? 1 : 0);
    }

    public String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.perMessageDeflate + ", clientMaxWindowBits=" + this.clientMaxWindowBits + ", clientNoContextTakeover=" + this.clientNoContextTakeover + ", serverMaxWindowBits=" + this.serverMaxWindowBits + ", serverNoContextTakeover=" + this.serverNoContextTakeover + ", unknownValues=" + this.unknownValues + ")";
    }

    public WebSocketExtensions(boolean perMessageDeflate2, Integer clientMaxWindowBits2, boolean clientNoContextTakeover2, Integer serverMaxWindowBits2, boolean serverNoContextTakeover2, boolean unknownValues2) {
        this.perMessageDeflate = perMessageDeflate2;
        this.clientMaxWindowBits = clientMaxWindowBits2;
        this.clientNoContextTakeover = clientNoContextTakeover2;
        this.serverMaxWindowBits = serverMaxWindowBits2;
        this.serverNoContextTakeover = serverNoContextTakeover2;
        this.unknownValues = unknownValues2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ WebSocketExtensions(boolean r6, java.lang.Integer r7, boolean r8, java.lang.Integer r9, boolean r10, boolean r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = r0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            r1 = 0
            if (r6 == 0) goto L_0x0012
            r7 = r1
            java.lang.Integer r7 = (java.lang.Integer) r7
            r2 = r7
            goto L_0x0013
        L_0x0012:
            r2 = r7
        L_0x0013:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0019
            r3 = r0
            goto L_0x001a
        L_0x0019:
            r3 = r8
        L_0x001a:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x0023
            r9 = r1
            java.lang.Integer r9 = (java.lang.Integer) r9
            r1 = r9
            goto L_0x0024
        L_0x0023:
            r1 = r9
        L_0x0024:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x002a
            r4 = r0
            goto L_0x002b
        L_0x002a:
            r4 = r10
        L_0x002b:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x0031
            r12 = r0
            goto L_0x0032
        L_0x0031:
            r12 = r11
        L_0x0032:
            r6 = r5
            r7 = r13
            r8 = r2
            r9 = r3
            r10 = r1
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.WebSocketExtensions.<init>(boolean, java.lang.Integer, boolean, java.lang.Integer, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final boolean noContextTakeover(boolean clientOriginated) {
        if (clientOriginated) {
            return this.clientNoContextTakeover;
        }
        return this.serverNoContextTakeover;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lokhttp3/internal/ws/WebSocketExtensions$Companion;", "", "()V", "HEADER_WEB_SOCKET_EXTENSION", "", "parse", "Lokhttp3/internal/ws/WebSocketExtensions;", "responseHeaders", "Lokhttp3/Headers;", "okhttp"}, k = 1, mv = {1, 1, 16})
    /* compiled from: WebSocketExtensions.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        /*  JADX ERROR: NullPointerException in pass: CodeShrinkVisitor
            java.lang.NullPointerException
            */
        public final okhttp3.internal.ws.WebSocketExtensions parse(okhttp3.Headers r24) throws java.io.IOException {
            /*
                r23 = this;
                r0 = r24
                java.lang.String r1 = "responseHeaders"
                kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r0, r1)
                r1 = 0
                r2 = 0
                r3 = r2
                java.lang.Integer r3 = (java.lang.Integer) r3
                r4 = 0
                r5 = r2
                java.lang.Integer r5 = (java.lang.Integer) r5
                r6 = 0
                r7 = 0
                int r8 = r24.size()
                r9 = 0
            L_0x0017:
                if (r9 >= r8) goto L_0x012f
                java.lang.String r10 = r0.name(r9)
                java.lang.String r11 = "Sec-WebSocket-Extensions"
                r12 = 1
                boolean r10 = kotlin.text.StringsKt.equals(r10, r11, r12)
                if (r10 != 0) goto L_0x0028
                goto L_0x0127
            L_0x0028:
                java.lang.String r10 = r0.value(r9)
                r11 = 0
            L_0x002d:
                int r13 = r10.length()
                if (r11 >= r13) goto L_0x0127
                r14 = 44
                r16 = 0
                r17 = 4
                r18 = 0
                r13 = r10
                r15 = r11
                int r13 = okhttp3.internal.Util.delimiterOffset$default((java.lang.String) r13, (char) r14, (int) r15, (int) r16, (int) r17, (java.lang.Object) r18)
                r14 = 59
                int r15 = okhttp3.internal.Util.delimiterOffset((java.lang.String) r10, (char) r14, (int) r11, (int) r13)
                java.lang.String r2 = okhttp3.internal.Util.trimSubstring(r10, r11, r15)
                int r11 = r15 + 1
                java.lang.String r14 = "permessage-deflate"
                boolean r14 = kotlin.text.StringsKt.equals(r2, r14, r12)
                if (r14 == 0) goto L_0x011b
                if (r1 == 0) goto L_0x0059
                r7 = 1
            L_0x0059:
                r1 = 1
            L_0x005a:
                if (r11 >= r13) goto L_0x0110
                r14 = 59
                int r12 = okhttp3.internal.Util.delimiterOffset((java.lang.String) r10, (char) r14, (int) r11, (int) r13)
                r14 = 61
                int r14 = okhttp3.internal.Util.delimiterOffset((java.lang.String) r10, (char) r14, (int) r11, (int) r12)
                java.lang.String r0 = okhttp3.internal.Util.trimSubstring(r10, r11, r14)
                if (r14 >= r12) goto L_0x0083
                r19 = r1
                int r1 = r14 + 1
                java.lang.String r1 = okhttp3.internal.Util.trimSubstring(r10, r1, r12)
                java.lang.String r20 = "\""
                r21 = r2
                r2 = r20
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                java.lang.String r1 = kotlin.text.StringsKt.removeSurrounding((java.lang.String) r1, (java.lang.CharSequence) r2)
                goto L_0x0088
            L_0x0083:
                r19 = r1
                r21 = r2
                r1 = 0
            L_0x0088:
                int r11 = r12 + 1
                java.lang.String r2 = "client_max_window_bits"
                r20 = r7
                r7 = 1
                boolean r2 = kotlin.text.StringsKt.equals(r0, r2, r7)
                if (r2 == 0) goto L_0x00b4
                if (r3 == 0) goto L_0x009b
                r7 = 1
                goto L_0x009d
            L_0x009b:
                r7 = r20
            L_0x009d:
                if (r1 == 0) goto L_0x00a4
                java.lang.Integer r2 = kotlin.text.StringsKt.toIntOrNull(r1)
                goto L_0x00a5
            L_0x00a4:
                r2 = 0
            L_0x00a5:
                if (r2 != 0) goto L_0x00b0
                r3 = 1
                r7 = 1
                r22 = r3
                r3 = r2
                r2 = r22
                goto L_0x0105
            L_0x00b0:
                r3 = r2
                r2 = r7
                r7 = 1
                goto L_0x0105
            L_0x00b4:
                java.lang.String r2 = "client_no_context_takeover"
                r7 = 1
                boolean r2 = kotlin.text.StringsKt.equals(r0, r2, r7)
                if (r2 == 0) goto L_0x00cb
                if (r4 == 0) goto L_0x00c1
                r7 = 1
                goto L_0x00c3
            L_0x00c1:
                r7 = r20
            L_0x00c3:
                if (r1 == 0) goto L_0x00c6
                r7 = 1
            L_0x00c6:
                r2 = 1
                r4 = r2
                r2 = r7
                r7 = 1
                goto L_0x0105
            L_0x00cb:
                java.lang.String r2 = "server_max_window_bits"
                r7 = 1
                boolean r2 = kotlin.text.StringsKt.equals(r0, r2, r7)
                if (r2 == 0) goto L_0x00f0
                if (r5 == 0) goto L_0x00d8
                r7 = 1
                goto L_0x00da
            L_0x00d8:
                r7 = r20
            L_0x00da:
                if (r1 == 0) goto L_0x00e1
                java.lang.Integer r2 = kotlin.text.StringsKt.toIntOrNull(r1)
                goto L_0x00e2
            L_0x00e1:
                r2 = 0
            L_0x00e2:
                if (r2 != 0) goto L_0x00ec
                r5 = 1
                r7 = 1
                r22 = r5
                r5 = r2
                r2 = r22
                goto L_0x0105
            L_0x00ec:
                r5 = r2
                r2 = r7
                r7 = 1
                goto L_0x0105
            L_0x00f0:
                java.lang.String r2 = "server_no_context_takeover"
                r7 = 1
                boolean r2 = kotlin.text.StringsKt.equals(r0, r2, r7)
                if (r2 == 0) goto L_0x0104
                if (r6 == 0) goto L_0x00fd
                r2 = 1
                goto L_0x00ff
            L_0x00fd:
                r2 = r20
            L_0x00ff:
                if (r1 == 0) goto L_0x0102
                r2 = 1
            L_0x0102:
                r6 = 1
                goto L_0x0105
            L_0x0104:
                r2 = 1
            L_0x0105:
                r0 = r24
                r12 = r7
                r1 = r19
                r7 = r2
                r2 = r21
                goto L_0x005a
            L_0x0110:
                r19 = r1
                r21 = r2
                r20 = r7
                r7 = r12
                r0 = r7
                r7 = r20
                goto L_0x0120
            L_0x011b:
                r21 = r2
                r0 = r12
                r2 = 1
                r7 = r2
            L_0x0120:
                r12 = r0
                r2 = 0
                r0 = r24
                goto L_0x002d
            L_0x0127:
                int r9 = r9 + 1
                r0 = r24
                r2 = 0
                goto L_0x0017
            L_0x012f:
                okhttp3.internal.ws.WebSocketExtensions r0 = new okhttp3.internal.ws.WebSocketExtensions
                r10 = r0
                r11 = r1
                r12 = r3
                r13 = r4
                r14 = r5
                r15 = r6
                r16 = r7
                r10.<init>(r11, r12, r13, r14, r15, r16)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.WebSocketExtensions.Companion.parse(okhttp3.Headers):okhttp3.internal.ws.WebSocketExtensions");
        }
    }
}
