package beibei.Process;

/**
 * Created by sunyinhui on 16-5-22.
 */

/**
 * Java是单继承的
 * 通过Runnable接口实现多线程
 * 使用静态代理设计模式创建多线程
 * 创建进程的三种方法
 * 1 继承Thread + 实现run()方法
 *   创建子类对象 + 对象.start()
 * 2 实现Runnable + 重写run()方法
 *     启动：使用静态代理
 *          1 创建真实角色
 *          2 创建代理角色 Thread + 引用
 *          3 代理角色.start()
 */
public class RunnableTest {
    public static void main(String[] args){
        //1. 创建真实角色
        Program pro = new Program();

        //2. 创建代理角色 + 真实角色的引用
        Thread proxy = new Thread(pro);

        //3. 调用代理角色.start()
        proxy.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("一边聊QQ! >> " + i);
        }
    }


}

/**
 * 真实角色
 */
class Program implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("一边敲HelloWorld! >> "+ i);
        }
    }
}