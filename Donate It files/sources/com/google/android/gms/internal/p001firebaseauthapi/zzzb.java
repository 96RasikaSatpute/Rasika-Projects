package com.google.android.gms.internal.p001firebaseauthapi;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public abstract class zzzb {
    int zza;
    zzzc zzb;

    /* synthetic */ zzzb(zzyz zzyz) {
    }

    static zzzb zzs(byte[] bArr, int i, int i2, boolean z) {
        zzza zzza = new zzza(bArr, 0, i2, z, (zzyz) null);
        try {
            zzza.zzm(i2);
            return zzza;
        } catch (zzaai e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static int zzt(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long zzu(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public abstract int zza() throws IOException;

    public abstract void zzb(int i) throws zzaai;

    public abstract boolean zzc(int i) throws IOException;

    public abstract boolean zzd() throws IOException;

    public abstract String zze() throws IOException;

    public abstract String zzf() throws IOException;

    public abstract zzyy zzg() throws IOException;

    public abstract int zzm(int i) throws zzaai;

    public abstract void zzn(int i);

    public abstract boolean zzo() throws IOException;

    public abstract int zzp();
}
