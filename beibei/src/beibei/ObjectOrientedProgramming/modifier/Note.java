package beibei.ObjectOrientedProgramming.modifier;

/**
 * Created by sunyinhui on 16-6-5.
 */
public class Note {
    /**
     *
     * 小结  public protected private abstract final static
     *  1. 访问修饰符
     *        public的访问修饰符最高，其次是protected default private
     *        顶层类可以处于public和默认级别，顶层类不能被protected和private修饰
     *        局部变量不能被访问控制符修饰
     *  2. abstract
     *        抽象类不能实例化
     *        抽象类中可以没有抽象方法，但包含了抽象方法的类必须被定义为抽象类
     *        如果子类没有实现父类中所有的抽象方法，子类也必须定义为抽象类
     *        抽象类不能被定义为private, final, static
     *        没有抽象构造方法(因为不能被实例化)
     *        抽象方法没有方法体
     * 3. final
     *        final修饰的类不能被继承
     *        final修饰的方法不能被子类的方法覆盖
     *        private类型的方法都默认是final方法，因而不能被子类的方法覆盖
     *        final变量必须被显式初始化，并且只能被赋一次值
     * 4. static
     *        静态变量在内存中只有一个拷贝，在类的所有实例中共享
     *        在静态方法中不能直接访问实例方法和实例变量
     *        在静态方法中不能使用this和super关键字
     *        静态方法不能被abstract修饰
     *        静态方法和静态变量可以通过类名直接访问
     *        当类被加载时，静态代码块只能被执行一次，类中不同的静态代码块按它们在类中出现的顺序被依次执行
     *
     * 许多修饰符可以连用，顺序可以颠倒
     * 不过，作为普遍遵守的编程规范，通常把访问控制符放在首位，其次是static或abstract,接着是其他修饰符
     *
     * 以下修饰符连用是无意义的，会导致编译错误
     *        abstract 与 private
     *        abstract 与 final
     *        abstract 与 static
     *
     * 成员变量分为静态变量和实例变量
     * 成员方法分为静态方法和实例方法
     *
     *
     *
     *
     *
     */
}
/**
 *
 */
