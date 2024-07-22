package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvn  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final /* synthetic */ class zzvn implements Runnable {
    private final zzvs zza;
    private final String zzb;

    zzvn(zzvs zzvs, String str) {
        this.zza = zzvs;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zzg(this.zzb);
    }
}
