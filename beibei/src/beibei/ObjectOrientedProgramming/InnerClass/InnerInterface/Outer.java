package beibei.ObjectOrientedProgramming.InnerClass.InnerInterface;

/**
 * Created by sunyinhui on 16-6-9.
 */

/**
 * Outer类中有一个静态内部接口Tool
 * Outer类的一个匿名内部类实现了这一接口
 * 此外，一个顶层类MyTool也实现了这个接口
 */
public class Outer {
    /**
     * 静态内部接口
     */
    public static interface Tool{
        public int add(int a, int b);
    }

    /**
     * 匿名类
     */
    private Tool tool = new Tool() {
        @Override
        public int add(int a, int b) {
            return a+b;
        }
    };

    public void add(int a, int b, int c){
        tool.add(tool.add(a,b),c);
    }

    public void setTool(Tool tool){
        this.tool = tool;
    }
}

class MyTool implements Outer.Tool{

    @Override
    public int add(int a, int b) {
        int result = a + b;
        System.out.println(result);
        return result;
    }
}
