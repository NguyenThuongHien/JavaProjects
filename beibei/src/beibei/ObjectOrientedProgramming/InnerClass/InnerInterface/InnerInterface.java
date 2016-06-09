package beibei.ObjectOrientedProgramming.InnerClass.InnerInterface;

/**
 * Created by sunyinhui on 16-6-9.
 */

/**
 * 在一个，类中也可以定义内部接口
 *
 */
public class InnerInterface {
    /**
     * 静态内部接口
     */
    public static interface Tool{
        public int add(int a, int b);
    }
}


/**
 * 接口中的内部类
 *      在接口中可以定义静态内部类，此时静态内部类位于接口的命令空间中
 */

interface A{
    static class B{
        public void method(B b){
        }
    }
}

class C implements A{
    /**
     * 类C实现了接口A,类B的名字对类C是可见的
     * 但在D中，必须通过A.B的形式使用类B
     */
    B b = new B();
    public void method(B b){

    }
}

class D{

      A.B b1 = new A.B(); // 合法
//    B b2 = new B();     // 编译错误

}

