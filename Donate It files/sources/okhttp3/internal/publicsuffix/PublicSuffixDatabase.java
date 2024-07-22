package okhttp3.internal.publicsuffix;

import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\fJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0016\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "", "()V", "listRead", "Ljava/util/concurrent/atomic/AtomicBoolean;", "publicSuffixExceptionListBytes", "", "publicSuffixListBytes", "readCompleteLatch", "Ljava/util/concurrent/CountDownLatch;", "findMatchingRule", "", "", "domainLabels", "getEffectiveTldPlusOne", "domain", "readTheList", "", "readTheListUninterruptibly", "setListBytes", "Companion", "okhttp"}, k = 1, mv = {1, 1, 16})
/* compiled from: PublicSuffixDatabase.kt */
public final class PublicSuffixDatabase {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final char EXCEPTION_MARKER = '!';
    private static final List<String> PREVAILING_RULE = CollectionsKt.listOf("*");
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    private static final byte[] WILDCARD_LABEL = {(byte) 42};
    /* access modifiers changed from: private */
    public static final PublicSuffixDatabase instance = new PublicSuffixDatabase();
    private final AtomicBoolean listRead = new AtomicBoolean(false);
    private byte[] publicSuffixExceptionListBytes;
    /* access modifiers changed from: private */
    public byte[] publicSuffixListBytes;
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    public static final /* synthetic */ byte[] access$getPublicSuffixListBytes$p(PublicSuffixDatabase $this) {
        byte[] bArr = $this.publicSuffixListBytes;
        if (bArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
        }
        return bArr;
    }

