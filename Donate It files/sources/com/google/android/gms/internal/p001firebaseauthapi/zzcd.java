package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcd  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzcd extends zzat<zzfs> {
    zzcd() {
        super(zzfs.class, new zzcb(zzag.class));
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    public final zzib zzc() {
        return zzib.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ zzabd zzd(zzyy zzyy) throws zzaai {
        return zzfs.zzc(zzyy, zzzn.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzabd zzabd) throws GeneralSecurityException {
        zzfs zzfs = (zzfs) zzabd;
        zzlg.zzb(zzfs.zza(), 0);
        zzlg.zza(zzfs.zzb().zzc());
    }

    public final zzar<zzfv, zzfs> zzi() {
        return new zzcc(this, zzfv.class);
    }
}
