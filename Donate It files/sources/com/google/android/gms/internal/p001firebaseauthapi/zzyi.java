package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzyi;
import com.google.android.gms.internal.p001firebaseauthapi.zzyj;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyi  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public abstract class zzyi<MessageType extends zzyj<MessageType, BuilderType>, BuilderType extends zzyi<MessageType, BuilderType>> implements zzabc {
    /* renamed from: zzf */
    public abstract BuilderType clone();

    /* access modifiers changed from: protected */
    public abstract BuilderType zzg(MessageType messagetype);

    public final /* bridge */ /* synthetic */ zzabc zzh(zzabd zzabd) {
        if (zzo().getClass().isInstance(zzabd)) {
            return zzg((zzyj) zzabd);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
