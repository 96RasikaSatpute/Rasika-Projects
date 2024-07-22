package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzig  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzig extends zzzw<zzih, zzig> implements zzabe {
    private zzig() {
        super(zzih.zzg);
    }

    public final zzig zza(String str) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        zzih.zzg((zzih) this.zza, str);
        return this;
    }

    public final zzig zzb(zzyy zzyy) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        ((zzih) this.zza).zze = zzyy;
        return this;
    }

    public final zzig zzc(zzji zzji) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        ((zzih) this.zza).zzf = zzji.zza();
        return this;
    }

    /* synthetic */ zzig(zzif zzif) {
        super(zzih.zzg);
    }
}
