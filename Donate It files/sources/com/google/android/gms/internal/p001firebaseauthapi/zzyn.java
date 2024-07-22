package com.google.android.gms.internal.p001firebaseauthapi;

import java.io.IOException;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyn  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzyn {
    static int zza(byte[] bArr, int i, zzym zzym) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzb(b, bArr, i2, zzym);
        }
        zzym.zza = b;
        return i2;
    }

    static int zzb(int i, byte[] bArr, int i2, zzym zzym) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzym.zza = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & ByteCompanionObject.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzym.zza = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & ByteCompanionObject.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzym.zza = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & ByteCompanionObject.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzym.zza = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & ByteCompanionObject.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] < 0) {
                i10 = i12;
            } else {
                zzym.zza = i11;
                return i12;
            }
        }
    }

    static int zzc(byte[] bArr, int i, zzym zzym) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j < 0) {
            int i3 = i2 + 1;
            byte b = bArr[i2];
            long j2 = (j & 127) | (((long) (b & ByteCompanionObject.MAX_VALUE)) << 7);
            int i4 = 7;
            while (b < 0) {
                int i5 = i3 + 1;
                byte b2 = bArr[i3];
                i4 += 7;
                j2 |= ((long) (b2 & ByteCompanionObject.MAX_VALUE)) << i4;
                int i6 = i5;
                b = b2;
                i3 = i6;
            }
            zzym.zzb = j2;
            return i3;
        }
        zzym.zzb = j;
        return i2;
    }

    static int zzd(byte[] bArr, int i) {
        return ((bArr[i + 3] & UByte.MAX_VALUE) << 24) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << 16);
    }

    static long zze(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    static int zzf(byte[] bArr, int i, zzym zzym) throws zzaai {
        int zza = zza(bArr, i, zzym);
        int i2 = zzym.zza;
        if (i2 < 0) {
            throw zzaai.zzc();
        } else if (i2 == 0) {
            zzym.zzc = "";
            return zza;
        } else {
            zzym.zzc = new String(bArr, zza, i2, zzaag.zza);
            return zza + i2;
        }
    }

    static int zzg(byte[] bArr, int i, zzym zzym) throws zzaai {
        int zza = zza(bArr, i, zzym);
        int i2 = zzym.zza;
        if (i2 < 0) {
            throw zzaai.zzc();
        } else if (i2 == 0) {
            zzym.zzc = "";
            return zza;
        } else {
            zzym.zzc = zzacs.zze(bArr, zza, i2);
            return zza + i2;
        }
    }

    static int zzh(byte[] bArr, int i, zzym zzym) throws zzaai {
        int zza = zza(bArr, i, zzym);
        int i2 = zzym.zza;
        if (i2 < 0) {
            throw zzaai.zzc();
        } else if (i2 > bArr.length - zza) {
            throw zzaai.zzb();
        } else if (i2 == 0) {
            zzym.zzc = zzyy.zzb;
            return zza;
        } else {
            zzym.zzc = zzyy.zzl(bArr, zza, i2);
            return zza + i2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int zzi(com.google.android.gms.internal.p001firebaseauthapi.zzabp r6, byte[] r7, int r8, int r9, com.google.android.gms.internal.p001firebaseauthapi.zzym r10) throws java.io.IOException {
        /*
            int r0 = r8 + 1
            byte r8 = r7[r8]
            if (r8 >= 0) goto L_0x000e
            int r0 = zzb(r8, r7, r0, r10)
            int r8 = r10.zza
            r3 = r0
            goto L_0x000f
        L_0x000e:
            r3 = r0
        L_0x000f:
            if (r8 < 0) goto L_0x0027
            int r9 = r9 - r3
            if (r8 > r9) goto L_0x0027
            java.lang.Object r9 = r6.zza()
            int r8 = r8 + r3
            r0 = r6
            r1 = r9
            r2 = r7
            r4 = r8
            r5 = r10
            r0.zzi(r1, r2, r3, r4, r5)
            r6.zzj(r9)
            r10.zzc = r9
            return r8
        L_0x0027:
            com.google.android.gms.internal.firebase-auth-api.zzaai r6 = com.google.android.gms.internal.p001firebaseauthapi.zzaai.zzb()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzyn.zzi(com.google.android.gms.internal.firebase-auth-api.zzabp, byte[], int, int, com.google.android.gms.internal.firebase-auth-api.zzym):int");
    }

    static int zzj(zzabp zzabp, byte[] bArr, int i, int i2, int i3, zzym zzym) throws IOException {
        zzabg zzabg = (zzabg) zzabp;
        Object zza = zzabg.zza();
        int zzh = zzabg.zzh(zza, bArr, i, i2, i3, zzym);
        zzabg.zzj(zza);
        zzym.zzc = zza;
        return zzh;
    }

    static int zzk(int i, byte[] bArr, int i2, int i3, zzaaf<?> zzaaf, zzym zzym) {
        zzaab zzaab = (zzaab) zzaaf;
        int zza = zza(bArr, i2, zzym);
        zzaab.zzf(zzym.zza);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzym);
            if (i != zzym.zza) {
                break;
            }
            zza = zza(bArr, zza2, zzym);
            zzaab.zzf(zzym.zza);
        }
        return zza;
    }

    static int zzl(byte[] bArr, int i, zzaaf<?> zzaaf, zzym zzym) throws IOException {
        zzaab zzaab = (zzaab) zzaaf;
        int zza = zza(bArr, i, zzym);
        int i2 = zzym.zza + zza;
        while (zza < i2) {
            zza = zza(bArr, zza, zzym);
            zzaab.zzf(zzym.zza);
        }
        if (zza == i2) {
            return zza;
        }
        throw zzaai.zzb();
    }

    static int zzm(zzabp<?> zzabp, int i, byte[] bArr, int i2, int i3, zzaaf<?> zzaaf, zzym zzym) throws IOException {
        int zzi = zzi(zzabp, bArr, i2, i3, zzym);
        zzaaf.add(zzym.zzc);
        while (zzi < i3) {
            int zza = zza(bArr, zzi, zzym);
            if (i != zzym.zza) {
                break;
            }
            zzi = zzi(zzabp, bArr, zza, i3, zzym);
            zzaaf.add(zzym.zzc);
        }
        return zzi;
    }

    static int zzn(int i, byte[] bArr, int i2, int i3, zzace zzace, zzym zzym) throws zzaai {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzc = zzc(bArr, i2, zzym);
                zzace.zzh(i, Long.valueOf(zzym.zzb));
                return zzc;
            } else if (i4 == 1) {
                zzace.zzh(i, Long.valueOf(zze(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zza = zza(bArr, i2, zzym);
                int i5 = zzym.zza;
                if (i5 < 0) {
                    throw zzaai.zzc();
                } else if (i5 <= bArr.length - zza) {
                    if (i5 == 0) {
                        zzace.zzh(i, zzyy.zzb);
                    } else {
                        zzace.zzh(i, zzyy.zzl(bArr, zza, i5));
                    }
                    return zza + i5;
                } else {
                    throw zzaai.zzb();
                }
            } else if (i4 == 3) {
                int i6 = (i & -8) | 4;
                zzace zzb = zzace.zzb();
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zza2 = zza(bArr, i2, zzym);
                    int i8 = zzym.zza;
                    if (i8 == i6) {
                        i7 = i8;
                        i2 = zza2;
                        break;
                    }
                    i7 = i8;
                    i2 = zzn(i8, bArr, zza2, i3, zzb, zzym);
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzaai.zzh();
                }
                zzace.zzh(i, zzb);
                return i2;
            } else if (i4 == 5) {
                zzace.zzh(i, Integer.valueOf(zzd(bArr, i2)));
                return i2 + 4;
            } else {
                throw zzaai.zze();
            }
        } else {
            throw zzaai.zze();
        }
    }
}
