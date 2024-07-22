package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcx  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzcx extends zzar<zzgh, zzge> {
    final /* synthetic */ zzcy zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcx(zzcy zzcy, Class cls) {
        super(cls);
        this.zza = zzcy;
    }

    public final /* bridge */ /* synthetic */ void zzb(zzabd zzabd) throws GeneralSecurityException {
        zzgh zzgh = (zzgh) zzabd;
        if (zzgh.zza() != 64) {
            int zza2 = zzgh.zza();
            StringBuilder sb = new StringBuilder(61);
            sb.append("invalid key size: ");
            sb.append(zza2);
            sb.append(". Valid keys must have 64 bytes.");
            throw new InvalidAlgorithmParameterException(sb.toString());
        }
    }

    public final /* bridge */ /* synthetic */ zzabd zzc(zzyy zzyy) throws zzaai {
        return zzgh.zzb(zzyy, zzzn.zza());
    }

    public final /* bridge */ /* synthetic */ Object zzd(zzabd zzabd) throws GeneralSecurityException {
        zzgd zzd = zzge.zzd();
        zzd.zzb(zzyy.zzm(zzle.zza(((zzgh) zzabd).zza())));
        zzd.zza(0);
        return (zzge) zzd.zzl();
    }
}
