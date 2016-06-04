package beibei.ObjectOrientedProgramming.combination.combination;

import java.util.Set;

/**
 * Created by sunyinhui on 16-6-4.
 */
public class IntSet {
    private Set<Integer> set;

    public IntSet(Set<Integer> set) {
        this.set = set;
    }

    public boolean add(int a){
        return set.add(Integer.valueOf(a));     //调用Set的add()方法
    }

    public boolean remove(int a){
        return set.remove(Integer.valueOf(a));  //调用Set的remove()方法
    }
}
