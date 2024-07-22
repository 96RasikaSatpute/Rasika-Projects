package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaap  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzaap extends zzaar {
    private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzaap() {
        super((zzaao) null);
    }

    /* synthetic */ zzaap(zzaao zzaao) {
        super((zzaao) null);
    }

    private static <L> List<L> zzf(Object obj, long j, int i) {
        List<L> list;
        List<L> list2 = (List) zzacn.zzn(obj, j);
        if (list2.isEmpty()) {
            if (list2 instanceof zzaan) {
                list = new zzaam(i);
            } else if (!(list2 instanceof zzabk) || !(list2 instanceof zzaaf)) {
                list = new ArrayList<>(i);
            } else {
                list = ((zzaaf) list2).zze(i);
            }
            zzacn.zzo(obj, j, list);
            return list;
        } else if (zza.isAssignableFrom(list2.getClass())) {
            ArrayList arrayList = new ArrayList(list2.size() + i);
            arrayList.addAll(list2);
            zzacn.zzo(obj, j, arrayList);
            return arrayList;
        } else if (list2 instanceof zzaci) {
            zzaam zzaam = new zzaam(list2.size() + i);
            zzaam.addAll(zzaam.size(), (zzaci) list2);
            zzacn.zzo(obj, j, zzaam);
            return zzaam;
        } else if (!(list2 instanceof zzabk) || !(list2 instanceof zzaaf)) {
            return list2;
        } else {
            zzaaf zzaaf = (zzaaf) list2;
            if (zzaaf.zza()) {
                return list2;
            }
            zzaaf zze = zzaaf.zze(list2.size() + i);
            zzacn.zzo(obj, j, zze);
            return zze;
        }
    }

    /* access modifiers changed from: package-private */
    public final <L> List<L> zza(Object obj, long j) {
        return zzf(obj, j, 10);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, long j) {
        Object obj2;
        List list = (List) zzacn.zzn(obj, j);
        if (list instanceof zzaan) {
            obj2 = ((zzaan) list).zzi();
        } else if (!zza.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzabk) || !(list instanceof zzaaf)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzaaf zzaaf = (zzaaf) list;
                if (zzaaf.zza()) {
                    zzaaf.zzb();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        zzacn.zzo(obj, j, obj2);
    }

    /* access modifiers changed from: package-private */
    public final <E> void zzc(Object obj, Object obj2, long j) {
        List list = (List) zzacn.zzn(obj2, j);
        List zzf = zzf(obj, j, list.size());
        int size = zzf.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            zzf.addAll(list);
        }
        if (size > 0) {
            list = zzf;
        }
        zzacn.zzo(obj, j, list);
    }
}
