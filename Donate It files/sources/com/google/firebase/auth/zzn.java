package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p001firebaseauthapi.zzwv;
import com.google.firebase.auth.internal.zzbk;

/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzn implements zzbk {
    final /* synthetic */ FirebaseAuth zza;

    zzn(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    public final void zza(zzwv zzwv, FirebaseUser firebaseUser) {
        FirebaseAuth.zzb(this.zza, firebaseUser, zzwv, true, true);
    }

    public final void zzb(Status status) {
        int statusCode = status.getStatusCode();
        if (statusCode == 17011 || statusCode == 17021 || statusCode == 17005) {
            this.zza.signOut();
        }
    }
}
