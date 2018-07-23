package com.smona.app.guaika.activity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.smona.app.guaika.R;
import com.smona.app.guaika.home.bean.VideoData;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.ittiger.player.VideoPlayerView;

public class VideoActivity extends BaseActivity {
    @BindView(R.id.video_player_view)
    VideoPlayerView mVideoPlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);
        playVideo();
    }

    private void playVideo() {
        VideoData item = new VideoData();
        item.setTitle("还记得吗？世界杯史上伟大的一次换人，上场后锁定胜利！");
        item.setVideoUrl("http://flv3.bn.netease.com/videolib3/1807/17/OgIoJ4058/SD/OgIoJ4058-mobile.mp4");
        item.setImageUrl("http://nos.netease.com/vimg/snapshot/20180717/OgIoJ4058_cover.jpg");
        mVideoPlayerView.bind(item.getVideoUrl(), item.getTitle());
        mVideoPlayerView.getThumbImageView().setScaleType(ImageView.ScaleType.FIT_XY);
        Glide.with(this).load(item.getImageUrl())
                .placeholder(R.drawable.video_image_place_holder)
                .error(R.drawable.video_image_place_holder)
                .into(mVideoPlayerView.getThumbImageView());
    }
}
