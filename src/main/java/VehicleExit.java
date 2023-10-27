public class VehicleExit extends Thread {
    private ParkingLot parkingLot;
    int delay;

    public VehicleExit(ParkingLot parkingLot, int delay)
    {
        this.parkingLot = parkingLot;
        this.delay = delay;
    }

    @Override
    public void run()
    {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                parkingLot.leave();
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
