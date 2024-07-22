package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgk  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzgk extends zzaaa<zzgk, zzgj> implements zzabe {
    /* access modifiers changed from: private */
    public static final zzgk zzf;
    /* access modifiers changed from: private */
    public int zzb;
    /* access modifiers changed from: private */
    public zzyy zze = zzyy.zzb;

    static {
        zzgk zzgk = new zzgk();
        zzf = zzgk;
        zzaaa.zzy(zzgk.class, zzgk);
    }

    private zzgk() {
    }

    public static zzgk zzc(zzyy zzyy, zzzn zzzn) throws zzaai {
        return (zzgk) zzaaa.zzE(zzf, zzyy, zzzn);
    }

    public static zzgj zzd() {
        return (zzgj) zzf.zzs();
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
            return zzz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new zzgk();
        } else {
            if (i2 == 4) {
                return new zzgj((zzgi) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }
}
