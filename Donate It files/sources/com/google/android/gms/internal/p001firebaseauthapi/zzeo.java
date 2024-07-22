package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzeo  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzeo extends zzaaa<zzeo, zzen> implements zzabe {
    /* access modifiers changed from: private */
    public static final zzeo zzf;
    private int zzb;
    private zzer zze;

    static {
        zzeo zzeo = new zzeo();
        zzf = zzeo;
        zzaaa.zzy(zzeo.class, zzeo);
    }

    private zzeo() {
    }

    public static zzeo zzc(zzyy zzyy, zzzn zzzn) throws zzaai {
        return (zzeo) zzaaa.zzE(zzf, zzyy, zzzn);
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzer zzb() {
        zzer zzer = this.zze;
        return zzer == null ? zzer.zzb() : zzer;
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
            return new zzeo();
        } else {
            if (i2 == 4) {
                return new zzen((zzem) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }
}
