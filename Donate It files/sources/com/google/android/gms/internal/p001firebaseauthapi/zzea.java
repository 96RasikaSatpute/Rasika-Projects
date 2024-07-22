package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzea  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzea extends zzat<zzel> {
    zzea() {
        super(zzel.class, new zzdy(zzaz.class));
    }

    /* access modifiers changed from: private */
    public static void zzl(zzer zzer) throws GeneralSecurityException {
        if (zzer.zza() < 10) {
            throw new GeneralSecurityException("tag size too short");
        } else if (zzer.zza() > 16) {
            throw new GeneralSecurityException("tag size too long");
        }
    }

    /* access modifiers changed from: private */
    public static void zzm(int i) throws GeneralSecurityException {
        if (i != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }

    public final zzib zzc() {
        return zzib.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ zzabd zzd(zzyy zzyy) throws zzaai {
        return zzel.zzd(zzyy, zzzn.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzabd zzabd) throws GeneralSecurityException {
        zzel zzel = (zzel) zzabd;
        zzlg.zzb(zzel.zza(), 0);
        zzm(zzel.zzb().zzc());
        zzl(zzel.zzc());
    }

    public final zzar<zzeo, zzel> zzi() {
        return new zzdz(this, zzeo.class);
    }
}
