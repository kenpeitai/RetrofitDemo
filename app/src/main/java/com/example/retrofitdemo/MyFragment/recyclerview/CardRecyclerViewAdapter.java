package com.example.retrofitdemo.MyFragment.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.retrofitdemo.MyFragment.recyclerview.bean.CardBean;
import com.example.retrofitdemo.R;

import java.util.List;

public class CardRecyclerViewAdapter extends RecyclerView.Adapter<CardRecyclerViewAdapter.ViewHolder> {
    private OnItemClickListener onItemClickListener;
    private List<CardBean.DataBean.DatasBean> list;
    private ViewGroup viewGroup;

    public CardRecyclerViewAdapter(List<CardBean.DataBean.DatasBean> list) {
        this.list = list;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public CardRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.viewGroup = parent;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.cardTitle.setText(list.get(position).getTitle());
        holder.cardDetails.setText(list.get(position).getDesc());
        holder.cardInfo.setText(list.get(position).getNiceDate() + " " + list.get(position).getAuthor());
        Glide.with(viewGroup.getContext()).load(list.get(position).getEnvelopePic()).into(holder.cardImage);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(v,position,list);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<CardBean.DataBean.DatasBean> projectList) {
        this.list = projectList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        private ImageView cardImage;
        private TextView cardTitle;
        private TextView cardDetails;
        private TextView cardInfo;
        private CheckBox cardLikeTab;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card);
            cardImage = itemView.findViewById(R.id.card_image);
            cardTitle = itemView.findViewById(R.id.card_title);
            cardDetails = itemView.findViewById(R.id.card_details);
            cardInfo = itemView.findViewById(R.id.card_info);
            cardLikeTab = itemView.findViewById(R.id.card_like_tab);

        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position,List<CardBean.DataBean.DatasBean> list);
    }

}
