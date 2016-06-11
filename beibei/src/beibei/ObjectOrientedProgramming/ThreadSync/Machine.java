package beibei.ObjectOrientedProgramming.ThreadSync;

/**
 * Created by sunyinhui on 16-6-10.
 */
public class Machine implements Runnable{

    private int a = 1;              //共享数据
    @Override
    public void run() {
        for (int i = 0; i<1000;i++){
            a += i;
            Thread.yield();
            a -= i;
            System.out.println(a);
        }
    }

    public static void main(String[] args){
        Machine machine = new Machine();
        Thread t1 = new Thread(machine);
        Thread t2 = new Thread(machine);
        t1.start();
        t2.start();
    }
}
/**
 * 原子操作由相关的一组操作完成，这些操作可能操纵与其他线程共享的资源
 * 为了保证得到正确的运算结果，一个线程在执行原子操作的期间，
 * 应该采取措施使得其他线程不能操纵共享资源，这里的共享资源是指Machine对象的实例变量a
 *
 */