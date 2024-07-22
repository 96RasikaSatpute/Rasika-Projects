package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaav  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzaav implements zzabq {
    private static final zzabb zzb = new zzaat();
    private final zzabb zza;

    public zzaav() {
        zzabb zzabb;
        zzabb[] zzabbArr = new zzabb[2];
        zzabbArr[0] = zzzv.zza();
        try {
            zzabb = (zzabb) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception e) {
            zzabb = zzb;
        }
        zzabbArr[1] = zzabb;
        zzaau zzaau = new zzaau(zzabbArr);
        zzaag.zzb(zzaau, "messageInfoFactory");
        this.zza = zzaau;
    }

    private static boolean zzb(zzaba zzaba) {
        return zzaba.zzc() == 1;
    }

    public final <T> zzabp<T> zza(Class<T> cls) {
        zzabr.zza(cls);
        zzaba zzc = this.zza.zzc(cls);
        if (zzc.zza()) {
            if (zzaaa.class.isAssignableFrom(cls)) {
                return zzabh.zzg(zzabr.zzC(), zzzq.zza(), zzc.zzb());
            }
            return zzabh.zzg(zzabr.zzA(), zzzq.zzb(), zzc.zzb());
        } else if (zzaaa.class.isAssignableFrom(cls)) {
            if (zzb(zzc)) {
                return zzabg.zzl(cls, zzc, zzabj.zzb(), zzaar.zze(), zzabr.zzC(), zzzq.zza(), zzaaz.zzb());
            }
            return zzabg.zzl(cls, zzc, zzabj.zzb(), zzaar.zze(), zzabr.zzC(), (zzzo<?>) null, zzaaz.zzb());
        } else if (zzb(zzc)) {
            return zzabg.zzl(cls, zzc, zzabj.zza(), zzaar.zzd(), zzabr.zzA(), zzzq.zzb(), zzaaz.zza());
        } else {
            return zzabg.zzl(cls, zzc, zzabj.zza(), zzaar.zzd(), zzabr.zzB(), (zzzo<?>) null, zzaaz.zza());
        }
    }
}
