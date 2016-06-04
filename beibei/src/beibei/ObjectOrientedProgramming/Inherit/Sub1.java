package beibei.ObjectOrientedProgramming.Inherit;

/**
 * Created by sunyinhui on 16-6-2.
 */

/**
 * 父类的抽象方法可以被子类通过两种途径覆盖
 *      1.子类实现父类的抽象方法
 *      2.子类重新声明父类的抽象方法
 * Note:  不能缩小访问权限
 */
public abstract class Sub1 extends Base1{
    public void method1(){          //实现method1()方法，并且扩大访问权限

    }

    public  abstract void method2(); //重新声明method2()方法，仅仅扩大访问权限，但不实现


}
