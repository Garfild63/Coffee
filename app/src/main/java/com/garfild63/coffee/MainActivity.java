package com.garfild63.coffee;

import androidx.fragment.app.FragmentActivity;
import androidx.navigation.Navigation;

import android.os.Bundle;

import com.yandex.mapkit.MapKitFactory;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapKitFactory.setApiKey(MyApiKeys.YANDEX_MAPKIT);
        MapKitFactory.initialize(this);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onNavigateUp() {
        return Navigation.findNavController(this, R.id.my_nav_host_fragment).navigateUp();
    }
}