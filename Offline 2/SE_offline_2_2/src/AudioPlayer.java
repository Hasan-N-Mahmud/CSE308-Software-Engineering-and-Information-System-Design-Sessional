public class AudioPlayer implements MediaPlayer {
    MediaAdapter ma;

    @Override
    public void play(String name, String type,int size, int duration) {
        if(type.equalsIgnoreCase("mp3"))
        {
            System.out.println(name+".mp3 "+" size:  "+size+"  duration: "+duration);

        }

        else if(type.equalsIgnoreCase("vlc") || type.equalsIgnoreCase("mp4") || type.equalsIgnoreCase("flv"))
        {
           ma=new MediaAdapter(type,size,duration);
           ma.play(name,type,size,duration);
        }
        else
        {
            System.out.println("Invalid format");
        }
    }
}
