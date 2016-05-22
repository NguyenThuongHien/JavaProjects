package beibei;



import org.jcp.xml.dsig.internal.dom.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by sunyinhui on 16-5-22.
 */
public class NewsItem implements Comparable<NewsItem>{
    private String title;
    private int hits;
    private Date pubTime;

    public NewsItem() {
    }

    public NewsItem(String title, int hits, Date pubTime) {
        super();
        this.title = title;
        this.hits = hits;
        this.pubTime = pubTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public Date getPubTime() {
        return pubTime;
    }

    public void setPubTime(Date pubTime) {
        this.pubTime = pubTime;
    }

    /**
     * 重写compareTo方法，自己定义业务实现，时间降序 点击量升序 标题降序
     */
    @Override
    public int compareTo(NewsItem o) {
        int result = 0;
        result = -this.pubTime.compareTo(o.pubTime); //默认升序 加负实现降序
        if(0==result){  //时间相同
            result = this.hits - o.hits; //点击量升序
            if (0==result){              //点击量相同
                result = this.title.compareTo(o.title);
                return result;
            }else{
                return result;
            }

        }else{
            return result;
        }

    }



}


