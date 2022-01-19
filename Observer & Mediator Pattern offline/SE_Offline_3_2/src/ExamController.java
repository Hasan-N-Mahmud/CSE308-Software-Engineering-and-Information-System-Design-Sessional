import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExamController extends Mediator {
    private List<Students> std=new ArrayList<Students>();
    List<Script> s=new ArrayList<Script>();
    List<Script> re=new ArrayList<Script>();
    List<Integer> pre=new ArrayList<Integer>();
    private Examiner ex;
    public boolean flag=false;
    Random rand=new Random();

    public List<Students> getStd() {
        return std;
    }

    public Examiner getEx() {
        return ex;
    }

    public void setEx(Examiner ex) {
        this.ex = ex;
    }

    @Override
    public void Send(user fr, List<Script> n) {

        if(!flag) {
            s = n;
            System.out.println("Exam controller prompt: Scripts and marks of student id 1,2,3,4,5 have been received.");

            for (int i = 0; i < n.size(); i++) {
                System.out.println("Student id: " + n.get(i).getRoll() + ",Marks:" + n.get(i).getNumbr() + "  ");
            }
        }
        else
        {
            flag =false;
            s=n;
            System.out.print("Exam controller prompt: ");
            for(int i=0;i<re.size();i++)
            {
                //System.out.println(s.get(i).getNumbr()+"  /  "+pre.get(i).toString());
                if(s.get(i).getNumbr() != pre.get(i).intValue())
                {
                    System.out.println("Marks of student id "+re.get(i).getRoll()+ " has updated from "+pre.get(i).intValue()+" to "+s.get(i).getNumbr());

                }
                else
                    System.out.println("Marks of student id "+re.get(i).getRoll()+" unchanged.");

            }

            for(int i=0;i<re.size();i++)
            {

                if(s.get(i).getNumbr() != pre.get(i).intValue())
                {
                    System.out.println("updated marks has been sent to student id "+re.get(i).getRoll());
                }
                else
                    System.out.println("Student id "+re.get(i).getRoll()+" has been informed of no change in marks.");

            }
            this.sendResults();
        }

    }
    public void SendScripts()
    {
        this.ex.sendScripts(s);
        //s=null;
    }

    public void rescrutinize()
    {

        System.out.println("");
        System.out.println("Scrutinization has been done.");
        for(Script k:s)
        {
            if(k.isMistake())
            {


                int i=rand.nextInt(101);
                int j=k.getNumbr();
                k.setNumbr(i);
                System.out.println("Marks of Student id "+k.getRoll()+" were incorrect.");
                System.out.println("Previous marks:  "+j+",Correct marks:"+k.getNumbr());
            }
        }
        System.out.println(" ");
        System.out.println("Results has been published to students.");
        System.out.println(" ");
        this.sendResults();
    }

    public void sendResults()
    {
        if (re.size() !=0)
        {
            for(Students k:std)
            {
                for(int i=0;i<s.size();i++)
                {
                    if(s.get(i).getRoll() == k.id)
                    {
                        k.receiveResults(s.get(i));
                        s.remove(i);
                    }
                }
            }
            re=null;
            return;
        }

        for(Students k:std)
        {
            for(int i=0;i<s.size();i++)
            {
                if(s.get(i).getRoll() == k.id)
                {
                    k.receiveResults(s.get(i));
                    s.remove(i);
                }
            }
        }
        if(re.size() != 0)
        {
            for(Script k:re) {
                pre.add(k.getNumbr());
            }
            System.out.print("Exam controller prompt: Re-examine request got from student id ");
            for(Script i:re)
            {
                System.out.print(i.getRoll()+",");
            }
            System.out.println("");

            System.out.print("Exam scripts of student id ");
            for(Script i:re)
            {
                System.out.print(i.getRoll()+",");
            }
            System.out.println(" sent to examiner.");
            ex.sendScripts(re);
        }
    }

    public void reExamine(Script st)
    {
        //System.out.println("Exam controller prompt: "+st.getRoll()+" Your request is accepted - Exam Controller");
        ex.rex=true;
        re.add(st);
    }
}
