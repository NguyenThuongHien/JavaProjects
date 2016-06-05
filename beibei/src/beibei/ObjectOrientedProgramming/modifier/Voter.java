package beibei.ObjectOrientedProgramming.modifier;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sunyinhui on 16-6-5.
 */

/**
 *static变量在某种程度上与其他语言(C/C++)中的全局变量相似。
 * Java不支持不属于任何类的全局变量，静态变量提供了这一功能。它有如下两个作用：
 * 1. 能被类的所有实例共享，可作为实例之间进行交流的共享数据
 * 2. 如果类的所有实例都包含一个相同的常量属性，可把这个属性定义为静态常量，从而节省内存空间
 */
public class Voter {

    private static final int MAX_COUNT = 100; //静态变量，最大投票数
    private static int count ;                //静态变量，投票数
    /**
     * 防止重复投票，使用HashSet记录
     */
    private static Set<Voter> voters = new HashSet<Voter>();

    private String name;                      //实例变量，投票人姓名

    public Voter(String name){
        this.name = name;
    }

    /**投票*/
    public void voterFor(){
        if (count == MAX_COUNT){
            System.out.println("投票活动已经结束");
        }

        if (voters.contains(this)){
            System.out.println(name+"：不允许重复投票");
        }else{
            count ++;
            voters.add(this);
            System.out.println(name + "感谢您投票");
        }
    }

    /**
     * 打印投票结果
     */
    public static void printVoteResult(){
        System.out.println("当前投票数为："+count);
        System.out.println("参与投票的选民名单如下：");
        for (Voter voter : voters){                //遍历voters集合
            System.out.println(voter.name);
        }
    }


    public static void main(String[] args){
        Voter tom = new Voter("Tom");
        Voter mike = new Voter("Mike");
        Voter jack = new Voter("Jack");

        tom.voterFor();
        tom.voterFor();
        mike.voterFor();
        jack.voterFor();

        Voter.printVoteResult();
    }

}
