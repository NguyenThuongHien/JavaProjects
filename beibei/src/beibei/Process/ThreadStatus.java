package beibei.Process;

/**
 * Created by sunyinhui on 16-5-23.
 */

/**
 * 1. 新生状态 ：用new和Thread关键字或其子类建立一个线程对象后，该线程就处于新生状态
 *             处于新生状态的线程有自己的内存空间，通过调用start方法进入就绪状态
 * 2. 就绪状态 ：处于就绪状态的线程已经具备了运行条件，但还没有分配到cpu，处于就绪队列
 * 3. 运行状态 ：在运行状态的线程执行自己的run方法中的代码，直到调用其他方法而终止，
 *             或等待某资源而阻塞或完成任务而死亡，如果在给定的时间内没有执行结束，就会被系统给换下来回到等待执行状态
 * 4. 阻塞状态 ：处于运行状态的线程在某些情况下，如执行了sleep方法，或等待I/O设备等资源，将让出cpu并暂时停止运行
 *              进入阻塞状态，在阻塞状态的线程不能进入就绪队列，只有当引起阻塞的原因消除时，如睡眠时间已到
 *              或等待的I/O设备空闲下来，线程便进入就绪状态 重新到就绪队列中排队等待
 * 5. 死亡状态 ： 线程死亡的原因有两个 一个是正常运行的线程完成了它的全部工作，另一个是线程被强制性的终止。
 *              如通过执行stop或destroy方法来终止一个线程(不推荐使用这两个方法，前者会产生异常，后者是强制终止，不会释放锁)
 *
 *
 */


/**
 * 停止线程
 *         1 自然终止
 *         2 外部干涉
 *                  线程类中定义线程体使用标示
 *                  线程体使用该标志
 *                  提供对外的方法改变该标示
 */
public class ThreadStatus {

    public static void main(String[] args) throws InterruptedException {
        //真实角色
        Study stu = new Study();
        //代理角色 + 真实角色的引用
        new Thread(stu).start();   //内部类
        Thread.sleep(1000);
        stu.stop();  //调用方法改变标识

    }

}

class Study implements Runnable{
    //线程类中定义线程体使用标识
    private boolean flag = true;

    @Override
    public void run() {
        //线程体使用标识
        while(flag){
            System.out.println("study thread ...");
        }
    }

    //提供对外的方法改变该标识
    public void stop(){
        this.flag = false;
    }
}
