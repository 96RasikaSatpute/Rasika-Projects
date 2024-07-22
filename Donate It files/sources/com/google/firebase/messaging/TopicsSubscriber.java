package com.google.firebase.messaging;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.GmsRpc;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
class TopicsSubscriber {
    private static final long MAX_DELAY_SEC = TimeUnit.HOURS.toSeconds(8);
    private final Context context;
    private final FirebaseInstallationsApi firebaseInstallationsApi;
    private final FirebaseMessaging firebaseMessaging;
    private final Metadata metadata;
    private final Map<String, ArrayDeque<TaskCompletionSource<Void>>> pendingOperations = new ArrayMap();
    private final GmsRpc rpc;
    private final TopicsStore store;
    private final ScheduledExecutorService syncExecutor;
    private boolean syncScheduledOrRunning = false;

    private TopicsSubscriber(FirebaseMessaging firebaseMessaging2, FirebaseInstallationsApi firebaseInstallationsApi2, Metadata metadata2, TopicsStore topicsStore, GmsRpc gmsRpc, Context context2, ScheduledExecutorService scheduledExecutorService) {
        this.firebaseMessaging = firebaseMessaging2;
        this.firebaseInstallationsApi = firebaseInstallationsApi2;
        this.metadata = metadata2;
        this.store = topicsStore;
        this.rpc = gmsRpc;
        this.context = context2;
        this.syncExecutor = scheduledExecutorService;
    }

    private void addToPendingOperations(TopicOperation topicOperation, TaskCompletionSource<Void> taskCompletionSource) {
        ArrayDeque arrayDeque;
        synchronized (this.pendingOperations) {
            String serialize = topicOperation.serialize();
            if (this.pendingOperations.containsKey(serialize)) {
                arrayDeque = this.pendingOperations.get(serialize);
            } else {
                ArrayDeque arrayDeque2 = new ArrayDeque();
                this.pendingOperations.put(serialize, arrayDeque2);
                arrayDeque = arrayDeque2;
            }
            arrayDeque.add(taskCompletionSource);
        }
    }

