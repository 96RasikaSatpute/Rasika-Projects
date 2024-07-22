package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfv  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzfv extends zzaaa<zzfv, zzfu> implements zzabe {
    /* access modifiers changed from: private */
    public static final zzfv zzf;
    /* access modifiers changed from: private */
    public int zzb;
    private int zze;

    static {
        zzfv zzfv = new zzfv();
        zzf = zzfv;
        zzaaa.zzy(zzfv.class, zzfv);
    }

    private zzfv() {
    }

    public static zzfv zzb(zzyy zzyy, zzzn zzzn) throws zzaai {
        return (zzfv) zzaaa.zzE(zzf, zzyy, zzzn);
    }

    public static zzfu zzc() {
        return (zzfu) zzf.zzs();
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
            return zzz(zzf, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new zzfv();
        } else {
            if (i2 == 4) {
                return new zzfu((zzft) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }
}
