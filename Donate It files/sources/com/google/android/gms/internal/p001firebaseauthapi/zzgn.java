package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgn  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzgn extends zzaaa<zzgn, zzgm> implements zzabe {
    /* access modifiers changed from: private */
    public static final zzgn zzb;

    static {
        zzgn zzgn = new zzgn();
        zzb = zzgn;
        zzaaa.zzy(zzgn.class, zzgn);
    }

    private zzgn() {
    }

    public static zzgn zza(zzyy zzyy, zzzn zzzn) throws zzaai {
        return (zzgn) zzaaa.zzE(zzb, zzyy, zzzn);
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzb, "\u0000\u0000", (Object[]) null);
        }
        if (i2 == 3) {
            return new zzgn();
        }
        if (i2 == 4) {
            return new zzgm((zzgl) null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
