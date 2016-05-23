package beibei.Process;

/**
 * Created by sunyinhui on 16-5-23.
 */


/**
 * 阻塞状态
 *         1. join  ：合并线程
 *         2. Yield ：暂停自己的线程 static方法
 *         3. Sleep ：休眠暂停执行 不释放锁 模拟网络延时
 *
 */

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 休眠暂停执行 不释放锁
 *          1. 倒计时
 *          2. 模拟网络延时
 */
public class Sleep {

    public static void main(String[] args) throws InterruptedException {

        Date endTime = new Date(System.currentTimeMillis() + 10*1000);
        long end = endTime.getTime();
        while(true){
            System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
            Thread.sleep(1000);
            endTime = new Date(endTime.getTime()-1000);
            if(end-1000>endTime.getTime()){
                break;
            }

        }
        test();
    }

    private static void test() throws InterruptedException {
        int num = 10;
        while(true){
            System.out.println(num--);
            Thread.sleep(1000);
            if(num<=0){
                break;
            }
        }
    }
}


