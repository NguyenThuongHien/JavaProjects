package beibei.ObjectOrientedProgramming.InnerClass;

/**
 * Created by sunyinhui on 16-6-8.
 */

/**
 * 内部类
 * 在一个类的内部定义的类称为内部类，内部类允许把一些逻辑相关的类组织在一起，并且控制内部类代码的可视性
 * 把外层的类称为顶层类，把内部类所在的类称为外部类
 * 顶层类只能处于public和default访问级别，而成员内部类可以处于public protected private default
 *
 */
public class InnerClass {


    public static void main(String[] args){

        Tool tool = new Out().getTool(); // InnerTool实例向上转型为Tool类型
    }

}

/**
 *内部类的用途
 *      1. 封装类型
 *      2. 直接访问外部类的成员
 *      3. 回调外部类的方法
 */

/**
 * 1. 封装类型
 *     private 类型的InnerTool内部类实现了公共的Tool接口
 *     在客户类中不能访问Out.InnerTool类，但是可以通过Out类的getTool()方法获得InnerTool的实例
 */
interface Tool{
    public int add(int a, int b);
}

class Out{
    private class InnerTool implements  Tool{

        @Override
        public int add(int a, int b) {
            return a+b;
        }
    }
    public Tool getTool(){
        return new InnerTool();
    }
}
/**
 * 2 直接访问外部类的成员
 *      当类C作为类A的实例内部类时，可以直接访问类A的count属性
 *      Java虚拟机会保证类C的实例持有类B的实例的引用，因此无须显式地建立类C与类B的关联。
 */
class B{
    private int count;
    public int add(){
        return ++count;
    }

    class C{
        public void reset(){
            if (count>0){
                count =1;
            }else{
                count-=1;
            }
        }
    }
}

/**
 * 3 回调CallBack
 *      Adjustable接口和Base类中都定义了adjust()方法，这两个方法的签名相同，但是有不同的功能
 */

interface  Adjustable{
    /**调节温度*/
    public void adjust(int temperature);

}

class Base{
    private int speed;
    /**调节速度*/
    public void adjust(int speed){
        this.speed = speed;
    }
}
/**
 * 如果一个Sub类同时具有调节温度和速度的功能，那么Sub类需要继承Base，并且实现Adjustable接口
 * 但以下代码并不能满足这一需求
 */

class Sub extends Base implements Adjustable{
    private int temperature;
    public void adjust(int temperature){
        this.temperature = temperature;
    }
}
/**
 * 以上Sub类实现了Adjustable接口中的adjust()方法，并且把Base类中的adjust()方法覆盖了
 * 这意味者Sub类仅仅有调节温度的功能，但失去了调节速度的功能
 * 可以用内部类来解决
 */

class Sub1 extends Base{
    private int temperature;
    private void adjustTemperature(int temperature){
        this.temperature = temperature;
    }

    private class Closure implements Adjustable{

        @Override
        public void adjust(int temperature) {
            adjustTemperature(temperature);
        }
    }

    public Adjustable getCallBackReference(){
        return new Closure();
    }
}






























