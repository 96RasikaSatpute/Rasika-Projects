package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzvb<ResultT, CallbackT> {
    private final zzvc<ResultT, CallbackT> zza;
    private final TaskCompletionSource<ResultT> zzb;

    public zzvb(zzvc<ResultT, CallbackT> zzvc, TaskCompletionSource<ResultT> taskCompletionSource) {
        this.zza = zzvc;
        this.zzb = taskCompletionSource;
    }

    public final void zza(ResultT resultt, Status status) {
        FirebaseUser firebaseUser;
        Preconditions.checkNotNull(this.zzb, "completion source cannot be null");
        if (status != null) {
            zzvc<ResultT, CallbackT> zzvc = this.zza;
            if (zzvc.zzs != null) {
                TaskCompletionSource<ResultT> taskCompletionSource = this.zzb;
                FirebaseAuth instance = FirebaseAuth.getInstance(zzvc.zzd);
                zzvc<ResultT, CallbackT> zzvc2 = this.zza;
                zzof zzof = zzvc2.zzs;
                if ("reauthenticateWithCredential".equals(zzvc2.zza()) || "reauthenticateWithCredentialWithData".equals(this.zza.zza())) {
                    firebaseUser = this.zza.zze;
                } else {
                    firebaseUser = null;
                }
                taskCompletionSource.setException(zztt.zzc(instance, zzof, firebaseUser));
                return;
            }
            AuthCredential authCredential = zzvc.zzp;
            if (authCredential != null) {
                this.zzb.setException(zztt.zzb(status, authCredential, zzvc.zzq, zzvc.zzr));
            } else {
                this.zzb.setException(zztt.zza(status));
            }
        } else {
            this.zzb.setResult(resultt);
        }
    }
}
