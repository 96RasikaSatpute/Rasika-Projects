package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgh  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzgh extends zzaaa<zzgh, zzgg> implements zzabe {
    /* access modifiers changed from: private */
    public static final zzgh zzf;
    private int zzb;
    private int zze;

    static {
        zzgh zzgh = new zzgh();
        zzf = zzgh;
        zzaaa.zzy(zzgh.class, zzgh);
    }

    private zzgh() {
    }

    public static zzgh zzb(zzyy zzyy, zzzn zzzn) throws zzaai {
        return (zzgh) zzaaa.zzE(zzf, zzyy, zzzn);
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
            return zzz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new zzgh();
        } else {
            if (i2 == 4) {
                return new zzgg((zzgf) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }
}
