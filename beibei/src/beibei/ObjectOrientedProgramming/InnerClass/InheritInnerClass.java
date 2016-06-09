package beibei.ObjectOrientedProgramming.InnerClass;

/**
 * Created by sunyinhui on 16-6-8.
 */


import beibei.ObjectOrientedProgramming.modifier.Sample;

/**
 * 内部类的继承
 * 外部类InheritInnerClass继承了另一个类Outer的内部类Inner
 * 每个InheritInnerClass实例必须自动用一个Outer实例，当调用一个InheritInnerClass实例的print()方法时，
 * print()方法会访问当前Outer实例的成员变量a
 */
class OuterTest{
    private int a ;
    public OuterTest(int a){
        this.a = a;
    }

    class InnerTest{
        public InnerTest(){

        }
        public void print(){
            System.out.println("a="+a); // 访问外部类的实例变量a
        }
    }

}
public class InheritInnerClass extends OuterTest.InnerTest{
    /**
     *但是通过InheritInnerClass inheritInnerClass = new InheritInnerClass();
     * Java虚拟机就无法决定让InheritInnerClass实例引用哪个Outer实例,
     * 为了避免这种错误，在编译阶段，Java编译器会要求InheritInnerClass类的构造方法必须通过参数传递
     * 一个Outer实例的引用，然后在构造方法中调用super语句来建立InheritInnerClass实例与Outer实例的关联关系。
     */
    public InheritInnerClass(OuterTest o){
        o.super();
    }

    /**
     *通过以上构造方法创建InheritInnerClass实例时，Java虚拟机会使它引用参数指定的Outer实例
     */

    public static void main(String[] args){
        OuterTest outerTest1 = new OuterTest(1);
        OuterTest outerTest2 = new OuterTest(2);

        OuterTest.InnerTest in = outerTest1.new InnerTest();
        in.print();

        /**
         * inheritInnerClass1 与 outerTest1 关联，执行inheritInnerClass1.print()方法时，打印outerTest1实例的变量
         * inheritInnerClass2 与 outerTest2 关联，执行inheritInnerClass2.print()方法时，打印outerTest2实例的变量
         */
        InheritInnerClass inheritInnerClass1 = new InheritInnerClass(outerTest1);
        InheritInnerClass inheritInnerClass2 = new InheritInnerClass(outerTest2);

        inheritInnerClass1.print();
        inheritInnerClass2.print();



    }



}


