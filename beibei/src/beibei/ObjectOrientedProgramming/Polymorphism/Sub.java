package beibei.ObjectOrientedProgramming.Polymorphism;

/**
 * Created by sunyinhui on 16-6-4.
 */


class Base{
    String var = "BaseVar";                         //实例变量
    static String staticVar = "StaticBaseVar";      //静态变量

    void method(){                                  //实例方法
        System.out.println("Base method");
    }

    static void staticMethod(){                     //静态方法
        System.out.println("Static Base method ");
    }

}
public class Sub  extends Base{
    String var = "SubVar";                          //实例变量
    static String staticVar = "StaticSubVar";       //静态变量

    void method(){
        System.out.println("Sub method");           //覆盖父类的method方法
    }

    static void staticMethod(){                     //隐藏父类的staticMethod()方法
        System.out.println("Static Sub method");
    }

    String subVar = "Var only belong to Sub";

    void subMethod(){
        System.out.println("Method only belong to Sub");
    }

    public static void main(String[] args){
        /**
         * who 被声明为Base类型，引用Sub类型
         */
        Base who = new Sub();
        System.out.println("who.var="+who.var);
        System.out.println("who.staticVar="+who.staticVar);
        who.method();
        who.staticMethod();
        /**
         * 对于引用类型变量，Java编译器按照它声明的类型处理
         * who.subVar和who.subMethod()，编译器人为who是Base类型的引用，不存在subVar和subMethod()
         * 如果要访问Sub类的成员，必须通过强制类型转换
         */
       ((Sub)who).subMethod();

        Sub sub = new Sub();
        sub.method();

    }

}

/**
 * 在运行时环境中，通过引用类型变量来访问所引用对象的方法和属性时，Java虚拟机采用一下绑定规则
 * 1. 实例方法与引用变量实际引用的对象的方法绑定，动态绑定，在运行时由Java虚拟机动态决定
 * 2. 静态方法与引用变量所声明的类型的方法绑定， 静态绑定， 在编译阶段就已经绑定
 * 3. 成员变量(包括静态变量和实例变量)与引用变量所声明的类型的成员变量绑定，静态绑定，在编译阶段已经绑定
 */


