public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String name,int size, int duration) {
        System.out.println(name+".vlc"+"  size:"+size+" Duration:"+duration);
    }

    @Override
    public void playflv(String name,int size, int duration) {

    }

    @Override
    public void playMp4(String name,int size, int duration) {

    }
}
