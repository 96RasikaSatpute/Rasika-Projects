package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcp  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzcp extends zzar<zzjg, zzjd> {
    final /* synthetic */ zzcq zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcp(zzcq zzcq, Class cls) {
        super(cls);
        this.zza = zzcq;
    }

    public final /* bridge */ /* synthetic */ void zzb(zzabd zzabd) throws GeneralSecurityException {
        zzjg zzjg = (zzjg) zzabd;
        if (zzjg.zza().isEmpty() || !zzjg.zzb()) {
            throw new GeneralSecurityException("invalid key format: missing KEK URI or DEK template");
        }
    }

    public final /* bridge */ /* synthetic */ zzabd zzc(zzyy zzyy) throws zzaai {
        return zzjg.zzd(zzyy, zzzn.zza());
    }

    public final /* bridge */ /* synthetic */ Object zzd(zzabd zzabd) throws GeneralSecurityException {
        zzjc zzd = zzjd.zzd();
        zzd.zzb((zzjg) zzabd);
        zzd.zza(0);
        return (zzjd) zzd.zzl();
    }
}
