package com.google.android.gms.internal.p001firebaseauthapi;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.util.Arrays;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzkj {
    private final ECPrivateKey zza;

    public zzkj(ECPrivateKey eCPrivateKey) {
        this.zza = eCPrivateKey;
    }

    public final byte[] zza(byte[] bArr, String str, byte[] bArr2, byte[] bArr3, int i, int i2) throws GeneralSecurityException {
        ECPoint eCPoint;
        boolean z;
        ECParameterSpec params = this.zza.getParams();
        EllipticCurve curve = params.getCurve();
        int zzc = zzkl.zzc(curve);
        int i3 = i2 - 1;
        int i4 = 1;
        if (i3 == 0) {
            int length = bArr.length;
            if (length != zzc + zzc + 1) {
                throw new GeneralSecurityException("invalid point size");
            } else if (bArr[0] == 4) {
                int i5 = zzc + 1;
                ECPoint eCPoint2 = new ECPoint(new BigInteger(1, Arrays.copyOfRange(bArr, 1, i5)), new BigInteger(1, Arrays.copyOfRange(bArr, i5, length)));
                zzkl.zza(eCPoint2, curve);
                eCPoint = eCPoint2;
            } else {
                throw new GeneralSecurityException("invalid point format");
            }
        } else if (i3 != 2) {
            BigInteger zzb = zzkl.zzb(curve);
            int length2 = bArr.length;
            if (length2 == zzc + 1) {
                byte b = bArr[0];
                if (b == 2) {
                    z = false;
                } else if (b == 3) {
                    z = true;
                } else {
                    throw new GeneralSecurityException("invalid format");
                }
                BigInteger bigInteger = new BigInteger(1, Arrays.copyOfRange(bArr, 1, length2));
                if (bigInteger.signum() == -1 || bigInteger.compareTo(zzb) >= 0) {
                    throw new GeneralSecurityException("x is out of range");
                }
                eCPoint = new ECPoint(bigInteger, zzkl.zzd(bigInteger, z, curve));
            } else {
                throw new GeneralSecurityException("compressed point has wrong length");
            }
        } else {
            int length3 = bArr.length;
            if (length3 == zzc + zzc) {
                ECPoint eCPoint3 = new ECPoint(new BigInteger(1, Arrays.copyOfRange(bArr, 0, zzc)), new BigInteger(1, Arrays.copyOfRange(bArr, zzc, length3)));
                zzkl.zza(eCPoint3, curve);
                eCPoint = eCPoint3;
            } else {
                throw new GeneralSecurityException("invalid point size");
            }
        }
        ECPublicKey eCPublicKey = (ECPublicKey) zzkn.zzg.zza("EC").generatePublic(new ECPublicKeySpec(eCPoint, params));
        ECPrivateKey eCPrivateKey = this.zza;
        try {
            ECParameterSpec params2 = eCPublicKey.getParams();
            ECParameterSpec params3 = eCPrivateKey.getParams();
            if (!params2.getCurve().equals(params3.getCurve()) || !params2.getGenerator().equals(params3.getGenerator()) || !params2.getOrder().equals(params3.getOrder()) || params2.getCofactor() != params3.getCofactor()) {
                throw new GeneralSecurityException("invalid public key spec");
            }
            ECPoint w = eCPublicKey.getW();
            zzkl.zza(w, eCPrivateKey.getParams().getCurve());
            PublicKey generatePublic = zzkn.zzg.zza("EC").generatePublic(new ECPublicKeySpec(w, eCPrivateKey.getParams()));
            KeyAgreement zza2 = zzkn.zze.zza("ECDH");
            zza2.init(eCPrivateKey);
            try {
                zza2.doPhase(generatePublic, true);
                byte[] generateSecret = zza2.generateSecret();
                EllipticCurve curve2 = eCPrivateKey.getParams().getCurve();
                BigInteger bigInteger2 = new BigInteger(1, generateSecret);
                if (bigInteger2.signum() == -1 || bigInteger2.compareTo(zzkl.zzb(curve2)) >= 0) {
                    throw new GeneralSecurityException("shared secret is out of range");
                }
                zzkl.zzd(bigInteger2, true, curve2);
                byte[] zzb2 = zzkb.zzb(bArr, generateSecret);
                Mac zza3 = zzkn.zzb.zza(str);
                if (i <= zza3.getMacLength() * 255) {
                    if (bArr2 == null || bArr2.length == 0) {
                        zza3.init(new SecretKeySpec(new byte[zza3.getMacLength()], str));
                    } else {
                        zza3.init(new SecretKeySpec(bArr2, str));
                    }
                    byte[] bArr4 = new byte[i];
                    zza3.init(new SecretKeySpec(zza3.doFinal(zzb2), str));
                    byte[] bArr5 = new byte[0];
                    int i6 = 0;
                    while (true) {
                        zza3.update(bArr5);
                        zza3.update((byte[]) null);
                        zza3.update((byte) i4);
                        bArr5 = zza3.doFinal();
                        int length4 = bArr5.length;
                        int i7 = i6 + length4;
                        if (i7 < i) {
                            System.arraycopy(bArr5, 0, bArr4, i6, length4);
                            i4++;
                            i6 = i7;
                        } else {
                            System.arraycopy(bArr5, 0, bArr4, i6, i - i6);
                            return bArr4;
                        }
                    }
                } else {
                    throw new GeneralSecurityException("size too large");
                }
            } catch (IllegalStateException e) {
                throw new GeneralSecurityException(e.toString());
            }
        } catch (IllegalArgumentException | NullPointerException e2) {
            throw new GeneralSecurityException(e2.toString());
        }
    }
}
