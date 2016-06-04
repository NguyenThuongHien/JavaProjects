package beibei.ObjectOrientedProgramming.Inherit;

/**
 * Created by sunyinhui on 16-6-2.
 */

import java.io.IOException;

/**
 * 用extends关键字来表示一个类继承了另一个类
 * 当Sub和Base位于同一个包中，Sub继承Base中的public protected 和默认default访问级别的成员变量和成员方法
 * 当Sub和Base位于不同的包中，Sub类继承Base类中public protected访问级别的成员变量和成员方法
 */

 public class Sub extends Base{


    /**
     * 重载方法 在同一个类中 (方法覆盖 在继承关系的类中)
     *      1. 方法名同名
     *      2. 参数列表不同(参数类型、参数个数、参数顺序)
     *      3. 与返回类型无关
     *      4. 与修饰符无关
     */

    /**
     * 作为程序入口的main()方法也可以被重载
     */
    public void main(String s, int i){}

    public void  main(String s) throws Exception {
    }


    /**
     * 方法覆盖 ：子类方法是父类方法不同的实现
     *子类中定义的方法 其名称、返回类型、及参数列表和父类匹配，那么可以说，子类的方法覆盖了父类的方法
     * Note:
     * 1.子类方法不能缩小父类方法的访问权限！ Why?
         * 假设没有这个限制，将会与Java语言的多态机制发生冲突,将Sub类的method方法改为private
         * private void method(){
         *
         * }
         *
         * Base base = new Sub();
         * base.method();
         * 在运行中，根据动态绑定规则，Java虚拟机会调用base变量所引用的Sub实例的method()方法。
         * 如果这个方法为private类型，Java虚拟机就无法访问它，所以为了避免这样的矛盾，Java语言
         * 不允许子类方法缩小父类中被覆盖方法的访问权限。
     * 2. 子类方法不能抛出比父类更多的异常
     *        子类方法抛出的异常必须和父类方法抛出的异常相同，或者子类方法抛出的异常是父类方法抛出的异常类的子类
     *
     */

    public void method() {
        System.out.println("method of sub");
    }

    public int method(int i){
        System.out.println("重载");
        return 0;
    }


    /**
     * 子类可以定义与父类的静态方法同名的静态方法，以便在子类中隐藏父类的静态方法。
     * 在编译时，子类定义的静态方法也必须满足与覆盖方法类似的约束：
     *              1.返回值相同
     *              2.参数列表相同
     *              3.不能缩小父类方法的访问权限
     *              4.不能抛出更多的异常
     */

    /**
     *子类隐藏父类的静态方法和子类覆盖父类方法的区别在于：
     *      运行时，Java虚拟机把静态方法和所属的类绑定
     *      而实例方法和所属的实例绑定
     */
    public static void staticmethod() {
        System.out.println("static method of sub");
    }

    /**
     * 引用变量Sub1和Sub2都是引用Sub类的实例，Java虚拟机在执行sub1.method()和sub2.method()
     * 都调用Sub实例的method()的方法，此时父类Base的实例方法method()被子类覆盖
     *
     * 引用变量sub1被声明为Base类型，Java虚拟机在执行sub1.staticMethod()时，调用Base类的staticMethod()方法
     * 可见父类Base的静态方法staticMethod()不能被子类覆盖
     * 引用变量sub2被声明为Sub类型，Java虚拟机在执行sub2.staticMethod()时，调用Sub类的staticMethod()方法
     * Base类staticMethod()方法被Sub类的staticMethod()方法被隐藏。
     *
     * Note：
     *      父类的非静态方法不能被子类覆盖为静态方法
     *      父类的私有方法不能被子类覆盖
     */
    public static void main(String[] args){

        Base sub1 = new Sub(); // sub1变量被声明为Base类型，引用Sub实例
        sub1.method();         // 打印method of Sub
        sub1.staticmethod();   // 打印static method of Base

        Sub sub2 = new Sub();  // sub2变量被声明为Sub类型，引用Sub实例
        sub2.method();         // 打印method of Sub
        sub2.staticmethod();   // 打印 static method of Sub

    }

}
class Base{

    public void method(){
        System.out.println("method of base");
    }

    static void staticmethod() {
        System.out.println("static method of base");
    }
    


}


