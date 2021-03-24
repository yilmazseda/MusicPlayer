package com.sedayilmaz.musicdeneme;

import android.graphics.Bitmap;
//Singleton Design (görsel alma)
//bu sınıf sadece bir tane objeye sahiptir
//Böylece bu sınıf hangi aktivitede çağrılırsa çağrılsın tek bir obje üzerinden işlem yapılısn
//bunun için constructor  private yapılır

public class Singleton {
// değişkenler singleton olduğu için private
   private Bitmap chosenImage;
   private  static  Singleton singleton; //singleton objesi

    private Singleton()
    {
      //constructor
    }

    public Bitmap getChosenImage() {
        //seçilen görseli verir
        return chosenImage;
    }

    public void setChosenImage(Bitmap chosenImage) {
        //bir tane görsel ister
        this.chosenImage = chosenImage;
    }
    //getInstance() : sınıfın objesini alır
    //getInstance() çağrılınca singleton objesi döndürülür
    public static Singleton getInstance()
    {
        //obje boş ise oluştur.Yani metot ilk kez çağrılır
      if(singleton ==null )
      {
          singleton = new Singleton();
      }
      // eğer obje daha önce oluşturuldu ise aynısını döndür.
      return  singleton;

    }

}
