package com.company;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sunyinhui on 16-4-16.
 */
public class Compute {
    List<String> list;
    static int top5 = 0;

   static int  computer(List<String> list){
        String targetImage = list.get(0);
        targetImage = targetImage.substring(2,8);
        System.out.println(targetImage);
        int num=0;
        for(int j=0; j<list.size();j++){
            String resultStr = list.get(j);
            resultStr = resultStr.substring(2,8);
            System.out.println(resultStr);
        }

       return top5;

    }

    public static void main(String argv[]){
        List<String> list = Arrays.asList("./batch1/1.jpg, ./batch4/76.jpg, ./batch2/23.jpg, ./batch2/15.jpg, ./batch4/79.jpg, ./batch4/21.jpg");
        computer(list);
    }


}
