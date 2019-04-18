package concurrency;

public class BiCounter {

    private int i=0;
    private int j=0;

    public int getI() {
        return i;
    }

    synchronized void incrementI () {
        i++;
    }

    public int getJ() {
        return j;
    }

    synchronized void incrementJ () {
        j++;
    }
}
