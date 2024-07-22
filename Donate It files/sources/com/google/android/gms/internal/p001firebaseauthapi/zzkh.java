package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.EllipticCurve;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkh  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzkh implements zzal {
    private static final byte[] zza = new byte[0];
    private final ECPrivateKey zzb;
    private final zzkj zzc;
    private final String zzd;
    private final byte[] zze;
    private final zzkg zzf;
    private final int zzg;

    public zzkh(ECPrivateKey eCPrivateKey, byte[] bArr, String str, int i, zzkg zzkg) throws GeneralSecurityException {
        this.zzb = eCPrivateKey;
        this.zzc = new zzkj(eCPrivateKey);
        this.zze = bArr;
        this.zzd = str;
        this.zzg = i;
        this.zzf = zzkg;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int i;
        EllipticCurve curve = this.zzb.getParams().getCurve();
        int i2 = this.zzg;
        int zzc2 = zzkl.zzc(curve);
        int i3 = i2 - 1;
        if (i3 == 0) {
            i = zzc2 + zzc2 + 1;
        } else if (i3 != 2) {
            i = zzc2 + 1;
        } else {
            i = zzc2 + zzc2;
        }
        int length = bArr.length;
        if (length >= i) {
            return this.zzf.zzb(this.zzc.zza(Arrays.copyOfRange(bArr, 0, i), this.zzd, this.zze, (byte[]) null, this.zzf.zza(), this.zzg)).zza(Arrays.copyOfRange(bArr, i, length), zza);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
