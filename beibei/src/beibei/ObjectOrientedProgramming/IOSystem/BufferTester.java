package beibei.ObjectOrientedProgramming.IOSystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by sunyinhui on 16-6-20.
 */
public class BufferTester {
    public static void main(String[] args) throws IOException {
        final int BSIZE = 1024;
        //把test.txt文件中的数据拷贝到out.txt中
        String fileName = "/home/sunyinhui/JavaProjects/beibei/src/beibei/ObjectOrientedProgramming/IOSystem";
        FileChannel in = new FileInputStream(fileName+"/test.txt").getChannel();
        FileChannel out = new FileOutputStream(fileName+"/out.txt").getChannel();

        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        while (in.read(buff)!=-1){
            buff.flip();
            out.write(buff);
            buff.clear();
        }
        in.close();
        out.close();
    }
}
