package gui;

import javax.swing.*;
import java.awt.*;

public class gui extends JFrame {
    static JPanel masterPanel = new MasterPanel();
    static JPanel panel = new JPanel();


    public gui(){
        this.setTitle("PizzeriaSimulation");
        this.setSize(550,550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUpMainPanel();
        this.setLocationRelativeTo(null);
        this.setFocusable(true);
        this.setResizable(false);
        this.setVisible(true);
    }

    private void setUpMainPanel() {
        panel.setLayout(new BorderLayout());
        panel.add(masterPanel);
        this.add(panel);

    }


}
