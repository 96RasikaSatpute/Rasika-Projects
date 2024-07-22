package com.google.firebase.auth;

import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p001firebaseauthapi.zztn;
import com.google.android.gms.internal.p001firebaseauthapi.zztp;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.internal.zzag;
import com.google.firebase.auth.internal.zze;

/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzp implements OnCompleteListener<zze> {
    final /* synthetic */ PhoneAuthOptions zza;
    final /* synthetic */ FirebaseAuth zzb;

    zzp(FirebaseAuth firebaseAuth, PhoneAuthOptions phoneAuthOptions) {
        this.zzb = firebaseAuth;
        this.zza = phoneAuthOptions;
    }

    public final void onComplete(Task<zze> task) {
        String str;
        String str2;
        boolean z;
        boolean z2;
        if (!task.isSuccessful()) {
            String str3 = "Error while validating application identity: ";
            if (task.getException() != null) {
                String valueOf = String.valueOf(task.getException().getMessage());
                if (valueOf.length() != 0) {
                    str3 = str3.concat(valueOf);
                } else {
                    str3 = new String(str3);
                }
            }
            Log.e("FirebaseAuth", str3);
            Log.e("FirebaseAuth", "Proceeding without any application identifier.");
            str2 = null;
            str = null;
        } else {
            String zza2 = task.getResult().zza();
            str = task.getResult().zzb();
            str2 = zza2;
        }
        long longValue = this.zza.zzc().longValue();
        PhoneAuthProvider.OnVerificationStateChangedCallbacks zzE = this.zzb.zzJ(this.zza.zzb(), this.zza.zzd());
        zzag zzag = (zzag) Preconditions.checkNotNull(this.zza.zzg());
        if (zzag.zze()) {
            zztn zzG = this.zzb.zze;
            String str4 = (String) Preconditions.checkNotNull(this.zza.zzb());
            String zzF = this.zzb.zzi;
            if (this.zza.zzf() != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            zzG.zzM(zzag, str4, zzF, longValue, z2, this.zza.zzh(), str2, str, zztp.zza(), zzE, this.zza.zze(), this.zza.zzi());
            return;
        }
        zztn zzG2 = this.zzb.zze;
        PhoneMultiFactorInfo phoneMultiFactorInfo = (PhoneMultiFactorInfo) Preconditions.checkNotNull(this.zza.zzj());
        String zzF2 = this.zzb.zzi;
        if (this.zza.zzf() != null) {
            z = true;
        } else {
            z = false;
        }
        zzG2.zzO(zzag, phoneMultiFactorInfo, zzF2, longValue, z, this.zza.zzh(), str2, str, zztp.zza(), zzE, this.zza.zze(), this.zza.zzi());
    }
}
