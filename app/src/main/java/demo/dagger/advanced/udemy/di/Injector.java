package demo.dagger.advanced.udemy.di;

import android.app.Activity;

import demo.dagger.advanced.udemy.base.BaseActivity;

public class Injector {

    private  Injector(){ }

    public static void inject(Activity activity){
        ActivityInjector.get(activity).inject(activity);
    }

    public static void clearComponent(Activity activity) {
        ActivityInjector.get(activity).clear(activity);
    }
}
