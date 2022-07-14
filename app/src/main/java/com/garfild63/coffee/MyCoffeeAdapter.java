package com.garfild63.coffee;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyCoffeeAdapter extends ArrayAdapter<MyCoffee> {

    public static int[] values;
    private final TextView[] tv;

    public MyCoffeeAdapter(Context context, MyCoffee[] arr) {
        super(context, R.layout.adapter_menu_item, arr);
        values = new int[arr.length];
        tv = new TextView[arr.length];
    }

    @SuppressLint("StaticFieldLeak")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final MyCoffee coffee = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_menu_item, parent, false);
        }

        if (tv[position] == null) {
            tv[position] = (TextView) convertView.findViewById(R.id.textViewNumber);
            tv[position].setText(String.valueOf(values[position]));
        }

        ((TextView) convertView.findViewById(R.id.textViewName)).setText(coffee.name);
        ((TextView) convertView.findViewById(R.id.textViewPrice)).setText(String.format(convertView.getResources().getString(R.string.rur), coffee.price));
        ImageView imageView = ((ImageView) convertView.findViewById(R.id.imgView));
        new AsyncTask<String, Integer, Bitmap>() {
            protected Bitmap doInBackground(String... urls) {
                Bitmap bmp = null;
                try {
                    bmp = BitmapFactory.decodeStream(new URL(urls[0]).openStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return bmp;
            }

            protected void onPostExecute(Bitmap result) {
                imageView.setImageBitmap(result);
            }
        }.execute(coffee.imageURL);
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
