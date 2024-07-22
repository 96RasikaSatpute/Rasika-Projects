package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzir  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzir extends zzzw<zziu, zzir> implements zzabe {
    private zzir() {
        super(zziu.zzf);
    }

    public final zzir zza(int i) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        ((zziu) this.zza).zzb = i;
        return this;
    }

    public final zzir zzb(zzit zzit) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        zziu.zze((zziu) this.zza, zzit);
        return this;
    }

    /* synthetic */ zzir(zziq zziq) {
        super(zziu.zzf);
    }
}
