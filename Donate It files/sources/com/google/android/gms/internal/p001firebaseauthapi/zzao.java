package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzabd;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzao  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzao<KeyFormatProtoT extends zzabd, KeyProtoT extends zzabd> {
    final zzar<KeyFormatProtoT, KeyProtoT> zza;

    zzao(zzar<KeyFormatProtoT, KeyProtoT> zzar) {
        this.zza = zzar;
    }

    /* access modifiers changed from: package-private */
    public final KeyProtoT zza(zzyy zzyy) throws GeneralSecurityException, zzaai {
        KeyFormatProtoT zzc = this.zza.zzc(zzyy);
        this.zza.zzb(zzc);
        return this.zza.zzd(zzc);
    }
}
