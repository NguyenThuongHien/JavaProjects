package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sunyinhui on 16-4-16.
 */
public class ScanTest {


    public static void main(String argv[]) throws FileNotFoundException {
        int i = 1;
        double sum = 0d;
//      String filePath= "/home/sunyinhui/JavaProjects/RetrievalStatistical/src/com/company/retrievalResult.txt";
        String filePath= "/media/sunyinhui/文档/毕业相关/adapt_apV3_0415/ReusltRetrievalPHOG.txt";

        Scanner in = new Scanner(new File(filePath));
        List<String> resultList = new ArrayList<String>();
            while(in.hasNextLine()) {
                String str = in.nextLine();
                if (String.valueOf(i).equals(str)) {
                    i++;
                    System.out.println(resultList);
                    int num = 0;
                    for(int j=1;j<resultList.size();j++){
                        String targetImage = resultList.get(0);
                        targetImage = targetImage.substring(2,8);
                        String resultStr = resultList.get(j);
                        resultStr = resultStr.substring(2,8);
                        if(resultStr.equals(targetImage)){
                            num++;
                        }
                    }
                 //   System.out.println((float) num / (float) (resultList.size() - 1));
                    sum += (float) num / (float) (resultList.size() - 1);
                    System.out.println(sum);
                    resultList.clear();
                }else{
                        resultList.add(str);
                }

            }




    }
}
