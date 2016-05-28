package beibei.ObjectOrientedProgramming;

/**
 * Created by sunyinhui on 16-5-28.
 */

/**
 * this 关键字
 * 成员变量与局部变量同名
 * 访问成员变量，可以通过this关键字来访问，this为当前实例的引用
 */
public class Scope {
    int x; // 成员变量
    int y; //成员变量
    static int z; // z为静态变量

    void method(int x){ // x为方法参数
        int y = 1; //局部变量
        int z = 1; //局部变量

        this.x = x + 1; // this.x为成员变量 x为局部变量
        this.y = y + 1; // this.y为成员变量 y为局部变量
        /**
         * 对静态变量 既可以通过引用变量来访问，也可以通过类名来访问
         * this.z = z + 1;
         */
        Scope.z = z + 1; // Scope.z为成员变量 z为局部变量


        System.out.println("x=" + x);
        System.out.println("y=" + y);
        System.out.println("z=" + z);

        System.out.println("this.x="+ this.x);
        System.out.println("this.y="+ this.y);
        System.out.println("this.z="+ this.z);
        System.out.println("Scope.z="+ Scope.z);

    }

    /**
     * 将局部变量的作用域最小化
     * 如果方法代码很冗长，过早的定义了var变量，会造成一下负面影响
     *  a. 程序的可读性和可维护性差，分散阅读程序的开发人员的注意力，当var变量被使用的时候，
     *     有可能开发人员已经忘记了var变量在哪定义的
     *  b. 增加出错的可能性，var变量有可能在if代码块以外被错误地使用。
     *
     *  为了将局部变量的作用域最小化，应该遵守一下规则
     *     1. 在需要使用某局部变量的时候，才定义它
     *     2. 使方法小而集中。如果一个方法包含多中操作，尽可能把这个方法分解为多个小方法
     *        每个方法负责一项操作，这些小方法在Java源程序中可集中放在一起，方法变小了，局部变量的作用域也就自然变小了
     */
    void method1(){
        int var = 0;
        // 假装很多代码
        // ...
        // ...
        if(var > 0){
            var ++;  //适用var变量
        }

    }


    public static void main(String[] args){
        Scope scope = new Scope();
        scope.method(1);
    }

}