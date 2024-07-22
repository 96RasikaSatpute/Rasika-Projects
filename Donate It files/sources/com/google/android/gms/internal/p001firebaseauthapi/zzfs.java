package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfs  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzfs extends zzaaa<zzfs, zzfr> implements zzabe {
    /* access modifiers changed from: private */
    public static final zzfs zzf;
    /* access modifiers changed from: private */
    public int zzb;
    /* access modifiers changed from: private */
    public zzyy zze = zzyy.zzb;

    static {
        zzfs zzfs = new zzfs();
        zzf = zzfs;
        zzaaa.zzy(zzfs.class, zzfs);
    }

    private zzfs() {
    }

    public static zzfs zzc(zzyy zzyy, zzzn zzzn) throws zzaai {
        return (zzfs) zzaaa.zzE(zzf, zzyy, zzzn);
    }

    public static zzfr zzd() {
        return (zzfr) zzf.zzs();
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzyy zzb() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new zzfs();
        } else {
            if (i2 == 4) {
                return new zzfr((zzfq) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }
}
