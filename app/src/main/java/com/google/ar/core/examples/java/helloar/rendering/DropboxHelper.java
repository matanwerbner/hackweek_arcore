package com.google.ar.core.examples.java.helloar.rendering;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.support.v4.content.ContextCompat;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.Metadata;
import java.net.URL;
import android.util.Log;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by matanw on 2/12/18.
 */

public class DropboxHelper {
    private final String ACCESS_TOKEN = "biv43ufU1VAAAAAAAAABnxlgEDXykDAW1yPn2SXHDlN2_QUSO0IpKBdrSEAyHwZ_";
    private DbxClientV2 client;
    public List<Metadata> GetFiles() {
        try {
            return client.files().listFolder("/models/").getEntries();
        }catch(Exception e) {
            Log.e("ERROR", e.getMessage());
            return null;
        }
    }

    public InputStream DownloadFile(String path) {
        try {
            return client.files().download(path).getInputStream();
        }catch(Exception e) {
            Log.e("ERROR", e.getMessage());
            return null;
        }
    };

    public DropboxHelper() {
        client = new DbxClientV2(
                new DbxRequestConfig("dropbox/hackweek-arcore", "en_US"),
                ACCESS_TOKEN
        );
    }
}
