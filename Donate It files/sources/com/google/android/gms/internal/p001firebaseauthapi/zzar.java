package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzabd;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzar  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public abstract class zzar<KeyFormatProtoT extends zzabd, KeyT> {
    private final Class<KeyFormatProtoT> zza;

    public zzar(Class<KeyFormatProtoT> cls) {
        this.zza = cls;
    }

    public final Class<KeyFormatProtoT> zza() {
        return this.zza;
    }

    public abstract void zzb(KeyFormatProtoT keyformatprotot) throws GeneralSecurityException;

    public abstract KeyFormatProtoT zzc(zzyy zzyy) throws zzaai;

    public abstract KeyT zzd(KeyFormatProtoT keyformatprotot) throws GeneralSecurityException;
}
