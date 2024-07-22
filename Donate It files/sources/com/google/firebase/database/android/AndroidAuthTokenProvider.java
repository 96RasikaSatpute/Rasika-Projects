package com.google.firebase.database.android;

import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.database.core.AuthTokenProvider;
import com.google.firebase.inject.Deferred;
import com.google.firebase.internal.api.FirebaseNoSignedInUserException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;

public class AndroidAuthTokenProvider implements AuthTokenProvider {
    private final Deferred<InternalAuthProvider> deferredAuthProvider;
    private final AtomicReference<InternalAuthProvider> internalAuth = new AtomicReference<>();

    public AndroidAuthTokenProvider(Deferred<InternalAuthProvider> deferredAuthProvider2) {
        this.deferredAuthProvider = deferredAuthProvider2;
        deferredAuthProvider2.whenAvailable(AndroidAuthTokenProvider$$Lambda$1.lambdaFactory$(this));
    }

    public void getToken(boolean forceRefresh, AuthTokenProvider.GetTokenCompletionListener listener) {
        InternalAuthProvider authProvider = this.internalAuth.get();
        if (authProvider != null) {
            authProvider.getAccessToken(forceRefresh).addOnSuccessListener(AndroidAuthTokenProvider$$Lambda$2.lambdaFactory$(listener)).addOnFailureListener(AndroidAuthTokenProvider$$Lambda$3.lambdaFactory$(listener));
        } else {
            listener.onSuccess((String) null);
        }
    }

    static /* synthetic */ void lambda$getToken$2(AuthTokenProvider.GetTokenCompletionListener listener, Exception e) {
        if (isUnauthenticatedUsage(e)) {
            listener.onSuccess((String) null);
        } else {
            listener.onError(e.getMessage());
        }
    }

    public void addTokenChangeListener(ExecutorService executorService, AuthTokenProvider.TokenChangeListener tokenListener) {
        this.deferredAuthProvider.whenAvailable(AndroidAuthTokenProvider$$Lambda$4.lambdaFactory$(executorService, tokenListener));
    }

    public void removeTokenChangeListener(AuthTokenProvider.TokenChangeListener tokenListener) {
    }

    private static boolean isUnauthenticatedUsage(Exception e) {
        return (e instanceof FirebaseApiNotAvailableException) || (e instanceof FirebaseNoSignedInUserException);
    }
}
