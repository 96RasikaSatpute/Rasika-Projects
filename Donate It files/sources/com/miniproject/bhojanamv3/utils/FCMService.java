package com.miniproject.bhojanamv3.utils;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.miniproject.bhojanamv3.R;
import com.miniproject.bhojanamv3.activity.SplashActivity;

public class FCMService extends FirebaseMessagingService {
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Intent intent = new Intent(this, SplashActivity.class);
        intent.addFlags(67108864);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "Default").setSmallIcon(R.drawable.logo).setStyle(new NotificationCompat.BigTextStyle().bigText(remoteMessage.getData().get("body"))).setContentTitle(remoteMessage.getData().get("title")).setContentText(remoteMessage.getData().get("body")).setAutoCancel(true).setContentIntent(PendingIntent.getActivity(this, 12345, intent, BasicMeasure.EXACTLY));
        NotificationManager manager = (NotificationManager) getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            manager.createNotificationChannel(new NotificationChannel("Default", "Default channel", 3));
        }
        manager.notify(12345, builder.build());
    }
}
