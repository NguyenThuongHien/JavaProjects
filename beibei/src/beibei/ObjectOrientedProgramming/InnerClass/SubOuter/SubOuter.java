package beibei.ObjectOrientedProgramming.InnerClass.SubOuter;

/**
 * Created by sunyinhui on 16-6-9.
 */

/**
 * 子类与父类中的内部类同名
 *      内部类并不存在覆盖的概念，假如子类与父类中存在同名的内部类，那么这两个内部类也会分别在不同的命名空间中
 *      因此不会发生冲突
 */

/**
 *在Outer类和SubOuter子类中都有一个实例内部类Inner,这两个内部类的完整名字分别为
 * Outer.Inner 和 SubInner.Inner，它们是独立的两个类，不存在覆盖关系。
 * Java编译器不会检查子类中的Inner类是否缩小了父类的Inner类的访问权限。
 */

class Outer{
    Inner in;
    Outer(){
        in = new Inner();
    }

    public class Inner{         // public
        public Inner(){
            System.out.println("inner of Outer");
        }
    }
}


public class SubOuter extends Outer{
    class Inner{
        public Inner(){        // 默认访问级别
            System.out.println("inner of SubOuter");
        }
    }

    public static void main(String[] args){
        SubOuter.Inner in1 = new SubOuter().new Inner();
        Outer.Inner    in2 = new Outer().new Inner();
    }
}
