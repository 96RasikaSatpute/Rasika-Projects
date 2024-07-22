package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p001firebaseauthapi.zzwv;
import com.google.firebase.auth.internal.zzbk;

/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzt implements zzbk {
    final /* synthetic */ FirebaseAuth zza;

    zzt(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    public final void zza(zzwv zzwv, FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(zzwv);
        Preconditions.checkNotNull(firebaseUser);
        firebaseUser.zzf(zzwv);
        FirebaseAuth.zzb(this.zza, firebaseUser, zzwv, true, true);
    }

    public final void zzb(Status status) {
        if (status.getStatusCode() == 17011 || status.getStatusCode() == 17021 || status.getStatusCode() == 17005 || status.getStatusCode() == 17091) {
            this.zza.signOut();
        }
    }
}
