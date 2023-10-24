public class VehicleEntry extends Thread {
    private ParkingLot parkingLot;
    int delay;

    public VehicleEntry(ParkingLot parkingLot, int delay)
    {
        this.parkingLot = parkingLot;
        this.delay = delay;
    }

    public void run()
    {
        while(true) {
            try {
                parkingLot.park();
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
