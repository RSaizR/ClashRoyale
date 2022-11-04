package com.example.clashroyale;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CardsAdapter extends ArrayAdapter<Cards> {


        public CardsAdapter(Context context, int resource, int txtcard, List<Cards> objects) {
            super(context, resource, objects);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Cards card = getItem(position);

            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.lv_cards_raw, parent, false);
            }

            TextView txtcard = convertView.findViewById(R.id.txtcard);
            ImageView imgCard = convertView.findViewById(R.id.imgCard);

            txtcard.setText(card.getName());
            Glide.with(getContext()).load(card.getImg()).into(imgCard);

            return convertView;
        }
}