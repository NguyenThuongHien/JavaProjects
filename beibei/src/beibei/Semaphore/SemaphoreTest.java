package beibei.Semaphore;

/**
 * Created by sunyinhui on 16-5-25.
 */

/**
 * 一个场景 共同的资源
 * 生产者消费者模式 信号灯法
 * wait() 等待 释放锁
 * sleep() 不释放锁
 * notify()/notifyall() 唤醒
 *
 */
public class SemaphoreTest {

    public static void main(String[] args){

    }
}

class Movie{
    private String pic;
    //信号灯
    //flag->T 生产者生产 消费者等待 生产完成后通知消费者
    //flag->F 消费者消费 生产者等待 消费者完成后通知生产者
    private boolean flag = true;

    //播放
    public synchronized void play(String pic) throws InterruptedException {
        if (!flag){
            this.wait();
        }

        Thread.sleep(500);
        System.out.println("生产了："+pic);
        this.pic = pic;
        this.notify();
        this.flag = false;
    }

    public synchronized void watch() throws InterruptedException {
        if(flag){
            this.wait();
        }
        Thread.sleep(200);
        System.out.println("消费了："+ pic);
        this.notifyAll();
        this.flag = true;

    }
}
