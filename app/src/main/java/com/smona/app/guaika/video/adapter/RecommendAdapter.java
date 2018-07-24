package com.smona.app.guaika.video.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.smona.app.guaika.R;
import com.smona.app.guaika.common.ui.recycler.HeaderAndFooterAdapter;
import com.smona.app.guaika.common.ui.recycler.ViewHolder;
import com.smona.app.guaika.home.bean.VideoData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecommendAdapter extends HeaderAndFooterAdapter<VideoData> {

    private Context mContext;

    public RecommendAdapter(Context context, List<VideoData> list) {
        super(list);
        mContext = context;
    }

    @Override
    public ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recomend_list_item, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(ViewHolder holder, int position, VideoData item) {
        VideoViewHolder videoViewHolder = (VideoViewHolder) holder;
        videoViewHolder.mImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        Glide.with(mContext).load(item.getImageUrl())
                .placeholder(R.drawable.video_image_place_holder)
                .error(R.drawable.video_image_place_holder)
                .into(videoViewHolder.mImageView);
        videoViewHolder.mTitle.setText(item.getTitle());
        videoViewHolder.mAuthor.setText(item.getAuthor());
        videoViewHolder.mDuration.setText(item.getDuration());
    }


    class VideoViewHolder extends ViewHolder {
        @BindView(R.id.thumbnail)
        ImageView mImageView;
        @BindView(R.id.title)
        TextView mTitle;
        @BindView(R.id.author)
        TextView mAuthor;
        @BindView(R.id.duration)
        TextView mDuration;

        VideoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
