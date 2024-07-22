package com.google.android.gms.internal.p001firebaseauthapi;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacf  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzacf extends zzacd<zzace, zzace> {
    zzacf() {
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzabo zzabo) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzb(Object obj, int i, long j) {
        ((zzace) obj).zzh(i << 3, Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzc(Object obj, int i, int i2) {
        ((zzace) obj).zzh((i << 3) | 5, Integer.valueOf(i2));
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzd(Object obj, int i, long j) {
        ((zzace) obj).zzh((i << 3) | 1, Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zze(Object obj, int i, zzyy zzyy) {
        ((zzace) obj).zzh((i << 3) | 2, zzyy);
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzf(Object obj, int i, Object obj2) {
        ((zzace) obj).zzh((i << 3) | 3, obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zzg() {
        return zzace.zzb();
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zzh(Object obj) {
        ((zzace) obj).zzd();
        return obj;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzi(Object obj, Object obj2) {
        ((zzaaa) obj).zzc = (zzace) obj2;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zzj(Object obj) {
        return ((zzaaa) obj).zzc;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zzk(Object obj) {
        zzaaa zzaaa = (zzaaa) obj;
        zzace zzace = zzaaa.zzc;
        if (zzace != zzace.zza()) {
            return zzace;
        }
        zzace zzb = zzace.zzb();
        zzaaa.zzc = zzb;
        return zzb;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzl(Object obj, Object obj2) {
        ((zzaaa) obj).zzc = (zzace) obj2;
    }

    /* access modifiers changed from: package-private */
    public final void zzm(Object obj) {
        ((zzaaa) obj).zzc.zzd();
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zzo(Object obj, Object obj2) {
        zzace zzace = (zzace) obj2;
        if (zzace.equals(zzace.zza())) {
            return obj;
        }
        return zzace.zzc((zzace) obj, zzace);
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ int zzp(Object obj) {
        return ((zzace) obj).zze();
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ int zzq(Object obj) {
        return ((zzace) obj).zzf();
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzr(Object obj, zzzj zzzj) throws IOException {
        ((zzace) obj).zzi(zzzj);
    }
}
