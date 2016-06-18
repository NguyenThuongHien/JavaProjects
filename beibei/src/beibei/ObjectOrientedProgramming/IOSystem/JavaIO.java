package beibei.ObjectOrientedProgramming.IOSystem;


import java.io.*;

/**
 * Created by sunyinhui on 16-6-13.
 */
public class JavaIO {

    public static void main(String[] args) throws IOException {
        FileOutputStream out = new FileOutputStream("./testIO.txt");
        BufferedOutputStream bout = new BufferedOutputStream(out,2);
        DataOutputStream dout = new DataOutputStream(bout);
        dout.writeUTF("hello JavaIO");

        InputStream in = new FileInputStream("./testIO.txt");
        BufferedInputStream bin = new BufferedInputStream(in);
        DataInputStream din = new DataInputStream(bin);
        System.out.println(din.readUTF());
        in.close();
    }

}
