import com.sun.tools.javac.Main;

public class ParkingLot {
    private final int CAPACITY = 12;
    private boolean[] parkingSpaces;

    public ParkingLot() {
        parkingSpaces = new boolean[CAPACITY];
    }

    public synchronized void park() throws InterruptedException
    {
        for(int i = 0; i < CAPACITY; i++) {
            if(!parkingSpaces[i]) {
                parkingSpaces[i] = true;
                MainWindow.UpdateSpaceStatus(i, true);
                return;
            }
        }
        wait(); // Wait if no space is available
    }

    public synchronized void leave() throws InterruptedException
    {
        for(int i = 0; i < CAPACITY; i++) {
            if(parkingSpaces[i]) {
                parkingSpaces[i] = false;
                MainWindow.UpdateSpaceStatus(i, false);
                notifyAll(); // Notify all threads that a space is available
                return;
            }
        }
    }

}
