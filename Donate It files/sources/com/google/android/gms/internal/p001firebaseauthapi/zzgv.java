package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgv  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzgv extends zzaaa<zzgv, zzgu> implements zzabe {
    /* access modifiers changed from: private */
    public static final zzgv zze;
    private zzgy zzb;

    static {
        zzgv zzgv = new zzgv();
        zze = zzgv;
        zzaaa.zzy(zzgv.class, zzgv);
    }

    private zzgv() {
    }

    public static zzgv zzb(zzyy zzyy, zzzn zzzn) throws zzaai {
        return (zzgv) zzaaa.zzE(zze, zzyy, zzzn);
    }

    public static zzgu zzc() {
        return (zzgu) zze.zzs();
    }

    static /* synthetic */ void zze(zzgv zzgv, zzgy zzgy) {
        zzgy.getClass();
        zzgv.zzb = zzgy;
    }

    public final zzgy zza() {
        zzgy zzgy = this.zzb;
        return zzgy == null ? zzgy.zze() : zzgy;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zze, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"zzb"});
        } else if (i2 == 3) {
            return new zzgv();
        } else {
            if (i2 == 4) {
                return new zzgu((zzgt) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zze;
        }
    }
}
