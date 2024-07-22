package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjo  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzjo extends zzaaa<zzjo, zzjn> implements zzabe {
    /* access modifiers changed from: private */
    public static final zzjo zzf;
    /* access modifiers changed from: private */
    public int zzb;
    /* access modifiers changed from: private */
    public zzyy zze = zzyy.zzb;

    static {
        zzjo zzjo = new zzjo();
        zzf = zzjo;
        zzaaa.zzy(zzjo.class, zzjo);
    }

    private zzjo() {
    }

    public static zzjo zzc(zzyy zzyy, zzzn zzzn) throws zzaai {
        return (zzjo) zzaaa.zzE(zzf, zzyy, zzzn);
    }

    public static zzjn zzd() {
        return (zzjn) zzf.zzs();
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
            return zzz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new zzjo();
        } else {
            if (i2 == 4) {
                return new zzjn((zzjm) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }
}
