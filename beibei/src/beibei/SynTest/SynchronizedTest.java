package beibei.SynTest;

/**
 * Created by sunyinhui on 16-5-24.
 */


/**
 * 线程同步
 *        由于同一进程的多个线程共享同一片存储空间，在带来方便的同时也带来了访问冲突这个严重的问题
 *        Java语言提供了专门机制以解决这种冲突，有效避免了同一数据对象被多个线程同时访问
 *  由于我们可以通过private关键字来保证数据对象只能被方法访问，所以我们只需要针对方法提出一套机制
 *  这套机制就是synchronized关键字，它包括两种方法 synchronized方法和synchronized块
 */

/**
 * 同步：并发 多个线程同时访问同一份资源
 *      synchronized
 *                  1. 同步块
 *                          synchronized(引用类型 | this | 类.class){
 *
 *                                   }
 *                  2. 同步方法
 */
public class SynchronizedTest {
    public static void main(String[] args){
        //真实角色
        Web web = new Web();
        //代理 多个代理+真实角色引用
        Thread t1 = new Thread(web,"路人甲");
        Thread t2 = new Thread(web,"黄牛乙");
        Thread t3 = new Thread(web,"工程师");
        //启动线程
        t1.start();
        t2.start();
        t3.start();
    }
}


class Web implements Runnable{
    
    private int num = 200;
    private boolean flag = true;

    @Override
    public void run() {
        
        while(flag){
            try {
                test3();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }

    /**
     * synchronized 方法
     */
    public synchronized void test2() throws InterruptedException {
        if(num<=0){
            flag = false;
            return ;
        }

        Thread.sleep(10);
        System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
    }

    /**
     * synchronized块
     */
    public void test3() throws InterruptedException {
        synchronized(this){
            if(num<=0){
                flag = false;
                return;
            }
            Thread.sleep(10);
            System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
        }
    }
}
