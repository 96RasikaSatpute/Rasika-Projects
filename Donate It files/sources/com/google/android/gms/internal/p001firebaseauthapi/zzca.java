package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzca  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzca extends zzat<zzfj> {
    zzca() {
        super(zzfj.class, new zzby(zzag.class));
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    public final zzib zzc() {
        return zzib.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ zzabd zzd(zzyy zzyy) throws zzaai {
        return zzfj.zzd(zzyy, zzzn.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzabd zzabd) throws GeneralSecurityException {
        zzfj zzfj = (zzfj) zzabd;
        zzlg.zzb(zzfj.zza(), 0);
        zzlg.zza(zzfj.zzc().zzc());
        if (zzfj.zzb().zza() != 12 && zzfj.zzb().zza() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }

    public final zzar<zzfm, zzfj> zzi() {
        return new zzbz(this, zzfm.class);
    }
}
