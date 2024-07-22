package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzix  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzix extends zzaaa<zzix, zziw> implements zzabe {
    /* access modifiers changed from: private */
    public static final zzix zzf;
    /* access modifiers changed from: private */
    public int zzb;
    private zzja zze;

    static {
        zzix zzix = new zzix();
        zzf = zzix;
        zzaaa.zzy(zzix.class, zzix);
    }

    private zzix() {
    }

    public static zzix zzc(zzyy zzyy, zzzn zzzn) throws zzaai {
        return (zzix) zzaaa.zzE(zzf, zzyy, zzzn);
    }

    public static zziw zzd() {
        return (zziw) zzf.zzs();
    }

    static /* synthetic */ void zzg(zzix zzix, zzja zzja) {
        zzja.getClass();
        zzix.zze = zzja;
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzja zzb() {
        zzja zzja = this.zze;
        return zzja == null ? zzja.zzc() : zzja;
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
            return new zzix();
        } else {
            if (i2 == 4) {
                return new zziw((zziv) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }
}
