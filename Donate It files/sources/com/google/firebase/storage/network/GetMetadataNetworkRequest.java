package com.google.firebase.storage.network;

import android.net.Uri;
import com.google.firebase.FirebaseApp;

public class GetMetadataNetworkRequest extends NetworkRequest {
    public GetMetadataNetworkRequest(Uri gsUri, FirebaseApp app) {
        super(gsUri, app);
    }

    /* access modifiers changed from: protected */
    public String getAction() {
        return "GET";
    }
}
