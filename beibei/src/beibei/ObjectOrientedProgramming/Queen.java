package beibei.ObjectOrientedProgramming;

/**
 * Created by sunyinhui on 16-6-2.
 */
public class Queen {
    private final int size;         // 棋盘大小
    private int[] location;         // 列的位置
    private int[] colsOccupied;    //
    private int[] cross1Occupied;   // 正对角线
    private int[] cross2Occupied;   // 斜对角线
    private static int count;       // 解决方案的个数

    private static final int START_OCCUPIED =1 ; // 占领状态
    private static final int START_OCCUPIED_CANCELED = 0 ; // 未占领状态


    public Queen(int size){
        this.size = size;
        location = new int[size];
        colsOccupied = new int[size];
        cross1Occupied = new int[2*size];
        cross2Occupied = new int[2*size];
    }

    public void printLocation(){
        System.out.println("以下是皇后在棋盘上的第"+count+"种摆放位置");
        for (int i=0;i<size;i++){
            System.out.println("行："+i + " 列："+ location[i]);
        }
    }

    /**
     * 判断位置(i,j)是否被占领
     */
    private boolean isOccupied(int i, int j){
        return (colsOccupied[j]==1) || (cross1Occupied[i-j+size-1]==1) || (cross2Occupied[i+j]==1);
    }

    /**
     * 宣布占领或取消占领
     * @param i
     * @param j
     * @param flag
     */
    private void setStatus(int i, int j, int flag){
        colsOccupied[j]=flag;
        cross1Occupied[i-j+size-1]=flag;
        cross2Occupied[i+j]=flag;
    }

    public void place(int i){
        for (int j=0;j<size; j++){
            if (!isOccupied(i,j)){
                location[i] = j;
                setStatus(i,j,START_OCCUPIED);
                if (i<size-1){
                    place(i+1);
                }else{
                    count++;
                    printLocation();
                }
                setStatus(i,j,START_OCCUPIED_CANCELED);
            }

        }
    }

    public void start(){
        place(0);
    }
    public static void main(String[] args){
        new Queen(8).start();
    }

}
