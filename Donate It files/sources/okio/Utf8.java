package okio;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0001H\b\u001a\u0011\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0007H\b\u001a1\u0010\u0010\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\b\u001a1\u0010\u0017\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\b\u001a1\u0010\u0018\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\b\u001a1\u0010\u0019\u001a\u00020\u0016*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00160\u0015H\b\u001a1\u0010\u001a\u001a\u00020\u0016*\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00160\u0015H\b\u001a1\u0010\u001c\u001a\u00020\u0016*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\b\u001a%\u0010\u001d\u001a\u00020\u001e*\u00020\u001b2\b\b\u0002\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u0001H\u0007¢\u0006\u0002\b\u001f\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"HIGH_SURROGATE_HEADER", "", "LOG_SURROGATE_HEADER", "MASK_2BYTES", "MASK_3BYTES", "MASK_4BYTES", "REPLACEMENT_BYTE", "", "REPLACEMENT_CHARACTER", "", "REPLACEMENT_CODE_POINT", "isIsoControl", "", "codePoint", "isUtf8Continuation", "byte", "process2Utf8Bytes", "", "beginIndex", "endIndex", "yield", "Lkotlin/Function1;", "", "process3Utf8Bytes", "process4Utf8Bytes", "processUtf16Chars", "processUtf8Bytes", "", "processUtf8CodePoints", "utf8Size", "", "size", "okio"}, k = 2, mv = {1, 1, 16})
/* compiled from: Utf8.kt */
public final class Utf8 {
    public static final int HIGH_SURROGATE_HEADER = 55232;
    public static final int LOG_SURROGATE_HEADER = 56320;
    public static final int MASK_2BYTES = 3968;
    public static final int MASK_3BYTES = -123008;
    public static final int MASK_4BYTES = 3678080;
    public static final byte REPLACEMENT_BYTE = 63;
    public static final char REPLACEMENT_CHARACTER = '�';
    public static final int REPLACEMENT_CODE_POINT = 65533;

    public static final long size(String str) {
        return size$default(str, 0, 0, 3, (Object) null);
    }

    public static final long size(String str, int i) {
        return size$default(str, i, 0, 2, (Object) null);
    }

