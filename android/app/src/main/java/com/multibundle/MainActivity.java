package com.multibundle;

import android.os.Bundle;
import android.util.Log;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.CatalystInstance;

public class MainActivity extends ReactActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private static final String TAG = "MainActivity";

    private void loadAsyncJs() {
        String fileName = ChunkLoaderModule.copyAsyncJsToFs(this, "");
        Log.d(TAG, "loadAsyncJs: " + fileName);
        ReactInstanceManager reactInstanceManager = getReactNativeHost().getReactInstanceManager();
        CatalystInstance catalystInstance = reactInstanceManager.getCurrentReactContext().getCatalystInstance();
        catalystInstance.loadScriptFromFile(fileName, null, false);
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
