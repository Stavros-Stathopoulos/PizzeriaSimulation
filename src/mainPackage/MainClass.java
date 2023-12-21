package mainPackage;


import pizzeria.PizzaFIFO;
import pizzeria.PizzaProfit;
import pizzeria.PizzaRandom;
import simulation.startSimulation;
import gui.gui;

public class MainClass {
    public static void main(String[] args) {
        gui mainFrame = new gui();

/*
        Thread pizzaFIFOSimulationThread = new Thread(new startSimulation(new PizzaFIFO()));
        Thread pizzaProfitSimulationThread = new Thread(new startSimulation(new PizzaProfit()));
        Thread pizzaRandomSimulationThread = new Thread(new startSimulation(new PizzaRandom()));

        pizzaFIFOSimulationThread.start();
        pizzaProfitSimulationThread.start();
        pizzaRandomSimulationThread.start();
*/
    }
}