    public final String getEffectiveTldPlusOne(String domain) {
        int firstLabelOffset;
        String str = domain;
        Intrinsics.checkParameterIsNotNull(str, "domain");
        String unicodeDomain = IDN.toUnicode(domain);
        Intrinsics.checkExpressionValueIsNotNull(unicodeDomain, "unicodeDomain");
        List domainLabels = StringsKt.split$default((CharSequence) unicodeDomain, new char[]{'.'}, false, 0, 6, (Object) null);
        List rule = findMatchingRule(domainLabels);
        if (domainLabels.size() == rule.size() && rule.get(0).charAt(0) != '!') {
            return null;
        }
        if (rule.get(0).charAt(0) == '!') {
            firstLabelOffset = domainLabels.size() - rule.size();
        } else {
            firstLabelOffset = domainLabels.size() - (rule.size() + 1);
        }
        return SequencesKt.joinToString$default(SequencesKt.drop(CollectionsKt.asSequence(StringsKt.split$default((CharSequence) str, new char[]{'.'}, false, 0, 6, (Object) null)), firstLabelOffset), ".", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    private final List<String> findMatchingRule(List<String> domainLabels) {
        List exactRuleLabels;
        List wildcardRuleLabels;
        if (this.listRead.get() || !this.listRead.compareAndSet(false, true)) {
            try {
                this.readCompleteLatch.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        } else {
            readTheListUninterruptibly();
        }
        if (this.publicSuffixListBytes != null) {
            int size = domainLabels.size();
            byte[][] bArr = new byte[size][];
            int i = 0;
            while (i < size) {
                String str = domainLabels.get(i);
                Charset charset = StandardCharsets.UTF_8;
                Intrinsics.checkExpressionValueIsNotNull(charset, "UTF_8");
                if (str != null) {
                    byte[] bytes = str.getBytes(charset);
                    Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                    bArr[i] = bytes;
                    i++;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            }
            byte[][] domainLabelsUtf8Bytes = bArr;
            String exactMatch = null;
            int length = domainLabelsUtf8Bytes.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                Companion companion = Companion;
                byte[] bArr2 = this.publicSuffixListBytes;
                if (bArr2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
                }
                String rule = companion.binarySearch(bArr2, domainLabelsUtf8Bytes, i2);
                if (rule != null) {
                    exactMatch = rule;
                    break;
                }
                i2++;
            }
            String wildcardMatch = null;
            if (((Object[]) domainLabelsUtf8Bytes).length > 1) {
                byte[][] labelsWithWildcard = (byte[][]) ((Object[]) domainLabelsUtf8Bytes).clone();
                int length2 = ((Object[]) labelsWithWildcard).length - 1;
                int labelIndex = 0;
                while (true) {
                    if (labelIndex >= length2) {
                        break;
                    }
                    labelsWithWildcard[labelIndex] = WILDCARD_LABEL;
                    Companion companion2 = Companion;
                    byte[] bArr3 = this.publicSuffixListBytes;
                    if (bArr3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
                    }
                    String rule2 = companion2.binarySearch(bArr3, labelsWithWildcard, labelIndex);
                    if (rule2 != null) {
                        wildcardMatch = rule2;
                        break;
                    }
                    labelIndex++;
                }
            }
            String exception = null;
            if (wildcardMatch != null) {
                int length3 = ((Object[]) domainLabelsUtf8Bytes).length - 1;
                int labelIndex2 = 0;
                while (true) {
                    if (labelIndex2 >= length3) {
                        break;
                    }
                    Companion companion3 = Companion;
                    byte[] bArr4 = this.publicSuffixExceptionListBytes;
                    if (bArr4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("publicSuffixExceptionListBytes");
                    }
                    String rule3 = companion3.binarySearch(bArr4, domainLabelsUtf8Bytes, labelIndex2);
                    if (rule3 != null) {
                        exception = rule3;
                        break;
                    }
                    labelIndex2++;
                }
            }
            if (exception != null) {
                return StringsKt.split$default((CharSequence) EXCEPTION_MARKER + exception, new char[]{'.'}, false, 0, 6, (Object) null);
            } else if (exactMatch == null && wildcardMatch == null) {
                return PREVAILING_RULE;
            } else {
                if (exactMatch == null || (exactRuleLabels = StringsKt.split$default((CharSequence) exactMatch, new char[]{'.'}, false, 0, 6, (Object) null)) == null) {
                    exactRuleLabels = CollectionsKt.emptyList();
                }
                if (wildcardMatch == null || (wildcardRuleLabels = StringsKt.split$default((CharSequence) wildcardMatch, new char[]{'.'}, false, 0, 6, (Object) null)) == null) {
                    wildcardRuleLabels = CollectionsKt.emptyList();
                }
                if (exactRuleLabels.size() > wildcardRuleLabels.size()) {
                    return exactRuleLabels;
                }
                return wildcardRuleLabels;
            }
        } else {
            throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.".toString());
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void readTheListUninterruptibly() {
        /*
            r6 = this;
            r0 = 0
        L_0x0002:
            r6.readTheList()     // Catch:{  }
            if (r0 == 0) goto L_0x0011
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ InterruptedIOException -> 0x002f, IOException -> 0x0014 }
            r1.interrupt()     // Catch:{ InterruptedIOException -> 0x002f, IOException -> 0x0014 }
        L_0x0011:
            return
        L_0x0012:
            r1 = move-exception
            goto L_0x0036
        L_0x0014:
            r1 = move-exception
            okhttp3.internal.platform.Platform$Companion r2 = okhttp3.internal.platform.Platform.Companion     // Catch:{ all -> 0x0012 }
            okhttp3.internal.platform.Platform r2 = r2.get()     // Catch:{ all -> 0x0012 }
            java.lang.String r3 = "Failed to read public suffix list"
            r4 = 5
            r5 = r1
            java.lang.Throwable r5 = (java.lang.Throwable) r5     // Catch:{ all -> 0x0012 }
            r2.log(r3, r4, r5)     // Catch:{ all -> 0x0012 }
            if (r0 == 0) goto L_0x002e
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            r2.interrupt()
        L_0x002e:
            return
        L_0x002f:
            r1 = move-exception
            java.lang.Thread.interrupted()     // Catch:{ all -> 0x0012 }
            r0 = 1
            goto L_0x0002
        L_0x0036:
            if (r0 == 0) goto L_0x003f
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            r2.interrupt()
        L_0x003f:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.readTheListUninterruptibly():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0062, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0063, code lost:
        kotlin.io.CloseableKt.closeFinally(r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0066, code lost:
        throw r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void readTheList() throws java.io.IOException {
        /*
            r11 = this;
            r0 = 0
            r1 = r0
            byte[] r1 = (byte[]) r1
            r2 = r0
            byte[] r2 = (byte[]) r2
            java.lang.Class<okhttp3.internal.publicsuffix.PublicSuffixDatabase> r3 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.class
            java.lang.String r4 = "publicsuffixes.gz"
            java.io.InputStream r3 = r3.getResourceAsStream(r4)
            if (r3 == 0) goto L_0x0067
            okio.GzipSource r4 = new okio.GzipSource
            okio.Source r5 = okio.Okio.source((java.io.InputStream) r3)
            r4.<init>(r5)
            okio.Source r4 = (okio.Source) r4
            okio.BufferedSource r4 = okio.Okio.buffer((okio.Source) r4)
            java.io.Closeable r4 = (java.io.Closeable) r4
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r5 = r4
            okio.BufferedSource r5 = (okio.BufferedSource) r5     // Catch:{ all -> 0x0060 }
            r6 = 0
            int r7 = r5.readInt()     // Catch:{ all -> 0x0060 }
            long r8 = (long) r7     // Catch:{ all -> 0x0060 }
            byte[] r8 = r5.readByteArray(r8)     // Catch:{ all -> 0x0060 }
            r1 = r8
            int r8 = r5.readInt()     // Catch:{ all -> 0x0060 }
            long r9 = (long) r8     // Catch:{ all -> 0x0060 }
            byte[] r9 = r5.readByteArray(r9)     // Catch:{ all -> 0x0060 }
            r2 = r9
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0060 }
            kotlin.io.CloseableKt.closeFinally(r4, r0)
            monitor-enter(r11)
            r0 = 0
            if (r1 != 0) goto L_0x004b
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x005d }
        L_0x004b:
            r11.publicSuffixListBytes = r1     // Catch:{ all -> 0x005d }
            if (r2 != 0) goto L_0x0052
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x005d }
        L_0x0052:
            r11.publicSuffixExceptionListBytes = r2     // Catch:{ all -> 0x005d }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x005d }
            monitor-exit(r11)
            java.util.concurrent.CountDownLatch r0 = r11.readCompleteLatch
            r0.countDown()
            return
        L_0x005d:
            r0 = move-exception
            monitor-exit(r11)
            throw r0
        L_0x0060:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0062 }
        L_0x0062:
            r5 = move-exception
            kotlin.io.CloseableKt.closeFinally(r4, r0)
            throw r5
        L_0x0067:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.readTheList():void");
    }

    public final void setListBytes(byte[] publicSuffixListBytes2, byte[] publicSuffixExceptionListBytes2) {
        Intrinsics.checkParameterIsNotNull(publicSuffixListBytes2, "publicSuffixListBytes");
        Intrinsics.checkParameterIsNotNull(publicSuffixExceptionListBytes2, "publicSuffixExceptionListBytes");
        this.publicSuffixListBytes = publicSuffixListBytes2;
        this.publicSuffixExceptionListBytes = publicSuffixExceptionListBytes2;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\fJ)\u0010\u000e\u001a\u0004\u0018\u00010\u0007*\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase$Companion;", "", "()V", "EXCEPTION_MARKER", "", "PREVAILING_RULE", "", "", "PUBLIC_SUFFIX_RESOURCE", "WILDCARD_LABEL", "", "instance", "Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "get", "binarySearch", "labels", "", "labelIndex", "", "([B[[BI)Ljava/lang/String;", "okhttp"}, k = 1, mv = {1, 1, 16})
    /* compiled from: PublicSuffixDatabase.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final PublicSuffixDatabase get() {
            return PublicSuffixDatabase.instance;
        }

        /* access modifiers changed from: private */
        public final String binarySearch(byte[] $this$binarySearch, byte[][] labels, int labelIndex) {
            int byte0;
            int compareResult;
            int low;
            byte[] bArr = $this$binarySearch;
            int low2 = 0;
            int high = bArr.length;
            String match = null;
            while (low2 < high) {
                int mid = (low2 + high) / 2;
                while (mid > -1 && bArr[mid] != ((byte) 10)) {
                    mid--;
                }
                int mid2 = mid + 1;
                int end = 1;
                while (bArr[mid2 + end] != ((byte) 10)) {
                    end++;
                }
                int publicSuffixLength = (mid2 + end) - mid2;
                int currentLabelIndex = labelIndex;
                int currentLabelByteIndex = 0;
                int publicSuffixByteIndex = 0;
                boolean expectDot = false;
                while (true) {
                    if (expectDot) {
                        byte0 = 46;
                        expectDot = false;
                    } else {
                        byte0 = Util.and(labels[currentLabelIndex][currentLabelByteIndex], 255);
                    }
                    compareResult = byte0 - Util.and(bArr[mid2 + publicSuffixByteIndex], 255);
                    if (compareResult == 0) {
                        publicSuffixByteIndex++;
                        currentLabelByteIndex++;
                        if (publicSuffixByteIndex == publicSuffixLength) {
                            break;
                        }
                        if (labels[currentLabelIndex].length != currentLabelByteIndex) {
                            low = low2;
                        } else if (currentLabelIndex == ((Object[]) labels).length - 1) {
                            break;
                        } else {
                            low = low2;
                            currentLabelIndex++;
                            expectDot = true;
                            currentLabelByteIndex = -1;
                        }
                        low2 = low;
                    } else {
                        break;
                    }
                }
                if (compareResult < 0) {
                    high = mid2 - 1;
                } else if (compareResult > 0) {
                    low2 = mid2 + end + 1;
                } else {
                    int low3 = publicSuffixLength - publicSuffixByteIndex;
                    int labelBytesLeft = labels[currentLabelIndex].length - currentLabelByteIndex;
                    int i = currentLabelIndex + 1;
                    int length = ((Object[]) labels).length;
                    while (i < length) {
                        labelBytesLeft += labels[i].length;
                        i++;
                        low2 = low2;
                    }
                    int low4 = low2;
                    if (labelBytesLeft < low3) {
                        high = mid2 - 1;
                        low2 = low4;
                    } else if (labelBytesLeft > low3) {
                        low2 = mid2 + end + 1;
                    } else {
                        Charset charset = StandardCharsets.UTF_8;
                        Intrinsics.checkExpressionValueIsNotNull(charset, "UTF_8");
                        return new String(bArr, mid2, publicSuffixLength, charset);
                    }
                }
            }
            return match;
        }
    }
}
