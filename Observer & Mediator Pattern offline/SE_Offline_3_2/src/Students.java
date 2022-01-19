import java.util.Scanner;

public class Students extends user {
    Scanner scn=new Scanner(System.in);
    String str;
    private int p=-1;
    public boolean srex=false;
    public Students(ExamController e,int i)
    {
        super(e);
        this.id=i;
        this.ec.getStd().add(this);
        this.ec.s.add(new Script(i,0));
    }

    public void receiveResults(Script s) {
        if (!srex) {
            System.out.println("");
            System.out.print("Student "+this.id+" prompt: Result published");
            p=s.getNumbr();
            System.out.println(".Got marks:" + s.getNumbr());
            System.out.println("Do you want to apply for re-examine?");
            System.out.println("1. yes ");
            System.out.println("2. no");
            str = scn.nextLine();
            if (str.equalsIgnoreCase("1")) {
                System.out.println("Re-examine request sent " );
                this.ec.reExamine(new Script(this.id, s.getNumbr()));
                this.srex = true;
                p=s.getNumbr();
            }
        }
        else
        {
            srex =false;
            System.out.println("");
            System.out.print("Student "+this.id+" prompt:");
            if(p != s.getNumbr())
            {
                System.out.println("Marks were "+p+" previously.Now the corrected marks are "+s.getNumbr());
            }
            else
                System.out.println("Marks unchanged.");
            //System.out.println("Student id no:" + this.id + ".....updated mark:" + s.getNumbr()+"...Previous mark:"+p);
            System.out.println("");
        }
    }
}
