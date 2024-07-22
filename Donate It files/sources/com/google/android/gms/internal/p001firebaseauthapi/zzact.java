package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzact  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public enum zzact {
    DOUBLE(zzacu.DOUBLE, 1),
    FLOAT(zzacu.FLOAT, 5),
    INT64(zzacu.LONG, 0),
    UINT64(zzacu.LONG, 0),
    INT32(zzacu.INT, 0),
    FIXED64(zzacu.LONG, 1),
    FIXED32(zzacu.INT, 5),
    BOOL(zzacu.BOOLEAN, 0),
    STRING(zzacu.STRING, 2),
    GROUP(zzacu.MESSAGE, 3),
    MESSAGE(zzacu.MESSAGE, 2),
    BYTES(zzacu.BYTE_STRING, 2),
    UINT32(zzacu.INT, 0),
    ENUM(zzacu.ENUM, 0),
    SFIXED32(zzacu.INT, 5),
    SFIXED64(zzacu.LONG, 1),
    SINT32(zzacu.INT, 0),
    SINT64(zzacu.LONG, 0);
    
    private final zzacu zzs;

    private zzact(zzacu zzacu, int i) {
        this.zzs = zzacu;
    }

    public final zzacu zza() {
        return this.zzs;
    }
}
