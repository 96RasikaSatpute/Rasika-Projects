package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaau  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzaau implements zzabb {
    private final zzabb[] zza;

    zzaau(zzabb... zzabbArr) {
        this.zza = zzabbArr;
    }

    public final boolean zzb(Class<?> cls) {
        zzabb[] zzabbArr = this.zza;
        for (int i = 0; i < 2; i++) {
            if (zzabbArr[i].zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzaba zzc(Class<?> cls) {
        zzabb[] zzabbArr = this.zza;
        for (int i = 0; i < 2; i++) {
            zzabb zzabb = zzabbArr[i];
            if (zzabb.zzb(cls)) {
                return zzabb.zzc(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
