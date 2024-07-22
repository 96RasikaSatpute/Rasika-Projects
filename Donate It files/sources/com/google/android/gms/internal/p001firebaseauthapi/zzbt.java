package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbt  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzbt extends zzar<zzex, zzeu> {
    final /* synthetic */ zzbu zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbt(zzbu zzbu, Class cls) {
        super(cls);
        this.zza = zzbu;
    }

    public final /* bridge */ /* synthetic */ void zzb(zzabd zzabd) throws GeneralSecurityException {
        zzex zzex = (zzex) zzabd;
        ((zzbw) new zzbx().zzi()).zzb(zzex.zza());
        new zzed().zzi().zzb(zzex.zzb());
        zzlg.zza(zzex.zza().zzb());
    }

    public final /* bridge */ /* synthetic */ zzabd zzc(zzyy zzyy) throws zzaai {
        return zzex.zzc(zzyy, zzzn.zza());
    }

    public final /* bridge */ /* synthetic */ Object zzd(zzabd zzabd) throws GeneralSecurityException {
        zzex zzex = (zzex) zzabd;
        new zzbx();
        zzfa zzf = zzbw.zzf(zzex.zza());
        Object zzd = new zzed().zzi().zzd(zzex.zzb());
        zzet zze = zzeu.zze();
        zze.zzb(zzf);
        zze.zzc((zzhr) zzd);
        zze.zza(0);
        return (zzeu) zze.zzl();
    }
}
