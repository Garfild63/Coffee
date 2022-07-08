package com.garfild63.coffee;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class MenuFragment extends Fragment {

    String[] nameArr = {"Эспрессо", "Капучино", "Горячий шоколад", "Латте", "Горячий шоколад", "Латте"};
    String[] priceArr = {"200 руб", "200 руб", "200 руб", "200 руб", "200 руб", "200 руб"};
    int[] imgArr = {R.drawable.espresso, R.drawable.capuccino, R.drawable.hot_chocolate, R.drawable.latte, R.drawable.hot_chocolate, R.drawable.latte};

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
                    bundle.putString("price" + quantity, priceArr[i]);
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
        MyCoffee[] arr = new MyCoffee[nameArr.length];

        for (int i = 0; i < arr.length; i++) {
            MyCoffee coffee = new MyCoffee();
            coffee.name = nameArr[i];
            coffee.price = priceArr[i];
            coffee.img = imgArr[i];
            arr[i] = coffee;
        }
        return arr;
    }
}