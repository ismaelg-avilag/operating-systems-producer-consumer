public class VehicleEntry extends Thread {
    private ParkingLot parkingLot;
    int delay;

    public VehicleEntry(ParkingLot parkingLot, int delay)
    {
        this.parkingLot = parkingLot;
        this.delay = delay;
    }

    @Override
    public void run()
    {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                parkingLot.park();
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
