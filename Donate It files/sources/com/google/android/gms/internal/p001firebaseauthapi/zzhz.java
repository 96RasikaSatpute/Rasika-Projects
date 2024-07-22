package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhz  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzhz extends zzzw<zzic, zzhz> implements zzabe {
    private zzhz() {
        super(zzic.zzg);
    }

    public final zzhz zza(String str) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        ((zzic) this.zza).zzb = str;
        return this;
    }

    public final zzhz zzb(zzyy zzyy) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        ((zzic) this.zza).zze = zzyy;
        return this;
    }

    public final zzhz zzc(zzib zzib) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        ((zzic) this.zza).zzf = zzib.zza();
        return this;
    }

    /* synthetic */ zzhz(zzhy zzhy) {
        super(zzic.zzg);
    }
}
