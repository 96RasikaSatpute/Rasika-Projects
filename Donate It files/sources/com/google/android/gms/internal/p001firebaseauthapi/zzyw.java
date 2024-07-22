package com.google.android.gms.internal.p001firebaseauthapi;

import java.io.IOException;
import java.nio.charset.Charset;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
class zzyw extends zzyv {
    protected final byte[] zza;

    zzyw(byte[] bArr) {
        if (bArr != null) {
            this.zza = bArr;
            return;
        }
        throw null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzyy) || zzc() != ((zzyy) obj).zzc()) {
            return false;
        }
        if (zzc() == 0) {
            return true;
        }
        if (!(obj instanceof zzyw)) {
            return obj.equals(this);
        }
        zzyw zzyw = (zzyw) obj;
        int zzr = zzr();
        int zzr2 = zzyw.zzr();
        if (zzr != 0 && zzr2 != 0 && zzr != zzr2) {
            return false;
        }
        int zzc = zzc();
        if (zzc > zzyw.zzc()) {
            int zzc2 = zzc();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(zzc);
            sb.append(zzc2);
            throw new IllegalArgumentException(sb.toString());
        } else if (zzc > zzyw.zzc()) {
            int zzc3 = zzyw.zzc();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(zzc);
            sb2.append(", ");
            sb2.append(zzc3);
            throw new IllegalArgumentException(sb2.toString());
        } else if (!(zzyw instanceof zzyw)) {
            return zzyw.zzf(0, zzc).equals(zzf(0, zzc));
        } else {
            byte[] bArr = this.zza;
            byte[] bArr2 = zzyw.zza;
            zzyw.zzd();
            int i = 0;
            int i2 = 0;
            while (i < zzc) {
                if (bArr[i] != bArr2[i2]) {
                    return false;
                }
                i++;
                i2++;
            }
            return true;
        }
    }

    public byte zza(int i) {
        return this.zza[i];
    }

    /* access modifiers changed from: package-private */
    public byte zzb(int i) {
        return this.zza[i];
    }

    public int zzc() {
        return this.zza.length;
    }

    /* access modifiers changed from: protected */
    public int zzd() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, 0, bArr, 0, i3);
    }

    public final zzyy zzf(int i, int i2) {
        int zzs = zzs(0, i2, zzc());
        if (zzs == 0) {
            return zzyy.zzb;
        }
        return new zzyt(this.zza, 0, zzs);
    }

    /* access modifiers changed from: package-private */
    public final void zzg(zzyp zzyp) throws IOException {
        zzyp.zza(this.zza, 0, zzc());
    }

    /* access modifiers changed from: protected */
    public final String zzh(Charset charset) {
        return new String(this.zza, 0, zzc(), charset);
    }

    public final boolean zzi() {
        return zzacs.zzb(this.zza, 0, zzc());
    }

    /* access modifiers changed from: protected */
    public final int zzj(int i, int i2, int i3) {
        return zzaag.zzh(i, this.zza, 0, i3);
    }

    public final zzzb zzk() {
        return zzzb.zzs(this.zza, 0, zzc(), true);
    }
}
