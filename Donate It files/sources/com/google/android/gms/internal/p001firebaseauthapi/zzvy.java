package com.google.android.gms.internal.p001firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.messaging.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvy  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzvy implements zzuo<zzvy> {
    private static final String zza = zzvy.class.getName();
    private String zzb;

    public final /* bridge */ /* synthetic */ zzuo zza(String str) throws zzqe {
        zzd(str);
        return this;
    }

    public final boolean zzb() {
        return !TextUtils.isEmpty(this.zzb);
    }

    public final String zzc() {
        return this.zzb;
    }

    public final zzvy zzd(String str) throws zzqe {
        try {
            JSONObject jSONObject = new JSONObject(new JSONObject(str).getString(Constants.IPC_BUNDLE_KEY_SEND_ERROR));
            jSONObject.getInt("code");
            this.zzb = jSONObject.getString("message");
            return this;
        } catch (NullPointerException | JSONException e) {
            String str2 = zza;
            String message = e.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 52 + String.valueOf(message).length());
            sb.append("Failed to parse error for string [");
            sb.append(str);
            sb.append("] with exception: ");
            sb.append(message);
            Log.e(str2, sb.toString());
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 35);
            sb2.append("Failed to parse error for string [");
            sb2.append(str);
            sb2.append("]");
            throw new zzqe(sb2.toString(), e);
        }
    }
}
