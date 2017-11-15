package com.example.rohit.mentora;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by Rohit on 24-12-2015.
 */
public class FBLauncher {
    public static Intent getOpenFacebookIntent(Context context, String profileUrl) {
        try {
            context.getPackageManager()
                    .getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse(profileUrl));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse(Constants.MENTORA_FB_URL));
        }
    }

}
