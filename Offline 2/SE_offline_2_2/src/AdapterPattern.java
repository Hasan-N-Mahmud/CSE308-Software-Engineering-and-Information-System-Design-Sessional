import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class AdapterPattern {
    public static void main(String[] args) {
        AudioPlayer ap=new AudioPlayer();

        List<PlayList> playlist = new ArrayList<PlayList>();
        PlayList current=null;
        Scanner scn=new Scanner(System.in);
        String str;
        String str1;
        int a,b,i;
        boolean prop=false;
        while(true)
        {
            System.out.println("Enter Command: <A C L D P S X>");
            str=scn.nextLine();

            if(str.equalsIgnoreCase("A")) {
                if (!prop) {
                    System.out.println("Create a playlist first");
                } else if(current == null) {
                    System.out.println("Enter name of the Playlist:");
                    str = scn.nextLine();
                    for (i = 0; i < playlist.size(); i++) {
                        if (playlist.get(i).getName().equalsIgnoreCase(str)) {
                            System.out.println("Enter file details:");
                            str1 = scn.nextLine();
                            str = scn.nextLine();
                            a = Integer.parseInt(str);
                            str = scn.nextLine();
                            b = Integer.parseInt(str);
                            MediaFile mf = new MediaFile(str1, a, b);
                            playlist.get(i).getItems().add(mf);
                            System.out.println("File added to " + playlist.get(i).getName());
                        }
                    }
                }
                else if(current!=null)
                {
                    System.out.println("Enter file details:");
                    str1 = scn.nextLine();
                    str = scn.nextLine();
                    a = Integer.parseInt(str);
                    str = scn.nextLine();
                    b = Integer.parseInt(str);
                    MediaFile mf = new MediaFile(str1, a, b);
                    current.getItems().add(mf);
                    System.out.println("Current PlayList: ");
                    for(i=0;i < current.getItems().size();i++)
                    {
                        ap.play(current.getItems().get(i).getName(),current.getItems().get(i).getType(),current.getItems().get(i).getSize(),current.getItems().get(i).getDuration());
                    }
                }
            }

            else if(str.equalsIgnoreCase("C"))
            {
                prop=true;
                if(current == null)
                {
                    System.out.println("Name of the playlist:");
                    str = scn.nextLine();
                    playlist.add(new PlayList(str));
                    System.out.println("Playlist created");
                }
                else if(current != null) {
                    System.out.println("Elapsed time:");
                    str = scn.nextLine();
                    a = Integer.parseInt(str);
                    b = 0;
                    for (i = 0; i < current.getItems().size(); i++) {
                        b = b + current.getItems().get(i).getDuration();
                    }
                    if (a > b) {
                        current=null;
                        System.out.println("Name of the playlist:");
                        str = scn.nextLine();
                        playlist.add(new PlayList(str));
                        System.out.println(str+"Playlist created");

                    } else {
                        System.out.println("Another playlist running.Please wait...");
                    }
                }
            }
            else if(str.equalsIgnoreCase("L"))
            {
                System.out.println("Playlists:");
                for(i=0;i<playlist.size();i++)
                {
                    System.out.println(playlist.get(i).getName());
                }
            }
            else if(str.equalsIgnoreCase("D"))
            {
                System.out.println("enter name of the playlist: ");
                str=scn.nextLine();
                for(i=0;i<playlist.size();i++)
                {
                    if(playlist.get(i).getName().equalsIgnoreCase(str))
                    {
                        for(int j=0;j<playlist.get(i).getItems().size();j++)
                        {
                            System.out.println(playlist.get(i).getItems().get(j).getName()+"."+playlist.get(i).getItems().get(j).getType()+"  size: "+playlist.get(i).getItems().get(j).getSize()+"  Duration: "+playlist.get(i).getItems().get(j).getDuration());

                        }
                        break;
                    }
                }

            }
            else if(str.equalsIgnoreCase("X"))
            {
                break;
            }
            else if(str.equalsIgnoreCase("P"))
            {
                System.out.println("Enter playlist:");
                str=scn.nextLine();
                for (i=0;i<playlist.size();i++)
                {
                    if(playlist.get(i).getName().equalsIgnoreCase(str))
                    {
                        current=playlist.get(i);
                        break;
                    }
                }

                System.out.println("Now playing:");
                for(i=0;i<current.getItems().size();i++)
                {
                    ap.play(current.getItems().get(i).getName(),current.getItems().get(i).getType(),current.getItems().get(i).getSize(),current.getItems().get(i).getDuration());
                }

            }
            else if(str.equalsIgnoreCase("S"))
            {
                if(current!=null)
                {
                    current=null;
                    System.out.println("Playlist is stopped");
                }
                else
                {
                    System.out.println("No playList is running");
                }
            }
        }
    }
}
