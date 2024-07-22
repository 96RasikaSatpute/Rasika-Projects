package com.google.firebase.database.android;

import com.google.firebase.auth.internal.IdTokenListener;
import com.google.firebase.database.core.AuthTokenProvider;
import com.google.firebase.internal.InternalTokenResult;
import java.util.concurrent.ExecutorService;

/* compiled from: AndroidAuthTokenProvider */
final /* synthetic */ class AndroidAuthTokenProvider$$Lambda$5 implements IdTokenListener {
    private final ExecutorService arg$1;
    private final AuthTokenProvider.TokenChangeListener arg$2;

    private AndroidAuthTokenProvider$$Lambda$5(ExecutorService executorService, AuthTokenProvider.TokenChangeListener tokenChangeListener) {
        this.arg$1 = executorService;
        this.arg$2 = tokenChangeListener;
    }

    public static IdTokenListener lambdaFactory$(ExecutorService executorService, AuthTokenProvider.TokenChangeListener tokenChangeListener) {
        return new AndroidAuthTokenProvider$$Lambda$5(executorService, tokenChangeListener);
    }

    public void onIdTokenChanged(InternalTokenResult internalTokenResult) {
        this.arg$1.execute(AndroidAuthTokenProvider$$Lambda$6.lambdaFactory$(this.arg$2, internalTokenResult));
    }
}
