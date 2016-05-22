package beibei;

import java.util.List;
import java.util.*;

/**
 * Created by sunyinhui on 16-5-21.
 */
public class CollectionTest {

    public static void main(String[] args){
        List list = new ArrayList();
        LinkedList linkedList = new LinkedList();
        List listtest = Collections.synchronizedList(new LinkedList());

//      System.out.println(List.class.getCanonicalName());

        Vector vector = new Vector();
        vector.size();
        vector.capacity();

        Stack stack = new Stack();
        stack.iterator();


        Map map = new HashMap();
        map.entrySet();
        //类型参数:E ArrayList<E>
        //类型参数的实例：Sting ArrayList<String>
        ArrayList<String> arrayList = new ArrayList<String>();

        arrayList.add("asa");
        //因为知道取出来的值的类型，所以不需要进行强制类型转换
        String str = arrayList.get(0);



    }



}
