package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzaaa;
import com.google.android.gms.internal.p001firebaseauthapi.zzzw;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaaa  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public abstract class zzaaa<MessageType extends zzaaa<MessageType, BuilderType>, BuilderType extends zzzw<MessageType, BuilderType>> extends zzyj<MessageType, BuilderType> {
    private static final Map<Object, zzaaa<?, ?>> zzb = new ConcurrentHashMap();
    protected zzace zzc = zzace.zza();
    protected int zzd = -1;

    static Object zzA(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static <E> zzaaf<E> zzB() {
        return zzabm.zzd();
    }

    protected static <E> zzaaf<E> zzC(zzaaf<E> zzaaf) {
        int i;
        int size = zzaaf.size();
        if (size == 0) {
            i = 10;
        } else {
            i = size + size;
        }
        return zzaaf.zze(i);
    }

    static <T extends zzaaa<T, ?>> T zzD(T t, byte[] bArr, int i, int i2, zzzn zzzn) throws zzaai {
        T t2 = (zzaaa) t.zzj(4, (Object) null, (Object) null);
        try {
            zzabp<?> zzb2 = zzabl.zza().zzb(t2.getClass());
            zzb2.zzi(t2, bArr, 0, i2, new zzym(zzzn));
            zzb2.zzj(t2);
            if (t2.zza == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (zzaai e) {
            e.zza(t2);
            throw e;
        } catch (IOException e2) {
            if (e2.getCause() instanceof zzaai) {
                throw ((zzaai) e2.getCause());
            }
            zzaai zzaai = new zzaai(e2);
            zzaai.zza(t2);
            throw zzaai;
        } catch (IndexOutOfBoundsException e3) {
            zzaai zzb3 = zzaai.zzb();
            zzb3.zza(t2);
            throw zzb3;
        }
    }

    protected static <T extends zzaaa<T, ?>> T zzE(T t, zzyy zzyy, zzzn zzzn) throws zzaai {
        T t2;
        try {
            zzzb zzk = zzyy.zzk();
            t2 = (zzaaa) t.zzj(4, (Object) null, (Object) null);
            zzabp<?> zzb2 = zzabl.zza().zzb(t2.getClass());
            zzb2.zzf(t2, zzzc.zza(zzk), zzzn);
            zzb2.zzj(t2);
            zzk.zzb(0);
            zza(t2);
            return t2;
        } catch (zzaai e) {
            e.zza(t2);
            throw e;
        } catch (IOException e2) {
            if (e2.getCause() instanceof zzaai) {
                throw ((zzaai) e2.getCause());
            }
            zzaai zzaai = new zzaai(e2);
            zzaai.zza(t2);
            throw zzaai;
        } catch (RuntimeException e3) {
            if (e3.getCause() instanceof zzaai) {
                throw ((zzaai) e3.getCause());
            }
            throw e3;
        } catch (zzaai e4) {
            e4.zza(t2);
            throw e4;
        } catch (zzaai e5) {
            throw e5;
        }
    }

    protected static <T extends zzaaa<T, ?>> T zzF(T t, byte[] bArr, zzzn zzzn) throws zzaai {
        T zzD = zzD(t, bArr, 0, bArr.length, zzzn);
        zza(zzD);
        return zzD;
    }

    private static <T extends zzaaa<T, ?>> T zza(T t) throws zzaai {
        if (t == null || t.zzt()) {
            return t;
        }
        zzaai zzaai = new zzaai(new zzacc(t).getMessage());
        zzaai.zza(t);
        throw zzaai;
    }

    static <T extends zzaaa> T zzx(Class<T> cls) {
        Map<Object, zzaaa<?, ?>> map = zzb;
        T t = (zzaaa) map.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzaaa) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzaaa) ((zzaaa) zzacn.zzc(cls)).zzj(6, (Object) null, (Object) null);
            if (t != null) {
                map.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends zzaaa> void zzy(Class<T> cls, T t) {
        zzb.put(cls, t);
    }

    protected static Object zzz(zzabd zzabd, String str, Object[] objArr) {
        return new zzabn(zzabd, str, objArr);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzabl.zza().zzb(getClass()).zzb(this, (zzaaa) obj);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int zzc2 = zzabl.zza().zzb(getClass()).zzc(this);
        this.zza = zzc2;
        return zzc2;
    }

    public final String toString() {
        return zzabf.zza(this, super.toString());
    }

    public final /* bridge */ /* synthetic */ zzabc zzG() {
        zzzw zzzw = (zzzw) zzj(5, (Object) null, (Object) null);
        zzzw.zzm(this);
        return zzzw;
    }

    public final /* bridge */ /* synthetic */ zzabc zzH() {
        return (zzzw) zzj(5, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public abstract Object zzj(int i, Object obj, Object obj2);

    public final /* bridge */ /* synthetic */ zzabd zzo() {
        return (zzaaa) zzj(6, (Object) null, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final int zzq() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final void zzr(int i) {
        this.zzd = i;
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends zzaaa<MessageType, BuilderType>, BuilderType extends zzzw<MessageType, BuilderType>> BuilderType zzs() {
        return (zzzw) zzj(5, (Object) null, (Object) null);
    }

    public final boolean zzt() {
        zzaaa zzaaa;
        boolean booleanValue = Boolean.TRUE.booleanValue();
        byte byteValue = ((Byte) zzj(1, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzk = zzabl.zza().zzb(getClass()).zzk(this);
        if (!booleanValue) {
            return zzk;
        }
        if (true != zzk) {
            zzaaa = null;
        } else {
            zzaaa = this;
        }
        zzj(2, zzaaa, (Object) null);
        return zzk;
    }

    public final BuilderType zzu() {
        BuilderType buildertype = (zzzw) zzj(5, (Object) null, (Object) null);
        buildertype.zzm(this);
        return buildertype;
    }

    public final void zzv(zzzi zzzi) throws IOException {
        zzabl.zza().zzb(getClass()).zzn(this, zzzj.zza(zzzi));
    }

    public final int zzw() {
        int i = this.zzd;
        if (i != -1) {
            return i;
        }
        int zze = zzabl.zza().zzb(getClass()).zze(this);
        this.zzd = zze;
        return zze;
    }
}
