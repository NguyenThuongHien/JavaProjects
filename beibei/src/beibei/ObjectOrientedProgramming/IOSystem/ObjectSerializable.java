package beibei.ObjectOrientedProgramming.IOSystem;

/**
 * Created by sunyinhui on 16-6-21.
 */


import java.io.*;
import java.util.Date;

/**
 * 对象的序列化是指把对象写到一个输出流中，对象的反序列化是指从一个输入流中读取一个对象
 *
 */
public class ObjectSerializable {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./object.obj"));
        String obj1 = "hello";
        Date obj2 = new Date();
        People obj3 = new People("Tom",20);

        //序列化对象
        out.writeObject(obj1);
        out.writeObject(obj2);
        out.writeObject(obj3);
        out.close();

        //反序列化
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("./object.obj"));
        String obj11 = (String)in.readObject();
        System.out.println("obj11:"+obj11);
        System.out.println("obj11==obj1:"+(obj11==obj1));
        System.out.println("obj11.equals(obj1):"+(obj11.equals(obj1)));

        Date obj22 = (Date)in.readObject();
        System.out.println("obj22:"+obj22);
        System.out.println("obj22==obj2:"+(obj22==obj2));
        System.out.println("obj22.equals(obj2):"+(obj22.equals(obj2)));

        People obj33 = (People)in.readObject();
        System.out.println("obj33:"+obj3);
        System.out.println("obj33==obj3:"+(obj33==obj3));
        System.out.println("obj33.equals(obj3):"+(obj11.equals(obj3)));

        in.close();

    }
}

class People implements Serializable{
    private String name;
    private int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("call second constructor");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof People)) return false;
        final People other = (People)o;
        if (this.name.equals(other.name) && this.age == other.age) return true;
        else return false;
    }

    @Override
    public String toString() {
        return "name=" + name + ", age=" + age;
    }
}
