package beibei;

/**
 * Created by sunyinhui on 16-5-22.
 */

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

/**
 *            HashMap                           HashTable
 *            线程安全                           线程不安全
 *      键最多为一个null,值可以为多个null     键和值都不能为null
 *          父类AbstractMap                     Dictionary
 */

public class HashMapTest {
    public static void main(String[] args){
        Hashtable talbe = new Hashtable();
        Properties pro = new Properties();
        HashMap map = new HashMap();

    }
}


/**
 * 引用分类：目的是避免对象长期驻留在内存，解决垃圾回收机制时机问题
 * 强引用StrongReference引用指向对象，gc运行时不回收
 * 软引用SoftReference gc运行时立即回收
 * 虚引用PhantomReference类似于无引用 主要跟踪对象被回收的状态
 * 不能单独使用，必须与引用队列ReferenceQueue联合使用
 */
