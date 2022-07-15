package com.garfild63.coffee;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.List;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MenuFragment extends Fragment {

    private final String[] nameArr = {"Эспрессо", "Капучино", "Горячий шоколад", "Латте", "Горячий шоколад", "Латте"};
    private final int[] priceArr = {200, 200, 200, 200, 200, 200};
    private final String[] imageArr = {
            "https://github.com/Garfild63/Coffee/blob/master/app/src/main/res/drawable/espresso.png?raw=true",
            "https://github.com/Garfild63/Coffee/blob/master/app/src/main/res/drawable/capuccino.png?raw=true",
            "https://github.com/Garfild63/Coffee/blob/master/app/src/main/res/drawable/hot_chocolate.png?raw=true",
            "https://github.com/Garfild63/Coffee/blob/master/app/src/main/res/drawable/latte.png?raw=true",
            "https://github.com/Garfild63/Coffee/blob/master/app/src/main/res/drawable/hot_chocolate.png?raw=true",
            "https://github.com/Garfild63/Coffee/blob/master/app/src/main/res/drawable/latte.png?raw=true"};
    private final MyCoffee[] arr = new MyCoffee[nameArr.length];

    private static final String BASE_URL = "http://185.244.172.108:8080/";

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_menu, container, false);
        Toolbar toolbar = (Toolbar) v.findViewById(R.id.toolbar);
        requireActivity().setActionBar(toolbar);
        requireActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
        Button button = (Button) v.findViewById(R.id.buttonToPayment);
        button.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            int quantity = 0;
            for (int i = 0; i < nameArr.length; i++) {
                if (MyCoffeeAdapter.values[i] != 0) {
                    bundle.putString("name" + quantity, nameArr[i]);
                    bundle.putString("price" + quantity, String.valueOf(priceArr[i]));
                    bundle.putString("value" + quantity, String.valueOf(MyCoffeeAdapter.values[i]));
                    quantity++;
                }
            }
            bundle.putString("quantity", String.valueOf(quantity));
            if (quantity != 0) {
                Navigation.findNavController(view).navigate(R.id.action_menuFragment_to_paymentFragment, bundle);
            } else {
                Toast.makeText(getActivity(), R.string.choose, Toast.LENGTH_SHORT).show();
            }
        });
        GridView g = (GridView) v.findViewById(R.id.gridView);
        MyCoffeeAdapter adapter = new MyCoffeeAdapter(getActivity(), makeCoffee());
        g.setAdapter(adapter);
        return v;
    }

    MyCoffee[] makeCoffee() {
        for (int i = 0; i < arr.length; i++) {
            MyCoffee coffee = new MyCoffee();
            coffee.id = i;
            coffee.name = nameArr[i];
            coffee.price = priceArr[i];
            coffee.imageURL = imageArr[i];
            arr[i] = coffee;
        }
        /* Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UserService service = retrofit.create(UserService.class);
        Call<List<MyCoffee>> call = service.getCoffees(Integer.parseInt(requireArguments().getString("id")));
        call.enqueue(new Callback<List<MyCoffee>>() {
            @Override
            public void onResponse(@NonNull Call<List<MyCoffee>> call, @NonNull Response<List<MyCoffee>> response) {
                if (response.isSuccessful()) {
                    List<MyCoffee> l = Objects.requireNonNull(response.body());
                    arr = new MyCoffee[l.size()];
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
            public void onFailure(@NonNull Call<List<MyCoffee>> call, @NonNull Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }); */
        return arr;
    }
}