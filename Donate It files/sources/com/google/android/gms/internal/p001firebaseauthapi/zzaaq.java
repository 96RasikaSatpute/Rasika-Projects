package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaaq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzaaq extends zzaar {
    private zzaaq() {
        super((zzaao) null);
    }

    /* synthetic */ zzaaq(zzaao zzaao) {
        super((zzaao) null);
    }

    /* access modifiers changed from: package-private */
    public final <L> List<L> zza(Object obj, long j) {
        int i;
        zzaaf zzaaf = (zzaaf) zzacn.zzn(obj, j);
        if (zzaaf.zza()) {
            return zzaaf;
        }
        int size = zzaaf.size();
        if (size == 0) {
            i = 10;
        } else {
            i = size + size;
        }
        zzaaf zze = zzaaf.zze(i);
        zzacn.zzo(obj, j, zze);
        return zze;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, long j) {
        ((zzaaf) zzacn.zzn(obj, j)).zzb();
    }

    /* access modifiers changed from: package-private */
    public final <E> void zzc(Object obj, Object obj2, long j) {
        zzaaf zzaaf = (zzaaf) zzacn.zzn(obj, j);
        zzaaf zzaaf2 = (zzaaf) zzacn.zzn(obj2, j);
        int size = zzaaf.size();
        int size2 = zzaaf2.size();
        if (size > 0 && size2 > 0) {
            if (!zzaaf.zza()) {
                zzaaf = zzaaf.zze(size2 + size);
            }
            zzaaf.addAll(zzaaf2);
        }
        if (size > 0) {
            zzaaf2 = zzaaf;
        }
        zzacn.zzo(obj, j, zzaaf2);
    }
}
