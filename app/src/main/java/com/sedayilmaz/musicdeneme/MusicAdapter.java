package com.sedayilmaz.musicdeneme;

//Adapter ile verilerimizi View'imiz içinde gösterebiliriz.Bir listeye görsel ve text ekleyip kullanıcıya göstermek istiyoruz
//Context : proje içinde neler olduğunu ,arka planda nelerin olduğunu tutar.Application Context, genel uygulamayı kapsar.
//Activity Context, sadece aktiviteyi ilgilendiren durum
import android.content.Context;
import android.media.Image;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
//Music tipinde bir ArrayAdapter ,MusicAdapter'a extend edildi.

public class MusicAdapter extends ArrayAdapter<Music> {

    public MusicAdapter(@NonNull Context context, int resource, @NonNull List<Music> objects) {
        super(context, resource, objects);
    }

//getView METODU:Objelerin listView içerisinde gösterilmesini sağlar.




    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        if(convertView == null)
        {

            LayoutInflater layoutinflater =LayoutInflater.from(getContext());
            convertView=layoutinflater.inflate(R.layout.music_list_items,null);
        }

        Music musicItems = getItem(position); //objelerin indexine göre alacağım için position kullandım

        //eğer aldığımız 'musicItems' nesnesi boş değilse atama yapalım.Çünkü adpater kullanıyoruz ve adapter'in mantığı objeyi listeye
        if(musicItems!=null)
        {
            ImageView musicImage = convertView.findViewById(R.id.music_image_view);
            TextView musicName = convertView.findViewById(R.id.music_name_text);

            if(musicImage!=null && musicName!=null)
            {
                //görsel ve text boş değilse kaynakları set ediyorum.
                musicImage.setImageResource(musicItems.getMusicImageID());
                musicName.setText(musicItems.getMusicName());
            }

        }
        return  convertView; //elimdeki tüm View'ler ,görünümler
    }


}

