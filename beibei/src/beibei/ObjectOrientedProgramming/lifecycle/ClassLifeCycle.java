package beibei.ObjectOrientedProgramming.lifecycle;

/**
 * Created by sunyinhui on 16-6-7.
 */

/**
 * 类的生命周期
 * 类的生命周期从被加载、连接、和初始化开始，到类被卸载结束
 * 当类处于生命周期中时，它的二进制数据位于方法区内，在堆内还会有一个相应的描述这个类的Class对象
 */

/**
 * 当通过java命令运行一个java程序时，就启动了一个Java虚拟机进程。Java虚拟机进程从启动到终止的过程
 * 称为Java虚拟机的生命周期，当Java虚拟机处于生命周期中，它的总任务就是运行java程序。
 * Java程序从开始运行到终止的过程称为程序的生命周期，它和java虚拟机的生命周期是一致的
 * 在以下情况，java虚拟机将结束生命周期
 *      1.程序正常执行结束
 *      2.执行中出现异常或错误而异常终止
 *      3.执行了System.exit()方法
 *      4.由于操作系统出现错误而导致java虚拟机进程终止
 */

/**
 * 类的加载、连接和初始化
 * 当java程序需要使用某个类时，Java虚拟机会确保这个类已经被加载，连接和初始化。
 * 其中连接过程又包括验证、准备和解析这三个子步骤
 *  1 加载：查找并加载类的二进制数据
 *  2.连接：包括验证、准备和解析类的二进制数据
 *          验证：确保被加载的类的正确性
 *          准备：为类的静态变量分配内存，并将其初始化为默认值
 *          解析：把类中的符号引用转换为直接引用
 *  3.初始化：给类的静态变量赋予正确的初始值
 *
 *
 */


/**
 * 类的加载
 * 类的加载是把类的.class文件中的二进制数据读入到内存中，把它存放在运行时数据区的方法区内，
 * 然后在堆区创建一个java.lang.Class对象，用来封装在方法区内的数据结构
 *
 * 类加载器并不需要等到某个类被首次主动使用时再加载它，Java虚拟机规范允许类加载器在预料某个类将要被使用时就预先加载它
 * 如果在预先加载类过程中遇到.class文件缺失或存在错误，类加载器必须等到程序首次使用该类时才报告错误
 * 如果这个类一直没有被程序主动使用，那么类加载器将不会报错
 */

/**
 * 类的验证
 * 当类被加载后，就进入连接阶段。连接就是把已经读入到内存的类的二进制数据合并到虚拟机的运行时环境中去，
 * 连接的第一步是类的验证，保证被加载的类有正确的内部结构，并且与其他类协调一致，如果Java虚拟机检查到错误，那么就会抛出响应的Error对象
 * 类的验证主要包括以下内容：
 *      1. 类文件的结构检查：确保类文件遵从Java类文件的固定格式
 *      2. 语义检查：确保类本身符合Java语言的语法规定，比如验证final类型的类没有子类
 *      3. 字节码验证：字节码代表了Java方法(静态方法和实例方法)，它是由被称做操作符的单字节指令组成的序列
 *      4. 二进制兼容的验证：确保相互引用的类之间协调一致
 */

/**
 * 类的准备
 * 在准备阶段，Java虚拟机为类的静态变量分配内存，并设置默认的初始值
 */

/**
 * 类的解析
 * 在解析阶段，Java虚拟机会把类的二进制数据中的符号引用替换为直接引用
 * 在类A的二进制数据中，包含了类B的方法的符号引用，有方法的全名和相关描述符组成
 * 在解析阶段，Java虚拟机会把这个符号引用替换为一个指针，该指针指向类B的方法在方法区的内存位置
 * 这个指针就是直接引用
 */

/**
 *
 */
public class ClassLifeCycle {

}










































