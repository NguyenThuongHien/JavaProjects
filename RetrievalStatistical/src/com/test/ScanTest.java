package com.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by sunyinhui
 */
public class ScanTest {


    public static void main(String argv[]) throws FileNotFoundException {
        int i = 1;
        double sum = 0d;
        int k=0;
        int l=0;
        int m=0;
        int n=0;
//      String filePath= "/home/sunyinhui/JavaProjects/RetrievalStatistical/src/com/company/retrievalResult.txt";
        String filePath= "/home/sunyinhui/git/adapt_apV3_0415/ResultRetrievalAPTamura.txt";
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
                    float rate = (float) num / (float)(resultList.size()-1);
//                    System.out.println((float) num / (float) (resultList.size() - 1));
                    System.out.println(rate);
                    sum += (float) num / (float) (resultList.size() - 1);
                    System.out.println(i + ": " + sum);
                    if(i ==16){
                        numSum.put(i,sum);
                    }else if(i == 64){
                        numSum.put(i,sum);
                    }else if(i == 111){
                        numSum.put(i,sum);
                    }else if (i == 187){
                        numSum.put(i,sum);
                    }

                    if(i<=16 && rate >= 0.4){
                        k++;
                    }else if((i>16&&i<=64) &&(rate>=0.4)){
                        l++;
                    }else if((i>64&&i<=111) &&(rate>=0.4)){
                        m++;
                    }else if ((i>111&&i<=187) && (rate>=0.4)){
                        n++;
                    }



//                    System.out.println(sum);
                    resultList.clear();
                }else{
                        resultList.add(str);
                }

            }

//
//        System.out.println(numSum.get(16));
//        System.out.println(numSum.get(64));
//        System.out.println(numSum.get(111));
//        System.out.println(numSum.get(187));
//
//        System.out.println(numSum.get(16)/16);
//        System.out.println((numSum.get(64)-numSum.get(16))/48);
//        System.out.println((numSum.get(111)-numSum.get(64))/47);
//        System.out.println((numSum.get(187)-numSum.get(111))/76);
//
//        System.out.println(((numSum.get(16)/16)+((numSum.get(64)-numSum.get(16))/48)+((numSum.get(111)-numSum.get(64))/47)
//                            + ((numSum.get(187)-numSum.get(111))/76))/4);
        System.out.println("-------------------------------");
        System.out.println("k=:"+k);
        System.out.println("l=:"+l);
        System.out.println("m=:"+m);
        System.out.println("n=:"+n);
        System.out.println((float)k/16);
        System.out.println((float)l/48);
        System.out.println((float)m/47);
        System.out.println((float)n/76);
        System.out.println(((float)k/16+(float)l/48+(float)m/47+(float)n/76)/4);


    }
}
