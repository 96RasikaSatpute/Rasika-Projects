package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.SecureRandom;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzle  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzle {
    private static final ThreadLocal<SecureRandom> zza = new zzld();

    public static byte[] zza(int i) {
        byte[] bArr = new byte[i];
        zza.get().nextBytes(bArr);
        return bArr;
    }
}
