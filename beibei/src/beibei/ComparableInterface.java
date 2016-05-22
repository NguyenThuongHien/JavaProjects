package beibei;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by sunyinhui on 16-5-22.
 */
public class ComparableInterface {

    public static void main(String[] args){
//        Comparable;
//        Integer;
//        Character;
//        String;
//        Date;
        /**
         * 冒泡排序
         */
        String[] arr = {"abcd", "abc", "def", "a"};
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                String temp = arr[0];
                if (arr[i].compareTo(arr[i+1])>=0){
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }

        }

        System.out.println(Arrays.toString(arr));
    }
}
