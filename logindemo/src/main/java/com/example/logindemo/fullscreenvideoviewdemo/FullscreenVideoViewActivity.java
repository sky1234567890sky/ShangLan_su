package com.example.logindemo.fullscreenvideoviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.logindemo.R;

import java.io.File;

import bg.devlabs.fullscreenvideoview.FullscreenVideoView;
import bg.devlabs.fullscreenvideoview.orientation.LandscapeOrientation;
import bg.devlabs.fullscreenvideoview.orientation.PortraitOrientation;

public class FullscreenVideoViewActivity extends AppCompatActivity {

    private FullscreenVideoView mFullscreenVideoView;
    String path = "http://clips.vorwaerts-gmbh.de/VfE_html5.mp4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen_video_view);

        mFullscreenVideoView = findViewById(R.id.fullscreenVideoView);
        mFullscreenVideoView.videoUrl(path);
        File videoFile = new File("file_path");
        mFullscreenVideoView.videoFile(videoFile);
    }
}
