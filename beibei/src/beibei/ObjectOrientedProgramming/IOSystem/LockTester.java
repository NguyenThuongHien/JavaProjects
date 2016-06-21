package beibei.ObjectOrientedProgramming.IOSystem;

/**
 * Created by sunyinhui on 16-6-20.
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;

/**
 * nio引入了文件加锁机制，允许程序同步访问某个作为共享资源的文件
 * Java使用的文件锁对操作系统的其他线程是可见的
 * 因为这种文件锁直接映射到本地操作系统的加锁工具
 */
public class LockTester {
    public static void main(String[] args) throws IOException, InterruptedException {
        String fileName = "/home/sunyinhui/JavaProjects/beibei/src/beibei/ObjectOrientedProgramming/IOSystem";
        FileOutputStream fos = new FileOutputStream(fileName+"/test.txt");
        FileLock fl  = fos.getChannel().tryLock();
        if(fl!=null){
            System.out.println("Lock File");
            System.out.println(fl.isShared());
            Thread.sleep(60000);
            fl.release();
            System.out.println("Released Lock");
        }
    }
}
