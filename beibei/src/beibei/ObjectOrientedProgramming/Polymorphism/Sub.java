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

    public static void main(String[] args){
        /**
         * who 被声明为Base类型，引用Sub类型
         */
        Base who = new Sub();
        System.out.println("who.var="+who.var);
        System.out.println("who.staticVar="+who.staticVar);
        who.method();
        who.staticMethod();
    }

}


