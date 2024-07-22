package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrt  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final /* synthetic */ class zzrt implements RemoteCall {
    private final zzru zza;

    zzrt(zzru zzru) {
        this.zza = zzru;
    }

    public final void accept(Object obj, Object obj2) {
        this.zza.zzd((zztr) obj, (TaskCompletionSource) obj2);
    }
}
