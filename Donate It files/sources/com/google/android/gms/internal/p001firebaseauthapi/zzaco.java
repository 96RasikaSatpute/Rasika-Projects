package com.google.android.gms.internal.p001firebaseauthapi;

import kotlin.UByte;
import okio.Utf8;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaco  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzaco {
    static /* synthetic */ boolean zza(byte b) {
        return b >= 0;
    }

    static /* synthetic */ void zzb(byte b, byte b2, char[] cArr, int i) throws zzaai {
        if (b < -62 || zze(b2)) {
            throw zzaai.zzi();
        }
        cArr[i] = (char) (((b & 31) << 6) | (b2 & Utf8.REPLACEMENT_BYTE));
    }

    static /* synthetic */ void zzd(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) throws zzaai {
        if (zze(b2) || (((b << 28) + (b2 + 112)) >> 30) != 0 || zze(b3) || zze(b4)) {
            throw zzaai.zzi();
        }
        byte b5 = ((b & 7) << 18) | ((b2 & Utf8.REPLACEMENT_BYTE) << 12) | ((b3 & Utf8.REPLACEMENT_BYTE) << 6) | (b4 & Utf8.REPLACEMENT_BYTE);
        cArr[i] = (char) ((b5 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
        cArr[i + 1] = (char) ((b5 & UByte.MAX_VALUE) + Utf8.LOG_SURROGATE_HEADER);
    }

    private static boolean zze(byte b) {
        return b > -65;
    }

    static /* synthetic */ void zzc(byte b, byte b2, byte b3, char[] cArr, int i) throws zzaai {
        if (!zze(b2)) {
            if (b == -32) {
                if (b2 >= -96) {
                    b = -32;
                }
            }
            if (b == -19) {
                if (b2 < -96) {
                    b = -19;
                }
            }
            if (!zze(b3)) {
                cArr[i] = (char) (((b & 15) << 12) | ((b2 & Utf8.REPLACEMENT_BYTE) << 6) | (b3 & Utf8.REPLACEMENT_BYTE));
                return;
            }
        }
        throw zzaai.zzi();
    }
}
