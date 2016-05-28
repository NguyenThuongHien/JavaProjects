package beibei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sunyinhui on 16-5-22.
 */
public class ComparatorInterface {

    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("abcd");
        list.add("abc");
        list.add("def");
        list.add("a");
        System.out.println(list);
//        Collections.sort(list,new StringComp());  //业务类StringComp实现comparator接口
        Collections.sort(list);                     //实体类实现comparable接口
        System.out.println(list);

    }


    private static class StringComp implements java.util.Comparator<String> {


        @Override
        public int compare(String s, String t1) {
            return s.compareTo(t1);
        }
    }
}
