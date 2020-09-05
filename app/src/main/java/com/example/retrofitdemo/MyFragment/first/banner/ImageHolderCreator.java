package com.example.retrofitdemo.MyFragment.first.banner;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.to.aboomy.banner.HolderCreator;

public class ImageHolderCreator implements HolderCreator {
    @Override
    public View createView(Context context, int index, Object o) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        Glide.with(imageView).load(o).into(imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Toast.makeText(context, "you clicked image"+index, Toast.LENGTH_SHORT).show();
            }
        });
        return imageView;
    }


}
