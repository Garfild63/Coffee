package com.garfild63.coffee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MyCafeAdapter extends ArrayAdapter<MyCafe> {

    public MyCafeAdapter(Context context, MyCafe[] arr) {
        super(context, R.layout.adapter_item, arr);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final MyCafe cafe = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_item, parent, false);
        }

        ((TextView) convertView.findViewById(R.id.textViewName)).setText(cafe.name);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        ((TextView) convertView.findViewById(R.id.textViewDest)).setText(String.valueOf(cafe.point.latitude + cafe.point.longitude) + " км от вас");
=======
        ((TextView) convertView.findViewById(R.id.textViewDest)).setText(cafe.dest);
>>>>>>> 5b2d7d6d53763c8eeac1c4a0eebed2804287acd7
=======
        ((TextView) convertView.findViewById(R.id.textViewDest)).setText(cafe.dest);
>>>>>>> 5b2d7d6d53763c8eeac1c4a0eebed2804287acd7
=======
        ((TextView) convertView.findViewById(R.id.textViewDest)).setText(cafe.dest);
>>>>>>> 5b2d7d6d53763c8eeac1c4a0eebed2804287acd7
=======
        ((TextView) convertView.findViewById(R.id.textViewDest)).setText(cafe.dest);
>>>>>>> 5b2d7d6d53763c8eeac1c4a0eebed2804287acd7

        return convertView;
    }
}
