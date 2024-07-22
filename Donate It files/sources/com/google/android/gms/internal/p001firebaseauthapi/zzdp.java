package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdp  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzdp {
    private final zzag zza;
    private final zzak zzb;

    public zzdp(zzag zzag) {
        this.zza = zzag;
        this.zzb = null;
    }

    public zzdp(zzak zzak) {
        this.zza = null;
        this.zzb = zzak;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        zzag zzag = this.zza;
        if (zzag != null) {
            return zzag.zzb(bArr, bArr2);
        }
        return this.zzb.zza(bArr, bArr2);
    }
}
