package com.company;

import java.io.*;

/**
 * Created by sunyinhui on 16-4-16.
 */
public class Statistical {

    public static void main(String argv[]){
        String filePath= "/home/sunyinhui/JavaProjects/RetrievalStatistical/src/com/company/retrievalResult.txt";
        try {
            readTxtFile(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void readTxtFile(String filePath) throws IOException {
        String encoding = "GBK";
        File file = new File(filePath);
        if(file.isFile() && file.exists()){
            InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);
            BufferedReader bufferedReader = new BufferedReader(read);
            String lineTxt = null;
            int  i = 1;
            int step =0;
            while((lineTxt = bufferedReader.readLine()) != null) {
                System.out.println(lineTxt);
                while(i == Integer.parseInt(lineTxt)) {
                    System.out.println(i);
                   String str = bufferedReader.readLine();
                    int j = i;
                    //就解析数据，然后统计top5的准确率
                    //否则，就统计跳过多少行，直到lineTex能够解析为整数。
                    String parStr = str;
                    String parStrr = parStr.substring(2,8);

                }
            }

            read.close();
        }else{
            System.out.println("找到不到指定的文件");
        }

    }

}
