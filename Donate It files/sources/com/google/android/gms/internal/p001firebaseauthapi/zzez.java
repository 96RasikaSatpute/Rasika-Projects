package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzez  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzez extends zzzw<zzfa, zzez> implements zzabe {
    private zzez() {
        super(zzfa.zzg);
    }

    public final zzez zza(int i) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        ((zzfa) this.zza).zzb = 0;
        return this;
    }

    public final zzez zzb(zzfg zzfg) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        zzfa.zzi((zzfa) this.zza, zzfg);
        return this;
    }

    public final zzez zzc(zzyy zzyy) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        ((zzfa) this.zza).zzf = zzyy;
        return this;
    }

    /* synthetic */ zzez(zzey zzey) {
        super(zzfa.zzg);
    }
}
