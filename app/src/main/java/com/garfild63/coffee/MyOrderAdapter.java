package com.garfild63.coffee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class MyOrderAdapter extends ArrayAdapter<MyOrder> {

    public static int[] values;
    private final TextView[] tv;

    public MyOrderAdapter(Context context, MyOrder[] arr) {
        super(context, R.layout.adapter_order_item, arr);
        values = new int[arr.length];
        tv = new TextView[arr.length];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final MyOrder order = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_order_item, parent, false);
        }

        if (tv[position] == null) {
            tv[position] = (TextView) convertView.findViewById(R.id.textViewNumber);
            values[position] = order.value;
            tv[position].setText(String.valueOf(values[position]));
        }

        ((TextView) convertView.findViewById(R.id.textViewName)).setText(order.name);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        ((TextView) convertView.findViewById(R.id.textViewPrice)).setText(String.valueOf(order.price) + " руб");
=======
        ((TextView) convertView.findViewById(R.id.textViewPrice)).setText(order.price);
>>>>>>> 5b2d7d6d53763c8eeac1c4a0eebed2804287acd7
=======
        ((TextView) convertView.findViewById(R.id.textViewPrice)).setText(order.price);
>>>>>>> 5b2d7d6d53763c8eeac1c4a0eebed2804287acd7
=======
        ((TextView) convertView.findViewById(R.id.textViewPrice)).setText(order.price);
>>>>>>> 5b2d7d6d53763c8eeac1c4a0eebed2804287acd7
=======
        ((TextView) convertView.findViewById(R.id.textViewPrice)).setText(order.price);
>>>>>>> 5b2d7d6d53763c8eeac1c4a0eebed2804287acd7
        ((Button) convertView.findViewById(R.id.minusButton)).setOnClickListener(view -> {
            if (values[position] > 0) {
                values[position]--;
                tv[position].setText(String.valueOf(values[position]));
            }
        });
        ((Button) convertView.findViewById(R.id.plusButton)).setOnClickListener(view -> {
            values[position]++;
            tv[position].setText(String.valueOf(values[position]));
        });

        return convertView;
    }
}
