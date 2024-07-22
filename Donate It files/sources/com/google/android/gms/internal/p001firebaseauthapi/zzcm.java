package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcm  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzcm extends zzat<zzix> {
    zzcm() {
        super(zzix.class, new zzck(zzag.class));
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.KmsAeadKey";
    }

    public final zzib zzc() {
        return zzib.REMOTE;
    }

    public final /* bridge */ /* synthetic */ zzabd zzd(zzyy zzyy) throws zzaai {
        return zzix.zzc(zzyy, zzzn.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzabd zzabd) throws GeneralSecurityException {
        zzlg.zzb(((zzix) zzabd).zza(), 0);
    }

    public final zzar<zzja, zzix> zzi() {
        return new zzcl(this, zzja.class);
    }
}
