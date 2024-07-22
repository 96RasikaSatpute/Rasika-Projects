package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Iterator;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzach  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzach implements Iterator<String> {
    final Iterator<String> zza;
    final /* synthetic */ zzaci zzb;

    zzach(zzaci zzaci) {
        this.zzb = zzaci;
        this.zza = zzaci.zza.iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return this.zza.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
