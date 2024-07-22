package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzn  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzzn {
    static final zzzn zza = new zzzn(true);
    private static volatile boolean zzb = false;
    private static volatile zzzn zzc;
    private final Map<zzzm, zzzy<?, ?>> zzd;

    zzzn() {
        this.zzd = new HashMap();
    }

    public static zzzn zza() {
        zzzn zzzn = zzc;
        if (zzzn == null) {
            synchronized (zzzn.class) {
                zzzn = zzc;
                if (zzzn == null) {
                    zzzn = zza;
                    zzc = zzzn;
                }
            }
        }
        return zzzn;
    }

    public final <ContainingType extends zzabd> zzzy<ContainingType, ?> zzb(ContainingType containingtype, int i) {
        return this.zzd.get(new zzzm(containingtype, i));
    }

    zzzn(boolean z) {
        this.zzd = Collections.emptyMap();
    }
}
