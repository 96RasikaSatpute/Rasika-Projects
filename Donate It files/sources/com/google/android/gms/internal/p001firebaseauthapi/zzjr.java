package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjr  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzjr extends zzaaa<zzjr, zzjq> implements zzabe {
    /* access modifiers changed from: private */
    public static final zzjr zze;
    private int zzb;

    static {
        zzjr zzjr = new zzjr();
        zze = zzjr;
        zzaaa.zzy(zzjr.class, zzjr);
    }

    private zzjr() {
    }

    public static zzjr zza(zzyy zzyy, zzzn zzzn) throws zzaai {
        return (zzjr) zzaaa.zzE(zze, zzyy, zzzn);
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zze, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzb"});
        } else if (i2 == 3) {
            return new zzjr();
        } else {
            if (i2 == 4) {
                return new zzjq((zzjp) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zze;
        }
    }
}
