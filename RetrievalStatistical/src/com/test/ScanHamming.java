package com.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by sunyinhui
 */
public class ScanHamming {


    public static void main(String argv[]) throws FileNotFoundException {
        int i = 1;
        double sum = 0d;
//      String filePath= "/home/sunyinhui/JavaProjects/RetrievalStatistical/src/com/company/retrievalResult.txt";
        String filePath= "/home/sunyinhui/git/adapt_apV3_0414/ResultHamming.txt";
        Map<Integer,Double> numSum = new HashMap<Integer,Double>();
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
                    System.out.println((float) num / (float) (resultList.size() - 1));
                    sum += (float) num / (float) (resultList.size() - 1);
                    System.out.println(i + ": " + sum);
                    if(i ==42){
                        numSum.put(i,sum);   // 3
                    }else if(i == 58){
                        numSum.put(i,sum);   // 1
                    }else if(i == 141){
                        numSum.put(i,sum);   // 4
                    }else if (i == 187){
                        numSum.put(i,sum);   // 2
                    }


//                    System.out.println(sum);
                    resultList.clear();
                }else{
                        resultList.add(str);
                }

            }


        System.out.println(numSum.get(42));
        System.out.println(numSum.get(58));
        System.out.println(numSum.get(141));
        System.out.println(numSum.get(187));

        System.out.println(numSum.get(42)/42);
        System.out.println((numSum.get(58)-numSum.get(42))/16);
        System.out.println((numSum.get(141)-numSum.get(58))/83);
        System.out.println((numSum.get(187)-numSum.get(141))/46);

//        System.out.println(((numSum.get(42)/42)+((numSum.get(58)-numSum.get(42))/16)+((numSum.get(141)-numSum.get(58))/83)
//                            + ((numSum.get(187)-numSum.get(141))/46))/4);



    }
}
