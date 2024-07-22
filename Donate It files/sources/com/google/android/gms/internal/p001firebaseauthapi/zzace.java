package com.google.android.gms.internal.p001firebaseauthapi;

import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzace  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzace {
    private static final zzace zza = new zzace(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzace() {
        this(0, new int[8], new Object[8], true);
    }

    private zzace(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzace zza() {
        return zza;
    }

    static zzace zzb() {
        return new zzace(0, new int[8], new Object[8], true);
    }

    static zzace zzc(zzace zzace, zzace zzace2) {
        int i = zzace.zzb + zzace2.zzb;
        int[] copyOf = Arrays.copyOf(zzace.zzc, i);
        System.arraycopy(zzace2.zzc, 0, copyOf, zzace.zzb, zzace2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzace.zzd, i);
        System.arraycopy(zzace2.zzd, 0, copyOf2, zzace.zzb, zzace2.zzb);
        return new zzace(i, copyOf, copyOf2, true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzace)) {
            return false;
        }
        zzace zzace = (zzace) obj;
        int i = this.zzb;
        if (i == zzace.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzace.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzace.zzd;
                    int i3 = this.zzb;
                    int i4 = 0;
                    while (i4 < i3) {
                        if (objArr[i4].equals(objArr2[i4])) {
                            i4++;
                        }
                    }
                    return true;
                } else if (iArr[i2] != iArr2[i2]) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzc;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzd;
        int i7 = this.zzb;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public final void zzd() {
        this.zzf = false;
    }

    public final int zze() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int i4 = this.zzc[i3];
            int zzA = zzzi.zzA(8);
            int zzc2 = ((zzyy) this.zzd[i3]).zzc();
            i2 += zzA + zzA + zzzi.zzA(16) + zzzi.zzA(i4 >>> 3) + zzzi.zzA(24) + zzzi.zzA(zzc2) + zzc2;
        }
        this.zze = i2;
        return i2;
    }

    public final int zzf() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int i4 = this.zzc[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 == 0) {
                i2 += zzzi.zzA(i5 << 3) + zzzi.zzB(((Long) this.zzd[i3]).longValue());
            } else if (i6 == 1) {
                ((Long) this.zzd[i3]).longValue();
                i2 += zzzi.zzA(i5 << 3) + 8;
            } else if (i6 == 2) {
                int zzA = zzzi.zzA(i5 << 3);
                int zzc2 = ((zzyy) this.zzd[i3]).zzc();
                i2 += zzA + zzzi.zzA(zzc2) + zzc2;
            } else if (i6 == 3) {
                int zzy = zzzi.zzy(i5);
                i2 += zzy + zzy + ((zzace) this.zzd[i3]).zzf();
            } else if (i6 == 5) {
                ((Integer) this.zzd[i3]).intValue();
                i2 += zzzi.zzA(i5 << 3) + 4;
            } else {
                throw new IllegalStateException(zzaai.zzg());
            }
        }
        this.zze = i2;
        return i2;
    }

    /* access modifiers changed from: package-private */
    public final void zzg(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzabf.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzh(int i, Object obj) {
        int i2;
        if (this.zzf) {
            int i3 = this.zzb;
            int[] iArr = this.zzc;
            if (i3 == iArr.length) {
                if (i3 < 4) {
                    i2 = 8;
                } else {
                    i2 = i3 >> 1;
                }
                int i4 = i3 + i2;
                this.zzc = Arrays.copyOf(iArr, i4);
                this.zzd = Arrays.copyOf(this.zzd, i4);
            }
            int[] iArr2 = this.zzc;
            int i5 = this.zzb;
            iArr2[i5] = i;
            this.zzd[i5] = obj;
            this.zzb = i5 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    public final void zzi(zzzj zzzj) throws IOException {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 >>> 3;
                int i4 = i2 & 7;
                if (i4 == 0) {
                    zzzj.zzc(i3, ((Long) obj).longValue());
                } else if (i4 == 1) {
                    zzzj.zzj(i3, ((Long) obj).longValue());
                } else if (i4 == 2) {
                    zzzj.zzn(i3, (zzyy) obj);
                } else if (i4 == 3) {
                    zzzj.zzt(i3);
                    ((zzace) obj).zzi(zzzj);
                    zzzj.zzu(i3);
                } else if (i4 == 5) {
                    zzzj.zzk(i3, ((Integer) obj).intValue());
                } else {
                    throw new RuntimeException(zzaai.zzg());
                }
            }
        }
    }
}
