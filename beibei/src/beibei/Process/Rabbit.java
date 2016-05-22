package beibei.Process;

/**
 * Created by sunyinhui on 16-5-22.
 */


/**
 * 模拟龟兔赛跑
 * 创建一个线程 继承Thread + 重写run()方法线程体
 * 使用线程： 创建子类线程 + 调用 对象.start()方法 注意线程启动不代表线程运行
 */
public class Rabbit extends Thread {

    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("Rabbit run " + i);
        }
    }


}
