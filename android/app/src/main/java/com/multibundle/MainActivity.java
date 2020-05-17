package com.multibundle;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.CatalystInstance;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends ReactActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(this::loadAsyncJs, 2000);
    }

    private static final String TAG = "MainActivity";

    private void loadAsyncJs() {
        String fileName = copyAsyncJsToFs();
        Log.d(TAG, "loadAsyncJs: " + fileName);
        ReactInstanceManager reactInstanceManager = getReactNativeHost().getReactInstanceManager();
        CatalystInstance catalystInstance = reactInstanceManager.getCurrentReactContext().getCatalystInstance();
        catalystInstance.loadScriptFromFile(fileName, null, false);
    }

    private String copyAsyncJsToFs() {
        try {
            InputStream assetStream = getAssets().open("async.bundle");
            File file = new File(getCacheDir(), "async.js");
            FileOutputStream fileOutputStream = new FileOutputStream(file);

            byte[] buf = new byte[1024];
            while (true) {
                int read = assetStream.read(buf);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(buf, 0, read);
            }
            fileOutputStream.flush();
            assetStream.close();
            fileOutputStream.close();
            return file.getPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
        return "main";
    }

    @Override
    protected ReactActivityDelegate createReactActivityDelegate() {
        return new ReactActivityDelegate(this, getMainComponentName()) {

        };
    }
}
