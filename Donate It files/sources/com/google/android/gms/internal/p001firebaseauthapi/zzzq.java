package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzzq {
    private static final zzzo<?> zza = new zzzp();
    private static final zzzo<?> zzb;

    static {
        zzzo<?> zzzo;
        try {
            zzzo = (zzzo) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            zzzo = null;
        }
        zzb = zzzo;
    }

    static zzzo<?> zza() {
        return zza;
    }

    static zzzo<?> zzb() {
        zzzo<?> zzzo = zzb;
        if (zzzo != null) {
            return zzzo;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
