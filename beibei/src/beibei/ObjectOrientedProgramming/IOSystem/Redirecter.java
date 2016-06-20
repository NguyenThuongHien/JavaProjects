package beibei.ObjectOrientedProgramming.IOSystem;

/**
 * Created by sunyinhui on 16-6-20.
 */

import java.io.*;

/**
 * 标准IO重定向
 * System类提供了一些用于重定向的静态方法
 * setIn(InputStream in)
 * setOut(PrintStream out)
 * setErr(PrintStream err)
 * 有时候，程序向控制台输出大量数据，由于输出数据滚动太快，会影响阅读
 * 此时，可以把标准输出重定向到一个文件
 */
public class Redirecter {
    /**
     * 标准IO重定向
     */
    public static void redirect(InputStream in, PrintStream out, PrintStream err){
        System.setIn(in);
        System.setOut(out);
        System.setErr(err);
    }

    /**
     * 把来自输入流的数据写到输出流和错误流
     */
    public static void copy() throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        String data;
        while((data=br.readLine())!=null && data.length()!=0){
            System.out.println(data);       //向输出流写数据
            System.err.println(data);       //向错误流写数据
        }
    }
    public static void main(String[] args) throws IOException {
        InputStream standardIn = System.in;
        PrintStream standardOut = System.out;
        PrintStream standardErr = System.err;
        String fileName = "/home/sunyinhui/JavaProjects/beibei/src/beibei/ObjectOrientedProgramming/IOSystem";
        InputStream in = new BufferedInputStream(new FileInputStream(fileName+"/test.txt"));
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream(fileName+"/out.txt")));
        PrintStream err = new PrintStream(new BufferedOutputStream(new FileOutputStream(fileName+"/err.txt")));
        redirect(in,out,err);
        copy();

        //对于用户创建的流，当不在使用它们时，应该关闭它们
        in.close();
        out.close();
        err.close();

        redirect(standardIn,standardOut,standardErr);
        copy();  //把从键盘上的数据输出到控制台


    }
}
