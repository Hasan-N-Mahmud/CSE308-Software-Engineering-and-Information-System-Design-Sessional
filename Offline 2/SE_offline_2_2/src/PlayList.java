import java.util.ArrayList;
import java.util.List;
public class PlayList {
    private String name;
    private List<MediaFile> items;
    public PlayList(String s)
    {
        name=s;
        items=new ArrayList<MediaFile>();
    }

    public String getName() {
        return name;
    }

    public List<MediaFile> getItems() {
        return items;
    }
}
