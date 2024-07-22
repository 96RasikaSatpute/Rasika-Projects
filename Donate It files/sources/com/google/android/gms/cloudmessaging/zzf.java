package com.google.android.gms.cloudmessaging;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.cloudmessaging.zze;
import java.util.ArrayDeque;
import java.util.Queue;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
final class zzf implements ServiceConnection {
    int zza;
    final Messenger zzb;
    zzo zzc;
    final Queue<zzq<?>> zzd;
    final SparseArray<zzq<?>> zze;
    final /* synthetic */ zze zzf;

    private zzf(zze zze2) {
        this.zzf = zze2;
        this.zza = 0;
        this.zzb = new Messenger(new zze(Looper.getMainLooper(), new zzi(this)));
        this.zzd = new ArrayDeque();
        this.zze = new SparseArray<>();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0099, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zza(com.google.android.gms.cloudmessaging.zzq<?> r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            int r0 = r5.zza     // Catch:{ all -> 0x009a }
            r1 = 2
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0043
            if (r0 == r3) goto L_0x003c
            if (r0 == r1) goto L_0x0032
            r6 = 3
            if (r0 == r6) goto L_0x0030
            r6 = 4
            if (r0 != r6) goto L_0x0013
            goto L_0x0030
        L_0x0013:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch:{ all -> 0x009a }
            int r0 = r5.zza     // Catch:{ all -> 0x009a }
            r1 = 26
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x009a }
            r2.<init>(r1)     // Catch:{ all -> 0x009a }
            java.lang.String r1 = "Unknown state: "
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch:{ all -> 0x009a }
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch:{ all -> 0x009a }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x009a }
            r6.<init>(r0)     // Catch:{ all -> 0x009a }
            throw r6     // Catch:{ all -> 0x009a }
        L_0x0030:
            monitor-exit(r5)
            return r2
        L_0x0032:
            java.util.Queue<com.google.android.gms.cloudmessaging.zzq<?>> r0 = r5.zzd     // Catch:{ all -> 0x009a }
            r0.add(r6)     // Catch:{ all -> 0x009a }
            r5.zza()     // Catch:{ all -> 0x009a }
            monitor-exit(r5)
            return r3
        L_0x003c:
            java.util.Queue<com.google.android.gms.cloudmessaging.zzq<?>> r0 = r5.zzd     // Catch:{ all -> 0x009a }
            r0.add(r6)     // Catch:{ all -> 0x009a }
            monitor-exit(r5)
            return r3
        L_0x0043:
            java.util.Queue<com.google.android.gms.cloudmessaging.zzq<?>> r0 = r5.zzd     // Catch:{ all -> 0x009a }
            r0.add(r6)     // Catch:{ all -> 0x009a }
            int r6 = r5.zza     // Catch:{ all -> 0x009a }
            if (r6 != 0) goto L_0x004f
            r6 = r3
            goto L_0x0050
        L_0x004f:
            r6 = r2
        L_0x0050:
            com.google.android.gms.common.internal.Preconditions.checkState(r6)     // Catch:{ all -> 0x009a }
            java.lang.String r6 = "MessengerIpcClient"
            boolean r6 = android.util.Log.isLoggable(r6, r1)     // Catch:{ all -> 0x009a }
            if (r6 == 0) goto L_0x0062
            java.lang.String r6 = "MessengerIpcClient"
            java.lang.String r0 = "Starting bind to GmsCore"
            android.util.Log.v(r6, r0)     // Catch:{ all -> 0x009a }
        L_0x0062:
            r5.zza = r3     // Catch:{ all -> 0x009a }
            android.content.Intent r6 = new android.content.Intent     // Catch:{ all -> 0x009a }
            java.lang.String r0 = "com.google.android.c2dm.intent.REGISTER"
            r6.<init>(r0)     // Catch:{ all -> 0x009a }
            java.lang.String r0 = "com.google.android.gms"
            r6.setPackage(r0)     // Catch:{ all -> 0x009a }
            com.google.android.gms.common.stats.ConnectionTracker r0 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ all -> 0x009a }
            com.google.android.gms.cloudmessaging.zze r1 = r5.zzf     // Catch:{ all -> 0x009a }
            android.content.Context r1 = r1.zzb     // Catch:{ all -> 0x009a }
            boolean r6 = r0.bindService(r1, r6, r5, r3)     // Catch:{ all -> 0x009a }
            if (r6 != 0) goto L_0x0086
            java.lang.String r6 = "Unable to bind to service"
            r5.zza(r2, r6)     // Catch:{ all -> 0x009a }
            goto L_0x0098
        L_0x0086:
            com.google.android.gms.cloudmessaging.zze r6 = r5.zzf     // Catch:{ all -> 0x009a }
            java.util.concurrent.ScheduledExecutorService r6 = r6.zzc     // Catch:{ all -> 0x009a }
            com.google.android.gms.cloudmessaging.zzh r0 = new com.google.android.gms.cloudmessaging.zzh     // Catch:{ all -> 0x009a }
            r0.<init>(r5)     // Catch:{ all -> 0x009a }
            r1 = 30
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x009a }
            r6.schedule(r0, r1, r4)     // Catch:{ all -> 0x009a }
        L_0x0098:
            monitor-exit(r5)
            return r3
        L_0x009a:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cloudmessaging.zzf.zza(com.google.android.gms.cloudmessaging.zzq):boolean");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0056, code lost:
        r5 = r5.getData();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0062, code lost:
        if (r5.getBoolean("unsupported", false) == false) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0064, code lost:
        r1.zza(new com.google.android.gms.cloudmessaging.zzp(4, "Not supported by GmsCore"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0070, code lost:
        r1.zza(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0073, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(android.os.Message r5) {
        /*
            r4 = this;
            int r0 = r5.arg1
            java.lang.String r1 = "MessengerIpcClient"
            r2 = 3
            boolean r1 = android.util.Log.isLoggable(r1, r2)
            if (r1 == 0) goto L_0x0025
            java.lang.String r1 = "MessengerIpcClient"
            r2 = 41
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Received response to request: "
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r1, r2)
        L_0x0025:
            monitor-enter(r4)
            android.util.SparseArray<com.google.android.gms.cloudmessaging.zzq<?>> r1 = r4.zze     // Catch:{ all -> 0x0074 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x0074 }
            com.google.android.gms.cloudmessaging.zzq r1 = (com.google.android.gms.cloudmessaging.zzq) r1     // Catch:{ all -> 0x0074 }
            r2 = 1
            if (r1 != 0) goto L_0x004d
            java.lang.String r5 = "MessengerIpcClient"
            r1 = 50
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0074 }
            r3.<init>(r1)     // Catch:{ all -> 0x0074 }
            java.lang.String r1 = "Received response for unknown request: "
            java.lang.StringBuilder r1 = r3.append(r1)     // Catch:{ all -> 0x0074 }
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch:{ all -> 0x0074 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0074 }
            android.util.Log.w(r5, r0)     // Catch:{ all -> 0x0074 }
            monitor-exit(r4)     // Catch:{ all -> 0x0074 }
            return r2
        L_0x004d:
            android.util.SparseArray<com.google.android.gms.cloudmessaging.zzq<?>> r3 = r4.zze     // Catch:{ all -> 0x0074 }
            r3.remove(r0)     // Catch:{ all -> 0x0074 }
            r4.zzb()     // Catch:{ all -> 0x0074 }
            monitor-exit(r4)     // Catch:{ all -> 0x0074 }
            android.os.Bundle r5 = r5.getData()
            java.lang.String r0 = "unsupported"
            r3 = 0
            boolean r0 = r5.getBoolean(r0, r3)
            if (r0 == 0) goto L_0x0070
            com.google.android.gms.cloudmessaging.zzp r5 = new com.google.android.gms.cloudmessaging.zzp
            r0 = 4
            java.lang.String r3 = "Not supported by GmsCore"
            r5.<init>(r0, r3)
            r1.zza((com.google.android.gms.cloudmessaging.zzp) r5)
            goto L_0x0073
        L_0x0070:
            r1.zza((android.os.Bundle) r5)
        L_0x0073:
            return r2
        L_0x0074:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0074 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cloudmessaging.zzf.zza(android.os.Message):boolean");
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        this.zzf.zzc.execute(new zzk(this, iBinder));
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zzf.zzc.execute(new zzj(this));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        this.zzf.zzc.execute(new zzm(this));
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza(int i, String str) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(str);
            Log.d("MessengerIpcClient", valueOf.length() != 0 ? "Disconnected: ".concat(valueOf) : new String("Disconnected: "));
        }
        int i2 = this.zza;
        if (i2 == 0) {
            throw new IllegalStateException();
        } else if (i2 == 1 || i2 == 2) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Unbinding service");
            }
            this.zza = 4;
            ConnectionTracker.getInstance().unbindService(this.zzf.zzb, this);
            zzp zzp = new zzp(i, str);
            for (zzq zza2 : this.zzd) {
                zza2.zza(zzp);
            }
            this.zzd.clear();
            for (int i3 = 0; i3 < this.zze.size(); i3++) {
                this.zze.valueAt(i3).zza(zzp);
            }
            this.zze.clear();
        } else if (i2 == 3) {
            this.zza = 4;
        } else if (i2 != 4) {
            throw new IllegalStateException(new StringBuilder(26).append("Unknown state: ").append(this.zza).toString());
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzb() {
        if (this.zza == 2 && this.zzd.isEmpty() && this.zze.size() == 0) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
            }
            this.zza = 3;
            ConnectionTracker.getInstance().unbindService(this.zzf.zzb, this);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzc() {
        if (this.zza == 1) {
            zza(1, "Timed out while binding");
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza(int i) {
        zzq zzq = this.zze.get(i);
        if (zzq != null) {
            Log.w("MessengerIpcClient", new StringBuilder(31).append("Timing out request: ").append(i).toString());
            this.zze.remove(i);
            zzq.zza(new zzp(3, "Timed out waiting for response"));
            zzb();
        }
    }
}
