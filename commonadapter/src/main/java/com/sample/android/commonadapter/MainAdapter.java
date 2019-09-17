package com.sample.android.commonadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hwangjr.rxbus.RxBus;
import com.sample.android.commonadapter.data.Item;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Item> data;

    public MainAdapter() {
        data = new ArrayList<>();
    }

    public void setNewData(List<Item> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public void removeByPosition(int position) {
        if (data != null && data.size() > position) {
            data.remove(position);
            notifyItemRemoved(position);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MainHolder) {
            MainHolder mh = (MainHolder) holder;
            Item item = data.get(position);
            mh.noView.setText(item.getUid());
            mh.itemView.setOnClickListener(view -> {
                RxBus.get().post(Event.ON_ITEM_CLICK, item);
                removeByPosition(position);
            });
        }
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    static class MainHolder extends RecyclerView.ViewHolder {
        TextView noView;

        public MainHolder(@NonNull View itemView) {
            super(itemView);
            noView = itemView.findViewById(R.id.it_no);
        }
    }
}
