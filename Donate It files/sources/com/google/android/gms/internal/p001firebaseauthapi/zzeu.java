package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzeu  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzeu extends zzaaa<zzeu, zzet> implements zzabe {
    /* access modifiers changed from: private */
    public static final zzeu zzg;
    /* access modifiers changed from: private */
    public int zzb;
    private zzfa zze;
    private zzhr zzf;

    static {
        zzeu zzeu = new zzeu();
        zzg = zzeu;
        zzaaa.zzy(zzeu.class, zzeu);
    }

    private zzeu() {
    }

    public static zzeu zzd(zzyy zzyy, zzzn zzzn) throws zzaai {
        return (zzeu) zzaaa.zzE(zzg, zzyy, zzzn);
    }

    public static zzet zze() {
        return (zzet) zzg.zzs();
    }

    static /* synthetic */ void zzh(zzeu zzeu, zzfa zzfa) {
        zzfa.getClass();
        zzeu.zze = zzfa;
    }

    static /* synthetic */ void zzi(zzeu zzeu, zzhr zzhr) {
        zzhr.getClass();
        zzeu.zzf = zzhr;
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzfa zzb() {
        zzfa zzfa = this.zze;
        return zzfa == null ? zzfa.zzf() : zzfa;
    }

    public final zzhr zzc() {
        zzhr zzhr = this.zzf;
        return zzhr == null ? zzhr.zzf() : zzhr;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzeu();
        } else {
            if (i2 == 4) {
                return new zzet((zzes) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
