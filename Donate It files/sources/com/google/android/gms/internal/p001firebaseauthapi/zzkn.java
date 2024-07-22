package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzkv;
import com.google.android.gms.security.ProviderInstaller;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkn  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzkn<T_WRAPPER extends zzkv<T_ENGINE>, T_ENGINE> {
    public static final zzkn<zzko, Cipher> zza = new zzkn<>(new zzko());
    public static final zzkn<zzks, Mac> zzb = new zzkn<>(new zzks());
    public static final zzkn<zzku, Signature> zzc = new zzkn<>(new zzku());
    public static final zzkn<zzkt, MessageDigest> zzd = new zzkn<>(new zzkt());
    public static final zzkn<zzkp, KeyAgreement> zze = new zzkn<>(new zzkp());
    public static final zzkn<zzkr, KeyPairGenerator> zzf = new zzkn<>(new zzkr());
    public static final zzkn<zzkq, KeyFactory> zzg = new zzkn<>(new zzkq());
    private static final Logger zzh = Logger.getLogger(zzkn.class.getName());
    private static final List<Provider> zzi;
    private static final boolean zzj;
    private final T_WRAPPER zzk;

    static {
        if (zzlf.zza()) {
            String[] strArr = {ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL"};
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 2; i++) {
                String str = strArr[i];
                Provider provider = Security.getProvider(str);
                if (provider != null) {
                    arrayList.add(provider);
                } else {
                    zzh.logp(Level.INFO, "com.google.crypto.tink.subtle.EngineFactory", "toProviderList", String.format("Provider %s not available", new Object[]{str}));
                }
            }
            zzi = arrayList;
            zzj = true;
        } else {
            zzi = new ArrayList();
            zzj = true;
        }
    }

    public zzkn(T_WRAPPER t_wrapper) {
        this.zzk = t_wrapper;
    }

    public final T_ENGINE zza(String str) throws GeneralSecurityException {
        Exception exc = null;
        for (Provider zza2 : zzi) {
            try {
                return this.zzk.zza(str, zza2);
            } catch (Exception e) {
                if (exc == null) {
                    exc = e;
                }
            }
        }
        if (zzj) {
            return this.zzk.zza(str, (Provider) null);
        }
        throw new GeneralSecurityException("No good Provider found.", exc);
    }
}
