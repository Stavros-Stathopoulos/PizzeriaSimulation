package gui;

import javax.swing.*;
import java.awt.*;

public class MasterPanel extends JPanel {
    
    public MasterPanel(){
        this.setLayout(new BorderLayout());
        this.add(SimulationPanelNorth(), BorderLayout.NORTH);
        this.add(SimulationPanelCenter(), BorderLayout.CENTER);
    }

    private JPanel SimulationPanelNorth() {
        JPanel simulationPanelNorth= new JPanel();
        simulationPanelNorth.setLayout(new GridLayout(1,0));
        simulationPanelNorth.setBackground(Color.black);
        simulationPanelNorth.setPreferredSize(new Dimension(550, 100));

        JLabel label = new JLabel("Pizzeria Simulation");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setFont(new Font("Serif", Font.BOLD, 25));
        label.setForeground(Color.white);

        simulationPanelNorth.add(label);

        return simulationPanelNorth;
    }

    private JPanel SimulationPanelCenter() {
        JPanel simulationPanelCenter = new JPanel();
        simulationPanelCenter.setLayout(new GridLayout(4,2));
        simulationPanelCenter.setBackground(Color.black);
        simulationPanelCenter.setPreferredSize(new Dimension(550, 450));

        JLabel label = new JLabel("Simulation duration:");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setFont(new Font("Serif", Font.BOLD, 20));
        label.setForeground(Color.white);

        JLabel label2 = new JLabel("Order Load:");
        label2.setHorizontalAlignment(JLabel.CENTER);
        label2.setVerticalAlignment(JLabel.CENTER);
        label2.setFont(new Font("Serif", Font.BOLD, 20));
        label2.setForeground(Color.white);

        JLabel label3 = new JLabel("Extra Delivery Time:");
        label3.setHorizontalAlignment(JLabel.CENTER);
        label3.setVerticalAlignment(JLabel.CENTER);
        label3.setFont(new Font("Serif", Font.BOLD, 20));
        label3.setForeground(Color.white);


        JTextField textField = getTextField("Enter Simulation Duration");

        JTextField textField2 = getTextField("Enter Order Load");

        JTextField textField3 = getTextField("Enter Extra Delivery Time");

        JButton startSimulationButton = getButton(textField, textField2, textField3);


        simulationPanelCenter.add(label);
        simulationPanelCenter.add(textField);
        simulationPanelCenter.add(label2);
        simulationPanelCenter.add(textField2);
        simulationPanelCenter.add(label3);
        simulationPanelCenter.add(textField3);
        simulationPanelCenter.add(startSimulationButton);

        return simulationPanelCenter;
    }

    private JButton getButton(JTextField textField, JTextField textField2, JTextField textField3) {
        JButton startSimulationButton = new JButton("Start Simulation");
        startSimulationButton.setFont(new Font("Serif", Font.BOLD, 20));
        startSimulationButton.setBackground(Color.BLACK);
        startSimulationButton.setForeground(Color.WHITE);
        startSimulationButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        startSimulationButton.setFocusPainted(false);
        startSimulationButton.addActionListener(e -> {
            System.out.println(textField.getText());
            System.out.println(textField2.getText());
            System.out.println(textField3.getText());
            System.out.println("Start Simulation");
        });
        return startSimulationButton;
    }

    private JTextField getTextField(String str) {
        JTextField textField3 = new JTextField(str, 10);
        textField3.setFont(new Font("Serif", Font.BOLD, 20));
        textField3.setBackground(Color.BLACK);
        textField3.setForeground(Color.WHITE);
        textField3.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        textField3.setFocusable(true);
        textField3.setHorizontalAlignment(JTextField.CENTER);
        textField3.addActionListener(e -> {
            System.out.println("Start Simulation");
        });
        return textField3;
    }


}
