package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzt  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public enum zzzt {
    DOUBLE(0, 1, zzaaj.DOUBLE),
    FLOAT(1, 1, zzaaj.FLOAT),
    INT64(2, 1, zzaaj.LONG),
    UINT64(3, 1, zzaaj.LONG),
    INT32(4, 1, zzaaj.INT),
    FIXED64(5, 1, zzaaj.LONG),
    FIXED32(6, 1, zzaaj.INT),
    BOOL(7, 1, zzaaj.BOOLEAN),
    STRING(8, 1, zzaaj.STRING),
    MESSAGE(9, 1, zzaaj.MESSAGE),
    BYTES(10, 1, zzaaj.BYTE_STRING),
    UINT32(11, 1, zzaaj.INT),
    ENUM(12, 1, zzaaj.ENUM),
    SFIXED32(13, 1, zzaaj.INT),
    SFIXED64(14, 1, zzaaj.LONG),
    SINT32(15, 1, zzaaj.INT),
    SINT64(16, 1, zzaaj.LONG),
    GROUP(17, 1, zzaaj.MESSAGE),
    DOUBLE_LIST(18, 2, zzaaj.DOUBLE),
    FLOAT_LIST(19, 2, zzaaj.FLOAT),
    INT64_LIST(20, 2, zzaaj.LONG),
    UINT64_LIST(21, 2, zzaaj.LONG),
    INT32_LIST(22, 2, zzaaj.INT),
    FIXED64_LIST(23, 2, zzaaj.LONG),
    FIXED32_LIST(24, 2, zzaaj.INT),
    BOOL_LIST(25, 2, zzaaj.BOOLEAN),
    STRING_LIST(26, 2, zzaaj.STRING),
    MESSAGE_LIST(27, 2, zzaaj.MESSAGE),
    BYTES_LIST(28, 2, zzaaj.BYTE_STRING),
    UINT32_LIST(29, 2, zzaaj.INT),
    ENUM_LIST(30, 2, zzaaj.ENUM),
    SFIXED32_LIST(31, 2, zzaaj.INT),
    SFIXED64_LIST(32, 2, zzaaj.LONG),
    SINT32_LIST(33, 2, zzaaj.INT),
    SINT64_LIST(34, 2, zzaaj.LONG),
    DOUBLE_LIST_PACKED(35, 3, zzaaj.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, zzaaj.FLOAT),
    INT64_LIST_PACKED(37, 3, zzaaj.LONG),
    UINT64_LIST_PACKED(38, 3, zzaaj.LONG),
    INT32_LIST_PACKED(39, 3, zzaaj.INT),
    FIXED64_LIST_PACKED(40, 3, zzaaj.LONG),
    FIXED32_LIST_PACKED(41, 3, zzaaj.INT),
    BOOL_LIST_PACKED(42, 3, zzaaj.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, zzaaj.INT),
    ENUM_LIST_PACKED(44, 3, zzaaj.ENUM),
    SFIXED32_LIST_PACKED(45, 3, zzaaj.INT),
    SFIXED64_LIST_PACKED(46, 3, zzaaj.LONG),
    SINT32_LIST_PACKED(47, 3, zzaaj.INT),
    SINT64_LIST_PACKED(48, 3, zzaaj.LONG),
    GROUP_LIST(49, 2, zzaaj.MESSAGE),
    MAP(50, 4, zzaaj.VOID);
    
    private static final zzzt[] zzac = null;
    private final zzaaj zzZ;
    private final int zzaa;
    private final Class<?> zzab;

    static {
        int i;
        zzac = new zzzt[r1];
        for (zzzt zzzt : values()) {
            zzac[zzzt.zzaa] = zzzt;
        }
    }

    private zzzt(int i, int i2, zzaaj zzaaj) {
        this.zzaa = i;
        this.zzZ = zzaaj;
        zzaaj zzaaj2 = zzaaj.VOID;
        int i3 = i2 - 1;
        if (i3 == 1) {
            this.zzab = zzaaj.zza();
        } else if (i3 != 3) {
            this.zzab = null;
        } else {
            this.zzab = zzaaj.zza();
        }
        if (i2 == 1) {
            zzaaj.ordinal();
        }
    }

    public final int zza() {
        return this.zzaa;
    }
}
