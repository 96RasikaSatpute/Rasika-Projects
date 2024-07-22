package com.google.android.gms.common.internal;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.0 */
public class LibraryVersion {
    private static final GmsLogger zzfc = new GmsLogger("LibraryVersion", "");
    private static LibraryVersion zzfd = new LibraryVersion();
    private ConcurrentHashMap<String, String> zzfe = new ConcurrentHashMap<>();

    public static LibraryVersion getInstance() {
        return zzfd;
    }

    protected LibraryVersion() {
    }

    public String getVersion(String str) {
        Preconditions.checkNotEmpty(str, "Please provide a valid libraryName");
        if (this.zzfe.containsKey(str)) {
            return this.zzfe.get(str);
        }
        Properties properties = new Properties();
        String str2 = null;
        try {
            InputStream resourceAsStream = LibraryVersion.class.getResourceAsStream(String.format("/%s.properties", new Object[]{str}));
            if (resourceAsStream != null) {
                properties.load(resourceAsStream);
                str2 = properties.getProperty("version", (String) null);
                zzfc.v("LibraryVersion", new StringBuilder(String.valueOf(str).length() + 12 + String.valueOf(str2).length()).append(str).append(" version is ").append(str2).toString());
            } else {
                GmsLogger gmsLogger = zzfc;
                String valueOf = String.valueOf(str);
                gmsLogger.w("LibraryVersion", valueOf.length() != 0 ? "Failed to get app version for libraryName: ".concat(valueOf) : new String("Failed to get app version for libraryName: "));
            }
        } catch (IOException e) {
            GmsLogger gmsLogger2 = zzfc;
            String valueOf2 = String.valueOf(str);
            gmsLogger2.e("LibraryVersion", valueOf2.length() != 0 ? "Failed to get app version for libraryName: ".concat(valueOf2) : new String("Failed to get app version for libraryName: "), e);
        }
        if (str2 == null) {
            zzfc.d("LibraryVersion", ".properties file is dropped during release process. Failure to read app version isexpected druing Google internal testing where locally-built libraries are used");
            str2 = "UNKNOWN";
        }
        this.zzfe.put(str, str2);
        return str2;
    }
}
