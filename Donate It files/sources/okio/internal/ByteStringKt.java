package okio.internal;

import com.google.firebase.messaging.Constants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Base64;
import okio.Buffer;
import okio.ByteString;
import okio.Platform;
import okio.Util;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0002\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\b\u001a\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a\r\u0010\u000f\u001a\u00020\u0010*\u00020\nH\b\u001a\r\u0010\u0011\u001a\u00020\u0010*\u00020\nH\b\u001a\u0015\u0010\u0012\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\b\u001a\u000f\u0010\u0014\u001a\u0004\u0018\u00010\n*\u00020\u0010H\b\u001a\r\u0010\u0015\u001a\u00020\n*\u00020\u0010H\b\u001a\r\u0010\u0016\u001a\u00020\n*\u00020\u0010H\b\u001a\u0015\u0010\u0017\u001a\u00020\u0018*\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0007H\b\u001a\u0015\u0010\u0017\u001a\u00020\u0018*\u00020\n2\u0006\u0010\u0019\u001a\u00020\nH\b\u001a\u0017\u0010\u001a\u001a\u00020\u0018*\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u001bH\b\u001a\u0015\u0010\u001c\u001a\u00020\u001d*\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0005H\b\u001a\r\u0010\u001f\u001a\u00020\u0005*\u00020\nH\b\u001a\r\u0010 \u001a\u00020\u0005*\u00020\nH\b\u001a\r\u0010!\u001a\u00020\u0010*\u00020\nH\b\u001a\u001d\u0010\"\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0005H\b\u001a\r\u0010$\u001a\u00020\u0007*\u00020\nH\b\u001a\u001d\u0010%\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0005H\b\u001a\u001d\u0010%\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0005H\b\u001a-\u0010&\u001a\u00020\u0018*\u00020\n2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\b\u001a-\u0010&\u001a\u00020\u0018*\u00020\n2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\b\u001a\u0015\u0010*\u001a\u00020\u0018*\u00020\n2\u0006\u0010+\u001a\u00020\u0007H\b\u001a\u0015\u0010*\u001a\u00020\u0018*\u00020\n2\u0006\u0010+\u001a\u00020\nH\b\u001a\u001d\u0010,\u001a\u00020\n*\u00020\n2\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0005H\b\u001a\r\u0010/\u001a\u00020\n*\u00020\nH\b\u001a\r\u00100\u001a\u00020\n*\u00020\nH\b\u001a\r\u00101\u001a\u00020\u0007*\u00020\nH\b\u001a\u001d\u00102\u001a\u00020\n*\u00020\u00072\u0006\u0010'\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\b\u001a\r\u00103\u001a\u00020\u0010*\u00020\nH\b\u001a\r\u00104\u001a\u00020\u0010*\u00020\nH\b\u001a$\u00105\u001a\u000206*\u00020\n2\u0006\u00107\u001a\u0002082\u0006\u0010'\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u00069"}, d2 = {"HEX_DIGIT_CHARS", "", "getHEX_DIGIT_CHARS", "()[C", "codePointIndexToCharIndex", "", "s", "", "codePointCount", "commonOf", "Lokio/ByteString;", "data", "decodeHexDigit", "c", "", "commonBase64", "", "commonBase64Url", "commonCompareTo", "other", "commonDecodeBase64", "commonDecodeHex", "commonEncodeUtf8", "commonEndsWith", "", "suffix", "commonEquals", "", "commonGetByte", "", "pos", "commonGetSize", "commonHashCode", "commonHex", "commonIndexOf", "fromIndex", "commonInternalArray", "commonLastIndexOf", "commonRangeEquals", "offset", "otherOffset", "byteCount", "commonStartsWith", "prefix", "commonSubstring", "beginIndex", "endIndex", "commonToAsciiLowercase", "commonToAsciiUppercase", "commonToByteArray", "commonToByteString", "commonToString", "commonUtf8", "commonWrite", "", "buffer", "Lokio/Buffer;", "okio"}, k = 2, mv = {1, 1, 16})
/* compiled from: ByteString.kt */
public final class ByteStringKt {
    private static final char[] HEX_DIGIT_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static final String commonUtf8(ByteString $this$commonUtf8) {
        Intrinsics.checkParameterIsNotNull($this$commonUtf8, "$this$commonUtf8");
        String result = $this$commonUtf8.getUtf8$okio();
        if (result != null) {
            return result;
        }
        String result2 = Platform.toUtf8String($this$commonUtf8.internalArray$okio());
        $this$commonUtf8.setUtf8$okio(result2);
        return result2;
    }

    public static final String commonBase64(ByteString $this$commonBase64) {
        Intrinsics.checkParameterIsNotNull($this$commonBase64, "$this$commonBase64");
        return Base64.encodeBase64$default($this$commonBase64.getData$okio(), (byte[]) null, 1, (Object) null);
    }

    public static final String commonBase64Url(ByteString $this$commonBase64Url) {
        Intrinsics.checkParameterIsNotNull($this$commonBase64Url, "$this$commonBase64Url");
        return Base64.encodeBase64($this$commonBase64Url.getData$okio(), Base64.getBASE64_URL_SAFE());
    }

    public static final char[] getHEX_DIGIT_CHARS() {
        return HEX_DIGIT_CHARS;
    }

    public static final String commonHex(ByteString $this$commonHex) {
        Intrinsics.checkParameterIsNotNull($this$commonHex, "$this$commonHex");
        char[] result = new char[($this$commonHex.getData$okio().length * 2)];
        int c = 0;
        for (int $this$and$iv : $this$commonHex.getData$okio()) {
            int c2 = c + 1;
            result[c] = getHEX_DIGIT_CHARS()[($this$and$iv >> 4) & 15];
            c = c2 + 1;
            result[c2] = getHEX_DIGIT_CHARS()[15 & $this$and$iv];
        }
        return new String(result);
    }

    public static final ByteString commonToAsciiLowercase(ByteString $this$commonToAsciiLowercase) {
        byte b;
        Intrinsics.checkParameterIsNotNull($this$commonToAsciiLowercase, "$this$commonToAsciiLowercase");
        int i = 0;
        while (i < $this$commonToAsciiLowercase.getData$okio().length) {
            byte c = $this$commonToAsciiLowercase.getData$okio()[i];
            byte b2 = (byte) 65;
            if (c < b2 || c > (b = (byte) 90)) {
                i++;
            } else {
                byte[] data$okio = $this$commonToAsciiLowercase.getData$okio();
                byte[] lowercase = Arrays.copyOf(data$okio, data$okio.length);
                Intrinsics.checkExpressionValueIsNotNull(lowercase, "java.util.Arrays.copyOf(this, size)");
                int i2 = i + 1;
                lowercase[i] = (byte) (c + 32);
                while (i2 < lowercase.length) {
                    byte c2 = lowercase[i2];
                    if (c2 < b2 || c2 > b) {
                        i2++;
                    } else {
                        lowercase[i2] = (byte) (c2 + 32);
                        i2++;
                    }
                }
                return new ByteString(lowercase);
            }
        }
        return $this$commonToAsciiLowercase;
    }

    public static final ByteString commonToAsciiUppercase(ByteString $this$commonToAsciiUppercase) {
        byte b;
        Intrinsics.checkParameterIsNotNull($this$commonToAsciiUppercase, "$this$commonToAsciiUppercase");
        int i = 0;
        while (i < $this$commonToAsciiUppercase.getData$okio().length) {
            byte c = $this$commonToAsciiUppercase.getData$okio()[i];
            byte b2 = (byte) 97;
            if (c < b2 || c > (b = (byte) 122)) {
                i++;
            } else {
                byte[] data$okio = $this$commonToAsciiUppercase.getData$okio();
                byte[] lowercase = Arrays.copyOf(data$okio, data$okio.length);
                Intrinsics.checkExpressionValueIsNotNull(lowercase, "java.util.Arrays.copyOf(this, size)");
                int i2 = i + 1;
                lowercase[i] = (byte) (c - 32);
                while (i2 < lowercase.length) {
                    byte c2 = lowercase[i2];
                    if (c2 < b2 || c2 > b) {
                        i2++;
                    } else {
                        lowercase[i2] = (byte) (c2 - 32);
                        i2++;
                    }
                }
                return new ByteString(lowercase);
            }
        }
        return $this$commonToAsciiUppercase;
    }

