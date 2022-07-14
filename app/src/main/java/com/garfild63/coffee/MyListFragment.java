package com.garfild63.coffee;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.List;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;
import androidx.navigation.Navigation;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyListFragment extends ListFragment {

    private final String[] nameArr = {"BEDOEV COFFEE", "Coffee Like", "EM&DI Coffee and Snacks", "Коффе есть", "BEDOEV COFFEE 2"};
    private final MyCafe.Point[] pointArr = {
            new MyCafe.Point(0.5, 0.5),
            new MyCafe.Point(0.6, 1.4),
            new MyCafe.Point(0.7, 0.3),
            new MyCafe.Point(0.1, 0.2),
            new MyCafe.Point(1.7, 1.3)};
    private final MyCafe[] arr = new MyCafe[nameArr.length];

    private static final String BASE_URL = "http://185.244.172.108:8080/";

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
        Bundle bundle = new Bundle();
        bundle.putString("id", String.valueOf(arr[position].id));
        Navigation.findNavController(v).navigate(R.id.action_listFragment_to_menuFragment, bundle);
    }

    MyCafe[] makeCafe() {
        for (int i = 0; i < arr.length; i++) {
            MyCafe cafe = new MyCafe();
            cafe.id = i;
            cafe.name = nameArr[i];
            cafe.point = pointArr[i];
            arr[i] = cafe;
        }
        /* Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UserService service = retrofit.create(UserService.class);
        Call<List<MyCafe>> call = service.getCafes();
        call.enqueue(new Callback<List<MyCafe>>() {
            @Override
            public void onResponse(@NonNull Call<List<MyCafe>> call, @NonNull Response<List<MyCafe>> response) {
                if (response.isSuccessful()) {
                    List<MyCafe> l = Objects.requireNonNull(response.body());
                    arr = new MyCafe[l.size()];
                    for (int i = 0; i < l.size(); i++) {
                        arr[i] = l.get(i);
                    }
                } else {
                    switch (response.code()) {
                        case 401:
                            Toast.makeText(getActivity(), "Пользователь не авторизован", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<MyCafe>> call, @NonNull Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }); */
        return arr;
    }
}