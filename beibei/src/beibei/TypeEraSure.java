package beibei;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * Created by sunyinhui on 16-5-21.
 */
public class TypeEraSure {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        ArrayList<String> arrayList1 = new ArrayList<String>();
        arrayList1.add("abc");

        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        arrayList2.add(123);

        System.out.println(arrayList1.getClass() == arrayList2.getClass());

        ArrayList<Integer> arrayList3 = new ArrayList<Integer>();
        arrayList3.add(1);

        //反射
        //ArrayList<Integer>被类型擦除类型后，原始类型也变成了Object,所以通过反射我们就可以存储字符串了
        arrayList3.getClass().getMethod("add",Object.class).invoke(arrayList3,"asd");

        for (int i = 0; i <arrayList3.size() ; i++) {
            System.out.println(arrayList3.get(i));
        }

        //Java编译器是通过先检查代码中的泛型的类型，然后载进行类型擦除，再进行编译的
        //在编译前检查
        //

        ArrayList<String> arrayList4 = new ArrayList<>();
        arrayList4.add("1");
//        arrayList4.add(1);   //编译错误


        //类型检查是针对引用的，谁是一个引用，用这个引用调用泛型方法
        //就会对这个引用调用的方法进行类型检查，而无关它真正引用的对象
        //new ArrayList<String>() 只是在内存中开辟一个存储空间，可以存储任何的类型对象
        ArrayList arrayList5 = new ArrayList<String>();
        arrayList5.add("1");
        arrayList5.add(1);

        //泛型中参数化类型不考虑继承关系
//        ArrayList<String> list1 = new ArrayList<Object>();  //编译错误
//        ArrayList<Object> list1 = new ArrayList<String>();  //编译错误
        //Java泛型中不考虑泛型的引用传递问题


    }


}


/**
 * java中的泛型基本上都是在编译器这个层次来实现的
 * 在生成的java字节码中是不包含泛型中的类型信息的
 * 使用泛型的时候加上的类型参数，会在编译器在编译的时候去掉，称为类型擦除
 */

// T 是一个无限定的类型变量，所以用Object替换
class Pair2<T>{
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