    public static final ByteString commonSubstring(ByteString $this$commonSubstring, int beginIndex, int endIndex) {
        Intrinsics.checkParameterIsNotNull($this$commonSubstring, "$this$commonSubstring");
        boolean z = true;
        if (beginIndex >= 0) {
            if (endIndex <= $this$commonSubstring.getData$okio().length) {
                if (endIndex - beginIndex < 0) {
                    z = false;
                }
                if (!z) {
                    throw new IllegalArgumentException("endIndex < beginIndex".toString());
                } else if (beginIndex == 0 && endIndex == $this$commonSubstring.getData$okio().length) {
                    return $this$commonSubstring;
                } else {
                    return new ByteString(ArraysKt.copyOfRange($this$commonSubstring.getData$okio(), beginIndex, endIndex));
                }
            } else {
                throw new IllegalArgumentException(("endIndex > length(" + $this$commonSubstring.getData$okio().length + ')').toString());
            }
        } else {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
    }

    public static final byte commonGetByte(ByteString $this$commonGetByte, int pos) {
        Intrinsics.checkParameterIsNotNull($this$commonGetByte, "$this$commonGetByte");
        return $this$commonGetByte.getData$okio()[pos];
    }

    public static final int commonGetSize(ByteString $this$commonGetSize) {
        Intrinsics.checkParameterIsNotNull($this$commonGetSize, "$this$commonGetSize");
        return $this$commonGetSize.getData$okio().length;
    }

    public static final byte[] commonToByteArray(ByteString $this$commonToByteArray) {
        Intrinsics.checkParameterIsNotNull($this$commonToByteArray, "$this$commonToByteArray");
        byte[] data$okio = $this$commonToByteArray.getData$okio();
        byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    public static final byte[] commonInternalArray(ByteString $this$commonInternalArray) {
        Intrinsics.checkParameterIsNotNull($this$commonInternalArray, "$this$commonInternalArray");
        return $this$commonInternalArray.getData$okio();
    }

    public static final boolean commonRangeEquals(ByteString $this$commonRangeEquals, int offset, ByteString other, int otherOffset, int byteCount) {
        Intrinsics.checkParameterIsNotNull($this$commonRangeEquals, "$this$commonRangeEquals");
        Intrinsics.checkParameterIsNotNull(other, "other");
        return other.rangeEquals(otherOffset, $this$commonRangeEquals.getData$okio(), offset, byteCount);
    }

    public static final boolean commonRangeEquals(ByteString $this$commonRangeEquals, int offset, byte[] other, int otherOffset, int byteCount) {
        Intrinsics.checkParameterIsNotNull($this$commonRangeEquals, "$this$commonRangeEquals");
        Intrinsics.checkParameterIsNotNull(other, "other");
        return offset >= 0 && offset <= $this$commonRangeEquals.getData$okio().length - byteCount && otherOffset >= 0 && otherOffset <= other.length - byteCount && Util.arrayRangeEquals($this$commonRangeEquals.getData$okio(), offset, other, otherOffset, byteCount);
    }

    public static final boolean commonStartsWith(ByteString $this$commonStartsWith, ByteString prefix) {
        Intrinsics.checkParameterIsNotNull($this$commonStartsWith, "$this$commonStartsWith");
        Intrinsics.checkParameterIsNotNull(prefix, "prefix");
        return $this$commonStartsWith.rangeEquals(0, prefix, 0, prefix.size());
    }

    public static final boolean commonStartsWith(ByteString $this$commonStartsWith, byte[] prefix) {
        Intrinsics.checkParameterIsNotNull($this$commonStartsWith, "$this$commonStartsWith");
        Intrinsics.checkParameterIsNotNull(prefix, "prefix");
        return $this$commonStartsWith.rangeEquals(0, prefix, 0, prefix.length);
    }

    public static final boolean commonEndsWith(ByteString $this$commonEndsWith, ByteString suffix) {
        Intrinsics.checkParameterIsNotNull($this$commonEndsWith, "$this$commonEndsWith");
        Intrinsics.checkParameterIsNotNull(suffix, "suffix");
        return $this$commonEndsWith.rangeEquals($this$commonEndsWith.size() - suffix.size(), suffix, 0, suffix.size());
    }

    public static final boolean commonEndsWith(ByteString $this$commonEndsWith, byte[] suffix) {
        Intrinsics.checkParameterIsNotNull($this$commonEndsWith, "$this$commonEndsWith");
        Intrinsics.checkParameterIsNotNull(suffix, "suffix");
        return $this$commonEndsWith.rangeEquals($this$commonEndsWith.size() - suffix.length, suffix, 0, suffix.length);
    }

    public static final int commonIndexOf(ByteString $this$commonIndexOf, byte[] other, int fromIndex) {
        Intrinsics.checkParameterIsNotNull($this$commonIndexOf, "$this$commonIndexOf");
        Intrinsics.checkParameterIsNotNull(other, "other");
        int limit = $this$commonIndexOf.getData$okio().length - other.length;
        int i = Math.max(fromIndex, 0);
        if (i > limit) {
            return -1;
        }
        while (!Util.arrayRangeEquals($this$commonIndexOf.getData$okio(), i, other, 0, other.length)) {
            if (i == limit) {
                return -1;
            }
            i++;
        }
        return i;
    }

    public static final int commonLastIndexOf(ByteString $this$commonLastIndexOf, ByteString other, int fromIndex) {
        Intrinsics.checkParameterIsNotNull($this$commonLastIndexOf, "$this$commonLastIndexOf");
        Intrinsics.checkParameterIsNotNull(other, "other");
        return $this$commonLastIndexOf.lastIndexOf(other.internalArray$okio(), fromIndex);
    }

    public static final int commonLastIndexOf(ByteString $this$commonLastIndexOf, byte[] other, int fromIndex) {
        Intrinsics.checkParameterIsNotNull($this$commonLastIndexOf, "$this$commonLastIndexOf");
        Intrinsics.checkParameterIsNotNull(other, "other");
        for (int i = Math.min(fromIndex, $this$commonLastIndexOf.getData$okio().length - other.length); i >= 0; i--) {
            if (Util.arrayRangeEquals($this$commonLastIndexOf.getData$okio(), i, other, 0, other.length)) {
                return i;
            }
        }
        return -1;
    }

    public static final boolean commonEquals(ByteString $this$commonEquals, Object other) {
        Intrinsics.checkParameterIsNotNull($this$commonEquals, "$this$commonEquals");
        if (other == $this$commonEquals) {
            return true;
        }
        if (!(other instanceof ByteString)) {
            return false;
        }
        if (((ByteString) other).size() != $this$commonEquals.getData$okio().length || !((ByteString) other).rangeEquals(0, $this$commonEquals.getData$okio(), 0, $this$commonEquals.getData$okio().length)) {
            return false;
        }
        return true;
    }

    public static final int commonHashCode(ByteString $this$commonHashCode) {
        Intrinsics.checkParameterIsNotNull($this$commonHashCode, "$this$commonHashCode");
        int result = $this$commonHashCode.getHashCode$okio();
        if (result != 0) {
            return result;
        }
        int it = Arrays.hashCode($this$commonHashCode.getData$okio());
        $this$commonHashCode.setHashCode$okio(it);
        return it;
    }

    public static final int commonCompareTo(ByteString $this$commonCompareTo, ByteString other) {
        Intrinsics.checkParameterIsNotNull($this$commonCompareTo, "$this$commonCompareTo");
        Intrinsics.checkParameterIsNotNull(other, "other");
        int sizeA = $this$commonCompareTo.size();
        int sizeB = other.size();
        int i = 0;
        int size = Math.min(sizeA, sizeB);
        while (i < size) {
            int $this$and$iv = $this$commonCompareTo.getByte(i) & 255;
            int byteB = other.getByte(i) & 255;
            if ($this$and$iv == byteB) {
                i++;
            } else if ($this$and$iv < byteB) {
                return -1;
            } else {
                return 1;
            }
        }
        if (sizeA == sizeB) {
            return 0;
        }
        if (sizeA < sizeB) {
            return -1;
        }
        return 1;
    }

    public static final ByteString commonOf(byte[] data) {
        Intrinsics.checkParameterIsNotNull(data, Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        byte[] copyOf = Arrays.copyOf(data, data.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        return new ByteString(copyOf);
    }

    public static final ByteString commonToByteString(byte[] $this$commonToByteString, int offset, int byteCount) {
        Intrinsics.checkParameterIsNotNull($this$commonToByteString, "$this$commonToByteString");
        Util.checkOffsetAndCount((long) $this$commonToByteString.length, (long) offset, (long) byteCount);
        return new ByteString(ArraysKt.copyOfRange($this$commonToByteString, offset, offset + byteCount));
    }

    public static final ByteString commonEncodeUtf8(String $this$commonEncodeUtf8) {
        Intrinsics.checkParameterIsNotNull($this$commonEncodeUtf8, "$this$commonEncodeUtf8");
        ByteString byteString = new ByteString(Platform.asUtf8ToByteArray($this$commonEncodeUtf8));
        byteString.setUtf8$okio($this$commonEncodeUtf8);
        return byteString;
    }

    public static final ByteString commonDecodeBase64(String $this$commonDecodeBase64) {
        Intrinsics.checkParameterIsNotNull($this$commonDecodeBase64, "$this$commonDecodeBase64");
        byte[] decoded = Base64.decodeBase64ToArray($this$commonDecodeBase64);
        if (decoded != null) {
            return new ByteString(decoded);
        }
        return null;
    }

    public static final ByteString commonDecodeHex(String $this$commonDecodeHex) {
        Intrinsics.checkParameterIsNotNull($this$commonDecodeHex, "$this$commonDecodeHex");
        if ($this$commonDecodeHex.length() % 2 == 0) {
            byte[] result = new byte[($this$commonDecodeHex.length() / 2)];
            int length = result.length;
            for (int i = 0; i < length; i++) {
                result[i] = (byte) ((decodeHexDigit($this$commonDecodeHex.charAt(i * 2)) << 4) + decodeHexDigit($this$commonDecodeHex.charAt((i * 2) + 1)));
            }
            return new ByteString(result);
        }
        throw new IllegalArgumentException(("Unexpected hex string: " + $this$commonDecodeHex).toString());
    }

    public static final void commonWrite(ByteString $this$commonWrite, Buffer buffer, int offset, int byteCount) {
        Intrinsics.checkParameterIsNotNull($this$commonWrite, "$this$commonWrite");
        Intrinsics.checkParameterIsNotNull(buffer, "buffer");
        buffer.write($this$commonWrite.getData$okio(), offset, byteCount);
    }

    /* access modifiers changed from: private */
    public static final int decodeHexDigit(char c) {
        if ('0' <= c && '9' >= c) {
            return c - '0';
        }
        if ('a' <= c && 'f' >= c) {
            return (c - 'a') + 10;
        }
        if ('A' <= c && 'F' >= c) {
            return (c - 'A') + 10;
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c);
    }

    public static final String commonToString(ByteString $this$commonToString) {
        Intrinsics.checkParameterIsNotNull($this$commonToString, "$this$commonToString");
        boolean z = true;
        if ($this$commonToString.getData$okio().length == 0) {
            return "[size=0]";
        }
        int i = codePointIndexToCharIndex($this$commonToString.getData$okio(), 64);
        if (i != -1) {
            String text = $this$commonToString.utf8();
            if (text != null) {
                String substring = text.substring(0, i);
                Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String safeText = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(substring, "\\", "\\\\", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null), "\r", "\\r", false, 4, (Object) null);
                if (i < text.length()) {
                    return "[size=" + $this$commonToString.getData$okio().length + " text=" + safeText + "…]";
                }
                return "[text=" + safeText + ']';
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        } else if ($this$commonToString.getData$okio().length <= 64) {
            return "[hex=" + $this$commonToString.hex() + ']';
        } else {
            StringBuilder append = new StringBuilder().append("[size=").append($this$commonToString.getData$okio().length).append(" hex=");
            ByteString $this$commonSubstring$iv = $this$commonToString;
            if (64 <= $this$commonSubstring$iv.getData$okio().length) {
                if (64 - 0 < 0) {
                    z = false;
                }
                if (z) {
                    if (64 != $this$commonSubstring$iv.getData$okio().length) {
                        $this$commonSubstring$iv = new ByteString(ArraysKt.copyOfRange($this$commonSubstring$iv.getData$okio(), 0, 64));
                    }
                    return append.append($this$commonSubstring$iv.hex()).append("…]").toString();
                }
                throw new IllegalArgumentException("endIndex < beginIndex".toString());
            }
            throw new IllegalArgumentException(("endIndex > length(" + $this$commonSubstring$iv.getData$okio().length + ')').toString());
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0180, code lost:
        if (31 < 65533(0xfffd, float:9.1831E-41)) goto L_0x0185;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x018c, code lost:
        if (159(0x9f, float:2.23E-43) < 65533(0xfffd, float:9.1831E-41)) goto L_0x0190;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x018e, code lost:
        r16 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x01c0, code lost:
        if (31 < r14) goto L_0x01c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x01cc, code lost:
        if (159 < r14) goto L_0x01d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x01ce, code lost:
        r16 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x024d, code lost:
        if (r16 == false) goto L_0x0252;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x028c, code lost:
        if (31 < 65533(0xfffd, float:9.1831E-41)) goto L_0x0291;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x0298, code lost:
        if (159(0x9f, float:2.23E-43) < 65533(0xfffd, float:9.1831E-41)) goto L_0x029c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x029a, code lost:
        r16 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x02e9, code lost:
        if (31 < 65533(0xfffd, float:9.1831E-41)) goto L_0x02ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x02f5, code lost:
        if (159(0x9f, float:2.23E-43) < 65533(0xfffd, float:9.1831E-41)) goto L_0x02f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x02f7, code lost:
        r16 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x0343, code lost:
        if (31 < 65533(0xfffd, float:9.1831E-41)) goto L_0x0348;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x034f, code lost:
        if (159(0x9f, float:2.23E-43) < 65533(0xfffd, float:9.1831E-41)) goto L_0x0353;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x0351, code lost:
        r16 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:286:0x0391, code lost:
        if (31 < 65533(0xfffd, float:9.1831E-41)) goto L_0x0396;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:291:0x039d, code lost:
        if (159(0x9f, float:2.23E-43) < 65533(0xfffd, float:9.1831E-41)) goto L_0x03a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:292:0x039f, code lost:
        r16 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:297:0x03ac, code lost:
        if (65533(0xfffd, float:9.1831E-41) < 65536(0x10000, float:9.18355E-41)) goto L_0x03e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:308:0x03ca, code lost:
        if (31 < r15) goto L_0x03cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:313:0x03d6, code lost:
        if (159 < r15) goto L_0x03da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:314:0x03d8, code lost:
        r16 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:319:0x03e5, code lost:
        if (r15 < 65536) goto L_0x03e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:382:0x04af, code lost:
        if (31 < 65533(0xfffd, float:9.1831E-41)) goto L_0x04b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:387:0x04bb, code lost:
        if (159(0x9f, float:2.23E-43) < 65533(0xfffd, float:9.1831E-41)) goto L_0x04bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:388:0x04bd, code lost:
        r16 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:411:0x050a, code lost:
        if (31 < 65533(0xfffd, float:9.1831E-41)) goto L_0x050f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:416:0x0516, code lost:
        if (159(0x9f, float:2.23E-43) < 65533(0xfffd, float:9.1831E-41)) goto L_0x051a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:417:0x0518, code lost:
        r16 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:440:0x0568, code lost:
        if (31 < 65533(0xfffd, float:9.1831E-41)) goto L_0x056d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:445:0x0574, code lost:
        if (159(0x9f, float:2.23E-43) < 65533(0xfffd, float:9.1831E-41)) goto L_0x0578;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:446:0x0576, code lost:
        r16 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:466:0x05c7, code lost:
        if (31 < 65533(0xfffd, float:9.1831E-41)) goto L_0x05cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:471:0x05d3, code lost:
        if (159(0x9f, float:2.23E-43) < 65533(0xfffd, float:9.1831E-41)) goto L_0x05d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:472:0x05d5, code lost:
        r16 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:494:0x0616, code lost:
        if (31 < 65533(0xfffd, float:9.1831E-41)) goto L_0x061b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:499:0x0622, code lost:
        if (159(0x9f, float:2.23E-43) < 65533(0xfffd, float:9.1831E-41)) goto L_0x0626;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:500:0x0624, code lost:
        r16 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:505:0x0631, code lost:
        if (65533(0xfffd, float:9.1831E-41) < 65536(0x10000, float:9.18355E-41)) goto L_0x0633;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:520:0x065c, code lost:
        if (31 < 65533(0xfffd, float:9.1831E-41)) goto L_0x0661;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:525:0x0668, code lost:
        if (159(0x9f, float:2.23E-43) < 65533(0xfffd, float:9.1831E-41)) goto L_0x066c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:526:0x066a, code lost:
        r16 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:531:0x0677, code lost:
        if (65533(0xfffd, float:9.1831E-41) < 65536(0x10000, float:9.18355E-41)) goto L_0x0633;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:542:0x0695, code lost:
        if (31 < r15) goto L_0x069a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:547:0x06a1, code lost:
        if (159 < r15) goto L_0x06a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:548:0x06a3, code lost:
        r16 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:553:0x06b0, code lost:
        if (r15 < 65536) goto L_0x0633;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x012a, code lost:
        if (31 < 65533(0xfffd, float:9.1831E-41)) goto L_0x012f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0136, code lost:
        if (159(0x9f, float:2.23E-43) < 65533(0xfffd, float:9.1831E-41)) goto L_0x013a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0138, code lost:
        r16 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int codePointIndexToCharIndex(byte[] r29, int r30) {
        /*
            r0 = r30
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = r29
            int r5 = r4.length
            r6 = r29
            r7 = 0
            r8 = r3
        L_0x000c:
            if (r8 >= r5) goto L_0x06fb
            byte r9 = r6[r8]
            r10 = 127(0x7f, float:1.78E-43)
            r11 = 159(0x9f, float:2.23E-43)
            r12 = 31
            r14 = 13
            r13 = 10
            r15 = 65536(0x10000, float:9.18355E-41)
            r16 = 0
            r17 = 2
            r18 = 1
            if (r9 < 0) goto L_0x00a0
            r19 = r9
            r20 = 0
            int r21 = r2 + 1
            if (r2 != r0) goto L_0x002e
            return r1
        L_0x002e:
            r2 = r19
            if (r2 == r13) goto L_0x0048
            if (r2 == r14) goto L_0x0048
            r19 = 0
            if (r2 < 0) goto L_0x003c
            if (r12 >= r2) goto L_0x0041
        L_0x003c:
            if (r10 <= r2) goto L_0x003f
            goto L_0x0044
        L_0x003f:
            if (r11 < r2) goto L_0x0044
        L_0x0041:
            r19 = r18
            goto L_0x0046
        L_0x0044:
            r19 = r16
        L_0x0046:
            if (r19 != 0) goto L_0x004d
        L_0x0048:
            r11 = 65533(0xfffd, float:9.1831E-41)
            if (r2 != r11) goto L_0x004f
        L_0x004d:
            r10 = -1
            return r10
        L_0x004f:
            if (r2 >= r15) goto L_0x0054
            r11 = r18
            goto L_0x0056
        L_0x0054:
            r11 = r17
        L_0x0056:
            int r1 = r1 + r11
            int r8 = r8 + 1
            r2 = r21
        L_0x005c:
            if (r8 >= r5) goto L_0x009c
            byte r11 = r6[r8]
            if (r11 < 0) goto L_0x009c
            int r11 = r8 + 1
            byte r8 = r6[r8]
            r20 = 0
            int r21 = r2 + 1
            if (r2 != r0) goto L_0x006d
            return r1
        L_0x006d:
            if (r8 == r13) goto L_0x0086
            if (r8 == r14) goto L_0x0086
            r2 = 0
            if (r8 < 0) goto L_0x0078
            if (r12 >= r8) goto L_0x007f
        L_0x0078:
            if (r10 <= r8) goto L_0x007b
            goto L_0x0082
        L_0x007b:
            r10 = 159(0x9f, float:2.23E-43)
            if (r10 < r8) goto L_0x0082
        L_0x007f:
            r2 = r18
            goto L_0x0084
        L_0x0082:
            r2 = r16
        L_0x0084:
            if (r2 != 0) goto L_0x008b
        L_0x0086:
            r2 = 65533(0xfffd, float:9.1831E-41)
            if (r8 != r2) goto L_0x008d
        L_0x008b:
            r2 = -1
            return r2
        L_0x008d:
            if (r8 >= r15) goto L_0x0092
            r2 = r18
            goto L_0x0094
        L_0x0092:
            r2 = r17
        L_0x0094:
            int r1 = r1 + r2
            r8 = r11
            r2 = r21
            r10 = 127(0x7f, float:1.78E-43)
            goto L_0x005c
        L_0x009c:
            r26 = r3
            goto L_0x06f4
        L_0x00a0:
            r10 = 5
            r11 = r9
            r20 = 0
            int r10 = r11 >> r10
            r11 = -2
            if (r10 != r11) goto L_0x01ec
            r10 = r6
            r11 = 0
            int r15 = r8 + 1
            if (r5 > r15) goto L_0x00ed
            r15 = 65533(0xfffd, float:9.1831E-41)
            r21 = 0
            r22 = r15
            r23 = 0
            int r24 = r2 + 1
            if (r2 != r0) goto L_0x00bd
            return r1
        L_0x00bd:
            r2 = r22
            if (r2 == r13) goto L_0x00d7
            if (r2 == r14) goto L_0x00d7
            r13 = 0
            if (r2 < 0) goto L_0x00ca
            if (r12 >= r2) goto L_0x00d3
        L_0x00ca:
            r12 = 127(0x7f, float:1.78E-43)
            if (r12 <= r2) goto L_0x00cf
            goto L_0x00d5
        L_0x00cf:
            r12 = 159(0x9f, float:2.23E-43)
            if (r12 < r2) goto L_0x00d5
        L_0x00d3:
            r16 = r18
        L_0x00d5:
            if (r16 != 0) goto L_0x00dc
        L_0x00d7:
            r12 = 65533(0xfffd, float:9.1831E-41)
            if (r2 != r12) goto L_0x00de
        L_0x00dc:
            r12 = -1
            return r12
        L_0x00de:
            r12 = 65536(0x10000, float:9.18355E-41)
            if (r2 >= r12) goto L_0x00e4
            r17 = r18
        L_0x00e4:
            int r1 = r1 + r17
            r26 = r3
            r17 = r18
            goto L_0x01e6
        L_0x00ed:
            byte r15 = r10[r8]
            int r22 = r8 + 1
            byte r12 = r10[r22]
            r22 = 0
            r24 = 192(0xc0, float:2.69E-43)
            r25 = r12
            r26 = 0
            r14 = r25 & r24
            r13 = 128(0x80, float:1.794E-43)
            if (r14 != r13) goto L_0x0104
            r13 = r18
            goto L_0x0106
        L_0x0104:
            r13 = r16
        L_0x0106:
            if (r13 != 0) goto L_0x0152
            r13 = 65533(0xfffd, float:9.1831E-41)
            r14 = 0
            r21 = r13
            r22 = 0
            int r25 = r2 + 1
            if (r2 != r0) goto L_0x0115
            return r1
        L_0x0115:
            r26 = r3
            r2 = r21
            r3 = 10
            if (r2 == r3) goto L_0x013c
            r3 = 13
            if (r2 == r3) goto L_0x013c
            r3 = 0
            if (r2 < 0) goto L_0x012d
            r21 = r3
            r3 = 31
            if (r3 >= r2) goto L_0x0138
            goto L_0x012f
        L_0x012d:
            r21 = r3
        L_0x012f:
            r3 = 127(0x7f, float:1.78E-43)
            if (r3 <= r2) goto L_0x0134
            goto L_0x013a
        L_0x0134:
            r3 = 159(0x9f, float:2.23E-43)
            if (r3 < r2) goto L_0x013a
        L_0x0138:
            r16 = r18
        L_0x013a:
            if (r16 != 0) goto L_0x0141
        L_0x013c:
            r3 = 65533(0xfffd, float:9.1831E-41)
            if (r2 != r3) goto L_0x0143
        L_0x0141:
            r3 = -1
            return r3
        L_0x0143:
            r3 = 65536(0x10000, float:9.18355E-41)
            if (r2 >= r3) goto L_0x0149
            r17 = r18
        L_0x0149:
            int r1 = r1 + r17
            r17 = r18
            r24 = r25
            goto L_0x01e6
        L_0x0152:
            r26 = r3
            r3 = r12 ^ 3968(0xf80, float:5.56E-42)
            int r13 = r15 << 6
            r3 = r3 ^ r13
            r13 = 128(0x80, float:1.794E-43)
            if (r3 >= r13) goto L_0x01a5
            r13 = 65533(0xfffd, float:9.1831E-41)
            r14 = 0
            r21 = r13
            r22 = 0
            int r25 = r2 + 1
            if (r2 != r0) goto L_0x016d
            return r1
        L_0x016d:
            r2 = r21
            r4 = 10
            if (r2 == r4) goto L_0x0192
            r4 = 13
            if (r2 == r4) goto L_0x0192
            r4 = 0
            if (r2 < 0) goto L_0x0183
            r21 = r4
            r4 = 31
            if (r4 >= r2) goto L_0x018e
            goto L_0x0185
        L_0x0183:
            r21 = r4
        L_0x0185:
            r4 = 127(0x7f, float:1.78E-43)
            if (r4 <= r2) goto L_0x018a
            goto L_0x0190
        L_0x018a:
            r4 = 159(0x9f, float:2.23E-43)
            if (r4 < r2) goto L_0x0190
        L_0x018e:
            r16 = r18
        L_0x0190:
            if (r16 != 0) goto L_0x0197
        L_0x0192:
            r4 = 65533(0xfffd, float:9.1831E-41)
            if (r2 != r4) goto L_0x0199
        L_0x0197:
            r4 = -1
            return r4
        L_0x0199:
            r4 = 65536(0x10000, float:9.18355E-41)
            if (r2 >= r4) goto L_0x019e
            goto L_0x01a0
        L_0x019e:
            r18 = r17
        L_0x01a0:
            int r1 = r1 + r18
            r24 = r25
            goto L_0x01e4
        L_0x01a5:
            r4 = r3
            r13 = 0
            r14 = r4
            r21 = 0
            int r22 = r2 + 1
            if (r2 != r0) goto L_0x01af
            return r1
        L_0x01af:
            r2 = 10
            if (r14 == r2) goto L_0x01d2
            r2 = 13
            if (r14 == r2) goto L_0x01d2
            r2 = 0
            if (r14 < 0) goto L_0x01c3
            r24 = r2
            r2 = 31
            if (r2 >= r14) goto L_0x01ce
            goto L_0x01c5
        L_0x01c3:
            r24 = r2
        L_0x01c5:
            r2 = 127(0x7f, float:1.78E-43)
            if (r2 <= r14) goto L_0x01ca
            goto L_0x01d0
        L_0x01ca:
            r2 = 159(0x9f, float:2.23E-43)
            if (r2 < r14) goto L_0x01d0
        L_0x01ce:
            r16 = r18
        L_0x01d0:
            if (r16 != 0) goto L_0x01d7
        L_0x01d2:
            r2 = 65533(0xfffd, float:9.1831E-41)
            if (r14 != r2) goto L_0x01d9
        L_0x01d7:
            r2 = -1
            return r2
        L_0x01d9:
            r2 = 65536(0x10000, float:9.18355E-41)
            if (r14 >= r2) goto L_0x01de
            goto L_0x01e0
        L_0x01de:
            r18 = r17
        L_0x01e0:
            int r1 = r1 + r18
            r24 = r22
        L_0x01e4:
        L_0x01e6:
            int r8 = r8 + r17
            r2 = r24
            goto L_0x06f4
        L_0x01ec:
            r26 = r3
            r3 = 4
            r4 = r9
            r10 = 0
            int r3 = r4 >> r3
            if (r3 != r11) goto L_0x03f6
            r3 = r6
            r11 = 0
            int r13 = r8 + 2
            if (r5 > r13) goto L_0x0256
            r4 = 65533(0xfffd, float:9.1831E-41)
            r10 = 0
            r12 = r4
            r13 = 0
            int r14 = r2 + 1
            if (r2 != r0) goto L_0x0206
            return r1
        L_0x0206:
            r2 = 10
            if (r12 == r2) goto L_0x0227
            r2 = 13
            if (r12 == r2) goto L_0x0227
            r2 = 0
            if (r12 < 0) goto L_0x0217
            r15 = 31
            if (r15 >= r12) goto L_0x0220
        L_0x0217:
            r15 = 127(0x7f, float:1.78E-43)
            if (r15 <= r12) goto L_0x021c
            goto L_0x0223
        L_0x021c:
            r15 = 159(0x9f, float:2.23E-43)
            if (r15 < r12) goto L_0x0223
        L_0x0220:
            r2 = r18
            goto L_0x0225
        L_0x0223:
            r2 = r16
        L_0x0225:
            if (r2 != 0) goto L_0x022c
        L_0x0227:
            r2 = 65533(0xfffd, float:9.1831E-41)
            if (r12 != r2) goto L_0x022e
        L_0x022c:
            r2 = -1
            return r2
        L_0x022e:
            r2 = 65536(0x10000, float:9.18355E-41)
            if (r12 >= r2) goto L_0x0235
            r2 = r18
            goto L_0x0237
        L_0x0235:
            r2 = r17
        L_0x0237:
            int r1 = r1 + r2
            int r2 = r8 + 1
            if (r5 <= r2) goto L_0x0252
            int r2 = r8 + 1
            byte r2 = r3[r2]
            r4 = 0
            r10 = 192(0xc0, float:2.69E-43)
            r12 = r2
            r13 = 0
            r10 = r10 & r12
            r12 = 128(0x80, float:1.794E-43)
            if (r10 != r12) goto L_0x024d
            r16 = r18
        L_0x024d:
            if (r16 != 0) goto L_0x0250
            goto L_0x0252
        L_0x0250:
            goto L_0x03f1
        L_0x0252:
            r17 = r18
            goto L_0x03f1
        L_0x0256:
            byte r13 = r3[r8]
            int r14 = r8 + 1
            byte r14 = r3[r14]
            r15 = 0
            r22 = 192(0xc0, float:2.69E-43)
            r25 = r14
            r27 = 0
            r12 = r25 & r22
            r10 = 128(0x80, float:1.794E-43)
            if (r12 != r10) goto L_0x026c
            r10 = r18
            goto L_0x026e
        L_0x026c:
            r10 = r16
        L_0x026e:
            if (r10 != 0) goto L_0x02b4
            r4 = 65533(0xfffd, float:9.1831E-41)
            r10 = 0
            r12 = r4
            r15 = 0
            int r21 = r2 + 1
            if (r2 != r0) goto L_0x027b
            return r1
        L_0x027b:
            r2 = 10
            if (r12 == r2) goto L_0x029e
            r2 = 13
            if (r12 == r2) goto L_0x029e
            r2 = 0
            if (r12 < 0) goto L_0x028f
            r22 = r2
            r2 = 31
            if (r2 >= r12) goto L_0x029a
            goto L_0x0291
        L_0x028f:
            r22 = r2
        L_0x0291:
            r2 = 127(0x7f, float:1.78E-43)
            if (r2 <= r12) goto L_0x0296
            goto L_0x029c
        L_0x0296:
            r2 = 159(0x9f, float:2.23E-43)
            if (r2 < r12) goto L_0x029c
        L_0x029a:
            r16 = r18
        L_0x029c:
            if (r16 != 0) goto L_0x02a3
        L_0x029e:
            r2 = 65533(0xfffd, float:9.1831E-41)
            if (r12 != r2) goto L_0x02a5
        L_0x02a3:
            r2 = -1
            return r2
        L_0x02a5:
            r2 = 65536(0x10000, float:9.18355E-41)
            if (r12 >= r2) goto L_0x02ab
            r17 = r18
        L_0x02ab:
            int r1 = r1 + r17
            r17 = r18
            r14 = r21
            goto L_0x03f1
        L_0x02b4:
            int r10 = r8 + 2
            byte r10 = r3[r10]
            r12 = 0
            r15 = 192(0xc0, float:2.69E-43)
            r25 = r10
            r27 = 0
            r15 = r25 & r15
            r4 = 128(0x80, float:1.794E-43)
            if (r15 != r4) goto L_0x02c8
            r4 = r18
            goto L_0x02ca
        L_0x02c8:
            r4 = r16
        L_0x02ca:
            if (r4 != 0) goto L_0x0310
            r4 = 65533(0xfffd, float:9.1831E-41)
            r12 = 0
            r15 = r4
            r21 = 0
            int r22 = r2 + 1
            if (r2 != r0) goto L_0x02d8
            return r1
        L_0x02d8:
            r2 = 10
            if (r15 == r2) goto L_0x02fb
            r2 = 13
            if (r15 == r2) goto L_0x02fb
            r2 = 0
            if (r15 < 0) goto L_0x02ec
            r24 = r2
            r2 = 31
            if (r2 >= r15) goto L_0x02f7
            goto L_0x02ee
        L_0x02ec:
            r24 = r2
        L_0x02ee:
            r2 = 127(0x7f, float:1.78E-43)
            if (r2 <= r15) goto L_0x02f3
            goto L_0x02f9
        L_0x02f3:
            r2 = 159(0x9f, float:2.23E-43)
            if (r2 < r15) goto L_0x02f9
        L_0x02f7:
            r16 = r18
        L_0x02f9:
            if (r16 != 0) goto L_0x0300
        L_0x02fb:
            r2 = 65533(0xfffd, float:9.1831E-41)
            if (r15 != r2) goto L_0x0302
        L_0x0300:
            r2 = -1
            return r2
        L_0x0302:
            r2 = 65536(0x10000, float:9.18355E-41)
            if (r15 >= r2) goto L_0x0307
            goto L_0x0309
        L_0x0307:
            r18 = r17
        L_0x0309:
            int r1 = r1 + r18
            r14 = r22
            goto L_0x03f1
        L_0x0310:
            r4 = -123008(0xfffffffffffe1f80, float:NaN)
            r4 = r4 ^ r10
            int r12 = r14 << 6
            r4 = r4 ^ r12
            int r12 = r13 << 12
            r4 = r4 ^ r12
            r12 = 2048(0x800, float:2.87E-42)
            if (r4 >= r12) goto L_0x0367
            r12 = 65533(0xfffd, float:9.1831E-41)
            r15 = 0
            r21 = r12
            r22 = 0
            int r25 = r2 + 1
            if (r2 != r0) goto L_0x032e
            return r1
        L_0x032e:
            r2 = r21
            r21 = r3
            r3 = 10
            if (r2 == r3) goto L_0x0355
            r3 = 13
            if (r2 == r3) goto L_0x0355
            r3 = 0
            if (r2 < 0) goto L_0x0346
            r24 = r3
            r3 = 31
            if (r3 >= r2) goto L_0x0351
            goto L_0x0348
        L_0x0346:
            r24 = r3
        L_0x0348:
            r3 = 127(0x7f, float:1.78E-43)
            if (r3 <= r2) goto L_0x034d
            goto L_0x0353
        L_0x034d:
            r3 = 159(0x9f, float:2.23E-43)
            if (r3 < r2) goto L_0x0353
        L_0x0351:
            r16 = r18
        L_0x0353:
            if (r16 != 0) goto L_0x035a
        L_0x0355:
            r3 = 65533(0xfffd, float:9.1831E-41)
            if (r2 != r3) goto L_0x035c
        L_0x035a:
            r3 = -1
            return r3
        L_0x035c:
            r3 = 65536(0x10000, float:9.18355E-41)
            if (r2 >= r3) goto L_0x0362
            r17 = r18
        L_0x0362:
            int r1 = r1 + r17
            goto L_0x03ec
        L_0x0367:
            r21 = r3
            r3 = 55296(0xd800, float:7.7486E-41)
            if (r3 <= r4) goto L_0x036f
            goto L_0x03af
        L_0x036f:
            r3 = 57343(0xdfff, float:8.0355E-41)
            if (r3 < r4) goto L_0x03af
            r3 = 65533(0xfffd, float:9.1831E-41)
            r12 = 0
            r15 = r3
            r22 = 0
            int r25 = r2 + 1
            if (r2 != r0) goto L_0x0380
            return r1
        L_0x0380:
            r2 = 10
            if (r15 == r2) goto L_0x03a3
            r2 = 13
            if (r15 == r2) goto L_0x03a3
            r2 = 0
            if (r15 < 0) goto L_0x0394
            r24 = r2
            r2 = 31
            if (r2 >= r15) goto L_0x039f
            goto L_0x0396
        L_0x0394:
            r24 = r2
        L_0x0396:
            r2 = 127(0x7f, float:1.78E-43)
            if (r2 <= r15) goto L_0x039b
            goto L_0x03a1
        L_0x039b:
            r2 = 159(0x9f, float:2.23E-43)
            if (r2 < r15) goto L_0x03a1
        L_0x039f:
            r16 = r18
        L_0x03a1:
            if (r16 != 0) goto L_0x03a8
        L_0x03a3:
            r2 = 65533(0xfffd, float:9.1831E-41)
            if (r15 != r2) goto L_0x03aa
        L_0x03a8:
            r2 = -1
            return r2
        L_0x03aa:
            r2 = 65536(0x10000, float:9.18355E-41)
            if (r15 >= r2) goto L_0x03e9
            goto L_0x03e7
        L_0x03af:
            r3 = r4
            r12 = 0
            r15 = r3
            r22 = 0
            int r25 = r2 + 1
            if (r2 != r0) goto L_0x03b9
            return r1
        L_0x03b9:
            r2 = 10
            if (r15 == r2) goto L_0x03dc
            r2 = 13
            if (r15 == r2) goto L_0x03dc
            r2 = 0
            if (r15 < 0) goto L_0x03cd
            r24 = r2
            r2 = 31
            if (r2 >= r15) goto L_0x03d8
            goto L_0x03cf
        L_0x03cd:
            r24 = r2
        L_0x03cf:
            r2 = 127(0x7f, float:1.78E-43)
            if (r2 <= r15) goto L_0x03d4
            goto L_0x03da
        L_0x03d4:
            r2 = 159(0x9f, float:2.23E-43)
            if (r2 < r15) goto L_0x03da
        L_0x03d8:
            r16 = r18
        L_0x03da:
            if (r16 != 0) goto L_0x03e1
        L_0x03dc:
            r2 = 65533(0xfffd, float:9.1831E-41)
            if (r15 != r2) goto L_0x03e3
        L_0x03e1:
            r2 = -1
            return r2
        L_0x03e3:
            r2 = 65536(0x10000, float:9.18355E-41)
            if (r15 >= r2) goto L_0x03e9
        L_0x03e7:
            r17 = r18
        L_0x03e9:
            int r1 = r1 + r17
        L_0x03ec:
            r14 = r25
            r17 = 3
        L_0x03f1:
            int r8 = r8 + r17
            r2 = r14
            goto L_0x06f4
        L_0x03f6:
            r3 = 3
            r4 = r9
            r10 = 0
            int r3 = r4 >> r3
            if (r3 != r11) goto L_0x06ba
            r3 = r6
            r4 = 0
            int r10 = r8 + 3
            if (r5 > r10) goto L_0x047c
            r10 = 65533(0xfffd, float:9.1831E-41)
            r11 = 0
            r12 = r10
            r13 = 0
            int r14 = r2 + 1
            if (r2 != r0) goto L_0x040e
            return r1
        L_0x040e:
            r2 = 10
            if (r12 == r2) goto L_0x042f
            r2 = 13
            if (r12 == r2) goto L_0x042f
            r2 = 0
            if (r12 < 0) goto L_0x041f
            r15 = 31
            if (r15 >= r12) goto L_0x0428
        L_0x041f:
            r15 = 127(0x7f, float:1.78E-43)
            if (r15 <= r12) goto L_0x0424
            goto L_0x042b
        L_0x0424:
            r15 = 159(0x9f, float:2.23E-43)
            if (r15 < r12) goto L_0x042b
        L_0x0428:
            r2 = r18
            goto L_0x042d
        L_0x042b:
            r2 = r16
        L_0x042d:
            if (r2 != 0) goto L_0x0434
        L_0x042f:
            r2 = 65533(0xfffd, float:9.1831E-41)
            if (r12 != r2) goto L_0x0436
        L_0x0434:
            r2 = -1
            return r2
        L_0x0436:
            r2 = 65536(0x10000, float:9.18355E-41)
            if (r12 >= r2) goto L_0x043d
            r2 = r18
            goto L_0x043f
        L_0x043d:
            r2 = r17
        L_0x043f:
            int r1 = r1 + r2
            int r2 = r8 + 1
            if (r5 <= r2) goto L_0x0478
            int r2 = r8 + 1
            byte r2 = r3[r2]
            r10 = 0
            r11 = 192(0xc0, float:2.69E-43)
            r12 = r2
            r13 = 0
            r11 = r11 & r12
            r12 = 128(0x80, float:1.794E-43)
            if (r11 != r12) goto L_0x0456
            r2 = r18
            goto L_0x0458
        L_0x0456:
            r2 = r16
        L_0x0458:
            if (r2 != 0) goto L_0x045b
            goto L_0x0478
        L_0x045b:
            int r2 = r8 + 2
            if (r5 <= r2) goto L_0x0476
            int r2 = r8 + 2
            byte r2 = r3[r2]
            r10 = 0
            r11 = 192(0xc0, float:2.69E-43)
            r12 = r2
            r13 = 0
            r11 = r11 & r12
            r12 = 128(0x80, float:1.794E-43)
            if (r11 != r12) goto L_0x046f
            r16 = r18
        L_0x046f:
            if (r16 != 0) goto L_0x0472
            goto L_0x0476
        L_0x0472:
            r17 = 3
            goto L_0x06b6
        L_0x0476:
            goto L_0x06b6
        L_0x0478:
            r17 = r18
            goto L_0x06b6
        L_0x047c:
            byte r10 = r3[r8]
            int r11 = r8 + 1
            byte r11 = r3[r11]
            r12 = 0
            r13 = 192(0xc0, float:2.69E-43)
            r14 = r11
            r15 = 0
            r13 = r13 & r14
            r14 = 128(0x80, float:1.794E-43)
            if (r13 != r14) goto L_0x048f
            r12 = r18
            goto L_0x0491
        L_0x048f:
            r12 = r16
        L_0x0491:
            if (r12 != 0) goto L_0x04d7
            r12 = 65533(0xfffd, float:9.1831E-41)
            r13 = 0
            r14 = r12
            r15 = 0
            int r21 = r2 + 1
            if (r2 != r0) goto L_0x049e
            return r1
        L_0x049e:
            r2 = 10
            if (r14 == r2) goto L_0x04c1
            r2 = 13
            if (r14 == r2) goto L_0x04c1
            r2 = 0
            if (r14 < 0) goto L_0x04b2
            r22 = r2
            r2 = 31
            if (r2 >= r14) goto L_0x04bd
            goto L_0x04b4
        L_0x04b2:
            r22 = r2
        L_0x04b4:
            r2 = 127(0x7f, float:1.78E-43)
            if (r2 <= r14) goto L_0x04b9
            goto L_0x04bf
        L_0x04b9:
            r2 = 159(0x9f, float:2.23E-43)
            if (r2 < r14) goto L_0x04bf
        L_0x04bd:
            r16 = r18
        L_0x04bf:
            if (r16 != 0) goto L_0x04c6
        L_0x04c1:
            r2 = 65533(0xfffd, float:9.1831E-41)
            if (r14 != r2) goto L_0x04c8
        L_0x04c6:
            r2 = -1
            return r2
        L_0x04c8:
            r2 = 65536(0x10000, float:9.18355E-41)
            if (r14 >= r2) goto L_0x04ce
            r17 = r18
        L_0x04ce:
            int r1 = r1 + r17
            r17 = r18
            r14 = r21
            goto L_0x06b6
        L_0x04d7:
            int r12 = r8 + 2
            byte r12 = r3[r12]
            r13 = 0
            r14 = 192(0xc0, float:2.69E-43)
            r15 = r12
            r27 = 0
            r14 = r14 & r15
            r15 = 128(0x80, float:1.794E-43)
            if (r14 != r15) goto L_0x04e9
            r13 = r18
            goto L_0x04eb
        L_0x04e9:
            r13 = r16
        L_0x04eb:
            if (r13 != 0) goto L_0x0531
            r13 = 65533(0xfffd, float:9.1831E-41)
            r14 = 0
            r15 = r13
            r21 = 0
            int r22 = r2 + 1
            if (r2 != r0) goto L_0x04f9
            return r1
        L_0x04f9:
            r2 = 10
            if (r15 == r2) goto L_0x051c
            r2 = 13
            if (r15 == r2) goto L_0x051c
            r2 = 0
            if (r15 < 0) goto L_0x050d
            r24 = r2
            r2 = 31
            if (r2 >= r15) goto L_0x0518
            goto L_0x050f
        L_0x050d:
            r24 = r2
        L_0x050f:
            r2 = 127(0x7f, float:1.78E-43)
            if (r2 <= r15) goto L_0x0514
            goto L_0x051a
        L_0x0514:
            r2 = 159(0x9f, float:2.23E-43)
            if (r2 < r15) goto L_0x051a
        L_0x0518:
            r16 = r18
        L_0x051a:
            if (r16 != 0) goto L_0x0521
        L_0x051c:
            r2 = 65533(0xfffd, float:9.1831E-41)
            if (r15 != r2) goto L_0x0523
        L_0x0521:
            r2 = -1
            return r2
        L_0x0523:
            r2 = 65536(0x10000, float:9.18355E-41)
            if (r15 >= r2) goto L_0x0528
            goto L_0x052a
        L_0x0528:
            r18 = r17
        L_0x052a:
            int r1 = r1 + r18
            r14 = r22
            goto L_0x06b6
        L_0x0531:
            int r13 = r8 + 3
            byte r13 = r3[r13]
            r14 = 0
            r15 = 192(0xc0, float:2.69E-43)
            r27 = r13
            r28 = 0
            r15 = r27 & r15
            r27 = r3
            r3 = 128(0x80, float:1.794E-43)
            if (r15 != r3) goto L_0x0547
            r3 = r18
            goto L_0x0549
        L_0x0547:
            r3 = r16
        L_0x0549:
            if (r3 != 0) goto L_0x0590
            r3 = 65533(0xfffd, float:9.1831E-41)
            r14 = 0
            r15 = r3
            r21 = 0
            int r22 = r2 + 1
            if (r2 != r0) goto L_0x0557
            return r1
        L_0x0557:
            r2 = 10
            if (r15 == r2) goto L_0x057a
            r2 = 13
            if (r15 == r2) goto L_0x057a
            r2 = 0
            if (r15 < 0) goto L_0x056b
            r24 = r2
            r2 = 31
            if (r2 >= r15) goto L_0x0576
            goto L_0x056d
        L_0x056b:
            r24 = r2
        L_0x056d:
            r2 = 127(0x7f, float:1.78E-43)
            if (r2 <= r15) goto L_0x0572
            goto L_0x0578
        L_0x0572:
            r2 = 159(0x9f, float:2.23E-43)
            if (r2 < r15) goto L_0x0578
        L_0x0576:
            r16 = r18
        L_0x0578:
            if (r16 != 0) goto L_0x057f
        L_0x057a:
            r2 = 65533(0xfffd, float:9.1831E-41)
            if (r15 != r2) goto L_0x0581
        L_0x057f:
            r2 = -1
            return r2
        L_0x0581:
            r2 = 65536(0x10000, float:9.18355E-41)
            if (r15 >= r2) goto L_0x0587
            r17 = r18
        L_0x0587:
            int r1 = r1 + r17
            r14 = r22
            r17 = 3
            goto L_0x06b6
        L_0x0590:
            r3 = 3678080(0x381f80, float:5.154088E-39)
            r3 = r3 ^ r13
            int r14 = r12 << 6
            r3 = r3 ^ r14
            int r14 = r11 << 12
            r3 = r3 ^ r14
            int r14 = r10 << 18
            r3 = r3 ^ r14
            r14 = 1114111(0x10ffff, float:1.561202E-39)
            if (r3 <= r14) goto L_0x05ec
            r14 = 65533(0xfffd, float:9.1831E-41)
            r15 = 0
            r21 = r14
            r22 = 0
            int r25 = r2 + 1
            if (r2 != r0) goto L_0x05b2
            return r1
        L_0x05b2:
            r2 = r21
            r21 = r4
            r4 = 10
            if (r2 == r4) goto L_0x05d9
            r4 = 13
            if (r2 == r4) goto L_0x05d9
            r4 = 0
            if (r2 < 0) goto L_0x05ca
            r24 = r4
            r4 = 31
            if (r4 >= r2) goto L_0x05d5
            goto L_0x05cc
        L_0x05ca:
            r24 = r4
        L_0x05cc:
            r4 = 127(0x7f, float:1.78E-43)
            if (r4 <= r2) goto L_0x05d1
            goto L_0x05d7
        L_0x05d1:
            r4 = 159(0x9f, float:2.23E-43)
            if (r4 < r2) goto L_0x05d7
        L_0x05d5:
            r16 = r18
        L_0x05d7:
            if (r16 != 0) goto L_0x05de
        L_0x05d9:
            r4 = 65533(0xfffd, float:9.1831E-41)
            if (r2 != r4) goto L_0x05e0
        L_0x05de:
            r4 = -1
            return r4
        L_0x05e0:
            r4 = 65536(0x10000, float:9.18355E-41)
            if (r2 >= r4) goto L_0x05e6
            r17 = r18
        L_0x05e6:
            int r1 = r1 + r17
            r14 = r25
            goto L_0x06b3
        L_0x05ec:
            r21 = r4
            r4 = 55296(0xd800, float:7.7486E-41)
            if (r4 <= r3) goto L_0x05f4
            goto L_0x063b
        L_0x05f4:
            r4 = 57343(0xdfff, float:8.0355E-41)
            if (r4 < r3) goto L_0x063b
            r4 = 65533(0xfffd, float:9.1831E-41)
            r14 = 0
            r15 = r4
            r22 = 0
            int r25 = r2 + 1
            if (r2 != r0) goto L_0x0605
            return r1
        L_0x0605:
            r2 = 10
            if (r15 == r2) goto L_0x0628
            r2 = 13
            if (r15 == r2) goto L_0x0628
            r2 = 0
            if (r15 < 0) goto L_0x0619
            r24 = r2
            r2 = 31
            if (r2 >= r15) goto L_0x0624
            goto L_0x061b
        L_0x0619:
            r24 = r2
        L_0x061b:
            r2 = 127(0x7f, float:1.78E-43)
            if (r2 <= r15) goto L_0x0620
            goto L_0x0626
        L_0x0620:
            r2 = 159(0x9f, float:2.23E-43)
            if (r2 < r15) goto L_0x0626
        L_0x0624:
            r16 = r18
        L_0x0626:
            if (r16 != 0) goto L_0x062d
        L_0x0628:
            r2 = 65533(0xfffd, float:9.1831E-41)
            if (r15 != r2) goto L_0x062f
        L_0x062d:
            r2 = -1
            return r2
        L_0x062f:
            r2 = 65536(0x10000, float:9.18355E-41)
            if (r15 >= r2) goto L_0x0635
        L_0x0633:
            r17 = r18
        L_0x0635:
            int r1 = r1 + r17
            r14 = r25
            goto L_0x06b3
        L_0x063b:
            r4 = 65536(0x10000, float:9.18355E-41)
            if (r3 >= r4) goto L_0x067a
            r4 = 65533(0xfffd, float:9.1831E-41)
            r14 = 0
            r15 = r4
            r22 = 0
            int r25 = r2 + 1
            if (r2 != r0) goto L_0x064b
            return r1
        L_0x064b:
            r2 = 10
            if (r15 == r2) goto L_0x066e
            r2 = 13
            if (r15 == r2) goto L_0x066e
            r2 = 0
            if (r15 < 0) goto L_0x065f
            r24 = r2
            r2 = 31
            if (r2 >= r15) goto L_0x066a
            goto L_0x0661
        L_0x065f:
            r24 = r2
        L_0x0661:
            r2 = 127(0x7f, float:1.78E-43)
            if (r2 <= r15) goto L_0x0666
            goto L_0x066c
        L_0x0666:
            r2 = 159(0x9f, float:2.23E-43)
            if (r2 < r15) goto L_0x066c
        L_0x066a:
            r16 = r18
        L_0x066c:
            if (r16 != 0) goto L_0x0673
        L_0x066e:
            r2 = 65533(0xfffd, float:9.1831E-41)
            if (r15 != r2) goto L_0x0675
        L_0x0673:
            r2 = -1
            return r2
        L_0x0675:
            r2 = 65536(0x10000, float:9.18355E-41)
            if (r15 >= r2) goto L_0x0635
            goto L_0x0633
        L_0x067a:
            r4 = r3
            r14 = 0
            r15 = r4
            r22 = 0
            int r25 = r2 + 1
            if (r2 != r0) goto L_0x0684
            return r1
        L_0x0684:
            r2 = 10
            if (r15 == r2) goto L_0x06a7
            r2 = 13
            if (r15 == r2) goto L_0x06a7
            r2 = 0
            if (r15 < 0) goto L_0x0698
            r24 = r2
            r2 = 31
            if (r2 >= r15) goto L_0x06a3
            goto L_0x069a
        L_0x0698:
            r24 = r2
        L_0x069a:
            r2 = 127(0x7f, float:1.78E-43)
            if (r2 <= r15) goto L_0x069f
            goto L_0x06a5
        L_0x069f:
            r2 = 159(0x9f, float:2.23E-43)
            if (r2 < r15) goto L_0x06a5
        L_0x06a3:
            r16 = r18
        L_0x06a5:
            if (r16 != 0) goto L_0x06ac
        L_0x06a7:
            r2 = 65533(0xfffd, float:9.1831E-41)
            if (r15 != r2) goto L_0x06ae
        L_0x06ac:
            r2 = -1
            return r2
        L_0x06ae:
            r2 = 65536(0x10000, float:9.18355E-41)
            if (r15 >= r2) goto L_0x0635
            goto L_0x0633
        L_0x06b3:
            r17 = 4
        L_0x06b6:
            int r8 = r8 + r17
            r2 = r14
            goto L_0x06f4
        L_0x06ba:
            r3 = 65533(0xfffd, float:9.1831E-41)
            r4 = 0
            int r10 = r2 + 1
            if (r2 != r0) goto L_0x06c3
            return r1
        L_0x06c3:
            r2 = 10
            if (r3 == r2) goto L_0x06e1
            r2 = 13
            if (r3 == r2) goto L_0x06e1
            r2 = 0
            if (r3 < 0) goto L_0x06d4
            r11 = 31
            if (r11 >= r3) goto L_0x06dd
        L_0x06d4:
            r11 = 127(0x7f, float:1.78E-43)
            if (r11 <= r3) goto L_0x06d9
            goto L_0x06df
        L_0x06d9:
            r11 = 159(0x9f, float:2.23E-43)
            if (r11 < r3) goto L_0x06df
        L_0x06dd:
            r16 = r18
        L_0x06df:
            if (r16 != 0) goto L_0x06e6
        L_0x06e1:
            r2 = 65533(0xfffd, float:9.1831E-41)
            if (r3 != r2) goto L_0x06e8
        L_0x06e6:
            r2 = -1
            return r2
        L_0x06e8:
            r2 = 65536(0x10000, float:9.18355E-41)
            if (r3 >= r2) goto L_0x06ee
            r17 = r18
        L_0x06ee:
            int r1 = r1 + r17
            int r8 = r8 + 1
            r2 = r10
        L_0x06f4:
            r4 = r29
            r3 = r26
            goto L_0x000c
        L_0x06fb:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.ByteStringKt.codePointIndexToCharIndex(byte[], int):int");
    }
}
