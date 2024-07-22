package com.google.android.gms.common.util;

import com.google.maps.android.BuildConfig;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.0 */
public class MapUtils {
    public static void writeStringMapToJson(StringBuilder sb, HashMap<String, String> hashMap) {
        sb.append("{");
        boolean z = true;
        for (String next : hashMap.keySet()) {
            if (!z) {
                sb.append(",");
            } else {
                z = false;
            }
            String str = hashMap.get(next);
            sb.append("\"").append(next).append("\":");
            if (str == null) {
                sb.append(BuildConfig.TRAVIS);
            } else {
                sb.append("\"").append(str).append("\"");
            }
        }
        sb.append("}");
    }
}
