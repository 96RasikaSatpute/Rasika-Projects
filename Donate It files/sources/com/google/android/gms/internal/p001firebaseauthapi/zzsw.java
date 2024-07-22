package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzx;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzsw extends zzvc<AuthResult, zzg> {
    public zzsw() {
        super(2);
    }

    public final String zza() {
        return "unlinkEmailCredential";
    }

    public final TaskApiCall<zztr, AuthResult> zzb() {
        return TaskApiCall.builder().run(new zzsv(this)).build();
    }

    public final void zzc() {
        zzx zzS = zztn.zzS(this.zzd, this.zzk);
        ((zzg) this.zzf).zza(this.zzj, zzS);
        zzj(new zzr(zzS));
    }
}
