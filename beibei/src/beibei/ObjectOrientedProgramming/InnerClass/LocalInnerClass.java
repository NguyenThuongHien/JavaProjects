package beibei.ObjectOrientedProgramming.InnerClass;

/**
 * Created by sunyinhui on 16-6-8.
 */

/**
 * 局部内部类
 *     局部内部类是在一个方法中定义内部类，它的可见范围是当前方法
 *     和局部变量一样，局部内部类不能用访问控制修饰符private protected public static 修饰
 *     局部内部类有以下特点：
 *          1. 局部内部类只能在当前方法中使用。
 *          2. 不能包含静态成员
 *          3. 局部内部类和实例内部类一样，可以访问外部类的所有成员。
 *             此外，局部内部类还可以访问所在方法中的final类型的参数和变量。
 */
public class LocalInnerClass {

}

class AA{

//     BB b = new BB(); // 1. 局部内部类只能在当前方法中使用

    /**
     * 在类B中有一个实例内部类C,在method()方法中可以访问类B和类C，但在method()方法以外就不能访问类B及它的成员
     */
    public void method(){
        class BB{
            int v1;
            int v2;
//          static int v3; // 2. 不能包含静态成员， 局部内部类和实例内一样，不能包含静态成员

            class CC{
                int v3;
            }
        }

        BB b = new BB();
        BB.CC c = b.new CC();
    }
}