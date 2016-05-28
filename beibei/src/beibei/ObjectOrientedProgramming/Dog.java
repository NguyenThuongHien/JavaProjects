package beibei.ObjectOrientedProgramming;

/**
 * Created by sunyinhui on 16-5-28.
 */

/**
 * 对象的默认引用: this
 * 当一个对象创建好后，Java虚拟机就会给它分配一个引用自身的指针：this。
 * 所有对象默认的引用都名叫this
 *
 */

class Owner{
    private Dog dog;

    public Dog getDog(){
        return dog;
    }

    public void setDog(Dog dog){
        this.dog = dog;
    }
}

public class Dog {
    private Owner owner;

    public Owner getOwner(){
        return owner;
    }

    public void setOwner(Owner owner){
        if(this.owner!=null){          //如果原先就有主人
            this.owner.setDog(null);   //那么取消与原先主人的关联关系
            this.owner = owner;        //建立狗和新主人的关联关系
            owner.setDog(this);        //建立新的主人和狗的关联关系
        }
    }

    public static void main(String[] args){
        Owner oldOwner = new Owner();
        Owner newOwner = new Owner();
        Dog dog = new Dog();

        dog.setOwner(oldOwner);     //建立dog和oldOwner的关联关系
        dog.setOwner(newOwner);     //建立dog和newOwner的关联关系
    }
}


/**
 * 在程序中，在以下情况下会使用this关键字
 * 1. 在类的构造方法中，通过this语句调用这个类的另一个构造方法，
 *    而不能在成员方法中用this语句来调用类的其他构造方法，但可以在成员方法中使用this调用其他非构造函数或变量
 *    Java为了提高代码的可重用性，在一个类的构造方法中，可能会出现一些重复操作
 *    Java语言允许在一个构造方法中，用this语句来调用另一个构造方法
 *    Note:用this语句来调用其他构造方法时，必须遵守以下语法规则
 *         a. 假如在一个构造方法中使用了this语句，那么它必须作为构造方法的第一条语句(不考虑注释语句)
 *         b. 只能在构造方法中用this语句来调用类的其他构造方法，而不能在实例方法中用this语句来调用类的其他构造方法
 *         c. 只能用this语句来调用其他构造方法，而不能通过方法名来直接调用构造方法。
 * 2. 在一个实例方法内，局部变量或参数和实例变量同名，实例变量被屏蔽，因此采用this.owner的方式来指代实例变量
 * 3. 只能在构方法中或实例方法内使用this关键字，而在静态方法和静态代码块内不能使用this关键字。
 *      因为静态方法不需要通过它所属的类的任何实例就会被调用，因此在静态方法中，不能使用this关键字，
 *      也不能直接访问所属类的实例变量和实例方法，但是可以直接访问所属的类的静态变量和静态方法。
 *
 *
 */