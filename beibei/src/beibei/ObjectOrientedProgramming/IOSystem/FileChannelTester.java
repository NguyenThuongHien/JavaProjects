package beibei.ObjectOrientedProgramming.IOSystem;

/**
 * Created by sunyinhui on 16-6-20.
 */

/**
 * 新的IO类库 java.nio 目的是提高IO操作的效率
 * java.nio包引入了4个关键的数据类型
 * Buffer   缓冲区 临时存放输入或输出数据
 * Charset  具有把Unicode 字符编码转换为其他字符编码，以及把其他编码转换为unicode的能力
 * Channel  数据传输通道 能够把Buffer中的数据写到数据汇，或把数据源的数据写入到Buffer
 * Selector 支持异步IO操作，也称为非阻塞IO操作，一般在编写服务器程序时需要使用到它
 * nio从两个方面来提高IO操作的效率
 * 1 利用Buffer缓冲器和Channel通道来提高IO操作的速度
 * 2 利用Select来支持非阻塞IO操作
 */

/**
 * Buffer从两个方面来提高IO操作的效率
 * 1 减少实际的物理读写次数
 * 2 缓冲区在创建时被分配内存，这块内存区域一直被重用，这可以减少动态分配和回收区域的次数
 */

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.RandomAccess;

/**
 * Channel用来连接缓冲区与数据源或数据汇
 * 数据源的数据经过通道到达缓冲区，缓冲区的数据经过通道到达数据汇
 *
 */
public class FileChannelTester {

    public static void main(String[] args) throws IOException {
        final int BSIZE = 1024;
        //向文件中写数据
        String fileName = "/home/sunyinhui/JavaProjects/beibei/src/beibei/ObjectOrientedProgramming/IOSystem/test.txt";
        FileChannel fileChannel = new FileOutputStream(fileName).getChannel();
        fileChannel.write(ByteBuffer.wrap("helloworld".getBytes()));
        fileChannel.close();

        //向文件末尾添加数据
        fileChannel = new RandomAccessFile(fileName,"rw").getChannel();
        fileChannel.position(fileChannel.size());//定位到文件末尾
        fileChannel.write(ByteBuffer.wrap("Java".getBytes()));
        fileChannel.close();

        //读数据
        fileChannel = new FileInputStream(fileName).getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fileChannel.read(buff);     //把文件中的数据读入到ByteBuffer中
        buff.flip();
        Charset cs = Charset.defaultCharset();  //获得本地平台的字符编码
        System.out.println(cs.decode(buff));    //转换为unicode字符编码
        fileChannel.close();

    }

}
