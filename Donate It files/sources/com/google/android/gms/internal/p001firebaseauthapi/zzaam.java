package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaam  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzaam extends zzyk<String> implements RandomAccess, zzaan {
    public static final zzaan zza;
    private static final zzaam zzb;
    private final List<Object> zzc;

    static {
        zzaam zzaam = new zzaam(10);
        zzb = zzaam;
        zzaam.zzb();
        zza = zzaam;
    }

    public zzaam() {
        this(10);
    }

    private static String zzj(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzyy) {
            return ((zzyy) obj).zzq(zzaag.zza);
        }
        return zzaag.zzd((byte[]) obj);
    }

    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        zzc();
        this.zzc.add(i, (String) obj);
        this.modCount++;
    }

    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzc();
        if (collection instanceof zzaan) {
            collection = ((zzaan) collection).zzh();
        }
        boolean addAll = this.zzc.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        zzc();
        this.zzc.clear();
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zzc();
        Object remove = this.zzc.remove(i);
        this.modCount++;
        return zzj(remove);
    }

    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        zzc();
        return zzj(this.zzc.set(i, (String) obj));
    }

    public final int size() {
        return this.zzc.size();
    }

    /* renamed from: zzd */
    public final String get(int i) {
        Object obj = this.zzc.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzyy) {
            zzyy zzyy = (zzyy) obj;
            String zzq = zzyy.zzq(zzaag.zza);
            if (zzyy.zzi()) {
                this.zzc.set(i, zzq);
            }
            return zzq;
        }
        byte[] bArr = (byte[]) obj;
        String zzd = zzaag.zzd(bArr);
        if (zzaag.zzc(bArr)) {
            this.zzc.set(i, zzd);
        }
        return zzd;
    }

    public final /* bridge */ /* synthetic */ zzaaf zze(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzc);
            return new zzaam((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final void zzf(zzyy zzyy) {
        zzc();
        this.zzc.add(zzyy);
        this.modCount++;
    }

    public final Object zzg(int i) {
        return this.zzc.get(i);
    }

    public final List<?> zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final zzaan zzi() {
        return zza() ? new zzaci(this) : this;
    }

    public zzaam(int i) {
        this.zzc = new ArrayList(i);
    }

    private zzaam(ArrayList<Object> arrayList) {
        this.zzc = arrayList;
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }
}
