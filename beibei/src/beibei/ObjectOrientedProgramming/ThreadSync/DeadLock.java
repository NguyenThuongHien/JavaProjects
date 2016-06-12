package beibei.ObjectOrientedProgramming.ThreadSync;

/**
 * Created by sunyinhui on 16-6-12.
 */
public class DeadLock extends Thread {

    private Counter counter;            //共享数据
    public DeadLock(Counter counter){
        this.counter = counter;
        start();
    }

    public void run(){
        for (int i=0; i<1000;i++){
            counter.add();
        }
    }

    public static void main(String[] args){
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();

        counter1.setFriend(counter2);
        counter2.setFriend(counter1);

        DeadLock deadLock1 = new DeadLock(counter1);
        DeadLock deadLock2 = new DeadLock(counter2);

    }
}

class Counter{
    private int a ;
    private Counter friend;
    public void setFriend(Counter friend){
        this.friend = friend;
    }

    public synchronized void add(){
        a++;
        Thread.yield();
        friend.delete();
        System.out.println(Thread.currentThread().getName()+":add");
    }

    public synchronized void  delete() {
        a--;
        System.out.println(Thread.currentThread().getName()+":delete");
    }
}

/**
 * 创建了deadLock1和deadLock2两个线程，这两个线程分别执行counter1和counter2对象的add()方法
 * 而counter1对象的add()方法会调用counter2对象的delete()方法，
 * counter2对象的add()方法会调用counter1对象的delete()方法。
 */
/**
 * 避免死锁的一个通用的经验法则是：当几个线程都要访问共享资源A,B,C时，保证使每个线程都按照同样的顺序去访问它们
 *
 */