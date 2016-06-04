package beibei.ObjectOrientedProgramming.combination.inherit;

import java.util.HashSet;

/**
 * Created by sunyinhui on 16-6-4.
 */
public class IntHashSet extends HashSet implements IntSet{
    @Override
    public boolean add(int a) {
        return add(new Integer(a));     //调用HashSet类的add方法
    }

    @Override
    public boolean remove(int a) {
        return remove(new Integer(a));   //调用HashSet类的remove方法
    }
}


