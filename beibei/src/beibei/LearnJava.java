package beibei;

/**
 * Created by sunyinhui on 16-5-17.
 */
public class LearnJava {
        public static void main(String[] args){
        //
            objPoolTest();
    }

    private static void objPoolTest() {
        int i = 40;
        int i0 = 40;
        Integer i1 = 40;  //引用类型
        Integer i2 = 40;
        Integer i3 = 0;
        Integer i4 = new Integer(40);
        Integer i5 = new Integer(40);
        Integer i6 = new Integer(0);
        Double d1=1.0;
        Double d2=1.0;
        //普通变量 数据直接存储在栈中，栈中的数据可以共享
        System.out.println("i=i0\t" + (i == i0));
        //引用类型 在栈中存储指针 因为Integer是包装类 由于Integer包装类实现了常量池技术
        //因此 i1 i2的40均是从常量池中获取的 均指向同一个地址
        System.out.println("i1=i2\t" + (i1 == i2));
        //java运算都是在栈中进行的 对i1 i2进行拆箱操作
        System.out.println("i1=i2+i3\t" + (i1 == i2 + i3));
        //i4 i5均是应用类型，在栈中存储指针，因为Integer是包装类 但是由于它们是new出来的
        //因此 不在常量池中取值 而是从堆里各自new一个对象 然后各自保存指向对象的指针
        //所以i4 i5不相等 因为它们所存指针不同 所指对象不同
        System.out.println("i4=i5\t" + (i4 == i5));
        System.out.println("i4=i5+i6\t" + (i4 == i5 + i6));
        // 加法运算 同3
        System.out.println("d1=d2\t" + (d1==d2));
        //d1 d2均是引用类型 在栈中存储指针 因为Double是包装类 但Double包装类没有实现常量池技术
        //因此 Double d1 = 1.0 相当于Double d1 = new Double(1.0)
        System.out.println();
    }
}

// String Byte、Short、Character、Integer、Long、Boolean 实现了常量池技术
// Double Float 没有实现常量池技术
//以上提到的几种基本类型包装类均实现了常量池技术,但他们维护的常量仅仅是【-128
//至 127】这个范围内的常量,如果常量值超过这个范围,就会从堆中创建对象,不再从常
//量池中取。比如,把上边例子改成 Integer i1 = 400; Integer i2 = 400;,很明显超过了
//127,无法从常量池获取常量,就要从堆中 new 新的 Integer 对象,这时 i1 和 i2 就不相等了。
//String 类型也实现了常量池技术,但是稍微有点不同。String 型是先检测常量池中有没
//有对应字符串,如果有,则取出来;如果没有,则把当前的添加进去。
