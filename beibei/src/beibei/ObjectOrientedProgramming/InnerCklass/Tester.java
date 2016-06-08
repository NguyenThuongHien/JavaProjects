package beibei.ObjectOrientedProgramming.InnerCklass;

/**
 * Created by sunyinhui on 16-6-8.
 */
public class Tester {

    public static void main(String[] args){
        Outer o = new Outer();
        o.add(1,2,3);
        /**
         * Tester类是Outer类及其内部类的客户类，如果在要在Tester类中使用InnerTool类，必须引用它的完整类名
         * 如果不希望客户程序访问成员内部类，外部类可以把成员内部类定义为private类型。此时，试图访问内部Outer.InnerTool，会导致编译错误
         */
        Outer.InnerTool tool = new Outer().new InnerTool();
        tool.add(2,3);
    }
}

class Outer{

    /**
     * 成员内部类还可以分为两种，实例内部类和静态内部类，后者用static修饰，
     * 必须保证内部类和外部类不重名。
     */

    public class InnerTool {
        public int add(int a, int b) {
            return a + b;
        }
    }

    /**
     * 在Outer类中，可以直接使用InnerTool类
     * InnerTool类的完整类名为Outer.InnerTool.
     */
    private InnerTool tool = new InnerTool();

    public void add(int a, int b, int c){
        tool.add(tool.add(a,b),c);
    }
}
/**
 * 实例内部类
 * 没有static修饰，实例内部类有以下特点：
 *      1. 在创建实例内部类的实例时，外部类的实例必须已经存在，例如要创建InnerTool实例，必须先创建Outer实例。
 *          Outer.InnerTool tool = new Outer().new InnerTool();
 *        等价于
 *          Outer outer = new Outer()
 *          Outer.InnerTool tool = outer.new InnerTool();
 *      2. 实例内部类的实例自动持有外部类的实例的引用，在内部类中，可以直接访问外部类的所有成员，
 *         包括成员变量和成员方法。
 *         是因为当内部类的实例B存在时，外部类的实例A肯定已经存在，实例B自动持有当前实例A的引用。
 *         在多重嵌套类中，内部类可以访问所有外部类的成员。
 *      3. 外部类实例与内部类实例之间是一对多的关系，一个内部类实例只会引用一个外部类实例，
 *         而一个外部类实例对应零个或多个内部类实例。在外部类中不能直接访问内部类的成员，
 *         必须通过内部类的实例去访问。
 *      4. 在实例内部类中不能定义静态成员、而只能定义实例成员。
 *      5. 如果实例内部类B与内部类A包含同名的成员(比如成员变量v)，那么在类B中，this.v表示类B的成员，
 *         A.this.v表示类A的成员。
 */



