public class FlvPlayer implements AdvancedMediaPlayer {
    @Override
    public void playflv(String name,int size, int duration) {
        System.out.println(name+".flv"+"  size:"+size+" Duration:"+duration);
    }

    @Override
    public void playVlc(String name,int size, int duration) {

    }

    @Override
    public void playMp4(String name,int size, int duration) {

    }
}
