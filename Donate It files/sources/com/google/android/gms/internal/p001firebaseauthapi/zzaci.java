package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaci  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzaci extends AbstractList<String> implements RandomAccess, zzaan {
    /* access modifiers changed from: private */
    public final zzaan zza;

    public zzaci(zzaan zzaan) {
        this.zza = zzaan;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        return ((zzaam) this.zza).get(i);
    }

    public final Iterator<String> iterator() {
        return new zzach(this);
    }

    public final ListIterator<String> listIterator(int i) {
        return new zzacg(this, i);
    }

    public final int size() {
        return this.zza.size();
    }

    public final void zzf(zzyy zzyy) {
        throw new UnsupportedOperationException();
    }

    public final Object zzg(int i) {
        return this.zza.zzg(i);
    }

    public final List<?> zzh() {
        return this.zza.zzh();
    }

    public final zzaan zzi() {
        return this;
    }
}
