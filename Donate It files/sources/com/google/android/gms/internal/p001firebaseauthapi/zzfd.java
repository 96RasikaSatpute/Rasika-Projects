package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfd  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzfd extends zzaaa<zzfd, zzfc> implements zzabe {
    /* access modifiers changed from: private */
    public static final zzfd zzf;
    private zzfg zzb;
    /* access modifiers changed from: private */
    public int zze;

    static {
        zzfd zzfd = new zzfd();
        zzf = zzfd;
        zzaaa.zzy(zzfd.class, zzfd);
    }

    private zzfd() {
    }

    public static zzfd zzc(zzyy zzyy, zzzn zzzn) throws zzaai {
        return (zzfd) zzaaa.zzE(zzf, zzyy, zzzn);
    }

    public static zzfc zzd() {
        return (zzfc) zzf.zzs();
    }

    public static zzfd zze() {
        return zzf;
    }

    static /* synthetic */ void zzg(zzfd zzfd, zzfg zzfg) {
        zzfg.getClass();
        zzfd.zzb = zzfg;
    }

    public final zzfg zza() {
        zzfg zzfg = this.zzb;
        return zzfg == null ? zzfg.zzc() : zzfg;
    }

    public final int zzb() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new zzfd();
        } else {
            if (i2 == 4) {
                return new zzfc((zzfb) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }
}
