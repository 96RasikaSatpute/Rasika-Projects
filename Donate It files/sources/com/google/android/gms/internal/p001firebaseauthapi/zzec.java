package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzec  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzec extends zzar<zzhu, zzhr> {
    final /* synthetic */ zzed zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzec(zzed zzed, Class cls) {
        super(cls);
        this.zza = zzed;
    }

    public final /* bridge */ /* synthetic */ void zzb(zzabd zzabd) throws GeneralSecurityException {
        zzhu zzhu = (zzhu) zzabd;
        if (zzhu.zzb() >= 16) {
            zzed.zzl(zzhu.zza());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }

    public final /* bridge */ /* synthetic */ zzabd zzc(zzyy zzyy) throws zzaai {
        return zzhu.zzc(zzyy, zzzn.zza());
    }

    public final /* bridge */ /* synthetic */ Object zzd(zzabd zzabd) throws GeneralSecurityException {
        zzhu zzhu = (zzhu) zzabd;
        zzhq zze = zzhr.zze();
        zze.zza(0);
        zze.zzb(zzhu.zza());
        zze.zzc(zzyy.zzm(zzle.zza(zzhu.zzb())));
        return (zzhr) zze.zzl();
    }
}
