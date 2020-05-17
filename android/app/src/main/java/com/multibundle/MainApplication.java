package com.multibundle;

import android.app.Application;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainPackageConfig;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

public class MainApplication extends Application implements ReactApplication {

    private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
        @Override
        public boolean getUseDeveloperSupport() {
            return BuildConfig.DEBUG;
        }

        @Override
        protected List<ReactPackage> getPackages() {
            List<ReactPackage> packages = new ArrayList<>();
            packages.add(new MainReactPackage(getMainPackageConfig()));
            return packages;
        }

      private MainPackageConfig getMainPackageConfig(){
        return new MainPackageConfig
                .Builder()
                .build();
      }

        @Override
        protected String getJSMainModuleName() {
            return "index";
        }

        @Override
        protected @Nullable String getJSBundleFile() {
            return super.getJSBundleFile();
        }

        @Override
        protected @Nullable String getBundleAssetName() {
            return super.getBundleAssetName();
        }
    };

    @Override
    public ReactNativeHost getReactNativeHost() {
        return mReactNativeHost;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SoLoader.init(this, /* native exopackage */ false);
    }

}
