package okio;

import com.google.firebase.messaging.Constants;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import okio.internal.BufferKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\rH\u0016J\b\u0010\u001e\u001a\u00020\u0001H\u0016J\u0018\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J(\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0016J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020'H\u0016J \u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020'2\u0006\u0010 \u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0016J\u0018\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0010\u0010(\u001a\u00020\u00122\u0006\u0010%\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0014H\u0016J\b\u0010+\u001a\u00020'H\u0016J\u0010\u0010+\u001a\u00020'2\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010,\u001a\u00020\u0018H\u0016J\u0010\u0010,\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010-\u001a\u00020\u0012H\u0016J\u0010\u0010.\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020'H\u0016J\u0018\u0010.\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010/\u001a\u00020\u0012H\u0016J\b\u00100\u001a\u00020\"H\u0016J\b\u00101\u001a\u00020\"H\u0016J\b\u00102\u001a\u00020\u0012H\u0016J\b\u00103\u001a\u00020\u0012H\u0016J\b\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u000205H\u0016J\u0010\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016J\u0018\u00107\u001a\u0002082\u0006\u0010#\u001a\u00020\u00122\u0006\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u000208H\u0016J\u0010\u0010;\u001a\u0002082\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010<\u001a\u00020\"H\u0016J\n\u0010=\u001a\u0004\u0018\u000108H\u0016J\b\u0010>\u001a\u000208H\u0016J\u0010\u0010>\u001a\u0002082\u0006\u0010?\u001a\u00020\u0012H\u0016J\u0010\u0010@\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0010\u0010A\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0010\u0010B\u001a\u00020\"2\u0006\u0010C\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u000208H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068Ö\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lokio/RealBufferedSource;", "Lokio/BufferedSource;", "source", "Lokio/Source;", "(Lokio/Source;)V", "buffer", "Lokio/Buffer;", "buffer$annotations", "()V", "getBuffer", "()Lokio/Buffer;", "bufferField", "closed", "", "close", "", "exhausted", "indexOf", "", "b", "", "fromIndex", "toIndex", "bytes", "Lokio/ByteString;", "indexOfElement", "targetBytes", "inputStream", "Ljava/io/InputStream;", "isOpen", "peek", "rangeEquals", "offset", "bytesOffset", "", "byteCount", "read", "sink", "Ljava/nio/ByteBuffer;", "", "readAll", "Lokio/Sink;", "readByte", "readByteArray", "readByteString", "readDecimalLong", "readFully", "readHexadecimalUnsignedLong", "readInt", "readIntLe", "readLong", "readLongLe", "readShort", "", "readShortLe", "readString", "", "charset", "Ljava/nio/charset/Charset;", "readUtf8", "readUtf8CodePoint", "readUtf8Line", "readUtf8LineStrict", "limit", "request", "require", "select", "options", "Lokio/Options;", "skip", "timeout", "Lokio/Timeout;", "toString", "okio"}, k = 1, mv = {1, 1, 16})
/* compiled from: RealBufferedSource.kt */
public final class RealBufferedSource implements BufferedSource {
    public final Buffer bufferField = new Buffer();
    public boolean closed;
    public final Source source;

    public static /* synthetic */ void buffer$annotations() {
    }

    public RealBufferedSource(Source source2) {
        Intrinsics.checkParameterIsNotNull(source2, Constants.ScionAnalytics.PARAM_SOURCE);
        this.source = source2;
    }

    public Buffer getBuffer() {
        return this.bufferField;
    }

    public Buffer buffer() {
        return this.bufferField;
    }

    public long read(Buffer sink, long byteCount) {
        Intrinsics.checkParameterIsNotNull(sink, "sink");
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        } else if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        } else if (this.bufferField.size() == 0 && this.source.read(this.bufferField, (long) 8192) == -1) {
            return -1;
        } else {
            return this.bufferField.read(sink, Math.min(byteCount, this.bufferField.size()));
        }
    }

    public boolean exhausted() {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        } else if (!this.bufferField.exhausted() || this.source.read(this.bufferField, (long) 8192) != -1) {
            return false;
        } else {
            return true;
        }
    }

    public void require(long byteCount) {
        if (!request(byteCount)) {
            throw new EOFException();
        }
    }

    public boolean request(long byteCount) {
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        } else if (!this.closed) {
            while (this.bufferField.size() < byteCount) {
                if (this.source.read(this.bufferField, (long) 8192) == -1) {
                    return false;
                }
            }
            return true;
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    public byte readByte() {
        require(1);
        return this.bufferField.readByte();
    }

    public ByteString readByteString() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteString();
    }

    public ByteString readByteString(long byteCount) {
        require(byteCount);
        return this.bufferField.readByteString(byteCount);
    }

    public int select(Options options) {
        Intrinsics.checkParameterIsNotNull(options, "options");
        if (!this.closed) {
            do {
                int index$iv = BufferKt.selectPrefix(this.bufferField, options, true);
                if (index$iv != -2) {
                    if (index$iv == -1) {
                        return -1;
                    }
                    this.bufferField.skip((long) options.getByteStrings$okio()[index$iv].size());
                    return index$iv;
                }
            } while (this.source.read(this.bufferField, (long) 8192) != -1);
            return -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    public byte[] readByteArray() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteArray();
    }

    public byte[] readByteArray(long byteCount) {
        require(byteCount);
        return this.bufferField.readByteArray(byteCount);
    }

    public int read(byte[] sink) {
        Intrinsics.checkParameterIsNotNull(sink, "sink");
        return read(sink, 0, sink.length);
    }

    public void readFully(byte[] sink) {
        Intrinsics.checkParameterIsNotNull(sink, "sink");
        try {
            require((long) sink.length);
            this.bufferField.readFully(sink);
        } catch (EOFException e$iv) {
            int offset$iv = 0;
            while (this.bufferField.size() > 0) {
                int read$iv = this.bufferField.read(sink, offset$iv, (int) this.bufferField.size());
                if (read$iv != -1) {
                    offset$iv += read$iv;
                } else {
                    throw new AssertionError();
                }
            }
            throw e$iv;
        }
    }

    public int read(byte[] sink, int offset, int byteCount) {
        Intrinsics.checkParameterIsNotNull(sink, "sink");
        Util.checkOffsetAndCount((long) sink.length, (long) offset, (long) byteCount);
        if (this.bufferField.size() == 0 && this.source.read(this.bufferField, (long) 8192) == -1) {
            return -1;
        }
        long j = (long) byteCount;
        return this.bufferField.read(sink, offset, (int) Math.min(j, this.bufferField.size()));
    }

    public int read(ByteBuffer sink) {
        Intrinsics.checkParameterIsNotNull(sink, "sink");
        if (this.bufferField.size() == 0 && this.source.read(this.bufferField, (long) 8192) == -1) {
            return -1;
        }
        return this.bufferField.read(sink);
    }

    public void readFully(Buffer sink, long byteCount) {
        Intrinsics.checkParameterIsNotNull(sink, "sink");
        try {
            require(byteCount);
            this.bufferField.readFully(sink, byteCount);
        } catch (EOFException e$iv) {
            sink.writeAll(this.bufferField);
            throw e$iv;
        }
    }

    public long readAll(Sink sink) {
        Intrinsics.checkParameterIsNotNull(sink, "sink");
        long totalBytesWritten$iv = 0;
        while (this.source.read(this.bufferField, (long) 8192) != -1) {
            long emitByteCount$iv = this.bufferField.completeSegmentByteCount();
            if (emitByteCount$iv > 0) {
                totalBytesWritten$iv += emitByteCount$iv;
                sink.write(this.bufferField, emitByteCount$iv);
            }
        }
        if (this.bufferField.size() <= 0) {
            return totalBytesWritten$iv;
        }
        long totalBytesWritten$iv2 = totalBytesWritten$iv + this.bufferField.size();
        sink.write(this.bufferField, this.bufferField.size());
        return totalBytesWritten$iv2;
    }

    public String readUtf8() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readUtf8();
    }

    public String readUtf8(long byteCount) {
        require(byteCount);
        return this.bufferField.readUtf8(byteCount);
    }

    public String readString(Charset charset) {
        Intrinsics.checkParameterIsNotNull(charset, "charset");
        this.bufferField.writeAll(this.source);
        return this.bufferField.readString(charset);
    }

    public String readString(long byteCount, Charset charset) {
        Intrinsics.checkParameterIsNotNull(charset, "charset");
        require(byteCount);
        return this.bufferField.readString(byteCount, charset);
    }

    public String readUtf8Line() {
        long newline$iv = indexOf((byte) 10);
        if (newline$iv != -1) {
            return BufferKt.readUtf8Line(this.bufferField, newline$iv);
        }
        if (this.bufferField.size() != 0) {
            return readUtf8(this.bufferField.size());
        }
        return null;
    }

    public String readUtf8LineStrict() {
        return readUtf8LineStrict(LongCompanionObject.MAX_VALUE);
    }

    public String readUtf8LineStrict(long limit) {
        long j = limit;
        if (j >= 0) {
            long scanLength$iv = j == LongCompanionObject.MAX_VALUE ? Long.MAX_VALUE : j + 1;
            byte b = (byte) 10;
            byte b2 = b;
            long newline$iv = indexOf(b, 0, scanLength$iv);
            if (newline$iv != -1) {
                return BufferKt.readUtf8Line(this.bufferField, newline$iv);
            }
            if (scanLength$iv < LongCompanionObject.MAX_VALUE && request(scanLength$iv) && this.bufferField.getByte(scanLength$iv - 1) == ((byte) 13) && request(1 + scanLength$iv) && this.bufferField.getByte(scanLength$iv) == b2) {
                return BufferKt.readUtf8Line(this.bufferField, scanLength$iv);
            }
            Buffer data$iv = new Buffer();
            this.bufferField.copyTo(data$iv, 0, Math.min((long) 32, this.bufferField.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.bufferField.size(), j) + " content=" + data$iv.readByteString().hex() + "…");
        }
        throw new IllegalArgumentException(("limit < 0: " + j).toString());
    }

    public int readUtf8CodePoint() {
        require(1);
        int b0$iv = this.bufferField.getByte(0);
        if ((b0$iv & 224) == 192) {
            require(2);
        } else if ((b0$iv & 240) == 224) {
            require(3);
        } else if ((b0$iv & 248) == 240) {
            require(4);
        }
        return this.bufferField.readUtf8CodePoint();
    }

    public short readShort() {
        require(2);
        return this.bufferField.readShort();
    }

    public short readShortLe() {
        require(2);
        return this.bufferField.readShortLe();
    }

    public int readInt() {
        require(4);
        return this.bufferField.readInt();
    }

    public int readIntLe() {
        require(4);
        return this.bufferField.readIntLe();
    }

    public long readLong() {
        require(8);
        return this.bufferField.readLong();
    }

    public long readLongLe() {
        require(8);
        return this.bufferField.readLongLe();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        if (r4 == 0) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0036, code lost:
        r2 = new java.lang.StringBuilder().append("Expected leading [0-9] or '-' character but was 0x");
        r3 = java.lang.Integer.toString(r6, kotlin.text.CharsKt.checkRadix(kotlin.text.CharsKt.checkRadix(16)));
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, "java.lang.Integer.toStri…(this, checkRadix(radix))");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0063, code lost:
        throw new java.lang.NumberFormatException(r2.append(r3).toString());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readDecimalLong() {
        /*
            r10 = this;
            r0 = r10
            r1 = 0
            r2 = 1
            r0.require(r2)
            r4 = 0
        L_0x0009:
            long r6 = r4 + r2
            boolean r6 = r0.request(r6)
            if (r6 == 0) goto L_0x0064
            r6 = r0
            r7 = 0
            okio.Buffer r6 = r6.bufferField
            byte r6 = r6.getByte(r4)
            r7 = 48
            byte r7 = (byte) r7
            if (r6 < r7) goto L_0x0023
            r7 = 57
            byte r7 = (byte) r7
            if (r6 <= r7) goto L_0x002f
        L_0x0023:
            r7 = 0
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x0031
            r9 = 45
            byte r9 = (byte) r9
            if (r6 == r9) goto L_0x002f
            goto L_0x0031
        L_0x002f:
            long r4 = r4 + r2
            goto L_0x0009
        L_0x0031:
            int r2 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r2 == 0) goto L_0x0036
            goto L_0x0064
        L_0x0036:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Expected leading [0-9] or '-' character but was 0x"
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = 16
            int r3 = kotlin.text.CharsKt.checkRadix(r3)
            int r3 = kotlin.text.CharsKt.checkRadix(r3)
            java.lang.String r3 = java.lang.Integer.toString(r6, r3)
            java.lang.String r7 = "java.lang.Integer.toStri…(this, checkRadix(radix))"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r7)
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.NumberFormatException r3 = new java.lang.NumberFormatException
            r3.<init>(r2)
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            throw r3
        L_0x0064:
            r2 = r0
            r3 = 0
            okio.Buffer r2 = r2.bufferField
            long r0 = r2.readDecimalLong()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.RealBufferedSource.readDecimalLong():long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readHexadecimalUnsignedLong() {
        /*
            r7 = this;
            r0 = r7
            r1 = 0
            r2 = 1
            r0.require(r2)
            r2 = 0
        L_0x0008:
            int r3 = r2 + 1
            long r3 = (long) r3
            boolean r3 = r0.request(r3)
            if (r3 == 0) goto L_0x0071
            r3 = r0
            r4 = 0
            okio.Buffer r3 = r3.bufferField
            long r4 = (long) r2
            byte r3 = r3.getByte(r4)
            r4 = 48
            byte r4 = (byte) r4
            if (r3 < r4) goto L_0x0027
            r4 = 57
            byte r4 = (byte) r4
            if (r3 <= r4) goto L_0x003c
        L_0x0027:
            r4 = 97
            byte r4 = (byte) r4
            if (r3 < r4) goto L_0x0031
            r4 = 102(0x66, float:1.43E-43)
            byte r4 = (byte) r4
            if (r3 <= r4) goto L_0x003c
        L_0x0031:
            r4 = 65
            byte r4 = (byte) r4
            if (r3 < r4) goto L_0x0040
            r4 = 70
            byte r4 = (byte) r4
            if (r3 <= r4) goto L_0x003c
            goto L_0x0040
        L_0x003c:
            int r2 = r2 + 1
            goto L_0x0008
        L_0x0040:
            if (r2 == 0) goto L_0x0043
            goto L_0x0071
        L_0x0043:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.StringBuilder r4 = r4.append(r5)
            r5 = 16
            int r5 = kotlin.text.CharsKt.checkRadix(r5)
            int r5 = kotlin.text.CharsKt.checkRadix(r5)
            java.lang.String r5 = java.lang.Integer.toString(r3, r5)
            java.lang.String r6 = "java.lang.Integer.toStri…(this, checkRadix(radix))"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r6)
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.NumberFormatException r5 = new java.lang.NumberFormatException
            r5.<init>(r4)
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            throw r5
        L_0x0071:
            r3 = r0
            r4 = 0
            okio.Buffer r3 = r3.bufferField
            long r0 = r3.readHexadecimalUnsignedLong()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.RealBufferedSource.readHexadecimalUnsignedLong():long");
    }

    public void skip(long byteCount) {
        long byteCount$iv = byteCount;
        if (!this.closed) {
            while (byteCount$iv > 0) {
                if (this.bufferField.size() == 0 && this.source.read(this.bufferField, (long) 8192) == -1) {
                    throw new EOFException();
                }
                long toSkip$iv = Math.min(byteCount$iv, this.bufferField.size());
                this.bufferField.skip(toSkip$iv);
                byteCount$iv -= toSkip$iv;
            }
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    public long indexOf(byte b) {
        return indexOf(b, 0, LongCompanionObject.MAX_VALUE);
    }

    public long indexOf(byte b, long fromIndex) {
        return indexOf(b, fromIndex, LongCompanionObject.MAX_VALUE);
    }

    public long indexOf(byte b, long fromIndex, long toIndex) {
        long j = toIndex;
        long fromIndex$iv = fromIndex;
        boolean z = true;
        if (!this.closed) {
            if (0 > fromIndex$iv || j < fromIndex$iv) {
                z = false;
            }
            if (z) {
                long fromIndex$iv2 = fromIndex$iv;
                while (fromIndex$iv2 < j) {
                    long result$iv = this.bufferField.indexOf(b, fromIndex$iv2, toIndex);
                    if (result$iv != -1) {
                        return result$iv;
                    }
                    long lastBufferSize$iv = this.bufferField.size();
                    if (lastBufferSize$iv >= j || this.source.read(this.bufferField, (long) 8192) == -1) {
                        return -1;
                    }
                    fromIndex$iv2 = Math.max(fromIndex$iv2, lastBufferSize$iv);
                }
                return -1;
            }
            throw new IllegalArgumentException(("fromIndex=" + fromIndex$iv + " toIndex=" + j).toString());
        }
        throw new IllegalStateException("closed".toString());
    }

    public long indexOf(ByteString bytes) {
        Intrinsics.checkParameterIsNotNull(bytes, "bytes");
        return indexOf(bytes, 0);
    }

    public long indexOf(ByteString bytes, long fromIndex) {
        ByteString byteString = bytes;
        Intrinsics.checkParameterIsNotNull(byteString, "bytes");
        long fromIndex$iv = fromIndex;
        if (!this.closed) {
            while (true) {
                long result$iv = this.bufferField.indexOf(byteString, fromIndex$iv);
                if (result$iv != -1) {
                    return result$iv;
                }
                long lastBufferSize$iv = this.bufferField.size();
                if (this.source.read(this.bufferField, (long) 8192) == -1) {
                    return -1;
                }
                fromIndex$iv = Math.max(fromIndex$iv, (lastBufferSize$iv - ((long) bytes.size())) + 1);
            }
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    public long indexOfElement(ByteString targetBytes) {
        Intrinsics.checkParameterIsNotNull(targetBytes, "targetBytes");
        return indexOfElement(targetBytes, 0);
    }

    public long indexOfElement(ByteString targetBytes, long fromIndex) {
        ByteString byteString = targetBytes;
        Intrinsics.checkParameterIsNotNull(byteString, "targetBytes");
        long fromIndex$iv = fromIndex;
        if (!this.closed) {
            while (true) {
                long result$iv = this.bufferField.indexOfElement(byteString, fromIndex$iv);
                if (result$iv != -1) {
                    return result$iv;
                }
                long lastBufferSize$iv = this.bufferField.size();
                if (this.source.read(this.bufferField, (long) 8192) == -1) {
                    return -1;
                }
                fromIndex$iv = Math.max(fromIndex$iv, lastBufferSize$iv);
            }
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    public boolean rangeEquals(long offset, ByteString bytes) {
        Intrinsics.checkParameterIsNotNull(bytes, "bytes");
        return rangeEquals(offset, bytes, 0, bytes.size());
    }

    public boolean rangeEquals(long offset, ByteString bytes, int bytesOffset, int byteCount) {
        Intrinsics.checkParameterIsNotNull(bytes, "bytes");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        } else if (offset < 0 || bytesOffset < 0 || byteCount < 0 || bytes.size() - bytesOffset < byteCount) {
            return false;
        } else {
            for (int i$iv = 0; i$iv < byteCount; i$iv++) {
                long bufferOffset$iv = ((long) i$iv) + offset;
                if (!request(1 + bufferOffset$iv)) {
                    return false;
                }
                if (this.bufferField.getByte(bufferOffset$iv) != bytes.getByte(bytesOffset + i$iv)) {
                    return false;
                }
            }
            return true;
        }
    }

    public BufferedSource peek() {
        return Okio.buffer((Source) new PeekSource(this));
    }

    public InputStream inputStream() {
        return new RealBufferedSource$inputStream$1(this);
    }

    public boolean isOpen() {
        return !this.closed;
    }

    public void close() {
        if (!this.closed) {
            this.closed = true;
            this.source.close();
            this.bufferField.clear();
        }
    }

    public Timeout timeout() {
        return this.source.timeout();
    }

    public String toString() {
        return "buffer(" + this.source + ')';
    }
}
