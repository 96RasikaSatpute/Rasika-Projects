package com.google.android.gms.internal.p001firebaseauthapi;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabg  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzabg<T> implements zzabp<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzacn.zzq();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzabd zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final int[] zzk;
    private final int zzl;
    private final int zzm;
    private final zzaar zzn;
    private final zzacd<?, ?> zzo;
    private final zzzo<?> zzp;
    private final zzabi zzq;
    private final zzaay zzr;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.google.android.gms.internal.firebase-auth-api.zzabd} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: com.google.android.gms.internal.firebase-auth-api.zzabi} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaay} */
    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.android.gms.internal.firebase-auth-api.zzzo, com.google.android.gms.internal.firebase-auth-api.zzzo<?>] */
    /* JADX WARNING: type inference failed for: r3v2, types: [int] */
    /* JADX WARNING: type inference failed for: r3v9, types: [int] */
    /* JADX WARNING: type inference failed for: r3v12, types: [com.google.android.gms.internal.firebase-auth-api.zzaar] */
    /* JADX WARNING: type inference failed for: r3v13, types: [com.google.android.gms.internal.firebase-auth-api.zzacd<?, ?>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzabg(int[] r6, int[] r7, java.lang.Object[] r8, int r9, int r10, com.google.android.gms.internal.p001firebaseauthapi.zzabd r11, boolean r12, boolean r13, int[] r14, int r15, int r16, com.google.android.gms.internal.p001firebaseauthapi.zzabi r17, com.google.android.gms.internal.p001firebaseauthapi.zzaar r18, com.google.android.gms.internal.p001firebaseauthapi.zzacd<?, ?> r19, com.google.android.gms.internal.p001firebaseauthapi.zzzo<?> r20, com.google.android.gms.internal.p001firebaseauthapi.zzaay r21) {
        /*
            r5 = this;
            r0 = r5
            r1 = r10
            r2 = r19
            r5.<init>()
            r3 = r6
            r0.zzc = r3
            r3 = r7
            r0.zzd = r3
            r3 = r8
            r0.zze = r3
            r3 = r9
            r0.zzf = r3
            boolean r3 = r1 instanceof com.google.android.gms.internal.p001firebaseauthapi.zzaaa
            r0.zzi = r3
            r3 = r11
            r0.zzj = r3
            r3 = 0
            if (r2 == 0) goto L_0x0025
            boolean r4 = r2.zza(r10)
            if (r4 == 0) goto L_0x0025
            r3 = 1
            goto L_0x0026
        L_0x0025:
        L_0x0026:
            r0.zzh = r3
            r3 = r13
            r0.zzk = r3
            r3 = r14
            r0.zzl = r3
            r3 = r15
            r0.zzm = r3
            r3 = r16
            r0.zzq = r3
            r3 = r17
            r0.zzn = r3
            r3 = r18
            r0.zzo = r3
            r0.zzp = r2
            r0.zzg = r1
            r1 = r20
            r0.zzr = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzabg.<init>(int[], java.lang.Object[], int, int, com.google.android.gms.internal.firebase-auth-api.zzabd, boolean, boolean, int[], int, int, com.google.android.gms.internal.firebase-auth-api.zzabi, com.google.android.gms.internal.firebase-auth-api.zzaar, com.google.android.gms.internal.firebase-auth-api.zzacd, com.google.android.gms.internal.firebase-auth-api.zzzo, com.google.android.gms.internal.firebase-auth-api.zzaay, byte[]):void");
    }

    private final <UT, UB> UB zzA(Object obj, int i, UB ub, zzacd<UT, UB> zzacd) {
        int i2 = this.zzc[i];
        Object zzn2 = zzacn.zzn(obj, (long) (zzD(i) & 1048575));
        if (zzn2 == null || zzy(i) == null) {
            return ub;
        }
        zzaax zzaax = (zzaax) zzn2;
        zzaaw zzaaw = (zzaaw) zzx(i);
        throw null;
    }

    private static boolean zzB(Object obj, int i, zzabp zzabp) {
        return zzabp.zzk(zzacn.zzn(obj, (long) (i & 1048575)));
    }

    private final void zzC(Object obj, int i, zzabo zzabo) throws IOException {
        if (zzG(i)) {
            zzacn.zzo(obj, (long) (i & 1048575), zzabo.zzn());
        } else if (this.zzi) {
            zzacn.zzo(obj, (long) (i & 1048575), zzabo.zzm());
        } else {
            zzacn.zzo(obj, (long) (i & 1048575), zzabo.zzq());
        }
    }

    private final int zzD(int i) {
        return this.zzc[i + 1];
    }

    private final int zzE(int i) {
        return this.zzc[i + 2];
    }

    private static int zzF(int i) {
        return (i >>> 20) & 255;
    }

    private static boolean zzG(int i) {
        return (i & 536870912) != 0;
    }

    private static <T> double zzH(T t, long j) {
        return ((Double) zzacn.zzn(t, j)).doubleValue();
    }

    private static <T> float zzI(T t, long j) {
        return ((Float) zzacn.zzn(t, j)).floatValue();
    }

    private static <T> int zzJ(T t, long j) {
        return ((Integer) zzacn.zzn(t, j)).intValue();
    }

    private static <T> long zzK(T t, long j) {
        return ((Long) zzacn.zzn(t, j)).longValue();
    }

    private static <T> boolean zzL(T t, long j) {
        return ((Boolean) zzacn.zzn(t, j)).booleanValue();
    }

    private final boolean zzM(T t, T t2, int i) {
        return zzO(t, i) == zzO(t2, i);
    }

    private final boolean zzN(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzO(t, i);
        }
        return (i3 & i4) != 0;
    }

    private final boolean zzO(T t, int i) {
        int zzE = zzE(i);
        long j = (long) (zzE & 1048575);
        if (j != 1048575) {
            return (zzacn.zzd(t, j) & (1 << (zzE >>> 20))) != 0;
        }
        int zzD = zzD(i);
        long j2 = (long) (zzD & 1048575);
        switch (zzF(zzD)) {
            case 0:
                return zzacn.zzl(t, j2) != 0.0d;
            case 1:
                return zzacn.zzj(t, j2) != 0.0f;
            case 2:
                return zzacn.zzf(t, j2) != 0;
            case 3:
                return zzacn.zzf(t, j2) != 0;
            case 4:
                return zzacn.zzd(t, j2) != 0;
            case 5:
                return zzacn.zzf(t, j2) != 0;
            case 6:
                return zzacn.zzd(t, j2) != 0;
            case 7:
                return zzacn.zzh(t, j2);
            case 8:
                Object zzn2 = zzacn.zzn(t, j2);
                if (zzn2 instanceof String) {
                    return !((String) zzn2).isEmpty();
                }
                if (zzn2 instanceof zzyy) {
                    return !zzyy.zzb.equals(zzn2);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzacn.zzn(t, j2) != null;
            case 10:
                return !zzyy.zzb.equals(zzacn.zzn(t, j2));
            case 11:
                return zzacn.zzd(t, j2) != 0;
            case 12:
                return zzacn.zzd(t, j2) != 0;
            case 13:
                return zzacn.zzd(t, j2) != 0;
            case 14:
                return zzacn.zzf(t, j2) != 0;
            case 15:
                return zzacn.zzd(t, j2) != 0;
            case 16:
                return zzacn.zzf(t, j2) != 0;
            case 17:
                return zzacn.zzn(t, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final void zzP(T t, int i) {
        int zzE = zzE(i);
        long j = (long) (1048575 & zzE);
        if (j != 1048575) {
            zzacn.zze(t, j, (1 << (zzE >>> 20)) | zzacn.zzd(t, j));
        }
    }

    private final boolean zzQ(T t, int i, int i2) {
        return zzacn.zzd(t, (long) (zzE(i2) & 1048575)) == i;
    }

    private final void zzR(T t, int i, int i2) {
        zzacn.zze(t, (long) (zzE(i2) & 1048575), i);
    }

    private final int zzS(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzU(i, 0);
    }

    private final int zzT(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzU(i, i2);
    }

    private final int zzU(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private final void zzV(T t, zzzj zzzj) throws IOException {
        int i;
        T t2 = t;
        zzzj zzzj2 = zzzj;
        if (!this.zzh) {
            int length = this.zzc.length;
            Unsafe unsafe = zzb;
            int i2 = 1048575;
            int i3 = 1048575;
            int i4 = 0;
            int i5 = 0;
            while (i4 < length) {
                int zzD = zzD(i4);
                int i6 = this.zzc[i4];
                int zzF = zzF(zzD);
                if (zzF <= 17) {
                    int i7 = this.zzc[i4 + 2];
                    int i8 = i7 & i2;
                    if (i8 != i3) {
                        i5 = unsafe.getInt(t2, (long) i8);
                        i3 = i8;
                    }
                    i = 1 << (i7 >>> 20);
                } else {
                    i = 0;
                }
                long j = (long) (zzD & i2);
                switch (zzF) {
                    case 0:
                        if ((i5 & i) == 0) {
                            break;
                        } else {
                            zzzj2.zzf(i6, zzacn.zzl(t2, j));
                            break;
                        }
                    case 1:
                        if ((i5 & i) == 0) {
                            break;
                        } else {
                            zzzj2.zze(i6, zzacn.zzj(t2, j));
                            break;
                        }
                    case 2:
                        if ((i5 & i) == 0) {
                            break;
                        } else {
                            zzzj2.zzc(i6, unsafe.getLong(t2, j));
                            break;
                        }
                    case 3:
                        if ((i5 & i) == 0) {
                            break;
                        } else {
                            zzzj2.zzh(i6, unsafe.getLong(t2, j));
                            break;
                        }
                    case 4:
                        if ((i5 & i) == 0) {
                            break;
                        } else {
                            zzzj2.zzi(i6, unsafe.getInt(t2, j));
                            break;
                        }
                    case 5:
                        if ((i5 & i) == 0) {
                            break;
                        } else {
                            zzzj2.zzj(i6, unsafe.getLong(t2, j));
                            break;
                        }
                    case 6:
                        if ((i5 & i) == 0) {
                            break;
                        } else {
                            zzzj2.zzk(i6, unsafe.getInt(t2, j));
                            break;
                        }
                    case 7:
                        if ((i5 & i) == 0) {
                            break;
                        } else {
                            zzzj2.zzl(i6, zzacn.zzh(t2, j));
                            break;
                        }
                    case 8:
                        if ((i5 & i) == 0) {
                            break;
                        } else {
                            zzX(i6, unsafe.getObject(t2, j), zzzj2);
                            break;
                        }
                    case 9:
                        if ((i5 & i) == 0) {
                            break;
                        } else {
                            zzzj2.zzr(i6, unsafe.getObject(t2, j), zzw(i4));
                            break;
                        }
                    case 10:
                        if ((i5 & i) == 0) {
                            break;
                        } else {
                            zzzj2.zzn(i6, (zzyy) unsafe.getObject(t2, j));
                            break;
                        }
                    case 11:
                        if ((i5 & i) == 0) {
                            break;
                        } else {
                            zzzj2.zzo(i6, unsafe.getInt(t2, j));
                            break;
                        }
                    case 12:
                        if ((i5 & i) == 0) {
                            break;
                        } else {
                            zzzj2.zzg(i6, unsafe.getInt(t2, j));
                            break;
                        }
                    case 13:
                        if ((i5 & i) == 0) {
                            break;
                        } else {
                            zzzj2.zzb(i6, unsafe.getInt(t2, j));
                            break;
                        }
                    case 14:
                        if ((i5 & i) == 0) {
                            break;
                        } else {
                            zzzj2.zzd(i6, unsafe.getLong(t2, j));
                            break;
                        }
                    case 15:
                        if ((i5 & i) == 0) {
                            break;
                        } else {
                            zzzj2.zzp(i6, unsafe.getInt(t2, j));
                            break;
                        }
                    case 16:
                        if ((i5 & i) == 0) {
                            break;
                        } else {
                            zzzj2.zzq(i6, unsafe.getLong(t2, j));
                            break;
                        }
                    case 17:
                        if ((i5 & i) == 0) {
                            break;
                        } else {
                            zzzj2.zzs(i6, unsafe.getObject(t2, j), zzw(i4));
                            break;
                        }
                    case 18:
                        zzabr.zzJ(this.zzc[i4], (List) unsafe.getObject(t2, j), zzzj2, false);
                        break;
                    case 19:
                        zzabr.zzK(this.zzc[i4], (List) unsafe.getObject(t2, j), zzzj2, false);
                        break;
                    case 20:
                        zzabr.zzL(this.zzc[i4], (List) unsafe.getObject(t2, j), zzzj2, false);
                        break;
                    case 21:
                        zzabr.zzM(this.zzc[i4], (List) unsafe.getObject(t2, j), zzzj2, false);
                        break;
                    case 22:
                        zzabr.zzQ(this.zzc[i4], (List) unsafe.getObject(t2, j), zzzj2, false);
                        break;
                    case 23:
                        zzabr.zzO(this.zzc[i4], (List) unsafe.getObject(t2, j), zzzj2, false);
                        break;
                    case 24:
                        zzabr.zzT(this.zzc[i4], (List) unsafe.getObject(t2, j), zzzj2, false);
                        break;
                    case 25:
                        zzabr.zzW(this.zzc[i4], (List) unsafe.getObject(t2, j), zzzj2, false);
                        break;
                    case 26:
                        zzabr.zzX(this.zzc[i4], (List) unsafe.getObject(t2, j), zzzj2);
                        break;
                    case 27:
                        zzabr.zzZ(this.zzc[i4], (List) unsafe.getObject(t2, j), zzzj2, zzw(i4));
                        break;
                    case 28:
                        zzabr.zzY(this.zzc[i4], (List) unsafe.getObject(t2, j), zzzj2);
                        break;
                    case 29:
                        zzabr.zzR(this.zzc[i4], (List) unsafe.getObject(t2, j), zzzj2, false);
                        break;
                    case 30:
                        zzabr.zzV(this.zzc[i4], (List) unsafe.getObject(t2, j), zzzj2, false);
                        break;
                    case 31:
                        zzabr.zzU(this.zzc[i4], (List) unsafe.getObject(t2, j), zzzj2, false);
                        break;
                    case 32:
                        zzabr.zzP(this.zzc[i4], (List) unsafe.getObject(t2, j), zzzj2, false);
                        break;
                    case 33:
                        zzabr.zzS(this.zzc[i4], (List) unsafe.getObject(t2, j), zzzj2, false);
                        break;
                    case 34:
                        zzabr.zzN(this.zzc[i4], (List) unsafe.getObject(t2, j), zzzj2, false);
                        break;
                    case 35:
                        zzabr.zzJ(this.zzc[i4], (List) unsafe.getObject(t2, j), zzzj2, true);
                        break;
                    case 36:
                        zzabr.zzK(this.zzc[i4], (List) unsafe.getObject(t2, j), zzzj2, true);
                        break;
                    case 37:
                        zzabr.zzL(this.zzc[i4], (List) unsafe.getObject(t2, j), zzzj2, true);
                        break;
                    case 38:
                        zzabr.zzM(this.zzc[i4], (List) unsafe.getObject(t2, j), zzzj2, true);
                        break;
                    case 39:
                        zzabr.zzQ(this.zzc[i4], (List) unsafe.getObject(t2, j), zzzj2, true);
                        break;
                    case 40:
                        zzabr.zzO(this.zzc[i4], (List) unsafe.getObject(t2, j), zzzj2, true);
                        break;
                    case 41:
                        zzabr.zzT(this.zzc[i4], (List) unsafe.getObject(t2, j), zzzj2, true);
                        break;
                    case 42:
                        zzabr.zzW(this.zzc[i4], (List) unsafe.getObject(t2, j), zzzj2, true);
                        break;
                    case 43:
                        zzabr.zzR(this.zzc[i4], (List) unsafe.getObject(t2, j), zzzj2, true);
                        break;
                    case 44:
                        zzabr.zzV(this.zzc[i4], (List) unsafe.getObject(t2, j), zzzj2, true);
                        break;
                    case 45:
                        zzabr.zzU(this.zzc[i4], (List) unsafe.getObject(t2, j), zzzj2, true);
                        break;
                    case 46:
                        zzabr.zzP(this.zzc[i4], (List) unsafe.getObject(t2, j), zzzj2, true);
                        break;
                    case 47:
                        zzabr.zzS(this.zzc[i4], (List) unsafe.getObject(t2, j), zzzj2, true);
                        break;
                    case 48:
                        zzabr.zzN(this.zzc[i4], (List) unsafe.getObject(t2, j), zzzj2, true);
                        break;
                    case 49:
                        zzabr.zzaa(this.zzc[i4], (List) unsafe.getObject(t2, j), zzzj2, zzw(i4));
                        break;
                    case 50:
                        zzW(zzzj2, i6, unsafe.getObject(t2, j), i4);
                        break;
                    case 51:
                        if (!zzQ(t2, i6, i4)) {
                            break;
                        } else {
                            zzzj2.zzf(i6, zzH(t2, j));
                            break;
                        }
                    case 52:
                        if (!zzQ(t2, i6, i4)) {
                            break;
                        } else {
                            zzzj2.zze(i6, zzI(t2, j));
                            break;
                        }
                    case 53:
                        if (!zzQ(t2, i6, i4)) {
                            break;
                        } else {
                            zzzj2.zzc(i6, zzK(t2, j));
                            break;
                        }
                    case 54:
                        if (!zzQ(t2, i6, i4)) {
                            break;
                        } else {
                            zzzj2.zzh(i6, zzK(t2, j));
                            break;
                        }
                    case 55:
                        if (!zzQ(t2, i6, i4)) {
                            break;
                        } else {
                            zzzj2.zzi(i6, zzJ(t2, j));
                            break;
                        }
                    case 56:
                        if (!zzQ(t2, i6, i4)) {
                            break;
                        } else {
                            zzzj2.zzj(i6, zzK(t2, j));
                            break;
                        }
                    case 57:
                        if (!zzQ(t2, i6, i4)) {
                            break;
                        } else {
                            zzzj2.zzk(i6, zzJ(t2, j));
                            break;
                        }
                    case 58:
                        if (!zzQ(t2, i6, i4)) {
                            break;
                        } else {
                            zzzj2.zzl(i6, zzL(t2, j));
                            break;
                        }
                    case 59:
                        if (!zzQ(t2, i6, i4)) {
                            break;
                        } else {
                            zzX(i6, unsafe.getObject(t2, j), zzzj2);
                            break;
                        }
                    case 60:
                        if (!zzQ(t2, i6, i4)) {
                            break;
                        } else {
                            zzzj2.zzr(i6, unsafe.getObject(t2, j), zzw(i4));
                            break;
                        }
                    case 61:
                        if (!zzQ(t2, i6, i4)) {
                            break;
                        } else {
                            zzzj2.zzn(i6, (zzyy) unsafe.getObject(t2, j));
                            break;
                        }
                    case 62:
                        if (!zzQ(t2, i6, i4)) {
                            break;
                        } else {
                            zzzj2.zzo(i6, zzJ(t2, j));
                            break;
                        }
                    case 63:
                        if (!zzQ(t2, i6, i4)) {
                            break;
                        } else {
                            zzzj2.zzg(i6, zzJ(t2, j));
                            break;
                        }
                    case 64:
                        if (!zzQ(t2, i6, i4)) {
                            break;
                        } else {
                            zzzj2.zzb(i6, zzJ(t2, j));
                            break;
                        }
                    case 65:
                        if (!zzQ(t2, i6, i4)) {
                            break;
                        } else {
                            zzzj2.zzd(i6, zzK(t2, j));
                            break;
                        }
                    case 66:
                        if (!zzQ(t2, i6, i4)) {
                            break;
                        } else {
                            zzzj2.zzp(i6, zzJ(t2, j));
                            break;
                        }
                    case 67:
                        if (!zzQ(t2, i6, i4)) {
                            break;
                        } else {
                            zzzj2.zzq(i6, zzK(t2, j));
                            break;
                        }
                    case 68:
                        if (!zzQ(t2, i6, i4)) {
                            break;
                        } else {
                            zzzj2.zzs(i6, unsafe.getObject(t2, j), zzw(i4));
                            break;
                        }
                }
                i4 += 3;
                i2 = 1048575;
            }
            zzacd<?, ?> zzacd = this.zzo;
            zzacd.zzr(zzacd.zzj(t2), zzzj2);
            return;
        }
        this.zzp.zzb(t2);
        throw null;
    }

    private static final void zzX(int i, Object obj, zzzj zzzj) throws IOException {
        if (obj instanceof String) {
            zzzj.zzm(i, (String) obj);
        } else {
            zzzj.zzn(i, (zzyy) obj);
        }
    }

    static zzace zzg(Object obj) {
        zzaaa zzaaa = (zzaaa) obj;
        zzace zzace = zzaaa.zzc;
        if (zzace != zzace.zza()) {
            return zzace;
        }
        zzace zzb2 = zzace.zzb();
        zzaaa.zzc = zzb2;
        return zzb2;
    }

    static <T> zzabg<T> zzl(Class<T> cls, zzaba zzaba, zzabi zzabi, zzaar zzaar, zzacd<?, ?> zzacd, zzzo<?> zzzo, zzaay zzaay) {
        if (zzaba instanceof zzabn) {
            return zzm((zzabn) zzaba, zzabi, zzaar, zzacd, zzzo, zzaay);
        }
        zzaca zzaca = (zzaca) zzaba;
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:158:0x034b  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0394  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x03a4  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x03ad  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> com.google.android.gms.internal.p001firebaseauthapi.zzabg<T> zzm(com.google.android.gms.internal.p001firebaseauthapi.zzabn r34, com.google.android.gms.internal.p001firebaseauthapi.zzabi r35, com.google.android.gms.internal.p001firebaseauthapi.zzaar r36, com.google.android.gms.internal.p001firebaseauthapi.zzacd<?, ?> r37, com.google.android.gms.internal.p001firebaseauthapi.zzzo<?> r38, com.google.android.gms.internal.p001firebaseauthapi.zzaay r39) {
        /*
            int r0 = r34.zzc()
            r1 = 0
            r3 = 2
            if (r0 != r3) goto L_0x000a
            r10 = 1
            goto L_0x000b
        L_0x000a:
            r10 = r1
        L_0x000b:
            java.lang.String r0 = r34.zzd()
            int r3 = r0.length()
            char r4 = r0.charAt(r1)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r5) goto L_0x0027
            r4 = 1
        L_0x001d:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0028
            r4 = r6
            goto L_0x001d
        L_0x0027:
            r6 = 1
        L_0x0028:
            int r4 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0048
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0034:
            int r9 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0044
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r8
            r6 = r6 | r4
            int r8 = r8 + 13
            r4 = r9
            goto L_0x0034
        L_0x0044:
            int r4 = r4 << r8
            r6 = r6 | r4
            r4 = r9
            goto L_0x0049
        L_0x0048:
        L_0x0049:
            if (r6 != 0) goto L_0x0059
            int[] r6 = zza
            r8 = r1
            r9 = r8
            r11 = r9
            r12 = r11
            r14 = r12
            r16 = r14
            r13 = r6
            r6 = r16
            goto L_0x0178
        L_0x0059:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0079
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0065:
            int r9 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0075
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r6 = r6 << r8
            r4 = r4 | r6
            int r8 = r8 + 13
            r6 = r9
            goto L_0x0065
        L_0x0075:
            int r6 = r6 << r8
            r4 = r4 | r6
            r6 = r9
            goto L_0x007a
        L_0x0079:
        L_0x007a:
            int r8 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x009a
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0086:
            int r11 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x0096
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r9
            r6 = r6 | r8
            int r9 = r9 + 13
            r8 = r11
            goto L_0x0086
        L_0x0096:
            int r8 = r8 << r9
            r6 = r6 | r8
            r8 = r11
            goto L_0x009b
        L_0x009a:
        L_0x009b:
            int r9 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x00bb
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x00a7:
            int r12 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00b7
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r11
            r8 = r8 | r9
            int r11 = r11 + 13
            r9 = r12
            goto L_0x00a7
        L_0x00b7:
            int r9 = r9 << r11
            r8 = r8 | r9
            r9 = r12
            goto L_0x00bc
        L_0x00bb:
        L_0x00bc:
            int r11 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00dc
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00c8:
            int r13 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00d8
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r9 = r9 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00c8
        L_0x00d8:
            int r11 = r11 << r12
            r9 = r9 | r11
            r11 = r13
            goto L_0x00dd
        L_0x00dc:
        L_0x00dd:
            int r12 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00fd
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00e9:
            int r14 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x00f9
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00e9
        L_0x00f9:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
            goto L_0x00fe
        L_0x00fd:
        L_0x00fe:
            int r13 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x011e
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x010a:
            int r15 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x011a
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x010a
        L_0x011a:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
            goto L_0x011f
        L_0x011e:
        L_0x011f:
            int r14 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x0141
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x012b:
            int r16 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x013c
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x012b
        L_0x013c:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
            goto L_0x0142
        L_0x0141:
        L_0x0142:
            int r15 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x0166
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x014e:
            int r17 = r15 + 1
            char r15 = r0.charAt(r15)
            if (r15 < r5) goto L_0x0160
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x014e
        L_0x0160:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
            goto L_0x0167
        L_0x0166:
        L_0x0167:
            int r16 = r14 + r12
            int r13 = r16 + r13
            int[] r13 = new int[r13]
            int r16 = r4 + r4
            int r16 = r16 + r6
            r6 = r4
            r4 = r15
            r33 = r12
            r12 = r9
            r9 = r33
        L_0x0178:
            sun.misc.Unsafe r15 = zzb
            java.lang.Object[] r17 = r34.zze()
            com.google.android.gms.internal.firebase-auth-api.zzabd r18 = r34.zzb()
            java.lang.Class r1 = r18.getClass()
            int r7 = r11 * 3
            int[] r7 = new int[r7]
            int r11 = r11 + r11
            java.lang.Object[] r11 = new java.lang.Object[r11]
            int r21 = r14 + r9
            r22 = r14
            r23 = r21
            r9 = 0
            r20 = 0
        L_0x0196:
            if (r4 >= r3) goto L_0x03e9
            int r24 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x01be
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r2 = r24
            r24 = 13
        L_0x01a6:
            int r26 = r2 + 1
            char r2 = r0.charAt(r2)
            if (r2 < r5) goto L_0x01b8
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r24
            r4 = r4 | r2
            int r24 = r24 + 13
            r2 = r26
            goto L_0x01a6
        L_0x01b8:
            int r2 = r2 << r24
            r4 = r4 | r2
            r2 = r26
            goto L_0x01c0
        L_0x01be:
            r2 = r24
        L_0x01c0:
            int r24 = r2 + 1
            char r2 = r0.charAt(r2)
            if (r2 < r5) goto L_0x01ed
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            r5 = r24
            r24 = 13
        L_0x01ce:
            int r27 = r5 + 1
            char r5 = r0.charAt(r5)
            r28 = r3
            r3 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r3) goto L_0x01e7
            r3 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r24
            r2 = r2 | r3
            int r24 = r24 + 13
            r5 = r27
            r3 = r28
            goto L_0x01ce
        L_0x01e7:
            int r3 = r5 << r24
            r2 = r2 | r3
            r3 = r27
            goto L_0x01f1
        L_0x01ed:
            r28 = r3
            r3 = r24
        L_0x01f1:
            r5 = r2 & 255(0xff, float:3.57E-43)
            r24 = r14
            r14 = r2 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x01ff
            int r14 = r20 + 1
            r13[r20] = r9
            r20 = r14
        L_0x01ff:
            r14 = 51
            if (r5 < r14) goto L_0x02aa
            int r14 = r3 + 1
            char r3 = r0.charAt(r3)
            r27 = r14
            r14 = 55296(0xd800, float:7.7486E-41)
            if (r3 < r14) goto L_0x0235
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r14 = r27
            r27 = 13
        L_0x0216:
            int r31 = r14 + 1
            char r14 = r0.charAt(r14)
            r32 = r12
            r12 = 55296(0xd800, float:7.7486E-41)
            if (r14 < r12) goto L_0x022f
            r12 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r27
            r3 = r3 | r12
            int r27 = r27 + 13
            r14 = r31
            r12 = r32
            goto L_0x0216
        L_0x022f:
            int r12 = r14 << r27
            r3 = r3 | r12
            r14 = r31
            goto L_0x0239
        L_0x0235:
            r32 = r12
            r14 = r27
        L_0x0239:
            int r12 = r5 + -51
            r27 = r14
            r14 = 9
            if (r12 == r14) goto L_0x025c
            r14 = 17
            if (r12 != r14) goto L_0x0246
            goto L_0x025c
        L_0x0246:
            r14 = 12
            if (r12 != r14) goto L_0x026b
            if (r10 != 0) goto L_0x026b
            int r12 = r9 / 3
            int r14 = r16 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r16 = r17[r16]
            r11[r12] = r16
            r16 = r14
            goto L_0x026b
        L_0x025c:
            int r12 = r9 / 3
            int r14 = r16 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r16 = r17[r16]
            r11[r12] = r16
            r16 = r14
        L_0x026b:
            int r3 = r3 + r3
            r12 = r17[r3]
            boolean r14 = r12 instanceof java.lang.reflect.Field
            if (r14 == 0) goto L_0x0275
            java.lang.reflect.Field r12 = (java.lang.reflect.Field) r12
            goto L_0x027d
        L_0x0275:
            java.lang.String r12 = (java.lang.String) r12
            java.lang.reflect.Field r12 = zzo(r1, r12)
            r17[r3] = r12
        L_0x027d:
            r31 = r7
            r14 = r8
            long r7 = r15.objectFieldOffset(r12)
            int r7 = (int) r7
            int r3 = r3 + 1
            r8 = r17[r3]
            boolean r12 = r8 instanceof java.lang.reflect.Field
            if (r12 == 0) goto L_0x0290
            java.lang.reflect.Field r8 = (java.lang.reflect.Field) r8
            goto L_0x0298
        L_0x0290:
            java.lang.String r8 = (java.lang.String) r8
            java.lang.reflect.Field r8 = zzo(r1, r8)
            r17[r3] = r8
        L_0x0298:
            r3 = r7
            long r7 = r15.objectFieldOffset(r8)
            int r7 = (int) r7
            r30 = r0
            r8 = r1
            r0 = r7
            r29 = r11
            r25 = 1
            r7 = r3
            r3 = 0
            goto L_0x03b0
        L_0x02aa:
            r31 = r7
            r14 = r8
            r32 = r12
            int r7 = r16 + 1
            r8 = r17[r16]
            java.lang.String r8 = (java.lang.String) r8
            java.lang.reflect.Field r8 = zzo(r1, r8)
            r12 = 9
            if (r5 == r12) goto L_0x0329
            r12 = 17
            if (r5 != r12) goto L_0x02c5
            r25 = 1
            goto L_0x032b
        L_0x02c5:
            r12 = 27
            if (r5 == r12) goto L_0x0319
            r12 = 49
            if (r5 != r12) goto L_0x02ce
            goto L_0x0319
        L_0x02ce:
            r12 = 12
            if (r5 == r12) goto L_0x0304
            r12 = 30
            if (r5 == r12) goto L_0x0304
            r12 = 44
            if (r5 != r12) goto L_0x02db
            goto L_0x0304
        L_0x02db:
            r12 = 50
            if (r5 != r12) goto L_0x0303
            int r12 = r22 + 1
            r13[r22] = r9
            int r22 = r9 / 3
            int r22 = r22 + r22
            int r27 = r7 + 1
            r7 = r17[r7]
            r11[r22] = r7
            r7 = r2 & 2048(0x800, float:2.87E-42)
            if (r7 == 0) goto L_0x02fc
            int r7 = r27 + 1
            int r22 = r22 + 1
            r27 = r17[r27]
            r11[r22] = r27
            r22 = r12
            goto L_0x0300
        L_0x02fc:
            r22 = r12
            r7 = r27
        L_0x0300:
            r25 = 1
            goto L_0x0336
        L_0x0303:
            goto L_0x0300
        L_0x0304:
            if (r10 != 0) goto L_0x0318
            int r12 = r9 / 3
            int r27 = r7 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r7 = r17[r7]
            r11[r12] = r7
            r7 = r27
        L_0x0315:
            r25 = 1
            goto L_0x0336
        L_0x0318:
            goto L_0x0315
        L_0x0319:
            int r12 = r9 / 3
            int r27 = r7 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r7 = r17[r7]
            r11[r12] = r7
            r7 = r27
            goto L_0x0336
        L_0x0329:
            r25 = 1
        L_0x032b:
            int r12 = r9 / 3
            int r12 = r12 + r12
            int r12 = r12 + 1
            java.lang.Class r27 = r8.getType()
            r11[r12] = r27
        L_0x0336:
            r12 = r7
            long r7 = r15.objectFieldOffset(r8)
            int r7 = (int) r7
            r8 = r2 & 4096(0x1000, float:5.74E-42)
            r27 = 1048575(0xfffff, float:1.469367E-39)
            r29 = r11
            r11 = 4096(0x1000, float:5.74E-42)
            if (r8 != r11) goto L_0x0394
            r8 = 17
            if (r5 > r8) goto L_0x0394
            int r8 = r3 + 1
            char r3 = r0.charAt(r3)
            r11 = 55296(0xd800, float:7.7486E-41)
            if (r3 < r11) goto L_0x0370
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r26 = 13
        L_0x035a:
            int r27 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r11) goto L_0x036c
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r26
            r3 = r3 | r8
            int r26 = r26 + 13
            r8 = r27
            goto L_0x035a
        L_0x036c:
            int r8 = r8 << r26
            r3 = r3 | r8
            goto L_0x0372
        L_0x0370:
            r27 = r8
        L_0x0372:
            int r8 = r6 + r6
            int r26 = r3 / 32
            int r8 = r8 + r26
            r11 = r17[r8]
            r30 = r0
            boolean r0 = r11 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x0383
            java.lang.reflect.Field r11 = (java.lang.reflect.Field) r11
            goto L_0x038b
        L_0x0383:
            java.lang.String r11 = (java.lang.String) r11
            java.lang.reflect.Field r11 = zzo(r1, r11)
            r17[r8] = r11
        L_0x038b:
            r8 = r1
            long r0 = r15.objectFieldOffset(r11)
            int r0 = (int) r0
            int r3 = r3 % 32
            goto L_0x039c
        L_0x0394:
            r30 = r0
            r8 = r1
            r0 = r27
            r27 = r3
            r3 = 0
        L_0x039c:
            r1 = 18
            if (r5 < r1) goto L_0x03ad
            r1 = 49
            if (r5 > r1) goto L_0x03ad
            int r1 = r23 + 1
            r13[r23] = r7
            r23 = r1
            r16 = r12
            goto L_0x03b0
        L_0x03ad:
            r16 = r12
        L_0x03b0:
            int r1 = r9 + 1
            r31[r9] = r4
            int r4 = r1 + 1
            r9 = r2 & 512(0x200, float:7.175E-43)
            if (r9 == 0) goto L_0x03bd
            r9 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x03be
        L_0x03bd:
            r9 = 0
        L_0x03be:
            r2 = r2 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x03c5
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03c6
        L_0x03c5:
            r2 = 0
        L_0x03c6:
            r2 = r2 | r9
            int r5 = r5 << 20
            r2 = r2 | r5
            r2 = r2 | r7
            r31[r1] = r2
            int r9 = r4 + 1
            int r1 = r3 << 20
            r0 = r0 | r1
            r31[r4] = r0
            r1 = r8
            r8 = r14
            r14 = r24
            r4 = r27
            r3 = r28
            r11 = r29
            r0 = r30
            r7 = r31
            r12 = r32
            r5 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0196
        L_0x03e9:
            r31 = r7
            r29 = r11
            r32 = r12
            r24 = r14
            r14 = r8
            com.google.android.gms.internal.firebase-auth-api.zzabg r0 = new com.google.android.gms.internal.firebase-auth-api.zzabg
            r4 = r0
            com.google.android.gms.internal.firebase-auth-api.zzabd r9 = r34.zzb()
            r11 = 0
            r1 = r29
            r20 = 0
            r5 = r31
            r6 = r1
            r7 = r14
            r8 = r32
            r12 = r13
            r13 = r24
            r14 = r21
            r15 = r35
            r16 = r36
            r17 = r37
            r18 = r38
            r19 = r39
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzabg.zzm(com.google.android.gms.internal.firebase-auth-api.zzabn, com.google.android.gms.internal.firebase-auth-api.zzabi, com.google.android.gms.internal.firebase-auth-api.zzaar, com.google.android.gms.internal.firebase-auth-api.zzacd, com.google.android.gms.internal.firebase-auth-api.zzzo, com.google.android.gms.internal.firebase-auth-api.zzaay):com.google.android.gms.internal.firebase-auth-api.zzabg");
    }

    private static Field zzo(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    private final void zzp(T t, T t2, int i) {
        long zzD = (long) (zzD(i) & 1048575);
        if (zzO(t2, i)) {
            Object zzn2 = zzacn.zzn(t, zzD);
            Object zzn3 = zzacn.zzn(t2, zzD);
            if (zzn2 != null && zzn3 != null) {
                zzacn.zzo(t, zzD, zzaag.zzi(zzn2, zzn3));
                zzP(t, i);
            } else if (zzn3 != null) {
                zzacn.zzo(t, zzD, zzn3);
                zzP(t, i);
            }
        }
    }

    private final void zzq(T t, T t2, int i) {
        Object obj;
        int zzD = zzD(i);
        int i2 = this.zzc[i];
        long j = (long) (zzD & 1048575);
        if (zzQ(t2, i2, i)) {
            if (zzQ(t, i2, i)) {
                obj = zzacn.zzn(t, j);
            } else {
                obj = null;
            }
            Object zzn2 = zzacn.zzn(t2, j);
            if (obj != null && zzn2 != null) {
                zzacn.zzo(t, j, zzaag.zzi(obj, zzn2));
                zzR(t, i2, i);
            } else if (zzn2 != null) {
                zzacn.zzo(t, j, zzn2);
                zzR(t, i2, i);
            }
        }
    }

    private final int zzr(T t) {
        int i;
        Unsafe unsafe = zzb;
        int i2 = 1048575;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < this.zzc.length; i5 += 3) {
            int zzD = zzD(i5);
            int i6 = this.zzc[i5];
            int zzF = zzF(zzD);
            if (zzF <= 17) {
                int i7 = this.zzc[i5 + 2];
                int i8 = i7 & 1048575;
                i = 1 << (i7 >>> 20);
                if (i8 != i2) {
                    i4 = unsafe.getInt(t, (long) i8);
                    i2 = i8;
                }
            } else {
                i = 0;
            }
            long j = (long) (zzD & 1048575);
            switch (zzF) {
                case 0:
                    if ((i4 & i) == 0) {
                        break;
                    } else {
                        i3 += zzzi.zzA(i6 << 3) + 8;
                        break;
                    }
                case 1:
                    if ((i4 & i) == 0) {
                        break;
                    } else {
                        i3 += zzzi.zzA(i6 << 3) + 4;
                        break;
                    }
                case 2:
                    if ((i4 & i) == 0) {
                        break;
                    } else {
                        i3 += zzzi.zzA(i6 << 3) + zzzi.zzB(unsafe.getLong(t, j));
                        break;
                    }
                case 3:
                    if ((i4 & i) == 0) {
                        break;
                    } else {
                        i3 += zzzi.zzA(i6 << 3) + zzzi.zzB(unsafe.getLong(t, j));
                        break;
                    }
                case 4:
                    if ((i4 & i) == 0) {
                        break;
                    } else {
                        i3 += zzzi.zzA(i6 << 3) + zzzi.zzz(unsafe.getInt(t, j));
                        break;
                    }
                case 5:
                    if ((i4 & i) == 0) {
                        break;
                    } else {
                        i3 += zzzi.zzA(i6 << 3) + 8;
                        break;
                    }
                case 6:
                    if ((i4 & i) == 0) {
                        break;
                    } else {
                        i3 += zzzi.zzA(i6 << 3) + 4;
                        break;
                    }
                case 7:
                    if ((i4 & i) == 0) {
                        break;
                    } else {
                        i3 += zzzi.zzA(i6 << 3) + 1;
                        break;
                    }
                case 8:
                    if ((i4 & i) == 0) {
                        break;
                    } else {
                        Object object = unsafe.getObject(t, j);
                        if (!(object instanceof zzyy)) {
                            i3 += zzzi.zzA(i6 << 3) + zzzi.zzC((String) object);
                            break;
                        } else {
                            int zzA = zzzi.zzA(i6 << 3);
                            int zzc2 = ((zzyy) object).zzc();
                            i3 += zzA + zzzi.zzA(zzc2) + zzc2;
                            break;
                        }
                    }
                case 9:
                    if ((i4 & i) == 0) {
                        break;
                    } else {
                        i3 += zzabr.zzw(i6, unsafe.getObject(t, j), zzw(i5));
                        break;
                    }
                case 10:
                    if ((i4 & i) == 0) {
                        break;
                    } else {
                        int zzA2 = zzzi.zzA(i6 << 3);
                        int zzc3 = ((zzyy) unsafe.getObject(t, j)).zzc();
                        i3 += zzA2 + zzzi.zzA(zzc3) + zzc3;
                        break;
                    }
                case 11:
                    if ((i4 & i) == 0) {
                        break;
                    } else {
                        i3 += zzzi.zzA(i6 << 3) + zzzi.zzA(unsafe.getInt(t, j));
                        break;
                    }
                case 12:
                    if ((i4 & i) == 0) {
                        break;
                    } else {
                        i3 += zzzi.zzA(i6 << 3) + zzzi.zzz(unsafe.getInt(t, j));
                        break;
                    }
                case 13:
                    if ((i4 & i) == 0) {
                        break;
                    } else {
                        i3 += zzzi.zzA(i6 << 3) + 4;
                        break;
                    }
                case 14:
                    if ((i4 & i) == 0) {
                        break;
                    } else {
                        i3 += zzzi.zzA(i6 << 3) + 8;
                        break;
                    }
                case 15:
                    if ((i4 & i) == 0) {
                        break;
                    } else {
                        int i9 = unsafe.getInt(t, j);
                        i3 += zzzi.zzA(i6 << 3) + zzzi.zzA((i9 >> 31) ^ (i9 + i9));
                        break;
                    }
                case 16:
                    if ((i4 & i) == 0) {
                        break;
                    } else {
                        long j2 = unsafe.getLong(t, j);
                        i3 += zzzi.zzA(i6 << 3) + zzzi.zzB((j2 >> 63) ^ (j2 + j2));
                        break;
                    }
                case 17:
                    if ((i4 & i) == 0) {
                        break;
                    } else {
                        i3 += zzzi.zzI(i6, (zzabd) unsafe.getObject(t, j), zzw(i5));
                        break;
                    }
                case 18:
                    i3 += zzabr.zzs(i6, (List) unsafe.getObject(t, j), false);
                    break;
                case 19:
                    i3 += zzabr.zzq(i6, (List) unsafe.getObject(t, j), false);
                    break;
                case 20:
                    i3 += zzabr.zzc(i6, (List) unsafe.getObject(t, j), false);
                    break;
                case 21:
                    i3 += zzabr.zze(i6, (List) unsafe.getObject(t, j), false);
                    break;
                case 22:
                    i3 += zzabr.zzk(i6, (List) unsafe.getObject(t, j), false);
                    break;
                case 23:
                    i3 += zzabr.zzs(i6, (List) unsafe.getObject(t, j), false);
                    break;
                case 24:
                    i3 += zzabr.zzq(i6, (List) unsafe.getObject(t, j), false);
                    break;
                case 25:
                    i3 += zzabr.zzu(i6, (List) unsafe.getObject(t, j), false);
                    break;
                case 26:
                    i3 += zzabr.zzv(i6, (List) unsafe.getObject(t, j));
                    break;
                case 27:
                    i3 += zzabr.zzx(i6, (List) unsafe.getObject(t, j), zzw(i5));
                    break;
                case 28:
                    i3 += zzabr.zzy(i6, (List) unsafe.getObject(t, j));
                    break;
                case 29:
                    i3 += zzabr.zzm(i6, (List) unsafe.getObject(t, j), false);
                    break;
                case 30:
                    i3 += zzabr.zzi(i6, (List) unsafe.getObject(t, j), false);
                    break;
                case 31:
                    i3 += zzabr.zzq(i6, (List) unsafe.getObject(t, j), false);
                    break;
                case 32:
                    i3 += zzabr.zzs(i6, (List) unsafe.getObject(t, j), false);
                    break;
                case 33:
                    i3 += zzabr.zzo(i6, (List) unsafe.getObject(t, j), false);
                    break;
                case 34:
                    i3 += zzabr.zzg(i6, (List) unsafe.getObject(t, j), false);
                    break;
                case 35:
                    int zzr2 = zzabr.zzr((List) unsafe.getObject(t, j));
                    if (zzr2 <= 0) {
                        break;
                    } else {
                        i3 += zzzi.zzy(i6) + zzzi.zzA(zzr2) + zzr2;
                        break;
                    }
                case 36:
                    int zzp2 = zzabr.zzp((List) unsafe.getObject(t, j));
                    if (zzp2 <= 0) {
                        break;
                    } else {
                        i3 += zzzi.zzy(i6) + zzzi.zzA(zzp2) + zzp2;
                        break;
                    }
                case 37:
                    int zzb2 = zzabr.zzb((List) unsafe.getObject(t, j));
                    if (zzb2 <= 0) {
                        break;
                    } else {
                        i3 += zzzi.zzy(i6) + zzzi.zzA(zzb2) + zzb2;
                        break;
                    }
                case 38:
                    int zzd2 = zzabr.zzd((List) unsafe.getObject(t, j));
                    if (zzd2 <= 0) {
                        break;
                    } else {
                        i3 += zzzi.zzy(i6) + zzzi.zzA(zzd2) + zzd2;
                        break;
                    }
                case 39:
                    int zzj2 = zzabr.zzj((List) unsafe.getObject(t, j));
                    if (zzj2 <= 0) {
                        break;
                    } else {
                        i3 += zzzi.zzy(i6) + zzzi.zzA(zzj2) + zzj2;
                        break;
                    }
                case 40:
                    int zzr3 = zzabr.zzr((List) unsafe.getObject(t, j));
                    if (zzr3 <= 0) {
                        break;
                    } else {
                        i3 += zzzi.zzy(i6) + zzzi.zzA(zzr3) + zzr3;
                        break;
                    }
                case 41:
                    int zzp3 = zzabr.zzp((List) unsafe.getObject(t, j));
                    if (zzp3 <= 0) {
                        break;
                    } else {
                        i3 += zzzi.zzy(i6) + zzzi.zzA(zzp3) + zzp3;
                        break;
                    }
                case 42:
                    int zzt = zzabr.zzt((List) unsafe.getObject(t, j));
                    if (zzt <= 0) {
                        break;
                    } else {
                        i3 += zzzi.zzy(i6) + zzzi.zzA(zzt) + zzt;
                        break;
                    }
                case 43:
                    int zzl2 = zzabr.zzl((List) unsafe.getObject(t, j));
                    if (zzl2 <= 0) {
                        break;
                    } else {
                        i3 += zzzi.zzy(i6) + zzzi.zzA(zzl2) + zzl2;
                        break;
                    }
                case 44:
                    int zzh2 = zzabr.zzh((List) unsafe.getObject(t, j));
                    if (zzh2 <= 0) {
                        break;
                    } else {
                        i3 += zzzi.zzy(i6) + zzzi.zzA(zzh2) + zzh2;
                        break;
                    }
                case 45:
                    int zzp4 = zzabr.zzp((List) unsafe.getObject(t, j));
                    if (zzp4 <= 0) {
                        break;
                    } else {
                        i3 += zzzi.zzy(i6) + zzzi.zzA(zzp4) + zzp4;
                        break;
                    }
                case 46:
                    int zzr4 = zzabr.zzr((List) unsafe.getObject(t, j));
                    if (zzr4 <= 0) {
                        break;
                    } else {
                        i3 += zzzi.zzy(i6) + zzzi.zzA(zzr4) + zzr4;
                        break;
                    }
                case 47:
                    int zzn2 = zzabr.zzn((List) unsafe.getObject(t, j));
                    if (zzn2 <= 0) {
                        break;
                    } else {
                        i3 += zzzi.zzy(i6) + zzzi.zzA(zzn2) + zzn2;
                        break;
                    }
                case 48:
                    int zzf2 = zzabr.zzf((List) unsafe.getObject(t, j));
                    if (zzf2 <= 0) {
                        break;
                    } else {
                        i3 += zzzi.zzy(i6) + zzzi.zzA(zzf2) + zzf2;
                        break;
                    }
                case 49:
                    i3 += zzabr.zzz(i6, (List) unsafe.getObject(t, j), zzw(i5));
                    break;
                case 50:
                    zzaay.zza(i6, unsafe.getObject(t, j), zzx(i5));
                    break;
                case 51:
                    if (!zzQ(t, i6, i5)) {
                        break;
                    } else {
                        i3 += zzzi.zzA(i6 << 3) + 8;
                        break;
                    }
                case 52:
                    if (!zzQ(t, i6, i5)) {
                        break;
                    } else {
                        i3 += zzzi.zzA(i6 << 3) + 4;
                        break;
                    }
                case 53:
                    if (!zzQ(t, i6, i5)) {
                        break;
                    } else {
                        i3 += zzzi.zzA(i6 << 3) + zzzi.zzB(zzK(t, j));
                        break;
                    }
                case 54:
                    if (!zzQ(t, i6, i5)) {
                        break;
                    } else {
                        i3 += zzzi.zzA(i6 << 3) + zzzi.zzB(zzK(t, j));
                        break;
                    }
                case 55:
                    if (!zzQ(t, i6, i5)) {
                        break;
                    } else {
                        i3 += zzzi.zzA(i6 << 3) + zzzi.zzz(zzJ(t, j));
                        break;
                    }
                case 56:
                    if (!zzQ(t, i6, i5)) {
                        break;
                    } else {
                        i3 += zzzi.zzA(i6 << 3) + 8;
                        break;
                    }
                case 57:
                    if (!zzQ(t, i6, i5)) {
                        break;
                    } else {
                        i3 += zzzi.zzA(i6 << 3) + 4;
                        break;
                    }
                case 58:
                    if (!zzQ(t, i6, i5)) {
                        break;
                    } else {
                        i3 += zzzi.zzA(i6 << 3) + 1;
                        break;
                    }
                case 59:
                    if (!zzQ(t, i6, i5)) {
                        break;
                    } else {
                        Object object2 = unsafe.getObject(t, j);
                        if (!(object2 instanceof zzyy)) {
                            i3 += zzzi.zzA(i6 << 3) + zzzi.zzC((String) object2);
                            break;
                        } else {
                            int zzA3 = zzzi.zzA(i6 << 3);
                            int zzc4 = ((zzyy) object2).zzc();
                            i3 += zzA3 + zzzi.zzA(zzc4) + zzc4;
                            break;
                        }
                    }
                case 60:
                    if (!zzQ(t, i6, i5)) {
                        break;
                    } else {
                        i3 += zzabr.zzw(i6, unsafe.getObject(t, j), zzw(i5));
                        break;
                    }
                case 61:
                    if (!zzQ(t, i6, i5)) {
                        break;
                    } else {
                        int zzA4 = zzzi.zzA(i6 << 3);
                        int zzc5 = ((zzyy) unsafe.getObject(t, j)).zzc();
                        i3 += zzA4 + zzzi.zzA(zzc5) + zzc5;
                        break;
                    }
                case 62:
                    if (!zzQ(t, i6, i5)) {
                        break;
                    } else {
                        i3 += zzzi.zzA(i6 << 3) + zzzi.zzA(zzJ(t, j));
                        break;
                    }
                case 63:
                    if (!zzQ(t, i6, i5)) {
                        break;
                    } else {
                        i3 += zzzi.zzA(i6 << 3) + zzzi.zzz(zzJ(t, j));
                        break;
                    }
                case 64:
                    if (!zzQ(t, i6, i5)) {
                        break;
                    } else {
                        i3 += zzzi.zzA(i6 << 3) + 4;
                        break;
                    }
                case 65:
                    if (!zzQ(t, i6, i5)) {
                        break;
                    } else {
                        i3 += zzzi.zzA(i6 << 3) + 8;
                        break;
                    }
                case 66:
                    if (!zzQ(t, i6, i5)) {
                        break;
                    } else {
                        int zzJ = zzJ(t, j);
                        i3 += zzzi.zzA(i6 << 3) + zzzi.zzA((zzJ >> 31) ^ (zzJ + zzJ));
                        break;
                    }
                case 67:
                    if (!zzQ(t, i6, i5)) {
                        break;
                    } else {
                        long zzK = zzK(t, j);
                        i3 += zzzi.zzA(i6 << 3) + zzzi.zzB((zzK >> 63) ^ (zzK + zzK));
                        break;
                    }
                case 68:
                    if (!zzQ(t, i6, i5)) {
                        break;
                    } else {
                        i3 += zzzi.zzI(i6, (zzabd) unsafe.getObject(t, j), zzw(i5));
                        break;
                    }
            }
        }
        zzacd<?, ?> zzacd = this.zzo;
        int zzq2 = i3 + zzacd.zzq(zzacd.zzj(t));
        if (!this.zzh) {
            return zzq2;
        }
        this.zzp.zzb(t);
        throw null;
    }

    private final int zzs(T t) {
        Unsafe unsafe = zzb;
        int i = 0;
        for (int i2 = 0; i2 < this.zzc.length; i2 += 3) {
            int zzD = zzD(i2);
            int zzF = zzF(zzD);
            int i3 = this.zzc[i2];
            long j = (long) (zzD & 1048575);
            if (zzF >= zzzt.DOUBLE_LIST_PACKED.zza() && zzF <= zzzt.SINT64_LIST_PACKED.zza()) {
                int i4 = this.zzc[i2 + 2];
            }
            switch (zzF) {
                case 0:
                    if (!zzO(t, i2)) {
                        break;
                    } else {
                        i += zzzi.zzA(i3 << 3) + 8;
                        break;
                    }
                case 1:
                    if (!zzO(t, i2)) {
                        break;
                    } else {
                        i += zzzi.zzA(i3 << 3) + 4;
                        break;
                    }
                case 2:
                    if (!zzO(t, i2)) {
                        break;
                    } else {
                        i += zzzi.zzA(i3 << 3) + zzzi.zzB(zzacn.zzf(t, j));
                        break;
                    }
                case 3:
                    if (!zzO(t, i2)) {
                        break;
                    } else {
                        i += zzzi.zzA(i3 << 3) + zzzi.zzB(zzacn.zzf(t, j));
                        break;
                    }
                case 4:
                    if (!zzO(t, i2)) {
                        break;
                    } else {
                        i += zzzi.zzA(i3 << 3) + zzzi.zzz(zzacn.zzd(t, j));
                        break;
                    }
                case 5:
                    if (!zzO(t, i2)) {
                        break;
                    } else {
                        i += zzzi.zzA(i3 << 3) + 8;
                        break;
                    }
                case 6:
                    if (!zzO(t, i2)) {
                        break;
                    } else {
                        i += zzzi.zzA(i3 << 3) + 4;
                        break;
                    }
                case 7:
                    if (!zzO(t, i2)) {
                        break;
                    } else {
                        i += zzzi.zzA(i3 << 3) + 1;
                        break;
                    }
                case 8:
                    if (!zzO(t, i2)) {
                        break;
                    } else {
                        Object zzn2 = zzacn.zzn(t, j);
                        if (!(zzn2 instanceof zzyy)) {
                            i += zzzi.zzA(i3 << 3) + zzzi.zzC((String) zzn2);
                            break;
                        } else {
                            int zzA = zzzi.zzA(i3 << 3);
                            int zzc2 = ((zzyy) zzn2).zzc();
                            i += zzA + zzzi.zzA(zzc2) + zzc2;
                            break;
                        }
                    }
                case 9:
                    if (!zzO(t, i2)) {
                        break;
                    } else {
                        i += zzabr.zzw(i3, zzacn.zzn(t, j), zzw(i2));
                        break;
                    }
                case 10:
                    if (!zzO(t, i2)) {
                        break;
                    } else {
                        int zzA2 = zzzi.zzA(i3 << 3);
                        int zzc3 = ((zzyy) zzacn.zzn(t, j)).zzc();
                        i += zzA2 + zzzi.zzA(zzc3) + zzc3;
                        break;
                    }
                case 11:
                    if (!zzO(t, i2)) {
                        break;
                    } else {
                        i += zzzi.zzA(i3 << 3) + zzzi.zzA(zzacn.zzd(t, j));
                        break;
                    }
                case 12:
                    if (!zzO(t, i2)) {
                        break;
                    } else {
                        i += zzzi.zzA(i3 << 3) + zzzi.zzz(zzacn.zzd(t, j));
                        break;
                    }
                case 13:
                    if (!zzO(t, i2)) {
                        break;
                    } else {
                        i += zzzi.zzA(i3 << 3) + 4;
                        break;
                    }
                case 14:
                    if (!zzO(t, i2)) {
                        break;
                    } else {
                        i += zzzi.zzA(i3 << 3) + 8;
                        break;
                    }
                case 15:
                    if (!zzO(t, i2)) {
                        break;
                    } else {
                        int zzd2 = zzacn.zzd(t, j);
                        i += zzzi.zzA(i3 << 3) + zzzi.zzA((zzd2 >> 31) ^ (zzd2 + zzd2));
                        break;
                    }
                case 16:
                    if (!zzO(t, i2)) {
                        break;
                    } else {
                        long zzf2 = zzacn.zzf(t, j);
                        i += zzzi.zzA(i3 << 3) + zzzi.zzB((zzf2 >> 63) ^ (zzf2 + zzf2));
                        break;
                    }
                case 17:
                    if (!zzO(t, i2)) {
                        break;
                    } else {
                        i += zzzi.zzI(i3, (zzabd) zzacn.zzn(t, j), zzw(i2));
                        break;
                    }
                case 18:
                    i += zzabr.zzs(i3, (List) zzacn.zzn(t, j), false);
                    break;
                case 19:
                    i += zzabr.zzq(i3, (List) zzacn.zzn(t, j), false);
                    break;
                case 20:
                    i += zzabr.zzc(i3, (List) zzacn.zzn(t, j), false);
                    break;
                case 21:
                    i += zzabr.zze(i3, (List) zzacn.zzn(t, j), false);
                    break;
                case 22:
                    i += zzabr.zzk(i3, (List) zzacn.zzn(t, j), false);
                    break;
                case 23:
                    i += zzabr.zzs(i3, (List) zzacn.zzn(t, j), false);
                    break;
                case 24:
                    i += zzabr.zzq(i3, (List) zzacn.zzn(t, j), false);
                    break;
                case 25:
                    i += zzabr.zzu(i3, (List) zzacn.zzn(t, j), false);
                    break;
                case 26:
                    i += zzabr.zzv(i3, (List) zzacn.zzn(t, j));
                    break;
                case 27:
                    i += zzabr.zzx(i3, (List) zzacn.zzn(t, j), zzw(i2));
                    break;
                case 28:
                    i += zzabr.zzy(i3, (List) zzacn.zzn(t, j));
                    break;
                case 29:
                    i += zzabr.zzm(i3, (List) zzacn.zzn(t, j), false);
                    break;
                case 30:
                    i += zzabr.zzi(i3, (List) zzacn.zzn(t, j), false);
                    break;
                case 31:
                    i += zzabr.zzq(i3, (List) zzacn.zzn(t, j), false);
                    break;
                case 32:
                    i += zzabr.zzs(i3, (List) zzacn.zzn(t, j), false);
                    break;
                case 33:
                    i += zzabr.zzo(i3, (List) zzacn.zzn(t, j), false);
                    break;
                case 34:
                    i += zzabr.zzg(i3, (List) zzacn.zzn(t, j), false);
                    break;
                case 35:
                    int zzr2 = zzabr.zzr((List) unsafe.getObject(t, j));
                    if (zzr2 <= 0) {
                        break;
                    } else {
                        i += zzzi.zzy(i3) + zzzi.zzA(zzr2) + zzr2;
                        break;
                    }
                case 36:
                    int zzp2 = zzabr.zzp((List) unsafe.getObject(t, j));
                    if (zzp2 <= 0) {
                        break;
                    } else {
                        i += zzzi.zzy(i3) + zzzi.zzA(zzp2) + zzp2;
                        break;
                    }
                case 37:
                    int zzb2 = zzabr.zzb((List) unsafe.getObject(t, j));
                    if (zzb2 <= 0) {
                        break;
                    } else {
                        i += zzzi.zzy(i3) + zzzi.zzA(zzb2) + zzb2;
                        break;
                    }
                case 38:
                    int zzd3 = zzabr.zzd((List) unsafe.getObject(t, j));
                    if (zzd3 <= 0) {
                        break;
                    } else {
                        i += zzzi.zzy(i3) + zzzi.zzA(zzd3) + zzd3;
                        break;
                    }
                case 39:
                    int zzj2 = zzabr.zzj((List) unsafe.getObject(t, j));
                    if (zzj2 <= 0) {
                        break;
                    } else {
                        i += zzzi.zzy(i3) + zzzi.zzA(zzj2) + zzj2;
                        break;
                    }
                case 40:
                    int zzr3 = zzabr.zzr((List) unsafe.getObject(t, j));
                    if (zzr3 <= 0) {
                        break;
                    } else {
                        i += zzzi.zzy(i3) + zzzi.zzA(zzr3) + zzr3;
                        break;
                    }
                case 41:
                    int zzp3 = zzabr.zzp((List) unsafe.getObject(t, j));
                    if (zzp3 <= 0) {
                        break;
                    } else {
                        i += zzzi.zzy(i3) + zzzi.zzA(zzp3) + zzp3;
                        break;
                    }
                case 42:
                    int zzt = zzabr.zzt((List) unsafe.getObject(t, j));
                    if (zzt <= 0) {
                        break;
                    } else {
                        i += zzzi.zzy(i3) + zzzi.zzA(zzt) + zzt;
                        break;
                    }
                case 43:
                    int zzl2 = zzabr.zzl((List) unsafe.getObject(t, j));
                    if (zzl2 <= 0) {
                        break;
                    } else {
                        i += zzzi.zzy(i3) + zzzi.zzA(zzl2) + zzl2;
                        break;
                    }
                case 44:
                    int zzh2 = zzabr.zzh((List) unsafe.getObject(t, j));
                    if (zzh2 <= 0) {
                        break;
                    } else {
                        i += zzzi.zzy(i3) + zzzi.zzA(zzh2) + zzh2;
                        break;
                    }
                case 45:
                    int zzp4 = zzabr.zzp((List) unsafe.getObject(t, j));
                    if (zzp4 <= 0) {
                        break;
                    } else {
                        i += zzzi.zzy(i3) + zzzi.zzA(zzp4) + zzp4;
                        break;
                    }
                case 46:
                    int zzr4 = zzabr.zzr((List) unsafe.getObject(t, j));
                    if (zzr4 <= 0) {
                        break;
                    } else {
                        i += zzzi.zzy(i3) + zzzi.zzA(zzr4) + zzr4;
                        break;
                    }
                case 47:
                    int zzn3 = zzabr.zzn((List) unsafe.getObject(t, j));
                    if (zzn3 <= 0) {
                        break;
                    } else {
                        i += zzzi.zzy(i3) + zzzi.zzA(zzn3) + zzn3;
                        break;
                    }
                case 48:
                    int zzf3 = zzabr.zzf((List) unsafe.getObject(t, j));
                    if (zzf3 <= 0) {
                        break;
                    } else {
                        i += zzzi.zzy(i3) + zzzi.zzA(zzf3) + zzf3;
                        break;
                    }
                case 49:
                    i += zzabr.zzz(i3, (List) zzacn.zzn(t, j), zzw(i2));
                    break;
                case 50:
                    zzaay.zza(i3, zzacn.zzn(t, j), zzx(i2));
                    break;
                case 51:
                    if (!zzQ(t, i3, i2)) {
                        break;
                    } else {
                        i += zzzi.zzA(i3 << 3) + 8;
                        break;
                    }
                case 52:
                    if (!zzQ(t, i3, i2)) {
                        break;
                    } else {
                        i += zzzi.zzA(i3 << 3) + 4;
                        break;
                    }
                case 53:
                    if (!zzQ(t, i3, i2)) {
                        break;
                    } else {
                        i += zzzi.zzA(i3 << 3) + zzzi.zzB(zzK(t, j));
                        break;
                    }
                case 54:
                    if (!zzQ(t, i3, i2)) {
                        break;
                    } else {
                        i += zzzi.zzA(i3 << 3) + zzzi.zzB(zzK(t, j));
                        break;
                    }
                case 55:
                    if (!zzQ(t, i3, i2)) {
                        break;
                    } else {
                        i += zzzi.zzA(i3 << 3) + zzzi.zzz(zzJ(t, j));
                        break;
                    }
                case 56:
                    if (!zzQ(t, i3, i2)) {
                        break;
                    } else {
                        i += zzzi.zzA(i3 << 3) + 8;
                        break;
                    }
                case 57:
                    if (!zzQ(t, i3, i2)) {
                        break;
                    } else {
                        i += zzzi.zzA(i3 << 3) + 4;
                        break;
                    }
                case 58:
                    if (!zzQ(t, i3, i2)) {
                        break;
                    } else {
                        i += zzzi.zzA(i3 << 3) + 1;
                        break;
                    }
                case 59:
                    if (!zzQ(t, i3, i2)) {
                        break;
                    } else {
                        Object zzn4 = zzacn.zzn(t, j);
                        if (!(zzn4 instanceof zzyy)) {
                            i += zzzi.zzA(i3 << 3) + zzzi.zzC((String) zzn4);
                            break;
                        } else {
                            int zzA3 = zzzi.zzA(i3 << 3);
                            int zzc4 = ((zzyy) zzn4).zzc();
                            i += zzA3 + zzzi.zzA(zzc4) + zzc4;
                            break;
                        }
                    }
                case 60:
                    if (!zzQ(t, i3, i2)) {
                        break;
                    } else {
                        i += zzabr.zzw(i3, zzacn.zzn(t, j), zzw(i2));
                        break;
                    }
                case 61:
                    if (!zzQ(t, i3, i2)) {
                        break;
                    } else {
                        int zzA4 = zzzi.zzA(i3 << 3);
                        int zzc5 = ((zzyy) zzacn.zzn(t, j)).zzc();
                        i += zzA4 + zzzi.zzA(zzc5) + zzc5;
                        break;
                    }
                case 62:
                    if (!zzQ(t, i3, i2)) {
                        break;
                    } else {
                        i += zzzi.zzA(i3 << 3) + zzzi.zzA(zzJ(t, j));
                        break;
                    }
                case 63:
                    if (!zzQ(t, i3, i2)) {
                        break;
                    } else {
                        i += zzzi.zzA(i3 << 3) + zzzi.zzz(zzJ(t, j));
                        break;
                    }
                case 64:
                    if (!zzQ(t, i3, i2)) {
                        break;
                    } else {
                        i += zzzi.zzA(i3 << 3) + 4;
                        break;
                    }
                case 65:
                    if (!zzQ(t, i3, i2)) {
                        break;
                    } else {
                        i += zzzi.zzA(i3 << 3) + 8;
                        break;
                    }
                case 66:
                    if (!zzQ(t, i3, i2)) {
                        break;
                    } else {
                        int zzJ = zzJ(t, j);
                        i += zzzi.zzA(i3 << 3) + zzzi.zzA((zzJ >> 31) ^ (zzJ + zzJ));
                        break;
                    }
                case 67:
                    if (!zzQ(t, i3, i2)) {
                        break;
                    } else {
                        long zzK = zzK(t, j);
                        i += zzzi.zzA(i3 << 3) + zzzi.zzB((zzK >> 63) ^ (zzK + zzK));
                        break;
                    }
                case 68:
                    if (!zzQ(t, i3, i2)) {
                        break;
                    } else {
                        i += zzzi.zzI(i3, (zzabd) zzacn.zzn(t, j), zzw(i2));
                        break;
                    }
            }
        }
        zzacd<?, ?> zzacd = this.zzo;
        return i + zzacd.zzq(zzacd.zzj(t));
    }

    private final int zzt(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, zzym zzym) throws IOException {
        boolean z;
        boolean z2;
        boolean z3;
        int i8;
        int i9;
        int i10;
        int i11;
        T t2 = t;
        byte[] bArr2 = bArr;
        int i12 = i;
        int i13 = i2;
        int i14 = i3;
        int i15 = i5;
        int i16 = i6;
        long j3 = j2;
        zzym zzym2 = zzym;
        Unsafe unsafe = zzb;
        zzaaf zzaaf = (zzaaf) unsafe.getObject(t2, j3);
        if (!zzaaf.zza()) {
            int size = zzaaf.size();
            zzaaf = zzaaf.zze(size == 0 ? 10 : size + size);
            unsafe.putObject(t2, j3, zzaaf);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i15 == 2) {
                    zzzk zzzk = (zzzk) zzaaf;
                    int zza2 = zzyn.zza(bArr2, i12, zzym2);
                    int i17 = zzym2.zza + zza2;
                    while (zza2 < i17) {
                        zzzk.zzd(Double.longBitsToDouble(zzyn.zze(bArr2, zza2)));
                        zza2 += 8;
                    }
                    if (zza2 == i17) {
                        return zza2;
                    }
                    throw zzaai.zzb();
                } else if (i15 == 1) {
                    zzzk zzzk2 = (zzzk) zzaaf;
                    zzzk2.zzd(Double.longBitsToDouble(zzyn.zze(bArr, i)));
                    int i18 = i12 + 8;
                    while (i18 < i13) {
                        int zza3 = zzyn.zza(bArr2, i18, zzym2);
                        if (i14 != zzym2.zza) {
                            return i18;
                        }
                        zzzk2.zzd(Double.longBitsToDouble(zzyn.zze(bArr2, zza3)));
                        i18 = zza3 + 8;
                    }
                    return i18;
                }
                break;
            case 19:
            case 36:
                if (i15 == 2) {
                    zzzu zzzu = (zzzu) zzaaf;
                    int zza4 = zzyn.zza(bArr2, i12, zzym2);
                    int i19 = zzym2.zza + zza4;
                    while (zza4 < i19) {
                        zzzu.zzd(Float.intBitsToFloat(zzyn.zzd(bArr2, zza4)));
                        zza4 += 4;
                    }
                    if (zza4 == i19) {
                        return zza4;
                    }
                    throw zzaai.zzb();
                } else if (i15 == 5) {
                    zzzu zzzu2 = (zzzu) zzaaf;
                    zzzu2.zzd(Float.intBitsToFloat(zzyn.zzd(bArr, i)));
                    int i20 = i12 + 4;
                    while (i20 < i13) {
                        int zza5 = zzyn.zza(bArr2, i20, zzym2);
                        if (i14 != zzym2.zza) {
                            return i20;
                        }
                        zzzu2.zzd(Float.intBitsToFloat(zzyn.zzd(bArr2, zza5)));
                        i20 = zza5 + 4;
                    }
                    return i20;
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i15 == 2) {
                    zzaas zzaas = (zzaas) zzaaf;
                    int zza6 = zzyn.zza(bArr2, i12, zzym2);
                    int i21 = zzym2.zza + zza6;
                    while (zza6 < i21) {
                        zza6 = zzyn.zzc(bArr2, zza6, zzym2);
                        zzaas.zzf(zzym2.zzb);
                    }
                    if (zza6 == i21) {
                        return zza6;
                    }
                    throw zzaai.zzb();
                } else if (i15 == 0) {
                    zzaas zzaas2 = (zzaas) zzaaf;
                    int zzc2 = zzyn.zzc(bArr2, i12, zzym2);
                    zzaas2.zzf(zzym2.zzb);
                    while (zzc2 < i13) {
                        int zza7 = zzyn.zza(bArr2, zzc2, zzym2);
                        if (i14 != zzym2.zza) {
                            return zzc2;
                        }
                        zzc2 = zzyn.zzc(bArr2, zza7, zzym2);
                        zzaas2.zzf(zzym2.zzb);
                    }
                    return zzc2;
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i15 == 2) {
                    return zzyn.zzl(bArr2, i12, zzaaf, zzym2);
                }
                if (i15 == 0) {
                    return zzyn.zzk(i3, bArr, i, i2, zzaaf, zzym);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i15 == 2) {
                    zzaas zzaas3 = (zzaas) zzaaf;
                    int zza8 = zzyn.zza(bArr2, i12, zzym2);
                    int i22 = zzym2.zza + zza8;
                    while (zza8 < i22) {
                        zzaas3.zzf(zzyn.zze(bArr2, zza8));
                        zza8 += 8;
                    }
                    if (zza8 == i22) {
                        return zza8;
                    }
                    throw zzaai.zzb();
                } else if (i15 == 1) {
                    zzaas zzaas4 = (zzaas) zzaaf;
                    zzaas4.zzf(zzyn.zze(bArr, i));
                    int i23 = i12 + 8;
                    while (i23 < i13) {
                        int zza9 = zzyn.zza(bArr2, i23, zzym2);
                        if (i14 != zzym2.zza) {
                            return i23;
                        }
                        zzaas4.zzf(zzyn.zze(bArr2, zza9));
                        i23 = zza9 + 8;
                    }
                    return i23;
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i15 == 2) {
                    zzaab zzaab = (zzaab) zzaaf;
                    int zza10 = zzyn.zza(bArr2, i12, zzym2);
                    int i24 = zzym2.zza + zza10;
                    while (zza10 < i24) {
                        zzaab.zzf(zzyn.zzd(bArr2, zza10));
                        zza10 += 4;
                    }
                    if (zza10 == i24) {
                        return zza10;
                    }
                    throw zzaai.zzb();
                } else if (i15 == 5) {
                    zzaab zzaab2 = (zzaab) zzaaf;
                    zzaab2.zzf(zzyn.zzd(bArr, i));
                    int i25 = i12 + 4;
                    while (i25 < i13) {
                        int zza11 = zzyn.zza(bArr2, i25, zzym2);
                        if (i14 != zzym2.zza) {
                            return i25;
                        }
                        zzaab2.zzf(zzyn.zzd(bArr2, zza11));
                        i25 = zza11 + 4;
                    }
                    return i25;
                }
                break;
            case 25:
            case 42:
                if (i15 == 2) {
                    zzyo zzyo = (zzyo) zzaaf;
                    int zza12 = zzyn.zza(bArr2, i12, zzym2);
                    int i26 = zzym2.zza + zza12;
                    while (zza12 < i26) {
                        zza12 = zzyn.zzc(bArr2, zza12, zzym2);
                        if (zzym2.zzb != 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        zzyo.zzd(z3);
                    }
                    if (zza12 == i26) {
                        return zza12;
                    }
                    throw zzaai.zzb();
                } else if (i15 == 0) {
                    zzyo zzyo2 = (zzyo) zzaaf;
                    int zzc3 = zzyn.zzc(bArr2, i12, zzym2);
                    if (zzym2.zzb != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zzyo2.zzd(z);
                    while (zzc3 < i13) {
                        int zza13 = zzyn.zza(bArr2, zzc3, zzym2);
                        if (i14 != zzym2.zza) {
                            return zzc3;
                        }
                        zzc3 = zzyn.zzc(bArr2, zza13, zzym2);
                        if (zzym2.zzb != 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        zzyo2.zzd(z2);
                    }
                    return zzc3;
                }
                break;
            case 26:
                if (i15 == 2) {
                    if ((j & 536870912) == 0) {
                        int zza14 = zzyn.zza(bArr2, i12, zzym2);
                        int i27 = zzym2.zza;
                        if (i27 >= 0) {
                            if (i27 == 0) {
                                zzaaf.add("");
                            } else {
                                zzaaf.add(new String(bArr2, zza14, i27, zzaag.zza));
                                zza14 += i27;
                            }
                            while (i9 < i13) {
                                int zza15 = zzyn.zza(bArr2, i9, zzym2);
                                if (i14 != zzym2.zza) {
                                    return i9;
                                }
                                i9 = zzyn.zza(bArr2, zza15, zzym2);
                                int i28 = zzym2.zza;
                                if (i28 < 0) {
                                    throw zzaai.zzc();
                                } else if (i28 == 0) {
                                    zzaaf.add("");
                                } else {
                                    zzaaf.add(new String(bArr2, i9, i28, zzaag.zza));
                                    i9 += i28;
                                }
                            }
                            return i9;
                        }
                        throw zzaai.zzc();
                    }
                    int zza16 = zzyn.zza(bArr2, i12, zzym2);
                    int i29 = zzym2.zza;
                    if (i29 >= 0) {
                        if (i29 == 0) {
                            zzaaf.add("");
                        } else {
                            int i30 = zza16 + i29;
                            if (zzacs.zzb(bArr2, zza16, i30)) {
                                zzaaf.add(new String(bArr2, zza16, i29, zzaag.zza));
                                zza16 = i30;
                            } else {
                                throw zzaai.zzi();
                            }
                        }
                        while (i8 < i13) {
                            int zza17 = zzyn.zza(bArr2, i8, zzym2);
                            if (i14 != zzym2.zza) {
                                return i8;
                            }
                            i8 = zzyn.zza(bArr2, zza17, zzym2);
                            int i31 = zzym2.zza;
                            if (i31 < 0) {
                                throw zzaai.zzc();
                            } else if (i31 == 0) {
                                zzaaf.add("");
                            } else {
                                int i32 = i8 + i31;
                                if (zzacs.zzb(bArr2, i8, i32)) {
                                    zzaaf.add(new String(bArr2, i8, i31, zzaag.zza));
                                    i8 = i32;
                                } else {
                                    throw zzaai.zzi();
                                }
                            }
                        }
                        return i8;
                    }
                    throw zzaai.zzc();
                }
                break;
            case 27:
                if (i15 == 2) {
                    return zzyn.zzm(zzw(i16), i3, bArr, i, i2, zzaaf, zzym);
                }
                break;
            case 28:
                if (i15 == 2) {
                    int zza18 = zzyn.zza(bArr2, i12, zzym2);
                    int i33 = zzym2.zza;
                    if (i33 < 0) {
                        throw zzaai.zzc();
                    } else if (i33 <= bArr2.length - zza18) {
                        if (i33 == 0) {
                            zzaaf.add(zzyy.zzb);
                        } else {
                            zzaaf.add(zzyy.zzl(bArr2, zza18, i33));
                            zza18 += i33;
                        }
                        while (i10 < i13) {
                            int zza19 = zzyn.zza(bArr2, i10, zzym2);
                            if (i14 != zzym2.zza) {
                                return i10;
                            }
                            i10 = zzyn.zza(bArr2, zza19, zzym2);
                            int i34 = zzym2.zza;
                            if (i34 < 0) {
                                throw zzaai.zzc();
                            } else if (i34 > bArr2.length - i10) {
                                throw zzaai.zzb();
                            } else if (i34 == 0) {
                                zzaaf.add(zzyy.zzb);
                            } else {
                                zzaaf.add(zzyy.zzl(bArr2, i10, i34));
                                i10 += i34;
                            }
                        }
                        return i10;
                    } else {
                        throw zzaai.zzb();
                    }
                }
                break;
            case 30:
            case 44:
                if (i15 == 2) {
                    i11 = zzyn.zzl(bArr2, i12, zzaaf, zzym2);
                } else if (i15 == 0) {
                    i11 = zzyn.zzk(i3, bArr, i, i2, zzaaf, zzym);
                }
                zzaaa zzaaa = (zzaaa) t2;
                zzace zzace = zzaaa.zzc;
                if (zzace == zzace.zza()) {
                    zzace = null;
                }
                Object zzG = zzabr.zzG(i4, zzaaf, zzy(i16), zzace, this.zzo);
                if (zzG == null) {
                    return i11;
                }
                zzaaa.zzc = (zzace) zzG;
                return i11;
            case 33:
            case 47:
                if (i15 == 2) {
                    zzaab zzaab3 = (zzaab) zzaaf;
                    int zza20 = zzyn.zza(bArr2, i12, zzym2);
                    int i35 = zzym2.zza + zza20;
                    while (zza20 < i35) {
                        zza20 = zzyn.zza(bArr2, zza20, zzym2);
                        zzaab3.zzf(zzzb.zzt(zzym2.zza));
                    }
                    if (zza20 == i35) {
                        return zza20;
                    }
                    throw zzaai.zzb();
                } else if (i15 == 0) {
                    zzaab zzaab4 = (zzaab) zzaaf;
                    int zza21 = zzyn.zza(bArr2, i12, zzym2);
                    zzaab4.zzf(zzzb.zzt(zzym2.zza));
                    while (zza21 < i13) {
                        int zza22 = zzyn.zza(bArr2, zza21, zzym2);
                        if (i14 != zzym2.zza) {
                            return zza21;
                        }
                        zza21 = zzyn.zza(bArr2, zza22, zzym2);
                        zzaab4.zzf(zzzb.zzt(zzym2.zza));
                    }
                    return zza21;
                }
                break;
            case 34:
            case 48:
                if (i15 == 2) {
                    zzaas zzaas5 = (zzaas) zzaaf;
                    int zza23 = zzyn.zza(bArr2, i12, zzym2);
                    int i36 = zzym2.zza + zza23;
                    while (zza23 < i36) {
                        zza23 = zzyn.zzc(bArr2, zza23, zzym2);
                        zzaas5.zzf(zzzb.zzu(zzym2.zzb));
                    }
                    if (zza23 == i36) {
                        return zza23;
                    }
                    throw zzaai.zzb();
                } else if (i15 == 0) {
                    zzaas zzaas6 = (zzaas) zzaaf;
                    int zzc4 = zzyn.zzc(bArr2, i12, zzym2);
                    zzaas6.zzf(zzzb.zzu(zzym2.zzb));
                    while (zzc4 < i13) {
                        int zza24 = zzyn.zza(bArr2, zzc4, zzym2);
                        if (i14 != zzym2.zza) {
                            return zzc4;
                        }
                        zzc4 = zzyn.zzc(bArr2, zza24, zzym2);
                        zzaas6.zzf(zzzb.zzu(zzym2.zzb));
                    }
                    return zzc4;
                }
                break;
            default:
                if (i15 == 3) {
                    zzabp zzw = zzw(i16);
                    int i37 = (i14 & -8) | 4;
                    int zzj2 = zzyn.zzj(zzw, bArr, i, i2, i37, zzym);
                    zzaaf.add(zzym2.zzc);
                    while (zzj2 < i13) {
                        int zza25 = zzyn.zza(bArr2, zzj2, zzym2);
                        if (i14 != zzym2.zza) {
                            return zzj2;
                        }
                        zzj2 = zzyn.zzj(zzw, bArr, zza25, i2, i37, zzym);
                        zzaaf.add(zzym2.zzc);
                    }
                    return zzj2;
                }
                break;
        }
        return i12;
    }

    private final <K, V> int zzu(T t, byte[] bArr, int i, int i2, int i3, long j, zzym zzym) throws IOException {
        Unsafe unsafe = zzb;
        Object zzx = zzx(i3);
        Object object = unsafe.getObject(t, j);
        if (zzaay.zzb(object)) {
            zzaax zzc2 = zzaax.zza().zzc();
            zzaay.zzc(zzc2, object);
            unsafe.putObject(t, j, zzc2);
        }
        zzaaw zzaaw = (zzaaw) zzx;
        throw null;
    }

    private final int zzv(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzym zzym) throws IOException {
        boolean z;
        Object obj;
        Object obj2;
        T t2 = t;
        byte[] bArr2 = bArr;
        int i9 = i;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        long j2 = j;
        int i13 = i8;
        zzym zzym2 = zzym;
        Unsafe unsafe = zzb;
        long j3 = (long) (this.zzc[i13 + 2] & 1048575);
        switch (i7) {
            case 51:
                if (i12 == 1) {
                    unsafe.putObject(t2, j2, Double.valueOf(Double.longBitsToDouble(zzyn.zze(bArr, i))));
                    unsafe.putInt(t2, j3, i11);
                    return i9 + 8;
                }
                break;
            case 52:
                if (i12 == 5) {
                    unsafe.putObject(t2, j2, Float.valueOf(Float.intBitsToFloat(zzyn.zzd(bArr, i))));
                    unsafe.putInt(t2, j3, i11);
                    return i9 + 4;
                }
                break;
            case 53:
            case 54:
                if (i12 == 0) {
                    int zzc2 = zzyn.zzc(bArr2, i9, zzym2);
                    unsafe.putObject(t2, j2, Long.valueOf(zzym2.zzb));
                    unsafe.putInt(t2, j3, i11);
                    return zzc2;
                }
                break;
            case 55:
            case 62:
                if (i12 == 0) {
                    int zza2 = zzyn.zza(bArr2, i9, zzym2);
                    unsafe.putObject(t2, j2, Integer.valueOf(zzym2.zza));
                    unsafe.putInt(t2, j3, i11);
                    return zza2;
                }
                break;
            case 56:
            case 65:
                if (i12 == 1) {
                    unsafe.putObject(t2, j2, Long.valueOf(zzyn.zze(bArr, i)));
                    unsafe.putInt(t2, j3, i11);
                    return i9 + 8;
                }
                break;
            case 57:
            case 64:
                if (i12 == 5) {
                    unsafe.putObject(t2, j2, Integer.valueOf(zzyn.zzd(bArr, i)));
                    unsafe.putInt(t2, j3, i11);
                    return i9 + 4;
                }
                break;
            case 58:
                if (i12 == 0) {
                    int zzc3 = zzyn.zzc(bArr2, i9, zzym2);
                    if (zzym2.zzb != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    unsafe.putObject(t2, j2, Boolean.valueOf(z));
                    unsafe.putInt(t2, j3, i11);
                    return zzc3;
                }
                break;
            case 59:
                if (i12 == 2) {
                    int zza3 = zzyn.zza(bArr2, i9, zzym2);
                    int i14 = zzym2.zza;
                    if (i14 == 0) {
                        unsafe.putObject(t2, j2, "");
                    } else if ((i6 & 536870912) == 0 || zzacs.zzb(bArr2, zza3, zza3 + i14)) {
                        unsafe.putObject(t2, j2, new String(bArr2, zza3, i14, zzaag.zza));
                        zza3 += i14;
                    } else {
                        throw zzaai.zzi();
                    }
                    unsafe.putInt(t2, j3, i11);
                    return zza3;
                }
                break;
            case 60:
                if (i12 == 2) {
                    int zzi2 = zzyn.zzi(zzw(i13), bArr2, i9, i2, zzym2);
                    if (unsafe.getInt(t2, j3) == i11) {
                        obj = unsafe.getObject(t2, j2);
                    } else {
                        obj = null;
                    }
                    if (obj == null) {
                        unsafe.putObject(t2, j2, zzym2.zzc);
                    } else {
                        unsafe.putObject(t2, j2, zzaag.zzi(obj, zzym2.zzc));
                    }
                    unsafe.putInt(t2, j3, i11);
                    return zzi2;
                }
                break;
            case 61:
                if (i12 == 2) {
                    int zzh2 = zzyn.zzh(bArr2, i9, zzym2);
                    unsafe.putObject(t2, j2, zzym2.zzc);
                    unsafe.putInt(t2, j3, i11);
                    return zzh2;
                }
                break;
            case 63:
                if (i12 == 0) {
                    int zza4 = zzyn.zza(bArr2, i9, zzym2);
                    int i15 = zzym2.zza;
                    zzaae zzy = zzy(i13);
                    if (zzy == null || zzy.zza()) {
                        unsafe.putObject(t2, j2, Integer.valueOf(i15));
                        unsafe.putInt(t2, j3, i11);
                    } else {
                        zzg(t).zzh(i10, Long.valueOf((long) i15));
                    }
                    return zza4;
                }
                break;
            case 66:
                if (i12 == 0) {
                    int zza5 = zzyn.zza(bArr2, i9, zzym2);
                    unsafe.putObject(t2, j2, Integer.valueOf(zzzb.zzt(zzym2.zza)));
                    unsafe.putInt(t2, j3, i11);
                    return zza5;
                }
                break;
            case 67:
                if (i12 == 0) {
                    int zzc4 = zzyn.zzc(bArr2, i9, zzym2);
                    unsafe.putObject(t2, j2, Long.valueOf(zzzb.zzu(zzym2.zzb)));
                    unsafe.putInt(t2, j3, i11);
                    return zzc4;
                }
                break;
            case 68:
                if (i12 == 3) {
                    int zzj2 = zzyn.zzj(zzw(i13), bArr, i, i2, (i10 & -8) | 4, zzym);
                    if (unsafe.getInt(t2, j3) == i11) {
                        obj2 = unsafe.getObject(t2, j2);
                    } else {
                        obj2 = null;
                    }
                    if (obj2 == null) {
                        unsafe.putObject(t2, j2, zzym2.zzc);
                    } else {
                        unsafe.putObject(t2, j2, zzaag.zzi(obj2, zzym2.zzc));
                    }
                    unsafe.putInt(t2, j3, i11);
                    return zzj2;
                }
                break;
        }
        return i9;
    }

    private final zzabp zzw(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzabp zzabp = (zzabp) this.zzd[i3];
        if (zzabp != null) {
            return zzabp;
        }
        zzabp zzb2 = zzabl.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzb2;
        return zzb2;
    }

    private final Object zzx(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final zzaae zzy(int i) {
        int i2 = i / 3;
        return (zzaae) this.zzd[i2 + i2 + 1];
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v4, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzz(T r31, byte[] r32, int r33, int r34, com.google.android.gms.internal.p001firebaseauthapi.zzym r35) throws java.io.IOException {
        /*
            r30 = this;
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            sun.misc.Unsafe r9 = zzb
            r10 = -1
            r16 = 0
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r33
            r7 = r8
            r1 = r10
            r2 = r16
            r6 = r2
        L_0x0019:
            if (r0 >= r13) goto L_0x0439
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002b
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzyn.zzb(r0, r12, r3, r11)
            int r3 = r11.zza
            r4 = r0
            r17 = r3
            goto L_0x002e
        L_0x002b:
            r17 = r0
            r4 = r3
        L_0x002e:
            int r5 = r17 >>> 3
            r3 = r17 & 7
            if (r5 <= r1) goto L_0x003c
            int r2 = r2 / 3
            int r0 = r15.zzT(r5, r2)
            r2 = r0
            goto L_0x0041
        L_0x003c:
            int r0 = r15.zzS(r5)
            r2 = r0
        L_0x0041:
            if (r2 != r10) goto L_0x004e
            r2 = r4
            r20 = r5
            r28 = r9
            r18 = r10
            r19 = r16
            goto L_0x0412
        L_0x004e:
            int[] r0 = r15.zzc
            int r1 = r2 + 1
            r1 = r0[r1]
            int r0 = zzF(r1)
            r10 = r1 & r8
            r19 = r9
            long r8 = (long) r10
            r10 = 17
            r33 = r5
            if (r0 > r10) goto L_0x02c1
            int[] r10 = r15.zzc
            int r21 = r2 + 2
            r10 = r10[r21]
            int r21 = r10 >>> 20
            r5 = 1
            int r21 = r5 << r21
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r10 = r10 & r13
            if (r10 == r7) goto L_0x0096
            if (r7 == r13) goto L_0x0081
            r23 = r1
            r20 = r2
            long r1 = (long) r7
            r7 = r19
            r7.putInt(r14, r1, r6)
            goto L_0x0087
        L_0x0081:
            r23 = r1
            r20 = r2
            r7 = r19
        L_0x0087:
            if (r10 == r13) goto L_0x008f
            long r1 = (long) r10
            int r6 = r7.getInt(r14, r1)
            goto L_0x0090
        L_0x008f:
        L_0x0090:
            r29 = r10
            r10 = r7
            r7 = r29
            goto L_0x009c
        L_0x0096:
            r23 = r1
            r20 = r2
            r10 = r19
        L_0x009c:
            r1 = 5
            switch(r0) {
                case 0: goto L_0x0295;
                case 1: goto L_0x0272;
                case 2: goto L_0x024d;
                case 3: goto L_0x024d;
                case 4: goto L_0x022d;
                case 5: goto L_0x0203;
                case 6: goto L_0x01df;
                case 7: goto L_0x01b2;
                case 8: goto L_0x0182;
                case 9: goto L_0x0143;
                case 10: goto L_0x0120;
                case 11: goto L_0x022d;
                case 12: goto L_0x00fe;
                case 13: goto L_0x01df;
                case 14: goto L_0x0203;
                case 15: goto L_0x00d8;
                case 16: goto L_0x00a8;
                default: goto L_0x00a0;
            }
        L_0x00a0:
            r19 = r13
            r13 = r20
            r20 = r33
            goto L_0x02b8
        L_0x00a8:
            if (r3 != 0) goto L_0x00cf
            int r17 = com.google.android.gms.internal.p001firebaseauthapi.zzyn.zzc(r12, r4, r11)
            long r0 = r11.zzb
            long r4 = com.google.android.gms.internal.p001firebaseauthapi.zzzb.zzu(r0)
            r0 = r10
            r1 = r31
            r13 = r20
            r2 = r8
            r20 = r33
            r0.putLong(r1, r2, r4)
            r6 = r6 | r21
            r9 = r10
            r2 = r13
            r0 = r17
            r1 = r20
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r10 = -1
            r13 = r34
            goto L_0x0019
        L_0x00cf:
            r13 = r20
            r20 = r33
            r19 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x02b8
        L_0x00d8:
            r13 = r20
            r20 = r33
            if (r3 != 0) goto L_0x00f9
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzyn.zza(r12, r4, r11)
            int r1 = r11.zza
            int r1 = com.google.android.gms.internal.p001firebaseauthapi.zzzb.zzt(r1)
            r10.putInt(r14, r8, r1)
            r6 = r6 | r21
            r9 = r10
            r2 = r13
            r1 = r20
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r10 = -1
            r13 = r34
            goto L_0x0019
        L_0x00f9:
            r19 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x02b8
        L_0x00fe:
            r13 = r20
            r20 = r33
            if (r3 != 0) goto L_0x011b
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzyn.zza(r12, r4, r11)
            int r1 = r11.zza
            r10.putInt(r14, r8, r1)
            r6 = r6 | r21
            r9 = r10
            r2 = r13
            r1 = r20
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r10 = -1
            r13 = r34
            goto L_0x0019
        L_0x011b:
            r19 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x02b8
        L_0x0120:
            r13 = r20
            r20 = r33
            r0 = 2
            if (r3 != r0) goto L_0x013e
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzyn.zzh(r12, r4, r11)
            java.lang.Object r1 = r11.zzc
            r10.putObject(r14, r8, r1)
            r6 = r6 | r21
            r9 = r10
            r2 = r13
            r1 = r20
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r10 = -1
            r13 = r34
            goto L_0x0019
        L_0x013e:
            r19 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x02b8
        L_0x0143:
            r13 = r20
            r0 = 2
            r20 = r33
            if (r3 != r0) goto L_0x017b
            com.google.android.gms.internal.firebase-auth-api.zzabp r0 = r15.zzw(r13)
            r2 = r34
            r19 = 1048575(0xfffff, float:1.469367E-39)
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzyn.zzi(r0, r12, r4, r2, r11)
            java.lang.Object r1 = r10.getObject(r14, r8)
            if (r1 != 0) goto L_0x0163
            java.lang.Object r1 = r11.zzc
            r10.putObject(r14, r8, r1)
            goto L_0x016c
        L_0x0163:
            java.lang.Object r3 = r11.zzc
            java.lang.Object r1 = com.google.android.gms.internal.p001firebaseauthapi.zzaag.zzi(r1, r3)
            r10.putObject(r14, r8, r1)
        L_0x016c:
            r6 = r6 | r21
            r9 = r10
            r8 = r19
            r1 = r20
            r10 = -1
            r29 = r13
            r13 = r2
            r2 = r29
            goto L_0x0019
        L_0x017b:
            r2 = r34
            r19 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x02b8
        L_0x0182:
            r2 = r34
            r19 = r13
            r13 = r20
            r20 = r33
            r0 = 2
            if (r3 != r0) goto L_0x01b0
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r23 & r0
            if (r0 != 0) goto L_0x0198
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzyn.zzf(r12, r4, r11)
            goto L_0x019c
        L_0x0198:
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzyn.zzg(r12, r4, r11)
        L_0x019c:
            java.lang.Object r1 = r11.zzc
            r10.putObject(r14, r8, r1)
            r6 = r6 | r21
            r9 = r10
            r8 = r19
            r1 = r20
            r10 = -1
            r29 = r13
            r13 = r2
            r2 = r29
            goto L_0x0019
        L_0x01b0:
            goto L_0x02b8
        L_0x01b2:
            r2 = r34
            r19 = r13
            r13 = r20
            r20 = r33
            if (r3 != 0) goto L_0x01dd
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzyn.zzc(r12, r4, r11)
            long r3 = r11.zzb
            r22 = 0
            int r1 = (r3 > r22 ? 1 : (r3 == r22 ? 0 : -1))
            if (r1 == 0) goto L_0x01c9
            goto L_0x01cb
        L_0x01c9:
            r5 = r16
        L_0x01cb:
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zzi(r14, r8, r5)
            r6 = r6 | r21
            r9 = r10
            r8 = r19
            r1 = r20
            r10 = -1
            r29 = r13
            r13 = r2
            r2 = r29
            goto L_0x0019
        L_0x01dd:
            goto L_0x02b8
        L_0x01df:
            r2 = r34
            r19 = r13
            r13 = r20
            r20 = r33
            if (r3 != r1) goto L_0x0201
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzyn.zzd(r12, r4)
            r10.putInt(r14, r8, r0)
            int r0 = r4 + 4
            r6 = r6 | r21
            r9 = r10
            r8 = r19
            r1 = r20
            r10 = -1
            r29 = r13
            r13 = r2
            r2 = r29
            goto L_0x0019
        L_0x0201:
            goto L_0x02b8
        L_0x0203:
            r2 = r34
            r19 = r13
            r13 = r20
            r20 = r33
            if (r3 != r5) goto L_0x022a
            long r22 = com.google.android.gms.internal.p001firebaseauthapi.zzyn.zze(r12, r4)
            r0 = r10
            r1 = r31
            r2 = r8
            r8 = r4
            r4 = r22
            r0.putLong(r1, r2, r4)
            int r0 = r8 + 8
            r6 = r6 | r21
            r9 = r10
            r2 = r13
            r8 = r19
            r1 = r20
            r10 = -1
            r13 = r34
            goto L_0x0019
        L_0x022a:
            r8 = r4
            goto L_0x02b8
        L_0x022d:
            r19 = r13
            r13 = r20
            r20 = r33
            if (r3 != 0) goto L_0x024b
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzyn.zza(r12, r4, r11)
            int r1 = r11.zza
            r10.putInt(r14, r8, r1)
            r6 = r6 | r21
            r9 = r10
            r2 = r13
            r8 = r19
            r1 = r20
            r10 = -1
            r13 = r34
            goto L_0x0019
        L_0x024b:
            goto L_0x02b8
        L_0x024d:
            r19 = r13
            r13 = r20
            r20 = r33
            if (r3 != 0) goto L_0x0271
            int r17 = com.google.android.gms.internal.p001firebaseauthapi.zzyn.zzc(r12, r4, r11)
            long r4 = r11.zzb
            r0 = r10
            r1 = r31
            r2 = r8
            r0.putLong(r1, r2, r4)
            r6 = r6 | r21
            r9 = r10
            r2 = r13
            r0 = r17
            r8 = r19
            r1 = r20
            r10 = -1
            r13 = r34
            goto L_0x0019
        L_0x0271:
            goto L_0x02b8
        L_0x0272:
            r19 = r13
            r13 = r20
            r20 = r33
            if (r3 != r1) goto L_0x0294
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzyn.zzd(r12, r4)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zzk(r14, r8, r0)
            int r0 = r4 + 4
            r6 = r6 | r21
            r9 = r10
            r2 = r13
            r8 = r19
            r1 = r20
            r10 = -1
            r13 = r34
            goto L_0x0019
        L_0x0294:
            goto L_0x02b8
        L_0x0295:
            r19 = r13
            r13 = r20
            r20 = r33
            if (r3 != r5) goto L_0x02b7
            long r0 = com.google.android.gms.internal.p001firebaseauthapi.zzyn.zze(r12, r4)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zzm(r14, r8, r0)
            int r0 = r4 + 8
            r6 = r6 | r21
            r9 = r10
            r2 = r13
            r8 = r19
            r1 = r20
            r10 = -1
            r13 = r34
            goto L_0x0019
        L_0x02b7:
        L_0x02b8:
            r2 = r4
            r28 = r10
            r19 = r13
            r18 = -1
            goto L_0x0412
        L_0x02c1:
            r20 = r33
            r23 = r1
            r13 = r2
            r10 = r19
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r1 = 27
            if (r0 != r1) goto L_0x031e
            r0 = 2
            if (r3 != r0) goto L_0x0310
            java.lang.Object r0 = r10.getObject(r14, r8)
            com.google.android.gms.internal.firebase-auth-api.zzaaf r0 = (com.google.android.gms.internal.p001firebaseauthapi.zzaaf) r0
            boolean r1 = r0.zza()
            if (r1 != 0) goto L_0x02f1
            int r1 = r0.size()
            if (r1 != 0) goto L_0x02e7
            r1 = 10
            goto L_0x02e8
        L_0x02e7:
            int r1 = r1 + r1
        L_0x02e8:
            com.google.android.gms.internal.firebase-auth-api.zzaaf r0 = r0.zze(r1)
            r10.putObject(r14, r8, r0)
            r5 = r0
            goto L_0x02f2
        L_0x02f1:
            r5 = r0
        L_0x02f2:
            com.google.android.gms.internal.firebase-auth-api.zzabp r0 = r15.zzw(r13)
            r1 = r17
            r2 = r32
            r3 = r4
            r4 = r34
            r8 = r6
            r6 = r35
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzyn.zzm(r0, r1, r2, r3, r4, r5, r6)
            r6 = r8
            r9 = r10
            r2 = r13
            r8 = r19
            r1 = r20
            r10 = -1
            r13 = r34
            goto L_0x0019
        L_0x0310:
            r8 = r6
            r15 = r4
            r25 = r7
            r24 = r8
            r28 = r10
            r19 = r13
            r18 = -1
            goto L_0x03d0
        L_0x031e:
            r1 = 49
            if (r0 > r1) goto L_0x037b
            r1 = r23
            long r1 = (long) r1
            r5 = r0
            r0 = r30
            r21 = r1
            r1 = r31
            r2 = r32
            r33 = r3
            r3 = r4
            r15 = r4
            r4 = r34
            r23 = r5
            r5 = r17
            r24 = r6
            r6 = r20
            r25 = r7
            r7 = r33
            r26 = r8
            r9 = r19
            r8 = r13
            r28 = r10
            r18 = -1
            r9 = r21
            r11 = r23
            r19 = r13
            r12 = r26
            r14 = r35
            int r0 = r0.zzt(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x0374
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r10 = r18
            r2 = r19
            r1 = r20
            r6 = r24
            r7 = r25
            r9 = r28
            r8 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0019
        L_0x0374:
            r2 = r0
            r6 = r24
            r7 = r25
            goto L_0x0412
        L_0x037b:
            r33 = r3
            r15 = r4
            r24 = r6
            r25 = r7
            r26 = r8
            r28 = r10
            r19 = r13
            r1 = r23
            r18 = -1
            r23 = r0
            r0 = 50
            r9 = r23
            if (r9 != r0) goto L_0x03d6
            r7 = r33
            r0 = 2
            if (r7 != r0) goto L_0x03cf
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r19
            r6 = r26
            r8 = r35
            int r0 = r0.zzu(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x03c9
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r10 = r18
            r2 = r19
            r1 = r20
            r6 = r24
            r7 = r25
            r9 = r28
            r8 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0019
        L_0x03c9:
            r2 = r0
            r6 = r24
            r7 = r25
            goto L_0x0412
        L_0x03cf:
        L_0x03d0:
            r2 = r15
            r6 = r24
            r7 = r25
            goto L_0x0412
        L_0x03d6:
            r7 = r33
            r0 = r30
            r8 = r1
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r17
            r6 = r20
            r10 = r26
            r12 = r19
            r13 = r35
            int r0 = r0.zzv(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x040d
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r10 = r18
            r2 = r19
            r1 = r20
            r6 = r24
            r7 = r25
            r9 = r28
            r8 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0019
        L_0x040d:
            r2 = r0
            r6 = r24
            r7 = r25
        L_0x0412:
            com.google.android.gms.internal.firebase-auth-api.zzace r4 = zzg(r31)
            r0 = r17
            r1 = r32
            r3 = r34
            r5 = r35
            int r0 = com.google.android.gms.internal.p001firebaseauthapi.zzyn.zzn(r0, r1, r2, r3, r4, r5)
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r10 = r18
            r2 = r19
            r1 = r20
            r9 = r28
            r8 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0019
        L_0x0439:
            r24 = r6
            r25 = r7
            r28 = r9
            r1 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 == r1) goto L_0x044e
            long r1 = (long) r7
            r3 = r31
            r6 = r24
            r4 = r28
            r4.putInt(r3, r1, r6)
        L_0x044e:
            r1 = r34
            if (r0 != r1) goto L_0x0453
            return r0
        L_0x0453:
            com.google.android.gms.internal.firebase-auth-api.zzaai r0 = com.google.android.gms.internal.p001firebaseauthapi.zzaai.zzh()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzabg.zzz(java.lang.Object, byte[], int, int, com.google.android.gms.internal.firebase-auth-api.zzym):int");
    }

    public final T zza() {
        return ((zzaaa) this.zzg).zzj(4, (Object) null, (Object) null);
    }

    public final boolean zzb(T t, T t2) {
        boolean z;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int zzD = zzD(i);
            long j = (long) (zzD & 1048575);
            switch (zzF(zzD)) {
                case 0:
                    if (zzM(t, t2, i) && Double.doubleToLongBits(zzacn.zzl(t, j)) == Double.doubleToLongBits(zzacn.zzl(t2, j))) {
                        continue;
                    }
                case 1:
                    if (zzM(t, t2, i) && Float.floatToIntBits(zzacn.zzj(t, j)) == Float.floatToIntBits(zzacn.zzj(t2, j))) {
                        continue;
                    }
                case 2:
                    if (zzM(t, t2, i) && zzacn.zzf(t, j) == zzacn.zzf(t2, j)) {
                        continue;
                    }
                case 3:
                    if (zzM(t, t2, i) && zzacn.zzf(t, j) == zzacn.zzf(t2, j)) {
                        continue;
                    }
                case 4:
                    if (zzM(t, t2, i) && zzacn.zzd(t, j) == zzacn.zzd(t2, j)) {
                        continue;
                    }
                case 5:
                    if (zzM(t, t2, i) && zzacn.zzf(t, j) == zzacn.zzf(t2, j)) {
                        continue;
                    }
                case 6:
                    if (zzM(t, t2, i) && zzacn.zzd(t, j) == zzacn.zzd(t2, j)) {
                        continue;
                    }
                case 7:
                    if (zzM(t, t2, i) && zzacn.zzh(t, j) == zzacn.zzh(t2, j)) {
                        continue;
                    }
                case 8:
                    if (zzM(t, t2, i) && zzabr.zzD(zzacn.zzn(t, j), zzacn.zzn(t2, j))) {
                        continue;
                    }
                case 9:
                    if (zzM(t, t2, i) && zzabr.zzD(zzacn.zzn(t, j), zzacn.zzn(t2, j))) {
                        continue;
                    }
                case 10:
                    if (zzM(t, t2, i) && zzabr.zzD(zzacn.zzn(t, j), zzacn.zzn(t2, j))) {
                        continue;
                    }
                case 11:
                    if (zzM(t, t2, i) && zzacn.zzd(t, j) == zzacn.zzd(t2, j)) {
                        continue;
                    }
                case 12:
                    if (zzM(t, t2, i) && zzacn.zzd(t, j) == zzacn.zzd(t2, j)) {
                        continue;
                    }
                case 13:
                    if (zzM(t, t2, i) && zzacn.zzd(t, j) == zzacn.zzd(t2, j)) {
                        continue;
                    }
                case 14:
                    if (zzM(t, t2, i) && zzacn.zzf(t, j) == zzacn.zzf(t2, j)) {
                        continue;
                    }
                case 15:
                    if (zzM(t, t2, i) && zzacn.zzd(t, j) == zzacn.zzd(t2, j)) {
                        continue;
                    }
                case 16:
                    if (zzM(t, t2, i) && zzacn.zzf(t, j) == zzacn.zzf(t2, j)) {
                        continue;
                    }
                case 17:
                    if (zzM(t, t2, i) && zzabr.zzD(zzacn.zzn(t, j), zzacn.zzn(t2, j))) {
                        continue;
                    }
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    z = zzabr.zzD(zzacn.zzn(t, j), zzacn.zzn(t2, j));
                    break;
                case 50:
                    z = zzabr.zzD(zzacn.zzn(t, j), zzacn.zzn(t2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long zzE = (long) (zzE(i) & 1048575);
                    if (zzacn.zzd(t, zzE) == zzacn.zzd(t2, zzE) && zzabr.zzD(zzacn.zzn(t, j), zzacn.zzn(t2, j))) {
                        continue;
                    }
            }
            if (!z) {
                return false;
            }
        }
        if (!this.zzo.zzj(t).equals(this.zzo.zzj(t2))) {
            return false;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzp.zzb(t);
        this.zzp.zzb(t2);
        throw null;
    }

    public final int zzc(T t) {
        int length = this.zzc.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int zzD = zzD(i2);
            int i3 = this.zzc[i2];
            long j = (long) (1048575 & zzD);
            int i4 = 37;
            switch (zzF(zzD)) {
                case 0:
                    i = (i * 53) + zzaag.zze(Double.doubleToLongBits(zzacn.zzl(t, j)));
                    break;
                case 1:
                    i = (i * 53) + Float.floatToIntBits(zzacn.zzj(t, j));
                    break;
                case 2:
                    i = (i * 53) + zzaag.zze(zzacn.zzf(t, j));
                    break;
                case 3:
                    i = (i * 53) + zzaag.zze(zzacn.zzf(t, j));
                    break;
                case 4:
                    i = (i * 53) + zzacn.zzd(t, j);
                    break;
                case 5:
                    i = (i * 53) + zzaag.zze(zzacn.zzf(t, j));
                    break;
                case 6:
                    i = (i * 53) + zzacn.zzd(t, j);
                    break;
                case 7:
                    i = (i * 53) + zzaag.zzf(zzacn.zzh(t, j));
                    break;
                case 8:
                    i = (i * 53) + ((String) zzacn.zzn(t, j)).hashCode();
                    break;
                case 9:
                    Object zzn2 = zzacn.zzn(t, j);
                    if (zzn2 != null) {
                        i4 = zzn2.hashCode();
                    }
                    i = (i * 53) + i4;
                    break;
                case 10:
                    i = (i * 53) + zzacn.zzn(t, j).hashCode();
                    break;
                case 11:
                    i = (i * 53) + zzacn.zzd(t, j);
                    break;
                case 12:
                    i = (i * 53) + zzacn.zzd(t, j);
                    break;
                case 13:
                    i = (i * 53) + zzacn.zzd(t, j);
                    break;
                case 14:
                    i = (i * 53) + zzaag.zze(zzacn.zzf(t, j));
                    break;
                case 15:
                    i = (i * 53) + zzacn.zzd(t, j);
                    break;
                case 16:
                    i = (i * 53) + zzaag.zze(zzacn.zzf(t, j));
                    break;
                case 17:
                    Object zzn3 = zzacn.zzn(t, j);
                    if (zzn3 != null) {
                        i4 = zzn3.hashCode();
                    }
                    i = (i * 53) + i4;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = (i * 53) + zzacn.zzn(t, j).hashCode();
                    break;
                case 50:
                    i = (i * 53) + zzacn.zzn(t, j).hashCode();
                    break;
                case 51:
                    if (!zzQ(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzaag.zze(Double.doubleToLongBits(zzH(t, j)));
                        break;
                    }
                case 52:
                    if (!zzQ(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + Float.floatToIntBits(zzI(t, j));
                        break;
                    }
                case 53:
                    if (!zzQ(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzaag.zze(zzK(t, j));
                        break;
                    }
                case 54:
                    if (!zzQ(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzaag.zze(zzK(t, j));
                        break;
                    }
                case 55:
                    if (!zzQ(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzJ(t, j);
                        break;
                    }
                case 56:
                    if (!zzQ(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzaag.zze(zzK(t, j));
                        break;
                    }
                case 57:
                    if (!zzQ(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzJ(t, j);
                        break;
                    }
                case 58:
                    if (!zzQ(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzaag.zzf(zzL(t, j));
                        break;
                    }
                case 59:
                    if (!zzQ(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + ((String) zzacn.zzn(t, j)).hashCode();
                        break;
                    }
                case 60:
                    if (!zzQ(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzacn.zzn(t, j).hashCode();
                        break;
                    }
                case 61:
                    if (!zzQ(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzacn.zzn(t, j).hashCode();
                        break;
                    }
                case 62:
                    if (!zzQ(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzJ(t, j);
                        break;
                    }
                case 63:
                    if (!zzQ(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzJ(t, j);
                        break;
                    }
                case 64:
                    if (!zzQ(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzJ(t, j);
                        break;
                    }
                case 65:
                    if (!zzQ(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzaag.zze(zzK(t, j));
                        break;
                    }
                case 66:
                    if (!zzQ(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzJ(t, j);
                        break;
                    }
                case 67:
                    if (!zzQ(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzaag.zze(zzK(t, j));
                        break;
                    }
                case 68:
                    if (!zzQ(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzacn.zzn(t, j).hashCode();
                        break;
                    }
            }
        }
        int hashCode = (i * 53) + this.zzo.zzj(t).hashCode();
        if (!this.zzh) {
            return hashCode;
        }
        this.zzp.zzb(t);
        throw null;
    }

    public final void zzd(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.zzc.length; i += 3) {
                int zzD = zzD(i);
                long j = (long) (1048575 & zzD);
                int i2 = this.zzc[i];
                switch (zzF(zzD)) {
                    case 0:
                        if (!zzO(t2, i)) {
                            break;
                        } else {
                            zzacn.zzm(t, j, zzacn.zzl(t2, j));
                            zzP(t, i);
                            break;
                        }
                    case 1:
                        if (!zzO(t2, i)) {
                            break;
                        } else {
                            zzacn.zzk(t, j, zzacn.zzj(t2, j));
                            zzP(t, i);
                            break;
                        }
                    case 2:
                        if (!zzO(t2, i)) {
                            break;
                        } else {
                            zzacn.zzg(t, j, zzacn.zzf(t2, j));
                            zzP(t, i);
                            break;
                        }
                    case 3:
                        if (!zzO(t2, i)) {
                            break;
                        } else {
                            zzacn.zzg(t, j, zzacn.zzf(t2, j));
                            zzP(t, i);
                            break;
                        }
                    case 4:
                        if (!zzO(t2, i)) {
                            break;
                        } else {
                            zzacn.zze(t, j, zzacn.zzd(t2, j));
                            zzP(t, i);
                            break;
                        }
                    case 5:
                        if (!zzO(t2, i)) {
                            break;
                        } else {
                            zzacn.zzg(t, j, zzacn.zzf(t2, j));
                            zzP(t, i);
                            break;
                        }
                    case 6:
                        if (!zzO(t2, i)) {
                            break;
                        } else {
                            zzacn.zze(t, j, zzacn.zzd(t2, j));
                            zzP(t, i);
                            break;
                        }
                    case 7:
                        if (!zzO(t2, i)) {
                            break;
                        } else {
                            zzacn.zzi(t, j, zzacn.zzh(t2, j));
                            zzP(t, i);
                            break;
                        }
                    case 8:
                        if (!zzO(t2, i)) {
                            break;
                        } else {
                            zzacn.zzo(t, j, zzacn.zzn(t2, j));
                            zzP(t, i);
                            break;
                        }
                    case 9:
                        zzp(t, t2, i);
                        break;
                    case 10:
                        if (!zzO(t2, i)) {
                            break;
                        } else {
                            zzacn.zzo(t, j, zzacn.zzn(t2, j));
                            zzP(t, i);
                            break;
                        }
                    case 11:
                        if (!zzO(t2, i)) {
                            break;
                        } else {
                            zzacn.zze(t, j, zzacn.zzd(t2, j));
                            zzP(t, i);
                            break;
                        }
                    case 12:
                        if (!zzO(t2, i)) {
                            break;
                        } else {
                            zzacn.zze(t, j, zzacn.zzd(t2, j));
                            zzP(t, i);
                            break;
                        }
                    case 13:
                        if (!zzO(t2, i)) {
                            break;
                        } else {
                            zzacn.zze(t, j, zzacn.zzd(t2, j));
                            zzP(t, i);
                            break;
                        }
                    case 14:
                        if (!zzO(t2, i)) {
                            break;
                        } else {
                            zzacn.zzg(t, j, zzacn.zzf(t2, j));
                            zzP(t, i);
                            break;
                        }
                    case 15:
                        if (!zzO(t2, i)) {
                            break;
                        } else {
                            zzacn.zze(t, j, zzacn.zzd(t2, j));
                            zzP(t, i);
                            break;
                        }
                    case 16:
                        if (!zzO(t2, i)) {
                            break;
                        } else {
                            zzacn.zzg(t, j, zzacn.zzf(t2, j));
                            zzP(t, i);
                            break;
                        }
                    case 17:
                        zzp(t, t2, i);
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        this.zzn.zzc(t, t2, j);
                        break;
                    case 50:
                        zzabr.zzI(this.zzr, t, t2, j);
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        if (!zzQ(t2, i2, i)) {
                            break;
                        } else {
                            zzacn.zzo(t, j, zzacn.zzn(t2, j));
                            zzR(t, i2, i);
                            break;
                        }
                    case 60:
                        zzq(t, t2, i);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!zzQ(t2, i2, i)) {
                            break;
                        } else {
                            zzacn.zzo(t, j, zzacn.zzn(t2, j));
                            zzR(t, i2, i);
                            break;
                        }
                    case 68:
                        zzq(t, t2, i);
                        break;
                }
            }
            zzabr.zzF(this.zzo, t, t2);
            if (this.zzh) {
                zzabr.zzE(this.zzp, t, t2);
                return;
            }
            return;
        }
        throw null;
    }

    public final int zze(T t) {
        return this.zzj ? zzs(t) : zzr(t);
    }

    /* JADX WARNING: Removed duplicated region for block: B:172:0x05c9 A[LOOP:5: B:170:0x05c5->B:172:0x05c9, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x05d6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzf(T r13, com.google.android.gms.internal.p001firebaseauthapi.zzabo r14, com.google.android.gms.internal.p001firebaseauthapi.zzzn r15) throws java.io.IOException {
        /*
            r12 = this;
            r0 = 0
            if (r15 == 0) goto L_0x05da
            com.google.android.gms.internal.firebase-auth-api.zzacd<?, ?> r8 = r12.zzo
            com.google.android.gms.internal.firebase-auth-api.zzzo<?> r9 = r12.zzp
            r1 = r0
            r10 = r1
        L_0x0009:
            int r2 = r14.zzb()     // Catch:{ all -> 0x05c2 }
            int r3 = r12.zzS(r2)     // Catch:{ all -> 0x05c2 }
            if (r3 >= 0) goto L_0x0079
            r3 = 2147483647(0x7fffffff, float:NaN)
            if (r2 != r3) goto L_0x002f
            int r14 = r12.zzl
        L_0x001a:
            int r15 = r12.zzm
            if (r14 >= r15) goto L_0x0029
            int[] r15 = r12.zzk
            r15 = r15[r14]
            java.lang.Object r10 = r12.zzA(r13, r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x001a
        L_0x0029:
            if (r10 == 0) goto L_0x05bf
        L_0x002b:
            r8.zzl(r13, r10)
            return
        L_0x002f:
            boolean r3 = r12.zzh     // Catch:{ all -> 0x05c2 }
            if (r3 != 0) goto L_0x0035
            r3 = r0
            goto L_0x003c
        L_0x0035:
            com.google.android.gms.internal.firebase-auth-api.zzabd r3 = r12.zzg     // Catch:{ all -> 0x05c2 }
            java.lang.Object r2 = r9.zzf(r15, r3, r2)     // Catch:{ all -> 0x05c2 }
            r3 = r2
        L_0x003c:
            if (r3 == 0) goto L_0x0053
            if (r1 != 0) goto L_0x0046
            com.google.android.gms.internal.firebase-auth-api.zzzs r1 = r9.zzc(r13)     // Catch:{ all -> 0x05c2 }
            r11 = r1
            goto L_0x0047
        L_0x0046:
            r11 = r1
        L_0x0047:
            r1 = r9
            r2 = r14
            r4 = r15
            r5 = r11
            r6 = r10
            r7 = r8
            java.lang.Object r10 = r1.zze(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x05c2 }
            r1 = r11
            goto L_0x0009
        L_0x0053:
            r8.zza(r14)     // Catch:{ all -> 0x05c2 }
            if (r10 != 0) goto L_0x005c
            java.lang.Object r10 = r8.zzk(r13)     // Catch:{ all -> 0x05c2 }
        L_0x005c:
            boolean r2 = r8.zzn(r10, r14)     // Catch:{ all -> 0x0076 }
            if (r2 != 0) goto L_0x0009
            int r14 = r12.zzl
        L_0x0064:
            int r15 = r12.zzm
            if (r14 >= r15) goto L_0x0073
            int[] r15 = r12.zzk
            r15 = r15[r14]
            java.lang.Object r10 = r12.zzA(r13, r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x0064
        L_0x0073:
            if (r10 == 0) goto L_0x05bf
            goto L_0x002b
        L_0x0076:
            r14 = move-exception
            goto L_0x05c3
        L_0x0079:
            int r4 = r12.zzD(r3)     // Catch:{ all -> 0x05c2 }
            int r5 = zzF(r4)     // Catch:{ zzaah -> 0x0599 }
            r6 = 1048575(0xfffff, float:1.469367E-39)
            switch(r5) {
                case 0: goto L_0x0569;
                case 1: goto L_0x055b;
                case 2: goto L_0x054d;
                case 3: goto L_0x053f;
                case 4: goto L_0x0531;
                case 5: goto L_0x0523;
                case 6: goto L_0x0514;
                case 7: goto L_0x0505;
                case 8: goto L_0x04fd;
                case 9: goto L_0x04cc;
                case 10: goto L_0x04bd;
                case 11: goto L_0x04ae;
                case 12: goto L_0x048c;
                case 13: goto L_0x047d;
                case 14: goto L_0x046e;
                case 15: goto L_0x045f;
                case 16: goto L_0x0450;
                case 17: goto L_0x041f;
                case 18: goto L_0x0411;
                case 19: goto L_0x0403;
                case 20: goto L_0x03f5;
                case 21: goto L_0x03e7;
                case 22: goto L_0x03d9;
                case 23: goto L_0x03cb;
                case 24: goto L_0x03bd;
                case 25: goto L_0x03af;
                case 26: goto L_0x0385;
                case 27: goto L_0x0373;
                case 28: goto L_0x0365;
                case 29: goto L_0x0357;
                case 30: goto L_0x0342;
                case 31: goto L_0x0334;
                case 32: goto L_0x0326;
                case 33: goto L_0x0318;
                case 34: goto L_0x030a;
                case 35: goto L_0x02fc;
                case 36: goto L_0x02ee;
                case 37: goto L_0x02e0;
                case 38: goto L_0x02d2;
                case 39: goto L_0x02c4;
                case 40: goto L_0x02b6;
                case 41: goto L_0x02a8;
                case 42: goto L_0x029a;
                case 43: goto L_0x028c;
                case 44: goto L_0x0277;
                case 45: goto L_0x0269;
                case 46: goto L_0x025b;
                case 47: goto L_0x024d;
                case 48: goto L_0x023f;
                case 49: goto L_0x022d;
                case 50: goto L_0x01f7;
                case 51: goto L_0x01e5;
                case 52: goto L_0x01d3;
                case 53: goto L_0x01c1;
                case 54: goto L_0x01af;
                case 55: goto L_0x019d;
                case 56: goto L_0x018b;
                case 57: goto L_0x0179;
                case 58: goto L_0x0167;
                case 59: goto L_0x015f;
                case 60: goto L_0x012e;
                case 61: goto L_0x0120;
                case 62: goto L_0x010e;
                case 63: goto L_0x00e9;
                case 64: goto L_0x00d7;
                case 65: goto L_0x00c5;
                case 66: goto L_0x00b3;
                case 67: goto L_0x00a1;
                case 68: goto L_0x008f;
                default: goto L_0x0087;
            }     // Catch:{ zzaah -> 0x0599 }
        L_0x0087:
            if (r10 != 0) goto L_0x0577
            java.lang.Object r10 = r8.zzg()     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0577
        L_0x008f:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.firebase-auth-api.zzabp r6 = r12.zzw(r3)     // Catch:{ zzaah -> 0x0599 }
            java.lang.Object r6 = r14.zzp(r6, r15)     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zzo(r13, r4, r6)     // Catch:{ zzaah -> 0x0599 }
            r12.zzR(r13, r2, r3)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x00a1:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzaah -> 0x0599 }
            long r6 = r14.zzw()     // Catch:{ zzaah -> 0x0599 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zzo(r13, r4, r6)     // Catch:{ zzaah -> 0x0599 }
            r12.zzR(r13, r2, r3)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x00b3:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzaah -> 0x0599 }
            int r6 = r14.zzv()     // Catch:{ zzaah -> 0x0599 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zzo(r13, r4, r6)     // Catch:{ zzaah -> 0x0599 }
            r12.zzR(r13, r2, r3)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x00c5:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzaah -> 0x0599 }
            long r6 = r14.zzu()     // Catch:{ zzaah -> 0x0599 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zzo(r13, r4, r6)     // Catch:{ zzaah -> 0x0599 }
            r12.zzR(r13, r2, r3)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x00d7:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzaah -> 0x0599 }
            int r6 = r14.zzt()     // Catch:{ zzaah -> 0x0599 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zzo(r13, r4, r6)     // Catch:{ zzaah -> 0x0599 }
            r12.zzR(r13, r2, r3)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x00e9:
            int r5 = r14.zzs()     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.firebase-auth-api.zzaae r7 = r12.zzy(r3)     // Catch:{ zzaah -> 0x0599 }
            if (r7 == 0) goto L_0x0100
            boolean r7 = r7.zza()     // Catch:{ zzaah -> 0x0599 }
            if (r7 == 0) goto L_0x00fa
            goto L_0x0100
        L_0x00fa:
            java.lang.Object r10 = com.google.android.gms.internal.p001firebaseauthapi.zzabr.zzH(r2, r5, r10, r8)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x0100:
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ zzaah -> 0x0599 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zzo(r13, r6, r4)     // Catch:{ zzaah -> 0x0599 }
            r12.zzR(r13, r2, r3)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x010e:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzaah -> 0x0599 }
            int r6 = r14.zzr()     // Catch:{ zzaah -> 0x0599 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zzo(r13, r4, r6)     // Catch:{ zzaah -> 0x0599 }
            r12.zzR(r13, r2, r3)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x0120:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.firebase-auth-api.zzyy r6 = r14.zzq()     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zzo(r13, r4, r6)     // Catch:{ zzaah -> 0x0599 }
            r12.zzR(r13, r2, r3)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x012e:
            boolean r5 = r12.zzQ(r13, r2, r3)     // Catch:{ zzaah -> 0x0599 }
            if (r5 == 0) goto L_0x014a
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzaah -> 0x0599 }
            java.lang.Object r6 = com.google.android.gms.internal.p001firebaseauthapi.zzacn.zzn(r13, r4)     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.firebase-auth-api.zzabp r7 = r12.zzw(r3)     // Catch:{ zzaah -> 0x0599 }
            java.lang.Object r7 = r14.zzo(r7, r15)     // Catch:{ zzaah -> 0x0599 }
            java.lang.Object r6 = com.google.android.gms.internal.p001firebaseauthapi.zzaag.zzi(r6, r7)     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zzo(r13, r4, r6)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x015a
        L_0x014a:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.firebase-auth-api.zzabp r6 = r12.zzw(r3)     // Catch:{ zzaah -> 0x0599 }
            java.lang.Object r6 = r14.zzo(r6, r15)     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zzo(r13, r4, r6)     // Catch:{ zzaah -> 0x0599 }
            r12.zzP(r13, r3)     // Catch:{ zzaah -> 0x0599 }
        L_0x015a:
            r12.zzR(r13, r2, r3)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x015f:
            r12.zzC(r13, r4, r14)     // Catch:{ zzaah -> 0x0599 }
            r12.zzR(r13, r2, r3)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x0167:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzaah -> 0x0599 }
            boolean r6 = r14.zzl()     // Catch:{ zzaah -> 0x0599 }
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zzo(r13, r4, r6)     // Catch:{ zzaah -> 0x0599 }
            r12.zzR(r13, r2, r3)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x0179:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzaah -> 0x0599 }
            int r6 = r14.zzk()     // Catch:{ zzaah -> 0x0599 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zzo(r13, r4, r6)     // Catch:{ zzaah -> 0x0599 }
            r12.zzR(r13, r2, r3)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x018b:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzaah -> 0x0599 }
            long r6 = r14.zzj()     // Catch:{ zzaah -> 0x0599 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zzo(r13, r4, r6)     // Catch:{ zzaah -> 0x0599 }
            r12.zzR(r13, r2, r3)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x019d:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzaah -> 0x0599 }
            int r6 = r14.zzi()     // Catch:{ zzaah -> 0x0599 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zzo(r13, r4, r6)     // Catch:{ zzaah -> 0x0599 }
            r12.zzR(r13, r2, r3)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x01af:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzaah -> 0x0599 }
            long r6 = r14.zzg()     // Catch:{ zzaah -> 0x0599 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zzo(r13, r4, r6)     // Catch:{ zzaah -> 0x0599 }
            r12.zzR(r13, r2, r3)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x01c1:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzaah -> 0x0599 }
            long r6 = r14.zzh()     // Catch:{ zzaah -> 0x0599 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zzo(r13, r4, r6)     // Catch:{ zzaah -> 0x0599 }
            r12.zzR(r13, r2, r3)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x01d3:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzaah -> 0x0599 }
            float r6 = r14.zzf()     // Catch:{ zzaah -> 0x0599 }
            java.lang.Float r6 = java.lang.Float.valueOf(r6)     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zzo(r13, r4, r6)     // Catch:{ zzaah -> 0x0599 }
            r12.zzR(r13, r2, r3)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x01e5:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzaah -> 0x0599 }
            double r6 = r14.zze()     // Catch:{ zzaah -> 0x0599 }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zzo(r13, r4, r6)     // Catch:{ zzaah -> 0x0599 }
            r12.zzR(r13, r2, r3)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x01f7:
            java.lang.Object r2 = r12.zzx(r3)     // Catch:{ zzaah -> 0x0599 }
            int r3 = r12.zzD(r3)     // Catch:{ zzaah -> 0x0599 }
            r3 = r3 & r6
            long r3 = (long) r3     // Catch:{ zzaah -> 0x0599 }
            java.lang.Object r5 = com.google.android.gms.internal.p001firebaseauthapi.zzacn.zzn(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            if (r5 == 0) goto L_0x021d
            boolean r6 = com.google.android.gms.internal.p001firebaseauthapi.zzaay.zzb(r5)     // Catch:{ zzaah -> 0x0599 }
            if (r6 == 0) goto L_0x0228
            com.google.android.gms.internal.firebase-auth-api.zzaax r6 = com.google.android.gms.internal.p001firebaseauthapi.zzaax.zza()     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.firebase-auth-api.zzaax r6 = r6.zzc()     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.p001firebaseauthapi.zzaay.zzc(r6, r5)     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zzo(r13, r3, r6)     // Catch:{ zzaah -> 0x0599 }
            r5 = r6
            goto L_0x0228
        L_0x021d:
            com.google.android.gms.internal.firebase-auth-api.zzaax r5 = com.google.android.gms.internal.p001firebaseauthapi.zzaax.zza()     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.firebase-auth-api.zzaax r5 = r5.zzc()     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zzo(r13, r3, r5)     // Catch:{ zzaah -> 0x0599 }
        L_0x0228:
            com.google.android.gms.internal.firebase-auth-api.zzaax r5 = (com.google.android.gms.internal.p001firebaseauthapi.zzaax) r5     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.firebase-auth-api.zzaaw r2 = (com.google.android.gms.internal.p001firebaseauthapi.zzaaw) r2     // Catch:{ zzaah -> 0x0599 }
            throw r0     // Catch:{ zzaah -> 0x0599 }
        L_0x022d:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.firebase-auth-api.zzabp r2 = r12.zzw(r3)     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.firebase-auth-api.zzaar r3 = r12.zzn     // Catch:{ zzaah -> 0x0599 }
            java.util.List r3 = r3.zza(r13, r4)     // Catch:{ zzaah -> 0x0599 }
            r14.zzH(r3, r2, r15)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x023f:
            com.google.android.gms.internal.firebase-auth-api.zzaar r2 = r12.zzn     // Catch:{ zzaah -> 0x0599 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzaah -> 0x0599 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            r14.zzO(r2)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x024d:
            com.google.android.gms.internal.firebase-auth-api.zzaar r2 = r12.zzn     // Catch:{ zzaah -> 0x0599 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzaah -> 0x0599 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            r14.zzN(r2)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x025b:
            com.google.android.gms.internal.firebase-auth-api.zzaar r2 = r12.zzn     // Catch:{ zzaah -> 0x0599 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzaah -> 0x0599 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            r14.zzM(r2)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x0269:
            com.google.android.gms.internal.firebase-auth-api.zzaar r2 = r12.zzn     // Catch:{ zzaah -> 0x0599 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzaah -> 0x0599 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            r14.zzL(r2)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x0277:
            com.google.android.gms.internal.firebase-auth-api.zzaar r5 = r12.zzn     // Catch:{ zzaah -> 0x0599 }
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ zzaah -> 0x0599 }
            java.util.List r4 = r5.zza(r13, r6)     // Catch:{ zzaah -> 0x0599 }
            r14.zzK(r4)     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.firebase-auth-api.zzaae r3 = r12.zzy(r3)     // Catch:{ zzaah -> 0x0599 }
            java.lang.Object r10 = com.google.android.gms.internal.p001firebaseauthapi.zzabr.zzG(r2, r4, r3, r10, r8)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x028c:
            com.google.android.gms.internal.firebase-auth-api.zzaar r2 = r12.zzn     // Catch:{ zzaah -> 0x0599 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzaah -> 0x0599 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            r14.zzJ(r2)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x029a:
            com.google.android.gms.internal.firebase-auth-api.zzaar r2 = r12.zzn     // Catch:{ zzaah -> 0x0599 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzaah -> 0x0599 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            r14.zzE(r2)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x02a8:
            com.google.android.gms.internal.firebase-auth-api.zzaar r2 = r12.zzn     // Catch:{ zzaah -> 0x0599 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzaah -> 0x0599 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            r14.zzD(r2)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x02b6:
            com.google.android.gms.internal.firebase-auth-api.zzaar r2 = r12.zzn     // Catch:{ zzaah -> 0x0599 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzaah -> 0x0599 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            r14.zzC(r2)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x02c4:
            com.google.android.gms.internal.firebase-auth-api.zzaar r2 = r12.zzn     // Catch:{ zzaah -> 0x0599 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzaah -> 0x0599 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            r14.zzB(r2)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x02d2:
            com.google.android.gms.internal.firebase-auth-api.zzaar r2 = r12.zzn     // Catch:{ zzaah -> 0x0599 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzaah -> 0x0599 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            r14.zzz(r2)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x02e0:
            com.google.android.gms.internal.firebase-auth-api.zzaar r2 = r12.zzn     // Catch:{ zzaah -> 0x0599 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzaah -> 0x0599 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            r14.zzA(r2)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x02ee:
            com.google.android.gms.internal.firebase-auth-api.zzaar r2 = r12.zzn     // Catch:{ zzaah -> 0x0599 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzaah -> 0x0599 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            r14.zzy(r2)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x02fc:
            com.google.android.gms.internal.firebase-auth-api.zzaar r2 = r12.zzn     // Catch:{ zzaah -> 0x0599 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzaah -> 0x0599 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            r14.zzx(r2)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x030a:
            com.google.android.gms.internal.firebase-auth-api.zzaar r2 = r12.zzn     // Catch:{ zzaah -> 0x0599 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzaah -> 0x0599 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            r14.zzO(r2)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x0318:
            com.google.android.gms.internal.firebase-auth-api.zzaar r2 = r12.zzn     // Catch:{ zzaah -> 0x0599 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzaah -> 0x0599 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            r14.zzN(r2)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x0326:
            com.google.android.gms.internal.firebase-auth-api.zzaar r2 = r12.zzn     // Catch:{ zzaah -> 0x0599 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzaah -> 0x0599 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            r14.zzM(r2)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x0334:
            com.google.android.gms.internal.firebase-auth-api.zzaar r2 = r12.zzn     // Catch:{ zzaah -> 0x0599 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzaah -> 0x0599 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            r14.zzL(r2)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x0342:
            com.google.android.gms.internal.firebase-auth-api.zzaar r5 = r12.zzn     // Catch:{ zzaah -> 0x0599 }
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ zzaah -> 0x0599 }
            java.util.List r4 = r5.zza(r13, r6)     // Catch:{ zzaah -> 0x0599 }
            r14.zzK(r4)     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.firebase-auth-api.zzaae r3 = r12.zzy(r3)     // Catch:{ zzaah -> 0x0599 }
            java.lang.Object r10 = com.google.android.gms.internal.p001firebaseauthapi.zzabr.zzG(r2, r4, r3, r10, r8)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x0357:
            com.google.android.gms.internal.firebase-auth-api.zzaar r2 = r12.zzn     // Catch:{ zzaah -> 0x0599 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzaah -> 0x0599 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            r14.zzJ(r2)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x0365:
            com.google.android.gms.internal.firebase-auth-api.zzaar r2 = r12.zzn     // Catch:{ zzaah -> 0x0599 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzaah -> 0x0599 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            r14.zzI(r2)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x0373:
            com.google.android.gms.internal.firebase-auth-api.zzabp r2 = r12.zzw(r3)     // Catch:{ zzaah -> 0x0599 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.firebase-auth-api.zzaar r5 = r12.zzn     // Catch:{ zzaah -> 0x0599 }
            java.util.List r3 = r5.zza(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            r14.zzG(r3, r2, r15)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x0385:
            boolean r2 = zzG(r4)     // Catch:{ zzaah -> 0x0599 }
            if (r2 == 0) goto L_0x039d
            com.google.android.gms.internal.firebase-auth-api.zzaar r2 = r12.zzn     // Catch:{ zzaah -> 0x0599 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzaah -> 0x0599 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            r3 = r14
            com.google.android.gms.internal.firebase-auth-api.zzzc r3 = (com.google.android.gms.internal.p001firebaseauthapi.zzzc) r3     // Catch:{ zzaah -> 0x0599 }
            r4 = 1
            r3.zzF(r2, r4)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x039d:
            com.google.android.gms.internal.firebase-auth-api.zzaar r2 = r12.zzn     // Catch:{ zzaah -> 0x0599 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzaah -> 0x0599 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            r3 = r14
            com.google.android.gms.internal.firebase-auth-api.zzzc r3 = (com.google.android.gms.internal.p001firebaseauthapi.zzzc) r3     // Catch:{ zzaah -> 0x0599 }
            r4 = 0
            r3.zzF(r2, r4)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x03af:
            com.google.android.gms.internal.firebase-auth-api.zzaar r2 = r12.zzn     // Catch:{ zzaah -> 0x0599 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzaah -> 0x0599 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            r14.zzE(r2)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x03bd:
            com.google.android.gms.internal.firebase-auth-api.zzaar r2 = r12.zzn     // Catch:{ zzaah -> 0x0599 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzaah -> 0x0599 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            r14.zzD(r2)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x03cb:
            com.google.android.gms.internal.firebase-auth-api.zzaar r2 = r12.zzn     // Catch:{ zzaah -> 0x0599 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzaah -> 0x0599 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            r14.zzC(r2)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x03d9:
            com.google.android.gms.internal.firebase-auth-api.zzaar r2 = r12.zzn     // Catch:{ zzaah -> 0x0599 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzaah -> 0x0599 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            r14.zzB(r2)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x03e7:
            com.google.android.gms.internal.firebase-auth-api.zzaar r2 = r12.zzn     // Catch:{ zzaah -> 0x0599 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzaah -> 0x0599 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            r14.zzz(r2)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x03f5:
            com.google.android.gms.internal.firebase-auth-api.zzaar r2 = r12.zzn     // Catch:{ zzaah -> 0x0599 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzaah -> 0x0599 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            r14.zzA(r2)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x0403:
            com.google.android.gms.internal.firebase-auth-api.zzaar r2 = r12.zzn     // Catch:{ zzaah -> 0x0599 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzaah -> 0x0599 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            r14.zzy(r2)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x0411:
            com.google.android.gms.internal.firebase-auth-api.zzaar r2 = r12.zzn     // Catch:{ zzaah -> 0x0599 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzaah -> 0x0599 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            r14.zzx(r2)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x041f:
            boolean r2 = r12.zzO(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            if (r2 == 0) goto L_0x043d
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzaah -> 0x0599 }
            java.lang.Object r2 = com.google.android.gms.internal.p001firebaseauthapi.zzacn.zzn(r13, r4)     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.firebase-auth-api.zzabp r3 = r12.zzw(r3)     // Catch:{ zzaah -> 0x0599 }
            java.lang.Object r3 = r14.zzp(r3, r15)     // Catch:{ zzaah -> 0x0599 }
            java.lang.Object r2 = com.google.android.gms.internal.p001firebaseauthapi.zzaag.zzi(r2, r3)     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zzo(r13, r4, r2)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x043d:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.firebase-auth-api.zzabp r2 = r12.zzw(r3)     // Catch:{ zzaah -> 0x0599 }
            java.lang.Object r2 = r14.zzp(r2, r15)     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zzo(r13, r4, r2)     // Catch:{ zzaah -> 0x0599 }
            r12.zzP(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x0450:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzaah -> 0x0599 }
            long r6 = r14.zzw()     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zzg(r13, r4, r6)     // Catch:{ zzaah -> 0x0599 }
            r12.zzP(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x045f:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzaah -> 0x0599 }
            int r2 = r14.zzv()     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zze(r13, r4, r2)     // Catch:{ zzaah -> 0x0599 }
            r12.zzP(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x046e:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzaah -> 0x0599 }
            long r6 = r14.zzu()     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zzg(r13, r4, r6)     // Catch:{ zzaah -> 0x0599 }
            r12.zzP(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x047d:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzaah -> 0x0599 }
            int r2 = r14.zzt()     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zze(r13, r4, r2)     // Catch:{ zzaah -> 0x0599 }
            r12.zzP(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x048c:
            int r5 = r14.zzs()     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.firebase-auth-api.zzaae r7 = r12.zzy(r3)     // Catch:{ zzaah -> 0x0599 }
            if (r7 == 0) goto L_0x04a3
            boolean r7 = r7.zza()     // Catch:{ zzaah -> 0x0599 }
            if (r7 == 0) goto L_0x049d
            goto L_0x04a3
        L_0x049d:
            java.lang.Object r10 = com.google.android.gms.internal.p001firebaseauthapi.zzabr.zzH(r2, r5, r10, r8)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x04a3:
            r2 = r4 & r6
            long r6 = (long) r2     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zze(r13, r6, r5)     // Catch:{ zzaah -> 0x0599 }
            r12.zzP(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x04ae:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzaah -> 0x0599 }
            int r2 = r14.zzr()     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zze(r13, r4, r2)     // Catch:{ zzaah -> 0x0599 }
            r12.zzP(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x04bd:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.firebase-auth-api.zzyy r2 = r14.zzq()     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zzo(r13, r4, r2)     // Catch:{ zzaah -> 0x0599 }
            r12.zzP(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x04cc:
            boolean r2 = r12.zzO(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            if (r2 == 0) goto L_0x04ea
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzaah -> 0x0599 }
            java.lang.Object r2 = com.google.android.gms.internal.p001firebaseauthapi.zzacn.zzn(r13, r4)     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.firebase-auth-api.zzabp r3 = r12.zzw(r3)     // Catch:{ zzaah -> 0x0599 }
            java.lang.Object r3 = r14.zzo(r3, r15)     // Catch:{ zzaah -> 0x0599 }
            java.lang.Object r2 = com.google.android.gms.internal.p001firebaseauthapi.zzaag.zzi(r2, r3)     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zzo(r13, r4, r2)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x04ea:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.firebase-auth-api.zzabp r2 = r12.zzw(r3)     // Catch:{ zzaah -> 0x0599 }
            java.lang.Object r2 = r14.zzo(r2, r15)     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zzo(r13, r4, r2)     // Catch:{ zzaah -> 0x0599 }
            r12.zzP(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x04fd:
            r12.zzC(r13, r4, r14)     // Catch:{ zzaah -> 0x0599 }
            r12.zzP(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x0505:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzaah -> 0x0599 }
            boolean r2 = r14.zzl()     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zzi(r13, r4, r2)     // Catch:{ zzaah -> 0x0599 }
            r12.zzP(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x0514:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzaah -> 0x0599 }
            int r2 = r14.zzk()     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zze(r13, r4, r2)     // Catch:{ zzaah -> 0x0599 }
            r12.zzP(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x0523:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzaah -> 0x0599 }
            long r6 = r14.zzj()     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zzg(r13, r4, r6)     // Catch:{ zzaah -> 0x0599 }
            r12.zzP(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x0531:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzaah -> 0x0599 }
            int r2 = r14.zzi()     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zze(r13, r4, r2)     // Catch:{ zzaah -> 0x0599 }
            r12.zzP(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x053f:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzaah -> 0x0599 }
            long r6 = r14.zzg()     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zzg(r13, r4, r6)     // Catch:{ zzaah -> 0x0599 }
            r12.zzP(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x054d:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzaah -> 0x0599 }
            long r6 = r14.zzh()     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zzg(r13, r4, r6)     // Catch:{ zzaah -> 0x0599 }
            r12.zzP(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x055b:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzaah -> 0x0599 }
            float r2 = r14.zzf()     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zzk(r13, r4, r2)     // Catch:{ zzaah -> 0x0599 }
            r12.zzP(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x0569:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzaah -> 0x0599 }
            double r6 = r14.zze()     // Catch:{ zzaah -> 0x0599 }
            com.google.android.gms.internal.p001firebaseauthapi.zzacn.zzm(r13, r4, r6)     // Catch:{ zzaah -> 0x0599 }
            r12.zzP(r13, r3)     // Catch:{ zzaah -> 0x0599 }
            goto L_0x0593
        L_0x0577:
            boolean r2 = r8.zzn(r10, r14)     // Catch:{ zzaah -> 0x0597, all -> 0x0595 }
            if (r2 != 0) goto L_0x0592
            int r14 = r12.zzl
        L_0x057f:
            int r15 = r12.zzm
            if (r14 >= r15) goto L_0x058e
            int[] r15 = r12.zzk
            r15 = r15[r14]
            java.lang.Object r10 = r12.zzA(r13, r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x057f
        L_0x058e:
            if (r10 == 0) goto L_0x05bf
            goto L_0x002b
        L_0x0592:
        L_0x0593:
            goto L_0x0009
        L_0x0595:
            r14 = move-exception
            goto L_0x05c3
        L_0x0597:
            r2 = move-exception
            goto L_0x059a
        L_0x0599:
            r2 = move-exception
        L_0x059a:
            r8.zza(r14)     // Catch:{ all -> 0x05c0 }
            if (r10 != 0) goto L_0x05a4
            java.lang.Object r2 = r8.zzk(r13)     // Catch:{ all -> 0x05c0 }
            r10 = r2
        L_0x05a4:
            boolean r2 = r8.zzn(r10, r14)     // Catch:{ all -> 0x05c0 }
            if (r2 != 0) goto L_0x0009
            int r14 = r12.zzl
        L_0x05ac:
            int r15 = r12.zzm
            if (r14 >= r15) goto L_0x05bb
            int[] r15 = r12.zzk
            r15 = r15[r14]
            java.lang.Object r10 = r12.zzA(r13, r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x05ac
        L_0x05bb:
            if (r10 == 0) goto L_0x05bf
            goto L_0x002b
        L_0x05bf:
            return
        L_0x05c0:
            r14 = move-exception
            goto L_0x05c3
        L_0x05c2:
            r14 = move-exception
        L_0x05c3:
            int r15 = r12.zzl
        L_0x05c5:
            int r0 = r12.zzm
            if (r15 >= r0) goto L_0x05d4
            int[] r0 = r12.zzk
            r0 = r0[r15]
            java.lang.Object r10 = r12.zzA(r13, r0, r10, r8)
            int r15 = r15 + 1
            goto L_0x05c5
        L_0x05d4:
            if (r10 == 0) goto L_0x05d9
            r8.zzl(r13, r10)
        L_0x05d9:
            throw r14
        L_0x05da:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzabg.zzf(java.lang.Object, com.google.android.gms.internal.firebase-auth-api.zzabo, com.google.android.gms.internal.firebase-auth-api.zzzn):void");
    }

    /* access modifiers changed from: package-private */
    public final int zzh(T t, byte[] bArr, int i, int i2, int i3, zzym zzym) throws IOException {
        Unsafe unsafe;
        int i4;
        T t2;
        zzabg zzabg;
        Object obj;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        T t3;
        int i13;
        zzym zzym2;
        int zzn2;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        boolean z;
        zzabg zzabg2 = this;
        T t4 = t;
        byte[] bArr2 = bArr;
        int i23 = i2;
        int i24 = i3;
        zzym zzym3 = zzym;
        Unsafe unsafe2 = zzb;
        int i25 = i;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        int i29 = -1;
        int i30 = 1048575;
        while (true) {
            if (i25 < i23) {
                int i31 = i25 + 1;
                byte b = bArr2[i25];
                if (b < 0) {
                    i6 = zzyn.zzb(b, bArr2, i31, zzym3);
                    i5 = zzym3.zza;
                } else {
                    int i32 = i31;
                    i5 = b;
                    i6 = i32;
                }
                int i33 = i5 >>> 3;
                int i34 = i5 & 7;
                if (i33 > i29) {
                    i7 = zzabg2.zzT(i33, i27 / 3);
                } else {
                    i7 = zzabg2.zzS(i33);
                }
                if (i7 == -1) {
                    i12 = i6;
                    i8 = i5;
                    i11 = i28;
                    i10 = i33;
                    unsafe = unsafe2;
                    i9 = 0;
                } else {
                    int i35 = zzabg2.zzc[i7 + 1];
                    int zzF = zzF(i35);
                    int i36 = i5;
                    int i37 = i6;
                    long j = (long) (i35 & 1048575);
                    if (zzF <= 17) {
                        int i38 = zzabg2.zzc[i7 + 2];
                        int i39 = 1 << (i38 >>> 20);
                        int i40 = i38 & 1048575;
                        if (i40 != i30) {
                            if (i30 != 1048575) {
                                i18 = i7;
                                unsafe2.putInt(t4, (long) i30, i28);
                            } else {
                                i18 = i7;
                            }
                            i17 = i40;
                            i19 = unsafe2.getInt(t4, (long) i40);
                        } else {
                            i18 = i7;
                            i17 = i30;
                            i19 = i28;
                        }
                        switch (zzF) {
                            case 0:
                                i21 = i36;
                                i12 = i37;
                                long j2 = j;
                                i20 = i33;
                                i22 = i18;
                                if (i34 == 1) {
                                    zzacn.zzm(t4, j2, Double.longBitsToDouble(zzyn.zze(bArr2, i12)));
                                    i25 = i12 + 8;
                                    i28 = i19 | i39;
                                    i27 = i22;
                                    i26 = i21;
                                    i29 = i20;
                                    i30 = i17;
                                    i24 = i3;
                                    continue;
                                }
                                break;
                            case 1:
                                i21 = i36;
                                i12 = i37;
                                long j3 = j;
                                i20 = i33;
                                i22 = i18;
                                if (i34 == 5) {
                                    zzacn.zzk(t4, j3, Float.intBitsToFloat(zzyn.zzd(bArr2, i12)));
                                    i25 = i12 + 4;
                                    i28 = i19 | i39;
                                    i27 = i22;
                                    i26 = i21;
                                    i29 = i20;
                                    i30 = i17;
                                    i24 = i3;
                                    continue;
                                }
                                break;
                            case 2:
                            case 3:
                                i21 = i36;
                                i12 = i37;
                                long j4 = j;
                                i20 = i33;
                                i22 = i18;
                                if (i34 == 0) {
                                    int zzc2 = zzyn.zzc(bArr2, i12, zzym3);
                                    unsafe2.putLong(t, j4, zzym3.zzb);
                                    i28 = i19 | i39;
                                    i27 = i22;
                                    i25 = zzc2;
                                    i26 = i21;
                                    i29 = i20;
                                    i30 = i17;
                                    i24 = i3;
                                    continue;
                                }
                                break;
                            case 4:
                            case 11:
                                i21 = i36;
                                i12 = i37;
                                long j5 = j;
                                i20 = i33;
                                i22 = i18;
                                if (i34 == 0) {
                                    i25 = zzyn.zza(bArr2, i12, zzym3);
                                    unsafe2.putInt(t4, j5, zzym3.zza);
                                    i28 = i19 | i39;
                                    i27 = i22;
                                    i26 = i21;
                                    i29 = i20;
                                    i30 = i17;
                                    i24 = i3;
                                    continue;
                                }
                                break;
                            case 5:
                            case 14:
                                i21 = i36;
                                int i41 = i37;
                                long j6 = j;
                                i20 = i33;
                                i22 = i18;
                                if (i34 != 1) {
                                    i12 = i41;
                                    break;
                                } else {
                                    unsafe2.putLong(t, j6, zzyn.zze(bArr2, i41));
                                    i25 = i41 + 8;
                                    i28 = i19 | i39;
                                    i27 = i22;
                                    i26 = i21;
                                    i29 = i20;
                                    i30 = i17;
                                    i24 = i3;
                                    continue;
                                }
                            case 6:
                            case 13:
                                i21 = i36;
                                int i42 = i37;
                                long j7 = j;
                                i20 = i33;
                                i22 = i18;
                                if (i34 != 5) {
                                    i12 = i42;
                                    break;
                                } else {
                                    unsafe2.putInt(t4, j7, zzyn.zzd(bArr2, i42));
                                    i25 = i42 + 4;
                                    i28 = i19 | i39;
                                    i27 = i22;
                                    i26 = i21;
                                    i29 = i20;
                                    i30 = i17;
                                    i24 = i3;
                                    continue;
                                }
                            case 7:
                                i21 = i36;
                                int i43 = i37;
                                long j8 = j;
                                i20 = i33;
                                i22 = i18;
                                if (i34 != 0) {
                                    i12 = i43;
                                    break;
                                } else {
                                    i25 = zzyn.zzc(bArr2, i43, zzym3);
                                    if (zzym3.zzb != 0) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    zzacn.zzi(t4, j8, z);
                                    i28 = i19 | i39;
                                    i27 = i22;
                                    i26 = i21;
                                    i29 = i20;
                                    i30 = i17;
                                    i24 = i3;
                                    continue;
                                }
                            case 8:
                                i21 = i36;
                                int i44 = i37;
                                long j9 = j;
                                i20 = i33;
                                i22 = i18;
                                if (i34 != 2) {
                                    i12 = i44;
                                    break;
                                } else {
                                    if ((536870912 & i35) == 0) {
                                        i25 = zzyn.zzf(bArr2, i44, zzym3);
                                    } else {
                                        i25 = zzyn.zzg(bArr2, i44, zzym3);
                                    }
                                    unsafe2.putObject(t4, j9, zzym3.zzc);
                                    i28 = i19 | i39;
                                    i27 = i22;
                                    i26 = i21;
                                    i29 = i20;
                                    i30 = i17;
                                    i24 = i3;
                                    continue;
                                }
                            case 9:
                                i21 = i36;
                                int i45 = i37;
                                long j10 = j;
                                i20 = i33;
                                i22 = i18;
                                if (i34 != 2) {
                                    i12 = i45;
                                    break;
                                } else {
                                    i25 = zzyn.zzi(zzabg2.zzw(i22), bArr2, i45, i23, zzym3);
                                    if ((i19 & i39) == 0) {
                                        unsafe2.putObject(t4, j10, zzym3.zzc);
                                    } else {
                                        unsafe2.putObject(t4, j10, zzaag.zzi(unsafe2.getObject(t4, j10), zzym3.zzc));
                                    }
                                    i28 = i19 | i39;
                                    i27 = i22;
                                    i26 = i21;
                                    i29 = i20;
                                    i30 = i17;
                                    i24 = i3;
                                    continue;
                                }
                            case 10:
                                i21 = i36;
                                int i46 = i37;
                                long j11 = j;
                                i20 = i33;
                                i22 = i18;
                                if (i34 != 2) {
                                    i12 = i46;
                                    break;
                                } else {
                                    i25 = zzyn.zzh(bArr2, i46, zzym3);
                                    unsafe2.putObject(t4, j11, zzym3.zzc);
                                    i28 = i19 | i39;
                                    i27 = i22;
                                    i26 = i21;
                                    i29 = i20;
                                    i30 = i17;
                                    i24 = i3;
                                    continue;
                                }
                            case 12:
                                i21 = i36;
                                int i47 = i37;
                                long j12 = j;
                                i20 = i33;
                                i22 = i18;
                                if (i34 != 0) {
                                    i12 = i47;
                                    break;
                                } else {
                                    i25 = zzyn.zza(bArr2, i47, zzym3);
                                    int i48 = zzym3.zza;
                                    zzaae zzy = zzabg2.zzy(i22);
                                    if (zzy == null || zzy.zza()) {
                                        unsafe2.putInt(t4, j12, i48);
                                        i28 = i19 | i39;
                                        i27 = i22;
                                        i26 = i21;
                                        i29 = i20;
                                        i30 = i17;
                                        i24 = i3;
                                        break;
                                    } else {
                                        zzg(t).zzh(i21, Long.valueOf((long) i48));
                                        i28 = i19;
                                        i27 = i22;
                                        i26 = i21;
                                        i29 = i20;
                                        i30 = i17;
                                        i24 = i3;
                                        continue;
                                    }
                                }
                                break;
                            case 15:
                                i21 = i36;
                                int i49 = i37;
                                long j13 = j;
                                i20 = i33;
                                i22 = i18;
                                if (i34 != 0) {
                                    i12 = i49;
                                    break;
                                } else {
                                    i25 = zzyn.zza(bArr2, i49, zzym3);
                                    unsafe2.putInt(t4, j13, zzzb.zzt(zzym3.zza));
                                    i28 = i19 | i39;
                                    i27 = i22;
                                    i26 = i21;
                                    i29 = i20;
                                    i30 = i17;
                                    i24 = i3;
                                    continue;
                                }
                            case 16:
                                if (i34 != 0) {
                                    i21 = i36;
                                    i20 = i33;
                                    i22 = i18;
                                    i12 = i37;
                                    break;
                                } else {
                                    int zzc3 = zzyn.zzc(bArr2, i37, zzym3);
                                    unsafe2.putLong(t, j, zzzb.zzu(zzym3.zzb));
                                    i28 = i19 | i39;
                                    i27 = i18;
                                    i25 = zzc3;
                                    i26 = i36;
                                    i29 = i33;
                                    i30 = i17;
                                    i24 = i3;
                                    continue;
                                }
                            default:
                                i21 = i36;
                                i12 = i37;
                                long j14 = j;
                                i20 = i33;
                                i22 = i18;
                                if (i34 == 3) {
                                    long j15 = j14;
                                    i25 = zzyn.zzj(zzabg2.zzw(i22), bArr, i12, i2, (i20 << 3) | 4, zzym);
                                    if ((i19 & i39) == 0) {
                                        unsafe2.putObject(t4, j15, zzym3.zzc);
                                    } else {
                                        unsafe2.putObject(t4, j15, zzaag.zzi(unsafe2.getObject(t4, j15), zzym3.zzc));
                                    }
                                    i28 = i19 | i39;
                                    bArr2 = bArr;
                                    i23 = i2;
                                    i27 = i22;
                                    i26 = i21;
                                    i29 = i20;
                                    i30 = i17;
                                    i24 = i3;
                                    continue;
                                }
                                break;
                        }
                        i11 = i19;
                        unsafe = unsafe2;
                        i8 = i21;
                        i10 = i20;
                        i30 = i17;
                        i9 = i22;
                    } else {
                        int i50 = i36;
                        long j16 = j;
                        int i51 = i33;
                        int i52 = i7;
                        int i53 = i37;
                        if (zzF != 27) {
                            i11 = i28;
                            i14 = i30;
                            int i54 = i53;
                            if (zzF <= 49) {
                                int i55 = i54;
                                int i56 = i51;
                                i10 = i51;
                                i9 = i52;
                                unsafe = unsafe2;
                                i8 = i50;
                                i25 = zzt(t, bArr, i54, i2, i50, i56, i34, i9, (long) i35, zzF, j16, zzym);
                                if (i25 != i55) {
                                    zzabg2 = this;
                                    t4 = t;
                                    bArr2 = bArr;
                                    i23 = i2;
                                    i24 = i3;
                                    zzym3 = zzym;
                                    i28 = i11;
                                    i29 = i10;
                                    i27 = i9;
                                    i26 = i8;
                                    i30 = i14;
                                    unsafe2 = unsafe;
                                } else {
                                    i12 = i25;
                                    i30 = i14;
                                }
                            } else {
                                i15 = i54;
                                unsafe = unsafe2;
                                i8 = i50;
                                i10 = i51;
                                i9 = i52;
                                int i57 = zzF;
                                if (i57 != 50) {
                                    i25 = zzv(t, bArr, i15, i2, i8, i10, i34, i35, i57, j16, i9, zzym);
                                    if (i25 != i15) {
                                        zzabg2 = this;
                                        t4 = t;
                                        bArr2 = bArr;
                                        i23 = i2;
                                        i24 = i3;
                                        zzym3 = zzym;
                                        i28 = i11;
                                        i29 = i10;
                                        i27 = i9;
                                        i26 = i8;
                                        i30 = i14;
                                        unsafe2 = unsafe;
                                    } else {
                                        i12 = i25;
                                        i30 = i14;
                                    }
                                } else if (i34 == 2) {
                                    i25 = zzu(t, bArr, i15, i2, i9, j16, zzym);
                                    if (i25 != i15) {
                                        zzabg2 = this;
                                        t4 = t;
                                        bArr2 = bArr;
                                        i23 = i2;
                                        i24 = i3;
                                        zzym3 = zzym;
                                        i28 = i11;
                                        i29 = i10;
                                        i27 = i9;
                                        i26 = i8;
                                        i30 = i14;
                                        unsafe2 = unsafe;
                                    } else {
                                        i12 = i25;
                                        i30 = i14;
                                    }
                                }
                            }
                        } else if (i34 == 2) {
                            zzaaf zzaaf = (zzaaf) unsafe2.getObject(t4, j16);
                            if (!zzaaf.zza()) {
                                int size = zzaaf.size();
                                if (size == 0) {
                                    i16 = 10;
                                } else {
                                    i16 = size + size;
                                }
                                zzaaf = zzaaf.zze(i16);
                                unsafe2.putObject(t4, j16, zzaaf);
                            }
                            i26 = i50;
                            i25 = zzyn.zzm(zzabg2.zzw(i52), i26, bArr, i53, i2, zzaaf, zzym);
                            bArr2 = bArr;
                            i23 = i2;
                            i27 = i52;
                            i28 = i28;
                            i29 = i51;
                            i30 = i30;
                            i24 = i3;
                        } else {
                            i11 = i28;
                            i14 = i30;
                            i15 = i53;
                            unsafe = unsafe2;
                            i8 = i50;
                            i10 = i51;
                            i9 = i52;
                        }
                        i12 = i15;
                        i30 = i14;
                    }
                }
                i4 = i3;
                int i58 = i8;
                if (i58 != i4 || i4 == 0) {
                    if (this.zzh) {
                        zzym2 = zzym;
                        if (zzym2.zzd != zzzn.zza()) {
                            i13 = i10;
                            if (zzym2.zzd.zzb(this.zzg, i13) == null) {
                                zzn2 = zzyn.zzn(i58, bArr, i12, i2, zzg(t), zzym);
                                t3 = t;
                                i23 = i2;
                                i26 = i58;
                                zzabg2 = this;
                                zzym3 = zzym2;
                                i29 = i13;
                                t4 = t3;
                                i28 = i11;
                                i27 = i9;
                                unsafe2 = unsafe;
                                bArr2 = bArr;
                                i24 = i4;
                            } else {
                                zzzx zzzx = (zzzx) t;
                                throw null;
                            }
                        } else {
                            t3 = t;
                            i13 = i10;
                        }
                    } else {
                        t3 = t;
                        zzym2 = zzym;
                        i13 = i10;
                    }
                    zzn2 = zzyn.zzn(i58, bArr, i12, i2, zzg(t), zzym);
                    i23 = i2;
                    i26 = i58;
                    zzabg2 = this;
                    zzym3 = zzym2;
                    i29 = i13;
                    t4 = t3;
                    i28 = i11;
                    i27 = i9;
                    unsafe2 = unsafe;
                    bArr2 = bArr;
                    i24 = i4;
                } else {
                    zzabg = this;
                    t2 = t;
                    i25 = i12;
                    i26 = i58;
                    i28 = i11;
                    obj = null;
                }
            } else {
                int i59 = i28;
                int i60 = i30;
                unsafe = unsafe2;
                i4 = i24;
                t2 = t4;
                zzabg = zzabg2;
                obj = null;
            }
        }
        if (i30 != 1048575) {
            unsafe.putInt(t2, (long) i30, i28);
        }
        for (int i61 = zzabg.zzl; i61 < zzabg.zzm; i61++) {
            zzabg.zzA(t2, zzabg.zzk[i61], obj, zzabg.zzo);
        }
        if (i4 == 0) {
            if (i25 != i2) {
                throw zzaai.zzh();
            }
        } else if (i25 > i2 || i26 != i4) {
            throw zzaai.zzh();
        }
        return i25;
    }

    public final void zzi(T t, byte[] bArr, int i, int i2, zzym zzym) throws IOException {
        if (this.zzj) {
            zzz(t, bArr, i, i2, zzym);
        } else {
            zzh(t, bArr, i, i2, 0, zzym);
        }
    }

    public final void zzj(T t) {
        int i;
        int i2 = this.zzl;
        while (true) {
            i = this.zzm;
            if (i2 >= i) {
                break;
            }
            long zzD = (long) (zzD(this.zzk[i2]) & 1048575);
            Object zzn2 = zzacn.zzn(t, zzD);
            if (zzn2 != null) {
                ((zzaax) zzn2).zzd();
                zzacn.zzo(t, zzD, zzn2);
            }
            i2++;
        }
        int length = this.zzk.length;
        while (i < length) {
            this.zzn.zzb(t, (long) this.zzk[i]);
            i++;
        }
        this.zzo.zzm(t);
        if (this.zzh) {
            this.zzp.zzd(t);
        }
    }

    public final boolean zzk(T t) {
        int i;
        int i2;
        T t2 = t;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i5 < this.zzl) {
            int i6 = this.zzk[i5];
            int i7 = this.zzc[i6];
            int zzD = zzD(i6);
            int i8 = this.zzc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 == i3) {
                i2 = i3;
                i = i4;
            } else if (i9 != 1048575) {
                i = zzb.getInt(t2, (long) i9);
                i2 = i9;
            } else {
                i = i4;
                i2 = i9;
            }
            if ((268435456 & zzD) != 0 && !zzN(t, i6, i2, i, i10)) {
                return false;
            }
            int zzF = zzF(zzD);
            if (zzF != 9 && zzF != 17) {
                if (zzF != 27) {
                    if (zzF == 60 || zzF == 68) {
                        if (zzQ(t2, i7, i6) && !zzB(t2, zzD, zzw(i6))) {
                            return false;
                        }
                    } else if (zzF != 49) {
                        if (zzF == 50 && !((zzaax) zzacn.zzn(t2, (long) (zzD & 1048575))).isEmpty()) {
                            zzaaw zzaaw = (zzaaw) zzx(i6);
                            throw null;
                        }
                    }
                }
                List list = (List) zzacn.zzn(t2, (long) (zzD & 1048575));
                if (!list.isEmpty()) {
                    zzabp zzw = zzw(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!zzw.zzk(list.get(i11))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (zzN(t, i6, i2, i, i10) && !zzB(t2, zzD, zzw(i6))) {
                return false;
            }
            i5++;
            i3 = i2;
            i4 = i;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzp.zzb(t2);
        throw null;
    }

    public final void zzn(T t, zzzj zzzj) throws IOException {
        if (!this.zzj) {
            zzV(t, zzzj);
        } else if (!this.zzh) {
            int length = this.zzc.length;
            for (int i = 0; i < length; i += 3) {
                int zzD = zzD(i);
                int i2 = this.zzc[i];
                switch (zzF(zzD)) {
                    case 0:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzzj.zzf(i2, zzacn.zzl(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 1:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzzj.zze(i2, zzacn.zzj(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 2:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzzj.zzc(i2, zzacn.zzf(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 3:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzzj.zzh(i2, zzacn.zzf(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 4:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzzj.zzi(i2, zzacn.zzd(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 5:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzzj.zzj(i2, zzacn.zzf(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 6:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzzj.zzk(i2, zzacn.zzd(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 7:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzzj.zzl(i2, zzacn.zzh(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 8:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzX(i2, zzacn.zzn(t, (long) (zzD & 1048575)), zzzj);
                            break;
                        }
                    case 9:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzzj.zzr(i2, zzacn.zzn(t, (long) (zzD & 1048575)), zzw(i));
                            break;
                        }
                    case 10:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzzj.zzn(i2, (zzyy) zzacn.zzn(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 11:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzzj.zzo(i2, zzacn.zzd(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 12:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzzj.zzg(i2, zzacn.zzd(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 13:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzzj.zzb(i2, zzacn.zzd(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 14:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzzj.zzd(i2, zzacn.zzf(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 15:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzzj.zzp(i2, zzacn.zzd(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 16:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzzj.zzq(i2, zzacn.zzf(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 17:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzzj.zzs(i2, zzacn.zzn(t, (long) (zzD & 1048575)), zzw(i));
                            break;
                        }
                    case 18:
                        zzabr.zzJ(this.zzc[i], (List) zzacn.zzn(t, (long) (zzD & 1048575)), zzzj, false);
                        break;
                    case 19:
                        zzabr.zzK(this.zzc[i], (List) zzacn.zzn(t, (long) (zzD & 1048575)), zzzj, false);
                        break;
                    case 20:
                        zzabr.zzL(this.zzc[i], (List) zzacn.zzn(t, (long) (zzD & 1048575)), zzzj, false);
                        break;
                    case 21:
                        zzabr.zzM(this.zzc[i], (List) zzacn.zzn(t, (long) (zzD & 1048575)), zzzj, false);
                        break;
                    case 22:
                        zzabr.zzQ(this.zzc[i], (List) zzacn.zzn(t, (long) (zzD & 1048575)), zzzj, false);
                        break;
                    case 23:
                        zzabr.zzO(this.zzc[i], (List) zzacn.zzn(t, (long) (zzD & 1048575)), zzzj, false);
                        break;
                    case 24:
                        zzabr.zzT(this.zzc[i], (List) zzacn.zzn(t, (long) (zzD & 1048575)), zzzj, false);
                        break;
                    case 25:
                        zzabr.zzW(this.zzc[i], (List) zzacn.zzn(t, (long) (zzD & 1048575)), zzzj, false);
                        break;
                    case 26:
                        zzabr.zzX(this.zzc[i], (List) zzacn.zzn(t, (long) (zzD & 1048575)), zzzj);
                        break;
                    case 27:
                        zzabr.zzZ(this.zzc[i], (List) zzacn.zzn(t, (long) (zzD & 1048575)), zzzj, zzw(i));
                        break;
                    case 28:
                        zzabr.zzY(this.zzc[i], (List) zzacn.zzn(t, (long) (zzD & 1048575)), zzzj);
                        break;
                    case 29:
                        zzabr.zzR(this.zzc[i], (List) zzacn.zzn(t, (long) (zzD & 1048575)), zzzj, false);
                        break;
                    case 30:
                        zzabr.zzV(this.zzc[i], (List) zzacn.zzn(t, (long) (zzD & 1048575)), zzzj, false);
                        break;
                    case 31:
                        zzabr.zzU(this.zzc[i], (List) zzacn.zzn(t, (long) (zzD & 1048575)), zzzj, false);
                        break;
                    case 32:
                        zzabr.zzP(this.zzc[i], (List) zzacn.zzn(t, (long) (zzD & 1048575)), zzzj, false);
                        break;
                    case 33:
                        zzabr.zzS(this.zzc[i], (List) zzacn.zzn(t, (long) (zzD & 1048575)), zzzj, false);
                        break;
                    case 34:
                        zzabr.zzN(this.zzc[i], (List) zzacn.zzn(t, (long) (zzD & 1048575)), zzzj, false);
                        break;
                    case 35:
                        zzabr.zzJ(this.zzc[i], (List) zzacn.zzn(t, (long) (zzD & 1048575)), zzzj, true);
                        break;
                    case 36:
                        zzabr.zzK(this.zzc[i], (List) zzacn.zzn(t, (long) (zzD & 1048575)), zzzj, true);
                        break;
                    case 37:
                        zzabr.zzL(this.zzc[i], (List) zzacn.zzn(t, (long) (zzD & 1048575)), zzzj, true);
                        break;
                    case 38:
                        zzabr.zzM(this.zzc[i], (List) zzacn.zzn(t, (long) (zzD & 1048575)), zzzj, true);
                        break;
                    case 39:
                        zzabr.zzQ(this.zzc[i], (List) zzacn.zzn(t, (long) (zzD & 1048575)), zzzj, true);
                        break;
                    case 40:
                        zzabr.zzO(this.zzc[i], (List) zzacn.zzn(t, (long) (zzD & 1048575)), zzzj, true);
                        break;
                    case 41:
                        zzabr.zzT(this.zzc[i], (List) zzacn.zzn(t, (long) (zzD & 1048575)), zzzj, true);
                        break;
                    case 42:
                        zzabr.zzW(this.zzc[i], (List) zzacn.zzn(t, (long) (zzD & 1048575)), zzzj, true);
                        break;
                    case 43:
                        zzabr.zzR(this.zzc[i], (List) zzacn.zzn(t, (long) (zzD & 1048575)), zzzj, true);
                        break;
                    case 44:
                        zzabr.zzV(this.zzc[i], (List) zzacn.zzn(t, (long) (zzD & 1048575)), zzzj, true);
                        break;
                    case 45:
                        zzabr.zzU(this.zzc[i], (List) zzacn.zzn(t, (long) (zzD & 1048575)), zzzj, true);
                        break;
                    case 46:
                        zzabr.zzP(this.zzc[i], (List) zzacn.zzn(t, (long) (zzD & 1048575)), zzzj, true);
                        break;
                    case 47:
                        zzabr.zzS(this.zzc[i], (List) zzacn.zzn(t, (long) (zzD & 1048575)), zzzj, true);
                        break;
                    case 48:
                        zzabr.zzN(this.zzc[i], (List) zzacn.zzn(t, (long) (zzD & 1048575)), zzzj, true);
                        break;
                    case 49:
                        zzabr.zzaa(this.zzc[i], (List) zzacn.zzn(t, (long) (zzD & 1048575)), zzzj, zzw(i));
                        break;
                    case 50:
                        zzW(zzzj, i2, zzacn.zzn(t, (long) (zzD & 1048575)), i);
                        break;
                    case 51:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzzj.zzf(i2, zzH(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 52:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzzj.zze(i2, zzI(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 53:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzzj.zzc(i2, zzK(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 54:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzzj.zzh(i2, zzK(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 55:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzzj.zzi(i2, zzJ(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 56:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzzj.zzj(i2, zzK(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 57:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzzj.zzk(i2, zzJ(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 58:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzzj.zzl(i2, zzL(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 59:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzX(i2, zzacn.zzn(t, (long) (zzD & 1048575)), zzzj);
                            break;
                        }
                    case 60:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzzj.zzr(i2, zzacn.zzn(t, (long) (zzD & 1048575)), zzw(i));
                            break;
                        }
                    case 61:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzzj.zzn(i2, (zzyy) zzacn.zzn(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 62:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzzj.zzo(i2, zzJ(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 63:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzzj.zzg(i2, zzJ(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 64:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzzj.zzb(i2, zzJ(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 65:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzzj.zzd(i2, zzK(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 66:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzzj.zzp(i2, zzJ(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 67:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzzj.zzq(i2, zzK(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 68:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzzj.zzs(i2, zzacn.zzn(t, (long) (zzD & 1048575)), zzw(i));
                            break;
                        }
                }
            }
            zzacd<?, ?> zzacd = this.zzo;
            zzacd.zzr(zzacd.zzj(t), zzzj);
        } else {
            this.zzp.zzb(t);
            throw null;
        }
    }

    private final <K, V> void zzW(zzzj zzzj, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzaaw zzaaw = (zzaaw) zzx(i2);
            throw null;
        }
    }
}
