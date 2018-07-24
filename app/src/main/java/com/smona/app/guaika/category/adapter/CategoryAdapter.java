package com.smona.app.guaika.category.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.smona.app.guaika.R;
import com.smona.app.guaika.activity.CategoryActivity;
import com.smona.app.guaika.common.ui.recycler.HeaderAndFooterAdapter;
import com.smona.app.guaika.common.ui.recycler.ViewHolder;
import com.smona.app.guaika.home.bean.VideoData;
import com.smona.app.guaika.util.UIUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryAdapter extends HeaderAndFooterAdapter<VideoData> {

    private Context mContext;

    public CategoryAdapter(Context context, List<VideoData> list) {
        super(list);
        mContext = context;
    }

    @Override
    public ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.category_list_item, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(ViewHolder holder, int position, VideoData item) {
        VideoViewHolder videoViewHolder = (VideoViewHolder) holder;

        videoViewHolder.mCategoryName.setText(R.string.app_name);

        videoViewHolder.mLeftImg.setScaleType(ImageView.ScaleType.FIT_XY);
        Glide.with(mContext).load(item.getImageUrl())
                .placeholder(R.drawable.video_image_place_holder)
                .error(R.drawable.video_image_place_holder)
                .into(videoViewHolder.mLeftImg);
        videoViewHolder.mLeftTitle.setText(item.getTitle());

        videoViewHolder.mRightImg.setScaleType(ImageView.ScaleType.FIT_XY);
        Glide.with(mContext).load(item.getImageUrl())
                .placeholder(R.drawable.video_image_place_holder)
                .error(R.drawable.video_image_place_holder)
                .into(videoViewHolder.mRightImg);
        videoViewHolder.mRightTitle.setText(item.getTitle());

        videoViewHolder.mMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIUtil.gotoCategory(mContext);
            }
        });
    }

    class VideoViewHolder extends ViewHolder {
        @BindView(R.id.left_img)
        ImageView mLeftImg;
        @BindView(R.id.right_img)
        ImageView mRightImg;
        @BindView(R.id.left_title)
        TextView mLeftTitle;
        @BindView(R.id.right_title)
        TextView mRightTitle;

        @BindView(R.id.category_name)
        TextView mCategoryName;

        @BindView(R.id.category_more)
        View mCateogryMore;

        @BindView(R.id.more)
        View mMore;

        VideoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
