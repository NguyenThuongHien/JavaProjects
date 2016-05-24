package beibei.Process;

/**
 * Created by sunyinhui on 16-5-24.
 */


public class NetWorkDelay {
    public static void main(String[] args){
        //真实角色
        Web web = new Web();

        //代理 多个代理+真实角色的引用
        Thread t1 = new Thread(web,"路人甲");
        Thread t2 = new Thread(web,"黄牛乙");
        Thread t3 = new Thread(web,"工程师");

        //启动线程
        t1.start();
        t2.start();
        t3.start();

    }
}

/**
 * 涉及到 资源冲突 对同一资源并发访问 需要解决多线程并发问题
 */
class Web implements Runnable{

    private int num =20;


    @Override
    public void run() {

        while(true){
            if(num<=0){
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
        }
    }
}

