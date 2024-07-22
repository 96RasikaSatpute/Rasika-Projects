package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzyi;
import com.google.android.gms.internal.p001firebaseauthapi.zzyj;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public abstract class zzyj<MessageType extends zzyj<MessageType, BuilderType>, BuilderType extends zzyi<MessageType, BuilderType>> implements zzabd {
    protected int zza = 0;

    public final byte[] zzI() {
        try {
            byte[] bArr = new byte[zzw()];
            zzzi zzx = zzzi.zzx(bArr);
            zzv(zzx);
            zzx.zzG();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 72);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a byte array threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    public final zzyy zzn() {
        try {
            int zzw = zzw();
            zzyy zzyy = zzyy.zzb;
            byte[] bArr = new byte[zzw];
            zzzi zzx = zzzi.zzx(bArr);
            zzv(zzx);
            zzx.zzG();
            return new zzyw(bArr);
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 72);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ByteString threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    public final void zzp(OutputStream outputStream) throws IOException {
        zzzi zzw = zzzi.zzw(outputStream, zzzi.zzv(zzw()));
        zzv(zzw);
        zzw.zzu();
    }

    /* access modifiers changed from: package-private */
    public int zzq() {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public void zzr(int i) {
        throw null;
    }
}
