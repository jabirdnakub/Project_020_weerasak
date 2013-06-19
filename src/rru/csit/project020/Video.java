package rru.csit.project020;

import com.example.finalproject.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class Video extends Activity {
Button vback; 
VideoView videoview1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        
        vback = (Button)findViewById(R.id.button1); 
        videoview1 = (VideoView)findViewById(R.id.videoView1);
        
        
        MediaController mc = new MediaController(this);
        mc.setAnchorView(videoview1);
        mc.setMediaPlayer(videoview1);
        
        videoview1.setMediaController(mc);
        videoview1.setVideoPath("http://ladyshoppingz.com/korkai.3gp");
        videoview1.start();
        
        
        
        vback.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				Intent i = new Intent();
				i.setClass(Video.this, MainActivity.class);
				startActivity(i);
				
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_video, menu);
        return true;
    }
}
