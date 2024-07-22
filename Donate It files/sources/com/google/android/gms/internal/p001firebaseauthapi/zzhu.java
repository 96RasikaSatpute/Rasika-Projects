package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhu  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzhu extends zzaaa<zzhu, zzht> implements zzabe {
    /* access modifiers changed from: private */
    public static final zzhu zzg;
    private zzhx zzb;
    /* access modifiers changed from: private */
    public int zze;
    private int zzf;

    static {
        zzhu zzhu = new zzhu();
        zzg = zzhu;
        zzaaa.zzy(zzhu.class, zzhu);
    }

    private zzhu() {
    }

    public static zzhu zzc(zzyy zzyy, zzzn zzzn) throws zzaai {
        return (zzhu) zzaaa.zzE(zzg, zzyy, zzzn);
    }

    public static zzht zzd() {
        return (zzht) zzg.zzs();
    }

    public static zzhu zze() {
        return zzg;
    }

    static /* synthetic */ void zzg(zzhu zzhu, zzhx zzhx) {
        zzhx.getClass();
        zzhu.zzb = zzhx;
    }

    public final zzhx zza() {
        zzhx zzhx = this.zzb;
        return zzhx == null ? zzhx.zzd() : zzhx;
    }

    public final int zzb() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\u000b", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzhu();
        } else {
            if (i2 == 4) {
                return new zzht((zzhs) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
