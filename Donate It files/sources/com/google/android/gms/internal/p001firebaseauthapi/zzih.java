package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzih  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzih extends zzaaa<zzih, zzig> implements zzabe {
    /* access modifiers changed from: private */
    public static final zzih zzg;
    private String zzb = "";
    /* access modifiers changed from: private */
    public zzyy zze = zzyy.zzb;
    /* access modifiers changed from: private */
    public int zzf;

    static {
        zzih zzih = new zzih();
        zzg = zzih;
        zzaaa.zzy(zzih.class, zzih);
    }

    private zzih() {
    }

    public static zzig zzd() {
        return (zzig) zzg.zzs();
    }

    public static zzih zze() {
        return zzg;
    }

    static /* synthetic */ void zzg(zzih zzih, String str) {
        str.getClass();
        zzih.zzb = str;
    }

    public final String zza() {
        return this.zzb;
    }

    public final zzyy zzb() {
        return this.zze;
    }

    public final zzji zzc() {
        zzji zzb2 = zzji.zzb(this.zzf);
        return zzb2 == null ? zzji.UNRECOGNIZED : zzb2;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzih();
        } else {
            if (i2 == 4) {
                return new zzig((zzif) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
