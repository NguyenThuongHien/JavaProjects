package beibei.ObjectOrientedProgramming;

/**
 * Created by sunyinhui on 16-5-28.
 */

/**
 * 如果方法A调用方法B，那么称方法A是方法B的调用者。
 * 如果方法B的参数是基本数据类型，那么方法A向方法B传递参数的值
 * 如果方法B的参数是对象或数组，那么方法A向方法B传递对象或数组的引用。
 */
public class ParamTester {

    public int memberVariable = 0;  //成员变量

    public static void main(String[] args){
        //声明并初始化4个局部变量
        int param1 = 0;                         //param1 是基本数据类型
        ParamTester param2 = new ParamTester(); //param2 是对象引用类型
        ParamTester param3 = new ParamTester(); //param3 是对象引用类型
        int[] param4 = {0};                     //param4 是数组引用类型

        //将4个局部变量作为参数传递给changeParamter()方法
        chageParamter(param1, param2, param3, param4);


        //打印4个局部变量
        System.out.println("paramter1="+ param1);
        System.out.println("paramter2.memberVariable="+ param2.memberVariable);
        System.out.println("paramter3.memberVariable="+ param3.memberVariable);
        System.out.println("paramter4.memberVariable="+ param4[0]);
    }

    /**
     * 实参和形参
     * 实参向形参的数据传递是“值传递”，单向传递，只有实参传给形参，而不能由形参传回来给实参。
     * 在调用函数时，给形参分配存储单元，并将实参对应的数值传递给形参，调用结束后，形参单元被释放
     * 实参单元仍保留并维持原值。
     * 因此，形参的值如果发生改变，并不会改变主调函数的实参的值。
     *
     * 如果希望通过函数调用使主调用函数能得到一个确定的值，可以通过函数的返回值获得。
     * 函数的返回值是通过函数中的return语句获得，return语句将调用函数中的一个确定值带到主调函数中去。如changeParamter1()
     *
     */
    private static void chageParamter(int param1, ParamTester param2, ParamTester param3, int[] param4) {
        param1 = 1 ;                    // 改变基本数据类型参数的值
        param2.memberVariable = 1 ;     // 改变对象类型参数的实例变量
        param3 = new ParamTester();     // 改变对象类型参数的引用，使它引用一个新的对象
        param3.memberVariable = 1 ;     // 改变新的对象的实例变量
        param4[0] = 1;                  // 改变数组类型参数的元素

    }

    private static int  chageParamter1(int param1, ParamTester param2, ParamTester param3, int[] param4) {
        param1 = 1 ;                    // 改变基本数据类型参数的值
        param2.memberVariable = 1 ;     // 改变对象类型参数的实例变量
        param3 = new ParamTester();     // 改变对象类型参数的引用，使它引用一个新的对象
        param3.memberVariable = 1 ;     // 改变新的对象的实例变量
        param4[0] = 1;                  // 改变数组类型参数的元素
        return param1;

    }


}
