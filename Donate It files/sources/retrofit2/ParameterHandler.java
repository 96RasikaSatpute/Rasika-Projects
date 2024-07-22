package retrofit2;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

abstract class ParameterHandler<T> {
    /* access modifiers changed from: package-private */
    public abstract void apply(RequestBuilder requestBuilder, @Nullable T t) throws IOException;

    ParameterHandler() {
    }

    /* access modifiers changed from: package-private */
    public final ParameterHandler<Iterable<T>> iterable() {
        return new ParameterHandler<Iterable<T>>() {
            /* access modifiers changed from: package-private */
            public void apply(RequestBuilder builder, @Nullable Iterable<T> values) throws IOException {
                if (values != null) {
                    for (T value : values) {
                        ParameterHandler.this.apply(builder, value);
                    }
                }
            }
        };
    }

    /* access modifiers changed from: package-private */
    public final ParameterHandler<Object> array() {
        return new ParameterHandler<Object>() {
            /* access modifiers changed from: package-private */
            public void apply(RequestBuilder builder, @Nullable Object values) throws IOException {
                if (values != null) {
                    int size = Array.getLength(values);
                    for (int i = 0; i < size; i++) {
                        ParameterHandler.this.apply(builder, Array.get(values, i));
                    }
                }
            }
        };
    }

    static final class RelativeUrl extends ParameterHandler<Object> {
        private final Method method;
        private final int p;

        RelativeUrl(Method method2, int p2) {
            this.method = method2;
            this.p = p2;
        }

        /* access modifiers changed from: package-private */
        public void apply(RequestBuilder builder, @Nullable Object value) {
            if (value != null) {
                builder.setRelativeUrl(value);
                return;
            }
            throw Utils.parameterError(this.method, this.p, "@Url parameter is null.", new Object[0]);
        }
    }

    static final class Header<T> extends ParameterHandler<T> {
        private final String name;
        private final Converter<T, String> valueConverter;

        Header(String name2, Converter<T, String> valueConverter2) {
            this.name = (String) Utils.checkNotNull(name2, "name == null");
            this.valueConverter = valueConverter2;
        }

        /* access modifiers changed from: package-private */
        public void apply(RequestBuilder builder, @Nullable T value) throws IOException {
            String headerValue;
            if (value != null && (headerValue = this.valueConverter.convert(value)) != null) {
                builder.addHeader(this.name, headerValue);
            }
        }
    }

    static final class Path<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final Method method;
        private final String name;
        private final int p;
        private final Converter<T, String> valueConverter;

        Path(Method method2, int p2, String name2, Converter<T, String> valueConverter2, boolean encoded2) {
            this.method = method2;
            this.p = p2;
            this.name = (String) Utils.checkNotNull(name2, "name == null");
            this.valueConverter = valueConverter2;
            this.encoded = encoded2;
        }

