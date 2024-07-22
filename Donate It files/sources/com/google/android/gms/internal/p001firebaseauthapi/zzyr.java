package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Comparator;
import kotlin.UByte;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyr  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzyr implements Comparator<zzyy> {
    zzyr() {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzyy zzyy = (zzyy) obj;
        zzyy zzyy2 = (zzyy) obj2;
        zzyq zzyq = new zzyq(zzyy);
        zzyq zzyq2 = new zzyq(zzyy2);
        while (zzyq.hasNext() && zzyq2.hasNext()) {
            int compare = Integer.compare(zzyq.zza() & UByte.MAX_VALUE, zzyq2.zza() & UByte.MAX_VALUE);
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzyy.zzc(), zzyy2.zzc());
    }
}
