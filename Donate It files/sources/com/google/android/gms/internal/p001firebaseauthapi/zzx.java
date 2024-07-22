package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.logging.Logger;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzx  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzx {
    private static final Logger zza = Logger.getLogger(zzx.class.getName());
    private static final zzw zzb = new zzw((zzv) null);

    private zzx() {
    }

    static boolean zza(@NullableDecl String str) {
        return str == null || str.isEmpty();
    }

    static String zzb(@NullableDecl String str) {
        return str == null ? "" : str;
    }

    static zzs zzc(String str) {
        return new zzu(Pattern.compile("[.-]"));
    }
}
