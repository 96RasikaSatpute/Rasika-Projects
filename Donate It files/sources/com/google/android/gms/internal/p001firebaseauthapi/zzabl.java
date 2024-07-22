package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.firebase.messaging.Constants;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabl  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzabl {
    private static final zzabl zza = new zzabl();
    private final zzabq zzb = new zzaav();
    private final ConcurrentMap<Class<?>, zzabp<?>> zzc = new ConcurrentHashMap();

    private zzabl() {
    }

    public static zzabl zza() {
        return zza;
    }

    public final <T> zzabp<T> zzb(Class<T> cls) {
        zzaag.zzb(cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
        zzabp<T> zzabp = (zzabp) this.zzc.get(cls);
        if (zzabp == null) {
            zzabp = this.zzb.zza(cls);
            zzaag.zzb(cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
            zzaag.zzb(zzabp, "schema");
            zzabp<T> putIfAbsent = this.zzc.putIfAbsent(cls, zzabp);
            return putIfAbsent == null ? zzabp : putIfAbsent;
        }
    }
}
