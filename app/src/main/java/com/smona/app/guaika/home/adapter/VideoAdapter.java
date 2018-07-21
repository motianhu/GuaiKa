package com.smona.app.guaika.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.smona.app.guaika.R;
import com.smona.app.guaika.home.bean.VideoData;
import com.smona.app.guaika.common.ui.recycler.HeaderAndFooterAdapter;
import com.smona.app.guaika.common.ui.recycler.ViewHolder;
import com.smona.app.guaika.util.DisplayManager;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.ittiger.player.VideoPlayerView;

public class VideoAdapter extends HeaderAndFooterAdapter<VideoData> {

    private Context mContext;

    public VideoAdapter(Context context, List<VideoData> list) {
        super(list);
        mContext = context;
    }

    @Override
    public ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.video_list_item, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(ViewHolder holder, int position, VideoData item) {
        VideoViewHolder videoViewHolder = (VideoViewHolder) holder;
        videoViewHolder.mPlayerView.bind(item.getVideoUrl(), item.getTitle());
        videoViewHolder.mPlayerView.getThumbImageView().setScaleType(ImageView.ScaleType.FIT_XY);
        Glide.with(mContext).load(item.getImageUrl())
                .placeholder(R.drawable.video_image_place_holder)
                .error(R.drawable.video_image_place_holder)
                .into(videoViewHolder.mPlayerView.getThumbImageView());
    }

    class VideoViewHolder extends ViewHolder {
        @BindView(R.id.video_player_view)
        VideoPlayerView mPlayerView;

        public VideoViewHolder(View itemView) {

            super(itemView);
            //以宽高比16:9的比例设置播放器的尺寸
            int width = DisplayManager.screenWidthPixel(mContext);
            int height = (int) (width * 1.0f / 16 * 9 + 0.5f);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) itemView.getLayoutParams();
            params.height = height;
            params.width = width;
            itemView.setLayoutParams(params);
            ButterKnife.bind(this, itemView);
        }
    }
}
