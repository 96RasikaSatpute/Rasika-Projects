package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzee  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzee {
    @Deprecated
    public static final zzjl zza;
    @Deprecated
    public static final zzjl zzb;
    @Deprecated
    public static final zzjl zzc;

    static {
        new zzed();
        zzjl zza2 = zzjl.zza();
        zza = zza2;
        zzb = zza2;
        zzc = zza2;
        try {
            zza();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzbl.zzc(new zzeh());
        zzbl.zza(new zzed(), true);
        zzbl.zza(new zzea(), true);
    }
}
