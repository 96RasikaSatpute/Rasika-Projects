package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzct  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzct extends zzat<zzjo> {
    zzct() {
        super(zzjo.class, new zzcr(zzag.class));
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
    }

    public final zzib zzc() {
        return zzib.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ zzabd zzd(zzyy zzyy) throws zzaai {
        return zzjo.zzc(zzyy, zzzn.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzabd zzabd) throws GeneralSecurityException {
        zzjo zzjo = (zzjo) zzabd;
        zzlg.zzb(zzjo.zza(), 0);
        if (zzjo.zzb().zzc() != 32) {
            throw new GeneralSecurityException("invalid XChaCha20Poly1305Key: incorrect key length");
        }
    }

    public final zzar<zzjr, zzjo> zzi() {
        return new zzcs(this, zzjr.class);
    }
}
