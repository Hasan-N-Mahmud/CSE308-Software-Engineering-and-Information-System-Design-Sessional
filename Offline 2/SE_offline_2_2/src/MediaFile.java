public class MediaFile {
    private String name;
    private String type;
    private int duration;
    private int size;

    public MediaFile(String n,int s,int d)
    {

        size=s;
        duration=d;
        String[] out=n.split("\\.");
        name=out[0];
        type=out[1];
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getDuration() {
        return duration;
    }

    public int getSize() {
        return size;
    }
}
