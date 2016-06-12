package beibei.ObjectOrientedProgramming.ThreadInterCommunication;

/**
 * Created by sunyinhui on 16-6-12.
 */

/**
 * 不同的线程执行不同的任务，如果这些任务有某种联系，线程之间必须能够通信，协调完成工作
 * 例如生产者和消费者共同操作堆栈，当堆栈为空时，消费者无法取出产品，应该先通知生产者向堆栈中加入产品
 * 但堆栈已满时，生产者无法继续加入产品，应该先通知消费者从堆栈中取出产品。
 * java.lang.Object类中提供了两个用于线程通信的方法
 *      wait():执行该方法的线程释放对象的锁，Java虚拟机把该线程放到对象的等待池中。
 *             该线程等待其他线程将它唤醒
 *      notify():执行该方法的线程唤醒在对象的等待池中等待的一个线程。Java虚拟机从对象的等待池中随机选择
 *               一个线程，把它转到对象的锁池中。
 *
 */
public class ThreadInterCoummunication {
    public static void main(String[] args){
        Stack stack1 = new Stack("Stack1");
        Producer producer1 = new Producer(stack1,"producer1");
        Consumer consumer1 = new Consumer(stack1,"consumer1");
//        Consumer consumer2 = new Consumer(stack1,"consumer2");

//        Stack stack2 = new Stack("Stack2");
//        Producer producer2 = new Producer(stack2,"producer2");
//        Producer producer3 = new Producer(stack2,"producer3");
//        Consumer consumer3 = new Consumer(stack1,"consumer3");
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
    public synchronized int getPoint(){
        return point;
    }
    public synchronized String pop(){
            this.notifyAll();
            while(point == -1){
                System.out.println(Thread.currentThread().getName()+":wait");
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String goods = buffer[point];
            buffer[point] = null;
            Thread.yield();
            point--;
            return goods;
    }
    public synchronized void push(String goods){
            this.notifyAll();
            while(point == buffer.length -1 ){
                System.out.println(Thread.currentThread().getName()+":wait");
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            point++;
            Thread.yield();
            buffer[point] = goods;
    }
}
