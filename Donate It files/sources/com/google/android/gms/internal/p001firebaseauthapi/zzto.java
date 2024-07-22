package com.google.android.gms.internal.p001firebaseauthapi;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApi;
import com.google.firebase.FirebaseExceptionMapper;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzto  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzto implements Callable<zzpz<zzuk>> {
    private final zzuk zza;
    private final Context zzb;

    public zzto(zzuk zzuk, Context context) {
        this.zza = zzuk;
        this.zzb = context;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        boolean z;
        int isGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this.zzb, 12451000);
        if (isGooglePlayServicesAvailable != 0) {
            z = isGooglePlayServicesAvailable == 2;
        } else {
            z = true;
        }
        boolean unused = zztp.zza = z;
        Context context = this.zzb;
        zzuk zzc = this.zza.zza();
        zzc.zza = true;
        return new zzpz(new zzqb(context, zzul.zzb, zzc, new GoogleApi.Settings.Builder().setMapper(new FirebaseExceptionMapper()).build()));
    }
}
