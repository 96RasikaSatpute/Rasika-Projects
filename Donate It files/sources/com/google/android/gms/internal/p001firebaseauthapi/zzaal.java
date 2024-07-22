package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaal  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public class zzaal {
    private static final zzzn zzb = zzzn.zza();
    protected volatile zzabd zza;
    private volatile zzyy zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaal)) {
            return false;
        }
        zzaal zzaal = (zzaal) obj;
        zzabd zzabd = this.zza;
        zzabd zzabd2 = zzaal.zza;
        if (zzabd == null && zzabd2 == null) {
            return zzb().equals(zzaal.zzb());
        }
        if (zzabd != null && zzabd2 != null) {
            return zzabd.equals(zzabd2);
        }
        if (zzabd != null) {
            zzaal.zzc(zzabd.zzo());
            return zzabd.equals(zzaal.zza);
        }
        zzc(zzabd2.zzo());
        return this.zza.equals(zzabd2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzyw) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzw();
        }
        return 0;
    }

    public final zzyy zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                zzyy zzyy = this.zzc;
                return zzyy;
            }
            if (this.zza == null) {
                this.zzc = zzyy.zzb;
            } else {
                this.zzc = this.zza.zzn();
            }
            zzyy zzyy2 = this.zzc;
            return zzyy2;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzc(zzabd zzabd) {
        if (this.zza == null) {
            synchronized (this) {
                if (this.zza == null) {
                    try {
                        this.zza = zzabd;
                        this.zzc = zzyy.zzb;
                    } catch (zzaai e) {
                        this.zza = zzabd;
                        this.zzc = zzyy.zzb;
                    }
                }
            }
        }
    }
}
