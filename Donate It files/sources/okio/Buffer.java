package okio;

import com.google.firebase.messaging.Constants;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.UByte;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.Typography;
import okhttp3.internal.connection.RealConnection;
import okio.internal.BufferKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u0001B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0000H\u0016J\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0000H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\u0006\u0010\u0015\u001a\u00020\fJ\u0006\u0010\u0016\u001a\u00020\u0000J$\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\fH\u0007J\u0018\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\fJ \u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u0000H\u0016J\b\u0010!\u001a\u00020\u0000H\u0016J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\b\u0010&\u001a\u00020#H\u0016J\b\u0010'\u001a\u00020\u0012H\u0016J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\fH\u0002¢\u0006\u0002\b+J\u0015\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\fH\u0007¢\u0006\u0002\b-J\b\u0010.\u001a\u00020/H\u0016J\u0018\u00100\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u001dH\u0002J\u000e\u00102\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dJ\u000e\u00103\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dJ\u000e\u00104\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dJ\u0010\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020)H\u0016J\u0018\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020\fH\u0016J \u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020\f2\u0006\u00108\u001a\u00020\fH\u0016J\u0010\u00105\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001dH\u0016J\u0018\u00105\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\fH\u0016J\u0010\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u001dH\u0016J\u0018\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\fH\u0016J\b\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020#H\u0016J\u0006\u0010?\u001a\u00020\u001dJ\b\u0010@\u001a\u00020\u0019H\u0016J\b\u0010A\u001a\u00020\u0001H\u0016J\u0018\u0010B\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001dH\u0016J(\u0010B\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0010\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020FH\u0016J\u0010\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020GH\u0016J \u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020G2\u0006\u0010\u001a\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0018\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010H\u001a\u00020\f2\u0006\u0010E\u001a\u00020IH\u0016J\u0012\u0010J\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020KH\u0007J\b\u0010M\u001a\u00020)H\u0016J\b\u0010N\u001a\u00020GH\u0016J\u0010\u0010N\u001a\u00020G2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010O\u001a\u00020\u001dH\u0016J\u0010\u0010O\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010P\u001a\u00020\fH\u0016J\u000e\u0010Q\u001a\u00020\u00002\u0006\u0010R\u001a\u00020=J\u0016\u0010Q\u001a\u00020\u00002\u0006\u0010R\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020\fJ \u0010Q\u001a\u00020\u00122\u0006\u0010R\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010S\u001a\u00020#H\u0002J\u0010\u0010T\u001a\u00020\u00122\u0006\u0010E\u001a\u00020GH\u0016J\u0018\u0010T\u001a\u00020\u00122\u0006\u0010E\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010U\u001a\u00020\fH\u0016J\b\u0010V\u001a\u00020/H\u0016J\b\u0010W\u001a\u00020/H\u0016J\b\u0010X\u001a\u00020\fH\u0016J\b\u0010Y\u001a\u00020\fH\u0016J\b\u0010Z\u001a\u00020[H\u0016J\b\u0010\\\u001a\u00020[H\u0016J\u0010\u0010]\u001a\u00020\u001f2\u0006\u0010^\u001a\u00020_H\u0016J\u0018\u0010]\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010^\u001a\u00020_H\u0016J\u0012\u0010`\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020KH\u0007J\b\u0010a\u001a\u00020\u001fH\u0016J\u0010\u0010a\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010b\u001a\u00020/H\u0016J\n\u0010c\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010d\u001a\u00020\u001fH\u0016J\u0010\u0010d\u001a\u00020\u001f2\u0006\u0010e\u001a\u00020\fH\u0016J\u0010\u0010f\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010g\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010h\u001a\u00020/2\u0006\u0010i\u001a\u00020jH\u0016J\u0006\u0010k\u001a\u00020\u001dJ\u0006\u0010l\u001a\u00020\u001dJ\u0006\u0010m\u001a\u00020\u001dJ\r\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0002\bnJ\u0010\u0010o\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0006\u0010p\u001a\u00020\u001dJ\u000e\u0010p\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020/J\b\u0010q\u001a\u00020rH\u0016J\b\u0010s\u001a\u00020\u001fH\u0016J\u0015\u0010t\u001a\u00020\n2\u0006\u0010u\u001a\u00020/H\u0000¢\u0006\u0002\bvJ\u0010\u0010w\u001a\u00020/2\u0006\u0010x\u001a\u00020FH\u0016J\u0010\u0010w\u001a\u00020\u00002\u0006\u0010x\u001a\u00020GH\u0016J \u0010w\u001a\u00020\u00002\u0006\u0010x\u001a\u00020G2\u0006\u0010\u001a\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0018\u0010w\u001a\u00020\u00122\u0006\u0010x\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010w\u001a\u00020\u00002\u0006\u0010y\u001a\u00020\u001dH\u0016J \u0010w\u001a\u00020\u00002\u0006\u0010y\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0018\u0010w\u001a\u00020\u00002\u0006\u0010x\u001a\u00020z2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010{\u001a\u00020\f2\u0006\u0010x\u001a\u00020zH\u0016J\u0010\u0010|\u001a\u00020\u00002\u0006\u00106\u001a\u00020/H\u0016J\u0010\u0010}\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\fH\u0016J\u0010\u0010\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\fH\u0016J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020/H\u0016J\u0011\u0010\u0001\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\fH\u0016J\u0011\u0010\u0001\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\fH\u0016J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020/H\u0016J\u001a\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u001f2\u0006\u0010^\u001a\u00020_H\u0016J,\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u001f2\u0007\u0010\u0001\u001a\u00020/2\u0007\u0010\u0001\u001a\u00020/2\u0006\u0010^\u001a\u00020_H\u0016J\u001b\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\fH\u0007J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u001fH\u0016J$\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u001f2\u0007\u0010\u0001\u001a\u00020/2\u0007\u0010\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020/H\u0016R\u0014\u0010\u0006\u001a\u00020\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0000@\u0000X\u000e¢\u0006\u0002\n\u0000R&\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8G@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0001"}, d2 = {"Lokio/Buffer;", "Lokio/BufferedSource;", "Lokio/BufferedSink;", "", "Ljava/nio/channels/ByteChannel;", "()V", "buffer", "getBuffer", "()Lokio/Buffer;", "head", "Lokio/Segment;", "<set-?>", "", "size", "()J", "setSize$okio", "(J)V", "clear", "", "clone", "close", "completeSegmentByteCount", "copy", "copyTo", "out", "Ljava/io/OutputStream;", "offset", "byteCount", "digest", "Lokio/ByteString;", "algorithm", "", "emit", "emitCompleteSegments", "equals", "", "other", "", "exhausted", "flush", "get", "", "pos", "getByte", "index", "-deprecated_getByte", "hashCode", "", "hmac", "key", "hmacSha1", "hmacSha256", "hmacSha512", "indexOf", "b", "fromIndex", "toIndex", "bytes", "indexOfElement", "targetBytes", "inputStream", "Ljava/io/InputStream;", "isOpen", "md5", "outputStream", "peek", "rangeEquals", "bytesOffset", "read", "sink", "Ljava/nio/ByteBuffer;", "", "readAll", "Lokio/Sink;", "readAndWriteUnsafe", "Lokio/Buffer$UnsafeCursor;", "unsafeCursor", "readByte", "readByteArray", "readByteString", "readDecimalLong", "readFrom", "input", "forever", "readFully", "readHexadecimalUnsignedLong", "readInt", "readIntLe", "readLong", "readLongLe", "readShort", "", "readShortLe", "readString", "charset", "Ljava/nio/charset/Charset;", "readUnsafe", "readUtf8", "readUtf8CodePoint", "readUtf8Line", "readUtf8LineStrict", "limit", "request", "require", "select", "options", "Lokio/Options;", "sha1", "sha256", "sha512", "-deprecated_size", "skip", "snapshot", "timeout", "Lokio/Timeout;", "toString", "writableSegment", "minimumCapacity", "writableSegment$okio", "write", "source", "byteString", "Lokio/Source;", "writeAll", "writeByte", "writeDecimalLong", "v", "writeHexadecimalUnsignedLong", "writeInt", "i", "writeIntLe", "writeLong", "writeLongLe", "writeShort", "s", "writeShortLe", "writeString", "string", "beginIndex", "endIndex", "writeTo", "writeUtf8", "writeUtf8CodePoint", "codePoint", "UnsafeCursor", "okio"}, k = 1, mv = {1, 1, 16})
/* compiled from: Buffer.kt */
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    public Segment head;
    private long size;

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, Buffer buffer2, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        return buffer.copyTo(buffer2, j);
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, Buffer buffer2, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        return buffer.copyTo(buffer2, j, j2);
    }

    public final Buffer copyTo(OutputStream outputStream) throws IOException {
        return copyTo$default(this, outputStream, 0, 0, 6, (Object) null);
    }

    public final Buffer copyTo(OutputStream outputStream, long j) throws IOException {
        return copyTo$default(this, outputStream, j, 0, 4, (Object) null);
    }

    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe$default(this, (UnsafeCursor) null, 1, (Object) null);
    }

    public final UnsafeCursor readUnsafe() {
        return readUnsafe$default(this, (UnsafeCursor) null, 1, (Object) null);
    }

    public final Buffer writeTo(OutputStream outputStream) throws IOException {
        return writeTo$default(this, outputStream, 0, 2, (Object) null);
    }

    public final void setSize$okio(long j) {
        this.size = j;
    }

    public final long size() {
        return this.size;
    }

    public Buffer buffer() {
        return this;
    }

    public Buffer getBuffer() {
        return this;
    }

    public OutputStream outputStream() {
        return new Buffer$outputStream$1(this);
    }

    public Buffer emitCompleteSegments() {
        return this;
    }

    public Buffer emit() {
        return this;
    }

    public boolean exhausted() {
        return this.size == 0;
    }

    public void require(long byteCount) throws EOFException {
        if (this.size < byteCount) {
            throw new EOFException();
        }
    }

    public boolean request(long byteCount) {
        return this.size >= byteCount;
    }

    public BufferedSource peek() {
        return Okio.buffer((Source) new PeekSource(this));
    }

    public InputStream inputStream() {
        return new Buffer$inputStream$1(this);
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, OutputStream outputStream, long j, long j2, int i, Object obj) throws IOException {
        long j3;
        long j4 = (i & 2) != 0 ? 0 : j;
        if ((i & 4) != 0) {
            j3 = buffer.size - j4;
        } else {
            j3 = j2;
        }
        return buffer.copyTo(outputStream, j4, j3);
    }

    public final Buffer copyTo(OutputStream out, long offset, long byteCount) throws IOException {
        OutputStream outputStream = out;
        Intrinsics.checkParameterIsNotNull(out, "out");
        long offset2 = offset;
        long byteCount2 = byteCount;
        Util.checkOffsetAndCount(this.size, offset2, byteCount2);
        if (byteCount2 == 0) {
            return this;
        }
        Segment s = this.head;
        while (true) {
            if (s == null) {
                Intrinsics.throwNpe();
            }
            if (offset2 < ((long) (s.limit - s.pos))) {
                break;
            }
            offset2 -= (long) (s.limit - s.pos);
            s = s.next;
        }
        while (byteCount2 > 0) {
            if (s == null) {
                Intrinsics.throwNpe();
            }
            int pos = (int) (((long) s.pos) + offset2);
            int toCopy = (int) Math.min((long) (s.limit - pos), byteCount2);
            out.write(s.data, pos, toCopy);
            byteCount2 -= (long) toCopy;
            offset2 = 0;
            s = s.next;
        }
        return this;
    }

    public final Buffer copyTo(Buffer out, long offset, long byteCount) {
        Buffer buffer = out;
        Intrinsics.checkParameterIsNotNull(out, "out");
        long offset$iv = offset;
        long byteCount$iv = byteCount;
        Util.checkOffsetAndCount(size(), offset$iv, byteCount$iv);
        if (byteCount$iv != 0) {
            out.setSize$okio(out.size() + byteCount$iv);
            Segment s$iv = this.head;
            while (true) {
                if (s$iv == null) {
                    Intrinsics.throwNpe();
                }
                if (offset$iv < ((long) (s$iv.limit - s$iv.pos))) {
                    break;
                }
                offset$iv -= (long) (s$iv.limit - s$iv.pos);
                s$iv = s$iv.next;
            }
            while (byteCount$iv > 0) {
                if (s$iv == null) {
                    Intrinsics.throwNpe();
                }
                Segment copy$iv = s$iv.sharedCopy();
                copy$iv.pos += (int) offset$iv;
                copy$iv.limit = Math.min(copy$iv.pos + ((int) byteCount$iv), copy$iv.limit);
                Segment segment = buffer.head;
                if (segment == null) {
                    copy$iv.prev = copy$iv;
                    copy$iv.next = copy$iv.prev;
                    buffer.head = copy$iv.next;
                } else {
                    if (segment == null) {
                        Intrinsics.throwNpe();
                    }
                    Segment segment2 = segment.prev;
                    if (segment2 == null) {
                        Intrinsics.throwNpe();
                    }
                    segment2.push(copy$iv);
                }
                byteCount$iv -= (long) (copy$iv.limit - copy$iv.pos);
                offset$iv = 0;
                s$iv = s$iv.next;
            }
        }
        return this;
    }

    public final Buffer copyTo(Buffer out, long offset) {
        Intrinsics.checkParameterIsNotNull(out, "out");
        return copyTo(out, offset, this.size - offset);
    }

    public static /* synthetic */ Buffer writeTo$default(Buffer buffer, OutputStream outputStream, long j, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            j = buffer.size;
        }
        return buffer.writeTo(outputStream, j);
    }

    public final Buffer writeTo(OutputStream out, long byteCount) throws IOException {
        Intrinsics.checkParameterIsNotNull(out, "out");
        long byteCount2 = byteCount;
        Util.checkOffsetAndCount(this.size, 0, byteCount2);
        Segment s = this.head;
        while (byteCount2 > 0) {
            if (s == null) {
                Intrinsics.throwNpe();
            }
            int toCopy = (int) Math.min(byteCount2, (long) (s.limit - s.pos));
            out.write(s.data, s.pos, toCopy);
            s.pos += toCopy;
            this.size -= (long) toCopy;
            byteCount2 -= (long) toCopy;
            if (s.pos == s.limit) {
                Segment toRecycle = s;
                s = toRecycle.pop();
                this.head = s;
                SegmentPool.INSTANCE.recycle(toRecycle);
            }
        }
        return this;
    }

    public final Buffer readFrom(InputStream input) throws IOException {
        Intrinsics.checkParameterIsNotNull(input, "input");
        readFrom(input, LongCompanionObject.MAX_VALUE, true);
        return this;
    }

    public final Buffer readFrom(InputStream input, long byteCount) throws IOException {
        Intrinsics.checkParameterIsNotNull(input, "input");
        if (byteCount >= 0) {
            readFrom(input, byteCount, false);
            return this;
        }
        throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
    }

    private final void readFrom(InputStream input, long byteCount, boolean forever) throws IOException {
        long byteCount2 = byteCount;
        while (true) {
            if (byteCount2 > 0 || forever) {
                Segment tail = writableSegment$okio(1);
                int bytesRead = input.read(tail.data, tail.limit, (int) Math.min(byteCount2, (long) (8192 - tail.limit)));
                if (bytesRead == -1) {
                    if (tail.pos == tail.limit) {
                        this.head = tail.pop();
                        SegmentPool.INSTANCE.recycle(tail);
                    }
                    if (!forever) {
                        throw new EOFException();
                    }
                    return;
                }
                tail.limit += bytesRead;
                this.size += (long) bytesRead;
                byteCount2 -= (long) bytesRead;
            } else {
                return;
            }
        }
    }

    public final long completeSegmentByteCount() {
        long result$iv = size();
        if (result$iv == 0) {
            return 0;
        }
        Segment segment = this.head;
        if (segment == null) {
            Intrinsics.throwNpe();
        }
        Segment tail$iv = segment.prev;
        if (tail$iv == null) {
            Intrinsics.throwNpe();
        }
        if (tail$iv.limit < 8192 && tail$iv.owner) {
            result$iv -= (long) (tail$iv.limit - tail$iv.pos);
        }
        return result$iv;
    }

    public byte readByte() throws EOFException {
        if (size() != 0) {
            Segment segment$iv = this.head;
            if (segment$iv == null) {
                Intrinsics.throwNpe();
            }
            int pos$iv = segment$iv.pos;
            int limit$iv = segment$iv.limit;
            int pos$iv2 = pos$iv + 1;
            byte b$iv = segment$iv.data[pos$iv];
            setSize$okio(size() - 1);
            if (pos$iv2 == limit$iv) {
                this.head = segment$iv.pop();
                SegmentPool.INSTANCE.recycle(segment$iv);
            } else {
                segment$iv.pos = pos$iv2;
            }
            return b$iv;
        }
        throw new EOFException();
    }

    public final byte getByte(long pos) {
        Util.checkOffsetAndCount(size(), pos, 1);
        Segment s$iv$iv = this.head;
        if (s$iv$iv == null) {
            Segment s$iv = null;
            Intrinsics.throwNpe();
            return s$iv.data[(int) ((((long) s$iv.pos) + pos) - -1)];
        } else if (size() - pos < pos) {
            long offset$iv$iv = size();
            while (offset$iv$iv > pos) {
                Segment segment = s$iv$iv.prev;
                if (segment == null) {
                    Intrinsics.throwNpe();
                }
                s$iv$iv = segment;
                offset$iv$iv -= (long) (s$iv$iv.limit - s$iv$iv.pos);
            }
            Segment s$iv2 = s$iv$iv;
            long offset$iv = offset$iv$iv;
            if (s$iv2 == null) {
                Intrinsics.throwNpe();
            }
            return s$iv2.data[(int) ((((long) s$iv2.pos) + pos) - offset$iv)];
        } else {
            long offset$iv$iv2 = 0;
            while (true) {
                long nextOffset$iv$iv = ((long) (s$iv$iv.limit - s$iv$iv.pos)) + offset$iv$iv2;
                if (nextOffset$iv$iv > pos) {
                    break;
                }
                Segment s$iv3 = s$iv$iv.next;
                if (s$iv3 == null) {
                    Intrinsics.throwNpe();
                }
                s$iv$iv = s$iv3;
                offset$iv$iv2 = nextOffset$iv$iv;
            }
            Segment s$iv4 = s$iv$iv;
            long offset$iv2 = offset$iv$iv2;
            if (s$iv4 == null) {
                Intrinsics.throwNpe();
            }
            return s$iv4.data[(int) ((((long) s$iv4.pos) + pos) - offset$iv2)];
        }
    }

    public short readShort() throws EOFException {
        if (size() >= 2) {
            Segment segment$iv = this.head;
            if (segment$iv == null) {
                Intrinsics.throwNpe();
            }
            int pos$iv = segment$iv.pos;
            int limit$iv = segment$iv.limit;
            if (limit$iv - pos$iv < 2) {
                return (short) (((readByte() & UByte.MAX_VALUE) << 8) | (readByte() & 255));
            }
            byte[] data$iv = segment$iv.data;
            int pos$iv2 = pos$iv + 1;
            int pos$iv3 = pos$iv2 + 1;
            int s$iv = ((data$iv[pos$iv] & UByte.MAX_VALUE) << 8) | (data$iv[pos$iv2] & 255);
            setSize$okio(size() - 2);
            if (pos$iv3 == limit$iv) {
                this.head = segment$iv.pop();
                SegmentPool.INSTANCE.recycle(segment$iv);
            } else {
                segment$iv.pos = pos$iv3;
            }
            return (short) s$iv;
        }
        throw new EOFException();
    }

    public int readInt() throws EOFException {
        if (size() >= 4) {
            Segment segment$iv = this.head;
            if (segment$iv == null) {
                Intrinsics.throwNpe();
            }
            int pos$iv = segment$iv.pos;
            int limit$iv = segment$iv.limit;
            if (((long) (limit$iv - pos$iv)) < 4) {
                return ((readByte() & UByte.MAX_VALUE) << 24) | ((readByte() & UByte.MAX_VALUE) << 16) | ((readByte() & UByte.MAX_VALUE) << 8) | (readByte() & UByte.MAX_VALUE);
            }
            byte[] data$iv = segment$iv.data;
            int pos$iv2 = pos$iv + 1;
            int pos$iv3 = pos$iv2 + 1;
            int i = ((data$iv[pos$iv] & UByte.MAX_VALUE) << 24) | ((data$iv[pos$iv2] & UByte.MAX_VALUE) << 16);
            int pos$iv4 = pos$iv3 + 1;
            int i2 = i | ((data$iv[pos$iv3] & UByte.MAX_VALUE) << 8);
            int pos$iv5 = pos$iv4 + 1;
            int i$iv = i2 | (data$iv[pos$iv4] & 255);
            setSize$okio(size() - 4);
            if (pos$iv5 == limit$iv) {
                this.head = segment$iv.pop();
                SegmentPool.INSTANCE.recycle(segment$iv);
            } else {
                segment$iv.pos = pos$iv5;
            }
            return i$iv;
        }
        throw new EOFException();
    }

    public long readLong() throws EOFException {
        if (size() >= 8) {
            Segment segment$iv = this.head;
            if (segment$iv == null) {
                Intrinsics.throwNpe();
            }
            int pos$iv = segment$iv.pos;
            int limit$iv = segment$iv.limit;
            if (((long) (limit$iv - pos$iv)) < 8) {
                return ((((long) readInt()) & 4294967295L) << 32) | (((long) readInt()) & 4294967295L);
            }
            byte[] data$iv = segment$iv.data;
            int pos$iv2 = pos$iv + 1;
            int pos$iv3 = pos$iv2 + 1;
            long j = (((long) data$iv[pos$iv2]) & 255) << 48;
            int pos$iv4 = pos$iv3 + 1;
            int pos$iv5 = pos$iv4 + 1;
            int pos$iv6 = pos$iv5 + 1;
            int pos$iv7 = pos$iv6 + 1;
            long j2 = j | ((255 & ((long) data$iv[pos$iv])) << 56) | ((255 & ((long) data$iv[pos$iv3])) << 40) | ((((long) data$iv[pos$iv4]) & 255) << 32) | ((255 & ((long) data$iv[pos$iv5])) << 24) | ((((long) data$iv[pos$iv6]) & 255) << 16);
            int pos$iv8 = pos$iv7 + 1;
            int pos$iv9 = pos$iv8 + 1;
            long v$iv = j2 | ((255 & ((long) data$iv[pos$iv7])) << 8) | (((long) data$iv[pos$iv8]) & 255);
            setSize$okio(size() - 8);
            if (pos$iv9 == limit$iv) {
                this.head = segment$iv.pop();
                SegmentPool.INSTANCE.recycle(segment$iv);
            } else {
                segment$iv.pos = pos$iv9;
            }
            return v$iv;
        }
        throw new EOFException();
    }

    public short readShortLe() throws EOFException {
        return Util.reverseBytes(readShort());
    }

    public int readIntLe() throws EOFException {
        return Util.reverseBytes(readInt());
    }

    public long readLongLe() throws EOFException {
        return Util.reverseBytes(readLong());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00d7, code lost:
        if (r11 != r12) goto L_0x00e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00d9, code lost:
        r1 = r15;
        r1.head = r9.pop();
        okio.SegmentPool.INSTANCE.recycle(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00e6, code lost:
        r1 = r15;
        r9.pos = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ea, code lost:
        if (r6 != false) goto L_0x00f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ee, code lost:
        if (r1.head != null) goto L_0x00f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00f6, code lost:
        r1.setSize$okio(r1.size() - ((long) r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ff, code lost:
        if (r5 == false) goto L_0x0102;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        return -r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readDecimalLong() throws java.io.EOFException {
        /*
            r19 = this;
            r0 = r19
            r1 = 0
            long r2 = r0.size()
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0105
            r2 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = -7
        L_0x0014:
            okio.Segment r9 = r0.head
            if (r9 != 0) goto L_0x001c
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x001c:
            byte[] r10 = r9.data
            int r11 = r9.pos
            int r12 = r9.limit
        L_0x0022:
            if (r11 >= r12) goto L_0x00d0
            byte r13 = r10[r11]
            r14 = 48
            byte r14 = (byte) r14
            if (r13 < r14) goto L_0x008c
            r15 = 57
            byte r15 = (byte) r15
            if (r13 > r15) goto L_0x008c
            int r14 = r14 - r13
            r15 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r17 = (r2 > r15 ? 1 : (r2 == r15 ? 0 : -1))
            if (r17 < 0) goto L_0x0054
            int r15 = (r2 > r15 ? 1 : (r2 == r15 ? 0 : -1))
            if (r15 != 0) goto L_0x0047
            r15 = r0
            r16 = r1
            long r0 = (long) r14
            int r0 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r0 >= 0) goto L_0x004a
            goto L_0x0057
        L_0x0047:
            r15 = r0
            r16 = r1
        L_0x004a:
            r0 = 10
            long r2 = r2 * r0
            long r0 = (long) r14
            long r2 = r2 + r0
            r17 = r6
            r18 = r10
            goto L_0x009e
        L_0x0054:
            r15 = r0
            r16 = r1
        L_0x0057:
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            okio.Buffer r0 = r0.writeDecimalLong((long) r2)
            okio.Buffer r0 = r0.writeByte((int) r13)
            if (r5 != 0) goto L_0x0069
            r0.readByte()
        L_0x0069:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            r17 = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r18 = r10
            java.lang.String r10 = "Number too large: "
            java.lang.StringBuilder r6 = r6.append(r10)
            java.lang.String r10 = r0.readUtf8()
            java.lang.StringBuilder r6 = r6.append(r10)
            java.lang.String r6 = r6.toString()
            r1.<init>(r6)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x008c:
            r15 = r0
            r16 = r1
            r17 = r6
            r18 = r10
            r0 = 45
            byte r0 = (byte) r0
            if (r13 != r0) goto L_0x00ac
            if (r4 != 0) goto L_0x00ac
            r5 = 1
            r0 = 1
            long r7 = r7 - r0
        L_0x009e:
            int r11 = r11 + 1
            int r4 = r4 + 1
            r0 = r15
            r1 = r16
            r6 = r17
            r10 = r18
            goto L_0x0022
        L_0x00ac:
            if (r4 == 0) goto L_0x00b1
            r0 = 1
            r6 = r0
            goto L_0x00d7
        L_0x00b1:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r6 = "Expected leading [0-9] or '-' character but was 0x"
            java.lang.StringBuilder r1 = r1.append(r6)
            java.lang.String r6 = okio.Util.toHexString((byte) r13)
            java.lang.StringBuilder r1 = r1.append(r6)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x00d0:
            r15 = r0
            r16 = r1
            r17 = r6
            r18 = r10
        L_0x00d7:
            if (r11 != r12) goto L_0x00e6
            okio.Segment r0 = r9.pop()
            r1 = r15
            r1.head = r0
            okio.SegmentPool r0 = okio.SegmentPool.INSTANCE
            r0.recycle(r9)
            goto L_0x00e9
        L_0x00e6:
            r1 = r15
            r9.pos = r11
        L_0x00e9:
            if (r6 != 0) goto L_0x00f6
            okio.Segment r0 = r1.head
            if (r0 != 0) goto L_0x00f1
            goto L_0x00f6
        L_0x00f1:
            r0 = r1
            r1 = r16
            goto L_0x0014
        L_0x00f6:
            long r9 = r1.size()
            long r11 = (long) r4
            long r9 = r9 - r11
            r1.setSize$okio(r9)
            if (r5 == 0) goto L_0x0102
            goto L_0x0104
        L_0x0102:
            long r9 = -r2
            r2 = r9
        L_0x0104:
            return r2
        L_0x0105:
            r16 = r1
            r1 = r0
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readDecimalLong():long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ae A[EDGE_INSN: B:48:0x00ae->B:32:0x00ae ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0016  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readHexadecimalUnsignedLong() throws java.io.EOFException {
        /*
            r16 = this;
            r0 = r16
            r1 = 0
            long r2 = r0.size()
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x00d0
            r2 = 0
            r6 = 0
            r7 = 0
        L_0x0011:
            okio.Segment r8 = r0.head
            if (r8 != 0) goto L_0x0019
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0019:
            byte[] r9 = r8.data
            int r10 = r8.pos
            int r11 = r8.limit
        L_0x001f:
            if (r10 >= r11) goto L_0x00ae
            r12 = 0
            byte r13 = r9[r10]
            r14 = 48
            byte r14 = (byte) r14
            if (r13 < r14) goto L_0x0031
            r15 = 57
            byte r15 = (byte) r15
            if (r13 > r15) goto L_0x0031
            int r12 = r13 - r14
            goto L_0x004e
        L_0x0031:
            r14 = 97
            byte r14 = (byte) r14
            if (r13 < r14) goto L_0x0040
            r15 = 102(0x66, float:1.43E-43)
            byte r15 = (byte) r15
            if (r13 > r15) goto L_0x0040
            int r14 = r13 - r14
            int r12 = r14 + 10
            goto L_0x004e
        L_0x0040:
            r14 = 65
            byte r14 = (byte) r14
            if (r13 < r14) goto L_0x008b
            r15 = 70
            byte r15 = (byte) r15
            if (r13 > r15) goto L_0x008b
            int r14 = r13 - r14
            int r12 = r14 + 10
        L_0x004e:
            r14 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r14 = r14 & r2
            int r14 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r14 != 0) goto L_0x005f
            r14 = 4
            long r2 = r2 << r14
            long r14 = (long) r12
            long r2 = r2 | r14
            int r10 = r10 + 1
            int r6 = r6 + 1
            goto L_0x001f
        L_0x005f:
            okio.Buffer r4 = new okio.Buffer
            r4.<init>()
            okio.Buffer r4 = r4.writeHexadecimalUnsignedLong((long) r2)
            okio.Buffer r4 = r4.writeByte((int) r13)
            java.lang.NumberFormatException r5 = new java.lang.NumberFormatException
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "Number too large: "
            java.lang.StringBuilder r14 = r14.append(r15)
            java.lang.String r15 = r4.readUtf8()
            java.lang.StringBuilder r14 = r14.append(r15)
            java.lang.String r14 = r14.toString()
            r5.<init>(r14)
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            throw r5
        L_0x008b:
            if (r6 == 0) goto L_0x008f
            r7 = 1
            goto L_0x00ae
        L_0x008f:
            java.lang.NumberFormatException r4 = new java.lang.NumberFormatException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r14 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.StringBuilder r5 = r5.append(r14)
            java.lang.String r14 = okio.Util.toHexString((byte) r13)
            java.lang.StringBuilder r5 = r5.append(r14)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            throw r4
        L_0x00ae:
            if (r10 != r11) goto L_0x00bc
            okio.Segment r12 = r8.pop()
            r0.head = r12
            okio.SegmentPool r12 = okio.SegmentPool.INSTANCE
            r12.recycle(r8)
            goto L_0x00be
        L_0x00bc:
            r8.pos = r10
        L_0x00be:
            if (r7 != 0) goto L_0x00c5
            okio.Segment r12 = r0.head
            if (r12 != 0) goto L_0x0011
        L_0x00c5:
            long r4 = r0.size()
            long r8 = (long) r6
            long r4 = r4 - r8
            r0.setSize$okio(r4)
            return r2
        L_0x00d0:
            java.io.EOFException r2 = new java.io.EOFException
            r2.<init>()
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readHexadecimalUnsignedLong():long");
    }

    public ByteString readByteString() {
        return readByteString(size());
    }

    public ByteString readByteString(long byteCount) throws EOFException {
        if (!(byteCount >= 0 && byteCount <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + byteCount).toString());
        } else if (size() < byteCount) {
            throw new EOFException();
        } else if (byteCount < ((long) 4096)) {
            return new ByteString(readByteArray(byteCount));
        } else {
            ByteString snapshot = snapshot((int) byteCount);
            ByteString byteString = snapshot;
            skip(byteCount);
            return snapshot;
        }
    }

    public int select(Options options) {
        Intrinsics.checkParameterIsNotNull(options, "options");
        int index$iv = BufferKt.selectPrefix$default(this, options, false, 2, (Object) null);
        if (index$iv == -1) {
            return -1;
        }
        skip((long) options.getByteStrings$okio()[index$iv].size());
        return index$iv;
    }

    public void readFully(Buffer sink, long byteCount) throws EOFException {
        Intrinsics.checkParameterIsNotNull(sink, "sink");
        if (size() >= byteCount) {
            sink.write(this, byteCount);
        } else {
            sink.write(this, size());
            throw new EOFException();
        }
    }

    public long readAll(Sink sink) throws IOException {
        Intrinsics.checkParameterIsNotNull(sink, "sink");
        long byteCount$iv = size();
        if (byteCount$iv > 0) {
            sink.write(this, byteCount$iv);
        }
        return byteCount$iv;
    }

    public String readUtf8() {
        return readString(this.size, Charsets.UTF_8);
    }

    public String readUtf8(long byteCount) throws EOFException {
        return readString(byteCount, Charsets.UTF_8);
    }

    public String readString(Charset charset) {
        Intrinsics.checkParameterIsNotNull(charset, "charset");
        return readString(this.size, charset);
    }

    public String readString(long byteCount, Charset charset) throws EOFException {
        Intrinsics.checkParameterIsNotNull(charset, "charset");
        if (!(byteCount >= 0 && byteCount <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + byteCount).toString());
        } else if (this.size < byteCount) {
            throw new EOFException();
        } else if (byteCount == 0) {
            return "";
        } else {
            Segment s = this.head;
            if (s == null) {
                Intrinsics.throwNpe();
            }
            if (((long) s.pos) + byteCount > ((long) s.limit)) {
                return new String(readByteArray(byteCount), charset);
            }
            String result = new String(s.data, s.pos, (int) byteCount, charset);
            s.pos += (int) byteCount;
            this.size -= byteCount;
            if (s.pos == s.limit) {
                this.head = s.pop();
                SegmentPool.INSTANCE.recycle(s);
            }
            return result;
        }
    }

    public String readUtf8Line() throws EOFException {
        long newline$iv = indexOf((byte) 10);
        if (newline$iv != -1) {
            return BufferKt.readUtf8Line(this, newline$iv);
        }
        if (size() != 0) {
            return readUtf8(size());
        }
        return null;
    }

    public String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(LongCompanionObject.MAX_VALUE);
    }

    public String readUtf8LineStrict(long limit) throws EOFException {
        long j = limit;
        if (j >= 0) {
            long j2 = LongCompanionObject.MAX_VALUE;
            if (j != LongCompanionObject.MAX_VALUE) {
                j2 = j + 1;
            }
            long scanLength$iv = j2;
            byte b = (byte) 10;
            long newline$iv = indexOf(b, 0, scanLength$iv);
            if (newline$iv != -1) {
                return BufferKt.readUtf8Line(this, newline$iv);
            }
            if (scanLength$iv < size() && getByte(scanLength$iv - 1) == ((byte) 13) && getByte(scanLength$iv) == b) {
                return BufferKt.readUtf8Line(this, scanLength$iv);
            }
            Buffer data$iv = new Buffer();
            long j3 = newline$iv;
            copyTo(data$iv, 0, Math.min((long) 32, size()));
            throw new EOFException("\\n not found: limit=" + Math.min(size(), j) + " content=" + data$iv.readByteString().hex() + Typography.ellipsis);
        }
        throw new IllegalArgumentException(("limit < 0: " + j).toString());
    }

    public int readUtf8CodePoint() throws EOFException {
        int min$iv;
        int byteCount$iv;
        int codePoint$iv;
        if (size() != 0) {
            byte b0$iv = getByte(0);
            if ((128 & b0$iv) == 0) {
                codePoint$iv = b0$iv & 127;
                byteCount$iv = 1;
                min$iv = 0;
            } else if ((224 & b0$iv) == 192) {
                codePoint$iv = b0$iv & 31;
                byteCount$iv = 2;
                min$iv = 128;
            } else if ((240 & b0$iv) == 224) {
                codePoint$iv = b0$iv & 15;
                byteCount$iv = 3;
                min$iv = 2048;
            } else if ((248 & b0$iv) == 240) {
                codePoint$iv = b0$iv & 7;
                byteCount$iv = 4;
                min$iv = 65536;
            } else {
                skip(1);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            if (size() >= ((long) byteCount$iv)) {
                int i$iv = 1;
                while (i$iv < byteCount$iv) {
                    int b$iv = getByte((long) i$iv);
                    if ((192 & b$iv) == 128) {
                        codePoint$iv = (codePoint$iv << 6) | (63 & b$iv);
                        i$iv++;
                    } else {
                        skip((long) i$iv);
                        return Utf8.REPLACEMENT_CODE_POINT;
                    }
                }
                skip((long) byteCount$iv);
                if (codePoint$iv > 1114111) {
                    return Utf8.REPLACEMENT_CODE_POINT;
                }
                if ((55296 <= codePoint$iv && 57343 >= codePoint$iv) || codePoint$iv < min$iv) {
                    return Utf8.REPLACEMENT_CODE_POINT;
                }
                return codePoint$iv;
            }
            throw new EOFException("size < " + byteCount$iv + ": " + size() + " (to read code point prefixed 0x" + Util.toHexString(b0$iv) + ')');
        }
        throw new EOFException();
    }

    public byte[] readByteArray() {
        return readByteArray(size());
    }

    public byte[] readByteArray(long byteCount) throws EOFException {
        if (!(byteCount >= 0 && byteCount <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + byteCount).toString());
        } else if (size() >= byteCount) {
            byte[] result$iv = new byte[((int) byteCount)];
            readFully(result$iv);
            return result$iv;
        } else {
            throw new EOFException();
        }
    }

    public int read(byte[] sink) {
        Intrinsics.checkParameterIsNotNull(sink, "sink");
        return read(sink, 0, sink.length);
    }

    public void readFully(byte[] sink) throws EOFException {
        Intrinsics.checkParameterIsNotNull(sink, "sink");
        int offset$iv = 0;
        while (offset$iv < sink.length) {
            int read$iv = read(sink, offset$iv, sink.length - offset$iv);
            if (read$iv != -1) {
                offset$iv += read$iv;
            } else {
                throw new EOFException();
            }
        }
    }

    public int read(byte[] sink, int offset, int byteCount) {
        Intrinsics.checkParameterIsNotNull(sink, "sink");
        Util.checkOffsetAndCount((long) sink.length, (long) offset, (long) byteCount);
        Segment s$iv = this.head;
        if (s$iv == null) {
            return -1;
        }
        int toCopy$iv = Math.min(byteCount, s$iv.limit - s$iv.pos);
        ArraysKt.copyInto(s$iv.data, sink, offset, s$iv.pos, s$iv.pos + toCopy$iv);
        s$iv.pos += toCopy$iv;
        setSize$okio(size() - ((long) toCopy$iv));
        if (s$iv.pos != s$iv.limit) {
            return toCopy$iv;
        }
        this.head = s$iv.pop();
        SegmentPool.INSTANCE.recycle(s$iv);
        return toCopy$iv;
    }

    public int read(ByteBuffer sink) throws IOException {
        Intrinsics.checkParameterIsNotNull(sink, "sink");
        Segment s = this.head;
        if (s == null) {
            return -1;
        }
        int toCopy = Math.min(sink.remaining(), s.limit - s.pos);
        sink.put(s.data, s.pos, toCopy);
        s.pos += toCopy;
        this.size -= (long) toCopy;
        if (s.pos == s.limit) {
            this.head = s.pop();
            SegmentPool.INSTANCE.recycle(s);
        }
        return toCopy;
    }

    public final void clear() {
        skip(size());
    }

    public void skip(long byteCount) throws EOFException {
        long byteCount$iv = byteCount;
        while (byteCount$iv > 0) {
            Segment head$iv = this.head;
            if (head$iv != null) {
                int toSkip$iv = (int) Math.min(byteCount$iv, (long) (head$iv.limit - head$iv.pos));
                setSize$okio(size() - ((long) toSkip$iv));
                byteCount$iv -= (long) toSkip$iv;
                head$iv.pos += toSkip$iv;
                if (head$iv.pos == head$iv.limit) {
                    this.head = head$iv.pop();
                    SegmentPool.INSTANCE.recycle(head$iv);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public Buffer write(ByteString byteString) {
        Intrinsics.checkParameterIsNotNull(byteString, "byteString");
        byteString.write$okio(this, 0, byteString.size());
        return this;
    }

    public Buffer write(ByteString byteString, int offset, int byteCount) {
        Intrinsics.checkParameterIsNotNull(byteString, "byteString");
        byteString.write$okio(this, offset, byteCount);
        return this;
    }

    public Buffer writeUtf8(String string) {
        Intrinsics.checkParameterIsNotNull(string, "string");
        return writeUtf8(string, 0, string.length());
    }

    public Buffer writeUtf8(String string, int beginIndex, int endIndex) {
        int runLimit$iv;
        String str = string;
        int i = beginIndex;
        int i2 = endIndex;
        Intrinsics.checkParameterIsNotNull(str, "string");
        int i3 = 1;
        if (i >= 0) {
            if (i2 >= i) {
                if (i2 <= string.length()) {
                    int runSize$iv = beginIndex;
                    while (runSize$iv < i2) {
                        int c$iv = str.charAt(runSize$iv);
                        if (c$iv < 128) {
                            Segment tail$iv = writableSegment$okio(i3);
                            byte[] data$iv = tail$iv.data;
                            int segmentOffset$iv = tail$iv.limit - runSize$iv;
                            int runLimit$iv2 = Math.min(i2, 8192 - segmentOffset$iv);
                            int i$iv = runSize$iv + 1;
                            data$iv[runSize$iv + segmentOffset$iv] = (byte) c$iv;
                            while (i$iv < runLimit$iv2) {
                                int c$iv2 = str.charAt(i$iv);
                                if (c$iv2 >= 128) {
                                    break;
                                }
                                data$iv[i$iv + segmentOffset$iv] = (byte) c$iv2;
                                i$iv++;
                            }
                            int runSize$iv2 = (i$iv + segmentOffset$iv) - tail$iv.limit;
                            tail$iv.limit += runSize$iv2;
                            setSize$okio(((long) runSize$iv2) + size());
                            runSize$iv = i$iv;
                            runLimit$iv = 1;
                        } else if (c$iv < 2048) {
                            Segment tail$iv2 = writableSegment$okio(2);
                            tail$iv2.data[tail$iv2.limit] = (byte) ((c$iv >> 6) | 192);
                            tail$iv2.data[tail$iv2.limit + 1] = (byte) (128 | (c$iv & 63));
                            tail$iv2.limit += 2;
                            setSize$okio(size() + 2);
                            runSize$iv++;
                            runLimit$iv = 1;
                        } else if (c$iv < 55296 || c$iv > 57343) {
                            Segment tail$iv3 = writableSegment$okio(3);
                            tail$iv3.data[tail$iv3.limit] = (byte) ((c$iv >> 12) | 224);
                            runLimit$iv = 1;
                            tail$iv3.data[tail$iv3.limit + 1] = (byte) ((63 & (c$iv >> 6)) | 128);
                            tail$iv3.data[tail$iv3.limit + 2] = (byte) ((c$iv & 63) | 128);
                            tail$iv3.limit += 3;
                            setSize$okio(size() + 3);
                            runSize$iv++;
                        } else {
                            int low$iv = runSize$iv + 1 < i2 ? str.charAt(runSize$iv + 1) : 0;
                            if (c$iv > 56319 || 56320 > low$iv || 57343 < low$iv) {
                                writeByte(63);
                                runSize$iv++;
                                runLimit$iv = 1;
                            } else {
                                int codePoint$iv = (((c$iv & 1023) << 10) | (low$iv & 1023)) + 65536;
                                Segment tail$iv4 = writableSegment$okio(4);
                                tail$iv4.data[tail$iv4.limit] = (byte) ((codePoint$iv >> 18) | 240);
                                tail$iv4.data[tail$iv4.limit + 1] = (byte) (((codePoint$iv >> 12) & 63) | 128);
                                tail$iv4.data[tail$iv4.limit + 2] = (byte) (((codePoint$iv >> 6) & 63) | 128);
                                tail$iv4.data[tail$iv4.limit + 3] = (byte) (128 | (codePoint$iv & 63));
                                tail$iv4.limit += 4;
                                setSize$okio(size() + 4);
                                runSize$iv += 2;
                                runLimit$iv = 1;
                            }
                        }
                        i3 = runLimit$iv;
                    }
                    return this;
                }
                throw new IllegalArgumentException(("endIndex > string.length: " + i2 + " > " + string.length()).toString());
            }
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i2 + " < " + i).toString());
        }
        throw new IllegalArgumentException(("beginIndex < 0: " + i).toString());
    }

    public Buffer writeUtf8CodePoint(int codePoint) {
        if (codePoint < 128) {
            writeByte(codePoint);
        } else if (codePoint < 2048) {
            Segment tail$iv = writableSegment$okio(2);
            tail$iv.data[tail$iv.limit] = (byte) ((codePoint >> 6) | 192);
            tail$iv.data[tail$iv.limit + 1] = (byte) (128 | (codePoint & 63));
            tail$iv.limit += 2;
            setSize$okio(size() + 2);
        } else if (55296 <= codePoint && 57343 >= codePoint) {
            writeByte(63);
        } else if (codePoint < 65536) {
            Segment tail$iv2 = writableSegment$okio(3);
            tail$iv2.data[tail$iv2.limit] = (byte) ((codePoint >> 12) | 224);
            tail$iv2.data[tail$iv2.limit + 1] = (byte) ((63 & (codePoint >> 6)) | 128);
            tail$iv2.data[tail$iv2.limit + 2] = (byte) (128 | (codePoint & 63));
            tail$iv2.limit += 3;
            setSize$okio(size() + 3);
        } else if (codePoint <= 1114111) {
            Segment tail$iv3 = writableSegment$okio(4);
            tail$iv3.data[tail$iv3.limit] = (byte) ((codePoint >> 18) | 240);
            tail$iv3.data[tail$iv3.limit + 1] = (byte) (((codePoint >> 12) & 63) | 128);
            tail$iv3.data[tail$iv3.limit + 2] = (byte) (((codePoint >> 6) & 63) | 128);
            tail$iv3.data[tail$iv3.limit + 3] = (byte) (128 | (codePoint & 63));
            tail$iv3.limit += 4;
            setSize$okio(size() + 4);
        } else {
            throw new IllegalArgumentException("Unexpected code point: 0x" + Util.toHexString(codePoint));
        }
        return this;
    }

    public Buffer writeString(String string, Charset charset) {
        Intrinsics.checkParameterIsNotNull(string, "string");
        Intrinsics.checkParameterIsNotNull(charset, "charset");
        return writeString(string, 0, string.length(), charset);
    }

    public Buffer writeString(String string, int beginIndex, int endIndex, Charset charset) {
        Intrinsics.checkParameterIsNotNull(string, "string");
        Intrinsics.checkParameterIsNotNull(charset, "charset");
        boolean z = true;
        if (beginIndex >= 0) {
            if (endIndex >= beginIndex) {
                if (endIndex > string.length()) {
                    z = false;
                }
                if (!z) {
                    throw new IllegalArgumentException(("endIndex > string.length: " + endIndex + " > " + string.length()).toString());
                } else if (Intrinsics.areEqual((Object) charset, (Object) Charsets.UTF_8)) {
                    return writeUtf8(string, beginIndex, endIndex);
                } else {
                    String substring = string.substring(beginIndex, endIndex);
                    Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    if (substring != null) {
                        byte[] data = substring.getBytes(charset);
                        Intrinsics.checkExpressionValueIsNotNull(data, "(this as java.lang.String).getBytes(charset)");
                        return write(data, 0, data.length);
                    }
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                throw new IllegalArgumentException(("endIndex < beginIndex: " + endIndex + " < " + beginIndex).toString());
            }
        } else {
            throw new IllegalArgumentException(("beginIndex < 0: " + beginIndex).toString());
        }
    }

    public Buffer write(byte[] source) {
        Intrinsics.checkParameterIsNotNull(source, Constants.ScionAnalytics.PARAM_SOURCE);
        return write(source, 0, source.length);
    }

    public Buffer write(byte[] source, int offset, int byteCount) {
        Intrinsics.checkParameterIsNotNull(source, Constants.ScionAnalytics.PARAM_SOURCE);
        int offset$iv = offset;
        Util.checkOffsetAndCount((long) source.length, (long) offset$iv, (long) byteCount);
        int limit$iv = offset$iv + byteCount;
        while (offset$iv < limit$iv) {
            Segment tail$iv = writableSegment$okio(1);
            int toCopy$iv = Math.min(limit$iv - offset$iv, 8192 - tail$iv.limit);
            ArraysKt.copyInto(source, tail$iv.data, tail$iv.limit, offset$iv, offset$iv + toCopy$iv);
            offset$iv += toCopy$iv;
            tail$iv.limit += toCopy$iv;
        }
        setSize$okio(size() + ((long) byteCount));
        return this;
    }

    public int write(ByteBuffer source) throws IOException {
        Intrinsics.checkParameterIsNotNull(source, Constants.ScionAnalytics.PARAM_SOURCE);
        int byteCount = source.remaining();
        int remaining = byteCount;
        while (remaining > 0) {
            Segment tail = writableSegment$okio(1);
            int toCopy = Math.min(remaining, 8192 - tail.limit);
            source.get(tail.data, tail.limit, toCopy);
            remaining -= toCopy;
            tail.limit += toCopy;
        }
        this.size += (long) byteCount;
        return byteCount;
    }

    public long writeAll(Source source) throws IOException {
        Intrinsics.checkParameterIsNotNull(source, Constants.ScionAnalytics.PARAM_SOURCE);
        long totalBytesRead$iv = 0;
        while (true) {
            long readCount$iv = source.read(this, (long) 8192);
            if (readCount$iv == -1) {
                return totalBytesRead$iv;
            }
            totalBytesRead$iv += readCount$iv;
        }
    }

    public Buffer write(Source source, long byteCount) throws IOException {
        Intrinsics.checkParameterIsNotNull(source, Constants.ScionAnalytics.PARAM_SOURCE);
        long byteCount$iv = byteCount;
        while (byteCount$iv > 0) {
            long read$iv = source.read(this, byteCount$iv);
            if (read$iv != -1) {
                byteCount$iv -= read$iv;
            } else {
                throw new EOFException();
            }
        }
        return this;
    }

    public Buffer writeByte(int b) {
        Segment tail$iv = writableSegment$okio(1);
        byte[] bArr = tail$iv.data;
        int i = tail$iv.limit;
        tail$iv.limit = i + 1;
        bArr[i] = (byte) b;
        setSize$okio(size() + 1);
        return this;
    }

    public Buffer writeShort(int s) {
        Segment tail$iv = writableSegment$okio(2);
        byte[] data$iv = tail$iv.data;
        int limit$iv = tail$iv.limit;
        int limit$iv2 = limit$iv + 1;
        data$iv[limit$iv] = (byte) ((s >>> 8) & 255);
        data$iv[limit$iv2] = (byte) (s & 255);
        tail$iv.limit = limit$iv2 + 1;
        setSize$okio(size() + 2);
        return this;
    }

    public Buffer writeShortLe(int s) {
        return writeShort((int) Util.reverseBytes((short) s));
    }

    public Buffer writeInt(int i) {
        Segment tail$iv = writableSegment$okio(4);
        byte[] data$iv = tail$iv.data;
        int limit$iv = tail$iv.limit;
        int limit$iv2 = limit$iv + 1;
        data$iv[limit$iv] = (byte) ((i >>> 24) & 255);
        int limit$iv3 = limit$iv2 + 1;
        data$iv[limit$iv2] = (byte) ((i >>> 16) & 255);
        int limit$iv4 = limit$iv3 + 1;
        data$iv[limit$iv3] = (byte) ((i >>> 8) & 255);
        data$iv[limit$iv4] = (byte) (i & 255);
        tail$iv.limit = limit$iv4 + 1;
        setSize$okio(size() + 4);
        return this;
    }

    public Buffer writeIntLe(int i) {
        return writeInt(Util.reverseBytes(i));
    }

    public Buffer writeLong(long v) {
        Segment tail$iv = writableSegment$okio(8);
        byte[] data$iv = tail$iv.data;
        int limit$iv = tail$iv.limit;
        int limit$iv2 = limit$iv + 1;
        data$iv[limit$iv] = (byte) ((int) ((v >>> 56) & 255));
        int limit$iv3 = limit$iv2 + 1;
        data$iv[limit$iv2] = (byte) ((int) ((v >>> 48) & 255));
        int limit$iv4 = limit$iv3 + 1;
        data$iv[limit$iv3] = (byte) ((int) ((v >>> 40) & 255));
        int limit$iv5 = limit$iv4 + 1;
        data$iv[limit$iv4] = (byte) ((int) ((v >>> 32) & 255));
        int limit$iv6 = limit$iv5 + 1;
        data$iv[limit$iv5] = (byte) ((int) ((v >>> 24) & 255));
        int limit$iv7 = limit$iv6 + 1;
        data$iv[limit$iv6] = (byte) ((int) ((v >>> 16) & 255));
        int limit$iv8 = limit$iv7 + 1;
        data$iv[limit$iv7] = (byte) ((int) ((v >>> 8) & 255));
        data$iv[limit$iv8] = (byte) ((int) (v & 255));
        tail$iv.limit = limit$iv8 + 1;
        setSize$okio(size() + 8);
        return this;
    }

    public Buffer writeLongLe(long v) {
        return writeLong(Util.reverseBytes(v));
    }

    public Buffer writeDecimalLong(long v) {
        int width$iv;
        long v$iv = v;
        if (v$iv == 0) {
            return writeByte(48);
        }
        boolean negative$iv = false;
        if (v$iv < 0) {
            v$iv = -v$iv;
            if (v$iv < 0) {
                return writeUtf8("-9223372036854775808");
            }
            negative$iv = true;
        }
        if (v$iv < 100000000) {
            width$iv = v$iv < 10000 ? v$iv < 100 ? v$iv < 10 ? 1 : 2 : v$iv < 1000 ? 3 : 4 : v$iv < 1000000 ? v$iv < 100000 ? 5 : 6 : v$iv < 10000000 ? 7 : 8;
        } else if (v$iv < 1000000000000L) {
            if (v$iv < RealConnection.IDLE_CONNECTION_HEALTHY_NS) {
                width$iv = v$iv < 1000000000 ? 9 : 10;
            } else if (v$iv < 100000000000L) {
                width$iv = 11;
            } else {
                width$iv = 12;
            }
        } else if (v$iv < 1000000000000000L) {
            if (v$iv < 10000000000000L) {
                width$iv = 13;
            } else if (v$iv < 100000000000000L) {
                width$iv = 14;
            } else {
                width$iv = 15;
            }
        } else if (v$iv < 100000000000000000L) {
            if (v$iv < 10000000000000000L) {
                width$iv = 16;
            } else {
                width$iv = 17;
            }
        } else if (v$iv < 1000000000000000000L) {
            width$iv = 18;
        } else {
            width$iv = 19;
        }
        if (negative$iv) {
            width$iv++;
        }
        Segment tail$iv = writableSegment$okio(width$iv);
        byte[] data$iv = tail$iv.data;
        int pos$iv = tail$iv.limit + width$iv;
        while (v$iv != 0) {
            long j = (long) 10;
            pos$iv--;
            data$iv[pos$iv] = BufferKt.getHEX_DIGIT_BYTES()[(int) (v$iv % j)];
            v$iv /= j;
        }
        if (negative$iv) {
            data$iv[pos$iv - 1] = (byte) 45;
        }
        tail$iv.limit += width$iv;
        setSize$okio(size() + ((long) width$iv));
        return this;
    }

    public Buffer writeHexadecimalUnsignedLong(long v) {
        long v$iv = v;
        if (v$iv == 0) {
            return writeByte(48);
        }
        long x$iv = v$iv;
        long x$iv2 = x$iv | (x$iv >>> 1);
        long x$iv3 = x$iv2 | (x$iv2 >>> 2);
        long x$iv4 = x$iv3 | (x$iv3 >>> 4);
        long x$iv5 = x$iv4 | (x$iv4 >>> 8);
        long x$iv6 = x$iv5 | (x$iv5 >>> 16);
        long x$iv7 = x$iv6 | (x$iv6 >>> 32);
        long x$iv8 = x$iv7 - ((x$iv7 >>> 1) & 6148914691236517205L);
        long x$iv9 = ((x$iv8 >>> 2) & 3689348814741910323L) + (3689348814741910323L & x$iv8);
        long x$iv10 = ((x$iv9 >>> 4) + x$iv9) & 1085102592571150095L;
        long x$iv11 = x$iv10 + (x$iv10 >>> 8);
        long x$iv12 = x$iv11 + (x$iv11 >>> 16);
        int width$iv = (int) ((((long) 3) + ((x$iv12 & 63) + (63 & (x$iv12 >>> 32)))) / ((long) 4));
        Segment tail$iv = writableSegment$okio(width$iv);
        byte[] data$iv = tail$iv.data;
        int start$iv = tail$iv.limit;
        for (int pos$iv = (tail$iv.limit + width$iv) - 1; pos$iv >= start$iv; pos$iv--) {
            data$iv[pos$iv] = BufferKt.getHEX_DIGIT_BYTES()[(int) (15 & v$iv)];
            v$iv >>>= 4;
        }
        tail$iv.limit += width$iv;
        setSize$okio(size() + ((long) width$iv));
        return this;
    }

    public final Segment writableSegment$okio(int minimumCapacity) {
        boolean z = true;
        if (minimumCapacity < 1 || minimumCapacity > 8192) {
            z = false;
        }
        if (z) {
            Segment segment = this.head;
            if (segment == null) {
                Segment tail$iv = SegmentPool.INSTANCE.take();
                this.head = tail$iv;
                tail$iv.prev = tail$iv;
                tail$iv.next = tail$iv;
                return tail$iv;
            }
            if (segment == null) {
                Intrinsics.throwNpe();
            }
            Segment tail$iv2 = segment.prev;
            if (tail$iv2 == null) {
                Intrinsics.throwNpe();
            }
            if (tail$iv2.limit + minimumCapacity > 8192 || !tail$iv2.owner) {
                return tail$iv2.push(SegmentPool.INSTANCE.take());
            }
            return tail$iv2;
        }
        throw new IllegalArgumentException("unexpected capacity".toString());
    }

    public void write(Buffer source, long byteCount) {
        Segment tail$iv;
        Intrinsics.checkParameterIsNotNull(source, Constants.ScionAnalytics.PARAM_SOURCE);
        long byteCount$iv = byteCount;
        if (source != this) {
            Util.checkOffsetAndCount(source.size(), 0, byteCount$iv);
            while (byteCount$iv > 0) {
                Segment segment = source.head;
                if (segment == null) {
                    Intrinsics.throwNpe();
                }
                int i = segment.limit;
                Segment segment2 = source.head;
                if (segment2 == null) {
                    Intrinsics.throwNpe();
                }
                if (byteCount$iv < ((long) (i - segment2.pos))) {
                    Segment segment3 = this.head;
                    if (segment3 != null) {
                        if (segment3 == null) {
                            Intrinsics.throwNpe();
                        }
                        tail$iv = segment3.prev;
                    } else {
                        tail$iv = null;
                    }
                    if (tail$iv != null && tail$iv.owner) {
                        if ((((long) tail$iv.limit) + byteCount$iv) - ((long) (tail$iv.shared ? 0 : tail$iv.pos)) <= ((long) 8192)) {
                            Segment segment4 = source.head;
                            if (segment4 == null) {
                                Intrinsics.throwNpe();
                            }
                            segment4.writeTo(tail$iv, (int) byteCount$iv);
                            source.setSize$okio(source.size() - byteCount$iv);
                            setSize$okio(size() + byteCount$iv);
                            return;
                        }
                    }
                    Segment segment5 = source.head;
                    if (segment5 == null) {
                        Intrinsics.throwNpe();
                    }
                    source.head = segment5.split((int) byteCount$iv);
                }
                Segment segmentToMove$iv = source.head;
                if (segmentToMove$iv == null) {
                    Intrinsics.throwNpe();
                }
                long movedByteCount$iv = (long) (segmentToMove$iv.limit - segmentToMove$iv.pos);
                source.head = segmentToMove$iv.pop();
                Segment segment6 = this.head;
                if (segment6 == null) {
                    this.head = segmentToMove$iv;
                    segmentToMove$iv.prev = segmentToMove$iv;
                    segmentToMove$iv.next = segmentToMove$iv.prev;
                } else {
                    if (segment6 == null) {
                        Intrinsics.throwNpe();
                    }
                    Segment tail$iv2 = segment6.prev;
                    if (tail$iv2 == null) {
                        Intrinsics.throwNpe();
                    }
                    tail$iv2.push(segmentToMove$iv).compact();
                }
                source.setSize$okio(source.size() - movedByteCount$iv);
                setSize$okio(size() + movedByteCount$iv);
                byteCount$iv -= movedByteCount$iv;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    public long read(Buffer sink, long byteCount) {
        Intrinsics.checkParameterIsNotNull(sink, "sink");
        long byteCount$iv = byteCount;
        if (!(byteCount$iv >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount$iv).toString());
        } else if (size() == 0) {
            return -1;
        } else {
            if (byteCount$iv > size()) {
                byteCount$iv = size();
            }
            sink.write(this, byteCount$iv);
            return byteCount$iv;
        }
    }

    public long indexOf(byte b) {
        return indexOf(b, 0, LongCompanionObject.MAX_VALUE);
    }

    public long indexOf(byte b, long fromIndex) {
        return indexOf(b, fromIndex, LongCompanionObject.MAX_VALUE);
    }

    public long indexOf(byte b, long fromIndex, long toIndex) {
        byte b2 = b;
        long fromIndex$iv = fromIndex;
        long toIndex$iv = toIndex;
        if (0 <= fromIndex$iv && toIndex$iv >= fromIndex$iv) {
            if (toIndex$iv > size()) {
                toIndex$iv = size();
            }
            if (fromIndex$iv == toIndex$iv) {
                return -1;
            }
            long fromIndex$iv$iv = fromIndex$iv;
            Buffer $this$seek$iv$iv = this;
            int $i$f$seek = false;
            Segment s$iv$iv = $this$seek$iv$iv.head;
            if (s$iv$iv == null) {
                Buffer buffer = $this$seek$iv$iv;
                long j = fromIndex$iv$iv;
                Segment segment = null;
                return -1;
            } else if ($this$seek$iv$iv.size() - fromIndex$iv$iv < fromIndex$iv$iv) {
                long offset$iv$iv = $this$seek$iv$iv.size();
                while (offset$iv$iv > fromIndex$iv$iv) {
                    Segment segment2 = s$iv$iv.prev;
                    if (segment2 == null) {
                        Intrinsics.throwNpe();
                    }
                    s$iv$iv = segment2;
                    offset$iv$iv -= (long) (s$iv$iv.limit - s$iv$iv.pos);
                }
                Segment s$iv = s$iv$iv;
                long offset$iv = offset$iv$iv;
                int i = false;
                if (s$iv != null) {
                    long offset$iv2 = offset$iv;
                    Segment s$iv2 = s$iv;
                    while (offset$iv2 < toIndex$iv) {
                        Buffer $this$seek$iv$iv2 = $this$seek$iv$iv;
                        byte[] data$iv = s$iv2.data;
                        Segment s$iv3 = s$iv;
                        int i2 = i;
                        int $i$f$seek2 = $i$f$seek;
                        Segment s$iv$iv2 = s$iv$iv;
                        int limit$iv = (int) Math.min((long) s$iv2.limit, (((long) s$iv2.pos) + toIndex$iv) - offset$iv2);
                        for (int pos$iv = (int) ((((long) s$iv2.pos) + fromIndex$iv) - offset$iv2); pos$iv < limit$iv; pos$iv++) {
                            if (data$iv[pos$iv] == b2) {
                                return ((long) (pos$iv - s$iv2.pos)) + offset$iv2;
                            }
                        }
                        offset$iv2 += (long) (s$iv2.limit - s$iv2.pos);
                        fromIndex$iv = offset$iv2;
                        Segment segment3 = s$iv2.next;
                        if (segment3 == null) {
                            Intrinsics.throwNpe();
                        }
                        s$iv2 = segment3;
                        $this$seek$iv$iv = $this$seek$iv$iv2;
                        s$iv = s$iv3;
                        i = i2;
                        $i$f$seek = $i$f$seek2;
                        s$iv$iv = s$iv$iv2;
                    }
                    Segment segment4 = s$iv;
                    int i3 = i;
                    int i4 = $i$f$seek;
                    Segment segment5 = s$iv$iv;
                    return -1;
                }
                Buffer buffer2 = $this$seek$iv$iv;
                Segment segment6 = s$iv;
                Segment segment7 = s$iv$iv;
                return -1;
            } else {
                Buffer buffer3 = $this$seek$iv$iv;
                long offset$iv$iv2 = 0;
                while (true) {
                    long nextOffset$iv$iv = ((long) (s$iv$iv.limit - s$iv$iv.pos)) + offset$iv$iv2;
                    if (nextOffset$iv$iv > fromIndex$iv$iv) {
                        break;
                    }
                    long fromIndex$iv$iv2 = fromIndex$iv$iv;
                    Segment segment8 = s$iv$iv.next;
                    if (segment8 == null) {
                        Intrinsics.throwNpe();
                    }
                    s$iv$iv = segment8;
                    offset$iv$iv2 = nextOffset$iv$iv;
                    fromIndex$iv$iv = fromIndex$iv$iv2;
                }
                Segment s$iv4 = s$iv$iv;
                long offset$iv3 = offset$iv$iv2;
                int i5 = false;
                if (s$iv4 != null) {
                    Segment s$iv5 = s$iv4;
                    long offset$iv4 = offset$iv3;
                    while (offset$iv4 < toIndex$iv) {
                        Segment s$iv6 = s$iv4;
                        byte[] data$iv2 = s$iv5.data;
                        long offset$iv$iv3 = offset$iv$iv2;
                        int i6 = i5;
                        long fromIndex$iv$iv3 = fromIndex$iv$iv;
                        int limit$iv2 = (int) Math.min((long) s$iv5.limit, (((long) s$iv5.pos) + toIndex$iv) - offset$iv4);
                        for (int pos$iv2 = (int) ((((long) s$iv5.pos) + fromIndex$iv) - offset$iv4); pos$iv2 < limit$iv2; pos$iv2++) {
                            if (data$iv2[pos$iv2] == b2) {
                                return ((long) (pos$iv2 - s$iv5.pos)) + offset$iv4;
                            }
                        }
                        offset$iv4 += (long) (s$iv5.limit - s$iv5.pos);
                        fromIndex$iv = offset$iv4;
                        Segment segment9 = s$iv5.next;
                        if (segment9 == null) {
                            Intrinsics.throwNpe();
                        }
                        s$iv5 = segment9;
                        s$iv4 = s$iv6;
                        i5 = i6;
                        offset$iv$iv2 = offset$iv$iv3;
                        fromIndex$iv$iv = fromIndex$iv$iv3;
                    }
                    long j2 = offset$iv$iv2;
                    int i7 = i5;
                    long j3 = fromIndex$iv$iv;
                    return -1;
                }
                long j4 = offset$iv$iv2;
                long j5 = fromIndex$iv$iv;
                return -1;
            }
        } else {
            throw new IllegalArgumentException(("size=" + size() + " fromIndex=" + fromIndex$iv + " toIndex=" + toIndex$iv).toString());
        }
    }

    public long indexOf(ByteString bytes) throws IOException {
        Intrinsics.checkParameterIsNotNull(bytes, "bytes");
        return indexOf(bytes, 0);
    }

    public long indexOf(ByteString bytes, long fromIndex) throws IOException {
        byte b0$iv;
        byte[] targetByteArray$iv;
        Intrinsics.checkParameterIsNotNull(bytes, "bytes");
        Buffer $this$commonIndexOf$iv = this;
        long fromIndex$iv = fromIndex;
        if (bytes.size() > 0) {
            if (fromIndex$iv >= 0) {
                long fromIndex$iv$iv = fromIndex$iv;
                Buffer $this$seek$iv$iv = $this$commonIndexOf$iv;
                int $i$f$seek = false;
                Segment s$iv$iv = $this$seek$iv$iv.head;
                if (s$iv$iv == null) {
                    Buffer buffer = $this$seek$iv$iv;
                    long j = fromIndex$iv$iv;
                    Segment segment = null;
                    return -1;
                } else if ($this$seek$iv$iv.size() - fromIndex$iv$iv < fromIndex$iv$iv) {
                    long offset$iv$iv = $this$seek$iv$iv.size();
                    while (offset$iv$iv > fromIndex$iv$iv) {
                        Segment segment2 = s$iv$iv.prev;
                        if (segment2 == null) {
                            Intrinsics.throwNpe();
                        }
                        s$iv$iv = segment2;
                        offset$iv$iv -= (long) (s$iv$iv.limit - s$iv$iv.pos);
                    }
                    Segment s$iv = s$iv$iv;
                    long offset$iv = offset$iv$iv;
                    if (s$iv != null) {
                        long offset$iv2 = offset$iv;
                        byte[] targetByteArray$iv2 = bytes.internalArray$okio();
                        byte b0$iv2 = targetByteArray$iv2[0];
                        int bytesSize$iv = bytes.size();
                        long resultLimit$iv = ($this$commonIndexOf$iv.size() - ((long) bytesSize$iv)) + 1;
                        Segment s$iv2 = s$iv;
                        while (offset$iv2 < resultLimit$iv) {
                            byte[] data$iv = s$iv2.data;
                            Buffer $this$seek$iv$iv2 = $this$seek$iv$iv;
                            int $i$f$seek2 = $i$f$seek;
                            Segment s$iv$iv2 = s$iv$iv;
                            Segment s$iv3 = s$iv;
                            long offset$iv3 = offset$iv;
                            int segmentLimit$iv = (int) Math.min((long) s$iv2.limit, (((long) s$iv2.pos) + resultLimit$iv) - offset$iv2);
                            for (int pos$iv = (int) ((((long) s$iv2.pos) + fromIndex$iv) - offset$iv2); pos$iv < segmentLimit$iv; pos$iv++) {
                                if (data$iv[pos$iv] == b0$iv2 && BufferKt.rangeEquals(s$iv2, pos$iv + 1, targetByteArray$iv2, 1, bytesSize$iv)) {
                                    return ((long) (pos$iv - s$iv2.pos)) + offset$iv2;
                                }
                            }
                            offset$iv2 += (long) (s$iv2.limit - s$iv2.pos);
                            fromIndex$iv = offset$iv2;
                            Segment segment3 = s$iv2.next;
                            if (segment3 == null) {
                                Intrinsics.throwNpe();
                            }
                            s$iv2 = segment3;
                            $this$seek$iv$iv = $this$seek$iv$iv2;
                            s$iv$iv = s$iv$iv2;
                            $i$f$seek = $i$f$seek2;
                            s$iv = s$iv3;
                            offset$iv = offset$iv3;
                        }
                        int i = $i$f$seek;
                        Segment segment4 = s$iv$iv;
                        Segment segment5 = s$iv;
                        long j2 = offset$iv;
                        return -1;
                    }
                    Buffer buffer2 = $this$seek$iv$iv;
                    Segment segment6 = s$iv$iv;
                    Segment segment7 = s$iv;
                    long j3 = offset$iv;
                    return -1;
                } else {
                    Buffer buffer3 = $this$seek$iv$iv;
                    long offset$iv$iv2 = 0;
                    while (true) {
                        long nextOffset$iv$iv = ((long) (s$iv$iv.limit - s$iv$iv.pos)) + offset$iv$iv2;
                        if (nextOffset$iv$iv > fromIndex$iv$iv) {
                            break;
                        }
                        Buffer $this$commonIndexOf$iv2 = $this$commonIndexOf$iv;
                        long j4 = offset$iv$iv2;
                        long fromIndex$iv$iv2 = fromIndex$iv$iv;
                        Segment segment8 = s$iv$iv.next;
                        if (segment8 == null) {
                            Intrinsics.throwNpe();
                        }
                        s$iv$iv = segment8;
                        offset$iv$iv2 = nextOffset$iv$iv;
                        $this$commonIndexOf$iv = $this$commonIndexOf$iv2;
                        fromIndex$iv$iv = fromIndex$iv$iv2;
                    }
                    Segment s$iv4 = s$iv$iv;
                    long offset$iv4 = offset$iv$iv2;
                    if (s$iv4 != null) {
                        Segment s$iv5 = s$iv4;
                        long offset$iv5 = offset$iv4;
                        long j5 = offset$iv$iv2;
                        byte[] targetByteArray$iv3 = bytes.internalArray$okio();
                        byte b0$iv3 = targetByteArray$iv3[0];
                        int bytesSize$iv2 = bytes.size();
                        long j6 = fromIndex$iv$iv;
                        long resultLimit$iv2 = ($this$commonIndexOf$iv.size() - ((long) bytesSize$iv2)) + 1;
                        while (offset$iv5 < resultLimit$iv2) {
                            byte[] data$iv2 = s$iv5.data;
                            Buffer $this$commonIndexOf$iv3 = $this$commonIndexOf$iv;
                            long offset$iv6 = offset$iv4;
                            byte[] targetByteArray$iv4 = targetByteArray$iv3;
                            int segmentLimit$iv2 = (int) Math.min((long) s$iv5.limit, (((long) s$iv5.pos) + resultLimit$iv2) - offset$iv5);
                            int pos$iv2 = (int) ((((long) s$iv5.pos) + fromIndex$iv) - offset$iv5);
                            while (pos$iv2 < segmentLimit$iv2) {
                                if (data$iv2[pos$iv2] == b0$iv3) {
                                    targetByteArray$iv = targetByteArray$iv4;
                                    if (BufferKt.rangeEquals(s$iv5, pos$iv2 + 1, targetByteArray$iv, 1, bytesSize$iv2)) {
                                        byte b = b0$iv3;
                                        long j7 = fromIndex$iv;
                                        return ((long) (pos$iv2 - s$iv5.pos)) + offset$iv5;
                                    }
                                    b0$iv = b0$iv3;
                                } else {
                                    b0$iv = b0$iv3;
                                    targetByteArray$iv = targetByteArray$iv4;
                                }
                                pos$iv2++;
                                b0$iv3 = b0$iv;
                                fromIndex$iv = fromIndex$iv;
                                targetByteArray$iv4 = targetByteArray$iv;
                            }
                            byte b0$iv4 = b0$iv3;
                            byte[] targetByteArray$iv5 = targetByteArray$iv4;
                            long j8 = fromIndex$iv;
                            offset$iv5 += (long) (s$iv5.limit - s$iv5.pos);
                            fromIndex$iv = offset$iv5;
                            Segment segment9 = s$iv5.next;
                            if (segment9 == null) {
                                Intrinsics.throwNpe();
                            }
                            s$iv5 = segment9;
                            targetByteArray$iv3 = targetByteArray$iv5;
                            $this$commonIndexOf$iv = $this$commonIndexOf$iv3;
                            b0$iv3 = b0$iv4;
                            offset$iv4 = offset$iv6;
                        }
                        byte b2 = b0$iv3;
                        long j9 = fromIndex$iv;
                        long j10 = offset$iv4;
                        byte[] bArr = targetByteArray$iv3;
                        return -1;
                    }
                    long j11 = offset$iv$iv2;
                    long j12 = fromIndex$iv$iv;
                    long j13 = offset$iv4;
                    return -1;
                }
            } else {
                Buffer buffer4 = $this$commonIndexOf$iv;
                throw new IllegalArgumentException(("fromIndex < 0: " + fromIndex$iv).toString());
            }
        } else {
            throw new IllegalArgumentException("bytes is empty".toString());
        }
    }

    public long indexOfElement(ByteString targetBytes) {
        Intrinsics.checkParameterIsNotNull(targetBytes, "targetBytes");
        return indexOfElement(targetBytes, 0);
    }

    public long indexOfElement(ByteString targetBytes, long fromIndex) {
        ByteString byteString = targetBytes;
        Intrinsics.checkParameterIsNotNull(byteString, "targetBytes");
        Buffer $this$commonIndexOfElement$iv = this;
        int $i$f$commonIndexOfElement = 0;
        long fromIndex$iv = fromIndex;
        if (fromIndex$iv >= 0) {
            long fromIndex$iv$iv = fromIndex$iv;
            Buffer $this$seek$iv$iv = $this$commonIndexOfElement$iv;
            int $i$f$seek = false;
            Segment s$iv$iv = $this$seek$iv$iv.head;
            if (s$iv$iv == null) {
                Buffer buffer = $this$seek$iv$iv;
                Segment segment = null;
                return -1;
            } else if ($this$seek$iv$iv.size() - fromIndex$iv$iv < fromIndex$iv$iv) {
                long offset$iv$iv = $this$seek$iv$iv.size();
                while (offset$iv$iv > fromIndex$iv$iv) {
                    Segment segment2 = s$iv$iv.prev;
                    if (segment2 == null) {
                        Intrinsics.throwNpe();
                    }
                    s$iv$iv = segment2;
                    offset$iv$iv -= (long) (s$iv$iv.limit - s$iv$iv.pos);
                }
                Segment s$iv = s$iv$iv;
                long offset$iv = offset$iv$iv;
                if (s$iv != null) {
                    Segment s$iv2 = s$iv;
                    long offset$iv2 = offset$iv;
                    if (targetBytes.size() == 2) {
                        byte b0$iv = byteString.getByte(0);
                        byte b1$iv = byteString.getByte(1);
                        Segment s$iv3 = s$iv2;
                        while (offset$iv2 < $this$commonIndexOfElement$iv.size()) {
                            int $i$f$commonIndexOfElement2 = $i$f$commonIndexOfElement;
                            byte[] data$iv = s$iv3.data;
                            Buffer $this$seek$iv$iv2 = $this$seek$iv$iv;
                            int $i$f$seek2 = $i$f$seek;
                            Segment s$iv$iv2 = s$iv$iv;
                            int limit$iv = s$iv3.limit;
                            for (int pos$iv = (int) ((((long) s$iv3.pos) + fromIndex$iv) - offset$iv2); pos$iv < limit$iv; pos$iv++) {
                                byte b$iv = data$iv[pos$iv];
                                if (b$iv == b0$iv || b$iv == b1$iv) {
                                    byte[] bArr = data$iv;
                                    long j = fromIndex$iv;
                                    return ((long) (pos$iv - s$iv3.pos)) + offset$iv2;
                                }
                            }
                            long j2 = fromIndex$iv;
                            offset$iv2 += (long) (s$iv3.limit - s$iv3.pos);
                            fromIndex$iv = offset$iv2;
                            Segment segment3 = s$iv3.next;
                            if (segment3 == null) {
                                Intrinsics.throwNpe();
                            }
                            s$iv3 = segment3;
                            s$iv$iv = s$iv$iv2;
                            $i$f$commonIndexOfElement = $i$f$commonIndexOfElement2;
                            $this$seek$iv$iv = $this$seek$iv$iv2;
                            $i$f$seek = $i$f$seek2;
                        }
                        long j3 = fromIndex$iv;
                        Buffer buffer2 = $this$seek$iv$iv;
                        int i = $i$f$seek;
                        Segment segment4 = s$iv$iv;
                    } else {
                        Buffer buffer3 = $this$seek$iv$iv;
                        Segment segment5 = s$iv$iv;
                        byte[] targetByteArray$iv = targetBytes.internalArray$okio();
                        Segment s$iv4 = s$iv2;
                        while (offset$iv2 < $this$commonIndexOfElement$iv.size()) {
                            byte[] data$iv2 = s$iv4.data;
                            int pos$iv2 = (int) ((((long) s$iv4.pos) + fromIndex$iv) - offset$iv2);
                            int limit$iv2 = s$iv4.limit;
                            while (pos$iv2 < limit$iv2) {
                                byte b$iv2 = data$iv2[pos$iv2];
                                long fromIndex$iv2 = fromIndex$iv;
                                for (byte t$iv : targetByteArray$iv) {
                                    if (b$iv2 == t$iv) {
                                        byte[] bArr2 = targetByteArray$iv;
                                        return ((long) (pos$iv2 - s$iv4.pos)) + offset$iv2;
                                    }
                                }
                                pos$iv2++;
                                fromIndex$iv = fromIndex$iv2;
                            }
                            byte[] targetByteArray$iv2 = targetByteArray$iv;
                            long j4 = fromIndex$iv;
                            offset$iv2 += (long) (s$iv4.limit - s$iv4.pos);
                            fromIndex$iv = offset$iv2;
                            Segment segment6 = s$iv4.next;
                            if (segment6 == null) {
                                Intrinsics.throwNpe();
                            }
                            s$iv4 = segment6;
                            targetByteArray$iv = targetByteArray$iv2;
                        }
                        long j5 = fromIndex$iv;
                        Segment segment7 = s$iv4;
                    }
                    return -1;
                }
                Buffer buffer4 = $this$seek$iv$iv;
                Segment segment8 = s$iv$iv;
                return -1;
            } else {
                Buffer buffer5 = $this$seek$iv$iv;
                long offset$iv$iv2 = 0;
                while (true) {
                    long nextOffset$iv$iv = ((long) (s$iv$iv.limit - s$iv$iv.pos)) + offset$iv$iv2;
                    if (nextOffset$iv$iv > fromIndex$iv$iv) {
                        break;
                    }
                    Buffer $this$commonIndexOfElement$iv2 = $this$commonIndexOfElement$iv;
                    long j6 = offset$iv$iv2;
                    Segment segment9 = s$iv$iv.next;
                    if (segment9 == null) {
                        Intrinsics.throwNpe();
                    }
                    s$iv$iv = segment9;
                    offset$iv$iv2 = nextOffset$iv$iv;
                    byteString = targetBytes;
                    $this$commonIndexOfElement$iv = $this$commonIndexOfElement$iv2;
                }
                Segment s$iv5 = s$iv$iv;
                long offset$iv3 = offset$iv$iv2;
                if (s$iv5 != null) {
                    Segment s$iv6 = s$iv5;
                    long offset$iv4 = offset$iv3;
                    if (targetBytes.size() == 2) {
                        byte b0$iv2 = byteString.getByte(0);
                        byte b1$iv2 = byteString.getByte(1);
                        while (offset$iv4 < $this$commonIndexOfElement$iv.size()) {
                            byte[] data$iv3 = s$iv6.data;
                            Segment s$iv7 = s$iv5;
                            long offset$iv$iv3 = offset$iv$iv2;
                            int pos$iv3 = (int) ((((long) s$iv6.pos) + fromIndex$iv) - offset$iv4);
                            int limit$iv3 = s$iv6.limit;
                            while (pos$iv3 < limit$iv3) {
                                byte b$iv3 = data$iv3[pos$iv3];
                                if (b$iv3 == b0$iv2 || b$iv3 == b1$iv2) {
                                    byte[] bArr3 = data$iv3;
                                    long j7 = fromIndex$iv;
                                    int i2 = pos$iv3;
                                    return ((long) (pos$iv3 - s$iv6.pos)) + offset$iv4;
                                }
                                pos$iv3++;
                            }
                            long j8 = fromIndex$iv;
                            int i3 = pos$iv3;
                            offset$iv4 += (long) (s$iv6.limit - s$iv6.pos);
                            long fromIndex$iv3 = offset$iv4;
                            Segment segment10 = s$iv6.next;
                            if (segment10 == null) {
                                Intrinsics.throwNpe();
                            }
                            s$iv6 = segment10;
                            ByteString byteString2 = targetBytes;
                            fromIndex$iv = fromIndex$iv3;
                            s$iv5 = s$iv7;
                            offset$iv$iv2 = offset$iv$iv3;
                        }
                        long j9 = fromIndex$iv;
                        long j10 = offset$iv$iv2;
                        Buffer buffer6 = $this$commonIndexOfElement$iv;
                    } else {
                        long j11 = offset$iv$iv2;
                        byte[] targetByteArray$iv3 = targetBytes.internalArray$okio();
                        while (offset$iv4 < $this$commonIndexOfElement$iv.size()) {
                            byte[] data$iv4 = s$iv6.data;
                            int pos$iv4 = (int) ((((long) s$iv6.pos) + fromIndex$iv) - offset$iv4);
                            int limit$iv4 = s$iv6.limit;
                            while (pos$iv4 < limit$iv4) {
                                byte b$iv4 = data$iv4[pos$iv4];
                                int length = targetByteArray$iv3.length;
                                Buffer $this$commonIndexOfElement$iv3 = $this$commonIndexOfElement$iv;
                                int i4 = 0;
                                while (i4 < length) {
                                    byte[] data$iv5 = data$iv4;
                                    if (b$iv4 == targetByteArray$iv3[i4]) {
                                        byte[] bArr4 = targetByteArray$iv3;
                                        return ((long) (pos$iv4 - s$iv6.pos)) + offset$iv4;
                                    }
                                    i4++;
                                    data$iv4 = data$iv5;
                                }
                                byte[] bArr5 = data$iv4;
                                pos$iv4++;
                                $this$commonIndexOfElement$iv = $this$commonIndexOfElement$iv3;
                            }
                            byte[] targetByteArray$iv4 = targetByteArray$iv3;
                            Buffer $this$commonIndexOfElement$iv4 = $this$commonIndexOfElement$iv;
                            byte[] bArr6 = data$iv4;
                            offset$iv4 += (long) (s$iv6.limit - s$iv6.pos);
                            fromIndex$iv = offset$iv4;
                            Segment segment11 = s$iv6.next;
                            if (segment11 == null) {
                                Intrinsics.throwNpe();
                            }
                            s$iv6 = segment11;
                            $this$commonIndexOfElement$iv = $this$commonIndexOfElement$iv4;
                            targetByteArray$iv3 = targetByteArray$iv4;
                        }
                        Buffer buffer7 = $this$commonIndexOfElement$iv;
                    }
                    return -1;
                }
                Segment segment12 = s$iv5;
                long j12 = offset$iv$iv2;
                return -1;
            }
        } else {
            Buffer buffer8 = $this$commonIndexOfElement$iv;
            throw new IllegalArgumentException(("fromIndex < 0: " + fromIndex$iv).toString());
        }
    }

    public boolean rangeEquals(long offset, ByteString bytes) {
        Intrinsics.checkParameterIsNotNull(bytes, "bytes");
        return rangeEquals(offset, bytes, 0, bytes.size());
    }

    public boolean rangeEquals(long offset, ByteString bytes, int bytesOffset, int byteCount) {
        Intrinsics.checkParameterIsNotNull(bytes, "bytes");
        if (offset < 0 || bytesOffset < 0 || byteCount < 0 || size() - offset < ((long) byteCount) || bytes.size() - bytesOffset < byteCount) {
            return false;
        }
        for (int i$iv = 0; i$iv < byteCount; i$iv++) {
            if (getByte(((long) i$iv) + offset) != bytes.getByte(bytesOffset + i$iv)) {
                return false;
            }
        }
        return true;
    }

    public void flush() {
    }

    public boolean isOpen() {
        return true;
    }

    public void close() {
    }

    public Timeout timeout() {
        return Timeout.NONE;
    }

    public final ByteString md5() {
        return digest("MD5");
    }

    public final ByteString sha1() {
        return digest("SHA-1");
    }

    public final ByteString sha256() {
        return digest("SHA-256");
    }

    public final ByteString sha512() {
        return digest("SHA-512");
    }

    private final ByteString digest(String algorithm) {
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        Segment head2 = this.head;
        if (head2 != null) {
            messageDigest.update(head2.data, head2.pos, head2.limit - head2.pos);
            Segment s = head2.next;
            if (s == null) {
                Intrinsics.throwNpe();
            }
            while (s != head2) {
                messageDigest.update(s.data, s.pos, s.limit - s.pos);
                Segment segment = s.next;
                if (segment == null) {
                    Intrinsics.throwNpe();
                }
                s = segment;
            }
        }
        byte[] digest = messageDigest.digest();
        Intrinsics.checkExpressionValueIsNotNull(digest, "messageDigest.digest()");
        return new ByteString(digest);
    }

    public final ByteString hmacSha1(ByteString key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return hmac("HmacSHA1", key);
    }

    public final ByteString hmacSha256(ByteString key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return hmac("HmacSHA256", key);
    }

    public final ByteString hmacSha512(ByteString key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return hmac("HmacSHA512", key);
    }

    private final ByteString hmac(String algorithm, ByteString key) {
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.internalArray$okio(), algorithm));
            Segment head2 = this.head;
            if (head2 != null) {
                mac.update(head2.data, head2.pos, head2.limit - head2.pos);
                Segment s = head2.next;
                if (s == null) {
                    Intrinsics.throwNpe();
                }
                while (s != head2) {
                    mac.update(s.data, s.pos, s.limit - s.pos);
                    Segment segment = s.next;
                    if (segment == null) {
                        Intrinsics.throwNpe();
                    }
                    s = segment;
                }
            }
            byte[] doFinal = mac.doFinal();
            Intrinsics.checkExpressionValueIsNotNull(doFinal, "mac.doFinal()");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* JADX WARNING: type inference failed for: r21v0, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r21) {
        /*
            r20 = this;
            r0 = r21
            r1 = r20
            r2 = 0
            r4 = 1
            if (r1 != r0) goto L_0x000b
            r3 = r4
            goto L_0x009e
        L_0x000b:
            boolean r5 = r0 instanceof okio.Buffer
            if (r5 != 0) goto L_0x0012
            r3 = 0
            goto L_0x009e
        L_0x0012:
            long r5 = r1.size()
            r7 = r0
            okio.Buffer r7 = (okio.Buffer) r7
            long r7 = r7.size()
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 == 0) goto L_0x0024
            r3 = 0
            goto L_0x009e
        L_0x0024:
            long r5 = r1.size()
            r7 = 0
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 != 0) goto L_0x0031
            r3 = r4
            goto L_0x009e
        L_0x0031:
            okio.Segment r5 = r1.head
            if (r5 != 0) goto L_0x0038
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0038:
            r6 = r0
            okio.Buffer r6 = (okio.Buffer) r6
            okio.Segment r6 = r6.head
            if (r6 != 0) goto L_0x0042
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0042:
            int r9 = r5.pos
            int r10 = r6.pos
            r11 = 0
            r13 = 0
        L_0x004a:
            long r15 = r1.size()
            int r15 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r15 >= 0) goto L_0x009d
            int r15 = r5.limit
            int r15 = r15 - r9
            int r3 = r6.limit
            int r3 = r3 - r10
            int r3 = java.lang.Math.min(r15, r3)
            long r13 = (long) r3
            r17 = r7
        L_0x005f:
            int r3 = (r17 > r13 ? 1 : (r17 == r13 ? 0 : -1))
            if (r3 >= 0) goto L_0x007d
            byte[] r3 = r5.data
            int r15 = r9 + 1
            byte r3 = r3[r9]
            byte[] r9 = r6.data
            int r19 = r10 + 1
            byte r9 = r9[r10]
            if (r3 == r9) goto L_0x0073
            r3 = 0
            goto L_0x009e
        L_0x0073:
            r9 = 1
            long r9 = r17 + r9
            r17 = r9
            r9 = r15
            r10 = r19
            goto L_0x005f
        L_0x007d:
            int r3 = r5.limit
            if (r9 != r3) goto L_0x008c
            okio.Segment r3 = r5.next
            if (r3 != 0) goto L_0x0088
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0088:
            int r5 = r3.pos
            r9 = r5
            r5 = r3
        L_0x008c:
            int r3 = r6.limit
            if (r10 != r3) goto L_0x009b
            okio.Segment r3 = r6.next
            if (r3 != 0) goto L_0x0097
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0097:
            int r6 = r3.pos
            r10 = r6
            r6 = r3
        L_0x009b:
            long r11 = r11 + r13
            goto L_0x004a
        L_0x009d:
            r3 = r4
        L_0x009e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        Segment s$iv = this.head;
        if (s$iv == null) {
            return 0;
        }
        int result$iv = 1;
        do {
            int limit$iv = s$iv.limit;
            for (int pos$iv = s$iv.pos; pos$iv < limit$iv; pos$iv++) {
                result$iv = (result$iv * 31) + s$iv.data[pos$iv];
            }
            Segment segment = s$iv.next;
            if (segment == null) {
                Intrinsics.throwNpe();
            }
            s$iv = segment;
        } while (s$iv != this.head);
        return result$iv;
    }

    public String toString() {
        return snapshot().toString();
    }

    public final Buffer copy() {
        Buffer result$iv = new Buffer();
        if (size() != 0) {
            Segment head$iv = this.head;
            if (head$iv == null) {
                Intrinsics.throwNpe();
            }
            Segment headCopy$iv = head$iv.sharedCopy();
            result$iv.head = headCopy$iv;
            headCopy$iv.prev = headCopy$iv;
            headCopy$iv.next = headCopy$iv.prev;
            for (Segment s$iv = head$iv.next; s$iv != head$iv; s$iv = s$iv.next) {
                Segment segment = headCopy$iv.prev;
                if (segment == null) {
                    Intrinsics.throwNpe();
                }
                if (s$iv == null) {
                    Intrinsics.throwNpe();
                }
                segment.push(s$iv.sharedCopy());
            }
            result$iv.setSize$okio(size());
        }
        return result$iv;
    }

    public Buffer clone() {
        return copy();
    }

    public final ByteString snapshot() {
        if (size() <= ((long) Integer.MAX_VALUE)) {
            return snapshot((int) size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + size()).toString());
    }

    public final ByteString snapshot(int byteCount) {
        if (byteCount == 0) {
            return ByteString.EMPTY;
        }
        Util.checkOffsetAndCount(size(), 0, (long) byteCount);
        int offset$iv = 0;
        int segmentCount$iv = 0;
        Segment s$iv = this.head;
        while (offset$iv < byteCount) {
            if (s$iv == null) {
                Intrinsics.throwNpe();
            }
            if (s$iv.limit != s$iv.pos) {
                offset$iv += s$iv.limit - s$iv.pos;
                segmentCount$iv++;
                s$iv = s$iv.next;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] segments$iv = new byte[segmentCount$iv][];
        int[] directory$iv = new int[(segmentCount$iv * 2)];
        int offset$iv2 = 0;
        int segmentCount$iv2 = 0;
        Segment s$iv2 = this.head;
        while (offset$iv2 < byteCount) {
            if (s$iv2 == null) {
                Intrinsics.throwNpe();
            }
            segments$iv[segmentCount$iv2] = s$iv2.data;
            offset$iv2 += s$iv2.limit - s$iv2.pos;
            directory$iv[segmentCount$iv2] = Math.min(offset$iv2, byteCount);
            directory$iv[((Object[]) segments$iv).length + segmentCount$iv2] = s$iv2.pos;
            s$iv2.shared = true;
            segmentCount$iv2++;
            s$iv2 = s$iv2.next;
        }
        return new SegmentedByteString(segments$iv, directory$iv);
    }

    public static /* synthetic */ UnsafeCursor readUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i, Object obj) {
        if ((i & 1) != 0) {
            unsafeCursor = new UnsafeCursor();
        }
        return buffer.readUnsafe(unsafeCursor);
    }

    public final UnsafeCursor readUnsafe(UnsafeCursor unsafeCursor) {
        Intrinsics.checkParameterIsNotNull(unsafeCursor, "unsafeCursor");
        if (unsafeCursor.buffer == null) {
            unsafeCursor.buffer = this;
            unsafeCursor.readWrite = false;
            return unsafeCursor;
        }
        throw new IllegalStateException("already attached to a buffer".toString());
    }

    public static /* synthetic */ UnsafeCursor readAndWriteUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i, Object obj) {
        if ((i & 1) != 0) {
            unsafeCursor = new UnsafeCursor();
        }
        return buffer.readAndWriteUnsafe(unsafeCursor);
    }

    public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor unsafeCursor) {
        Intrinsics.checkParameterIsNotNull(unsafeCursor, "unsafeCursor");
        if (unsafeCursor.buffer == null) {
            unsafeCursor.buffer = this;
            unsafeCursor.readWrite = true;
            return unsafeCursor;
        }
        throw new IllegalStateException("already attached to a buffer".toString());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to operator function", replaceWith = @ReplaceWith(expression = "this[index]", imports = {}))
    /* renamed from: -deprecated_getByte  reason: not valid java name */
    public final byte m1145deprecated_getByte(long index) {
        return getByte(index);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))
    /* renamed from: -deprecated_size  reason: not valid java name */
    public final long m1146deprecated_size() {
        return this.size;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\bJ\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nJ\u000e\u0010\u0017\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lokio/Buffer$UnsafeCursor;", "Ljava/io/Closeable;", "()V", "buffer", "Lokio/Buffer;", "data", "", "end", "", "offset", "", "readWrite", "", "segment", "Lokio/Segment;", "start", "close", "", "expandBuffer", "minByteCount", "next", "resizeBuffer", "newSize", "seek", "okio"}, k = 1, mv = {1, 1, 16})
    /* compiled from: Buffer.kt */
    public static final class UnsafeCursor implements Closeable {
        public Buffer buffer;
        public byte[] data;
        public int end = -1;
        public long offset = -1;
        public boolean readWrite;
        private Segment segment;
        public int start = -1;

        public final int next() {
            long j = this.offset;
            Buffer buffer2 = this.buffer;
            if (buffer2 == null) {
                Intrinsics.throwNpe();
            }
            if (j != buffer2.size()) {
                long j2 = this.offset;
                return seek(j2 == -1 ? 0 : j2 + ((long) (this.end - this.start)));
            }
            throw new IllegalStateException("no more bytes".toString());
        }

        public final int seek(long offset2) {
            long nextOffset;
            Segment next;
            long j = offset2;
            Buffer buffer2 = this.buffer;
            if (buffer2 == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            } else if (j < ((long) -1) || j > buffer2.size()) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("offset=%s > size=%s", Arrays.copyOf(new Object[]{Long.valueOf(offset2), Long.valueOf(buffer2.size())}, 2));
                Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
                throw new ArrayIndexOutOfBoundsException(format);
            } else if (j == -1 || j == buffer2.size()) {
                this.segment = null;
                this.offset = j;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return -1;
            } else {
                long min = 0;
                long max = buffer2.size();
                Segment head = buffer2.head;
                Segment tail = buffer2.head;
                Segment segment2 = this.segment;
                if (segment2 != null) {
                    long j2 = this.offset;
                    int i = this.start;
                    if (segment2 == null) {
                        Intrinsics.throwNpe();
                    }
                    long segmentOffset = j2 - ((long) (i - segment2.pos));
                    if (segmentOffset > j) {
                        max = segmentOffset;
                        tail = this.segment;
                    } else {
                        min = segmentOffset;
                        head = this.segment;
                    }
                }
                if (max - j > j - min) {
                    next = head;
                    nextOffset = min;
                    while (true) {
                        if (next == null) {
                            Intrinsics.throwNpe();
                        }
                        if (j < ((long) (next.limit - next.pos)) + nextOffset) {
                            break;
                        }
                        nextOffset += (long) (next.limit - next.pos);
                        next = next.next;
                    }
                } else {
                    Segment next2 = tail;
                    long nextOffset2 = max;
                    while (nextOffset > j) {
                        if (next == null) {
                            Intrinsics.throwNpe();
                        }
                        next2 = next.prev;
                        if (next2 == null) {
                            Intrinsics.throwNpe();
                        }
                        nextOffset2 = nextOffset - ((long) (next2.limit - next2.pos));
                    }
                }
                if (this.readWrite) {
                    if (next == null) {
                        Intrinsics.throwNpe();
                    }
                    if (next.shared) {
                        Segment unsharedNext = next.unsharedCopy();
                        if (buffer2.head == next) {
                            buffer2.head = unsharedNext;
                        }
                        next = next.push(unsharedNext);
                        Segment segment3 = next.prev;
                        if (segment3 == null) {
                            Intrinsics.throwNpe();
                        }
                        segment3.pop();
                    }
                }
                this.segment = next;
                this.offset = j;
                if (next == null) {
                    Intrinsics.throwNpe();
                }
                this.data = next.data;
                this.start = next.pos + ((int) (j - nextOffset));
                int i2 = next.limit;
                this.end = i2;
                return i2 - this.start;
            }
        }

        public final long resizeBuffer(long newSize) {
            long j = newSize;
            Buffer buffer2 = this.buffer;
            if (buffer2 == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            } else if (this.readWrite) {
                long oldSize = buffer2.size();
                int segmentBytesToAdd = 1;
                if (j <= oldSize) {
                    if (j < 0) {
                        segmentBytesToAdd = 0;
                    }
                    if (segmentBytesToAdd != 0) {
                        long bytesToSubtract = oldSize - j;
                        while (true) {
                            if (bytesToSubtract > 0) {
                                Segment segment2 = buffer2.head;
                                if (segment2 == null) {
                                    Intrinsics.throwNpe();
                                }
                                Segment tail = segment2.prev;
                                if (tail == null) {
                                    Intrinsics.throwNpe();
                                }
                                int tailSize = tail.limit - tail.pos;
                                if (((long) tailSize) > bytesToSubtract) {
                                    tail.limit -= (int) bytesToSubtract;
                                    break;
                                }
                                buffer2.head = tail.pop();
                                SegmentPool.INSTANCE.recycle(tail);
                                bytesToSubtract -= (long) tailSize;
                            } else {
                                break;
                            }
                        }
                        this.segment = null;
                        this.offset = j;
                        this.data = null;
                        this.start = -1;
                        this.end = -1;
                    } else {
                        throw new IllegalArgumentException(("newSize < 0: " + j).toString());
                    }
                } else if (j > oldSize) {
                    boolean needsToSeek = true;
                    long bytesToAdd = j - oldSize;
                    for (long j2 = 0; bytesToAdd > j2; j2 = 0) {
                        Segment tail2 = buffer2.writableSegment$okio(segmentBytesToAdd);
                        int segmentBytesToAdd2 = (int) Math.min(bytesToAdd, (long) (8192 - tail2.limit));
                        tail2.limit += segmentBytesToAdd2;
                        bytesToAdd -= (long) segmentBytesToAdd2;
                        if (needsToSeek) {
                            this.segment = tail2;
                            this.offset = oldSize;
                            this.data = tail2.data;
                            this.start = tail2.limit - segmentBytesToAdd2;
                            this.end = tail2.limit;
                            needsToSeek = false;
                        }
                        segmentBytesToAdd = 1;
                    }
                }
                buffer2.setSize$okio(j);
                return oldSize;
            } else {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
            }
        }

        public final long expandBuffer(int minByteCount) {
            boolean z = true;
            if (minByteCount > 0) {
                if (minByteCount > 8192) {
                    z = false;
                }
                if (z) {
                    Buffer buffer2 = this.buffer;
                    if (buffer2 == null) {
                        throw new IllegalStateException("not attached to a buffer".toString());
                    } else if (this.readWrite) {
                        long oldSize = buffer2.size();
                        Segment tail = buffer2.writableSegment$okio(minByteCount);
                        int result = 8192 - tail.limit;
                        tail.limit = 8192;
                        buffer2.setSize$okio(((long) result) + oldSize);
                        this.segment = tail;
                        this.offset = oldSize;
                        this.data = tail.data;
                        this.start = 8192 - result;
                        this.end = 8192;
                        return (long) result;
                    } else {
                        throw new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
                    }
                } else {
                    throw new IllegalArgumentException(("minByteCount > Segment.SIZE: " + minByteCount).toString());
                }
            } else {
                throw new IllegalArgumentException(("minByteCount <= 0: " + minByteCount).toString());
            }
        }

        public void close() {
            if (this.buffer != null) {
                this.buffer = null;
                this.segment = null;
                this.offset = -1;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer".toString());
        }
    }
}
