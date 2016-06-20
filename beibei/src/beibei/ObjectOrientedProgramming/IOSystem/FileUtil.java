package beibei.ObjectOrientedProgramming.IOSystem;


import java.io.*;

/**
 * Created by sunyinhui on 16-6-19.
 */
public class FileUtil {
    /**
     * 从一个文件中逐行读取字符串，采用本地平台的字符编码
     */
    public void readFile(String fileName) throws IOException {
        readFile(fileName,null);
    }

    /**
     * 从一个文件中逐行读取字符串，参数charsetName指定文件的字符编码
     */
    private void readFile(String fileName, String charsetName) throws IOException {
        InputStream in = new FileInputStream(fileName);
        InputStreamReader reader = null;
        if (charsetName==null)
            reader = new InputStreamReader(in);
        else
            reader = new InputStreamReader(in,charsetName);
        BufferedReader  br = new BufferedReader(reader);
        String data;
        while ((data = br.readLine())!=null){
            System.out.println(data);
        }
        br.close();
    }

    /**
     * 把一个文件的字符内容拷贝到另一个文件中，并且进行了相关的字符编码转换
     */
    public void copyFile(String from, String charsetFrom, String to,String chasetTo) throws IOException {
        InputStream in = new FileInputStream(from);
        InputStreamReader reader;
        if (charsetFrom == null)
            reader = new InputStreamReader(in);
        else
            reader = new InputStreamReader(in,charsetFrom);
        BufferedReader br = new BufferedReader(reader);

        OutputStream out = new FileOutputStream(to);
        OutputStreamWriter writer = new OutputStreamWriter(out,chasetTo);
        BufferedWriter bw = new BufferedWriter(writer);
        PrintWriter pw = new PrintWriter(bw,true);
        String data;
        while((data=br.readLine())!=null){
            pw.println(data);
        }
        br.close();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        FileUtil util = new FileUtil();
        //按照本地贫太的字符编码读取字符
        String fileName = "/home/sunyinhui/JavaProjects/beibei/src/beibei/ObjectOrientedProgramming/IOSystem";
        util.readFile(fileName+"/test.txt");

        //把test.txt文件中的字符内容拷贝到out.txt中，out.txt采用UTF-8字符编码
        util.copyFile(fileName+"/test.txt", null, fileName+"/out.txt", "UTF-8");

        //按照本地平台的字符编码读取字符，读到错误的数据
        util.readFile(fileName+"/out.txt");
        //按照UTF-8字符编码读取字符
        util.readFile(fileName+"/out.txt","utf-8");

    }

}
