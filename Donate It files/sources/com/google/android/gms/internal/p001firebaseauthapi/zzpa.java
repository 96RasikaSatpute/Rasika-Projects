package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.firebase.auth.internal.zzai;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpa  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzpa implements zzve<zzwv> {
    final /* synthetic */ zztq zza;
    final /* synthetic */ zzpy zzb;

    zzpa(zzpy zzpy, zztq zztq) {
        this.zzb = zzpy;
        this.zza = zztq;
    }

    public final void zza(String str) {
        this.zza.zzk(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzwv zzwv = (zzwv) obj;
        zzxl zzxl = new zzxl();
        zzxl.zzg(zzwv.zze());
        zzxl.zzh((String) null);
        zzxl.zzi((String) null);
        zzpy.zzI(this.zzb, this.zza, zzwv, zzxl, this);
    }
}
