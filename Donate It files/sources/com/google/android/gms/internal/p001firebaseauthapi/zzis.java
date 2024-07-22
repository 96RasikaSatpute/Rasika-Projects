package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzis  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzis extends zzzw<zzit, zzis> implements zzabe {
    private zzis() {
        super(zzit.zzh);
    }

    public final zzis zza(String str) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        zzit.zzd((zzit) this.zza, str);
        return this;
    }

    public final zzis zzb(zzie zzie) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        ((zzit) this.zza).zze = zzie.zza();
        return this;
    }

    public final zzis zzc(int i) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        ((zzit) this.zza).zzf = i;
        return this;
    }

    public final zzis zzd(zzji zzji) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        ((zzit) this.zza).zzg = zzji.zza();
        return this;
    }

    /* synthetic */ zzis(zziq zziq) {
        super(zzit.zzh);
    }
}
