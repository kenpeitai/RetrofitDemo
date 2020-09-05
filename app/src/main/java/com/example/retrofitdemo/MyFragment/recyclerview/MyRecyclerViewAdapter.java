package com.example.retrofitdemo.MyFragment.recyclerview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitdemo.ApplicationData;
import com.example.retrofitdemo.MyFragment.recyclerview.bean.ArticleBean;
import com.example.retrofitdemo.R;

import java.util.Arrays;
import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    private OnItemClickListener onItemClickListener;
    private ApplicationData applicationData;

    private List<ArticleBean.DatasBean> mList;

    public MyRecyclerViewAdapter(List<ArticleBean.DatasBean> list, Activity activity) {
        applicationData = (ApplicationData) activity.getApplication();
        mList = list;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    @NonNull
    @Override
    public MyRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyRecyclerViewAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull final MyRecyclerViewAdapter.ViewHolder holder, int position) {
        ArticleBean.DatasBean bean = mList.get(position);
        holder.textView1.setText(bean.getTitle());
        holder.textView2.setText("分类:" + bean.getSuperChapterName() + "   时间:" + bean.getNiceDate());
        if (applicationData.getUserInfo() != null) {
            if (Arrays.asList(applicationData.getUserInfo().getCollectIds()).contains(mList.get(position).getOrigin())) {
                holder.checkBox.setChecked(true);
            }
        }



        holder.textView1.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(v, position, mList);
            }

        });

    }

    public void setmList(List<ArticleBean.DatasBean> mList) {
        this.mList = mList;
    }

    public void addList(List<ArticleBean.DatasBean> morerAticles) {
        mList.addAll(morerAticles);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1;
        TextView textView2;
        CheckBox checkBox;

        public ViewHolder(View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.text_title);
            textView2 = itemView.findViewById(R.id.text_info);
            checkBox = itemView.findViewById(R.id.like_tab);


        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position, List<ArticleBean.DatasBean> list);
    }

}

