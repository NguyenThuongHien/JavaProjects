package beibei.ObjectOrientedProgramming.statictest;

/**
 * Created by sunyinhui on 16-6-1.
 */

/**
 * 静态代码块 静态方法
 * 静态代码块的作用：
 *              如果有些代码在项目启动的时候就执行，需要使用静态代码块，这种代码块是主动执行的
 * 静态方法：
 *              需要在项目启动的时候就初始化，在不创建对象的情况下，其他程序调用的时候，需要使用静态方法
 *              这种代码是被动执行的，静态方法在类加载的时候，就已经加载。 可以用类名直接调用
 *              比如main方法就必须是静态的，这是程序入口。
 *              Java中的main方法必须写成static的，因为，在类加载时无法创建对象，静态方法可以不通过对象调用
 *              所以在类加载时就可以通过main方法入口来运行程序。
 *
 * 区别：
 *      静态代码是主动执行的，静态方法是调用才执行的
 */

/**
 *一个类可以使用不包含任何方法体中的静态代码块，当类被载入时，静态代码块就被执行，且只被执行一次
 * 且只被执行一次，静态块常用来执行类属性的初始化。
 */


public class Parent {
    static String name = "hello";
    {
        System.out.println("parent block");
    }

    static{
        System.out.println("static block");
    }

    public Parent(){
        System.out.println("Parent constructor");
    }
    static void func(){
        System.out.println("Parent override");
    }

    public static void main(String[] args){
      new Child();
    }

}

class Child extends Parent{
    static String chileName = "hello world";
    {
        System.out.println("child block");
    }

    static{
        System.out.println("child static block");
    }

    public Child(){
        System.out.println("child constructor");
    }
    static void func(){
        System.out.println("Parent override");
    }

}

/**输出顺序如下：
         static block
         child static block
         parent block
         Parent constructor
         child block
         child constructor
 */
/**
 * 分析:当执行new Child()时，它首先去看父类里面有没有静态代码块，
 * 如果有，它先去执行父类里面静态代码块里面的内容，当父类的静态代码块里面的内容执行完毕之后，
 * 接着去执行子类(自己这个类)里面的静态代码块，当子类的静态代码块执行完毕之后，它接着又去看父类有没有非静态代码块，
 * 如果有就执行父类的非静态代码块，父类的非静态代码块执行完毕，接着执行父类的构造方法；
 * 父类的构造方法执行完毕之后，它接着去看子类有没有非静态代码块，如果有就执行子类的非静态代码块。
 * 子类的非静态代码块执行完毕再去执行子类的构造方法，这个就是一个对象的初始化顺序。
 */

/**
 * 总结: 对象的初始化顺序:首先执行父类静态的内容，父类静态的内容执行完毕后，接着去执行子类的静态的内容，
 * 当子类的静态内容执行完毕之后，再去看父类有没有非静态代码块，
 * 如果有就执行父类的非静态代码块，父类的非静态代码块执行完毕，接着执行父类的构造方法；
 * 父类的构造方法执行完毕之后，它接着去看子类有没有非静态代码块，如果有就执行子类的非静态代码块。
 * 子类的非静态代码块执行完毕再去执行子类的构造方法。
 * 总之一句话，静态代码块内容先执行，接着执行父类非静态代码块和构造方法，然后执行子类非静态代码块和构造方法。
 * 1.先执行静态代码块      先父类再子类
 * 2.接着执行非静态代码块  先父类再子类
 * 3.然后执行构造方法     先父类再子类
 */



