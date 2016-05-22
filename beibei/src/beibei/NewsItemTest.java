package beibei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by sunyinhui on 16-5-22.
 */
public class NewsItemTest {
    public static void main(String[] args){
        List<NewsItem> news = new ArrayList<>();
        news.add(new NewsItem("HelloJava",100,new Date()));
        news.add(new NewsItem("HelloC",100,new Date()));
        news.add(new NewsItem("HelloC++",50,new Date(System.currentTimeMillis()+1000*60*60)));
        news.add(new NewsItem("HelloPython",60,new Date(System.currentTimeMillis()+1000*60*60)));
        news.add(new NewsItem("HelloEnLang",100,new Date(System.currentTimeMillis()-1000*60*60)));
        System.out.println("=====before sorted========="+ news);
        Collections.sort(news);
        System.out.println("=====after sorted========="+ news);

    }
}
