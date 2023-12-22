package gui;

import pizzeria.PizzaFIFO;
import pizzeria.PizzaProfit;
import pizzeria.PizzaRandom;
import simulation.startSimulation;

import javax.swing.*;

import java.awt.*;

import static gui.gui.panel;

public class SimulationFrame {
    public SimulationFrame(String SimulationDuration, String orderLoad, String extraDeliveryDuration) {

        Thread pizzaFIFOSimulationThread = new Thread(new startSimulation(new PizzaFIFO(), Integer.parseInt(orderLoad)));
        Thread pizzaProfitSimulationThread = new Thread(new startSimulation(new PizzaProfit(), Integer.parseInt(orderLoad)));
        Thread pizzaRandomSimulationThread = new Thread(new startSimulation(new PizzaRandom(), Integer.parseInt(orderLoad)));

        //pizzaFIFOSimulationThread.start();
        newFIFOFrame();
       // pizzaProfitSimulationThread.start();
        newProfitFrame();
        //pizzaRandomSimulationThread.start();
        newRandomFrame();

    }

    private void newRandomFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        JFrame randomFrame = new JFrame("Random Pizzeria Simulation");
        randomFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        randomFrame.setSize(screenSize.width/3, screenSize.height);
        randomFrame.setLayout(new BorderLayout());
        randomFrame.setLocationRelativeTo(panel);
        randomFrame.setVisible(true);
        randomFrame.add(SetUpNorthPanel("Random Pizzeria Simulation"));
        randomFrame.add(SetUpCenterPanel());





    }

    private JPanel  SetUpCenterPanel() {
        JPanel panel = new JPanel();
        return panel;
    }

    private JPanel SetUpNorthPanel(String str) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel(str));
        return panel;
    }

    private void newProfitFrame() {
    }

    private void newFIFOFrame() {
    }
}
