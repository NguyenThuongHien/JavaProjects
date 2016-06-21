package beibei.ObjectOrientedProgramming.IOSystem;

/**
 * Created by sunyinhui on 16-6-21.
 */

import java.io.*;

/**
 * 对于一些敏感的信息，一旦序列化后，人们就可以通过读取文件或者拦截网络传输数据的方式来偷窥这些信息
 * 因此处于安全的原因，应该禁止对这些属性进行序列化，
 * 解决办法是把这些属性用transient修饰
 * password属性用transient修饰，因此不会参与序列化及反序列化过程
 */
public class User {
    private String name;
    private transient String password;
    public User(String name,String password){
        this.name = name;
        this.password = password;
    }

    public String toString(){
        return name+" "+password;
    }

    public static void main(String[] args) throws IOException {
        User user = new User("Tom","123456");
        System.out.println("Befor Serialization:"+user);
        ByteArrayOutputStream buf = new ByteArrayOutputStream();

        //把User对象序列化到一个字节缓冲中
        ObjectOutputStream o = new ObjectOutputStream(buf);
        o.writeObject(user);

        //从字节缓冲中反序列化User对象
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buf.toByteArray()));
        try {
            user = (User)in.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("After Serialization:"+user);
    }


}
