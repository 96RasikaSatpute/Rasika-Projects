package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.firebase.auth.internal.zzai;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpc  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzpc implements zzve<zzwv> {
    final /* synthetic */ String zza;
    final /* synthetic */ zztq zzb;
    final /* synthetic */ zzpy zzc;

    zzpc(zzpy zzpy, String str, zztq zztq) {
        this.zzc = zzpy;
        this.zza = str;
        this.zzb = zztq;
    }

    public final void zza(String str) {
        this.zzb.zzk(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzwv zzwv = (zzwv) obj;
        this.zzc.zza.zzh(new zzwl(zzwv.zze()), new zzpb(this, this, zzwv));
    }
}
