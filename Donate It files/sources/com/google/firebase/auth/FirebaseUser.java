package com.google.firebase.auth;

import android.app.Activity;
import android.net.Uri;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.p001firebaseauthapi.zzwv;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public abstract class FirebaseUser extends AbstractSafeParcelable implements UserInfo {
    public Task<Void> delete() {
        return FirebaseAuth.getInstance(zzd()).zzy(this);
    }

    public abstract String getDisplayName();

    public abstract String getEmail();

    public Task<GetTokenResult> getIdToken(boolean forceRefresh) {
        return FirebaseAuth.getInstance(zzd()).zzh(this, forceRefresh);
    }

    public abstract FirebaseUserMetadata getMetadata();

    public abstract MultiFactor getMultiFactor();

    public abstract String getPhoneNumber();

    public abstract Uri getPhotoUrl();

    public abstract List<? extends UserInfo> getProviderData();

    public abstract String getProviderId();

    public abstract String getTenantId();

    public abstract String getUid();

    public abstract boolean isAnonymous();

    public Task<AuthResult> linkWithCredential(AuthCredential credential) {
        Preconditions.checkNotNull(credential);
        return FirebaseAuth.getInstance(zzd()).zzn(this, credential);
    }

    public Task<Void> reauthenticate(AuthCredential credential) {
        Preconditions.checkNotNull(credential);
        return FirebaseAuth.getInstance(zzd()).zzi(this, credential);
    }

    public Task<AuthResult> reauthenticateAndRetrieveData(AuthCredential credential) {
        Preconditions.checkNotNull(credential);
        return FirebaseAuth.getInstance(zzd()).zzj(this, credential);
    }

    public Task<Void> reload() {
        FirebaseAuth instance = FirebaseAuth.getInstance(zzd());
        return instance.zzm(this, new zzt(instance));
    }

    public Task<Void> sendEmailVerification() {
        return FirebaseAuth.getInstance(zzd()).zzh(this, false).continueWithTask(new zzw(this));
    }

    public Task<AuthResult> startActivityForLinkWithProvider(Activity activity, FederatedAuthProvider federatedAuthProvider) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(federatedAuthProvider);
        return FirebaseAuth.getInstance(zzd()).zzw(activity, federatedAuthProvider, this);
    }

    public Task<AuthResult> startActivityForReauthenticateWithProvider(Activity activity, FederatedAuthProvider federatedAuthProvider) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(federatedAuthProvider);
        return FirebaseAuth.getInstance(zzd()).zzx(activity, federatedAuthProvider, this);
    }

    public Task<AuthResult> unlink(String provider) {
        Preconditions.checkNotEmpty(provider);
        return FirebaseAuth.getInstance(zzd()).zzo(this, provider);
    }

    public Task<Void> updateEmail(String email) {
        Preconditions.checkNotEmpty(email);
        return FirebaseAuth.getInstance(zzd()).zzq(this, email);
    }

    public Task<Void> updatePassword(String password) {
        Preconditions.checkNotEmpty(password);
        return FirebaseAuth.getInstance(zzd()).zzs(this, password);
    }

    public Task<Void> updatePhoneNumber(PhoneAuthCredential credential) {
        return FirebaseAuth.getInstance(zzd()).zzr(this, credential);
    }

    public Task<Void> updateProfile(UserProfileChangeRequest request) {
        Preconditions.checkNotNull(request);
        return FirebaseAuth.getInstance(zzd()).zzp(this, request);
    }

    public Task<Void> verifyBeforeUpdateEmail(String newEmail) {
        return verifyBeforeUpdateEmail(newEmail, (ActionCodeSettings) null);
    }

    public abstract List<String> zza();

    public abstract FirebaseUser zzb(List<? extends UserInfo> list);

    public abstract FirebaseUser zzc();

    public abstract FirebaseApp zzd();

    public abstract zzwv zze();

    public abstract void zzf(zzwv zzwv);

    public abstract String zzg();

    public abstract String zzh();

    public abstract void zzi(List<MultiFactorInfo> list);

    public Task<Void> verifyBeforeUpdateEmail(String newEmail, ActionCodeSettings actionCodeSettings) {
        return FirebaseAuth.getInstance(zzd()).zzh(this, false).continueWithTask(new zzy(this, newEmail, actionCodeSettings));
    }

    public Task<Void> sendEmailVerification(ActionCodeSettings actionCodeSettings) {
        return FirebaseAuth.getInstance(zzd()).zzh(this, false).continueWithTask(new zzx(this, actionCodeSettings));
    }
}
