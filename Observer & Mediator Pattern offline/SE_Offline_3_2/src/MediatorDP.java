public class MediatorDP {
    public static void main(String[] args) {
        ExamController Controller =new ExamController();
        Examiner examiner=new Examiner(Controller);
        Students s1=new Students(Controller,1);
        Students s2=new Students(Controller,2);
        Students s3=new Students(Controller,3);
        Students s4=new Students(Controller,4);
        Students s5=new Students(Controller,5);

        Controller.SendScripts();
        Controller.rescrutinize();
    }
}
