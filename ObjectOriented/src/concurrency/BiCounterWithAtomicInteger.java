package concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BiCounterWithLock {

    private int i=0;
    private int j=0;

    Lock lockForI = new ReentrantLock();
    Lock lockForJ = new ReentrantLock();

    public int getI() {
        return i;
    }

    synchronized void incrementI () {
       lockForI.lock(); //Get Lock
        i++;
        lockForI.unlock();//Release Lock
    }

    public int getJ() {
        return j;
    }

    synchronized void incrementJ () {
      lockForJ.lock();  //Get Lock
        j++;
       lockForJ.unlock(); //Release Lock
    }
}
