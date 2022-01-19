import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Examiner extends user {
    private boolean prop=true;
    private boolean mis=false;
    public boolean rex=false;
    private List<Script> num =new ArrayList<Script>();
    private List<Script> unchecked=new ArrayList<Script>();
    Random rand=new Random();
    public Examiner(ExamController e)
    {
        super(e);
        this.id=-1;
        this.ec.setEx(this);
    }
    public void scrutinize()
    {
        for(Script s:num) {
            if (s.getNumbr() == 0) {
                int j = rand.nextInt(101);
                s.setNumbr(j);
                if ((j % 6) == 3) {
                    s.setMistake(true);
                    mis = true;
                }

                if (!mis) {
                    int i = rand.nextInt(101) % 5;

                    num.get(i).setMistake(true);
                }
            }

            else
            {
                this.ec.flag=true;

                int i=rand.nextInt(100);
               // System.out.println(i);
                if(i%3 == 1 )
                {
                    int j=rand.nextInt(101);
                    System.out.println("Marks of student id "+s.getRoll()+" changed.");
                    System.out.println("previous marks were "+s.getNumbr()+",Now the current marks are "+j);
                    s.setNumbr(j);
                }
                else
                    System.out.println("Marks of student id "+s.getRoll()+" unchanged.");

            }
        }

    }
    public void send()
    {
            if(!rex){
            System.out.println("Examiner prompt: Scripts and marks of student id 1,2,3,4,5 have been sent to exam controller office.");}
            /*for(Script i:num)
            {
                System.out.println(num.get(i).getRoll()+",");
            }*/
            ec.Send(this,num);
            prop=false;

    }

    public void sendScripts(List<Script> n)
    {
        this.num=n;
        unchecked=num;
        if(rex) {
            System.out.print("Examiner prompt: ");
            System.out.println("Exam Scripts of student id");
            for (Script i : num) {
                System.out.print(i.getRoll() + ",");
            }
            System.out.println("has been received for re-examine.");
        }
        this.scrutinize();
        this.send();
    }
}
