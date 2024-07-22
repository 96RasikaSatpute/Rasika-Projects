package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdg  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzdg extends zzat<zzhe> {
    public zzdg() {
        super(zzhe.class, new zzdf(zzam.class));
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey";
    }

    public final zzib zzc() {
        return zzib.ASYMMETRIC_PUBLIC;
    }

    public final /* bridge */ /* synthetic */ zzabd zzd(zzyy zzyy) throws zzaai {
        return zzhe.zze(zzyy, zzzn.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzabd zzabd) throws GeneralSecurityException {
        zzhe zzhe = (zzhe) zzabd;
        zzlg.zzb(zzhe.zza(), 0);
        zzdn.zza(zzhe.zzb());
    }
}
