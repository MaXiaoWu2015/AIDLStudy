package com.example.xiaowu.aidlstudy;

import android.app.Application;

import com.konka.downloadcenter.FileDownloader;

/**
 * Created by xiaowu on 2016-7-3.
 */
public class APP extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FileDownloader.init(this);
    }
}
