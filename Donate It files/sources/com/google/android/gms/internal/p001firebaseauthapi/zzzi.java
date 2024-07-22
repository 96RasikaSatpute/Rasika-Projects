package com.google.android.gms.internal.p001firebaseauthapi;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzi  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public abstract class zzzi extends zzyp {
    private static final Logger zza = Logger.getLogger(zzzi.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzb = zzacn.zza();
    zzzj zze;

    private zzzi() {
    }

    /* synthetic */ zzzi(zzzd zzzd) {
    }

    public static int zzA(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public static int zzB(long j) {
        int i;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            j >>>= 28;
            i = 6;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & -16384) != 0 ? i + 1 : i;
    }

    public static int zzC(String str) {
        int i;
        try {
            i = zzacs.zzc(str);
        } catch (zzacr e) {
            i = str.getBytes(zzaag.zza).length;
        }
        return zzA(i) + i;
    }

    public static int zzD(zzaal zzaal) {
        int zza2 = zzaal.zza();
        return zzA(zza2) + zza2;
    }

    public static int zzE(zzyy zzyy) {
        int zzc = zzyy.zzc();
        return zzA(zzc) + zzc;
    }

    static int zzF(zzabd zzabd, zzabp zzabp) {
        zzyj zzyj = (zzyj) zzabd;
        int zzq = zzyj.zzq();
        if (zzq == -1) {
            zzq = zzabp.zze(zzyj);
            zzyj.zzr(zzq);
        }
        return zzA(zzq) + zzq;
    }

    @Deprecated
    static int zzI(int i, zzabd zzabd, zzabp zzabp) {
        int zzA = zzA(i << 3);
        int i2 = zzA + zzA;
        zzyj zzyj = (zzyj) zzabd;
        int zzq = zzyj.zzq();
        if (zzq == -1) {
            zzq = zzabp.zze(zzyj);
            zzyj.zzr(zzq);
        }
        return i2 + zzq;
    }

    static int zzv(int i) {
        if (i > 4096) {
            return 4096;
        }
        return i;
    }

    public static zzzi zzw(OutputStream outputStream, int i) {
        return new zzzh(outputStream, i);
    }

    public static zzzi zzx(byte[] bArr) {
        return new zzzf(bArr, 0, bArr.length);
    }

    public static int zzy(int i) {
        return zzA(i << 3);
    }

    public static int zzz(int i) {
        if (i >= 0) {
            return zzA(i);
        }
        return 10;
    }

    public final void zzG() {
        if (zzb() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzH(String str, zzacr zzacr) throws IOException {
        zza.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzacr);
        byte[] bytes = str.getBytes(zzaag.zza);
        try {
            int length = bytes.length;
            zzo(length);
            zza(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzzg(e);
        } catch (zzzg e2) {
            throw e2;
        }
    }

    public abstract void zzM(int i, int i2) throws IOException;

    public abstract void zzN(int i, int i2) throws IOException;

    public abstract void zzO(int i, int i2) throws IOException;

    public abstract void zzP(int i, int i2) throws IOException;

    public abstract void zzQ(int i, long j) throws IOException;

    public abstract void zza(byte[] bArr, int i, int i2) throws IOException;

    public abstract int zzb();

    public abstract void zzh(int i, long j) throws IOException;

    public abstract void zzi(int i, boolean z) throws IOException;

    public abstract void zzj(int i, String str) throws IOException;

    public abstract void zzk(int i, zzyy zzyy) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zzl(int i, zzabd zzabd, zzabp zzabp) throws IOException;

    public abstract void zzm(byte b) throws IOException;

    public abstract void zzn(int i) throws IOException;

    public abstract void zzo(int i) throws IOException;

    public abstract void zzp(int i) throws IOException;

    public abstract void zzq(long j) throws IOException;

    public abstract void zzr(long j) throws IOException;

    public abstract void zzu() throws IOException;
}
