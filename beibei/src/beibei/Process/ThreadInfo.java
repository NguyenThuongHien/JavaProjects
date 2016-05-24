package beibei.Process;

/**
 *  Created by sunyinhui on 16-5-24.
 *
 * /

 /**
 * isAlive()              判断 线程是否还活着 即线程是否还未停止
 * getPriority()          获得线程的优先级数值
 * setPriority()          设置线程的优先级数值
 * setName()              给线程起一个名字
 * getName()              获取线程的名字
 * currentThread()        取得当前正在运行的线程对象也就是取得自己本身
 */

/**
 * currentThread() 是一个静态的方法，写在那个类就取得那个类本身
 */
public class ThreadInfo {

    public static void main(String[] args) throws InterruptedException {
        MyThread it = new MyThread();
        Thread proxy = new Thread(it,"just do it");
        proxy.setName("test");
        System.out.println(proxy.getName());
        System.out.println(Thread.currentThread().getName());
        System.out.println(proxy.isAlive());
        proxy.start();
        System.out.println(proxy.isAlive());
        Thread.sleep(10);
        proxy.stop();
        System.out.println(proxy.isAlive());

    }

}


class MyThread implements Runnable{

    @Override
    public void run() {

    }
}

