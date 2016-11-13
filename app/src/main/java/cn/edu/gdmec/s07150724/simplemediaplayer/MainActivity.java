package cn.edu.gdmec.s07150724.simplemediaplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
        private MediaPlayer mediaPlayer;
        private String mPath;
         private VideoView mVideoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=getIntent();
        Uri uri=intent.getData();
        mPath =uri.getPath();
        if(intent.getType().contains("audio")){
            mediaPlayer =new MediaPlayer();
        try{
           mediaPlayer.setDataSource(mPath);
            mediaPlayer.prepare();
            mediaPlayer.start();
        }catch (Exception e){
            e.printStackTrace();
        }

        }
        else if(intent.getType().contains("video")){
            mVideoView =new VideoView(this);
            mVideoView.setVideoURI(uri);
            mVideoView.setMediaController(new MediaController(this));
            mVideoView.start();
            setContentView(mVideoView);
        }
    }


}
