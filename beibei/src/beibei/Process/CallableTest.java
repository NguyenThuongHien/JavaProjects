package beibei.Process;

/**
 * Created by sunyinhui on 16-5-22.
 */


import java.util.concurrent.*;

/**
 * Callable 和 Future 接口
 * Callable是类似于Runnable的接口
 * 不同之处：
*          1. Callable规定的方法是call()，而Runnable规定的方法是run()
*          2. call()可抛出异常，而run()方法是不能抛出异常
*          3. Callable的任务执行后可返回值，运行callable任务可拿到一个Future对象，而Runable是没有返回值的
 *
 *Future表示计算的结果，它提供了检查计算是否完成的方法，以等待计算的完成，并检索计算的结果
 * 通过Future对象可了解任务执行情况，可取消任务的执行，还可获取任务执行的结果
 *
 * 流程：
 *     1. 创建Callable实现类 + 重写call
 *     2. 借助执行调度服务ExecutorService 获取Future对象
 *         ExecutorService ser = Executors.newFixedThreadPool(2);
 *         Future result = ser.submit(实现类对象)
 *     3. 获取值result.get()
 *     4. 停止服务 ser.shutdownNow();
 *
 */
public class CallableTest {

    public  static void main(String[] args) throws InterruptedException, ExecutionException {
        //创建线程
        ExecutorService ser =  Executors.newFixedThreadPool(2);
        Race tortoise = new Race("tortoise",1000);
        Race rabbit   = new Race("rabbit",500);

        //获取值
        Future<Integer> tortoiseresult = ser.submit(tortoise);
        Future<Integer> rabbitresult = ser.submit(rabbit);

        Thread.sleep(9000);             //设置9秒停下
        tortoise.setFlag(false);        //flag设置为false,跳出线程体while循环
        rabbit.setFlag(false);          //flag设置为false,跳出线程体while循环


        int tortoisenum = tortoiseresult.get();
        int rabbitnum   = rabbitresult.get();


        System.out.println("tortoise run >> " + tortoisenum);
        System.out.println("rabbit run >> " + rabbitnum);

        //停止服务
        ser.shutdown();


    }



}


class Race implements Callable<Integer>{

    private String name;
    private long time;
    private int step=0;
    private boolean flag = true;

    public Race() {
    }

    public Race(String name) {
        super();
        this.name = name;
    }

    public Race(String name, long time) {
        super();
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public Integer call() throws Exception {
        while(flag){
            Thread.sleep(time);  //延时
            step++;
        }
        return step;
    }
}