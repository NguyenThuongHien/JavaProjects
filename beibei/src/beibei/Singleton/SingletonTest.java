package beibei.Singleton;

/**
 * Created by sunyinhui on 16-5-24.
 */

/**
 * 单例模式
 * 单例模式根据实例化对象的不同分为两种
 *         1.饿汉式
 *                在单例类被加载时候，就实例化一个对象交给自己的引用
 *         2.懒汉式
 *                在调用取得实例方法的时候才会实例化对象
 *
 */
public class SingletonTest {

}

/**
 * 单例模式有以下几个要素
 *          1. 私有的构造方法
 *          2. 指向自己实例的私有静态引用
 *          3. 以自己实例为返回值的静态的公有的方法
 */

/**
 * 饿汉式
 */
class SingletonHunger{
    private static SingletonHunger singletonHunger = new SingletonHunger();

    private SingletonHunger() {

    }

    public static SingletonHunger getInstance(){
        return singletonHunger;
    }
}

/**
 * 懒汉式
 */
class SingletonLazy{

    private static SingletonLazy singletonLazy = new SingletonLazy();
    private SingletonLazy(){}

    public static synchronized SingletonLazy getInstance(){
        if (singletonLazy == null){
            singletonLazy = new SingletonLazy();
        }
        return singletonLazy;
    }
}


/**
 *
 */