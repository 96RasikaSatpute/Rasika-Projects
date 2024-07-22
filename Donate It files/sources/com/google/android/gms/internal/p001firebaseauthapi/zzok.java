package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzok  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzok implements zzve<zzwe> {
    final /* synthetic */ zztq zza;
    final /* synthetic */ zzpy zzb;

    zzok(zzpy zzpy, zztq zztq) {
        this.zzb = zzpy;
        this.zza = zztq;
    }

    public final void zza(String str) {
        this.zza.zzk(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzwe zzwe = (zzwe) obj;
        if (zzwe.zzh()) {
            this.zza.zzo(new zzof(zzwe.zzg(), zzwe.zzf(), (zze) null));
            return;
        }
        this.zzb.zzO(new zzwv(zzwe.zzc(), zzwe.zzb(), Long.valueOf(zzwe.zze()), "Bearer"), (String) null, (String) null, Boolean.valueOf(zzwe.zzd()), (zze) null, this.zza, this);
    }
}
