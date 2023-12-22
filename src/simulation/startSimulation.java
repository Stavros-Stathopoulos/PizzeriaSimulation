package simulation;

import pizzeria.Pizzeria;

public class startSimulation implements Runnable {
    final private Pizzeria pizzeria;
    final private int numb;

    public startSimulation(Pizzeria pizzeria, int numb) {
        this.pizzeria = pizzeria;
        this.numb = numb;
    }

    @Override
    public void run() {

        new Thread(new Simulation(pizzeria, this.numb)).start();
    }
}
