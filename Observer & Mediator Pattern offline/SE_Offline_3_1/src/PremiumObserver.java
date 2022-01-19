import java.util.Scanner;
public class PremiumObserver extends Observer {
    Scanner scn=new Scanner(System.in);
    String str;
    private int current=2;
    public PremiumObserver(Subject s)
    {
        this.sub=s;
        this.sub.attach(this);
    }

    public int getCurrent() {
        return current;
    }

    @Override
    public void update() {
        System.out.println("Premium User Prompt:");
       if(this.sub.getState() == 1)
       {

           if(this.sub.getPrevious() == 2)
           {
               System.out.print("Service is partially down now.");
               System.out.println("Do you want to use service from two servers (partially from the server of our company and partially from the server of DEF company) or from one server (server of DEF company)?");
               System.out.println("Please choose:");
               System.out.println("1.one server");
               System.out.println("2.two servers");
               str=scn.nextLine();
               if(str.equalsIgnoreCase("2"))
               {
                   current=1;
                   //System.out.println("Your service is provided by two partially used servers");
               }
               else
               {
                   current=0;
                   //System.out.println("Your service is provided by DEF");
               }

           }
           else if(this.sub.getPrevious() == 0)
           {
               System.out.println("Our server is partially operational now.");
           }
       }


       else if(this.sub.getState() == 2)
       {
           if(this.sub.getPrevious() == 0)
           {
               System.out.println("Now the server is operational again.");
           }
           else if(this.sub.getPrevious() == 1)
           {
               System.out.println("Now the server is operational again.");
           }
       }

       else if(this.sub.getState() == 0)
       {
           if(this.sub.getPrevious() == 1)
           {

               if(current == 1) {
                   System.out.println("Server is fully down now. All of your services has been shifted to the server of DEF company.");
                   current=0;
               }
               else
                   System.out.println("Server is fully down now. Service is now being provided by DEF company.");
           }
           else if(this.sub.getPrevious() == 2)
           {
               current=0;
               System.out.println(" Server is fully down now. Service is now being provided by DEF company.");


           }
       }

    }
}
