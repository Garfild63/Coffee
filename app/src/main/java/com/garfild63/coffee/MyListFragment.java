package com.garfild63.coffee;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;
import androidx.navigation.Navigation;

public class MyListFragment extends ListFragment {

    String[] nameArr = {"BEDOEV COFFEE", "Coffee Like", "EM&DI Coffee and Snacks", "Коффе есть", "BEDOEV COFFEE 2"};
    String[] destArr = {"1 км от вас", "2 км от вас", "1 км от вас", "300 м от вас", "3 км от вас"};

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);
        Toolbar toolbar = (Toolbar) v.findViewById(R.id.toolbar);
        requireActivity().setActionBar(toolbar);
        requireActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
        Button button = (Button) v.findViewById(R.id.buttonOnMap);
        button.setOnClickListener(view -> Navigation.findNavController(view).navigate(R.id.action_listFragment_to_mapFragment));
        MyCafeAdapter adapter = new MyCafeAdapter(getActivity(), makeCafe());
        setListAdapter(adapter);
        return v;
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        Navigation.findNavController(v).navigate(R.id.action_listFragment_to_menuFragment);
    }

    MyCafe[] makeCafe() {
        MyCafe[] arr = new MyCafe[nameArr.length];

        for (int i = 0; i < arr.length; i++) {
            MyCafe cafe = new MyCafe();
            cafe.name = nameArr[i];
            cafe.dest = destArr[i];
            arr[i] = cafe;
        }
        return arr;
    }
}