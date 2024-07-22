package com.google.android.gms.internal.p001firebaseauthapi;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabr  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzabr {
    private static final Class<?> zza;
    private static final zzacd<?, ?> zzb = zzab(false);
    private static final zzacd<?, ?> zzc = zzab(true);
    private static final zzacd<?, ?> zzd = new zzacf();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable th) {
            cls = null;
        }
        zza = cls;
    }

    public static zzacd<?, ?> zzA() {
        return zzb;
    }

    public static zzacd<?, ?> zzB() {
        return zzc;
    }

    public static zzacd<?, ?> zzC() {
        return zzd;
    }

    static boolean zzD(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static <T, FT extends zzzr<FT>> void zzE(zzzo<FT> zzzo, T t, T t2) {
        zzzo.zzb(t2);
        throw null;
    }

    static <T, UT, UB> void zzF(zzacd<UT, UB> zzacd, T t, T t2) {
        zzacd.zzi(t, zzacd.zzo(zzacd.zzj(t), zzacd.zzj(t2)));
    }

    static <UT, UB> UB zzG(int i, List<Integer> list, zzaae zzaae, UB ub, zzacd<UT, UB> zzacd) {
        if (zzaae == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzaae.zza()) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = zzH(i, intValue, ub, zzacd);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
                return ub;
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzaae.zza()) {
                    ub = zzH(i, intValue2, ub, zzacd);
                    it.remove();
                }
            }
        }
        return ub;
    }

    static <UT, UB> UB zzH(int i, int i2, UB ub, zzacd<UT, UB> zzacd) {
        if (ub == null) {
            ub = zzacd.zzg();
        }
        zzacd.zzb(ub, i, (long) i2);
        return ub;
    }

    static <T> void zzI(zzaay zzaay, T t, T t2, long j) {
        zzacn.zzo(t, j, zzaay.zzc(zzacn.zzn(t, j), zzacn.zzn(t2, j)));
    }

    public static void zzJ(int i, List<Double> list, zzzj zzzj, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzj.zzB(i, list, z);
        }
    }

    public static void zzK(int i, List<Float> list, zzzj zzzj, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzj.zzA(i, list, z);
        }
    }

    public static void zzL(int i, List<Long> list, zzzj zzzj, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzj.zzx(i, list, z);
        }
    }

    public static void zzM(int i, List<Long> list, zzzj zzzj, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzj.zzy(i, list, z);
        }
    }

    public static void zzN(int i, List<Long> list, zzzj zzzj, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzj.zzK(i, list, z);
        }
    }

    public static void zzO(int i, List<Long> list, zzzj zzzj, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzj.zzz(i, list, z);
        }
    }

    public static void zzP(int i, List<Long> list, zzzj zzzj, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzj.zzI(i, list, z);
        }
    }

    public static void zzQ(int i, List<Integer> list, zzzj zzzj, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzj.zzv(i, list, z);
        }
    }

    public static void zzR(int i, List<Integer> list, zzzj zzzj, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzj.zzG(i, list, z);
        }
    }

    public static void zzS(int i, List<Integer> list, zzzj zzzj, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzj.zzJ(i, list, z);
        }
    }

    public static void zzT(int i, List<Integer> list, zzzj zzzj, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzj.zzw(i, list, z);
        }
    }

    public static void zzU(int i, List<Integer> list, zzzj zzzj, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzj.zzH(i, list, z);
        }
    }

    public static void zzV(int i, List<Integer> list, zzzj zzzj, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzj.zzC(i, list, z);
        }
    }

    public static void zzW(int i, List<Boolean> list, zzzj zzzj, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzj.zzD(i, list, z);
        }
    }

    public static void zzX(int i, List<String> list, zzzj zzzj) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzj.zzE(i, list);
        }
    }

    public static void zzY(int i, List<zzyy> list, zzzj zzzj) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzzj.zzF(i, list);
        }
    }

    public static void zzZ(int i, List<?> list, zzzj zzzj, zzabp zzabp) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                zzzj.zzr(i, list.get(i2), zzabp);
            }
        }
    }

    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzaaa.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzaa(int i, List<?> list, zzzj zzzj, zzabp zzabp) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                zzzj.zzs(i, list.get(i2), zzabp);
            }
        }
    }

    private static zzacd<?, ?> zzab(boolean z) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable th) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (zzacd) cls.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable th2) {
            return null;
        }
    }

    static int zzb(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzaas) {
            zzaas zzaas = (zzaas) list;
            i = 0;
            while (i2 < size) {
                i += zzzi.zzB(zzaas.zzd(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzzi.zzB(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzc(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzb(list) + (list.size() * zzzi.zzy(i));
    }

    static int zzd(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzaas) {
            zzaas zzaas = (zzaas) list;
            i = 0;
            while (i2 < size) {
                i += zzzi.zzB(zzaas.zzd(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzzi.zzB(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zze(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzzi.zzy(i));
    }

    static int zzf(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzaas) {
            zzaas zzaas = (zzaas) list;
            i = 0;
            while (i2 < size) {
                long zzd2 = zzaas.zzd(i2);
                i += zzzi.zzB((zzd2 >> 63) ^ (zzd2 + zzd2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                long longValue = list.get(i2).longValue();
                i3 = i + zzzi.zzB((longValue >> 63) ^ (longValue + longValue));
                i2++;
            }
        }
        return i;
    }

    static int zzg(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzf(list) + (size * zzzi.zzy(i));
    }

    static int zzh(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzaab) {
            zzaab zzaab = (zzaab) list;
            i = 0;
            while (i2 < size) {
                i += zzzi.zzz(zzaab.zzd(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzzi.zzz(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzi(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzh(list) + (size * zzzi.zzy(i));
    }

    static int zzj(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzaab) {
            zzaab zzaab = (zzaab) list;
            i = 0;
            while (i2 < size) {
                i += zzzi.zzz(zzaab.zzd(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzzi.zzz(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzk(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzj(list) + (size * zzzi.zzy(i));
    }

    static int zzl(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzaab) {
            zzaab zzaab = (zzaab) list;
            i = 0;
            while (i2 < size) {
                i += zzzi.zzA(zzaab.zzd(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzzi.zzA(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzm(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzl(list) + (size * zzzi.zzy(i));
    }

    static int zzn(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzaab) {
            zzaab zzaab = (zzaab) list;
            i = 0;
            while (i2 < size) {
                int zzd2 = zzaab.zzd(i2);
                i += zzzi.zzA((zzd2 >> 31) ^ (zzd2 + zzd2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                int intValue = list.get(i2).intValue();
                i3 = i + zzzi.zzA((intValue >> 31) ^ (intValue + intValue));
                i2++;
            }
        }
        return i;
    }

    static int zzo(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzn(list) + (size * zzzi.zzy(i));
    }

    static int zzp(List<?> list) {
        return list.size() * 4;
    }

    static int zzq(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzzi.zzA(i << 3) + 4);
    }

    static int zzr(List<?> list) {
        return list.size() * 8;
    }

    static int zzs(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzzi.zzA(i << 3) + 8);
    }

    static int zzt(List<?> list) {
        return list.size();
    }

    static int zzu(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzzi.zzA(i << 3) + 1);
    }

    static int zzv(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zzy = zzzi.zzy(i) * size;
        if (list instanceof zzaan) {
            zzaan zzaan = (zzaan) list;
            while (i4 < size) {
                Object zzg = zzaan.zzg(i4);
                if (zzg instanceof zzyy) {
                    i3 = zzzi.zzE((zzyy) zzg);
                } else {
                    i3 = zzzi.zzC((String) zzg);
                }
                zzy += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzyy) {
                    i2 = zzzi.zzE((zzyy) obj);
                } else {
                    i2 = zzzi.zzC((String) obj);
                }
                zzy += i2;
                i4++;
            }
        }
        return zzy;
    }

    static int zzw(int i, Object obj, zzabp zzabp) {
        if (!(obj instanceof zzaal)) {
            return zzzi.zzA(i << 3) + zzzi.zzF((zzabd) obj, zzabp);
        }
        int zzA = zzzi.zzA(i << 3);
        int zza2 = ((zzaal) obj).zza();
        return zzA + zzzi.zzA(zza2) + zza2;
    }

    static int zzx(int i, List<?> list, zzabp zzabp) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzy = zzzi.zzy(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzaal) {
                i2 = zzzi.zzD((zzaal) obj);
            } else {
                i2 = zzzi.zzF((zzabd) obj, zzabp);
            }
            zzy += i2;
        }
        return zzy;
    }

    static int zzy(int i, List<zzyy> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzy = size * zzzi.zzy(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzy += zzzi.zzE(list.get(i2));
        }
        return zzy;
    }

    static int zzz(int i, List<zzabd> list, zzabp zzabp) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzzi.zzI(i, list.get(i3), zzabp);
        }
        return i2;
    }
}
