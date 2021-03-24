package com.sedayilmaz.musicdeneme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
     ListView listView ;
     Bitmap selectedImage;
     MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.music_listview);

        ArrayList<Music> musics = new ArrayList<>();
        musics.add(new Music("ABC's",R.drawable.abc,R.raw.affet));
        musics.add(new Music("Old Mc Donald's Had A Farm",R.drawable.farm,R.raw.myvoice));
        /*musics.add(new Music("Five Little Ducks",R.drawable.ducks));
        musics.add(new Music("Little Frog",R.drawable.littlefrog));
        musics.add(new Music("Johny Johny Yes Papap",R.drawable.johnyyespapa));
        musics.add(new Music("Baby Shark",R.drawable.babyshark));
        musics.add(new Music("Finger Family",R.drawable.fingerfamily));
        musics.add(new Music("This Is A Happy Face",R.drawable.happyface));
        musics.add(new Music("Wheels On The Bus",R.drawable.onthebus));*/


        //Müzik Aktarma



        //görsel aktarma
        //getApplicationContext.getResourse = görselin kaynağını almak için
        Bitmap abc= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.abc);
        Bitmap mcDonald= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.farm);
        Bitmap fiveDucks= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.ducks);
        Bitmap littleFrog = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.littlefrog);
        Bitmap yesPapa=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.johnyyespapa);
        Bitmap babyShark=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.babyshark);
        Bitmap fingerFamily=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.fingerfamily);
        Bitmap happyFace=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.happyface);
        Bitmap onTheBus=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.onthebus);


        //Görselleri liste içersinde tutuyorum.
        ArrayList<Bitmap> images = new ArrayList<>();
        images.add(abc);
        images.add(mcDonald);
        images.add(fiveDucks);
        images.add(littleFrog);
        images.add(yesPapa);
        images.add(babyShark);
        images.add(fingerFamily);
        images.add(happyFace);
        images.add(onTheBus);


        //Adapter: Veriler ile view bağlanır ve kullanıcıya gösterilir.

        MusicAdapter musicAdapter = new MusicAdapter(MainActivity.this,R.layout.music_list_items,musics);

        if(listView !=null)
        {
            listView.setAdapter(musicAdapter);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, PlayMusicActivity.class);
                //Diğer aktiviteye göndereceğimiz şeyler burada tanımlanır daha sonra intent yapılır

               //Müzik Alma




                //getInstance() : obje oluşturmak içib bu metodu çağırdık.Zaten bunda obje oluşturuluyor.
                Singleton singleton =Singleton.getInstance();
                singleton.setChosenImage(images.get(position));//görsel alındı
                startActivity(intent);
            }
        });

    }




}