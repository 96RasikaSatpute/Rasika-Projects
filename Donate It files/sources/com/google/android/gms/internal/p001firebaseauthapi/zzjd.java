package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjd  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzjd extends zzaaa<zzjd, zzjc> implements zzabe {
    /* access modifiers changed from: private */
    public static final zzjd zzf;
    /* access modifiers changed from: private */
    public int zzb;
    private zzjg zze;

    static {
        zzjd zzjd = new zzjd();
        zzf = zzjd;
        zzaaa.zzy(zzjd.class, zzjd);
    }

    private zzjd() {
    }

    public static zzjd zzc(zzyy zzyy, zzzn zzzn) throws zzaai {
        return (zzjd) zzaaa.zzE(zzf, zzyy, zzzn);
    }

    public static zzjc zzd() {
        return (zzjc) zzf.zzs();
    }

    static /* synthetic */ void zzg(zzjd zzjd, zzjg zzjg) {
        zzjg.getClass();
        zzjd.zze = zzjg;
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzjg zzb() {
        zzjg zzjg = this.zze;
        return zzjg == null ? zzjg.zze() : zzjg;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new zzjd();
        } else {
            if (i2 == 4) {
                return new zzjc((zzjb) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }
}
