package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzabd;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbf  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzbf<PrimitiveT, KeyProtoT extends zzabd, PublicKeyProtoT extends zzabd> extends zzap<PrimitiveT, KeyProtoT> implements zzan {
    private final zzbg<KeyProtoT, PublicKeyProtoT> zza;
    private final zzat<PublicKeyProtoT> zzb;

    public zzbf(zzbg<KeyProtoT, PublicKeyProtoT> zzbg, zzat<PublicKeyProtoT> zzat, Class<PrimitiveT> cls) {
        super(zzbg, cls);
        this.zza = zzbg;
        this.zzb = zzat;
    }

    public final zzic zze(zzyy zzyy) throws GeneralSecurityException {
        try {
            zzhb zzd = zzhb.zzd(zzyy, zzzn.zza());
            zzde.zzj(zzd);
            zzhe zzb2 = zzd.zzb();
            this.zzb.zze(zzb2);
            zzhz zzd2 = zzic.zzd();
            zzd2.zza("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey");
            zzd2.zzb(zzb2.zzn());
            zzd2.zzc(zzib.ASYMMETRIC_PUBLIC);
            return (zzic) zzd2.zzl();
        } catch (zzaai e) {
            throw new GeneralSecurityException("expected serialized proto of type ", e);
        }
    }
}
