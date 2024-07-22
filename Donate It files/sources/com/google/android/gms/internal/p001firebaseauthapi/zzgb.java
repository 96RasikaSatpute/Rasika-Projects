package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzgb extends zzaaa<zzgb, zzga> implements zzabe {
    /* access modifiers changed from: private */
    public static final zzgb zzf;
    private int zzb;
    private int zze;

    static {
        zzgb zzgb = new zzgb();
        zzf = zzgb;
        zzaaa.zzy(zzgb.class, zzgb);
    }

    private zzgb() {
    }

    public static zzgb zzb(zzyy zzyy, zzzn zzzn) throws zzaai {
        return (zzgb) zzaaa.zzE(zzf, zzyy, zzzn);
    }

    public final int zza() {
        return this.zzb;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zze", "zzb"});
        } else if (i2 == 3) {
            return new zzgb();
        } else {
            if (i2 == 4) {
                return new zzga((zzfz) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }
}
