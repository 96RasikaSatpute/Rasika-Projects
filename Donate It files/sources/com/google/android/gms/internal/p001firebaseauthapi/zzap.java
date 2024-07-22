package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzabd;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzap  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
class zzap<PrimitiveT, KeyProtoT extends zzabd> implements zzan<PrimitiveT> {
    private final zzat<KeyProtoT> zza;
    private final Class<PrimitiveT> zzb;

    public zzap(zzat<KeyProtoT> zzat, Class<PrimitiveT> cls) {
        if (zzat.zzg().contains(cls) || Void.class.equals(cls)) {
            this.zza = zzat;
            this.zzb = cls;
            return;
        }
        throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", new Object[]{zzat.toString(), cls.getName()}));
    }

    private final PrimitiveT zze(KeyProtoT keyprotot) throws GeneralSecurityException {
        if (!Void.class.equals(this.zzb)) {
            this.zza.zze(keyprotot);
            return this.zza.zzf(keyprotot, this.zzb);
        }
        throw new GeneralSecurityException("Cannot create a primitive for Void");
    }

    private final zzao<?, KeyProtoT> zzf() {
        return new zzao<>(this.zza.zzi());
    }

    public final PrimitiveT zza(zzyy zzyy) throws GeneralSecurityException {
        try {
            return zze(this.zza.zzd(zzyy));
        } catch (zzaai e) {
            String valueOf = String.valueOf(this.zza.zza().getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? "Failures parsing proto of type ".concat(valueOf) : new String("Failures parsing proto of type "), e);
        }
    }

    public final PrimitiveT zzb(zzabd zzabd) throws GeneralSecurityException {
        String valueOf = String.valueOf(this.zza.zza().getName());
        String concat = valueOf.length() != 0 ? "Expected proto of type ".concat(valueOf) : new String("Expected proto of type ");
        if (this.zza.zza().isInstance(zzabd)) {
            return zze(zzabd);
        }
        throw new GeneralSecurityException(concat);
    }

    public final zzabd zzc(zzyy zzyy) throws GeneralSecurityException {
        try {
            return zzf().zza(zzyy);
        } catch (zzaai e) {
            String valueOf = String.valueOf(this.zza.zzi().zza().getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? "Failures parsing proto of type ".concat(valueOf) : new String("Failures parsing proto of type "), e);
        }
    }

    public final zzic zzd(zzyy zzyy) throws GeneralSecurityException {
        try {
            zzabd zza2 = zzf().zza(zzyy);
            zzhz zzd = zzic.zzd();
            zzd.zza(this.zza.zzb());
            zzd.zzb(zza2.zzn());
            zzd.zzc(this.zza.zzc());
            return (zzic) zzd.zzl();
        } catch (zzaai e) {
            throw new GeneralSecurityException("Unexpected proto", e);
        }
    }
}
