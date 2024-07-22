package com.google.android.gms.internal.p001firebaseauthapi;

import android.text.TextUtils;
import com.google.firebase.auth.zze;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzon  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzon implements zzve<zzwm> {
    final /* synthetic */ zzvd zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ Boolean zzd;
    final /* synthetic */ zze zze;
    final /* synthetic */ zztq zzf;
    final /* synthetic */ zzwv zzg;

    zzon(zzpy zzpy, zzvd zzvd, String str, String str2, Boolean bool, zze zze2, zztq zztq, zzwv zzwv) {
        this.zza = zzvd;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bool;
        this.zze = zze2;
        this.zzf = zztq;
        this.zzg = zzwv;
    }

    public final void zza(String str) {
        this.zza.zza(str);
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        List<zzxb> list;
        List<zzwo> zzb2 = ((zzwm) obj).zzb();
        if (zzb2 == null || zzb2.isEmpty()) {
            this.zza.zza("No users.");
            return;
        }
        int i = 0;
        zzwo zzwo = zzb2.get(0);
        zzxd zzq = zzwo.zzq();
        if (zzq != null) {
            list = zzq.zza();
        } else {
            list = null;
        }
        if (list != null && !list.isEmpty()) {
            if (!TextUtils.isEmpty(this.zzb)) {
                while (true) {
                    if (i >= list.size()) {
                        break;
                    } else if (list.get(i).zzd().equals(this.zzb)) {
                        list.get(i).zzf(this.zzc);
                        break;
                    } else {
                        i++;
                    }
                }
            } else {
                list.get(0).zzf(this.zzc);
            }
        }
        zzwo.zzo(this.zzd.booleanValue());
        zzwo.zzs(this.zze);
        this.zzf.zzb(this.zzg, zzwo);
    }
}
