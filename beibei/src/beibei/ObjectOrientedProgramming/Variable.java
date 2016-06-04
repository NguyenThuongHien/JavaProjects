package beibei.ObjectOrientedProgramming;

/**
 * Created by sunyinhui on 16-6-1.
 */

/**
 * 变量用于表示现实系统的某种数据
 * 先定义，再初始化，然后使用
 * 初始化是指自从变量定义以后，首次给它赋初始值的过程
 */

/**
 * 对于成员变量初始化，不管程序有没有显式地进行初始化，Java虚拟机都会自动给它初始化为默认值。
 * 整型(byte short int long) : 0
 * 单精度float : 0.0f
 * 双精度double : 0.0d
 * 字符char : '\u0000'
 * boolean : false
 * 引用类型 ： null
 * 数组引用类型的变量的默认值为null。
 */

/**
 * Note 数组在Java中是一个对象，数组实例同样是使用new操作符创建的
 */
public class Variable {

    static boolean booleanVar;
    static String stringVar;
    Doll dollVar;
    int intVar;
    char charVar = '*';
    int[] numbers ;

    public static void main(String[] args){

        Variable var = new Variable();
        System.out.println(booleanVar);
        System.out.println(stringVar);
        System.out.println(var.dollVar);
        System.out.println(var.intVar);
        System.out.println(var.charVar);
        System.out.println(var.numbers);

    }

    /**
     * 局部变量的初始化
     * 局部变量声明之后，Java虚拟机就不会自动给它初始化
     * 因此，对于局部变量，必须先经过显式初始化，才能使用。
     * 如果编译器确认一个局部变量在使用之前没有被初始化，编译器将报错。
     * 如果局部变量没有被初始化，并且在方法中一直没有被使用，则编译和运行都会通过。
     */

    /**
     * 为什么Java虚拟机会自动初始化类的成员变量，却要求局部变量必须被显式初始化？
     * 这是因为对于局部变量，很有可能是程序员的疏忽，忘了初始化局部变量，Java编译器在编译阶段强制要求
     * 程序员给局部变量赋初始值，可避免潜在的错误。
     */

    /**
     * 而对于成员变量，Java语言提供了多种初始化的途径，即可在声明时初始化，也可在构造方法中初始化
     * 还可在静态代码块中初始化，假设成员变量的初始值与该类数据类型的默认值不符，程序员一般总会在构造方法中显式初始化
     * 忘记初始化成员变量的错误并不多。假设程序员没有显式初始化成员变量，Java语言则认为这些变量的初始值刚好
     * 和该数据类型的默认值相同，因此提供自动初始化的功能，以简化编程。
     */
//    void test(){
//        Variable var;
//        int a ;
//        System.out.println(a);
//        System.out.println(var.numbers);
//    }
    /**
     * 那么， 加了修饰符的Java成员变量是如何初始化的呢？
     */






}

class Doll{

}

/**
 *
 */
