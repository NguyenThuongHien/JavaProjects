package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sunyinhui on 16-4-16.
 */
public class ResultList {


    public static void main(String argv[]) throws FileNotFoundException {
        int i = 1;

        Scanner in = new Scanner(new File("/home/sunyinhui/JavaProjects/RetrievalStatistical/src/com/company/retrievalResult1.txt"));
        List<String> resultList = new ArrayList<String>();
            while(in.hasNextLine()) {
                String str = in.nextLine();
                if (String.valueOf(i).equals(str)) {
                    i++;
                    System.out.println(resultList);
                    
                    resultList.clear();
//                    str = in.nextLine();
                }else{
                        resultList.add(str);
//                        str = in.nextLine();
                }

            }




    }
}
