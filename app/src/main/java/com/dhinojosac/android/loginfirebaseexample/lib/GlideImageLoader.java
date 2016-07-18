package com.dhinojosac.android.loginfirebaseexample.lib;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

/**
 * Created by negro-PC on 17-Jul-16.
 */
public class GlideImageLoader implements ImageLoader{
    private RequestManager glideRequestManager;

    public GlideImageLoader(Context context) {
        this.glideRequestManager = Glide.with(context);
    }

    @Override
    public void load(ImageView imgAvatar, String url) {
        glideRequestManager.load(url).into(imgAvatar);
    }
}
