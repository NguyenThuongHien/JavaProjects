package beibei.ObjectOrientedProgramming.ThreadSync;

/**
 * Created by sunyinhui on 16-6-10.
 */

/**
 * 以生产者/消费者的例子来演示多个线程对共享资源的竞争
 */

import java.awt.image.ImageProducer;

/**
 * SyncTest类：提供程序入口main()，负责创建生产者和消费者线程，并切启动这些线程
 * Producer类：生产者线程，不断向堆栈中取出产品
 * Consumer类：消费者线程，不断向堆栈中取出产品
 * Stack类   ：堆栈，允许从堆栈中取出或加入产品
 */
public class SyncTest {
    public static void main(String[] args){
        Stack stack = new Stack("stack1");
        Producer producer = new Producer(stack,"producer");
        Consumer consumer = new Consumer(stack,"consumer");


    }
}
/**生产者线程*/
class Producer extends Thread{
    private Stack theStack;
    public Producer(Stack s, String name){
        super(name);
        theStack = s;
        start();            //  启动自身生产者线程
    }

    public void run(){
        String goods;
        for (int i=0; i<100; i++){
            goods = "goods"+(theStack.getPoint()+1);
            theStack.push(goods);
            System.out.println(getName() + ":push " + goods +" to " + theStack.getClass().getName());
        }
    }


}

/**消费者线程*/
class Consumer extends Thread{
    private Stack theStack;
    public Consumer (Stack s, String name){
        super(name);
        theStack = s;
        start();           //启动自身进程
    }

    public void run(){
        String goods;
        for (int i = 0; i < 100; i++) {
            goods = theStack.pop();
            System.out.println(getName()+":pop "+ goods + "from "+ theStack.getClass().getName());
        }

    }

}
class Stack{
    private String name;
    private String[] buffer = new String[100];
    int point =-1;

    public Stack(String name){
        this.name = name;
    }
    public int getPoint(){
        return point;
    }
    public String pop(){
        synchronized (this){
            String goods = buffer[point];
            buffer[point] = null;
            point--;
            return goods;
        }

    }
    public void push(String goods){
        synchronized(this){
            point++;
            buffer[point] = goods;
        }
    }
}

/**
 * 每个Java对象都有一个同步锁，在任何时刻，最多只允许一个线程拥有这把锁。
 * 当消费者线程试图执行以上带有synchronized(this)标记的代码块时，消费者线程必须
 * 首先获得this关键字引用的Stack对象的锁。
 * 在一下两种情况下，消费者线程有着不同的命运
 *    1.  假如这个锁已经被其他线程占用，Java虚拟机就会把这个消费者线程放到Stack对象的锁池中，
 *        消费者线程进入阻塞状态，在Stack对象的锁池中可能有许多等待锁的线程
 *        等到其他线程释放了锁，Java虚拟机会从锁池中随机取出一个线程，使这个线程拥有锁，并且转到就绪状态
 *    2.  假如这个锁没有被其他线程占用，消费者线程就会获得这把锁，开始执行同步代码，
 *        在一般情况下，消费者线程只有执行完同步代码块，才会释放锁，使得其他线程能够获得锁。
 */
/**
 *  线程同步的特征
 *      1. 如果一个同步代码块和非同步代码块同时操作共享资源，仍然会造成对共享资源的竞争。
 *         因为当一个线程执行一个对象的同步代码块时，其他线程仍然可以执行对象的非同步代码块。
 *      2. 每个对象都有唯一的同步锁。
 *      3. 在静态方法前面也可以使用synchronized修饰符
 *      4. 当一个线程开始执行同步代码块时，并不意味着必须以不断的方式运行。进入同步代码块的线程也可以执行
 *          Thread.sleep()或者执行Thread.yield()方法。此时，它并没有释放锁，只是把运行机会即CPU
 *          让给了其他的线程。
 *      5. synchronized声明不会被继承，如果一个用synchronized修饰的方法被子类覆盖，那么子类中这个方法不能
 *         再保证同步，除非也用synchronized修饰。
 *
 */