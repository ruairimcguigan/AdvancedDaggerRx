package demo.dagger.advanced.udemy.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.UUID;

import demo.dagger.advanced.udemy.di.Injector;

public abstract class BaseActivity extends AppCompatActivity{

    private String INSTANCE_ID = "instance id";
    private String instanceId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {

        if (savedInstanceState != null){
            instanceId = savedInstanceState.getString(INSTANCE_ID);
        }else {
            instanceId = UUID.randomUUID().toString();
        }
        Injector.inject(this);
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(INSTANCE_ID, instanceId);
    }

    public String getInstanceId(){
        return instanceId;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()){
            Injector.clearComponent(this);
        }
    }
}
