package com.example.mobileapplication01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.CheckBox;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mobileapplication01.model.smarthome;

import java.util.ArrayList;
import java.util.List;

public class MyAdptersmar extends RecyclerView.Adapter<MyAdptersmar.ViewHolder> {
    private List<smarthome> values;
    private Context context;

    public MyAdptersmar(List<smarthome> values, Context context) {
        this.values = values;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgView;
        public TextView textHeader;
        public TextView textFooter;
        public CheckBox checkBox;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            imgView = v.findViewById(R.id.icon);
            textHeader = v.findViewById(R.id.firstLine);
            textFooter = v.findViewById(R.id.secondLine);
            checkBox = v.findViewById(R.id.checkBox);
        }
    }

    @Override
    public MyAdptersmar.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        return new MyAdptersmar.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyAdptersmar.ViewHolder holder, final int position) {
        final smarthome smarthomeItem = values.get(position);
        holder.textHeader.setText(smarthomeItem.getSmarthome_name());
        holder.textFooter.setText(smarthomeItem.getSmarthome_detail() + " - " + smarthomeItem.getSmarthome_price());

        Glide.with(context)
                .load(smarthomeItem.getSmarthome_image())
                .into(holder.imgView);

        holder.checkBox.setChecked(smarthomeItem.isChecked());

        holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            smarthomeItem.setChecked(isChecked);
        });

        holder.imgView.setOnClickListener(v -> {
            // การแสดงรายละเอียดเพิ่มเติม
        });
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    // Method to get selected items
    public List<smarthome> getSelectedItems() {
        List<smarthome> selectedItems = new ArrayList<>();
        for (smarthome item : values) {
            if (item.isChecked()) {
                selectedItems.add(item);
            }
        }
        return selectedItems;
    }
}
