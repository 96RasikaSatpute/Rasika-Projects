package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzaaa;
import com.google.android.gms.internal.p001firebaseauthapi.zzzw;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public class zzzw<MessageType extends zzaaa<MessageType, BuilderType>, BuilderType extends zzzw<MessageType, BuilderType>> extends zzyi<MessageType, BuilderType> {
    protected MessageType zza;
    protected boolean zzb = false;
    private final MessageType zzc;

    protected zzzw(MessageType messagetype) {
        this.zzc = messagetype;
        this.zza = (zzaaa) messagetype.zzj(4, (Object) null, (Object) null);
    }

    private static final void zza(MessageType messagetype, MessageType messagetype2) {
        zzabl.zza().zzb(messagetype.getClass()).zzd(messagetype, messagetype2);
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ zzyi zzg(zzyj zzyj) {
        zzm((zzaaa) zzyj);
        return this;
    }

    /* access modifiers changed from: protected */
    public void zzi() {
        MessageType messagetype = (zzaaa) this.zza.zzj(4, (Object) null, (Object) null);
        zza(messagetype, this.zza);
        this.zza = messagetype;
    }

    /* renamed from: zzj */
    public final BuilderType zzf() {
        BuilderType buildertype = (zzzw) this.zzc.zzj(5, (Object) null, (Object) null);
        buildertype.zzm(zzn());
        return buildertype;
    }

    /* renamed from: zzk */
    public MessageType zzn() {
        if (this.zzb) {
            return this.zza;
        }
        MessageType messagetype = this.zza;
        zzabl.zza().zzb(messagetype.getClass()).zzj(messagetype);
        this.zzb = true;
        return this.zza;
    }

    public final MessageType zzl() {
        MessageType zzk = zzn();
        if (zzk.zzt()) {
            return zzk;
        }
        throw new zzacc(zzk);
    }

    public final BuilderType zzm(MessageType messagetype) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        zza(this.zza, messagetype);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzabd zzo() {
        return this.zzc;
    }
}
