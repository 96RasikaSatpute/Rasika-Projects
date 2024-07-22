package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzet  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzet extends zzzw<zzeu, zzet> implements zzabe {
    private zzet() {
        super(zzeu.zzg);
    }

    public final zzet zza(int i) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        ((zzeu) this.zza).zzb = i;
        return this;
    }

    public final zzet zzb(zzfa zzfa) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        zzeu.zzh((zzeu) this.zza, zzfa);
        return this;
    }

    public final zzet zzc(zzhr zzhr) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        zzeu.zzi((zzeu) this.zza, zzhr);
        return this;
    }

    /* synthetic */ zzet(zzes zzes) {
        super(zzeu.zzg);
    }
}
