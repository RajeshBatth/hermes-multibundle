# hermes-multibundle


This project is to test loading multiple bundles on hermes in a single context

Here we load default bundle first and then load the second bundle from file-system after some timeout


```
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(this::loadAsyncJs, 2000);
    }
    
    private void loadAsyncJs() {
        String fileName = copyAsyncJsToFs();
        Log.d(TAG, "loadAsyncJs: " + fileName);
        ReactInstanceManager reactInstanceManager = getReactNativeHost().getReactInstanceManager();
        CatalystInstance catalystInstance = reactInstanceManager.getCurrentReactContext().getCatalystInstance();
        catalystInstance.loadScriptFromFile(fileName, null, false);
    }

```

second bundle file: app/src/main/assets/async.js
This just imports the code from main bundle.

We can see the result in logcat
```adb logcat -s "ReactNativeJS"```
