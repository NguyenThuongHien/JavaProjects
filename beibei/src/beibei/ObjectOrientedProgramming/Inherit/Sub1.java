package beibei.ObjectOrientedProgramming.Inherit;

/**
 * Created by sunyinhui on 16-6-2.
 */

/**
 * 父类的抽象方法可以被子类通过两种途径覆盖
 *      1.子类实现父类的抽象方法
 *      2.子类重新声明父类的抽象方法
 * Note:  不能缩小访问权限
 */
public abstract class Sub1 extends Base1{
    public void method1(){          //实现method1()方法，并且扩大访问权限

    }

    public  abstract void method2(); //重新声明method2()方法，仅仅扩大访问权限，但不实现


}

/**
 * Note:
 *      0.没有抽象构造方法，也没有抽象静态方法
 *      1.可以有非抽象的构造方法，创建子类的实例可能会调用这些构造方法
 *      2.抽象类中可以没有抽象方法，但包含了抽象方法的类必须被定义为抽象类
 *      3.如果子类没有实现父类中所有的抽象方法，那么子类也必须被定义为抽象类
 *      4.抽象类不能被实例化，然而可以创建一个引用变量，其类型是一个抽象类，并让它引用非抽象的子类的一个实例
 *      5.抽象类及抽象方法不能被final修饰符修饰。abstract与final不能连用。
 *        因为抽象类只能允许创建其子类，它的抽象方法才能实现，并且只有它的具体子类才能被实例化
 *        而final修饰的类不能拥有子类，用final修饰的方法不允许被子类覆盖，abstract和final连用，会导致自相矛盾
 *        抽象类就是让其他类继承的，而final是不让继承，是矛盾的
 *
 *
 */
