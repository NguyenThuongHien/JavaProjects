package beibei.ObjectOrientedProgramming.modifier;

/**
 * Created by sunyinhui on 16-6-5.
 */

/**
 * final修饰成员变量，可以在定义变量时，或者在构造方法中进行初始化
 * 对于final类型的静态变量，只能在定义变量时进行初始化
 */
public class Final {
    static final int a=0;
    final int b;

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
