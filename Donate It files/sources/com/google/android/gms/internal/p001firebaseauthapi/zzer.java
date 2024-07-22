package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzer  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzer extends zzaaa<zzer, zzeq> implements zzabe {
    /* access modifiers changed from: private */
    public static final zzer zze;
    private int zzb;

    static {
        zzer zzer = new zzer();
        zze = zzer;
        zzaaa.zzy(zzer.class, zzer);
    }

    private zzer() {
    }

    public static zzer zzb() {
        return zze;
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
            return zzz(zze, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzb"});
        } else if (i2 == 3) {
            return new zzer();
        } else {
            if (i2 == 4) {
                return new zzeq((zzep) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zze;
        }
    }
}
