package beibei.ObjectOrientedProgramming.ThreadSync;

/**
 * Created by sunyinhui on 16-6-12.
 */

/**
 * 同步是解决共享资源竞争的有效手段，当一个线程已经在操纵共享资源时，其他线程只能等待，
 * 只有当已经在操作共享资源的线程执行完同步代码块后，其他线程才有机会操作共享资源
 * 但是，多线程的同步和并发是一对此消彼长的矛盾。
 * 只有当一个Person线程执行完整个for循环后，其他Person线程才有机会执行for循环，
 * 尽管在for循环中调用了yield()方法，但是执行该方法的Person线程仅仅试图把CPU让给其他线程，
 * 但是不会释放Well对象的锁，其他Person线程由于不能获得锁，只能依然在Well对象的锁池中等待
 */
public class Person extends Thread{
    private Well well ;
    public Person(Well well){
        this.well = well;
        start();
    }
    public void run(){
        synchronized(well){
            for (int i = 0; i<10; i++){
                well.withdraw();
                yield();
            }
        }
    }

    public static void main(String[] args){
        Well well = new Well();
        Person person[] = new Person[10];
        for (int i=10; i<10; i++){
            person[i] = new Person(well);
        }
    }

}

class Well{
    private int water = 1000;
    public void withdraw(){
        water--;
        System.out.println(Thread.currentThread().getName()+":water left:"+water);
    }
}
