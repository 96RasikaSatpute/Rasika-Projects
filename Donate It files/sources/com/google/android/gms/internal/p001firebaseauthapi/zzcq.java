package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzcq extends zzat<zzjd> {
    zzcq() {
        super(zzjd.class, new zzco(zzag.class));
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
    }

    public final zzib zzc() {
        return zzib.REMOTE;
    }

    public final /* bridge */ /* synthetic */ zzabd zzd(zzyy zzyy) throws zzaai {
        return zzjd.zzc(zzyy, zzzn.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzabd zzabd) throws GeneralSecurityException {
        zzlg.zzb(((zzjd) zzabd).zza(), 0);
    }

    public final zzar<zzjg, zzjd> zzi() {
        return new zzcp(this, zzjg.class);
    }
}
