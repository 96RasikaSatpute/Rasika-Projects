package okhttp3;

import com.google.android.gms.common.internal.ImagesContract;
import com.miniproject.bhojanamv3.utils.Constants;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okio.Buffer;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 J2\u00020\u0001:\u0002IJBa\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\u000f\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b!J\r\u0010\u0011\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\"J\r\u0010\u0012\u001a\u00020\u0003H\u0007¢\u0006\u0002\b#J\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0007¢\u0006\u0002\b$J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b%J\r\u0010\u0016\u001a\u00020\u0003H\u0007¢\u0006\u0002\b&J\u0013\u0010'\u001a\u00020\u00182\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u0002J\u000f\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b)J\b\u0010*\u001a\u00020\bH\u0016J\r\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0002\b+J\u0006\u0010,\u001a\u00020-J\u0010\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\u0003J\r\u0010\u0005\u001a\u00020\u0003H\u0007¢\u0006\u0002\b/J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0007¢\u0006\u0002\b0J\r\u0010\u001a\u001a\u00020\bH\u0007¢\u0006\u0002\b1J\r\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\b2J\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b3J\u0010\u00104\u001a\u0004\u0018\u00010\u00032\u0006\u00105\u001a\u00020\u0003J\u000e\u00106\u001a\u00020\u00032\u0006\u00107\u001a\u00020\bJ\u0013\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001eH\u0007¢\u0006\u0002\b8J\u0010\u00109\u001a\u0004\u0018\u00010\u00032\u0006\u00107\u001a\u00020\bJ\u0016\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\n2\u0006\u00105\u001a\u00020\u0003J\r\u0010 \u001a\u00020\bH\u0007¢\u0006\u0002\b;J\u0006\u0010<\u001a\u00020\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u00002\u0006\u0010.\u001a\u00020\u0003J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b>J\b\u0010?\u001a\u00020\u0003H\u0016J\r\u0010@\u001a\u00020AH\u0007¢\u0006\u0002\bBJ\r\u0010C\u001a\u00020DH\u0007¢\u0006\u0002\b\rJ\b\u0010E\u001a\u0004\u0018\u00010\u0003J\r\u0010B\u001a\u00020AH\u0007¢\u0006\u0002\bFJ\r\u0010\r\u001a\u00020DH\u0007¢\u0006\u0002\bGJ\r\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\bHR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00038G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0012\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\n8G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00038G¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0016\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0010R\u0015\u0010\f\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0010R\u0013\u0010\u0006\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0019R\u0013\u0010\u0005\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0010R\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0014R\u0011\u0010\u001a\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0007\u001a\u00020\b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u00038G¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0010R\u0018\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e8G¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001fR\u0011\u0010 \u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b \u0010\u001bR\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0010R\u000e\u0010\r\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0010¨\u0006K"}, d2 = {"Lokhttp3/HttpUrl;", "", "scheme", "", "username", "password", "host", "port", "", "pathSegments", "", "queryNamesAndValues", "fragment", "url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "encodedFragment", "()Ljava/lang/String;", "encodedPassword", "encodedPath", "encodedPathSegments", "()Ljava/util/List;", "encodedQuery", "encodedUsername", "isHttps", "", "()Z", "pathSize", "()I", "query", "queryParameterNames", "", "()Ljava/util/Set;", "querySize", "-deprecated_encodedFragment", "-deprecated_encodedPassword", "-deprecated_encodedPath", "-deprecated_encodedPathSegments", "-deprecated_encodedQuery", "-deprecated_encodedUsername", "equals", "other", "-deprecated_fragment", "hashCode", "-deprecated_host", "newBuilder", "Lokhttp3/HttpUrl$Builder;", "link", "-deprecated_password", "-deprecated_pathSegments", "-deprecated_pathSize", "-deprecated_port", "-deprecated_query", "queryParameter", "name", "queryParameterName", "index", "-deprecated_queryParameterNames", "queryParameterValue", "queryParameterValues", "-deprecated_querySize", "redact", "resolve", "-deprecated_scheme", "toString", "toUri", "Ljava/net/URI;", "uri", "toUrl", "Ljava/net/URL;", "topPrivateDomain", "-deprecated_uri", "-deprecated_url", "-deprecated_username", "Builder", "Companion", "okhttp"}, k = 1, mv = {1, 1, 16})
/* compiled from: HttpUrl.kt */
public final class HttpUrl {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    public static final String FRAGMENT_ENCODE_SET = "";
    public static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    /* access modifiers changed from: private */
    public static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    public static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
    public static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    public static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";
    public static final String QUERY_ENCODE_SET = " \"'<>#";
    public static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    private final String fragment;
    private final String host;
    private final boolean isHttps;
    private final String password;
    private final List<String> pathSegments;
    private final int port;
    private final List<String> queryNamesAndValues;
    private final String scheme;
    private final String url;
    private final String username;

    @JvmStatic
    public static final int defaultPort(String str) {
        return Companion.defaultPort(str);
    }

    @JvmStatic
    public static final HttpUrl get(String str) {
        return Companion.get(str);
    }

    @JvmStatic
    public static final HttpUrl get(URI uri) {
        return Companion.get(uri);
    }

    @JvmStatic
    public static final HttpUrl get(URL url2) {
        return Companion.get(url2);
    }

    @JvmStatic
    public static final HttpUrl parse(String str) {
        return Companion.parse(str);
    }

    public HttpUrl(String scheme2, String username2, String password2, String host2, int port2, List<String> pathSegments2, List<String> queryNamesAndValues2, String fragment2, String url2) {
        Intrinsics.checkParameterIsNotNull(scheme2, "scheme");
        Intrinsics.checkParameterIsNotNull(username2, Constants.USERNAME);
        Intrinsics.checkParameterIsNotNull(password2, "password");
        Intrinsics.checkParameterIsNotNull(host2, "host");
        Intrinsics.checkParameterIsNotNull(pathSegments2, "pathSegments");
        Intrinsics.checkParameterIsNotNull(url2, ImagesContract.URL);
        this.scheme = scheme2;
        this.username = username2;
        this.password = password2;
        this.host = host2;
        this.port = port2;
        this.pathSegments = pathSegments2;
        this.queryNamesAndValues = queryNamesAndValues2;
        this.fragment = fragment2;
        this.url = url2;
        this.isHttps = Intrinsics.areEqual((Object) scheme2, (Object) "https");
    }

    public final String scheme() {
        return this.scheme;
    }

    public final String username() {
        return this.username;
    }

    public final String password() {
        return this.password;
    }

    public final String host() {
        return this.host;
    }

    public final int port() {
        return this.port;
    }

    public final List<String> pathSegments() {
        return this.pathSegments;
    }

    public final String fragment() {
        return this.fragment;
    }

    public final boolean isHttps() {
        return this.isHttps;
    }

    public final URL url() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public final URI uri() {
        String uri = newBuilder().reencodeForUri$okhttp().toString();
        try {
            return new URI(uri);
        } catch (URISyntaxException e) {
            try {
                URI create = URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").replace((CharSequence) uri, ""));
                Intrinsics.checkExpressionValueIsNotNull(create, "URI.create(stripped)");
                return create;
            } catch (Exception e2) {
                throw new RuntimeException(e);
            }
        }
    }

    public final String encodedUsername() {
        if (this.username.length() == 0) {
            return "";
        }
        int usernameStart = this.scheme.length() + 3;
        String str = this.url;
        int usernameEnd = Util.delimiterOffset(str, ":@", usernameStart, str.length());
        String str2 = this.url;
        if (str2 != null) {
            String substring = str2.substring(usernameStart, usernameEnd);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public final String encodedPassword() {
        if (this.password.length() == 0) {
            return "";
        }
        int passwordStart = StringsKt.indexOf$default((CharSequence) this.url, ':', this.scheme.length() + 3, false, 4, (Object) null) + 1;
        int passwordEnd = StringsKt.indexOf$default((CharSequence) this.url, '@', 0, false, 6, (Object) null);
        String str = this.url;
        if (str != null) {
            String substring = str.substring(passwordStart, passwordEnd);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public final int pathSize() {
        return this.pathSegments.size();
    }

    public final String encodedPath() {
        int pathStart = StringsKt.indexOf$default((CharSequence) this.url, '/', this.scheme.length() + 3, false, 4, (Object) null);
        String str = this.url;
        int pathEnd = Util.delimiterOffset(str, "?#", pathStart, str.length());
        String str2 = this.url;
        if (str2 != null) {
            String substring = str2.substring(pathStart, pathEnd);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public final List<String> encodedPathSegments() {
        int pathStart = StringsKt.indexOf$default((CharSequence) this.url, '/', this.scheme.length() + 3, false, 4, (Object) null);
        String str = this.url;
        int pathEnd = Util.delimiterOffset(str, "?#", pathStart, str.length());
        List result = new ArrayList();
        int i = pathStart;
        while (i < pathEnd) {
            int i2 = i + 1;
            int segmentEnd = Util.delimiterOffset(this.url, '/', i2, pathEnd);
            String str2 = this.url;
            if (str2 != null) {
                String substring = str2.substring(i2, segmentEnd);
                Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                result.add(substring);
                i = segmentEnd;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
        }
        return result;
    }

    public final String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int queryStart = StringsKt.indexOf$default((CharSequence) this.url, '?', 0, false, 6, (Object) null) + 1;
        String str = this.url;
        int queryEnd = Util.delimiterOffset(str, '#', queryStart, str.length());
        String str2 = this.url;
        if (str2 != null) {
            String substring = str2.substring(queryStart, queryEnd);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public final String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        Companion.toQueryString$okhttp(this.queryNamesAndValues, result);
        return result.toString();
    }

    public final int querySize() {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    public final String queryParameter(String name) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            return null;
        }
        IntProgression step = RangesKt.step((IntProgression) RangesKt.until(0, list.size()), 2);
        int i = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if (step2 < 0 ? i >= last : i <= last) {
            while (!Intrinsics.areEqual((Object) name, (Object) this.queryNamesAndValues.get(i))) {
                if (i != last) {
                    i += step2;
                }
            }
            return this.queryNamesAndValues.get(i + 1);
        }
        return null;
    }

    public final Set<String> queryParameterNames() {
        if (this.queryNamesAndValues == null) {
            return SetsKt.emptySet();
        }
        LinkedHashSet result = new LinkedHashSet();
        IntProgression step = RangesKt.step((IntProgression) RangesKt.until(0, this.queryNamesAndValues.size()), 2);
        int i = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if (step2 < 0 ? i >= last : i <= last) {
            while (true) {
                String str = this.queryNamesAndValues.get(i);
                if (str == null) {
                    Intrinsics.throwNpe();
                }
                result.add(str);
                if (i == last) {
                    break;
                }
                i += step2;
            }
        }
        Set<String> unmodifiableSet = Collections.unmodifiableSet(result);
        Intrinsics.checkExpressionValueIsNotNull(unmodifiableSet, "Collections.unmodifiableSet(result)");
        return unmodifiableSet;
    }

    public final List<String> queryParameterValues(String name) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        if (this.queryNamesAndValues == null) {
            return CollectionsKt.emptyList();
        }
        List result = new ArrayList();
        IntProgression step = RangesKt.step((IntProgression) RangesKt.until(0, this.queryNamesAndValues.size()), 2);
        int i = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if (step2 < 0 ? i >= last : i <= last) {
            while (true) {
                if (Intrinsics.areEqual((Object) name, (Object) this.queryNamesAndValues.get(i))) {
                    result.add(this.queryNamesAndValues.get(i + 1));
                }
                if (i == last) {
                    break;
                }
                i += step2;
            }
        }
        List<String> unmodifiableList = Collections.unmodifiableList(result);
        Intrinsics.checkExpressionValueIsNotNull(unmodifiableList, "Collections.unmodifiableList(result)");
        return unmodifiableList;
    }

    public final String queryParameterName(int index) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            String str = list.get(index * 2);
            if (str == null) {
                Intrinsics.throwNpe();
            }
            return str;
        }
        throw new IndexOutOfBoundsException();
    }

    public final String queryParameterValue(int index) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.get((index * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    public final String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        int fragmentStart = StringsKt.indexOf$default((CharSequence) this.url, '#', 0, false, 6, (Object) null) + 1;
        String str = this.url;
        if (str != null) {
            String substring = str.substring(fragmentStart);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public final String redact() {
        Builder newBuilder = newBuilder("/...");
        if (newBuilder == null) {
            Intrinsics.throwNpe();
        }
        return newBuilder.username("").password("").build().toString();
    }

    public final HttpUrl resolve(String link) {
        Intrinsics.checkParameterIsNotNull(link, "link");
        Builder newBuilder = newBuilder(link);
        if (newBuilder != null) {
            return newBuilder.build();
        }
        return null;
    }

    public final Builder newBuilder() {
        Builder result = new Builder();
        result.setScheme$okhttp(this.scheme);
        result.setEncodedUsername$okhttp(encodedUsername());
        result.setEncodedPassword$okhttp(encodedPassword());
        result.setHost$okhttp(this.host);
        result.setPort$okhttp(this.port != Companion.defaultPort(this.scheme) ? this.port : -1);
        result.getEncodedPathSegments$okhttp().clear();
        result.getEncodedPathSegments$okhttp().addAll(encodedPathSegments());
        result.encodedQuery(encodedQuery());
        result.setEncodedFragment$okhttp(encodedFragment());
        return result;
    }

    public final Builder newBuilder(String link) {
        Intrinsics.checkParameterIsNotNull(link, "link");
        try {
            return new Builder().parse$okhttp(this, link);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public boolean equals(Object other) {
        return (other instanceof HttpUrl) && Intrinsics.areEqual((Object) ((HttpUrl) other).url, (Object) this.url);
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public String toString() {
        return this.url;
    }

    public final String topPrivateDomain() {
        if (Util.canParseAsIpAddress(this.host)) {
            return null;
        }
        return PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(this.host);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to toUrl()", replaceWith = @ReplaceWith(expression = "toUrl()", imports = {}))
    /* renamed from: -deprecated_url  reason: not valid java name */
    public final URL m1078deprecated_url() {
        return url();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to toUri()", replaceWith = @ReplaceWith(expression = "toUri()", imports = {}))
    /* renamed from: -deprecated_uri  reason: not valid java name */
    public final URI m1077deprecated_uri() {
        return uri();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "scheme", imports = {}))
    /* renamed from: -deprecated_scheme  reason: not valid java name */
    public final String m1076deprecated_scheme() {
        return this.scheme;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedUsername", imports = {}))
    /* renamed from: -deprecated_encodedUsername  reason: not valid java name */
    public final String m1066deprecated_encodedUsername() {
        return encodedUsername();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "username", imports = {}))
    /* renamed from: -deprecated_username  reason: not valid java name */
    public final String m1079deprecated_username() {
        return this.username;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedPassword", imports = {}))
    /* renamed from: -deprecated_encodedPassword  reason: not valid java name */
    public final String m1062deprecated_encodedPassword() {
        return encodedPassword();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "password", imports = {}))
    /* renamed from: -deprecated_password  reason: not valid java name */
    public final String m1069deprecated_password() {
        return this.password;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "host", imports = {}))
    /* renamed from: -deprecated_host  reason: not valid java name */
    public final String m1068deprecated_host() {
        return this.host;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "port", imports = {}))
    /* renamed from: -deprecated_port  reason: not valid java name */
    public final int m1072deprecated_port() {
        return this.port;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "pathSize", imports = {}))
    /* renamed from: -deprecated_pathSize  reason: not valid java name */
    public final int m1071deprecated_pathSize() {
        return pathSize();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedPath", imports = {}))
    /* renamed from: -deprecated_encodedPath  reason: not valid java name */
    public final String m1063deprecated_encodedPath() {
        return encodedPath();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedPathSegments", imports = {}))
    /* renamed from: -deprecated_encodedPathSegments  reason: not valid java name */
    public final List<String> m1064deprecated_encodedPathSegments() {
        return encodedPathSegments();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "pathSegments", imports = {}))
    /* renamed from: -deprecated_pathSegments  reason: not valid java name */
    public final List<String> m1070deprecated_pathSegments() {
        return this.pathSegments;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedQuery", imports = {}))
    /* renamed from: -deprecated_encodedQuery  reason: not valid java name */
    public final String m1065deprecated_encodedQuery() {
        return encodedQuery();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "query", imports = {}))
    /* renamed from: -deprecated_query  reason: not valid java name */
    public final String m1073deprecated_query() {
        return query();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "querySize", imports = {}))
    /* renamed from: -deprecated_querySize  reason: not valid java name */
    public final int m1075deprecated_querySize() {
        return querySize();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "queryParameterNames", imports = {}))
    /* renamed from: -deprecated_queryParameterNames  reason: not valid java name */
    public final Set<String> m1074deprecated_queryParameterNames() {
        return queryParameterNames();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedFragment", imports = {}))
    /* renamed from: -deprecated_encodedFragment  reason: not valid java name */
    public final String m1061deprecated_encodedFragment() {
        return encodedFragment();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "fragment", imports = {}))
    /* renamed from: -deprecated_fragment  reason: not valid java name */
    public final String m1067deprecated_fragment() {
        return this.fragment;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0017\u0018\u0000 V2\u00020\u0001:\u0001VB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u0004J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0004J\u0018\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010\u0004J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0004J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0004J\u0018\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020.H\u0002J\u0018\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u00010\u0004J\u0006\u00102\u001a\u000203J\b\u00104\u001a\u00020\u001bH\u0002J\u0010\u0010\u0003\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0004J\u000e\u00105\u001a\u00020\u00002\u0006\u00105\u001a\u00020\u0004J\u0010\u00106\u001a\u00020\u00002\b\u00106\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0004J\u0010\u00107\u001a\u00020\u00002\b\u00107\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0004J\u0010\u00108\u001a\u00020.2\u0006\u00109\u001a\u00020\u0004H\u0002J\u0010\u0010:\u001a\u00020.2\u0006\u00109\u001a\u00020\u0004H\u0002J\u001f\u0010;\u001a\u00020\u00002\b\u0010<\u001a\u0004\u0018\u0001032\u0006\u00109\u001a\u00020\u0004H\u0000¢\u0006\u0002\b=J\u000e\u0010>\u001a\u00020\u00002\u0006\u0010>\u001a\u00020\u0004J\b\u0010?\u001a\u00020@H\u0002J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001bJ0\u0010A\u001a\u00020@2\u0006\u00109\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020\u001b2\u0006\u0010D\u001a\u00020.2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010E\u001a\u00020\u00002\b\u0010E\u001a\u0004\u0018\u00010\u0004J\r\u0010F\u001a\u00020\u0000H\u0000¢\u0006\u0002\bGJ\u0010\u0010H\u001a\u00020@2\u0006\u0010I\u001a\u00020\u0004H\u0002J\u000e\u0010J\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u0004J\u000e\u0010K\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u0004J\u000e\u0010L\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u001bJ \u0010N\u001a\u00020@2\u0006\u00109\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020\u001bH\u0002J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0004J\u0016\u0010P\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u0004J\u0018\u0010Q\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010\u0004J\u0016\u0010R\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u0004J\u0018\u0010S\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u00010\u0004J\b\u0010T\u001a\u00020\u0004H\u0016J\u000e\u0010U\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000f\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\u001a\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\b¨\u0006W"}, d2 = {"Lokhttp3/HttpUrl$Builder;", "", "()V", "encodedFragment", "", "getEncodedFragment$okhttp", "()Ljava/lang/String;", "setEncodedFragment$okhttp", "(Ljava/lang/String;)V", "encodedPassword", "getEncodedPassword$okhttp", "setEncodedPassword$okhttp", "encodedPathSegments", "", "getEncodedPathSegments$okhttp", "()Ljava/util/List;", "encodedQueryNamesAndValues", "getEncodedQueryNamesAndValues$okhttp", "setEncodedQueryNamesAndValues$okhttp", "(Ljava/util/List;)V", "encodedUsername", "getEncodedUsername$okhttp", "setEncodedUsername$okhttp", "host", "getHost$okhttp", "setHost$okhttp", "port", "", "getPort$okhttp", "()I", "setPort$okhttp", "(I)V", "scheme", "getScheme$okhttp", "setScheme$okhttp", "addEncodedPathSegment", "encodedPathSegment", "addEncodedPathSegments", "addEncodedQueryParameter", "encodedName", "encodedValue", "addPathSegment", "pathSegment", "addPathSegments", "pathSegments", "alreadyEncoded", "", "addQueryParameter", "name", "value", "build", "Lokhttp3/HttpUrl;", "effectivePort", "encodedPath", "encodedQuery", "fragment", "isDot", "input", "isDotDot", "parse", "base", "parse$okhttp", "password", "pop", "", "push", "pos", "limit", "addTrailingSlash", "query", "reencodeForUri", "reencodeForUri$okhttp", "removeAllCanonicalQueryParameters", "canonicalName", "removeAllEncodedQueryParameters", "removeAllQueryParameters", "removePathSegment", "index", "resolvePath", "startPos", "setEncodedPathSegment", "setEncodedQueryParameter", "setPathSegment", "setQueryParameter", "toString", "username", "Companion", "okhttp"}, k = 1, mv = {1, 1, 16})
    /* compiled from: HttpUrl.kt */
    public static final class Builder {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final String INVALID_HOST = "Invalid URL host";
        private String encodedFragment;
        private String encodedPassword = "";
        private final List<String> encodedPathSegments;
        private List<String> encodedQueryNamesAndValues;
        private String encodedUsername = "";
        private String host;
        private int port = -1;
        private String scheme;

        public Builder() {
            List<String> arrayList = new ArrayList<>();
            this.encodedPathSegments = arrayList;
            arrayList.add("");
        }

        public final String getScheme$okhttp() {
            return this.scheme;
        }

        public final void setScheme$okhttp(String str) {
            this.scheme = str;
        }

        public final String getEncodedUsername$okhttp() {
            return this.encodedUsername;
        }

        public final void setEncodedUsername$okhttp(String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.encodedUsername = str;
        }

        public final String getEncodedPassword$okhttp() {
            return this.encodedPassword;
        }

        public final void setEncodedPassword$okhttp(String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.encodedPassword = str;
        }

        public final String getHost$okhttp() {
            return this.host;
        }

        public final void setHost$okhttp(String str) {
            this.host = str;
        }

        public final int getPort$okhttp() {
            return this.port;
        }

        public final void setPort$okhttp(int i) {
            this.port = i;
        }

        public final List<String> getEncodedPathSegments$okhttp() {
            return this.encodedPathSegments;
        }

        public final List<String> getEncodedQueryNamesAndValues$okhttp() {
            return this.encodedQueryNamesAndValues;
        }

        public final void setEncodedQueryNamesAndValues$okhttp(List<String> list) {
            this.encodedQueryNamesAndValues = list;
        }

        public final String getEncodedFragment$okhttp() {
            return this.encodedFragment;
        }

        public final void setEncodedFragment$okhttp(String str) {
            this.encodedFragment = str;
        }

        public final Builder scheme(String scheme2) {
            Intrinsics.checkParameterIsNotNull(scheme2, "scheme");
            Builder $this$apply = this;
            if (StringsKt.equals(scheme2, "http", true)) {
                $this$apply.scheme = "http";
            } else if (StringsKt.equals(scheme2, "https", true)) {
                $this$apply.scheme = "https";
            } else {
                throw new IllegalArgumentException("unexpected scheme: " + scheme2);
            }
            return this;
        }

        public final Builder username(String username) {
            Intrinsics.checkParameterIsNotNull(username, Constants.USERNAME);
            this.encodedUsername = Companion.canonicalize$okhttp$default(HttpUrl.Companion, username, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, (Charset) null, 251, (Object) null);
            return this;
        }

        public final Builder encodedUsername(String encodedUsername2) {
            Intrinsics.checkParameterIsNotNull(encodedUsername2, "encodedUsername");
            this.encodedUsername = Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedUsername2, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, (Charset) null, 243, (Object) null);
            return this;
        }

        public final Builder password(String password) {
            Intrinsics.checkParameterIsNotNull(password, "password");
            this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.Companion, password, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, (Charset) null, 251, (Object) null);
            return this;
        }

        public final Builder encodedPassword(String encodedPassword2) {
            Intrinsics.checkParameterIsNotNull(encodedPassword2, "encodedPassword");
            this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedPassword2, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, (Charset) null, 243, (Object) null);
            return this;
        }

        public final Builder host(String host2) {
            Intrinsics.checkParameterIsNotNull(host2, "host");
            Builder $this$apply = this;
            String encoded = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, host2, 0, 0, false, 7, (Object) null));
            if (encoded != null) {
                $this$apply.host = encoded;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + host2);
        }

        public final Builder port(int port2) {
            Builder $this$apply = this;
            boolean z = true;
            if (1 > port2 || 65535 < port2) {
                z = false;
            }
            if (z) {
                $this$apply.port = port2;
                return this;
            }
            throw new IllegalArgumentException(("unexpected port: " + port2).toString());
        }

        private final int effectivePort() {
            int i = this.port;
            if (i != -1) {
                return i;
            }
            Companion companion = HttpUrl.Companion;
            String str = this.scheme;
            if (str == null) {
                Intrinsics.throwNpe();
            }
            return companion.defaultPort(str);
        }

        public final Builder addPathSegment(String pathSegment) {
            Intrinsics.checkParameterIsNotNull(pathSegment, "pathSegment");
            push(pathSegment, 0, pathSegment.length(), false, false);
            return this;
        }

        public final Builder addPathSegments(String pathSegments) {
            Intrinsics.checkParameterIsNotNull(pathSegments, "pathSegments");
            return addPathSegments(pathSegments, false);
        }

        public final Builder addEncodedPathSegment(String encodedPathSegment) {
            Intrinsics.checkParameterIsNotNull(encodedPathSegment, "encodedPathSegment");
            push(encodedPathSegment, 0, encodedPathSegment.length(), false, true);
            return this;
        }

        public final Builder addEncodedPathSegments(String encodedPathSegments2) {
            Intrinsics.checkParameterIsNotNull(encodedPathSegments2, "encodedPathSegments");
            return addPathSegments(encodedPathSegments2, true);
        }

        private final Builder addPathSegments(String pathSegments, boolean alreadyEncoded) {
            Builder $this$apply = this;
            int offset = 0;
            do {
                int segmentEnd = Util.delimiterOffset(pathSegments, "/\\", offset, pathSegments.length());
                $this$apply.push(pathSegments, offset, segmentEnd, segmentEnd < pathSegments.length(), alreadyEncoded);
                offset = segmentEnd + 1;
            } while (offset <= pathSegments.length());
            return this;
        }

        public final Builder setPathSegment(int index, String pathSegment) {
            String str = pathSegment;
            Intrinsics.checkParameterIsNotNull(str, "pathSegment");
            Builder $this$apply = this;
            String canonicalPathSegment = Companion.canonicalize$okhttp$default(HttpUrl.Companion, pathSegment, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, false, false, false, false, (Charset) null, 251, (Object) null);
            if (!$this$apply.isDot(canonicalPathSegment) && !$this$apply.isDotDot(canonicalPathSegment)) {
                $this$apply.encodedPathSegments.set(index, canonicalPathSegment);
                return this;
            }
            int i = index;
            throw new IllegalArgumentException(("unexpected path segment: " + str).toString());
        }

        public final Builder setEncodedPathSegment(int index, String encodedPathSegment) {
            String str = encodedPathSegment;
            Intrinsics.checkParameterIsNotNull(str, "encodedPathSegment");
            Builder $this$apply = this;
            String canonicalPathSegment = Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedPathSegment, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, true, false, false, false, (Charset) null, 243, (Object) null);
            $this$apply.encodedPathSegments.set(index, canonicalPathSegment);
            if (!$this$apply.isDot(canonicalPathSegment) && !$this$apply.isDotDot(canonicalPathSegment)) {
                return this;
            }
            throw new IllegalArgumentException(("unexpected path segment: " + str).toString());
        }

        public final Builder removePathSegment(int index) {
            Builder $this$apply = this;
            $this$apply.encodedPathSegments.remove(index);
            if ($this$apply.encodedPathSegments.isEmpty()) {
                $this$apply.encodedPathSegments.add("");
            }
            return this;
        }

        public final Builder encodedPath(String encodedPath) {
            Intrinsics.checkParameterIsNotNull(encodedPath, "encodedPath");
            Builder $this$apply = this;
            if (StringsKt.startsWith$default(encodedPath, "/", false, 2, (Object) null)) {
                $this$apply.resolvePath(encodedPath, 0, encodedPath.length());
                return this;
            }
            throw new IllegalArgumentException(("unexpected encodedPath: " + encodedPath).toString());
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
            r2 = okhttp3.HttpUrl.Companion.canonicalize$okhttp$default(okhttp3.HttpUrl.Companion, r15, 0, 0, okhttp3.HttpUrl.QUERY_ENCODE_SET, false, false, true, false, (java.nio.charset.Charset) null, 219, (java.lang.Object) null);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final okhttp3.HttpUrl.Builder query(java.lang.String r15) {
            /*
                r14 = this;
                r0 = r14
                okhttp3.HttpUrl$Builder r0 = (okhttp3.HttpUrl.Builder) r0
                r1 = 0
                if (r15 == 0) goto L_0x0023
                okhttp3.HttpUrl$Companion r2 = okhttp3.HttpUrl.Companion
                r4 = 0
                r5 = 0
                r7 = 0
                r8 = 0
                r9 = 1
                r10 = 0
                r11 = 0
                r12 = 219(0xdb, float:3.07E-43)
                r13 = 0
                java.lang.String r6 = " \"'<>#"
                r3 = r15
                java.lang.String r2 = okhttp3.HttpUrl.Companion.canonicalize$okhttp$default(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
                if (r2 == 0) goto L_0x0023
                okhttp3.HttpUrl$Companion r3 = okhttp3.HttpUrl.Companion
                java.util.List r2 = r3.toQueryNamesAndValues$okhttp(r2)
                goto L_0x0024
            L_0x0023:
                r2 = 0
            L_0x0024:
                r0.encodedQueryNamesAndValues = r2
                r0 = r14
                okhttp3.HttpUrl$Builder r0 = (okhttp3.HttpUrl.Builder) r0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Builder.query(java.lang.String):okhttp3.HttpUrl$Builder");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
            r2 = okhttp3.HttpUrl.Companion.canonicalize$okhttp$default(okhttp3.HttpUrl.Companion, r15, 0, 0, okhttp3.HttpUrl.QUERY_ENCODE_SET, true, false, true, false, (java.nio.charset.Charset) null, 211, (java.lang.Object) null);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final okhttp3.HttpUrl.Builder encodedQuery(java.lang.String r15) {
            /*
                r14 = this;
                r0 = r14
                okhttp3.HttpUrl$Builder r0 = (okhttp3.HttpUrl.Builder) r0
                r1 = 0
                if (r15 == 0) goto L_0x0024
                okhttp3.HttpUrl$Companion r2 = okhttp3.HttpUrl.Companion
                r4 = 0
                r5 = 0
                r7 = 1
                r8 = 0
                r9 = 1
                r10 = 0
                r11 = 0
                r12 = 211(0xd3, float:2.96E-43)
                r13 = 0
                java.lang.String r6 = " \"'<>#"
                r3 = r15
                java.lang.String r2 = okhttp3.HttpUrl.Companion.canonicalize$okhttp$default(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
                if (r2 == 0) goto L_0x0024
                okhttp3.HttpUrl$Companion r3 = okhttp3.HttpUrl.Companion
                java.util.List r2 = r3.toQueryNamesAndValues$okhttp(r2)
                goto L_0x0025
            L_0x0024:
                r2 = 0
            L_0x0025:
                r0.encodedQueryNamesAndValues = r2
                r0 = r14
                okhttp3.HttpUrl$Builder r0 = (okhttp3.HttpUrl.Builder) r0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Builder.encodedQuery(java.lang.String):okhttp3.HttpUrl$Builder");
        }

        public final Builder addQueryParameter(String name, String value) {
            Intrinsics.checkParameterIsNotNull(name, "name");
            Builder $this$apply = this;
            if ($this$apply.encodedQueryNamesAndValues == null) {
                $this$apply.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = $this$apply.encodedQueryNamesAndValues;
            if (list == null) {
                Intrinsics.throwNpe();
            }
            list.add(Companion.canonicalize$okhttp$default(HttpUrl.Companion, name, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, (Charset) null, 219, (Object) null));
            List<String> list2 = $this$apply.encodedQueryNamesAndValues;
            if (list2 == null) {
                Intrinsics.throwNpe();
            }
            list2.add(value != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, value, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, (Charset) null, 219, (Object) null) : null);
            return this;
        }

        public final Builder addEncodedQueryParameter(String encodedName, String encodedValue) {
            Intrinsics.checkParameterIsNotNull(encodedName, "encodedName");
            Builder $this$apply = this;
            if ($this$apply.encodedQueryNamesAndValues == null) {
                $this$apply.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = $this$apply.encodedQueryNamesAndValues;
            if (list == null) {
                Intrinsics.throwNpe();
            }
            list.add(Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedName, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, (Charset) null, 211, (Object) null));
            List<String> list2 = $this$apply.encodedQueryNamesAndValues;
            if (list2 == null) {
                Intrinsics.throwNpe();
            }
            list2.add(encodedValue != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedValue, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, (Charset) null, 211, (Object) null) : null);
            return this;
        }

        public final Builder setQueryParameter(String name, String value) {
            Intrinsics.checkParameterIsNotNull(name, "name");
            Builder $this$apply = this;
            $this$apply.removeAllQueryParameters(name);
            $this$apply.addQueryParameter(name, value);
            return this;
        }

        public final Builder setEncodedQueryParameter(String encodedName, String encodedValue) {
            Intrinsics.checkParameterIsNotNull(encodedName, "encodedName");
            Builder $this$apply = this;
            $this$apply.removeAllEncodedQueryParameters(encodedName);
            $this$apply.addEncodedQueryParameter(encodedName, encodedValue);
            return this;
        }

        public final Builder removeAllQueryParameters(String name) {
            Intrinsics.checkParameterIsNotNull(name, "name");
            Builder $this$apply = this;
            if ($this$apply.encodedQueryNamesAndValues == null) {
                return $this$apply;
            }
            $this$apply.removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, name, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, (Charset) null, 219, (Object) null));
            return this;
        }

        public final Builder removeAllEncodedQueryParameters(String encodedName) {
            Intrinsics.checkParameterIsNotNull(encodedName, "encodedName");
            Builder $this$apply = this;
            if ($this$apply.encodedQueryNamesAndValues == null) {
                return $this$apply;
            }
            $this$apply.removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedName, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, (Charset) null, 211, (Object) null));
            return this;
        }

        private final void removeAllCanonicalQueryParameters(String canonicalName) {
            List<String> list = this.encodedQueryNamesAndValues;
            if (list == null) {
                Intrinsics.throwNpe();
            }
            IntProgression step = RangesKt.step(RangesKt.downTo(list.size() - 2, 0), 2);
            int i = step.getFirst();
            int last = step.getLast();
            int step2 = step.getStep();
            if (step2 >= 0) {
                if (i > last) {
                    return;
                }
            } else if (i < last) {
                return;
            }
            while (true) {
                List<String> list2 = this.encodedQueryNamesAndValues;
                if (list2 == null) {
                    Intrinsics.throwNpe();
                }
                if (Intrinsics.areEqual((Object) canonicalName, (Object) list2.get(i))) {
                    List<String> list3 = this.encodedQueryNamesAndValues;
                    if (list3 == null) {
                        Intrinsics.throwNpe();
                    }
                    list3.remove(i + 1);
                    List<String> list4 = this.encodedQueryNamesAndValues;
                    if (list4 == null) {
                        Intrinsics.throwNpe();
                    }
                    list4.remove(i);
                    List<String> list5 = this.encodedQueryNamesAndValues;
                    if (list5 == null) {
                        Intrinsics.throwNpe();
                    }
                    if (list5.isEmpty()) {
                        this.encodedQueryNamesAndValues = null;
                        return;
                    }
                }
                if (i != last) {
                    i += step2;
                } else {
                    return;
                }
            }
        }

        public final Builder fragment(String fragment) {
            this.encodedFragment = fragment != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, fragment, 0, 0, "", false, false, false, true, (Charset) null, 187, (Object) null) : null;
            return this;
        }

        public final Builder encodedFragment(String encodedFragment2) {
            this.encodedFragment = encodedFragment2 != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedFragment2, 0, 0, "", true, false, false, true, (Charset) null, 179, (Object) null) : null;
            return this;
        }

        public final Builder reencodeForUri$okhttp() {
            Builder $this$apply = this;
            String str = $this$apply.host;
            String str2 = null;
            $this$apply.host = str != null ? new Regex("[\"<>^`{|}]").replace((CharSequence) str, "") : null;
            int size = $this$apply.encodedPathSegments.size();
            for (int i = 0; i < size; i++) {
                $this$apply.encodedPathSegments.set(i, Companion.canonicalize$okhttp$default(HttpUrl.Companion, $this$apply.encodedPathSegments.get(i), 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, false, (Charset) null, 227, (Object) null));
            }
            List encodedQueryNamesAndValues2 = $this$apply.encodedQueryNamesAndValues;
            if (encodedQueryNamesAndValues2 != null) {
                int size2 = encodedQueryNamesAndValues2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str3 = encodedQueryNamesAndValues2.get(i2);
                    encodedQueryNamesAndValues2.set(i2, str3 != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str3, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, false, (Charset) null, 195, (Object) null) : null);
                }
            }
            String str4 = $this$apply.encodedFragment;
            if (str4 != null) {
                str2 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str4, 0, 0, HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, true, (Charset) null, 163, (Object) null);
            }
            $this$apply.encodedFragment = str2;
            return this;
        }

        public final HttpUrl build() {
            String str = this.scheme;
            if (str != null) {
                String percentDecode$okhttp$default = Companion.percentDecode$okhttp$default(HttpUrl.Companion, this.encodedUsername, 0, 0, false, 7, (Object) null);
                String percentDecode$okhttp$default2 = Companion.percentDecode$okhttp$default(HttpUrl.Companion, this.encodedPassword, 0, 0, false, 7, (Object) null);
                String str2 = this.host;
                if (str2 != null) {
                    int effectivePort = effectivePort();
                    List percentDecode$default = Companion.percentDecode$default(HttpUrl.Companion, this.encodedPathSegments, false, 1, (Object) null);
                    if (percentDecode$default != null) {
                        List<String> list = this.encodedQueryNamesAndValues;
                        List access$percentDecode = list != null ? HttpUrl.Companion.percentDecode(list, true) : null;
                        String str3 = this.encodedFragment;
                        return new HttpUrl(str, percentDecode$okhttp$default, percentDecode$okhttp$default2, str2, effectivePort, percentDecode$default, access$percentDecode, str3 != null ? Companion.percentDecode$okhttp$default(HttpUrl.Companion, str3, 0, 0, false, 7, (Object) null) : null, toString());
                    }
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x003a, code lost:
            if ((r8.encodedPassword.length() > 0) != false) goto L_0x003c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a3, code lost:
            if (r3 != r4.defaultPort(r5)) goto L_0x00a5;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String toString() {
            /*
                r8 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r1 = r0
                r2 = 0
                java.lang.String r3 = r8.scheme
                if (r3 == 0) goto L_0x0014
                r1.append(r3)
                java.lang.String r3 = "://"
                r1.append(r3)
                goto L_0x0019
            L_0x0014:
                java.lang.String r3 = "//"
                r1.append(r3)
            L_0x0019:
                java.lang.String r3 = r8.encodedUsername
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                int r3 = r3.length()
                r4 = 1
                r5 = 0
                if (r3 <= 0) goto L_0x0028
                r3 = r4
                goto L_0x0029
            L_0x0028:
                r3 = r5
            L_0x0029:
                r6 = 58
                if (r3 != 0) goto L_0x003c
                java.lang.String r3 = r8.encodedPassword
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                int r3 = r3.length()
                if (r3 <= 0) goto L_0x0039
                r3 = r4
                goto L_0x003a
            L_0x0039:
                r3 = r5
            L_0x003a:
                if (r3 == 0) goto L_0x005c
            L_0x003c:
                java.lang.String r3 = r8.encodedUsername
                r1.append(r3)
                java.lang.String r3 = r8.encodedPassword
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                int r3 = r3.length()
                if (r3 <= 0) goto L_0x004c
                goto L_0x004d
            L_0x004c:
                r4 = r5
            L_0x004d:
                if (r4 == 0) goto L_0x0057
                r1.append(r6)
                java.lang.String r3 = r8.encodedPassword
                r1.append(r3)
            L_0x0057:
                r3 = 64
                r1.append(r3)
            L_0x005c:
                java.lang.String r3 = r8.host
                if (r3 == 0) goto L_0x0084
                if (r3 != 0) goto L_0x0065
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x0065:
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                r4 = 2
                r7 = 0
                boolean r3 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r3, (char) r6, (boolean) r5, (int) r4, (java.lang.Object) r7)
                if (r3 == 0) goto L_0x007f
                r3 = 91
                r1.append(r3)
                java.lang.String r3 = r8.host
                r1.append(r3)
                r3 = 93
                r1.append(r3)
                goto L_0x0084
            L_0x007f:
                java.lang.String r3 = r8.host
                r1.append(r3)
            L_0x0084:
                int r3 = r8.port
                r4 = -1
                if (r3 != r4) goto L_0x008e
                java.lang.String r3 = r8.scheme
                if (r3 == 0) goto L_0x00ab
            L_0x008e:
                int r3 = r8.effectivePort()
                java.lang.String r4 = r8.scheme
                if (r4 == 0) goto L_0x00a5
                okhttp3.HttpUrl$Companion r4 = okhttp3.HttpUrl.Companion
                java.lang.String r5 = r8.scheme
                if (r5 != 0) goto L_0x009f
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x009f:
                int r4 = r4.defaultPort(r5)
                if (r3 == r4) goto L_0x00ab
            L_0x00a5:
                r1.append(r6)
                r1.append(r3)
            L_0x00ab:
                okhttp3.HttpUrl$Companion r3 = okhttp3.HttpUrl.Companion
                java.util.List<java.lang.String> r4 = r8.encodedPathSegments
                r3.toPathString$okhttp(r4, r1)
                java.util.List<java.lang.String> r3 = r8.encodedQueryNamesAndValues
                if (r3 == 0) goto L_0x00c7
                r3 = 63
                r1.append(r3)
                okhttp3.HttpUrl$Companion r3 = okhttp3.HttpUrl.Companion
                java.util.List<java.lang.String> r4 = r8.encodedQueryNamesAndValues
                if (r4 != 0) goto L_0x00c4
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x00c4:
                r3.toQueryString$okhttp(r4, r1)
            L_0x00c7:
                java.lang.String r3 = r8.encodedFragment
                if (r3 == 0) goto L_0x00d5
                r3 = 35
                r1.append(r3)
                java.lang.String r3 = r8.encodedFragment
                r1.append(r3)
            L_0x00d5:
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "StringBuilder().apply(builderAction).toString()"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Builder.toString():java.lang.String");
        }

        public final Builder parse$okhttp(HttpUrl base, String input) {
            int limit;
            int pos;
            int componentDelimiterOffset;
            char c;
            char c2;
            String str;
            String str2;
            int limit2;
            int schemeDelimiterOffset;
            boolean z;
            int slashCount;
            int limit3;
            String str3;
            String str4 = input;
            Intrinsics.checkParameterIsNotNull(str4, "input");
            int pos2 = Util.indexOfFirstNonAsciiWhitespace$default(str4, 0, 0, 3, (Object) null);
            int limit4 = Util.indexOfLastNonAsciiWhitespace$default(str4, pos2, 0, 2, (Object) null);
            Companion companion = Companion;
            int schemeDelimiterOffset2 = companion.schemeDelimiterOffset(str4, pos2, limit4);
            String str5 = "(this as java.lang.Strin…ing(startIndex, endIndex)";
            char c3 = 65535;
            boolean z2 = true;
            if (schemeDelimiterOffset2 != -1) {
                if (StringsKt.startsWith(str4, "https:", pos2, true)) {
                    this.scheme = "https";
                    pos2 += "https:".length();
                } else if (StringsKt.startsWith(str4, "http:", pos2, true)) {
                    this.scheme = "http";
                    pos2 += "http:".length();
                } else {
                    StringBuilder append = new StringBuilder().append("Expected URL scheme 'http' or 'https' but was '");
                    String substring = str4.substring(0, schemeDelimiterOffset2);
                    Intrinsics.checkExpressionValueIsNotNull(substring, str5);
                    throw new IllegalArgumentException(append.append(substring).append("'").toString());
                }
            } else if (base != null) {
                this.scheme = base.scheme();
            } else {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            }
            int slashCount2 = companion.slashCount(str4, pos2, limit4);
            char c4 = '?';
            char c5 = '#';
            if (slashCount2 >= 2 || base == null || (!Intrinsics.areEqual((Object) base.scheme(), (Object) this.scheme))) {
                boolean hasUsername = false;
                boolean hasPassword = false;
                int pos3 = pos2 + slashCount2;
                while (true) {
                    componentDelimiterOffset = Util.delimiterOffset(str4, "@/\\?#", pos3, limit4);
                    if (componentDelimiterOffset != limit4) {
                        c = str4.charAt(componentDelimiterOffset);
                    } else {
                        c = c3;
                    }
                    c2 = c;
                    if (c2 == c3 || c2 == c5 || c2 == '/' || c2 == '\\' || c2 == c4) {
                        char c6 = c2;
                        int i = slashCount2;
                        boolean z3 = z2;
                        String str6 = str5;
                        int i2 = schemeDelimiterOffset2;
                        limit = limit4;
                        int componentDelimiterOffset2 = componentDelimiterOffset;
                        Companion companion2 = Companion;
                        int pos4 = pos3;
                        int portColonOffset = companion2.portColonOffset(str4, pos4, componentDelimiterOffset2);
                    } else {
                        if (c2 != '@') {
                            slashCount = slashCount2;
                            z = z2;
                            str2 = str5;
                            schemeDelimiterOffset = schemeDelimiterOffset2;
                            limit2 = limit4;
                        } else {
                            if (!hasPassword) {
                                int passwordColonOffset = Util.delimiterOffset(str4, ':', pos3, componentDelimiterOffset);
                                String str7 = "%40";
                                char c7 = c2;
                                int componentDelimiterOffset3 = componentDelimiterOffset;
                                int i3 = pos3;
                                slashCount = slashCount2;
                                z = z2;
                                str2 = str5;
                                schemeDelimiterOffset = schemeDelimiterOffset2;
                                String canonicalUsername = Companion.canonicalize$okhttp$default(HttpUrl.Companion, input, pos3, passwordColonOffset, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, (Charset) null, 240, (Object) null);
                                if (hasUsername) {
                                    str3 = this.encodedUsername + str7 + canonicalUsername;
                                } else {
                                    str3 = canonicalUsername;
                                }
                                this.encodedUsername = str3;
                                int passwordColonOffset2 = passwordColonOffset;
                                int componentDelimiterOffset4 = componentDelimiterOffset3;
                                if (passwordColonOffset2 != componentDelimiterOffset4) {
                                    hasPassword = true;
                                    int i4 = passwordColonOffset2;
                                    String str8 = canonicalUsername;
                                    this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.Companion, input, passwordColonOffset2 + 1, componentDelimiterOffset4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, (Charset) null, 240, (Object) null);
                                } else {
                                    String str9 = canonicalUsername;
                                }
                                hasUsername = true;
                                limit2 = limit4;
                                limit3 = componentDelimiterOffset4;
                            } else {
                                char c8 = c2;
                                slashCount = slashCount2;
                                z = z2;
                                str2 = str5;
                                schemeDelimiterOffset = schemeDelimiterOffset2;
                                limit2 = limit4;
                                limit3 = componentDelimiterOffset;
                                this.encodedPassword += "%40" + Companion.canonicalize$okhttp$default(HttpUrl.Companion, input, pos3, componentDelimiterOffset, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, (Charset) null, 240, (Object) null);
                            }
                            pos3 = limit3 + 1;
                        }
                        slashCount2 = slashCount;
                        z2 = z;
                        schemeDelimiterOffset2 = schemeDelimiterOffset;
                        limit4 = limit2;
                        str5 = str2;
                        c5 = '#';
                        c4 = '?';
                        c3 = 65535;
                    }
                }
                char c62 = c2;
                int i5 = slashCount2;
                boolean z32 = z2;
                String str62 = str5;
                int i22 = schemeDelimiterOffset2;
                limit = limit4;
                int componentDelimiterOffset22 = componentDelimiterOffset;
                Companion companion22 = Companion;
                int pos42 = pos3;
                int portColonOffset2 = companion22.portColonOffset(str4, pos42, componentDelimiterOffset22);
                if (portColonOffset2 + 1 < componentDelimiterOffset22) {
                    this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, input, pos42, portColonOffset2, false, 4, (Object) null));
                    int access$parsePort = companion22.parsePort(str4, portColonOffset2 + 1, componentDelimiterOffset22);
                    this.port = access$parsePort;
                    if (access$parsePort != -1 ? z32 : false) {
                        str = str62;
                    } else {
                        StringBuilder append2 = new StringBuilder().append("Invalid URL port: \"");
                        String substring2 = str4.substring(portColonOffset2 + 1, componentDelimiterOffset22);
                        Intrinsics.checkExpressionValueIsNotNull(substring2, str62);
                        throw new IllegalArgumentException(append2.append(substring2).append(Typography.quote).toString().toString());
                    }
                } else {
                    str = str62;
                    this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, input, pos42, portColonOffset2, false, 4, (Object) null));
                    Companion companion3 = HttpUrl.Companion;
                    String str10 = this.scheme;
                    if (str10 == null) {
                        Intrinsics.throwNpe();
                    }
                    this.port = companion3.defaultPort(str10);
                }
                if (this.host != null ? z32 : false) {
                    pos2 = componentDelimiterOffset22;
                } else {
                    StringBuilder append3 = new StringBuilder().append("Invalid URL host: \"");
                    String substring3 = str4.substring(pos42, portColonOffset2);
                    Intrinsics.checkExpressionValueIsNotNull(substring3, str);
                    throw new IllegalArgumentException(append3.append(substring3).append(Typography.quote).toString().toString());
                }
            } else {
                this.encodedUsername = base.encodedUsername();
                this.encodedPassword = base.encodedPassword();
                this.host = base.host();
                this.port = base.port();
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(base.encodedPathSegments());
                if (pos2 == limit4 || str4.charAt(pos2) == '#') {
                    encodedQuery(base.encodedQuery());
                }
                int i6 = slashCount2;
                int i7 = schemeDelimiterOffset2;
                limit = limit4;
            }
            int limit5 = limit;
            int pathDelimiterOffset = Util.delimiterOffset(str4, "?#", pos2, limit5);
            resolvePath(str4, pos2, pathDelimiterOffset);
            int pos5 = pathDelimiterOffset;
            if (pos5 >= limit5 || str4.charAt(pos5) != '?') {
                pos = pos5;
            } else {
                int queryDelimiterOffset = Util.delimiterOffset(str4, '#', pos5, limit5);
                int i8 = pos5;
                this.encodedQueryNamesAndValues = HttpUrl.Companion.toQueryNamesAndValues$okhttp(Companion.canonicalize$okhttp$default(HttpUrl.Companion, input, pos5 + 1, queryDelimiterOffset, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, (Charset) null, 208, (Object) null));
                pos = queryDelimiterOffset;
            }
            if (pos >= limit5 || str4.charAt(pos) != '#') {
            } else {
                int i9 = pos;
                this.encodedFragment = Companion.canonicalize$okhttp$default(HttpUrl.Companion, input, pos + 1, limit5, "", true, false, false, true, (Charset) null, 176, (Object) null);
            }
            return this;
        }

        private final void resolvePath(String input, int startPos, int limit) {
            int pos = startPos;
            if (pos != limit) {
                char c = input.charAt(pos);
                if (c == '/' || c == '\\') {
                    this.encodedPathSegments.clear();
                    this.encodedPathSegments.add("");
                    pos++;
                } else {
                    List<String> list = this.encodedPathSegments;
                    list.set(list.size() - 1, "");
                }
                int i = pos;
                while (i < limit) {
                    int pathSegmentDelimiterOffset = Util.delimiterOffset(input, "/\\", i, limit);
                    boolean segmentHasTrailingSlash = pathSegmentDelimiterOffset < limit;
                    push(input, i, pathSegmentDelimiterOffset, segmentHasTrailingSlash, true);
                    i = pathSegmentDelimiterOffset;
                    if (segmentHasTrailingSlash) {
                        i++;
                    }
                }
            }
        }

        private final void push(String input, int pos, int limit, boolean addTrailingSlash, boolean alreadyEncoded) {
            String segment = Companion.canonicalize$okhttp$default(HttpUrl.Companion, input, pos, limit, HttpUrl.PATH_SEGMENT_ENCODE_SET, alreadyEncoded, false, false, false, (Charset) null, 240, (Object) null);
            if (!isDot(segment)) {
                if (isDotDot(segment)) {
                    pop();
                    return;
                }
                List<String> list = this.encodedPathSegments;
                if (list.get(list.size() - 1).length() == 0) {
                    List<String> list2 = this.encodedPathSegments;
                    list2.set(list2.size() - 1, segment);
                } else {
                    this.encodedPathSegments.add(segment);
                }
                if (addTrailingSlash) {
                    this.encodedPathSegments.add("");
                }
            }
        }

        private final boolean isDot(String input) {
            return Intrinsics.areEqual((Object) input, (Object) ".") || StringsKt.equals(input, "%2e", true);
        }

        private final boolean isDotDot(String input) {
            return Intrinsics.areEqual((Object) input, (Object) "..") || StringsKt.equals(input, "%2e.", true) || StringsKt.equals(input, ".%2e", true) || StringsKt.equals(input, "%2e%2e", true);
        }

        private final void pop() {
            List<String> list = this.encodedPathSegments;
            if (!(list.remove(list.size() - 1).length() == 0) || !(!this.encodedPathSegments.isEmpty())) {
                this.encodedPathSegments.add("");
                return;
            }
            List<String> list2 = this.encodedPathSegments;
            list2.set(list2.size() - 1, "");
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u001c\u0010\f\u001a\u00020\u0006*\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lokhttp3/HttpUrl$Builder$Companion;", "", "()V", "INVALID_HOST", "", "parsePort", "", "input", "pos", "limit", "portColonOffset", "schemeDelimiterOffset", "slashCount", "okhttp"}, k = 1, mv = {1, 1, 16})
        /* compiled from: HttpUrl.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }

            /* access modifiers changed from: private */
            public final int schemeDelimiterOffset(String input, int pos, int limit) {
                if (limit - pos < 2) {
                    return -1;
                }
                char c0 = input.charAt(pos);
                if ((c0 < 'a' || c0 > 'z') && (c0 < 'A' || c0 > 'Z')) {
                    return -1;
                }
                int i = pos + 1;
                while (i < limit) {
                    char charAt = input.charAt(i);
                    if (('a' <= charAt && 'z' >= charAt) || (('A' <= charAt && 'Z' >= charAt) || (('0' <= charAt && '9' >= charAt) || charAt == '+' || charAt == '-' || charAt == '.'))) {
                        i++;
                    } else if (charAt == ':') {
                        return i;
                    } else {
                        return -1;
                    }
                }
                return -1;
            }

            /* access modifiers changed from: private */
            public final int slashCount(String $this$slashCount, int pos, int limit) {
                int slashCount = 0;
                for (int i = pos; i < limit; i++) {
                    char c = $this$slashCount.charAt(i);
                    if (c != '\\' && c != '/') {
                        break;
                    }
                    slashCount++;
                }
                return slashCount;
            }

            /* access modifiers changed from: private */
            public final int portColonOffset(String input, int pos, int limit) {
                int i = pos;
                while (i < limit) {
                    char charAt = input.charAt(i);
                    if (charAt == ':') {
                        return i;
                    }
                    if (charAt == '[') {
                        do {
                            i++;
                            if (i >= limit) {
                                break;
                            }
                        } while (input.charAt(i) == ']');
                    }
                    i++;
                }
                return limit;
            }

            /* access modifiers changed from: private */
            public final int parsePort(String input, int pos, int limit) {
                try {
                    int i = Integer.parseInt(Companion.canonicalize$okhttp$default(HttpUrl.Companion, input, pos, limit, "", false, false, false, false, (Charset) null, 248, (Object) null));
                    if (1 <= i && 65535 >= i) {
                        return i;
                    }
                    return -1;
                } catch (NumberFormatException e) {
                    return -1;
                }
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0002\b\u0018J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0007¢\u0006\u0002\b\u0018J\u0015\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0004H\u0007¢\u0006\u0002\b\u0018J\u0017\u0010\u001b\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0019\u001a\u00020\u0004H\u0007¢\u0006\u0002\b\u001cJa\u0010\u001d\u001a\u00020\u0004*\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00042\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020\"2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'H\u0000¢\u0006\u0002\b(J\u001c\u0010)\u001a\u00020\"*\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0012H\u0002J/\u0010*\u001a\u00020\u0004*\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020\"H\u0000¢\u0006\u0002\b+J&\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040,*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040,2\b\b\u0002\u0010$\u001a\u00020\"H\u0002J\u0011\u0010-\u001a\u00020\u0015*\u00020\u0004H\u0007¢\u0006\u0002\b\u0014J\u0013\u0010.\u001a\u0004\u0018\u00010\u0015*\u00020\u0017H\u0007¢\u0006\u0002\b\u0014J\u0013\u0010.\u001a\u0004\u0018\u00010\u0015*\u00020\u001aH\u0007¢\u0006\u0002\b\u0014J\u0013\u0010.\u001a\u0004\u0018\u00010\u0015*\u00020\u0004H\u0007¢\u0006\u0002\b\u001bJ#\u0010/\u001a\u000200*\b\u0012\u0004\u0012\u00020\u00040,2\n\u00101\u001a\u000602j\u0002`3H\u0000¢\u0006\u0002\b4J\u0019\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000406*\u00020\u0004H\u0000¢\u0006\u0002\b7J%\u00108\u001a\u000200*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040,2\n\u00101\u001a\u000602j\u0002`3H\u0000¢\u0006\u0002\b9JV\u0010:\u001a\u000200*\u00020;2\u0006\u0010<\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J,\u0010=\u001a\u000200*\u00020;2\u0006\u0010>\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\"H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lokhttp3/HttpUrl$Companion;", "", "()V", "FORM_ENCODE_SET", "", "FRAGMENT_ENCODE_SET", "FRAGMENT_ENCODE_SET_URI", "HEX_DIGITS", "", "PASSWORD_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET_URI", "QUERY_COMPONENT_ENCODE_SET", "QUERY_COMPONENT_ENCODE_SET_URI", "QUERY_COMPONENT_REENCODE_SET", "QUERY_ENCODE_SET", "USERNAME_ENCODE_SET", "defaultPort", "", "scheme", "get", "Lokhttp3/HttpUrl;", "uri", "Ljava/net/URI;", "-deprecated_get", "url", "Ljava/net/URL;", "parse", "-deprecated_parse", "canonicalize", "pos", "limit", "encodeSet", "alreadyEncoded", "", "strict", "plusIsSpace", "unicodeAllowed", "charset", "Ljava/nio/charset/Charset;", "canonicalize$okhttp", "isPercentEncoded", "percentDecode", "percentDecode$okhttp", "", "toHttpUrl", "toHttpUrlOrNull", "toPathString", "", "out", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "toPathString$okhttp", "toQueryNamesAndValues", "", "toQueryNamesAndValues$okhttp", "toQueryString", "toQueryString$okhttp", "writeCanonicalized", "Lokio/Buffer;", "input", "writePercentDecoded", "encoded", "okhttp"}, k = 1, mv = {1, 1, 16})
    /* compiled from: HttpUrl.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        @JvmStatic
        public final int defaultPort(String scheme) {
            Intrinsics.checkParameterIsNotNull(scheme, "scheme");
            int hashCode = scheme.hashCode();
            if (hashCode != 3213448) {
                if (hashCode == 99617003 && scheme.equals("https")) {
                    return 443;
                }
            } else if (scheme.equals("http")) {
                return 80;
            }
            return -1;
        }

        public final void toPathString$okhttp(List<String> $this$toPathString, StringBuilder out) {
            Intrinsics.checkParameterIsNotNull($this$toPathString, "$this$toPathString");
            Intrinsics.checkParameterIsNotNull(out, "out");
            int size = $this$toPathString.size();
            for (int i = 0; i < size; i++) {
                out.append('/');
                out.append($this$toPathString.get(i));
            }
        }

        public final void toQueryString$okhttp(List<String> $this$toQueryString, StringBuilder out) {
            Intrinsics.checkParameterIsNotNull($this$toQueryString, "$this$toQueryString");
            Intrinsics.checkParameterIsNotNull(out, "out");
            IntProgression step = RangesKt.step((IntProgression) RangesKt.until(0, $this$toQueryString.size()), 2);
            int i = step.getFirst();
            int last = step.getLast();
            int step2 = step.getStep();
            if (step2 >= 0) {
                if (i > last) {
                    return;
                }
            } else if (i < last) {
                return;
            }
            while (true) {
                String name = $this$toQueryString.get(i);
                String value = $this$toQueryString.get(i + 1);
                if (i > 0) {
                    out.append(Typography.amp);
                }
                out.append(name);
                if (value != null) {
                    out.append('=');
                    out.append(value);
                }
                if (i != last) {
                    i += step2;
                } else {
                    return;
                }
            }
        }

        public final List<String> toQueryNamesAndValues$okhttp(String $this$toQueryNamesAndValues) {
            Intrinsics.checkParameterIsNotNull($this$toQueryNamesAndValues, "$this$toQueryNamesAndValues");
            List result = new ArrayList();
            int pos = 0;
            while (pos <= $this$toQueryNamesAndValues.length()) {
                int ampersandOffset = StringsKt.indexOf$default((CharSequence) $this$toQueryNamesAndValues, (char) Typography.amp, pos, false, 4, (Object) null);
                if (ampersandOffset == -1) {
                    ampersandOffset = $this$toQueryNamesAndValues.length();
                }
                int ampersandOffset2 = ampersandOffset;
                int equalsOffset = StringsKt.indexOf$default((CharSequence) $this$toQueryNamesAndValues, '=', pos, false, 4, (Object) null);
                if (equalsOffset == -1 || equalsOffset > ampersandOffset2) {
                    String substring = $this$toQueryNamesAndValues.substring(pos, ampersandOffset2);
                    Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    result.add(substring);
                    result.add((Object) null);
                } else {
                    String substring2 = $this$toQueryNamesAndValues.substring(pos, equalsOffset);
                    Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    result.add(substring2);
                    String substring3 = $this$toQueryNamesAndValues.substring(equalsOffset + 1, ampersandOffset2);
                    Intrinsics.checkExpressionValueIsNotNull(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    result.add(substring3);
                }
                pos = ampersandOffset2 + 1;
            }
            return result;
        }

        @JvmStatic
        public final HttpUrl get(String $this$toHttpUrl) {
            Intrinsics.checkParameterIsNotNull($this$toHttpUrl, "$this$toHttpUrl");
            return new Builder().parse$okhttp((HttpUrl) null, $this$toHttpUrl).build();
        }

        @JvmStatic
        public final HttpUrl parse(String $this$toHttpUrlOrNull) {
            Intrinsics.checkParameterIsNotNull($this$toHttpUrlOrNull, "$this$toHttpUrlOrNull");
            try {
                return get($this$toHttpUrlOrNull);
            } catch (IllegalArgumentException e) {
                return null;
            }
        }

        @JvmStatic
        public final HttpUrl get(URL $this$toHttpUrlOrNull) {
            Intrinsics.checkParameterIsNotNull($this$toHttpUrlOrNull, "$this$toHttpUrlOrNull");
            String url = $this$toHttpUrlOrNull.toString();
            Intrinsics.checkExpressionValueIsNotNull(url, "toString()");
            return parse(url);
        }

        @JvmStatic
        public final HttpUrl get(URI $this$toHttpUrlOrNull) {
            Intrinsics.checkParameterIsNotNull($this$toHttpUrlOrNull, "$this$toHttpUrlOrNull");
            String uri = $this$toHttpUrlOrNull.toString();
            Intrinsics.checkExpressionValueIsNotNull(uri, "toString()");
            return parse(uri);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "url.toHttpUrl()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrl"}))
        /* renamed from: -deprecated_get  reason: not valid java name */
        public final HttpUrl m1080deprecated_get(String url) {
            Intrinsics.checkParameterIsNotNull(url, ImagesContract.URL);
            return get(url);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "url.toHttpUrlOrNull()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))
        /* renamed from: -deprecated_parse  reason: not valid java name */
        public final HttpUrl m1083deprecated_parse(String url) {
            Intrinsics.checkParameterIsNotNull(url, ImagesContract.URL);
            return parse(url);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "url.toHttpUrlOrNull()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))
        /* renamed from: -deprecated_get  reason: not valid java name */
        public final HttpUrl m1082deprecated_get(URL url) {
            Intrinsics.checkParameterIsNotNull(url, ImagesContract.URL);
            return get(url);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "uri.toHttpUrlOrNull()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))
        /* renamed from: -deprecated_get  reason: not valid java name */
        public final HttpUrl m1081deprecated_get(URI uri) {
            Intrinsics.checkParameterIsNotNull(uri, "uri");
            return get(uri);
        }

        public static /* synthetic */ String percentDecode$okhttp$default(Companion companion, String str, int i, int i2, boolean z, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = str.length();
            }
            if ((i3 & 4) != 0) {
                z = false;
            }
            return companion.percentDecode$okhttp(str, i, i2, z);
        }

        public final String percentDecode$okhttp(String $this$percentDecode, int pos, int limit, boolean plusIsSpace) {
            Intrinsics.checkParameterIsNotNull($this$percentDecode, "$this$percentDecode");
            for (int i = pos; i < limit; i++) {
                char c = $this$percentDecode.charAt(i);
                if (c == '%' || (c == '+' && plusIsSpace)) {
                    Buffer out = new Buffer();
                    out.writeUtf8($this$percentDecode, pos, i);
                    writePercentDecoded(out, $this$percentDecode, i, limit, plusIsSpace);
                    return out.readUtf8();
                }
            }
            String substring = $this$percentDecode.substring(pos, limit);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }

        private final void writePercentDecoded(Buffer $this$writePercentDecoded, String encoded, int pos, int limit, boolean plusIsSpace) {
            int i = pos;
            while (i < limit) {
                if (encoded != null) {
                    int codePoint = encoded.codePointAt(i);
                    if (codePoint == 37 && i + 2 < limit) {
                        int d1 = Util.parseHexDigit(encoded.charAt(i + 1));
                        int d2 = Util.parseHexDigit(encoded.charAt(i + 2));
                        if (!(d1 == -1 || d2 == -1)) {
                            $this$writePercentDecoded.writeByte((d1 << 4) + d2);
                            i = i + 2 + Character.charCount(codePoint);
                        }
                    } else if (codePoint == 43 && plusIsSpace) {
                        $this$writePercentDecoded.writeByte(32);
                        i++;
                    }
                    $this$writePercentDecoded.writeUtf8CodePoint(codePoint);
                    i += Character.charCount(codePoint);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            }
        }

        static /* synthetic */ List percentDecode$default(Companion companion, List list, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.percentDecode(list, z);
        }

        /* access modifiers changed from: private */
        public final List<String> percentDecode(List<String> $this$percentDecode, boolean plusIsSpace) {
            ArrayList result = new ArrayList($this$percentDecode.size());
            Iterator<String> it = $this$percentDecode.iterator();
            while (it.hasNext()) {
                String i = it.next();
                result.add(i != null ? percentDecode$okhttp$default(this, i, 0, 0, plusIsSpace, 3, (Object) null) : null);
            }
            List<String> unmodifiableList = Collections.unmodifiableList(result);
            Intrinsics.checkExpressionValueIsNotNull(unmodifiableList, "Collections.unmodifiableList(result)");
            return unmodifiableList;
        }

        private final boolean isPercentEncoded(String $this$isPercentEncoded, int pos, int limit) {
            return pos + 2 < limit && $this$isPercentEncoded.charAt(pos) == '%' && Util.parseHexDigit($this$isPercentEncoded.charAt(pos + 1)) != -1 && Util.parseHexDigit($this$isPercentEncoded.charAt(pos + 2)) != -1;
        }

        public static /* synthetic */ String canonicalize$okhttp$default(Companion companion, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset, int i3, Object obj) {
            int i4;
            boolean z5;
            boolean z6;
            boolean z7;
            boolean z8;
            Charset charset2;
            int i5 = i3;
            int i6 = (i5 & 1) != 0 ? 0 : i;
            if ((i5 & 2) != 0) {
                i4 = str.length();
            } else {
                i4 = i2;
            }
            if ((i5 & 8) != 0) {
                z5 = false;
            } else {
                z5 = z;
            }
            if ((i5 & 16) != 0) {
                z6 = false;
            } else {
                z6 = z2;
            }
            if ((i5 & 32) != 0) {
                z7 = false;
            } else {
                z7 = z3;
            }
            if ((i5 & 64) != 0) {
                z8 = false;
            } else {
                z8 = z4;
            }
            if ((i5 & 128) != 0) {
                charset2 = null;
            } else {
                charset2 = charset;
            }
            return companion.canonicalize$okhttp(str, i6, i4, str2, z5, z6, z7, z8, charset2);
        }

        public final String canonicalize$okhttp(String $this$canonicalize, int pos, int limit, String encodeSet, boolean alreadyEncoded, boolean strict, boolean plusIsSpace, boolean unicodeAllowed, Charset charset) {
            String str = $this$canonicalize;
            int i = limit;
            String str2 = encodeSet;
            Intrinsics.checkParameterIsNotNull(str, "$this$canonicalize");
            Intrinsics.checkParameterIsNotNull(str2, "encodeSet");
            int i2 = pos;
            while (i2 < i) {
                int codePoint = str.codePointAt(i2);
                if (codePoint < 32 || codePoint == 127 || ((codePoint >= 128 && !unicodeAllowed) || StringsKt.contains$default((CharSequence) str2, (char) codePoint, false, 2, (Object) null) || ((codePoint == 37 && (!alreadyEncoded || (strict && !isPercentEncoded(str, i2, i)))) || (codePoint == 43 && plusIsSpace)))) {
                    Buffer out = new Buffer();
                    out.writeUtf8(str, pos, i2);
                    Buffer out2 = out;
                    writeCanonicalized(out, $this$canonicalize, i2, limit, encodeSet, alreadyEncoded, strict, plusIsSpace, unicodeAllowed, charset);
                    return out2.readUtf8();
                }
                i2 += Character.charCount(codePoint);
                int i3 = codePoint;
            }
            String substring = $this$canonicalize.substring(pos, limit);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }

        private final void writeCanonicalized(Buffer $this$writeCanonicalized, String input, int pos, int limit, String encodeSet, boolean alreadyEncoded, boolean strict, boolean plusIsSpace, boolean unicodeAllowed, Charset charset) {
            Buffer buffer = $this$writeCanonicalized;
            String str = input;
            int i = limit;
            Charset charset2 = charset;
            Buffer encodedCharBuffer = null;
            int i2 = pos;
            while (i2 < i) {
                if (str != null) {
                    int codePoint = input.codePointAt(i2);
                    if (!alreadyEncoded || !(codePoint == 9 || codePoint == 10 || codePoint == 12 || codePoint == 13)) {
                        if (codePoint == 43 && plusIsSpace) {
                            $this$writeCanonicalized.writeUtf8(alreadyEncoded ? "+" : "%2B");
                        } else if (codePoint < 32 || codePoint == 127 || ((codePoint >= 128 && !unicodeAllowed) || StringsKt.contains$default((CharSequence) encodeSet, (char) codePoint, false, 2, (Object) null) || (codePoint == 37 && (!alreadyEncoded || (strict && !isPercentEncoded(input, i2, i)))))) {
                            if (encodedCharBuffer == null) {
                                encodedCharBuffer = new Buffer();
                            }
                            if (charset2 == null || Intrinsics.areEqual((Object) charset2, (Object) StandardCharsets.UTF_8)) {
                                encodedCharBuffer.writeUtf8CodePoint(codePoint);
                            } else {
                                encodedCharBuffer.writeString(input, i2, Character.charCount(codePoint) + i2, charset2);
                            }
                            while (!encodedCharBuffer.exhausted()) {
                                int b = encodedCharBuffer.readByte() & 255;
                                $this$writeCanonicalized.writeByte(37);
                                $this$writeCanonicalized.writeByte((int) HttpUrl.HEX_DIGITS[(b >> 4) & 15]);
                                $this$writeCanonicalized.writeByte((int) HttpUrl.HEX_DIGITS[b & 15]);
                            }
                        } else {
                            $this$writeCanonicalized.writeUtf8CodePoint(codePoint);
                        }
                    }
                    i2 += Character.charCount(codePoint);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            }
        }
    }
}
