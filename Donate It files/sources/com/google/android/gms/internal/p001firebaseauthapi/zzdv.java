package com.google.android.gms.internal.p001firebaseauthapi;

import android.util.Log;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.Arrays;
import java.util.Locale;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdv  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzdv implements zzax {
    private static final String zza = zzdv.class.getSimpleName();
    private KeyStore zzb = new zzdu().zza;

    public final synchronized boolean zza(String str) {
        return str.toLowerCase(Locale.US).startsWith("android-keystore://");
    }

    public final synchronized zzag zzb(String str) throws GeneralSecurityException {
        zzdt zzdt;
        zzdt = new zzdt(zzlg.zzc("android-keystore://", str), this.zzb);
        byte[] zza2 = zzle.zza(10);
        byte[] bArr = new byte[0];
        if (!Arrays.equals(zza2, zzdt.zzb(zzdt.zza(zza2, bArr), bArr))) {
            throw new KeyStoreException("cannot use Android Keystore: encryption/decryption of non-empty message and empty aad returns an incorrect result");
        }
        return zzdt;
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean zzc(String str) throws GeneralSecurityException {
        String zzc;
        zzc = zzlg.zzc("android-keystore://", str);
        try {
        } catch (IOException e) {
            throw new GeneralSecurityException(e);
        } catch (InterruptedException e2) {
        } catch (NullPointerException e3) {
            Log.w(zza, "Keystore is temporarily unavailable, wait 20ms, reinitialize Keystore and try again.");
            Thread.sleep(20);
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            this.zzb = instance;
            instance.load((KeyStore.LoadStoreParameter) null);
        }
        return this.zzb.containsAlias(zzc);
        return this.zzb.containsAlias(zzc);
    }
}
