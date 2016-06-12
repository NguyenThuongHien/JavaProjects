package beibei.ObjectOrientedProgramming.ThreadSync;

/**
 * Created by sunyinhui on 16-6-12.
 */
public class MachineTest extends Thread {
    private int a=1;
    public synchronized void print(){
        System.out.println("a="+a);
    }
    public void run(){
        synchronized (this){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a = 1/0;        // 抛出ArithmeticException
            a++;
        }
    }

    public static void main(String[] args){
        MachineTest machine = new MachineTest();
        machine.start();
        Thread.yield();
        machine.print();
    }
}
