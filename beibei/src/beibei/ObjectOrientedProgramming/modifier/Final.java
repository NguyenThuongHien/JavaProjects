package beibei.ObjectOrientedProgramming.modifier;

/**
 * Created by sunyinhui on 16-6-5.
 */

/**
 * 类的成员变量分为两种：一种是static修饰的变量，叫类变量或静态变量
 *                   另一种是没有被static修饰的变量，叫实例变量
 * final修饰实例变量，可以在定义变量时，或者在构造方法中进行初始化
 * 对于final类型的静态变量，只能在定义变量时进行初始化
 */

/**
 * 静态变量在内存中只有一个拷贝，可以直接通过类名访问静态变量
 * 实例变量在创建每个实例，就会为实例变量分配一次内存，实例变量在内存中有对个拷贝
 *
 * 在类的内部可以在任何方法内直接访问静态变量；在其他类中，可以通过某个类的类名来访问它的静态变量
 *
 */
public class Final {
    static final int a=0;   //静态变量
    final int b;            //实例变量

    public Final() {
        b =0;
    }

    public Final(int x){
        b=x;
    }

    public static void main(String[] args){
        final Final f = new Final();
//        f = new Final(7);
        /**
         * 如果将引用类型用final修饰，那么变量只能始终引用一个对象。
         */
    }
}
