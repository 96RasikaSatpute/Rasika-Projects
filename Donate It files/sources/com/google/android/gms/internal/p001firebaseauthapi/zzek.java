package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzek  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzek extends zzzw<zzel, zzek> implements zzabe {
    private zzek() {
        super(zzel.zzg);
    }

    public final zzek zza(int i) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        ((zzel) this.zza).zzb = 0;
        return this;
    }

    public final zzek zzb(zzyy zzyy) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        ((zzel) this.zza).zze = zzyy;
        return this;
    }

    public final zzek zzc(zzer zzer) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        zzel.zzi((zzel) this.zza, zzer);
        return this;
    }

    /* synthetic */ zzek(zzej zzej) {
        super(zzel.zzg);
    }
}
