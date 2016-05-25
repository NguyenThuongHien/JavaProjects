package beibei.Singleton;

/**
 * Created by sunyinhui on 16-5-25.
 */
public class SynDemo {
    public static void main(String[] args){

        JVMThread thread1 = new JVMThread(100);
        JVMThread thread2 = new JVMThread(500);

        thread1.start();
        thread2.start();

    }
}



class JVMThread extends Thread {


    private long time;

    public JVMThread() {
    }

    public JVMThread(long time) {
        this.time = time;
    }

    @Override
    public void run() {
        super.run();
        try {
            System.out.println(Thread.currentThread().getName()+"-->创建："+Jvm.getInstance(time));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class Jvm{

    private static Jvm instance = null;
    private Jvm(){

    }

    public static Jvm getInstance(long time) throws InterruptedException {
        if(null == instance){              //效率
            synchronized(Jvm.class){
                if (null == instance){
                    Thread.sleep(time);    //延时 放大错误
                    instance = new Jvm();  //安全
                }
            }
        }
        return instance;
    }



}

