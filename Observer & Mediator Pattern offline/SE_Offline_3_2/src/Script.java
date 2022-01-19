public class Script {
    private int roll;
    private int numbr;
    private boolean mistake=false;
    public Script(int a,int b)
    {
        this.roll=a;
        this.numbr=b;
    }

    public int getRoll() {
        return roll;
    }

    public int getNumbr() {
        return numbr;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public void setNumbr(int numbr) {
        this.numbr = numbr;
    }

    public boolean isMistake() {
        return mistake;
    }

    public void setMistake(boolean mistake) {
        this.mistake = mistake;
    }

}
