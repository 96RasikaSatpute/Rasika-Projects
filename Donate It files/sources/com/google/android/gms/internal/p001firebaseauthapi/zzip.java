package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzip  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzip extends zzaaa<zzip, zzim> implements zzabe {
    /* access modifiers changed from: private */
    public static final zzip zzf;
    /* access modifiers changed from: private */
    public int zzb;
    private zzaaf<zzio> zze = zzB();

    static {
        zzip zzip = new zzip();
        zzf = zzip;
        zzaaa.zzy(zzip.class, zzip);
    }

    private zzip() {
    }

    public static zzip zze(byte[] bArr, zzzn zzzn) throws zzaai {
        return (zzip) zzaaa.zzF(zzf, bArr, zzzn);
    }

    public static zzim zzf() {
        return (zzim) zzf.zzs();
    }

    static /* synthetic */ void zzi(zzip zzip, zzio zzio) {
        zzio.getClass();
        zzaaf<zzio> zzaaf = zzip.zze;
        if (!zzaaf.zza()) {
            zzip.zze = zzaaa.zzC(zzaaf);
        }
        zzip.zze.add(zzio);
    }

    public final int zza() {
        return this.zzb;
    }

    public final List<zzio> zzb() {
        return this.zze;
    }

    public final int zzc() {
        return this.zze.size();
    }

    public final zzio zzd(int i) {
        return (zzio) this.zze.get(i);
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzb", "zze", zzio.class});
        } else if (i2 == 3) {
            return new zzip();
        } else {
            if (i2 == 4) {
                return new zzim((zzil) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }
}
