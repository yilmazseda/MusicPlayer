package com.sedayilmaz.musicdeneme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class PlayMusicActivity extends AppCompatActivity {

    ImageView musicImage,prevImage,playImage,nextImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music_activitiy);

        musicImage=findViewById(R.id.musicImageID);
        prevImage=findViewById(R.id.prevID);
        playImage=findViewById(R.id.playID);
        nextImage=findViewById(R.id.nexID);



        //Diğer aktiviteden gelen verileri al
        Intent intent = getIntent();
        Singleton singleton = Singleton.getInstance(); //gönderilen singleton objesi alındı
        musicImage.setImageBitmap(singleton.getChosenImage());//view'a görsel set edildi.


    }





}