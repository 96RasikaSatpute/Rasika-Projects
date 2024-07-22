package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zziu  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zziu extends zzaaa<zziu, zzir> implements zzabe {
    /* access modifiers changed from: private */
    public static final zziu zzf;
    /* access modifiers changed from: private */
    public int zzb;
    private zzaaf<zzit> zze = zzB();

    static {
        zziu zziu = new zziu();
        zzf = zziu;
        zzaaa.zzy(zziu.class, zziu);
    }

    private zziu() {
    }

    public static zzir zzb() {
        return (zzir) zzf.zzs();
    }

    static /* synthetic */ void zze(zziu zziu, zzit zzit) {
        zzit.getClass();
        zzaaf<zzit> zzaaf = zziu.zze;
        if (!zzaaf.zza()) {
            zziu.zze = zzaaa.zzC(zzaaf);
        }
        zziu.zze.add(zzit);
    }

    public final zzit zza(int i) {
        return (zzit) this.zze.get(0);
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzb", "zze", zzit.class});
        } else if (i2 == 3) {
            return new zziu();
        } else {
            if (i2 == 4) {
                return new zzir((zziq) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }
}
