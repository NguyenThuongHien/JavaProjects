package beibei.ObjectOrientedProgramming.InnerClass;

/**
 * Created by sunyinhui on 16-6-8.
 */

/**
 * 静态内部类
 * 用static修饰，静态内部类有以下特点。
 *      1. 静态内部类的实例不会自动持有外部类的特定实例的引用，在创建内部类的实例时，不必创建外部类的实例。
 *      2. 静态内部类可以直接访问外部类的静态成员，如果访问外部类的实例成员，就必须通过外部类的实例去访问。
 *      3. 在静态内部类中可以定义静态成员和实例成员
 *      4. 客户类可以通过完整的类名直接访问静态内部类的静态成员。
 *
 */
public class StaticInnerClass {
    public void test(){
        A.B b = new A.B();
        b.v = 1;
        A.B.v2 = 3;  //4. 客户类可以通过完整的类名直接访问静态内部类的静态成员
    }
}

class A{
    private int a1;
    private static int a2;
    public static class B{
        int v;
        static int v2;          // 可以定义静态变量
    //  int b1 = a1;            //编译错误，不能直接访问外部类A的实例变量a1
        int b2 = a2;            //合法，可以直接访问外部类A的静态变量a2
        int b3 = new A().a1;    //合法，可以通过类A的实例访问变量a1
    }
}
