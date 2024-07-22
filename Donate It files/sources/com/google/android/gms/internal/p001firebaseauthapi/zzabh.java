package com.google.android.gms.internal.p001firebaseauthapi;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabh  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzabh<T> implements zzabp<T> {
    private final zzabd zza;
    private final zzacd<?, ?> zzb;
    private final boolean zzc;
    private final zzzo<?> zzd;

    private zzabh(zzacd<?, ?> zzacd, zzzo<?> zzzo, zzabd zzabd) {
        this.zzb = zzacd;
        this.zzc = zzzo.zza(zzabd);
        this.zzd = zzzo;
        this.zza = zzabd;
    }

    static <T> zzabh<T> zzg(zzacd<?, ?> zzacd, zzzo<?> zzzo, zzabd zzabd) {
        return new zzabh<>(zzacd, zzzo, zzabd);
    }

    public final T zza() {
        return this.zza.zzH().zzn();
    }

    public final boolean zzb(T t, T t2) {
        if (!this.zzb.zzj(t).equals(this.zzb.zzj(t2))) {
            return false;
        }
        if (!this.zzc) {
            return true;
        }
        this.zzd.zzb(t);
        this.zzd.zzb(t2);
        throw null;
    }

    public final int zzc(T t) {
        int hashCode = this.zzb.zzj(t).hashCode();
        if (!this.zzc) {
            return hashCode;
        }
        this.zzd.zzb(t);
        throw null;
    }

    public final void zzd(T t, T t2) {
        zzabr.zzF(this.zzb, t, t2);
        if (this.zzc) {
            zzabr.zzE(this.zzd, t, t2);
        }
    }

    public final int zze(T t) {
        zzacd<?, ?> zzacd = this.zzb;
        int zzp = zzacd.zzp(zzacd.zzj(t));
        if (!this.zzc) {
            return zzp;
        }
        this.zzd.zzb(t);
        throw null;
    }

    public final void zzf(T t, zzabo zzabo, zzzn zzzn) throws IOException {
        boolean z;
        zzacd<?, ?> zzacd = this.zzb;
        zzzo<?> zzzo = this.zzd;
        Object zzk = zzacd.zzk(t);
        zzzs<?> zzc2 = zzzo.zzc(t);
        while (zzabo.zzb() != Integer.MAX_VALUE) {
            int zzc3 = zzabo.zzc();
            if (zzc3 != 11) {
                if ((zzc3 & 7) == 2) {
                    Object zzf = zzzo.zzf(zzzn, this.zza, zzc3 >>> 3);
                    if (zzf != null) {
                        zzzo.zzg(zzabo, zzf, zzzn, zzc2);
                    } else {
                        z = zzacd.zzn(zzk, zzabo);
                    }
                } else {
                    z = zzabo.zzd();
                }
                if (!z) {
                    break;
                }
            } else {
                int i = 0;
                Object obj = null;
                zzyy zzyy = null;
                while (true) {
                    try {
                        if (zzabo.zzb() == Integer.MAX_VALUE) {
                            break;
                        }
                        int zzc4 = zzabo.zzc();
                        if (zzc4 == 16) {
                            i = zzabo.zzr();
                            obj = zzzo.zzf(zzzn, this.zza, i);
                        } else if (zzc4 == 26) {
                            if (obj != null) {
                                zzzo.zzg(zzabo, obj, zzzn, zzc2);
                            } else {
                                zzyy = zzabo.zzq();
                            }
                        } else if (!zzabo.zzd()) {
                            break;
                        }
                    } catch (Throwable th) {
                        zzacd.zzl(t, zzk);
                        throw th;
                    }
                }
                if (zzabo.zzc() != 12) {
                    throw zzaai.zzf();
                } else if (zzyy != null) {
                    if (obj != null) {
                        zzzo.zzh(zzyy, obj, zzzn, zzc2);
                    } else {
                        zzacd.zze(zzk, i, zzyy);
                    }
                }
            }
        }
        zzacd.zzl(t, zzk);
    }

    public final void zzi(T t, byte[] bArr, int i, int i2, zzym zzym) throws IOException {
        zzaaa zzaaa = (zzaaa) t;
        if (zzaaa.zzc == zzace.zza()) {
            zzaaa.zzc = zzace.zzb();
        }
        zzzx zzzx = (zzzx) t;
        throw null;
    }

    public final void zzj(T t) {
        this.zzb.zzm(t);
        this.zzd.zzd(t);
    }

    public final boolean zzk(T t) {
        this.zzd.zzb(t);
        throw null;
    }

    public final void zzn(T t, zzzj zzzj) throws IOException {
        this.zzd.zzb(t);
        throw null;
    }
}
