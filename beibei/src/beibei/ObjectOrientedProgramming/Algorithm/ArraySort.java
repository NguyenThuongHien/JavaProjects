package beibei.ObjectOrientedProgramming.Algorithm;

/**
 * Created by sunyinhui on 16-6-12.
 */
public class ArraySort {
    /**
     * 冒泡排序
     */

    public static void bubbleSort(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-i-1; j++) {
                if (array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
            print(i+1,array);
        }
    }

    public static void print(int time, int[] array) {
        System.out.print("第" + time + "趟排序:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

    }

    public static void main(String[] args){
        int[] array = {4, 7, 5, 3, 9, 0};
        bubbleSort(array);
    }
}