        /* access modifiers changed from: package-private */
        public void apply(RequestBuilder builder, @Nullable T value) throws IOException {
            if (value != null) {
                builder.addPathParam(this.name, this.valueConverter.convert(value), this.encoded);
                return;
            }
            throw Utils.parameterError(this.method, this.p, "Path parameter \"" + this.name + "\" value must not be null.", new Object[0]);
        }
    }

    static final class Query<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final String name;
        private final Converter<T, String> valueConverter;

        Query(String name2, Converter<T, String> valueConverter2, boolean encoded2) {
            this.name = (String) Utils.checkNotNull(name2, "name == null");
            this.valueConverter = valueConverter2;
            this.encoded = encoded2;
        }

        /* access modifiers changed from: package-private */
        public void apply(RequestBuilder builder, @Nullable T value) throws IOException {
            String queryValue;
            if (value != null && (queryValue = this.valueConverter.convert(value)) != null) {
                builder.addQueryParam(this.name, queryValue, this.encoded);
            }
        }
    }

    static final class QueryName<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final Converter<T, String> nameConverter;

        QueryName(Converter<T, String> nameConverter2, boolean encoded2) {
            this.nameConverter = nameConverter2;
            this.encoded = encoded2;
        }

        /* access modifiers changed from: package-private */
        public void apply(RequestBuilder builder, @Nullable T value) throws IOException {
            if (value != null) {
                builder.addQueryParam(this.nameConverter.convert(value), (String) null, this.encoded);
            }
        }
    }

    static final class QueryMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean encoded;
        private final Method method;
        private final int p;
        private final Converter<T, String> valueConverter;

        QueryMap(Method method2, int p2, Converter<T, String> valueConverter2, boolean encoded2) {
            this.method = method2;
            this.p = p2;
            this.valueConverter = valueConverter2;
            this.encoded = encoded2;
        }

        /* access modifiers changed from: package-private */
        public void apply(RequestBuilder builder, @Nullable Map<String, T> value) throws IOException {
            if (value != null) {
                for (Map.Entry<String, T> entry : value.entrySet()) {
                    String entryKey = entry.getKey();
                    if (entryKey != null) {
                        T entryValue = entry.getValue();
                        if (entryValue != null) {
                            String convertedEntryValue = this.valueConverter.convert(entryValue);
                            if (convertedEntryValue != null) {
                                builder.addQueryParam(entryKey, convertedEntryValue, this.encoded);
                            } else {
                                throw Utils.parameterError(this.method, this.p, "Query map value '" + entryValue + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + entryKey + "'.", new Object[0]);
                            }
                        } else {
                            throw Utils.parameterError(this.method, this.p, "Query map contained null value for key '" + entryKey + "'.", new Object[0]);
                        }
                    } else {
                        throw Utils.parameterError(this.method, this.p, "Query map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw Utils.parameterError(this.method, this.p, "Query map was null", new Object[0]);
        }
    }

    static final class HeaderMap<T> extends ParameterHandler<Map<String, T>> {
        private final Method method;
        private final int p;
        private final Converter<T, String> valueConverter;

        HeaderMap(Method method2, int p2, Converter<T, String> valueConverter2) {
            this.method = method2;
            this.p = p2;
            this.valueConverter = valueConverter2;
        }

        /* access modifiers changed from: package-private */
        public void apply(RequestBuilder builder, @Nullable Map<String, T> value) throws IOException {
            if (value != null) {
                for (Map.Entry<String, T> entry : value.entrySet()) {
                    String headerName = entry.getKey();
                    if (headerName != null) {
                        T headerValue = entry.getValue();
                        if (headerValue != null) {
                            builder.addHeader(headerName, this.valueConverter.convert(headerValue));
                        } else {
                            throw Utils.parameterError(this.method, this.p, "Header map contained null value for key '" + headerName + "'.", new Object[0]);
                        }
                    } else {
                        throw Utils.parameterError(this.method, this.p, "Header map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw Utils.parameterError(this.method, this.p, "Header map was null.", new Object[0]);
        }
    }

    static final class Headers extends ParameterHandler<okhttp3.Headers> {
        private final Method method;
        private final int p;

        Headers(Method method2, int p2) {
            this.method = method2;
            this.p = p2;
        }

        /* access modifiers changed from: package-private */
        public void apply(RequestBuilder builder, @Nullable okhttp3.Headers headers) {
            if (headers != null) {
                builder.addHeaders(headers);
                return;
            }
            throw Utils.parameterError(this.method, this.p, "Headers parameter must not be null.", new Object[0]);
        }
    }

    static final class Field<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final String name;
        private final Converter<T, String> valueConverter;

        Field(String name2, Converter<T, String> valueConverter2, boolean encoded2) {
            this.name = (String) Utils.checkNotNull(name2, "name == null");
            this.valueConverter = valueConverter2;
            this.encoded = encoded2;
        }

        /* access modifiers changed from: package-private */
        public void apply(RequestBuilder builder, @Nullable T value) throws IOException {
            String fieldValue;
            if (value != null && (fieldValue = this.valueConverter.convert(value)) != null) {
                builder.addFormField(this.name, fieldValue, this.encoded);
            }
        }
    }

    static final class FieldMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean encoded;
        private final Method method;
        private final int p;
        private final Converter<T, String> valueConverter;

        FieldMap(Method method2, int p2, Converter<T, String> valueConverter2, boolean encoded2) {
            this.method = method2;
            this.p = p2;
            this.valueConverter = valueConverter2;
            this.encoded = encoded2;
        }

        /* access modifiers changed from: package-private */
        public void apply(RequestBuilder builder, @Nullable Map<String, T> value) throws IOException {
            if (value != null) {
                for (Map.Entry<String, T> entry : value.entrySet()) {
                    String entryKey = entry.getKey();
                    if (entryKey != null) {
                        T entryValue = entry.getValue();
                        if (entryValue != null) {
                            String fieldEntry = this.valueConverter.convert(entryValue);
                            if (fieldEntry != null) {
                                builder.addFormField(entryKey, fieldEntry, this.encoded);
                            } else {
                                throw Utils.parameterError(this.method, this.p, "Field map value '" + entryValue + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + entryKey + "'.", new Object[0]);
                            }
                        } else {
                            throw Utils.parameterError(this.method, this.p, "Field map contained null value for key '" + entryKey + "'.", new Object[0]);
                        }
                    } else {
                        throw Utils.parameterError(this.method, this.p, "Field map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw Utils.parameterError(this.method, this.p, "Field map was null.", new Object[0]);
        }
    }

    static final class Part<T> extends ParameterHandler<T> {
        private final Converter<T, RequestBody> converter;
        private final okhttp3.Headers headers;
        private final Method method;
        private final int p;

        Part(Method method2, int p2, okhttp3.Headers headers2, Converter<T, RequestBody> converter2) {
            this.method = method2;
            this.p = p2;
            this.headers = headers2;
            this.converter = converter2;
        }

        /* access modifiers changed from: package-private */
        public void apply(RequestBuilder builder, @Nullable T value) {
            if (value != null) {
                try {
                    builder.addPart(this.headers, this.converter.convert(value));
                } catch (IOException e) {
                    throw Utils.parameterError(this.method, this.p, "Unable to convert " + value + " to RequestBody", e);
                }
            }
        }
    }

    static final class RawPart extends ParameterHandler<MultipartBody.Part> {
        static final RawPart INSTANCE = new RawPart();

        private RawPart() {
        }

        /* access modifiers changed from: package-private */
        public void apply(RequestBuilder builder, @Nullable MultipartBody.Part value) {
            if (value != null) {
                builder.addPart(value);
            }
        }
    }

    static final class PartMap<T> extends ParameterHandler<Map<String, T>> {
        private final Method method;
        private final int p;
        private final String transferEncoding;
        private final Converter<T, RequestBody> valueConverter;

        PartMap(Method method2, int p2, Converter<T, RequestBody> valueConverter2, String transferEncoding2) {
            this.method = method2;
            this.p = p2;
            this.valueConverter = valueConverter2;
            this.transferEncoding = transferEncoding2;
        }

        /* access modifiers changed from: package-private */
        public void apply(RequestBuilder builder, @Nullable Map<String, T> value) throws IOException {
            if (value != null) {
                for (Map.Entry<String, T> entry : value.entrySet()) {
                    String entryKey = entry.getKey();
                    if (entryKey != null) {
                        T entryValue = entry.getValue();
                        if (entryValue != null) {
                            builder.addPart(okhttp3.Headers.of("Content-Disposition", "form-data; name=\"" + entryKey + "\"", "Content-Transfer-Encoding", this.transferEncoding), this.valueConverter.convert(entryValue));
                        } else {
                            throw Utils.parameterError(this.method, this.p, "Part map contained null value for key '" + entryKey + "'.", new Object[0]);
                        }
                    } else {
                        throw Utils.parameterError(this.method, this.p, "Part map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw Utils.parameterError(this.method, this.p, "Part map was null.", new Object[0]);
        }
    }

    static final class Body<T> extends ParameterHandler<T> {
        private final Converter<T, RequestBody> converter;
        private final Method method;
        private final int p;

        Body(Method method2, int p2, Converter<T, RequestBody> converter2) {
            this.method = method2;
            this.p = p2;
            this.converter = converter2;
        }

        /* access modifiers changed from: package-private */
        public void apply(RequestBuilder builder, @Nullable T value) {
            if (value != null) {
                try {
                    builder.setBody(this.converter.convert(value));
                } catch (IOException e) {
                    throw Utils.parameterError(this.method, e, this.p, "Unable to convert " + value + " to RequestBody", new Object[0]);
                }
            } else {
                throw Utils.parameterError(this.method, this.p, "Body parameter value must not be null.", new Object[0]);
            }
        }
    }

    static final class Tag<T> extends ParameterHandler<T> {
        final Class<T> cls;

        Tag(Class<T> cls2) {
            this.cls = cls2;
        }

        /* access modifiers changed from: package-private */
        public void apply(RequestBuilder builder, @Nullable T value) {
            builder.addTag(this.cls, value);
        }
    }
}
