package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final /* synthetic */ class zzsb implements RemoteCall {
    private final zzsc zza;

    zzsb(zzsc zzsc) {
        this.zza = zzsc;
    }

    public final void accept(Object obj, Object obj2) {
        this.zza.zzd((zztr) obj, (TaskCompletionSource) obj2);
    }
}
