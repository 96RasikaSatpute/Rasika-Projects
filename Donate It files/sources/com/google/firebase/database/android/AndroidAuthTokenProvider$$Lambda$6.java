package com.google.firebase.database.android;

import com.google.firebase.database.core.AuthTokenProvider;
import com.google.firebase.internal.InternalTokenResult;

/* compiled from: AndroidAuthTokenProvider */
final /* synthetic */ class AndroidAuthTokenProvider$$Lambda$6 implements Runnable {
    private final AuthTokenProvider.TokenChangeListener arg$1;
    private final InternalTokenResult arg$2;

    private AndroidAuthTokenProvider$$Lambda$6(AuthTokenProvider.TokenChangeListener tokenChangeListener, InternalTokenResult internalTokenResult) {
        this.arg$1 = tokenChangeListener;
        this.arg$2 = internalTokenResult;
    }

    public static Runnable lambdaFactory$(AuthTokenProvider.TokenChangeListener tokenChangeListener, InternalTokenResult internalTokenResult) {
        return new AndroidAuthTokenProvider$$Lambda$6(tokenChangeListener, internalTokenResult);
    }

    public void run() {
        this.arg$1.onTokenChange(this.arg$2.getToken());
    }
}
