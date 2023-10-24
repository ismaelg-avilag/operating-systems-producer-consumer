public class VehicleExit extends Thread{
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
        while(true) {
            try {
                parkingLot.leave();
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
