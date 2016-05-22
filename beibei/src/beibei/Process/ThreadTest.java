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
         * 调用run方法
         */
        rat.run();  // 改为 rat.start()
        tor.run();  // 改为 tor.start()   比较下结果

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


