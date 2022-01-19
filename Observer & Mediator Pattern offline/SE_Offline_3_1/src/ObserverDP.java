import java.util.Scanner;
public class ObserverDP {
    public static void main(String[] args) {
        Subject s=new Subject();
        PremiumObserver pob=new PremiumObserver(s);
        regularObserver rob=new regularObserver(s);
        Scanner scn=new Scanner(System.in);
        String str;
        int i,j,k,current=2;

        while (true)
        {
            System.out.println("Enter server state: (press X to exit)");
            //System.out.println("<2 for fully operational,1 for partially operational,0 for fully down>");
            str=scn.nextLine();
            if(str.equalsIgnoreCase("X"))
                break;
            i=Integer.parseInt(str);
            i=i-2;
            //i=Math.abs(i);
            s.setState(Math.abs(i));


        }

    }
}
