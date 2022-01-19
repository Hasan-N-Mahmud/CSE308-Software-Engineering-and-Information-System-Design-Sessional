import java.util.*;
public class  Drive  {
    private String name;
    private String type;
    private String dir;
    private int component_count=0;
    private List<Drive> sub;

    public int getComponent_count() {
        return component_count;
    }

    public void setComponent_count(int component_count) {
        this.component_count = component_count;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDir() {
        return dir;
    }

    public List<Drive> getSub() {
        return sub;
    }

    public Drive(String n, String t, String d)
    {
        this.name=n;
        this.dir=d;
        this.type=t;
        this.component_count=0;
        this.sub=new ArrayList<Drive>();

    }

    public void add(Drive drive)
    {
        sub.add(drive);
        if(drive.getType().equals("file"))
        {
            this.setComponent_count(this.getComponent_count()+1);
        }

    }
    public void remove(Drive drive)
    {
        sub.remove(drive);
    }
    public int calculate()
    {
        Drive t;
        int size=this.sub.size();
        int k,n,in=0;


        if(this.getType().equals("file"))
        {
            return 1;
        }

        else if(this.getType().equals("drive")) {
            in=0;
            k=0;
            if (size == 0) {
                return k;
            }
            else
            {
                while(true) {
                    t = this.sub.get(in);
                    in++;
                    if(t.getType().equals("file"))
                    {
                        k = k + t.calculate();
                    }
                    else if(t.getType().equals("folder"))
                    {
                        k = k + t.calculate();
                    }
                    if(in==size)
                    {

                        break;
                    }
                }
                return k;
            }

        }

        else if(this.getType().equals("folder"))
        {
            in=0;
            k=0;
            if (size == 0) {
                return k;
            }
            else
            {
                while(true) {
                    t = this.sub.get(in);
                    in++;
                    if(t.getType().equals("file"))
                    {
                        k = k + t.calculate();
                    }
                    else if(t.getType().equals("folder"))
                    {
                        k = k + t.calculate();
                    }
                    if(in==size)
                    {

                        break;
                    }
                }
                return k;
            }

        }
        return 0;
    }
    public void details()
    {
        this.setComponent_count(this.calculate());
        System.out.println("Name: "+this.getName());
        System.out.println("Type: "+this.getType());
        System.out.println("Directory: "+this.getDir());
        System.out.println("Component Count: "+this.getComponent_count());
        System.out.println("");
    }

    public void list()
    {
        Drive t;
        int size=this.sub.size();
        int k,n,in=0;


        if(this.getType().equals("file"))
        {
            System.out.println(this.getName());
        }

        if(this.getType().equals("drive")) {
            in=0;
            System.out.println(this.getName() + ":\\ ");
            if (size == 0) {
                System.out.println("<Empty>");
                System.out.println("<End of "+this.getName()+">");
            }
            else
            {
                while(true) {
                    t = this.sub.get(in);
                    in++;
                    if(t.getType().equals("file"))
                    {
                        t.list();
                    }
                    else if(t.getType().equals("folder"))
                    {
                        t.list();
                    }
                    if(in==size)
                    {
                        System.out.println("<End of "+this.getName()+">");
                        break;
                    }
                }
            }

        }

        if(this.getType().equals("folder"))
        {
            in=0;
            System.out.println("----"+this.getName());
            if (size == 0) {
                System.out.println("<Empty>");
                System.out.println("<End of "+this.getName()+">");
            }
            else
            {
                while(true) {
                    t = this.sub.get(in);
                    in++;
                    if(t.getType().equals("file"))
                    {
                        t.list();
                    }
                    else if(t.getType().equals("folder"))
                    {
                        t.list();
                    }
                    if(in==size)
                    {
                        System.out.println("<End of "+this.getName()+">");
                        break;
                    }
                }
            }

        }



    }

}
