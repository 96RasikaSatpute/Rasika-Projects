package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuy  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzuy implements Runnable {
    final /* synthetic */ zzva zza;
    final /* synthetic */ zzuz zzb;

    zzuy(zzuz zzuz, zzva zzva) {
        this.zzb = zzuz;
        this.zza = zzva;
    }

    public final void run() {
        synchronized (this.zzb.zza.zzh) {
            if (!this.zzb.zza.zzh.isEmpty()) {
                this.zza.zza(this.zzb.zza.zzh.get(0), new Object[0]);
            }
        }
    }
}
