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
    private JLabel labelEntranceRandom;
    private JLabel labelExitRandom;

    private static JPanel[] spaces;
    private String[] delayOptions = {"0.5 segundos", "1 segundo", "2 segundos"};
    private int[] delayValues = {500, 1000, 2000};
    private int entranceDelay;
    private int exitDelay;

    public MainWindow()
    {
        loadCarParks();
        loadComboBoxOptions();

        entranceDelay = getRandomDelay();
        exitDelay = getRandomDelay();

        labelEntranceRandom.setText("Tiempo de entrada al inicializar: " + entranceDelay + " ms");
        labelExitRandom.setText("Tiempo de salida al inicializar: " + exitDelay + " ms");

        ParkingLot parkingLot = new ParkingLot();
        new VehicleEntry(parkingLot, entranceDelay).start();
        new VehicleExit(parkingLot, exitDelay).start();


        comboBoxEntranceSpeed.addActionListener(e -> {
            entranceDelay = delayValues[comboBoxEntranceSpeed.getSelectedIndex()];
        });

        comboBoxExitSpeed.addActionListener(e -> {
            exitDelay = delayValues[comboBoxExitSpeed.getSelectedIndex()];
        });
    }

    private void loadComboBoxOptions()
    {
        comboBoxEntranceSpeed.addItem("");
        comboBoxExitSpeed.addItem("");

        for(String option : delayOptions) {
            comboBoxEntranceSpeed.addItem(option);
            comboBoxExitSpeed.addItem(option);
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

    private int getRandomDelay()
    {
        Random random = new Random();
        return delayValues[random.nextInt(3)];
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
    }

}