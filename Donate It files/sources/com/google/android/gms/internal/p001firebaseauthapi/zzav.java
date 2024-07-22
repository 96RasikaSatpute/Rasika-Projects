package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Iterator;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzav  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzav {
    private final zzim zza;

    private zzav(zzim zzim) {
        this.zza = zzim;
    }

    public static zzav zza(zzau zzau) {
        return new zzav((zzim) zzau.zzb().zzu());
    }

    public static zzav zzb() {
        return new zzav(zzip.zzf());
    }

    private final synchronized zzio zzg(zzih zzih) throws GeneralSecurityException {
        return zzh(zzbl.zze(zzih), zzih.zzc());
    }

    private final synchronized zzio zzh(zzic zzic, zzji zzji) throws GeneralSecurityException {
        zzin zzf;
        int zzj = zzj();
        if (zzji != zzji.UNKNOWN_PREFIX) {
            zzf = zzio.zzf();
            zzf.zza(zzic);
            zzf.zzc(zzj);
            zzf.zzb(zzie.ENABLED);
            zzf.zzd(zzji);
        } else {
            throw new GeneralSecurityException("unknown output prefix type");
        }
        return (zzio) zzf.zzl();
    }

    private final synchronized boolean zzi(int i) {
        boolean z;
        Iterator<zzio> it = this.zza.zzb().iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().zzd() == i) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        return z;
    }

    private final synchronized int zzj() {
        int zzk;
        zzk = zzk();
        while (zzi(zzk)) {
            zzk = zzk();
        }
        return zzk;
    }

    private static int zzk() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[4];
        byte b = 0;
        while (b == 0) {
            secureRandom.nextBytes(bArr);
            b = ((bArr[0] & ByteCompanionObject.MAX_VALUE) << 24) | ((bArr[1] & UByte.MAX_VALUE) << 16) | ((bArr[2] & UByte.MAX_VALUE) << 8) | (bArr[3] & UByte.MAX_VALUE);
        }
        return b;
    }

    public final synchronized zzau zzc() throws GeneralSecurityException {
        return zzau.zza((zzip) this.zza.zzl());
    }

    public final synchronized zzav zzd(zzaq zzaq) throws GeneralSecurityException {
        zze(zzaq.zza(), false);
        return this;
    }

    @Deprecated
    public final synchronized int zze(zzih zzih, boolean z) throws GeneralSecurityException {
        zzio zzg;
        zzg = zzg(zzih);
        this.zza.zze(zzg);
        return zzg.zzd();
    }

    public final synchronized zzav zzf(int i) throws GeneralSecurityException {
        int i2 = 0;
        while (i2 < this.zza.zzc()) {
            zzio zzd = this.zza.zzd(i2);
            if (zzd.zzd() != i) {
                i2++;
            } else if (zzd.zzc().equals(zzie.ENABLED)) {
                this.zza.zza(i);
            } else {
                StringBuilder sb = new StringBuilder(63);
                sb.append("cannot set key as primary because it's not enabled: ");
                sb.append(i);
                throw new GeneralSecurityException(sb.toString());
            }
        }
        StringBuilder sb2 = new StringBuilder(26);
        sb2.append("key not found: ");
        sb2.append(i);
        throw new GeneralSecurityException(sb2.toString());
        return this;
    }
}
