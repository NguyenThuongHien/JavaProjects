package beibei.ObjectOrientedProgramming.InnerClass.AnonymousClass;

/**
 * Created by sunyinhui on 16-6-9.
 */

/**
 * 匿名类是一种特殊的内部类，这种类没有名字
 *
 */
public class AnonymousClass {
    AnonymousClass(int v){
        System.out.println("another constructor");
    }

    AnonymousClass(){
        System.out.println("default constructor");
    }

    void method(){
        System.out.println("method A");
    }

    public static void main(String[] args){
        new AnonymousClass().method();

        /**
         * 返回匿名类实例的引用
         */
        AnonymousClass anonymousClass = new AnonymousClass(){
          void method(){
              System.out.println("method AnonymousClass");
          }
        };
        anonymousClass.method();

        /**
         * 等价于以下代码：
         //        class SubA extends AnonymousClass{
         //            void method(){
         //                System.out.println("method AnonymousClass");
         //            }
         //        }
         //
         //        AnonymousClass anonymousClass = new SubA();
         //        anonymousClass.method();

         */

        /**
         * 匿名类本身没有构造方法，但是会调用父类的构造方法。例如如下匿名类会调用父类AnonymousClass的
         * AnonymousClass(int v)的构造方法。
         */
        int v = 1;
//        final int v = 1;
        AnonymousClass a = new AnonymousClass(v){
            {
                System.out.println("initialize instance"); //实例初始化代码
            }
          void method(){
              System.out.println("from AnonymousClass");
              /**
               * 局部内部类访问所在方法中的final类型的参数和变量。
               */
//            System.out.println("from AnonymousClass:"+v);
          }
        };

        a.method();


    }
}
/**
 * 匿名类有以下特点：  在main方法中的局部内部类
 *      1. 匿名内部类本身没有构造方法，但是会调用父类的构造方法。
 *      2. 如果参数v是局部变量，并且在匿名类的类体中使用它，那么v必须是final类型的，否则导致编译错误。
 *      3. 匿名类尽管没有构造方法，但是可以在匿名类中提供一段实例初始化代码，Java虚拟机会调用父类的构造方法后，
 *         执行这段代码
 *      4. 匿名类除了可以继承类以外，还可以实现接口
 *      5. 匿名类和局部内部类一样，可以访问外部类的所有成员，如果匿名类位于一个方法中，还能访问所在方法的final类型的变量和参数
 *      6. 局部内部类的名字在方法外是不可见的，因此与匿名类一样，能够起到封装类型名字的作用。
 *
 * 局部内部类与匿名类有以下区别：
 *      1. 匿名类的程序代码比较简短
 *      2. 一个局部内部类可以有多个重载构造方法，并且客户类可以多次创建局部内部类的实例。
 *
 *  因此：如果只需要创建内部类的一个实例，那么可以使用匿名类，它能使程序代码比较简介，如果需要多次创建内部类的实例，那么用局部内部类
 *
 *
 */


class Sample{
    public static void main(String[] args){

        /**
         * 匿名类除了可以继承类以外，还可以实现接口
         * 以下匿名类实现了java.lang.Runnable接口，把这个匿名类的实例的引用作为参数，
         * 传给java.lang.Thread类的构造方法。
         */
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0 ; i < 100 ; i++){
                    System.out.println(i);
                }
            }
        });

        t.start();


        /**
         * 等价于：
         * Runnable r = new Runnable(){
         *      public void run(){
         *          for(int i=0; i < 100 ; i++){
         *              System.out.println(i);
         *          }
         *      }
         * }
         * Thread t = new Thread(r);
         * t.start();
         */
    }
}