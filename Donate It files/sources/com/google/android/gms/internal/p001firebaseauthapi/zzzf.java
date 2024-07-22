package com.google.android.gms.internal.p001firebaseauthapi;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzf  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzzf extends zzzi {
    private final byte[] zza;
    private final int zzb;
    private int zzc;

    public final void zzM(int i, int i2) throws IOException {
        zzo((i << 3) | i2);
    }

    public final void zzN(int i, int i2) throws IOException {
        zzo(i << 3);
        zzn(i2);
    }

    public final void zzO(int i, int i2) throws IOException {
        zzo(i << 3);
        zzo(i2);
    }

    public final void zzP(int i, int i2) throws IOException {
        zzo((i << 3) | 5);
        zzp(i2);
    }

    public final void zzQ(int i, long j) throws IOException {
        zzo(i << 3);
        zzq(j);
    }

    public final void zza(byte[] bArr, int i, int i2) throws IOException {
        zzs(bArr, 0, i2);
    }

    public final int zzb() {
        return this.zzb - this.zzc;
    }

    public final void zzh(int i, long j) throws IOException {
        zzo((i << 3) | 1);
        zzr(j);
    }

    public final void zzi(int i, boolean z) throws IOException {
        zzo(i << 3);
        zzm(z ? (byte) 1 : 0);
    }

    public final void zzj(int i, String str) throws IOException {
        zzo((i << 3) | 2);
        zzt(str);
    }

    public final void zzk(int i, zzyy zzyy) throws IOException {
        zzo((i << 3) | 2);
        zzo(zzyy.zzc());
        zzyy.zzg(this);
    }

    /* access modifiers changed from: package-private */
    public final void zzl(int i, zzabd zzabd, zzabp zzabp) throws IOException {
        zzo((i << 3) | 2);
        zzyj zzyj = (zzyj) zzabd;
        int zzq = zzyj.zzq();
        if (zzq == -1) {
            zzq = zzabp.zze(zzyj);
            zzyj.zzr(zzq);
        }
        zzo(zzq);
        zzabp.zzn(zzabd, this.zze);
    }

    public final void zzn(int i) throws IOException {
        if (i >= 0) {
            zzo(i);
        } else {
            zzq((long) i);
        }
    }

    public final void zzo(int i) throws IOException {
        if (zzzi.zzb) {
            int i2 = zzyl.zza;
        }
        while ((i & -128) != 0) {
            byte[] bArr = this.zza;
            int i3 = this.zzc;
            this.zzc = i3 + 1;
            bArr[i3] = (byte) ((i & 127) | 128);
            i >>>= 7;
        }
        try {
            byte[] bArr2 = this.zza;
            int i4 = this.zzc;
            this.zzc = i4 + 1;
            bArr2[i4] = (byte) i;
        } catch (IndexOutOfBoundsException e) {
            throw new zzzg(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1}), e);
        }
    }

    public final void zzp(int i) throws IOException {
        try {
            byte[] bArr = this.zza;
            int i2 = this.zzc;
            int i3 = i2 + 1;
            this.zzc = i3;
            bArr[i2] = (byte) (i & 255);
            int i4 = i3 + 1;
            this.zzc = i4;
            bArr[i3] = (byte) ((i >> 8) & 255);
            int i5 = i4 + 1;
            this.zzc = i5;
            bArr[i4] = (byte) ((i >> 16) & 255);
            this.zzc = i5 + 1;
            bArr[i5] = (byte) ((i >> 24) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new zzzg(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1}), e);
        }
    }

    public final void zzr(long j) throws IOException {
        try {
            byte[] bArr = this.zza;
            int i = this.zzc;
            int i2 = i + 1;
            this.zzc = i2;
            bArr[i] = (byte) (((int) j) & 255);
            int i3 = i2 + 1;
            this.zzc = i3;
            bArr[i2] = (byte) (((int) (j >> 8)) & 255);
            int i4 = i3 + 1;
            this.zzc = i4;
            bArr[i3] = (byte) (((int) (j >> 16)) & 255);
            int i5 = i4 + 1;
            this.zzc = i5;
            bArr[i4] = (byte) (((int) (j >> 24)) & 255);
            int i6 = i5 + 1;
            this.zzc = i6;
            bArr[i5] = (byte) (((int) (j >> 32)) & 255);
            int i7 = i6 + 1;
            this.zzc = i7;
            bArr[i6] = (byte) (((int) (j >> 40)) & 255);
            int i8 = i7 + 1;
            this.zzc = i8;
            bArr[i7] = (byte) (((int) (j >> 48)) & 255);
            this.zzc = i8 + 1;
            bArr[i8] = (byte) (((int) (j >> 56)) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new zzzg(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1}), e);
        }
    }

    public final void zzt(String str) throws IOException {
        int i = this.zzc;
        try {
            int zzA = zzA(str.length() * 3);
            int zzA2 = zzA(str.length());
            if (zzA2 == zzA) {
                int i2 = i + zzA2;
                this.zzc = i2;
                int zzd = zzacs.zzd(str, this.zza, i2, this.zzb - i2);
                this.zzc = i;
                zzo((zzd - i) - zzA2);
                this.zzc = zzd;
                return;
            }
            zzo(zzacs.zzc(str));
            byte[] bArr = this.zza;
            int i3 = this.zzc;
            this.zzc = zzacs.zzd(str, bArr, i3, this.zzb - i3);
        } catch (zzacr e) {
            this.zzc = i;
            zzH(str, e);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzzg(e2);
        }
    }

    public final void zzu() {
    }

    zzzf(byte[] bArr, int i, int i2) {
        super((zzzd) null);
        int length = bArr.length;
        if (((length - i2) | i2) >= 0) {
            this.zza = bArr;
            this.zzc = 0;
            this.zzb = i2;
            return;
        }
        throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(length), 0, Integer.valueOf(i2)}));
    }

    public final void zzm(byte b) throws IOException {
        try {
            byte[] bArr = this.zza;
            int i = this.zzc;
            this.zzc = i + 1;
            bArr[i] = b;
        } catch (IndexOutOfBoundsException e) {
            throw new zzzg(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1}), e);
        }
    }

    public final void zzs(byte[] bArr, int i, int i2) throws IOException {
        try {
            System.arraycopy(bArr, 0, this.zza, this.zzc, i2);
            this.zzc += i2;
        } catch (IndexOutOfBoundsException e) {
            throw new zzzg(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), Integer.valueOf(i2)}), e);
        }
    }

    public final void zzq(long j) throws IOException {
        if (!zzzi.zzb || this.zzb - this.zzc < 10) {
            while ((j & -128) != 0) {
                byte[] bArr = this.zza;
                int i = this.zzc;
                this.zzc = i + 1;
                bArr[i] = (byte) ((((int) j) & 127) | 128);
                j >>>= 7;
            }
            try {
                byte[] bArr2 = this.zza;
                int i2 = this.zzc;
                this.zzc = i2 + 1;
                bArr2[i2] = (byte) ((int) j);
            } catch (IndexOutOfBoundsException e) {
                throw new zzzg(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1}), e);
            }
        } else {
            while ((j & -128) != 0) {
                byte[] bArr3 = this.zza;
                int i3 = this.zzc;
                this.zzc = i3 + 1;
                zzacn.zzp(bArr3, (long) i3, (byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            byte[] bArr4 = this.zza;
            int i4 = this.zzc;
            this.zzc = i4 + 1;
            zzacn.zzp(bArr4, (long) i4, (byte) ((int) j));
        }
    }
}
