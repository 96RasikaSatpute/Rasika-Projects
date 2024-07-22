package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzja  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzja extends zzaaa<zzja, zziz> implements zzabe {
    /* access modifiers changed from: private */
    public static final zzja zze;
    private String zzb = "";

    static {
        zzja zzja = new zzja();
        zze = zzja;
        zzaaa.zzy(zzja.class, zzja);
    }

    private zzja() {
    }

    public static zzja zzb(zzyy zzyy, zzzn zzzn) throws zzaai {
        return (zzja) zzaaa.zzE(zze, zzyy, zzzn);
    }

    public static zzja zzc() {
        return zze;
    }

    public final String zza() {
        return this.zzb;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zze, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzb"});
        } else if (i2 == 3) {
            return new zzja();
        } else {
            if (i2 == 4) {
                return new zziz((zziy) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zze;
        }
    }
}
