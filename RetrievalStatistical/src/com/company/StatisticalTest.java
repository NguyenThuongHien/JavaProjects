package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunyinhui on 16-4-16.
 */
public class StatisticalTest {
    static List<String> resultList = new ArrayList<String>();
    public static void main(String argv[]){
        String filePath= "/home/sunyinhui/JavaProjects/RetrievalStatistical/src/com/company/retrievalResult.txt";
        try {
            readTxtFile(filePath,resultList);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void readTxtFile(String filePath,List<String> resultList) throws IOException {
        String encoding = "GBK";
        File file = new File(filePath);
        if(file.isFile() && file.exists()){
            InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);
            BufferedReader bufferedReader = new BufferedReader(read);
            String lineTxt = null;
            int i = 1;
            int step =0;

//          System.out.println(lineTxt);


            while((lineTxt = bufferedReader.readLine()) != null){
                System.out.println(lineTxt);
                if(i != Integer.parseInt(lineTxt)){
                    resultList.add(lineTxt);
                    System.out.println(resultList);

                }
                i++;
            }







            read.close();
        }else{
            System.out.println("找到不到指定的文件");
        }

    }

}
