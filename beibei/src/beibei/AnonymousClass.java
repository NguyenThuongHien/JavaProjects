package beibei;

/**
 * Created by sunyinhui on 16-5-21.
 */

/**
 * 匿名内部类
 */
public class AnonymousClass {

    // static 修饰的方法默认都是final类型的，不能被子类覆盖
    public final static void main(String[] args){
        /**
         * 匿名内部类
         */
        Person p = new Person() {
            @Override
            public void eat() {
                System.out.println("eat someting");
            }
        };
        p.eat();
        /**
         * 在接口上使用匿名内部类
         */
        People pp = new People() {
            @Override
            public void eat() {
                System.out.println("eat somethings -people");
            }
        };
        pp.eat();

        /**
         * Thread类的匿名内部类实现
         */
        Thread t = new Thread(){
                public void run(){
                    for (int i = 1; i <= 5; i++) {
                        System.out.print(i+ " ");
                    }
                }
        };
        t.start();

        /**
         * Runnable 接口的匿名内部类实现
         */
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println();
                for (int i = 1; i <= 5; i++) {
                    System.out.print(i + ",");
                }
            }
        };
        Thread tt = new Thread(r);
        tt.start();
    }

}

abstract class Person{
    public abstract void eat();
}

interface People{
    public void eat();
}

/**
 * 只要一个类是抽象的或是一个接口，那么其子类中的方法都可以使用匿名内部类来实现
 * 最常用的情况就是在多线程的实现上，因为要实现多线程必须继承Thread类或是继承Runnable接口
 */