    private static <T> T awaitTask(Task<T> task) throws IOException {
        try {
            return Tasks.await(task, 30, TimeUnit.SECONDS);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            } else if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else {
                throw new IOException(e);
            }
        } catch (InterruptedException | TimeoutException e2) {
            throw new IOException(GmsRpc.ERROR_SERVICE_NOT_AVAILABLE, e2);
        }
    }

    private void blockingSubscribeToTopic(String str) throws IOException {
        awaitTask(this.rpc.subscribeToTopic((String) awaitTask(this.firebaseInstallationsApi.getId()), this.firebaseMessaging.blockingGetToken(), str));
    }

    private void blockingUnsubscribeFromTopic(String str) throws IOException {
        awaitTask(this.rpc.unsubscribeFromTopic((String) awaitTask(this.firebaseInstallationsApi.getId()), this.firebaseMessaging.blockingGetToken(), str));
    }

    static Task<TopicsSubscriber> createInstance(FirebaseMessaging firebaseMessaging2, FirebaseInstallationsApi firebaseInstallationsApi2, Metadata metadata2, GmsRpc gmsRpc, Context context2, ScheduledExecutorService scheduledExecutorService) {
        return Tasks.call(scheduledExecutorService, new TopicsSubscriber$$Lambda$0(context2, scheduledExecutorService, firebaseMessaging2, firebaseInstallationsApi2, metadata2, gmsRpc));
    }

    static boolean isDebugLogEnabled() {
        if (Log.isLoggable(Constants.TAG, 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable(Constants.TAG, 3))) {
            return true;
        }
        return false;
    }

    static final /* synthetic */ TopicsSubscriber lambda$createInstance$0$TopicsSubscriber(Context context2, ScheduledExecutorService scheduledExecutorService, FirebaseMessaging firebaseMessaging2, FirebaseInstallationsApi firebaseInstallationsApi2, Metadata metadata2, GmsRpc gmsRpc) throws Exception {
        return new TopicsSubscriber(firebaseMessaging2, firebaseInstallationsApi2, metadata2, TopicsStore.getInstance(context2, scheduledExecutorService), gmsRpc, context2, scheduledExecutorService);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void markCompletePendingOperation(com.google.firebase.messaging.TopicOperation r5) {
        /*
            r4 = this;
            java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>>> r0 = r4.pendingOperations
            monitor-enter(r0)
            java.lang.String r5 = r5.serialize()     // Catch:{ all -> 0x0032 }
            java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>>> r1 = r4.pendingOperations     // Catch:{ all -> 0x0032 }
            boolean r1 = r1.containsKey(r5)     // Catch:{ all -> 0x0032 }
            if (r1 != 0) goto L_0x0011
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return
        L_0x0011:
            java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>>> r1 = r4.pendingOperations     // Catch:{ all -> 0x0032 }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x0032 }
            java.util.ArrayDeque r1 = (java.util.ArrayDeque) r1     // Catch:{ all -> 0x0032 }
            java.lang.Object r2 = r1.poll()     // Catch:{ all -> 0x0032 }
            com.google.android.gms.tasks.TaskCompletionSource r2 = (com.google.android.gms.tasks.TaskCompletionSource) r2     // Catch:{ all -> 0x0032 }
            if (r2 == 0) goto L_0x0025
            r3 = 0
            r2.setResult(r3)     // Catch:{ all -> 0x0032 }
        L_0x0025:
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x0030
            java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>>> r1 = r4.pendingOperations     // Catch:{ all -> 0x0032 }
            r1.remove(r5)     // Catch:{ all -> 0x0032 }
        L_0x0030:
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return
        L_0x0032:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.TopicsSubscriber.markCompletePendingOperation(com.google.firebase.messaging.TopicOperation):void");
    }

    private void startSync() {
        if (!isSyncScheduledOrRunning()) {
            syncWithDelaySecondsInternal(0);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean hasPendingOperation() {
        return this.store.getNextTopicOperation() != null;
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean isSyncScheduledOrRunning() {
        return this.syncScheduledOrRunning;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0092 A[Catch:{ IOException -> 0x00c5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean performTopicOperation(com.google.firebase.messaging.TopicOperation r7) throws java.io.IOException {
        /*
            r6 = this;
            java.lang.String r0 = "FirebaseMessaging"
            r1 = 0
            java.lang.String r2 = r7.getOperation()     // Catch:{ IOException -> 0x00c5 }
            int r3 = r2.hashCode()     // Catch:{ IOException -> 0x00c5 }
            r4 = 83
            r5 = 1
            if (r3 == r4) goto L_0x0020
            r4 = 85
            if (r3 == r4) goto L_0x0015
        L_0x0014:
            goto L_0x002a
        L_0x0015:
            java.lang.String r3 = "U"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0014
            r2 = r5
            goto L_0x002b
        L_0x0020:
            java.lang.String r3 = "S"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0014
            r2 = r1
            goto L_0x002b
        L_0x002a:
            r2 = -1
        L_0x002b:
            java.lang.String r3 = " succeeded."
            if (r2 == 0) goto L_0x0092
            if (r2 == r5) goto L_0x005f
            boolean r2 = isDebugLogEnabled()     // Catch:{ IOException -> 0x00c5 }
            if (r2 == 0) goto L_0x00c4
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ IOException -> 0x00c5 }
            java.lang.String r2 = java.lang.String.valueOf(r7)     // Catch:{ IOException -> 0x00c5 }
            int r2 = r2.length()     // Catch:{ IOException -> 0x00c5 }
            int r2 = r2 + 24
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00c5 }
            r3.<init>(r2)     // Catch:{ IOException -> 0x00c5 }
            java.lang.String r2 = "Unknown topic operation"
            r3.append(r2)     // Catch:{ IOException -> 0x00c5 }
            r3.append(r7)     // Catch:{ IOException -> 0x00c5 }
            java.lang.String r7 = "."
            r3.append(r7)     // Catch:{ IOException -> 0x00c5 }
            java.lang.String r7 = r3.toString()     // Catch:{ IOException -> 0x00c5 }
            android.util.Log.d(r0, r7)     // Catch:{ IOException -> 0x00c5 }
            goto L_0x00c4
        L_0x005f:
            java.lang.String r2 = r7.getTopic()     // Catch:{ IOException -> 0x00c5 }
            r6.blockingUnsubscribeFromTopic(r2)     // Catch:{ IOException -> 0x00c5 }
            boolean r2 = isDebugLogEnabled()     // Catch:{ IOException -> 0x00c5 }
            if (r2 == 0) goto L_0x00c4
            java.lang.String r7 = r7.getTopic()     // Catch:{ IOException -> 0x00c5 }
            java.lang.String r2 = java.lang.String.valueOf(r7)     // Catch:{ IOException -> 0x00c5 }
            int r2 = r2.length()     // Catch:{ IOException -> 0x00c5 }
            int r2 = r2 + 35
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00c5 }
            r4.<init>(r2)     // Catch:{ IOException -> 0x00c5 }
            java.lang.String r2 = "Unsubscribe from topic: "
            r4.append(r2)     // Catch:{ IOException -> 0x00c5 }
            r4.append(r7)     // Catch:{ IOException -> 0x00c5 }
            r4.append(r3)     // Catch:{ IOException -> 0x00c5 }
            java.lang.String r7 = r4.toString()     // Catch:{ IOException -> 0x00c5 }
            android.util.Log.d(r0, r7)     // Catch:{ IOException -> 0x00c5 }
            goto L_0x00c4
        L_0x0092:
            java.lang.String r2 = r7.getTopic()     // Catch:{ IOException -> 0x00c5 }
            r6.blockingSubscribeToTopic(r2)     // Catch:{ IOException -> 0x00c5 }
            boolean r2 = isDebugLogEnabled()     // Catch:{ IOException -> 0x00c5 }
            if (r2 == 0) goto L_0x00c4
            java.lang.String r7 = r7.getTopic()     // Catch:{ IOException -> 0x00c5 }
            java.lang.String r2 = java.lang.String.valueOf(r7)     // Catch:{ IOException -> 0x00c5 }
            int r2 = r2.length()     // Catch:{ IOException -> 0x00c5 }
            int r2 = r2 + 31
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00c5 }
            r4.<init>(r2)     // Catch:{ IOException -> 0x00c5 }
            java.lang.String r2 = "Subscribe to topic: "
            r4.append(r2)     // Catch:{ IOException -> 0x00c5 }
            r4.append(r7)     // Catch:{ IOException -> 0x00c5 }
            r4.append(r3)     // Catch:{ IOException -> 0x00c5 }
            java.lang.String r7 = r4.toString()     // Catch:{ IOException -> 0x00c5 }
            android.util.Log.d(r0, r7)     // Catch:{ IOException -> 0x00c5 }
        L_0x00c4:
            return r5
        L_0x00c5:
            r7 = move-exception
            java.lang.String r2 = r7.getMessage()
            java.lang.String r3 = "SERVICE_NOT_AVAILABLE"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x00ed
            java.lang.String r2 = r7.getMessage()
            java.lang.String r3 = "INTERNAL_SERVER_ERROR"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x00df
            goto L_0x00ed
        L_0x00df:
            java.lang.String r2 = r7.getMessage()
            if (r2 != 0) goto L_0x00ec
            java.lang.String r7 = "Topic operation failed without exception message. Will retry Topic operation."
            android.util.Log.e(r0, r7)
            return r1
        L_0x00ec:
            throw r7
        L_0x00ed:
            java.lang.String r7 = r7.getMessage()
            java.lang.String r2 = java.lang.String.valueOf(r7)
            int r2 = r2.length()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            int r2 = r2 + 53
            r3.<init>(r2)
            java.lang.String r2 = "Topic operation failed: "
            r3.append(r2)
            r3.append(r7)
            java.lang.String r7 = ". Will retry Topic operation."
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            android.util.Log.e(r0, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.TopicsSubscriber.performTopicOperation(com.google.firebase.messaging.TopicOperation):boolean");
    }

    /* access modifiers changed from: package-private */
    public void scheduleSyncTaskWithDelaySeconds(Runnable runnable, long j) {
        this.syncExecutor.schedule(runnable, j, TimeUnit.SECONDS);
    }

    /* access modifiers changed from: package-private */
    public Task<Void> scheduleTopicOperation(TopicOperation topicOperation) {
        this.store.addTopicOperation(topicOperation);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        addToPendingOperations(topicOperation, taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    /* access modifiers changed from: package-private */
    public synchronized void setSyncScheduledOrRunning(boolean z) {
        this.syncScheduledOrRunning = z;
    }

    /* access modifiers changed from: package-private */
    public void startTopicsSyncIfNecessary() {
        if (hasPendingOperation()) {
            startSync();
        }
    }

    /* access modifiers changed from: package-private */
    public Task<Void> subscribeToTopic(String str) {
        Task<Void> scheduleTopicOperation = scheduleTopicOperation(TopicOperation.subscribe(str));
        startTopicsSyncIfNecessary();
        return scheduleTopicOperation;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        if (performTopicOperation(r0) != false) goto L_0x0023;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0021, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0018, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean syncTopics() throws java.io.IOException {
        /*
            r2 = this;
        L_0x0000:
            monitor-enter(r2)
            com.google.firebase.messaging.TopicsStore r0 = r2.store     // Catch:{ all -> 0x002c }
            com.google.firebase.messaging.TopicOperation r0 = r0.getNextTopicOperation()     // Catch:{ all -> 0x002c }
            if (r0 != 0) goto L_0x001a
            boolean r0 = isDebugLogEnabled()     // Catch:{ all -> 0x002c }
            if (r0 == 0) goto L_0x0017
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.String r1 = "topic sync succeeded"
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x002c }
        L_0x0017:
            monitor-exit(r2)     // Catch:{ all -> 0x002c }
            r0 = 1
            return r0
        L_0x001a:
            monitor-exit(r2)     // Catch:{ all -> 0x002c }
            boolean r1 = r2.performTopicOperation(r0)
            if (r1 != 0) goto L_0x0023
            r0 = 0
            return r0
        L_0x0023:
            com.google.firebase.messaging.TopicsStore r1 = r2.store
            r1.removeTopicOperation(r0)
            r2.markCompletePendingOperation(r0)
            goto L_0x0000
        L_0x002c:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x002c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.TopicsSubscriber.syncTopics():boolean");
    }

    /* access modifiers changed from: package-private */
    public void syncWithDelaySecondsInternal(long j) {
        scheduleSyncTaskWithDelaySeconds(new TopicsSyncTask(this, this.context, this.metadata, Math.min(Math.max(30, j + j), MAX_DELAY_SEC)), j);
        setSyncScheduledOrRunning(true);
    }

    /* access modifiers changed from: package-private */
    public Task<Void> unsubscribeFromTopic(String str) {
        Task<Void> scheduleTopicOperation = scheduleTopicOperation(TopicOperation.unsubscribe(str));
        startTopicsSyncIfNecessary();
        return scheduleTopicOperation;
    }
}
