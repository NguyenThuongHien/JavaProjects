package beibei;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by sunyinhui on 16-5-25.
 */

/**
 * 任务调度
 *     1. 安排在指定的时间执行指定的任务
 *        schedule(TimerTask task, Date timer)
 *     2. 安排指定的任务在指定的时间开始进行重复的固定延迟执行
 *        schedule(TImerTask task, Date timer, long period)
 */
public class TimerTest {
    public static void main(String[] args){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("so easy...");
            }
        },new Date(System.currentTimeMillis()+1000),200);


    }
}
