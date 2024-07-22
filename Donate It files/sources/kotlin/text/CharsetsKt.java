package kotlin.text;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\b¨\u0006\u0004"}, d2 = {"charset", "Ljava/nio/charset/Charset;", "charsetName", "", "kotlin-stdlib"}, k = 2, mv = {1, 1, 16})
/* compiled from: Charsets.kt */
public final class CharsetsKt {
    private static final Charset charset(String charsetName) {
        Charset forName = Charset.forName(charsetName);
        Intrinsics.checkExpressionValueIsNotNull(forName, "Charset.forName(charsetName)");
        return forName;
    }
}
