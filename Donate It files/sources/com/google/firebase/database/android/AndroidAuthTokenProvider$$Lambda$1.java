package com.google.firebase.database.android;

import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

/* compiled from: AndroidAuthTokenProvider */
final /* synthetic */ class AndroidAuthTokenProvider$$Lambda$1 implements Deferred.DeferredHandler {
    private final AndroidAuthTokenProvider arg$1;

    private AndroidAuthTokenProvider$$Lambda$1(AndroidAuthTokenProvider androidAuthTokenProvider) {
        this.arg$1 = androidAuthTokenProvider;
    }

    public static Deferred.DeferredHandler lambdaFactory$(AndroidAuthTokenProvider androidAuthTokenProvider) {
        return new AndroidAuthTokenProvider$$Lambda$1(androidAuthTokenProvider);
    }

    public void handle(Provider provider) {
        this.arg$1.internalAuth.set((InternalAuthProvider) provider.get());
    }
}
