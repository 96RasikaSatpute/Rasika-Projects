package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhr  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzhr extends zzaaa<zzhr, zzhq> implements zzabe {
    /* access modifiers changed from: private */
    public static final zzhr zzg;
    /* access modifiers changed from: private */
    public int zzb;
    private zzhx zze;
    /* access modifiers changed from: private */
    public zzyy zzf = zzyy.zzb;

    static {
        zzhr zzhr = new zzhr();
        zzg = zzhr;
        zzaaa.zzy(zzhr.class, zzhr);
    }

    private zzhr() {
    }

    public static zzhr zzd(zzyy zzyy, zzzn zzzn) throws zzaai {
        return (zzhr) zzaaa.zzE(zzg, zzyy, zzzn);
    }

    public static zzhq zze() {
        return (zzhq) zzg.zzs();
    }

    public static zzhr zzf() {
        return zzg;
    }

    static /* synthetic */ void zzi(zzhr zzhr, zzhx zzhx) {
        zzhx.getClass();
        zzhr.zze = zzhx;
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzhx zzb() {
        zzhx zzhx = this.zze;
        return zzhx == null ? zzhx.zzd() : zzhx;
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
            return new zzhr();
        } else {
            if (i2 == 4) {
                return new zzhq((zzhp) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
