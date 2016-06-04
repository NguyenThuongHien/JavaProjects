package beibei.ObjectOrientedProgramming.Inherit;

/**
 * Created by sunyinhui on 16-6-3.
 */
class SuperBase {
    String var = "Base's Variable";
    void method(){
        System.out.println("call Base's method");
    }
}


public class SubTest extends SuperBase{
    String var = "Sub's variable";               //隐藏父类的var变量
    void method(){
        System.out.println("call Sub's method"); //覆盖父类的method()方法
    }

    void test(){
        String var = "Local variable";          //局部变量
        System.out.println("var is " + var);
        System.out.println("this.var is "+ this.var);
        System.out.println("super.var is "+ super.var);

        method();
        this.method();
        super.method();
    }


    public static void main(String[] args){
        SubTest sub = new SubTest();
        sub.test();
    }
}


/**
 * super的使用
 * 1. 在类的构造方法中，通过super语句调用这个类的父类的构造方法
 * 2. 在子类中访问父类的被屏蔽的方法和属性
 */

/**
 * Note: 如果父类中的成员变量和方法被定义为private类型，那么子类永远无法访问它们
 * 如果试图采用super.var的形式去访问父类的private类型的var变量，就会导致编译错误
 */

/**
 * Note： 只能在构造方法或实例方法内使用super关键字，而在静态方法和静态代码块内不能使用super关键字
 */



