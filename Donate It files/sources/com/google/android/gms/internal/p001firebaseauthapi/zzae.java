package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzae  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzae {
    /* access modifiers changed from: private */
    public final zzp zza;
    private final zzad zzb;

    private zzae(zzad zzad) {
        zzo zzo = zzo.zza;
        this.zzb = zzad;
        this.zza = zzo;
    }

    public static zzae zza(char c) {
        return new zzae(new zzz(new zzm('.')));
    }

    public static zzae zzb(String str) {
        zzs zzc = zzx.zzc("[.-]");
        if (!((zzt) zzc.zza("")).zza.matches()) {
            return new zzae(new zzab(zzc));
        }
        throw new IllegalArgumentException(zzaf.zzd("The pattern may not match the empty string: %s", zzc));
    }

    public final List<String> zzc(CharSequence charSequence) {
        if (charSequence != null) {
            Iterator<String> zza2 = this.zzb.zza(this, charSequence);
            ArrayList arrayList = new ArrayList();
            while (zza2.hasNext()) {
                arrayList.add(zza2.next());
            }
            return Collections.unmodifiableList(arrayList);
        }
        throw null;
    }
}
