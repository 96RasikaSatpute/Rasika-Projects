package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzhw extends zzzw<zzhx, zzhw> implements zzabe {
    private zzhw() {
        super(zzhx.zzf);
    }

    public final zzhw zza(zzho zzho) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        ((zzhx) this.zza).zzb = zzho.zza();
        return this;
    }

    public final zzhw zzb(int i) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        ((zzhx) this.zza).zze = i;
        return this;
    }

    /* synthetic */ zzhw(zzhv zzhv) {
        super(zzhx.zzf);
    }
}
