package ca.uwo.csd.cs2212.team12;
import javax.swing.*;
import java.awt.*;

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
        this.setSize(950, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setLayout(new BorderLayout());
        this.add(new LoginPanel(), BorderLayout.CENTER);
    }

    /* Replaces the panel currently being shown in MainWindow and replaces it with a new one. */
    public void presentPanel(JPanel panel) {
        this.removeAll();
        this.add(panel, BorderLayout.CENTER);
    }

}