package com.sedayilmaz.musicdeneme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class PlayMusicActivity extends AppCompatActivity {

    ImageView musicImage,playImage,pauseImage,stopImage;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music_activitiy);

        musicImage=findViewById(R.id.musicImageID);
        playImage=findViewById(R.id.play);
        stopImage=findViewById(R.id.stop);
        pauseImage=findViewById(R.id.pause);

        //DİĞER AKTİVİTEDEN GELEN MÜZİKLERİ AL
        /*int number = getIntent().getExtras().getInt("Song_List");
        mediaPlayer=MediaPlayer.create(this,number);*/
        int number = getIntent().getExtras().getInt("Song_List");


        playImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mediaPlayer==null)
                {
                    mediaPlayer=MediaPlayer.create(PlayMusicActivity.this,number);
                }
                mediaPlayer.start();

            }
        });

        pauseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer!=null)
                {
                    mediaPlayer.pause();
                }
            }
        });

        stopImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer != null)
                {
                    mediaPlayer.release();
                    mediaPlayer=null;
                }
            }
        });






         //DİĞER AKTİVİTEDEN GELEN BİTMAP ÖĞESİNİ AL
        Intent intent = getIntent();
        Singleton singleton = Singleton.getInstance(); //gönderilen singleton objesi alındı
        musicImage.setImageBitmap(singleton.getChosenImage());//view'a görsel set edildi.

    }

}