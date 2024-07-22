package com.google.android.gms.internal.p001firebaseauthapi;

import java.io.IOException;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzzj {
    private final zzzi zza;

    private zzzj(zzzi zzzi) {
        zzaag.zzb(zzzi, "output");
        this.zza = zzzi;
        zzzi.zze = this;
    }

    public static zzzj zza(zzzi zzzi) {
        zzzj zzzj = zzzi.zze;
        return zzzj != null ? zzzj : new zzzj(zzzi);
    }

    public final void zzE(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzaan) {
            zzaan zzaan = (zzaan) list;
            while (i2 < list.size()) {
                Object zzg = zzaan.zzg(i2);
                if (zzg instanceof String) {
                    this.zza.zzj(i, (String) zzg);
                } else {
                    this.zza.zzk(i, (zzyy) zzg);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzj(i, list.get(i2));
            i2++;
        }
    }

    public final void zzF(int i, List<zzyy> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zzk(i, list.get(i2));
        }
    }

    public final void zzb(int i, int i2) throws IOException {
        this.zza.zzP(i, i2);
    }

    public final void zzc(int i, long j) throws IOException {
        this.zza.zzQ(i, j);
    }

    public final void zzd(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    public final void zze(int i, float f) throws IOException {
        this.zza.zzP(i, Float.floatToRawIntBits(f));
    }

    public final void zzf(int i, double d) throws IOException {
        this.zza.zzh(i, Double.doubleToRawLongBits(d));
    }

    public final void zzg(int i, int i2) throws IOException {
        this.zza.zzN(i, i2);
    }

    public final void zzh(int i, long j) throws IOException {
        this.zza.zzQ(i, j);
    }

    public final void zzi(int i, int i2) throws IOException {
        this.zza.zzN(i, i2);
    }

    public final void zzj(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    public final void zzk(int i, int i2) throws IOException {
        this.zza.zzP(i, i2);
    }

    public final void zzl(int i, boolean z) throws IOException {
        this.zza.zzi(i, z);
    }

    public final void zzm(int i, String str) throws IOException {
        this.zza.zzj(i, str);
    }

    public final void zzn(int i, zzyy zzyy) throws IOException {
        this.zza.zzk(i, zzyy);
    }

    public final void zzo(int i, int i2) throws IOException {
        this.zza.zzO(i, i2);
    }

    public final void zzp(int i, int i2) throws IOException {
        this.zza.zzO(i, (i2 >> 31) ^ (i2 + i2));
    }

    public final void zzq(int i, long j) throws IOException {
        this.zza.zzQ(i, (j >> 63) ^ (j + j));
    }

    public final void zzr(int i, Object obj, zzabp zzabp) throws IOException {
        this.zza.zzl(i, (zzabd) obj, zzabp);
    }

    public final void zzs(int i, Object obj, zzabp zzabp) throws IOException {
        zzzi zzzi = this.zza;
        zzzi.zzM(i, 3);
        zzabp.zzn((zzabd) obj, zzzi.zze);
        zzzi.zzM(i, 4);
    }

    public final void zzt(int i) throws IOException {
        this.zza.zzM(i, 3);
    }

    public final void zzu(int i) throws IOException {
        this.zza.zzM(i, 4);
    }

    public final void zzC(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzM(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzzi.zzz(list.get(i4).intValue());
            }
            this.zza.zzo(i3);
            while (i2 < list.size()) {
                this.zza.zzn(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzN(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzD(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzM(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                list.get(i4).booleanValue();
                i3++;
            }
            this.zza.zzo(i3);
            while (i2 < list.size()) {
                this.zza.zzm(list.get(i2).booleanValue() ? (byte) 1 : 0);
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzi(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    public final void zzG(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzM(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzzi.zzA(list.get(i4).intValue());
            }
            this.zza.zzo(i3);
            while (i2 < list.size()) {
                this.zza.zzo(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzO(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzH(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzM(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                list.get(i4).intValue();
                i3 += 4;
            }
            this.zza.zzo(i3);
            while (i2 < list.size()) {
                this.zza.zzp(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzP(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzI(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzM(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                list.get(i4).longValue();
                i3 += 8;
            }
            this.zza.zzo(i3);
            while (i2 < list.size()) {
                this.zza.zzr(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzh(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzJ(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzM(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                int intValue = list.get(i4).intValue();
                i3 += zzzi.zzA((intValue >> 31) ^ (intValue + intValue));
            }
            this.zza.zzo(i3);
            while (i2 < list.size()) {
                zzzi zzzi = this.zza;
                int intValue2 = list.get(i2).intValue();
                zzzi.zzo((intValue2 >> 31) ^ (intValue2 + intValue2));
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            zzzi zzzi2 = this.zza;
            int intValue3 = list.get(i2).intValue();
            zzzi2.zzO(i, (intValue3 >> 31) ^ (intValue3 + intValue3));
            i2++;
        }
    }

    public final void zzK(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzM(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                long longValue = list.get(i4).longValue();
                i3 += zzzi.zzB((longValue >> 63) ^ (longValue + longValue));
            }
            this.zza.zzo(i3);
            while (i2 < list.size()) {
                zzzi zzzi = this.zza;
                long longValue2 = list.get(i2).longValue();
                zzzi.zzq((longValue2 >> 63) ^ (longValue2 + longValue2));
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            zzzi zzzi2 = this.zza;
            long longValue3 = list.get(i2).longValue();
            zzzi2.zzQ(i, (longValue3 >> 63) ^ (longValue3 + longValue3));
            i2++;
        }
    }

    public final void zzv(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzM(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzzi.zzz(list.get(i4).intValue());
            }
            this.zza.zzo(i3);
            while (i2 < list.size()) {
                this.zza.zzn(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzN(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzw(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzM(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                list.get(i4).intValue();
                i3 += 4;
            }
            this.zza.zzo(i3);
            while (i2 < list.size()) {
                this.zza.zzp(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzP(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzx(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzM(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzzi.zzB(list.get(i4).longValue());
            }
            this.zza.zzo(i3);
            while (i2 < list.size()) {
                this.zza.zzq(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzQ(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzy(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzM(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzzi.zzB(list.get(i4).longValue());
            }
            this.zza.zzo(i3);
            while (i2 < list.size()) {
                this.zza.zzq(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzQ(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzz(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzM(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                list.get(i4).longValue();
                i3 += 8;
            }
            this.zza.zzo(i3);
            while (i2 < list.size()) {
                this.zza.zzr(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzh(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzA(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzM(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                list.get(i4).floatValue();
                i3 += 4;
            }
            this.zza.zzo(i3);
            while (i2 < list.size()) {
                this.zza.zzp(Float.floatToRawIntBits(list.get(i2).floatValue()));
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzP(i, Float.floatToRawIntBits(list.get(i2).floatValue()));
            i2++;
        }
    }

    public final void zzB(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzM(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                list.get(i4).doubleValue();
                i3 += 8;
            }
            this.zza.zzo(i3);
            while (i2 < list.size()) {
                this.zza.zzr(Double.doubleToRawLongBits(list.get(i2).doubleValue()));
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzh(i, Double.doubleToRawLongBits(list.get(i2).doubleValue()));
            i2++;
        }
    }
}
