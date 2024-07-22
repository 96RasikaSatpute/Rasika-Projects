package com.google.android.gms.internal.p001firebaseauthapi;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlk  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzlk extends WeakReference<Throwable> {
    private final int zza;

    public zzlk(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        this.zza = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        zzlk zzlk = (zzlk) obj;
        return this.zza == zzlk.zza && get() == zzlk.get();
    }

    public final int hashCode() {
        return this.zza;
    }
}
