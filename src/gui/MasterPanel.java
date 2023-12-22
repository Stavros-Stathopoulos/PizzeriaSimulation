package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class MasterPanel extends JPanel {
    private Color backgroundColor = Color.darkGray;
    public MasterPanel(){
        this.setLayout(new BorderLayout());
        this.add(SimulationPanelNorth(), BorderLayout.NORTH);
        this.add(SimulationPanelCenter(), BorderLayout.CENTER);
    }

    private JPanel SimulationPanelNorth() {
        JPanel simulationPanelNorth= new JPanel();
        simulationPanelNorth.setLayout(new GridLayout(1,0));
        simulationPanelNorth.setBackground(backgroundColor);
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
        simulationPanelCenter.setBackground(backgroundColor);
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
        JPanel textField1p = new JPanel();
        textField1p.setBackground(backgroundColor);
        textField1p.setPreferredSize(new Dimension(100, 50));
        textField1p.add(textField);

        JPanel textField2p = new JPanel();
        textField2p.setBackground(backgroundColor);
        textField2p.setPreferredSize(new Dimension(100, 50));
        textField2p.add(textField2);

        JPanel textField3p = new JPanel();
        textField3p.setBackground(backgroundColor);
        textField3p.setPreferredSize(new Dimension(100, 50));
        textField3p.add(textField3);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(backgroundColor);
        buttonPanel.setPreferredSize(new Dimension(300, 80));
        buttonPanel.add(startSimulationButton);


        simulationPanelCenter.add(label,0);
        simulationPanelCenter.add(label);
        simulationPanelCenter.add(textField1p, 1);

        simulationPanelCenter.add(label2, 0);
        simulationPanelCenter.add(textField2p, 1);

        simulationPanelCenter.add(label3, 0);
        simulationPanelCenter.add(textField3p, 1);
        simulationPanelCenter.add(buttonPanel);

        return simulationPanelCenter;
    }

    private JButton getButton(JTextField textField, JTextField textField2, JTextField textField3) {
        JButton startSimulationButton = new JButton("Start Simulation");
        startSimulationButton.setFont(new Font("Serif", Font.BOLD, 20));
        startSimulationButton.setBackground(backgroundColor);
        startSimulationButton.setForeground(Color.WHITE);
        startSimulationButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        startSimulationButton.setFocusPainted(false);
        startSimulationButton.addActionListener(e -> {
            System.out.println(textField.getText());
            System.out.println(textField2.getText());
            System.out.println(textField3.getText());
            System.out.println("Start Simulation");
            new SimulationFrame(textField.getText(), textField2.getText(), textField3.getText());
        });
        return startSimulationButton;
    }

    private JTextField getTextField(String str) {
        JTextField textField3 = new JTextField(str);
        textField3.setPreferredSize(new Dimension(150, 40));
        textField3.setFont(new Font("Serif", Font.BOLD, 10));
        textField3.setBackground(backgroundColor);
        textField3.setForeground(Color.WHITE);
        textField3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textField3.setFocusable(true);
        textField3.setAlignmentY(JTextField.CENTER_ALIGNMENT);
        textField3.addFocusListener(new FocusListener() {
                                        @Override
                                        public void focusGained(FocusEvent e) {
                                            // Clear the prompt text when the JTextField gains focus
                                            if (textField3.getText().equals(str)) {
                                                textField3.setText("");
                                            }
                                        }

                                        @Override
                                        public void focusLost(FocusEvent e) {
                                            if (textField3.getText().isEmpty()) {
                                                textField3.setText(str);
                                            }
                                        }

                                    });
        textField3.setHorizontalAlignment(JTextField.CENTER);
        textField3.addActionListener(e -> {
            System.out.println("Start Simulation");
        });
        return textField3;
    }


}
