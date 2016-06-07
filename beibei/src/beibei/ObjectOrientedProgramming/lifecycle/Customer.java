package beibei.ObjectOrientedProgramming.lifecycle;

/**
 * Created by sunyinhui on 16-6-7.
 */
public class Customer implements Cloneable {

    private String name;
    private int age;

    public Customer(){
        this("unknown",0);
        System.out.println("call default constructor");
    }

    public Customer(String name, int age){
        this.name = name;
        this.age = age;
        System.out.println("call second constructor");
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if (!(o instanceof Customer)) return false;

        final Customer other = (Customer)o;

        if (this.name.equals(other.name) && this.age == other.age){
            return true;
        }else {
            return false;
        }
    }

    public String toString(){
        return "name="+name+",age="+age;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, CloneNotSupportedException {
        //运用反射创建Customer对象
//        Class objClass = Class.forName("Customer");
//        Customer c1 = (Customer)objClass.newInstance();
//        System.out.println("c1:"+c1);

        //用new语句创建Customer对象
        Customer c2 = new Customer("Tom",2);
        System.out.println("c2"+c2);

        //运用克隆创建Customer对象
        Customer c3 = (Customer)c2.clone();
        System.out.println("c2==c3:"+(c2==c3));
        System.out.println("c2.equals(c3):"+c2.equals(c3));
        System.out.println("c3:"+c3);
    }


}
