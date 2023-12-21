package simulation;

import pizzeria.Pizzeria;

public class startSimulation implements Runnable {
    final private Pizzeria pizzeria;

    public startSimulation(Pizzeria pizzeria) {
        this.pizzeria = pizzeria;
    }

    @Override
    public void run() {

        new Thread(new Simulation(pizzeria, 10)).start();
    }
}
