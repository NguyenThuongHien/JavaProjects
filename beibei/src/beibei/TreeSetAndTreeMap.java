package beibei;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by sunyinhui on 16-5-22.
 */
public class TreeSetAndTreeMap {
    public static void main(String[] args){

        Persons p1 = new Persons("您",10);
        Persons p2 = new Persons("刘德华",88);
        Persons p3 = new Persons("梁朝伟",99);
        Persons p4 = new Persons("老裴",77);
        //一次存放到TreeSet容器中，使用排序的业务类 匿名内部类
        TreeSet<Persons> persons = new TreeSet<Persons>(
                new Comparator<Persons>() {
                    @Override
                    public int compare(Persons persons, Persons t1) {
                        return -(persons.getSales()-t1.getSales());
                    }
                }
        );
        //TreeSet在添加数据时排序
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);

        System.out.println(persons.first().getName());


    }
}


class Persons{
    private String name;
    private int sales;

    public Persons(String name, int sales) {
        this.name = name;
        this.sales = sales;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }
}