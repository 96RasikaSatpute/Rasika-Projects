package com.google.android.gms.internal.p001firebaseauthapi;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaai  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public class zzaai extends IOException {
    private zzabd zza = null;

    public zzaai(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    static zzaai zzb() {
        return new zzaai("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzaai zzc() {
        return new zzaai("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzaai zzd() {
        return new zzaai("CodedInputStream encountered a malformed varint.");
    }

    static zzaai zze() {
        return new zzaai("Protocol message contained an invalid tag (zero).");
    }

    static zzaai zzf() {
        return new zzaai("Protocol message end-group tag did not match expected tag.");
    }

    static zzaah zzg() {
        return new zzaah("Protocol message tag had invalid wire type.");
    }

    static zzaai zzh() {
        return new zzaai("Failed to parse the message.");
    }

    static zzaai zzi() {
        return new zzaai("Protocol message had invalid UTF-8.");
    }

    public final zzaai zza(zzabd zzabd) {
        this.zza = zzabd;
        return this;
    }

    public zzaai(String str) {
        super(str);
    }
}
