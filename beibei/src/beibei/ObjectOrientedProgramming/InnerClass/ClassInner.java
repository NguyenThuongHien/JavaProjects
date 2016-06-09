package beibei.ObjectOrientedProgramming.InnerClass;

/**
 * Created by sunyinhui on 16-6-10.
 */

/**
 * 内部类的类文件
 *      对于每个内部类来说，Java编译器会生成独立的.class文件。
 *      这些类文件的命名规则如下：
 *             1. 成员内部类：外部类的名字$内部类的名字
 *             2. 局部内部类：外部类的名字$数字$内部类的名字
 *             3. 匿名类：外部类的名字$数字
 */
class AAA {
    static class B {}                  //成员内部类，对应AAA$B.class

    class C {                          //成员内部类 对应AAA$C.class
        class D {}                     //成员内部类 对应AAA$C$D.class
    }

    public void method1() {
        class E {}                   //局部内部类 对应AAA$1$E.class

        B b = new B() {};            //匿名内部类，对应AAA$1.class
        C c = new C() {};            //匿名内部类，对应AAA$2.class
    }

    public void method2(){
        class E{};                  //局部内部类 对应AAA$2$E.class
    }

    public static void main(String[] args){

    }
}
public class ClassInner {

}


