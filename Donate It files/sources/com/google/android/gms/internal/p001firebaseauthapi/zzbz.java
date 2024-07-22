package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbz  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzbz extends zzar<zzfm, zzfj> {
    final /* synthetic */ zzca zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbz(zzca zzca, Class cls) {
        super(cls);
        this.zza = zzca;
    }

    public final /* bridge */ /* synthetic */ void zzb(zzabd zzabd) throws GeneralSecurityException {
        zzfm zzfm = (zzfm) zzabd;
        zzlg.zza(zzfm.zzb());
        if (zzfm.zza().zza() != 12 && zzfm.zza().zza() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }

    public final /* bridge */ /* synthetic */ zzabd zzc(zzyy zzyy) throws zzaai {
        return zzfm.zzc(zzyy, zzzn.zza());
    }

    public final /* bridge */ /* synthetic */ Object zzd(zzabd zzabd) throws GeneralSecurityException {
        zzfm zzfm = (zzfm) zzabd;
        zzfi zze = zzfj.zze();
        zze.zzc(zzyy.zzm(zzle.zza(zzfm.zzb())));
        zze.zzb(zzfm.zza());
        zze.zza(0);
        return (zzfj) zze.zzl();
    }
}
