package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaay  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzaay {
    zzaay() {
    }

    public static final int zza(int i, Object obj, Object obj2) {
        zzaax zzaax = (zzaax) obj;
        zzaaw zzaaw = (zzaaw) obj2;
        if (zzaax.isEmpty()) {
            return 0;
        }
        Iterator it = zzaax.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw null;
    }

    public static final boolean zzb(Object obj) {
        return !((zzaax) obj).zze();
    }

    public static final Object zzc(Object obj, Object obj2) {
        zzaax zzaax = (zzaax) obj;
        zzaax zzaax2 = (zzaax) obj2;
        if (!zzaax2.isEmpty()) {
            if (!zzaax.zze()) {
                zzaax = zzaax.zzc();
            }
            zzaax.zzb(zzaax2);
        }
        return zzaax;
    }
}
