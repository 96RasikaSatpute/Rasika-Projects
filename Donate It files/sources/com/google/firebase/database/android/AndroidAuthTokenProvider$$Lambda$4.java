package com.google.firebase.database.android;

import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.database.core.AuthTokenProvider;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.concurrent.ExecutorService;

/* compiled from: AndroidAuthTokenProvider */
final /* synthetic */ class AndroidAuthTokenProvider$$Lambda$4 implements Deferred.DeferredHandler {
    private final ExecutorService arg$1;
    private final AuthTokenProvider.TokenChangeListener arg$2;

    private AndroidAuthTokenProvider$$Lambda$4(ExecutorService executorService, AuthTokenProvider.TokenChangeListener tokenChangeListener) {
        this.arg$1 = executorService;
        this.arg$2 = tokenChangeListener;
    }

    public static Deferred.DeferredHandler lambdaFactory$(ExecutorService executorService, AuthTokenProvider.TokenChangeListener tokenChangeListener) {
        return new AndroidAuthTokenProvider$$Lambda$4(executorService, tokenChangeListener);
    }

    public void handle(Provider provider) {
        ((InternalAuthProvider) provider.get()).addIdTokenListener(AndroidAuthTokenProvider$$Lambda$5.lambdaFactory$(this.arg$1, this.arg$2));
    }
}
