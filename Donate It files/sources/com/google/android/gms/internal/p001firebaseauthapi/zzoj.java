package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.internal.zzai;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzoj implements zzve<zzwv> {
    final /* synthetic */ EmailAuthCredential zza;
    final /* synthetic */ zztq zzb;
    final /* synthetic */ zzpy zzc;

    zzoj(zzpy zzpy, EmailAuthCredential emailAuthCredential, zztq zztq) {
        this.zzc = zzpy;
        this.zza = emailAuthCredential;
        this.zzb = zztq;
    }

    public final void zza(String str) {
        this.zzb.zzk(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzc.zzN(new zzwd(this.zza, ((zzwv) obj).zze()), this.zzb);
    }
}
