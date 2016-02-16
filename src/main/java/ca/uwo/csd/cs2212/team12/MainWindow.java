package ca.uwo.csd.cs2212.team12;
import javax.swing.*;

public class MainWindow extends JFrame {
    private JTextField txtName;
    private JLabel lblGreeting;
    private JRadioButton radBachelors;
    private JRadioButton radMasters;
    private JRadioButton radPhd;

    public MainWindow() {
        this.initUI();
    }

    private void initUI() {
        this.setTitle("StayFit");
        this.setSize(800, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}