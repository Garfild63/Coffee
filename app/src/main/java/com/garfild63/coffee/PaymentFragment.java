package com.garfild63.coffee;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.fragment.app.ListFragment;

public class PaymentFragment extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_payment, container, false);
        Toolbar toolbar = (Toolbar) v.findViewById(R.id.toolbar);
        requireActivity().setActionBar(toolbar);
        requireActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
        Button button = (Button) v.findViewById(R.id.buttonPay);
        button.setOnClickListener(view -> Toast.makeText(getActivity(), R.string.paid, Toast.LENGTH_SHORT).show());
        MyOrderAdapter adapter = new MyOrderAdapter(getActivity(), makeOrder());
        setListAdapter(adapter);
        return v;
    }

    MyOrder[] makeOrder() {
        int quantity = Integer.parseInt(requireArguments().getString("quantity"));
        MyOrder[] arr = new MyOrder[quantity];
        for (int i = 0; i < arr.length; i++) {
            MyOrder order = new MyOrder();
            order.name = requireArguments().getString("name" + i);
            order.price = Integer.parseInt(requireArguments().getString("price" + i));
            order.value = Integer.parseInt(requireArguments().getString("value" + i));
            arr[i] = order;
        }
        return arr;
    }
}