public class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer ad;

    public MediaAdapter(String type,int size,int duration)
    {
        if(type.equalsIgnoreCase("mp4"))
        {
            ad=new Mp4Player();
        }
        else if(type.equalsIgnoreCase("vlc"))
        {
            ad=new VlcPlayer();
        }
        else if(type.equalsIgnoreCase("flv"))
        {
            ad=new FlvPlayer();
        }
    }

    @Override
    public void play(String name, String type,int size, int duration) {
        if(type.equalsIgnoreCase("vlc"))
        {
            ad.playVlc(name,size,duration);
        }
        else if(type.equalsIgnoreCase("mp4"))
        {
            ad.playMp4(name,size,duration);
        }
        else if(type.equalsIgnoreCase("flv"))
        {
            ad.playflv(name,size,duration);
        }

    }
}
