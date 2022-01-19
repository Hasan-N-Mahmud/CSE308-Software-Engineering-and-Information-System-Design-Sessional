import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
public class CompositeDP {
    public static void main(String[] args) {

        List<Drive> arr = new ArrayList<Drive>();
        boolean prop = false;
        String str;
        String str1;
        String str2;
        String str3;
        Scanner scn = new Scanner(System.in);
        Drive current = null;
        while (true) {
            System.out.println("Enter Command: <C R E L H DET X>");
            str2=scn.nextLine();
            if (str2.equalsIgnoreCase("C")) {
                System.out.println("Type: <D FD FL>");
                str1=scn.nextLine();
                if (str1.equalsIgnoreCase("D")) {
                    prop = true;
                    System.out.println("Enter name:");
                    str = scn.nextLine();
                    Drive d1 = new Drive(str, "drive", str + ":/");
                    current = d1;
                    arr.add(d1);
                    System.out.println("Drive Created");


                }
                else if (str1.equalsIgnoreCase("FD")) {
                    if (current==null) {
                        System.out.println("Create a drive first...");

                    }
                    else {
                        System.out.println("Enter name:");
                        str = scn.nextLine();
                        Drive d1 = new Drive(str, "folder", current.getDir() + str + "/");
                        current.add(d1);
                        System.out.println("Folder Created");
                    }

                }
                else if (str1.equalsIgnoreCase("FL")) {
                    System.out.println("Enter name:");
                    str = scn.nextLine();
                    Drive d1 = new Drive(str, "file", current.getDir() + str + "/");
                    current.add(d1);
                    System.out.println("File Created");
                }
            }

            else if (str2.equalsIgnoreCase("R")) {

                System.out.println("Enter name:");
                str=scn.nextLine();

                    for(int i=0;i<current.getSub().size();i++)
                    {
                        if(current.getSub().get(i).getName().equalsIgnoreCase(str))
                        {
                            if(current.getSub().get(i).getSub().size()==0){
                            current.getSub().remove(i);}
                            else
                                System.out.println("Delete all the Leafs first ");
                        }
                    }


            }

            else if (str2.equalsIgnoreCase("E")) {
                System.out.println("Enter name:");
                str = scn.nextLine();
                if (current == null) {
                    for (int i = 0; i < arr.size(); i++) {
                        if (arr.get(i).getName().equalsIgnoreCase(str)) {
                            current = arr.get(i);
                        }
                    }
                    if (current == null)
                        System.out.println("Directory not found");
                } else if (current.getType().equalsIgnoreCase("drive") || current.getType().equalsIgnoreCase("folder")) {
                    for (int i = 0; i < current.getSub().size(); i++) {
                        if (current.getSub().get(i).getName().equalsIgnoreCase(str)) {
                            current = current.getSub().get(i);
                        }

                    }
                }
            }

            else if (str2.equalsIgnoreCase("L")) {
                    current.list();
                }

            else if (str2.equalsIgnoreCase("H")) {
                System.out.println("Drives:");
                for (int i = 0; i < arr.size(); i++) {
                        System.out.println(arr.get(i).getName());
                        current = null;
                    }
                }

            else if(str2.equalsIgnoreCase("X"))
                {
                    break;
                }
            else if(str2.equalsIgnoreCase("DET"))
            {
                current.details();
            }



        }
    }
}
