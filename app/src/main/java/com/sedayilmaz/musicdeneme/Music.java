package com.sedayilmaz.musicdeneme;

public class Music {
    //Her müziğe ait bir adet görsel ve bir adet text olacak
    //sadece get kullanılacak
    private String musicName;
    private int musicImageID;
    private int songID;


    public Music(String musicName,int musicImageID,int songID)
    {
        this.musicName=musicName;
        this.musicImageID=musicImageID;
        this.songID=songID;
    }




    //Verileri sadece okunmasını istiyorum
    public String getMusicName()
    {
        return musicName;
    }
    public int getMusicImageID()
    {
        return musicImageID;
    }
    private int getsongID(){return songID;}


}
