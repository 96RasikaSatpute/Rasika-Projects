package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzha  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzha extends zzzw<zzhb, zzha> implements zzabe {
    private zzha() {
        super(zzhb.zzg);
    }

    public final zzha zza(int i) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        ((zzhb) this.zza).zzb = 0;
        return this;
    }

    public final zzha zzb(zzhe zzhe) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        zzhb.zzh((zzhb) this.zza, zzhe);
        return this;
    }

    public final zzha zzc(zzyy zzyy) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        ((zzhb) this.zza).zzf = zzyy;
        return this;
    }

    /* synthetic */ zzha(zzgz zzgz) {
        super(zzhb.zzg);
    }
}
