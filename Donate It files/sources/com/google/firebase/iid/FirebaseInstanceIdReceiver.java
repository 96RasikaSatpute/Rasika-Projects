package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.android.gms.cloudmessaging.CloudMessagingReceiver;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.Constants;
import com.google.firebase.messaging.FcmBroadcastProcessor;
import com.google.firebase.messaging.MessagingAnalytics;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
public final class FirebaseInstanceIdReceiver extends CloudMessagingReceiver {
    private static Intent zzb(Context context, String str, Bundle bundle) {
        return new Intent(str).putExtras(bundle);
    }

    /* access modifiers changed from: protected */
    public final int onMessageReceive(Context context, CloudMessage cloudMessage) {
        try {
            return ((Integer) Tasks.await(new FcmBroadcastProcessor(context).process(cloudMessage.getIntent()))).intValue();
        } catch (InterruptedException | ExecutionException e) {
            Log.e(Constants.TAG, "Failed to send message to service.", e);
            return 500;
        }
    }

    /* access modifiers changed from: protected */
    public final void onNotificationDismissed(Context context, Bundle bundle) {
        Intent zzb = zzb(context, CloudMessagingReceiver.IntentActionKeys.NOTIFICATION_DISMISS, bundle);
        if (MessagingAnalytics.shouldUploadScionMetrics(zzb)) {
            MessagingAnalytics.logNotificationDismiss(zzb);
        }
    }

    /* access modifiers changed from: protected */
    public final void onNotificationOpen(Context context, Bundle bundle) {
        Intent zzb = zzb(context, CloudMessagingReceiver.IntentActionKeys.NOTIFICATION_OPEN, bundle);
        if (MessagingAnalytics.shouldUploadScionMetrics(zzb)) {
            MessagingAnalytics.logNotificationOpen(zzb);
        }
    }
}
