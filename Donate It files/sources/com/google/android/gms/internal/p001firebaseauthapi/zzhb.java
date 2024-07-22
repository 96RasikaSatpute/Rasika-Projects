package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzhb extends zzaaa<zzhb, zzha> implements zzabe {
    /* access modifiers changed from: private */
    public static final zzhb zzg;
    /* access modifiers changed from: private */
    public int zzb;
    private zzhe zze;
    /* access modifiers changed from: private */
    public zzyy zzf = zzyy.zzb;

    static {
        zzhb zzhb = new zzhb();
        zzg = zzhb;
        zzaaa.zzy(zzhb.class, zzhb);
    }

    private zzhb() {
    }

    public static zzhb zzd(zzyy zzyy, zzzn zzzn) throws zzaai {
        return (zzhb) zzaaa.zzE(zzg, zzyy, zzzn);
    }

    public static zzha zze() {
        return (zzha) zzg.zzs();
    }

    static /* synthetic */ void zzh(zzhb zzhb, zzhe zzhe) {
        zzhe.getClass();
        zzhb.zze = zzhe;
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzhe zzb() {
        zzhe zzhe = this.zze;
        return zzhe == null ? zzhe.zzg() : zzhe;
    }

    public final zzyy zzc() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzhb();
        } else {
            if (i2 == 4) {
                return new zzha((zzgz) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