    public static /* synthetic */ long size$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return size(str, i, i2);
    }

    public static final long size(String $this$utf8Size, int beginIndex, int endIndex) {
        Intrinsics.checkParameterIsNotNull($this$utf8Size, "$this$utf8Size");
        boolean z = true;
        if (beginIndex >= 0) {
            if (endIndex >= beginIndex) {
                if (endIndex > $this$utf8Size.length()) {
                    z = false;
                }
                if (z) {
                    long result = 0;
                    int i = beginIndex;
                    while (i < endIndex) {
                        int c = $this$utf8Size.charAt(i);
                        if (c < 128) {
                            result++;
                            i++;
                        } else if (c < 2048) {
                            result += (long) 2;
                            i++;
                        } else if (c < 55296 || c > 57343) {
                            result += (long) 3;
                            i++;
                        } else {
                            int low = i + 1 < endIndex ? $this$utf8Size.charAt(i + 1) : 0;
                            if (c > 56319 || low < 56320 || low > 57343) {
                                result++;
                                i++;
                            } else {
                                result += (long) 4;
                                i += 2;
                            }
                        }
                    }
                    return result;
                }
                throw new IllegalArgumentException(("endIndex > string.length: " + endIndex + " > " + $this$utf8Size.length()).toString());
            }
            throw new IllegalArgumentException(("endIndex < beginIndex: " + endIndex + " < " + beginIndex).toString());
        }
        throw new IllegalArgumentException(("beginIndex < 0: " + beginIndex).toString());
    }

    public static final boolean isIsoControl(int codePoint) {
        return (codePoint >= 0 && 31 >= codePoint) || (127 <= codePoint && 159 >= codePoint);
    }

    public static final boolean isUtf8Continuation(byte $this$and$iv) {
        return (192 & $this$and$iv) == 128;
    }

    public static final void processUtf8Bytes(String $this$processUtf8Bytes, int beginIndex, int endIndex, Function1<? super Byte, Unit> yield) {
        char charAt;
        Intrinsics.checkParameterIsNotNull($this$processUtf8Bytes, "$this$processUtf8Bytes");
        Intrinsics.checkParameterIsNotNull(yield, "yield");
        int index = beginIndex;
        while (index < endIndex) {
            char c = $this$processUtf8Bytes.charAt(index);
            if (c < 128) {
                yield.invoke(Byte.valueOf((byte) c));
                index++;
                while (index < endIndex && $this$processUtf8Bytes.charAt(index) < 128) {
                    yield.invoke(Byte.valueOf((byte) $this$processUtf8Bytes.charAt(index)));
                    index++;
                }
            } else if (c < 2048) {
                yield.invoke(Byte.valueOf((byte) ((c >> 6) | 192)));
                yield.invoke(Byte.valueOf((byte) (128 | (c & '?'))));
                index++;
            } else if (55296 > c || 57343 < c) {
                yield.invoke(Byte.valueOf((byte) ((c >> 12) | 224)));
                yield.invoke(Byte.valueOf((byte) (((c >> 6) & 63) | 128)));
                yield.invoke(Byte.valueOf((byte) (128 | (c & '?'))));
                index++;
            } else if (c > 56319 || endIndex <= index + 1 || 56320 > (charAt = $this$processUtf8Bytes.charAt(index + 1)) || 57343 < charAt) {
                yield.invoke(Byte.valueOf(REPLACEMENT_BYTE));
                index++;
            } else {
                int codePoint = ((c << 10) + $this$processUtf8Bytes.charAt(index + 1)) - 56613888;
                yield.invoke(Byte.valueOf((byte) ((codePoint >> 18) | 240)));
                yield.invoke(Byte.valueOf((byte) (((codePoint >> 12) & 63) | 128)));
                yield.invoke(Byte.valueOf((byte) ((63 & (codePoint >> 6)) | 128)));
                yield.invoke(Byte.valueOf((byte) (128 | (codePoint & 63))));
                index += 2;
            }
        }
    }

    public static final void processUtf8CodePoints(byte[] $this$processUtf8CodePoints, int beginIndex, int endIndex, Function1<? super Integer, Unit> yield) {
        byte b1$iv;
        int it;
        int i;
        int it2;
        int i2;
        int it3;
        byte[] bArr = $this$processUtf8CodePoints;
        int i3 = endIndex;
        Function1<? super Integer, Unit> function1 = yield;
        Intrinsics.checkParameterIsNotNull(bArr, "$this$processUtf8CodePoints");
        Intrinsics.checkParameterIsNotNull(function1, "yield");
        int index = beginIndex;
        while (index < i3) {
            byte b0 = bArr[index];
            if (b0 >= 0) {
                function1.invoke(Integer.valueOf(b0));
                index++;
                while (index < i3 && bArr[index] >= 0) {
                    function1.invoke(Integer.valueOf(bArr[index]));
                    index++;
                }
            } else if ((b0 >> 5) == -2) {
                byte[] $this$process2Utf8Bytes$iv = $this$processUtf8CodePoints;
                if (i3 <= index + 1) {
                    function1.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                    i2 = 1;
                } else {
                    byte b0$iv = $this$process2Utf8Bytes$iv[index];
                    byte b1$iv2 = $this$process2Utf8Bytes$iv[index + 1];
                    if (!((b1$iv2 & 192) == 128)) {
                        function1.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                        i2 = 1;
                    } else {
                        int codePoint$iv = (b1$iv2 ^ MASK_2BYTES) ^ (b0$iv << 6);
                        if (codePoint$iv < 128) {
                            it3 = REPLACEMENT_CODE_POINT;
                        } else {
                            it3 = codePoint$iv;
                        }
                        function1.invoke(Integer.valueOf(it3));
                        i2 = 2;
                    }
                }
                index += i2;
            } else if ((b0 >> 4) == -2) {
                byte[] $this$process3Utf8Bytes$iv = $this$processUtf8CodePoints;
                if (i3 <= index + 2) {
                    function1.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                    if (i3 > index + 1) {
                        if ((192 & $this$process3Utf8Bytes$iv[index + 1]) == 128) {
                            i = 2;
                        }
                    }
                    i = 1;
                } else {
                    byte b0$iv2 = $this$process3Utf8Bytes$iv[index];
                    byte b1$iv3 = $this$process3Utf8Bytes$iv[index + 1];
                    if (!((b1$iv3 & 192) == 128)) {
                        function1.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                        i = 1;
                    } else {
                        byte b2$iv = $this$process3Utf8Bytes$iv[index + 2];
                        if (!((b2$iv & 192) == 128)) {
                            function1.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                            i = 2;
                        } else {
                            int codePoint$iv2 = ((-123008 ^ b2$iv) ^ (b1$iv3 << 6)) ^ (b0$iv2 << 12);
                            if (codePoint$iv2 < 2048) {
                                it2 = REPLACEMENT_CODE_POINT;
                            } else if (55296 <= codePoint$iv2 && 57343 >= codePoint$iv2) {
                                it2 = REPLACEMENT_CODE_POINT;
                            } else {
                                it2 = codePoint$iv2;
                            }
                            function1.invoke(Integer.valueOf(it2));
                            i = 3;
                        }
                    }
                }
                index += i;
            } else if ((b0 >> 3) == -2) {
                byte[] $this$process4Utf8Bytes$iv = $this$processUtf8CodePoints;
                if (i3 <= index + 3) {
                    function1.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                    if (i3 > index + 1) {
                        if (((192 & $this$process4Utf8Bytes$iv[index + 1]) == 128 ? (byte) 1 : 0) != 0) {
                            if (i3 > index + 2) {
                                if (((192 & $this$process4Utf8Bytes$iv[index + 2]) == 128 ? (byte) 1 : 0) != 0) {
                                    b1$iv = 3;
                                }
                            }
                            b1$iv = 2;
                        }
                    }
                    b1$iv = 1;
                } else {
                    byte b0$iv3 = $this$process4Utf8Bytes$iv[index];
                    byte b1$iv4 = $this$process4Utf8Bytes$iv[index + 1];
                    if (!((b1$iv4 & 192) == 128)) {
                        function1.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                        b1$iv = 1;
                    } else {
                        byte b2$iv2 = $this$process4Utf8Bytes$iv[index + 2];
                        if (!((b2$iv2 & 192) == 128)) {
                            function1.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                            b1$iv = 2;
                        } else {
                            byte b3$iv = $this$process4Utf8Bytes$iv[index + 3];
                            if (!((b3$iv & 192) == 128)) {
                                function1.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                                b1$iv = 3;
                            } else {
                                int codePoint$iv3 = (((3678080 ^ b3$iv) ^ (b2$iv2 << 6)) ^ (b1$iv4 << 12)) ^ (b0$iv3 << 18);
                                if (codePoint$iv3 > 1114111) {
                                    it = REPLACEMENT_CODE_POINT;
                                } else if (55296 <= codePoint$iv3 && 57343 >= codePoint$iv3) {
                                    it = REPLACEMENT_CODE_POINT;
                                } else if (codePoint$iv3 < 65536) {
                                    it = REPLACEMENT_CODE_POINT;
                                } else {
                                    it = codePoint$iv3;
                                }
                                function1.invoke(Integer.valueOf(it));
                                b1$iv = 4;
                            }
                        }
                    }
                }
                index += b1$iv;
            } else {
                function1.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                index++;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:119:0x029d, code lost:
        if (65533(0xfffd, float:9.1831E-41) != 65533(0xfffd, float:9.1831E-41)) goto L_0x029f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x02b7, code lost:
        r2.invoke(java.lang.Character.valueOf(REPLACEMENT_CHARACTER));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x02cc, code lost:
        if (65533(0xfffd, float:9.1831E-41) != 65533(0xfffd, float:9.1831E-41)) goto L_0x029f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x02d7, code lost:
        if (65533(0xfffd, float:9.1831E-41) != 65533(0xfffd, float:9.1831E-41)) goto L_0x029f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x02dc, code lost:
        if (r12 != 65533) goto L_0x029f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void processUtf16Chars(byte[] r24, int r25, int r26, kotlin.jvm.functions.Function1<? super java.lang.Character, kotlin.Unit> r27) {
        /*
            r0 = r24
            r1 = r26
            r2 = r27
            r3 = 0
            java.lang.String r4 = "$this$processUtf16Chars"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r0, r4)
            java.lang.String r4 = "yield"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r4)
            r4 = r25
        L_0x0013:
            if (r4 >= r1) goto L_0x02f0
            byte r5 = r0[r4]
            if (r5 < 0) goto L_0x0038
            char r6 = (char) r5
            java.lang.Character r6 = java.lang.Character.valueOf(r6)
            r2.invoke(r6)
            int r4 = r4 + 1
        L_0x0024:
            if (r4 >= r1) goto L_0x02ed
            byte r6 = r0[r4]
            if (r6 < 0) goto L_0x02ed
            int r6 = r4 + 1
            byte r4 = r0[r4]
            char r4 = (char) r4
            java.lang.Character r4 = java.lang.Character.valueOf(r4)
            r2.invoke(r4)
            r4 = r6
            goto L_0x0024
        L_0x0038:
            r6 = 5
            r7 = r5
            r8 = 0
            int r6 = r7 >> r6
            r7 = -2
            r9 = 128(0x80, float:1.794E-43)
            if (r6 != r7) goto L_0x009a
            r6 = r24
            r7 = 0
            int r12 = r4 + 1
            if (r1 > r12) goto L_0x0057
            r8 = 65533(0xfffd, float:9.1831E-41)
            r9 = 0
            char r10 = (char) r8
            java.lang.Character r10 = java.lang.Character.valueOf(r10)
            r2.invoke(r10)
            r10 = 1
            goto L_0x0097
        L_0x0057:
            byte r12 = r6[r4]
            int r13 = r4 + 1
            byte r13 = r6[r13]
            r14 = 0
            r15 = 192(0xc0, float:2.69E-43)
            r16 = r13
            r17 = 0
            r15 = r16 & r15
            if (r15 != r9) goto L_0x006a
            r8 = 1
            goto L_0x006b
        L_0x006a:
            r8 = 0
        L_0x006b:
            if (r8 != 0) goto L_0x007b
            r8 = 65533(0xfffd, float:9.1831E-41)
            r9 = 0
            char r10 = (char) r8
            java.lang.Character r10 = java.lang.Character.valueOf(r10)
            r2.invoke(r10)
            r10 = 1
            goto L_0x0097
        L_0x007b:
            r8 = r13 ^ 3968(0xf80, float:5.56E-42)
            int r11 = r12 << 6
            r8 = r8 ^ r11
            if (r8 >= r9) goto L_0x008b
            r9 = 65533(0xfffd, float:9.1831E-41)
            r11 = 0
            goto L_0x008d
        L_0x008b:
            r9 = r8
            r11 = 0
        L_0x008d:
            char r14 = (char) r9
            java.lang.Character r14 = java.lang.Character.valueOf(r14)
            r2.invoke(r14)
            r10 = 2
        L_0x0097:
            int r4 = r4 + r10
            goto L_0x02ed
        L_0x009a:
            r6 = 4
            r12 = r5
            r13 = 0
            int r6 = r12 >> r6
            r12 = 55296(0xd800, float:7.7486E-41)
            r13 = 57343(0xdfff, float:8.0355E-41)
            if (r6 != r7) goto L_0x0151
            r6 = r24
            r7 = 0
            int r15 = r4 + 2
            if (r1 > r15) goto L_0x00d7
            r12 = 65533(0xfffd, float:9.1831E-41)
            r13 = 0
            char r14 = (char) r12
            java.lang.Character r14 = java.lang.Character.valueOf(r14)
            r2.invoke(r14)
            int r12 = r4 + 1
            if (r1 <= r12) goto L_0x00d4
            int r12 = r4 + 1
            byte r12 = r6[r12]
            r13 = 0
            r14 = 192(0xc0, float:2.69E-43)
            r15 = r12
            r16 = 0
            r14 = r14 & r15
            if (r14 != r9) goto L_0x00cd
            r8 = 1
            goto L_0x00ce
        L_0x00cd:
            r8 = 0
        L_0x00ce:
            if (r8 != 0) goto L_0x00d1
            goto L_0x00d4
        L_0x00d1:
            r10 = 2
            goto L_0x014e
        L_0x00d4:
            r10 = 1
            goto L_0x014e
        L_0x00d7:
            byte r15 = r6[r4]
            int r16 = r4 + 1
            byte r16 = r6[r16]
            r17 = 0
            r18 = 192(0xc0, float:2.69E-43)
            r19 = r16
            r20 = 0
            r8 = r19 & r18
            if (r8 != r9) goto L_0x00eb
            r8 = 1
            goto L_0x00ec
        L_0x00eb:
            r8 = 0
        L_0x00ec:
            if (r8 != 0) goto L_0x00fc
            r8 = 65533(0xfffd, float:9.1831E-41)
            r9 = 0
            char r10 = (char) r8
            java.lang.Character r10 = java.lang.Character.valueOf(r10)
            r2.invoke(r10)
            r10 = 1
            goto L_0x014e
        L_0x00fc:
            int r8 = r4 + 2
            byte r8 = r6[r8]
            r17 = 0
            r18 = 192(0xc0, float:2.69E-43)
            r19 = r8
            r20 = 0
            r10 = r19 & r18
            if (r10 != r9) goto L_0x010f
            r21 = 1
            goto L_0x0111
        L_0x010f:
            r21 = 0
        L_0x0111:
            if (r21 != 0) goto L_0x0121
            r9 = 65533(0xfffd, float:9.1831E-41)
            r10 = 0
            char r11 = (char) r9
            java.lang.Character r11 = java.lang.Character.valueOf(r11)
            r2.invoke(r11)
            r10 = 2
            goto L_0x014e
        L_0x0121:
            r9 = -123008(0xfffffffffffe1f80, float:NaN)
            r9 = r9 ^ r8
            int r10 = r16 << 6
            r9 = r9 ^ r10
            int r10 = r15 << 12
            r9 = r9 ^ r10
            r10 = 2048(0x800, float:2.87E-42)
            if (r9 >= r10) goto L_0x013f
            r10 = 65533(0xfffd, float:9.1831E-41)
            r11 = 0
        L_0x0136:
            char r12 = (char) r10
            java.lang.Character r12 = java.lang.Character.valueOf(r12)
            r2.invoke(r12)
            goto L_0x014c
        L_0x013f:
            if (r12 <= r9) goto L_0x0142
            goto L_0x0149
        L_0x0142:
            if (r13 < r9) goto L_0x0149
            r10 = 65533(0xfffd, float:9.1831E-41)
            r11 = 0
            goto L_0x0136
        L_0x0149:
            r10 = r9
            r11 = 0
            goto L_0x0136
        L_0x014c:
            r10 = 3
        L_0x014e:
            int r4 = r4 + r10
            goto L_0x02ed
        L_0x0151:
            r6 = 3
            r8 = r5
            r10 = 0
            int r6 = r8 >> r6
            r8 = 65533(0xfffd, float:9.1831E-41)
            if (r6 != r7) goto L_0x02e4
            r6 = r24
            r7 = 0
            int r10 = r4 + 3
            r15 = 56320(0xdc00, float:7.8921E-41)
            r16 = 55232(0xd7c0, float:7.7397E-41)
            if (r1 > r10) goto L_0x01c4
            r10 = 65533(0xfffd, float:9.1831E-41)
            r12 = 0
            if (r10 == r8) goto L_0x0186
            int r8 = r10 >>> 10
            int r8 = r8 + r16
            char r8 = (char) r8
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            r2.invoke(r8)
            r8 = r10 & 1023(0x3ff, float:1.434E-42)
            int r8 = r8 + r15
            char r8 = (char) r8
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            r2.invoke(r8)
            goto L_0x018d
        L_0x0186:
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            r2.invoke(r8)
        L_0x018d:
            int r8 = r4 + 1
            if (r1 <= r8) goto L_0x01c1
            int r8 = r4 + 1
            byte r8 = r6[r8]
            r10 = 0
            r12 = 192(0xc0, float:2.69E-43)
            r13 = r8
            r15 = 0
            r12 = r12 & r13
            if (r12 != r9) goto L_0x01a1
            r8 = 1
            goto L_0x01a2
        L_0x01a1:
            r8 = 0
        L_0x01a2:
            if (r8 != 0) goto L_0x01a5
            goto L_0x01c1
        L_0x01a5:
            int r8 = r4 + 2
            if (r1 <= r8) goto L_0x01be
            int r8 = r4 + 2
            byte r8 = r6[r8]
            r10 = 0
            r12 = 192(0xc0, float:2.69E-43)
            r13 = r8
            r15 = 0
            r12 = r12 & r13
            if (r12 != r9) goto L_0x01b7
            r8 = 1
            goto L_0x01b8
        L_0x01b7:
            r8 = 0
        L_0x01b8:
            if (r8 != 0) goto L_0x01bb
            goto L_0x01be
        L_0x01bb:
            r10 = 3
            goto L_0x02e2
        L_0x01be:
            r10 = 2
            goto L_0x02e2
        L_0x01c1:
            r10 = 1
            goto L_0x02e2
        L_0x01c4:
            byte r10 = r6[r4]
            int r17 = r4 + 1
            byte r17 = r6[r17]
            r18 = 0
            r19 = 192(0xc0, float:2.69E-43)
            r20 = r17
            r23 = 0
            r11 = r20 & r19
            if (r11 != r9) goto L_0x01d8
            r11 = 1
            goto L_0x01d9
        L_0x01d8:
            r11 = 0
        L_0x01d9:
            if (r11 != 0) goto L_0x0205
            r9 = 65533(0xfffd, float:9.1831E-41)
            r11 = 0
            if (r9 == r8) goto L_0x01f9
            int r8 = r9 >>> 10
            int r8 = r8 + r16
            char r8 = (char) r8
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            r2.invoke(r8)
            r8 = r9 & 1023(0x3ff, float:1.434E-42)
            int r8 = r8 + r15
            char r8 = (char) r8
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            r2.invoke(r8)
            goto L_0x0200
        L_0x01f9:
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            r2.invoke(r8)
        L_0x0200:
            r10 = 1
            goto L_0x02e2
        L_0x0205:
            int r11 = r4 + 2
            byte r11 = r6[r11]
            r18 = 0
            r19 = 192(0xc0, float:2.69E-43)
            r20 = r11
            r23 = 0
            r14 = r20 & r19
            if (r14 != r9) goto L_0x0217
            r14 = 1
            goto L_0x0218
        L_0x0217:
            r14 = 0
        L_0x0218:
            if (r14 != 0) goto L_0x0244
            r9 = 65533(0xfffd, float:9.1831E-41)
            r12 = 0
            if (r9 == r8) goto L_0x0238
            int r8 = r9 >>> 10
            int r8 = r8 + r16
            char r8 = (char) r8
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            r2.invoke(r8)
            r8 = r9 & 1023(0x3ff, float:1.434E-42)
            int r8 = r8 + r15
            char r8 = (char) r8
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            r2.invoke(r8)
            goto L_0x023f
        L_0x0238:
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            r2.invoke(r8)
        L_0x023f:
            r10 = 2
            goto L_0x02e2
        L_0x0244:
            int r14 = r4 + 3
            byte r14 = r6[r14]
            r18 = 0
            r19 = 192(0xc0, float:2.69E-43)
            r20 = r14
            r22 = 0
            r13 = r20 & r19
            if (r13 != r9) goto L_0x0257
            r21 = 1
            goto L_0x0259
        L_0x0257:
            r21 = 0
        L_0x0259:
            if (r21 != 0) goto L_0x0284
            r9 = 65533(0xfffd, float:9.1831E-41)
            r12 = 0
            if (r9 == r8) goto L_0x0279
            int r8 = r9 >>> 10
            int r8 = r8 + r16
            char r8 = (char) r8
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            r2.invoke(r8)
            r8 = r9 & 1023(0x3ff, float:1.434E-42)
            int r8 = r8 + r15
            char r8 = (char) r8
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            r2.invoke(r8)
            goto L_0x0280
        L_0x0279:
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            r2.invoke(r8)
        L_0x0280:
            r10 = 3
            goto L_0x02e2
        L_0x0284:
            r9 = 3678080(0x381f80, float:5.154088E-39)
            r9 = r9 ^ r14
            int r13 = r11 << 6
            r9 = r9 ^ r13
            int r13 = r17 << 12
            r9 = r9 ^ r13
            int r13 = r10 << 18
            r9 = r9 ^ r13
            r13 = 1114111(0x10ffff, float:1.561202E-39)
            if (r9 <= r13) goto L_0x02c0
            r12 = 65533(0xfffd, float:9.1831E-41)
            r13 = 0
            if (r12 == r8) goto L_0x02b7
        L_0x029f:
            int r8 = r12 >>> 10
            int r8 = r8 + r16
            char r8 = (char) r8
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            r2.invoke(r8)
            r8 = r12 & 1023(0x3ff, float:1.434E-42)
            int r8 = r8 + r15
            char r8 = (char) r8
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            r2.invoke(r8)
            goto L_0x02be
        L_0x02b7:
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            r2.invoke(r8)
        L_0x02be:
            goto L_0x02df
        L_0x02c0:
            if (r12 <= r9) goto L_0x02c3
            goto L_0x02cf
        L_0x02c3:
            r12 = 57343(0xdfff, float:8.0355E-41)
            if (r12 < r9) goto L_0x02cf
            r12 = 65533(0xfffd, float:9.1831E-41)
            r13 = 0
            if (r12 == r8) goto L_0x02b7
            goto L_0x029f
        L_0x02cf:
            r12 = 65536(0x10000, float:9.18355E-41)
            if (r9 >= r12) goto L_0x02da
            r12 = 65533(0xfffd, float:9.1831E-41)
            r13 = 0
            if (r12 == r8) goto L_0x02b7
            goto L_0x029f
        L_0x02da:
            r12 = r9
            r13 = 0
            if (r12 == r8) goto L_0x02b7
            goto L_0x029f
        L_0x02df:
            r8 = 4
            r10 = r8
        L_0x02e2:
            int r4 = r4 + r10
            goto L_0x02ed
        L_0x02e4:
            java.lang.Character r6 = java.lang.Character.valueOf(r8)
            r2.invoke(r6)
            int r4 = r4 + 1
        L_0x02ed:
            goto L_0x0013
        L_0x02f0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Utf8.processUtf16Chars(byte[], int, int, kotlin.jvm.functions.Function1):void");
    }

    public static final int process2Utf8Bytes(byte[] $this$process2Utf8Bytes, int beginIndex, int endIndex, Function1<? super Integer, Unit> yield) {
        Intrinsics.checkParameterIsNotNull($this$process2Utf8Bytes, "$this$process2Utf8Bytes");
        Intrinsics.checkParameterIsNotNull(yield, "yield");
        int i = beginIndex + 1;
        Integer valueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (endIndex <= i) {
            yield.invoke(valueOf);
            return 1;
        }
        byte b0 = $this$process2Utf8Bytes[beginIndex];
        byte b1 = $this$process2Utf8Bytes[beginIndex + 1];
        if (!((192 & b1) == 128)) {
            yield.invoke(valueOf);
            return 1;
        }
        int codePoint = (b1 ^ MASK_2BYTES) ^ (b0 << 6);
        if (codePoint < 128) {
            yield.invoke(valueOf);
            return 2;
        }
        yield.invoke(Integer.valueOf(codePoint));
        return 2;
    }

    public static final int process3Utf8Bytes(byte[] $this$process3Utf8Bytes, int beginIndex, int endIndex, Function1<? super Integer, Unit> yield) {
        byte[] bArr = $this$process3Utf8Bytes;
        int i = endIndex;
        Function1<? super Integer, Unit> function1 = yield;
        Intrinsics.checkParameterIsNotNull(bArr, "$this$process3Utf8Bytes");
        Intrinsics.checkParameterIsNotNull(function1, "yield");
        int i2 = beginIndex + 2;
        boolean z = false;
        Integer valueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i <= i2) {
            function1.invoke(valueOf);
            if (i > beginIndex + 1) {
                if ((192 & bArr[beginIndex + 1]) == 128) {
                    z = true;
                }
                return !z ? 1 : 2;
            }
        }
        byte b0 = bArr[beginIndex];
        byte b1 = bArr[beginIndex + 1];
        if (((192 & b1) == 128 ? 1 : 0) == 0) {
            function1.invoke(valueOf);
            return 1;
        }
        byte b2 = bArr[beginIndex + 2];
        if ((192 & b2) == 128) {
            z = true;
        }
        if (!z) {
            function1.invoke(valueOf);
            return 2;
        }
        int codePoint = ((-123008 ^ b2) ^ (b1 << 6)) ^ (b0 << 12);
        if (codePoint < 2048) {
            function1.invoke(valueOf);
            return 3;
        } else if (55296 <= codePoint && 57343 >= codePoint) {
            function1.invoke(valueOf);
            return 3;
        } else {
            function1.invoke(Integer.valueOf(codePoint));
            return 3;
        }
    }

    public static final int process4Utf8Bytes(byte[] $this$process4Utf8Bytes, int beginIndex, int endIndex, Function1<? super Integer, Unit> yield) {
        byte[] bArr = $this$process4Utf8Bytes;
        int i = endIndex;
        Function1<? super Integer, Unit> function1 = yield;
        Intrinsics.checkParameterIsNotNull(bArr, "$this$process4Utf8Bytes");
        Intrinsics.checkParameterIsNotNull(function1, "yield");
        int i2 = beginIndex + 3;
        boolean z = false;
        Integer valueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i <= i2) {
            function1.invoke(valueOf);
            if (i > beginIndex + 1) {
                if (((192 & bArr[beginIndex + 1]) == 128 ? (byte) 1 : 0) != 0) {
                    if (i > beginIndex + 2) {
                        if ((192 & bArr[beginIndex + 2]) == 128) {
                            z = true;
                        }
                        return !z ? 2 : 3;
                    }
                }
            }
            return 1;
        }
        byte b0 = bArr[beginIndex];
        byte b1 = bArr[beginIndex + 1];
        if (((192 & b1) == 128 ? 1 : 0) == 0) {
            function1.invoke(valueOf);
            return 1;
        }
        byte b2 = bArr[beginIndex + 2];
        if (((192 & b2) == 128 ? 1 : 0) == 0) {
            function1.invoke(valueOf);
            return 2;
        }
        byte b3 = bArr[beginIndex + 3];
        if ((192 & b3) == 128) {
            z = true;
        }
        if (!z) {
            function1.invoke(valueOf);
            return 3;
        }
        int codePoint = (((3678080 ^ b3) ^ (b2 << 6)) ^ (b1 << 12)) ^ (b0 << 18);
        if (codePoint > 1114111) {
            function1.invoke(valueOf);
            return 4;
        } else if (55296 <= codePoint && 57343 >= codePoint) {
            function1.invoke(valueOf);
            return 4;
        } else if (codePoint < 65536) {
            function1.invoke(valueOf);
            return 4;
        } else {
            function1.invoke(Integer.valueOf(codePoint));
            return 4;
        }
    }
}
