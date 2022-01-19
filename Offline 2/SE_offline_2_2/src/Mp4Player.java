public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playMp4(String name,int size, int duration) {
        System.out.println(name+".mp4"+"  size:"+size+" Duration:"+duration);
    }

    @Override
    public void playflv(String name,int size, int duration) {

    }

    @Override
    public void playVlc(String name,int size, int duration) {

    }
}
