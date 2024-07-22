package com.google.android.gms.internal.p001firebaseauthapi;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzds  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzds {
    public static final /* synthetic */ int zza = 0;
    /* access modifiers changed from: private */
    public static final String zzb = zzds.class.getSimpleName();
    private final zzaw zzc;
    private final zzag zzd;
    private final zzav zze;

    /* synthetic */ zzds(zzdr zzdr, zzdq zzdq) throws GeneralSecurityException, IOException {
        this.zzc = zzdr.zza;
        this.zzd = zzdr.zzc;
        this.zze = zzdr.zze;
    }

    public final synchronized zzau zza() throws GeneralSecurityException {
        return this.zze.zzc();
    }
}
