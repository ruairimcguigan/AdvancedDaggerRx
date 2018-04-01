package demo.dagger.advanced.udemy.home;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import demo.dagger.advanced.udemy.di.ActivityScope;

@ActivityScope
@Subcomponent
public interface MainActivityComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity>{

    }

}
