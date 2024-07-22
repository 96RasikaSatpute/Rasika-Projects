package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzyq extends zzys {
    final /* synthetic */ zzyy zza;
    private int zzb = 0;
    private final int zzc;

    zzyq(zzyy zzyy) {
        this.zza = zzyy;
        this.zzc = zzyy.zzc();
    }

    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    public final byte zza() {
        int i = this.zzb;
        if (i < this.zzc) {
            this.zzb = i + 1;
            return this.zza.zzb(i);
        }
        throw new NoSuchElementException();
    }
}
