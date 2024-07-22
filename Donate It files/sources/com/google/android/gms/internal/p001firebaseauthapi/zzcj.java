package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzcj extends zzat<zzgk> {
    zzcj() {
        super(zzgk.class, new zzch(zzag.class));
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    public final zzib zzc() {
        return zzib.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ zzabd zzd(zzyy zzyy) throws zzaai {
        return zzgk.zzc(zzyy, zzzn.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzabd zzabd) throws GeneralSecurityException {
        zzgk zzgk = (zzgk) zzabd;
        zzlg.zzb(zzgk.zza(), 0);
        if (zzgk.zzb().zzc() != 32) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
    }

    public final zzar<zzgn, zzgk> zzi() {
        return new zzci(this, zzgn.class);
    }
}
