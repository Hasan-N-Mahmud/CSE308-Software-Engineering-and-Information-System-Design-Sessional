import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers=new ArrayList<Observer>();
    private int state=2;
    private int previous=-1;
    public int getState() {
        return state;
    }

    public int getPrevious() {
        return previous;
    }

    public void setState(int state) {
        this.previous=this.state;
        this.state = state;

        notifyAllObservers();
    }

    public void notifyAllObservers()
    {
        for(Observer ob: observers)
        {
            ob.update();
            System.out.println("");
        }
    }
    public void attach(Observer ob)
    {
        observers.add(ob);
    }

    public void detach(Observer ob)
    {
        observers.remove(ob);
    }


}
