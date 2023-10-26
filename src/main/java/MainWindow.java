import javax.swing.*;
import java.util.Random;

public class MainWindow {
    private JPanel mainPanel;
    private JComboBox comboBoxEntranceSpeed;
    private JComboBox comboBoxExitSpeed;
    private JPanel carPark0;
    private JPanel carPark1;
    private JPanel carPark2;
    private JPanel carPark3;
    private JPanel carPark4;
    private JPanel carPark5;
    private JPanel carPark6;
    private JPanel carPark7;
    private JPanel carPark8;
    private JPanel carPark9;
    private JPanel carPark10;
    private JPanel carPark11;

    private static JPanel[] spaces;
    private String[] delayOptions = {"0.5 segundos", "1 segundo", "2 segundos"};

    public MainWindow()
    {
        loadCarParks();

        for(String option : delayOptions) {
            comboBoxEntranceSpeed.addItem(option);
            comboBoxExitSpeed.addItem(option);
        }
    }

    private long getDelay(String selectedOption)
    {
        switch(selectedOption) {
            case "0.5 segundos":
                return 500;
            case "1 segundo":
                return 1000;
            case "2 segundos":
                return 2000;
            default:
                return 0;
        }
    }

    private void loadCarParks()
    {
        spaces = new JPanel[12];
        spaces[0] = carPark0;
        spaces[1] = carPark1;
        spaces[2] = carPark2;
        spaces[3] = carPark3;
        spaces[4] = carPark4;
        spaces[5] = carPark5;
        spaces[6] = carPark6;
        spaces[7] = carPark7;
        spaces[8] = carPark8;
        spaces[9] = carPark9;
        spaces[10] = carPark10;
        spaces[11] = carPark11;

        for(JPanel space : spaces)
            space.setBackground(java.awt.Color.GREEN);
    }


    public static void UpdateSpaceStatus(int nextEmptySpace, boolean isOccupied)
    {
        spaces[nextEmptySpace].setBackground(isOccupied ? java.awt.Color.RED : java.awt.Color.GREEN);
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Productor - Consumidor");
        frame.setContentPane(new MainWindow().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        /*
        ParkingLot parkingLot = new ParkingLot();
        Random random = new Random();

        int randomEntranceDelay = random.nextInt(3) + 1;
        int randomExitDelay = random.nextInt(3) + 1;

        int entranceDelay = randomEntranceDelay * 500;
        int exitDelay = randomExitDelay * 500;

        new VehicleEntry(parkingLot, entranceDelay);
        new VehicleExit(parkingLot, exitDelay);
        */
    }

}