package com.google.android.gms.internal.p001firebaseauthapi;

import com.miniproject.bhojanamv3.utils.Constants;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacn  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzacn {
    static final long zza = ((long) zzz(byte[].class));
    static final boolean zzb;
    private static final Unsafe zzc;
    private static final Class<?> zzd = zzyl.zza();
    private static final boolean zze;
    private static final boolean zzf;
    private static final zzacm zzg;
    private static final boolean zzh;
    private static final boolean zzi;

    static {
        boolean z;
        boolean z2;
        zzacm zzacm;
        Class<double[]> cls = double[].class;
        Class<float[]> cls2 = float[].class;
        Class<long[]> cls3 = long[].class;
        Class<int[]> cls4 = int[].class;
        Class<boolean[]> cls5 = boolean[].class;
        Unsafe zzq = zzq();
        zzc = zzq;
        boolean zzr = zzr(Long.TYPE);
        zze = zzr;
        boolean zzr2 = zzr(Integer.TYPE);
        zzf = zzr2;
        zzacm zzacm2 = null;
        if (zzq != null) {
            if (zzr) {
                zzacm2 = new zzacl(zzq);
            } else if (zzr2) {
                zzacm2 = new zzack(zzq);
            }
        }
        zzg = zzacm2;
        boolean z3 = true;
        if (zzacm2 == null) {
            z = false;
        } else {
            Unsafe unsafe = zzacm2.zza;
            if (unsafe == null) {
                z = false;
            } else {
                try {
                    Class<?> cls6 = unsafe.getClass();
                    cls6.getMethod("objectFieldOffset", new Class[]{Field.class});
                    cls6.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
                    z = zzB() != null;
                } catch (Throwable th) {
                    zzs(th);
                    z = false;
                }
            }
        }
        zzh = z;
        zzacm zzacm3 = zzg;
        if (zzacm3 == null) {
            z2 = false;
        } else {
            Unsafe unsafe2 = zzacm3.zza;
            if (unsafe2 == null) {
                z2 = false;
            } else {
                try {
                    Class<?> cls7 = unsafe2.getClass();
                    cls7.getMethod("objectFieldOffset", new Class[]{Field.class});
                    cls7.getMethod("arrayBaseOffset", new Class[]{Class.class});
                    cls7.getMethod("arrayIndexScale", new Class[]{Class.class});
                    cls7.getMethod("getInt", new Class[]{Object.class, Long.TYPE});
                    cls7.getMethod("putInt", new Class[]{Object.class, Long.TYPE, Integer.TYPE});
                    cls7.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
                    cls7.getMethod("putLong", new Class[]{Object.class, Long.TYPE, Long.TYPE});
                    cls7.getMethod("getObject", new Class[]{Object.class, Long.TYPE});
                    cls7.getMethod("putObject", new Class[]{Object.class, Long.TYPE, Object.class});
                    z2 = true;
                } catch (Throwable th2) {
                    zzs(th2);
                    z2 = false;
                }
            }
        }
        zzi = z2;
        zzz(cls5);
        zzA(cls5);
        zzz(cls4);
        zzA(cls4);
        zzz(cls3);
        zzA(cls3);
        zzz(cls2);
        zzA(cls2);
        zzz(cls);
        zzA(cls);
        zzz(Object[].class);
        zzA(Object[].class);
        Field zzB = zzB();
        if (!(zzB == null || (zzacm = zzg) == null)) {
            zzacm.zzh(zzB);
        }
        if (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN) {
            z3 = false;
        }
        zzb = z3;
    }

    private zzacn() {
    }

    private static int zzA(Class<?> cls) {
        if (zzi) {
            return zzg.zzj(cls);
        }
        return -1;
    }

    private static Field zzB() {
        int i = zzyl.zza;
        Field zzC = zzC(Buffer.class, "effectiveDirectAddress");
        if (zzC != null) {
            return zzC;
        }
        Field zzC2 = zzC(Buffer.class, Constants.ADDRESS);
        if (zzC2 == null || zzC2.getType() != Long.TYPE) {
            return null;
        }
        return zzC2;
    }

    private static Field zzC(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable th) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static void zzD(Object obj, long j, byte b) {
        long j2 = -4 & j;
        zzacm zzacm = zzg;
        int zzk = zzacm.zzk(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zzacm.zzl(obj, j2, ((255 & b) << i) | (zzk & (~(255 << i))));
    }

    /* access modifiers changed from: private */
    public static void zzE(Object obj, long j, byte b) {
        long j2 = -4 & j;
        zzacm zzacm = zzg;
        int i = (((int) j) & 3) << 3;
        zzacm.zzl(obj, j2, ((255 & b) << i) | (zzacm.zzk(obj, j2) & (~(255 << i))));
    }

    static boolean zza() {
        return zzi;
    }

    static boolean zzb() {
        return zzh;
    }

    static <T> T zzc(Class<T> cls) {
        try {
            return zzc.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    static int zzd(Object obj, long j) {
        return zzg.zzk(obj, j);
    }

    static void zze(Object obj, long j, int i) {
        zzg.zzl(obj, j, i);
    }

    static long zzf(Object obj, long j) {
        return zzg.zzm(obj, j);
    }

    static void zzg(Object obj, long j, long j2) {
        zzg.zzn(obj, j, j2);
    }

    static boolean zzh(Object obj, long j) {
        return zzg.zzb(obj, j);
    }

    static void zzi(Object obj, long j, boolean z) {
        zzg.zzc(obj, j, z);
    }

    static float zzj(Object obj, long j) {
        return zzg.zzd(obj, j);
    }

    static void zzk(Object obj, long j, float f) {
        zzg.zze(obj, j, f);
    }

    static double zzl(Object obj, long j) {
        return zzg.zzf(obj, j);
    }

    static void zzm(Object obj, long j, double d) {
        zzg.zzg(obj, j, d);
    }

    static Object zzn(Object obj, long j) {
        return zzg.zzo(obj, j);
    }

    static void zzo(Object obj, long j, Object obj2) {
        zzg.zzp(obj, j, obj2);
    }

    static void zzp(byte[] bArr, long j, byte b) {
        zzg.zza(bArr, zza + j, b);
    }

    static Unsafe zzq() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzacj());
        } catch (Throwable th) {
            return null;
        }
    }

    static boolean zzr(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        int i = zzyl.zza;
        try {
            Class<?> cls3 = zzd;
            cls3.getMethod("peekLong", new Class[]{cls, Boolean.TYPE});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, Boolean.TYPE});
            cls3.getMethod("pokeInt", new Class[]{cls, Integer.TYPE, Boolean.TYPE});
            cls3.getMethod("peekInt", new Class[]{cls, Boolean.TYPE});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, Integer.TYPE, Integer.TYPE});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, Integer.TYPE, Integer.TYPE});
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    static /* synthetic */ void zzs(Throwable th) {
        Logger logger = Logger.getLogger(zzacn.class.getName());
        Level level = Level.WARNING;
        String valueOf = String.valueOf(th);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
        sb.append("platform method missing - proto runtime falling back to safer methods: ");
        sb.append(valueOf);
        logger.logp(level, "com.google.protobuf.UnsafeUtil", "logMissingMethod", sb.toString());
    }

    static /* synthetic */ boolean zzv(Object obj, long j) {
        return ((byte) ((zzg.zzk(obj, -4 & j) >>> ((int) (((~j) & 3) << 3))) & 255)) != 0;
    }

    static /* synthetic */ boolean zzw(Object obj, long j) {
        return ((byte) ((zzg.zzk(obj, -4 & j) >>> ((int) ((j & 3) << 3))) & 255)) != 0;
    }

    private static int zzz(Class<?> cls) {
        if (zzi) {
            return zzg.zzi(cls);
        }
        return -1;
    }
}
