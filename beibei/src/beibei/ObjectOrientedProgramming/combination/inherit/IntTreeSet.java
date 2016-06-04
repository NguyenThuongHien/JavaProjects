package beibei.ObjectOrientedProgramming.combination.inherit;

import java.util.TreeSet;

/**
 * Created by sunyinhui on 16-6-4.
 */
public class IntTreeSet extends TreeSet implements IntSet {
    @Override
    public boolean add(int a) {
        return add(new Integer(a));     //调用TreeSet类的add方法
    }

    @Override
    public boolean remove(int a) {
        return remove(new Integer(a));  //调用TreeSet类的remove方法
    }
}
