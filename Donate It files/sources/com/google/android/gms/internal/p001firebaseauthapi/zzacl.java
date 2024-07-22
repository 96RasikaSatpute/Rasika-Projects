package com.google.android.gms.internal.p001firebaseauthapi;

import sun.misc.Unsafe;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacl  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzacl extends zzacm {
    zzacl(Unsafe unsafe) {
        super(unsafe);
    }

    public final void zza(Object obj, long j, byte b) {
        if (zzacn.zzb) {
            zzacn.zzD(obj, j, b);
        } else {
            zzacn.zzE(obj, j, b);
        }
    }

    public final boolean zzb(Object obj, long j) {
        if (zzacn.zzb) {
            return zzacn.zzv(obj, j);
        }
        return zzacn.zzw(obj, j);
    }

    public final void zzc(Object obj, long j, boolean z) {
        if (zzacn.zzb) {
            zzacn.zzD(obj, j, r3 ? (byte) 1 : 0);
        } else {
            zzacn.zzE(obj, j, r3 ? (byte) 1 : 0);
        }
    }

    public final float zzd(Object obj, long j) {
        return Float.intBitsToFloat(zzk(obj, j));
    }

    public final void zze(Object obj, long j, float f) {
        zzl(obj, j, Float.floatToIntBits(f));
    }

    public final double zzf(Object obj, long j) {
        return Double.longBitsToDouble(zzm(obj, j));
    }

    public final void zzg(Object obj, long j, double d) {
        zzn(obj, j, Double.doubleToLongBits(d));
    }
}
