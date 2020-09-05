package com.example.retrofitdemo.MyFragment.recyclerview;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitdemo.MyFragment.recyclerview.bean.ClassficationBean;
import com.example.retrofitdemo.R;

import java.util.ArrayList;
import java.util.List;

public class ClassficationRecyclerViewAdapter extends RecyclerView.Adapter<ClassficationRecyclerViewAdapter.ViewHolder> {
    private List<Boolean> isClicks;
    private List<ClassficationBean.DataBean> list;
    private OnItemClickListener onItemClickListener;

    public List<Boolean> getIsClicks() {
        return isClicks;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public ClassficationRecyclerViewAdapter(List list) {
        this.list = list;
        isClicks = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            isClicks.add(false);
        }
        isClicks.set(0, true);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.classfication_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ClassficationBean.DataBean dataBean = list.get(position);
        holder.classficationText.setText(dataBean.getName());
        if (onItemClickListener != null)
            holder.classficationText.setOnClickListener(v -> {

                for (int i = 0; i < isClicks.size(); i++) {
                    isClicks.set(i, false);
                }



                onItemClickListener.onItemClick(v, position);
                isClicks.set(position, true);
                notifyDataSetChanged();
            });

        if (isClicks.get(position)) {
            holder.classficationText.setTextColor(Color.parseColor("#03C7B7"));
        } else {
            holder.classficationText.setTextColor(Color.parseColor("#00000f"));
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView classficationText;

        ViewHolder(@NonNull View itemView) {
            super(itemView);


            classficationText = itemView.findViewById(R.id.classfication_text);


        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }


}
