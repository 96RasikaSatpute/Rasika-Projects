package com.google.android.gms.internal.p001firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzom  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzom implements zzve<zzxm> {
    final /* synthetic */ zzxl zza;
    final /* synthetic */ zzwo zzb;
    final /* synthetic */ zztq zzc;
    final /* synthetic */ zzwv zzd;
    final /* synthetic */ zzvd zze;
    final /* synthetic */ zzpy zzf;

    zzom(zzpy zzpy, zzxl zzxl, zzwo zzwo, zztq zztq, zzwv zzwv, zzvd zzvd) {
        this.zzf = zzpy;
        this.zza = zzxl;
        this.zzb = zzwo;
        this.zzc = zztq;
        this.zzd = zzwv;
        this.zze = zzvd;
    }

    public final void zza(String str) {
        this.zze.zza(str);
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzxm zzxm = (zzxm) obj;
        if (this.zza.zzb("EMAIL")) {
            this.zzb.zzj((String) null);
        } else if (this.zza.zzc() != null) {
            this.zzb.zzj(this.zza.zzc());
        }
        if (this.zza.zzb("DISPLAY_NAME")) {
            this.zzb.zzk((String) null);
        } else if (this.zza.zze() != null) {
            this.zzb.zzk(this.zza.zze());
        }
        if (this.zza.zzb("PHOTO_URL")) {
            this.zzb.zzl((String) null);
        } else if (this.zza.zzf() != null) {
            this.zzb.zzl(this.zza.zzf());
        }
        if (!TextUtils.isEmpty(this.zza.zzd())) {
            this.zzb.zzm(Base64Utils.encode("redacted".getBytes()));
        }
        List zzf2 = zzxm.zzf();
        if (zzf2 == null) {
            zzf2 = new ArrayList();
        }
        this.zzb.zzn(zzf2);
        zztq zztq = this.zzc;
        zzwv zzwv = this.zzd;
        Preconditions.checkNotNull(zzwv);
        Preconditions.checkNotNull(zzxm);
        String zzb2 = zzxm.zzb();
        String zzc2 = zzxm.zzc();
        if (!TextUtils.isEmpty(zzb2) && !TextUtils.isEmpty(zzc2)) {
            zzwv = new zzwv(zzc2, zzb2, Long.valueOf(zzxm.zzd()), zzwv.zzg());
        }
        zztq.zzb(zzwv, this.zzb);
    }
}
