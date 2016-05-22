package beibei.Process;

/**
 * Created by sunyinhui on 16-5-22.
 */

/**
 * 创建一个线程 继承Thread + 重写run()方法线程体
 * 使用线程： 创建子类线程 + 调用 对象.start()方法 注意线程启动不代表线程运行
 */
public class ThreadTest {
    public static void main(String[] args){

        /**
         * 创建子类对象
         */
        Rabbit rat = new Rabbit();
        Tortoise tor = new Tortoise();

        /**
         * 调用start方法
         */
        rat.start();  // 改为 rat.run()
        tor.start();  // 改为 tor.run()   比较下结果

        for (int i = 0; i < 10; i++) {
            System.out.println("main run >>" + i);
        }
    }
}


/**
 * 线程的启动并不是简单的调用run方法，而是有一个线程调度器来分别调用所有线程的run方法
 * 普通的run方法如果没有执行完是不会返回的，也就是说一直执行下去
 * 而start方法来启动线程。
 */

/**
 * 启动线程有两种方法
 * 1. 写一个类继承自Thread类，然后重写run方法，用start方法启动线程
 * 2. 写一个类实现Runnable接口，实现里面的run方法 用new Thread(Runnable target).start()来启动
 */

/**
 * 通过调用Thread类的start()方法来启动一个线程 这时此线程处于就绪状态，并没有运行
 * 然后通过调用run()称为线程体，它包含了要执行的这个线程的内容，run方法结束，此线程终止
 * 而如果直接调用run方法，这只是调用一个方法而已，程序中依然只有主线程和这个线程
 * 其程序执行路劲还是只有一条,就没有达到写现成的目的
 * 线程就是为了更好的利用cpu，提高程序执行速率的
 */

/**
 *  .run() 相当于调用一个方法，不会创建新的线程
 *  .start()创建新的线程，并且调用run方法
 */

