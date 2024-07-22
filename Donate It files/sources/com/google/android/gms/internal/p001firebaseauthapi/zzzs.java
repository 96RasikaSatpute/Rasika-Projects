package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzzr;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzs  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzzs<T extends zzzr<T>> {
    private static final zzzs zzd = new zzzs(true);
    final zzabz<T, Object> zza = new zzabs(16);
    private boolean zzb;
    private boolean zzc;

    private zzzs() {
    }

    public static <T extends zzzr<T>> zzzs<T> zza() {
        throw null;
    }

    private static final void zzd(T t, Object obj) {
        boolean z;
        zzact zzb2 = t.zzb();
        zzaag.zza(obj);
        zzact zzact = zzact.DOUBLE;
        zzacu zzacu = zzacu.INT;
        switch (zzb2.zza().ordinal()) {
            case 0:
                z = obj instanceof Integer;
                break;
            case 1:
                z = obj instanceof Long;
                break;
            case 2:
                z = obj instanceof Float;
                break;
            case 3:
                z = obj instanceof Double;
                break;
            case 4:
                z = obj instanceof Boolean;
                break;
            case 5:
                z = obj instanceof String;
                break;
            case 6:
                if ((obj instanceof zzyy) || (obj instanceof byte[])) {
                    return;
                }
            case 7:
                if ((obj instanceof Integer) || (obj instanceof zzaac)) {
                    return;
                }
            case 8:
                if ((obj instanceof zzabd) || (obj instanceof zzaak)) {
                    return;
                }
        }
        if (z) {
            return;
        }
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(t.zza()), t.zzb().zza(), obj.getClass().getName()}));
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzzs zzzs = new zzzs();
        for (int i = 0; i < this.zza.zzc(); i++) {
            Map.Entry<T, Object> zzd2 = this.zza.zzd(i);
            zzzs.zzc((zzzr) zzd2.getKey(), zzd2.getValue());
        }
        for (Map.Entry next : this.zza.zze()) {
            zzzs.zzc((zzzr) next.getKey(), next.getValue());
        }
        zzzs.zzc = this.zzc;
        return zzzs;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzzs)) {
            return false;
        }
        return this.zza.equals(((zzzs) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (!this.zzb) {
            this.zza.zza();
            this.zzb = true;
        }
    }

    public final void zzc(T t, Object obj) {
        if (!t.zzc()) {
            zzd(t, obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zzd(t, arrayList.get(i));
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzaak) {
            this.zzc = true;
        }
        this.zza.put(t, obj);
    }

    private zzzs(boolean z) {
        zzb();
        zzb();
    }
}
