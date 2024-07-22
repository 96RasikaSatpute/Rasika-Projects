package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzbb<P> {
    private final P zza;
    private final byte[] zzb;
    private final zzie zzc;
    private final zzji zzd;

    zzbb(P p, byte[] bArr, zzie zzie, zzji zzji, int i) {
        this.zza = p;
        this.zzb = Arrays.copyOf(bArr, bArr.length);
        this.zzc = zzie;
        this.zzd = zzji;
    }

    public final P zza() {
        return this.zza;
    }

    public final zzie zzb() {
        return this.zzc;
    }

    public final zzji zzc() {
        return this.zzd;
    }

    public final byte[] zzd() {
        byte[] bArr = this.zzb;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }
}
