package beibei;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by sunyinhui on 16-5-21.
 */
public class GenericClass {

    public static void main(String[] args){

        ShowTest showTest = new ShowTest();
        showTest.show("hello",new Date());

    }

    // 泛型方法
    public  static <T,U>T  get(T t, U u){
        if(u!=null)
            return t;
        else
            return null;
    }

    // 添加类型限定
    //注意 不管该限定是类还是接口 统一都使用关键字extends
    //     使用&符号给出多个限定
    //     如果限定有类也有接口 那么类必须只有一个 并且放在首位置
    public static <T extends Comparable & Serializable> T get(T t1,T t2) {
        if ( t1.compareTo(t2)>=0 );
            return t1;
    }


}

//定义泛型类
class Pair<T>{

    private T value;

    public Pair(T value){
//        this.value = value;
        setValue();
    }


    public T getValue(){
        return value;
    }

    public void setValue(){
        this.value = value;
    }

}

//泛型接口

interface Show<T,U>{
    void show(T t, U u);
}

class ShowTest implements Show<String,Date>{

    @Override
    public void show(String str, Date date) {
        System.out.println(str);
        System.out.println(date);
    }
}



