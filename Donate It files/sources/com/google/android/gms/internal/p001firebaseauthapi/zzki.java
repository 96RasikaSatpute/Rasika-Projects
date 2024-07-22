package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzki  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzki implements zzam {
    private final zzkk zza;
    private final String zzb;
    private final byte[] zzc;
    private final zzkg zzd;

    public zzki(ECPublicKey eCPublicKey, byte[] bArr, String str, int i, zzkg zzkg) throws GeneralSecurityException {
        zzkl.zza(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
        this.zza = new zzkk(eCPublicKey);
        this.zzc = bArr;
        this.zzb = str;
        this.zzd = zzkg;
    }
}
