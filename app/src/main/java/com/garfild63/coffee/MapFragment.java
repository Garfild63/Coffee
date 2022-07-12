package com.garfild63.coffee;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toolbar;

import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class MapFragment extends Fragment {

    private MapView mapView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_map, container, false);
        Toolbar toolbar = (Toolbar) v.findViewById(R.id.toolbar);
        requireActivity().setActionBar(toolbar);
        requireActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
        /* Button button = (Button) v.findViewById(R.id.buttonMenu);
        button.setOnClickListener(view -> Navigation.findNavController(view).navigate(R.id.action_mapFragment_to_menuFragment)); */
        mapView = (MapView) v.findViewById(R.id.mapView);
        mapView.getMap().move(
                new CameraPosition(new Point(44.67342, 37.77034), 11.0f, 0.0f, 0.0f),
                new Animation(Animation.Type.SMOOTH, 0),
                null);
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
        MapKitFactory.getInstance().onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
        MapKitFactory.getInstance().onStop();
    }
}