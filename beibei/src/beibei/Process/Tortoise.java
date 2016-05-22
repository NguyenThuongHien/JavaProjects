package beibei.Process;

/**
 * Created by sunyinhui on 16-5-22.
 */
public class Tortoise extends Thread {
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("Tortoise run " + i);
        }
    }
}
