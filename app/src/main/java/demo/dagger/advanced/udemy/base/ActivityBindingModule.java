package demo.dagger.advanced.udemy.base;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import demo.dagger.advanced.udemy.home.MainActivity;
import demo.dagger.advanced.udemy.home.MainActivityComponent;

@Module(subcomponents = {
        MainActivityComponent.class
})
public abstract class ActivityBindingModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> providesMainActivityInjector(MainActivityComponent.Builder builder);
}
