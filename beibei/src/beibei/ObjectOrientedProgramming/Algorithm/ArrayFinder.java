package beibei.ObjectOrientedProgramming.Algorithm;

/**
 * Created by sunyinhui on 16-6-12.
 */
public class ArrayFinder {
    /**
     * 二分查找
     */
    public static int indexOf(int[] array, int value){
        int low = 0;
        int high = array.length-1;
        int middle;
        while(low < high){
            middle = (low+high)/2;
            print(array,middle);
            if(array[middle] == value) return middle;
            if (value<array[middle]){
                high = middle;
            }else{
                low = middle;
            }
        }
        return -1;              //没有找到该元素，返回-1
    }


    public static void print(int[] array, int middle) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i==middle) System.out.print("*");
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] array = {4,5,6,7,9,13,17};
        System.out.println("location of 13:"+indexOf(array,13));
    }

}
