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

    private static SingletonLazy singletonLazy ;
    private SingletonLazy(){

    }

    public static synchronized SingletonLazy getInstance(){
        if (singletonLazy == null){
            singletonLazy = new SingletonLazy();
        }
        return singletonLazy;
    }
}


/**
 * 单例模式的优点
 *              1. 在内存中只有一个对象 节省内存空间
 *              2. 避免频繁的创建销毁对象，可以提高性能
 *              3. 避免对共享资源的多重占用
 *              4. 可以全局访问
 */

/**
 * 适用场景
 *              1. 需要频繁实例化然后销毁的对象
 *              2. 创建对象时耗时过多或者消耗过多，但经常用到的对象
 *              3. 频繁访问数据库或文件的对象
 */