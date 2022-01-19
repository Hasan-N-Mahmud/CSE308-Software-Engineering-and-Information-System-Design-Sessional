import java.util.Scanner;

public class regularObserver extends Observer {
    Scanner scn=new Scanner(System.in);
    String str;
    private int current=2;
    public regularObserver(Subject s)
    {
        this.sub=s;
        this.sub.attach(this);
    }
    @Override
    public void update() {
        System.out.println("Regular user prompt:");
        if(this.sub.getState() == 1)
        {

            if(this.sub.getPrevious() == 2)
            {
                System.out.println("Server is partially down now. Do you want to continue using the limited functionality or pay $20 per hour to enjoy the full functionality taking service from server of DEF company? In the 2nd case, all your data will be copied to the server of DEF company.");
                System.out.println("Please choose:");
                System.out.println("1.Limited functionality");
                System.out.println("2.pay for full functionality");
                str=scn.nextLine();
                if(str.equalsIgnoreCase("1"))
                {
                    current=1;
                    //System.out.println("Your service is provided by ABC with limited functionality");
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
                System.out.print("Now the server is operational again. ");
                if(current == 0)
                {
                    current = 2;
                    System.out.println("Your total bill: x taka");
                }

            }
            else if(this.sub.getPrevious() == 1)
            {
                System.out.print("Now the server is operational again.");
                if(current == 0)
                {
                    current = 2;
                    System.out.println(" Your total bill: x taka");
                }
            }
        }

        else if(this.sub.getState() == 0)
        {
            if(this.sub.getPrevious() == 1)
            {
                System.out.println("Server is fully down now.");
            }
            else if(this.sub.getPrevious() == 2)
            {
                System.out.println("Server is fully down now. Do you want to pay $20 per hour to take service from the server of DEF company? Note that, it will copy all your data to the server of DEF company.");
                System.out.println("Please choose:");
                System.out.println("1.yes, pay $20 per hour");
                System.out.println("2.no");
                str=scn.nextLine();
                if(str.equalsIgnoreCase("1"))
                {
                    current=0;
                   // System.out.println("Your service is provided by DEF");
                }
                else
                {

                   // System.out.println("your service is interrupted");
                }

            }
        }

    }
}
