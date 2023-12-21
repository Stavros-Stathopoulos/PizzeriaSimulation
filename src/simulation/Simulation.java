package simulation;

import order.DeliveryTime;
import order.Order;
import order.OrderStatus;
import pizza.ExtraIngrediens;
import pizza.Pizza;
import pizzeria.Pizzeria;

import java.util.LinkedList;
import java.util.Random;

import customer.Customer;

public class Simulation implements Runnable {
    private static final Random rand = new Random();
    private final Pizzeria  pizzeria;
    private final int numb;

    public Simulation(Pizzeria pizzeria, int numb) {
        this.pizzeria = pizzeria;
        this.numb = numb;
    }

    @Override
    public void run() {
        LinkedList<Order> orderList;
        orderList = randomOrderCreation(this.numb);
        this.pizzeria.setReceivedOrders(orderList);
        System.out.println(Thread.currentThread() + "\treceived Orders:\t" +this.pizzeria.getNumberOfOrders());
        System.out.println("______________________________________________________________________");

        for(Order order  : orderList) {
            //order.printOrderItems();
            this.pizzeria.prepareOrder(order);
            this.pizzeria.deliverOrder(order);

        }
        System.out.println(Thread.currentThread() + "Delivered orders: "+this.pizzeria.getNumberOfDeliveredOrders());
        System.out.println(Thread.currentThread() + "Revenue: "+this.pizzeria.getRevenue());

    }

    public LinkedList<Order> randomOrderCreation(int numberOfOrders) {
        LinkedList<Order> orderListForSimulation = new LinkedList<>();
        for (int i = 0; i < numberOfOrders; i++) {
            orderListForSimulation.add(new Order(randomCustomer(), OrderStatus.OrderInPreparation, randomOrderItemsGenerator()));
        }
        return orderListForSimulation;

    }

    private Customer randomCustomer() {
        return new Customer(RandomName().toString(), RandomAddress ());
    }

    private DeliveryTime RandomAddress () {
        int pick = rand.nextInt(DeliveryTime.values().length);
        return DeliveryTime.values()[pick];
    }


    private CustomerName RandomName() {
        int pick = rand.nextInt(CustomerName.values().length);
        return CustomerName.values()[pick];
    }



    private LinkedList<Pizza> randomOrderItemsGenerator() {
        LinkedList<Pizza> Pizzas = new LinkedList<>();
        int numberOfPizzas = rand.nextInt(1, 10);

        for(int i=1; i <=numberOfPizzas ; i++) {
            Pizzas.add(new Pizza(pickExtra()));
        }
        return Pizzas;
    }

    private LinkedList<ExtraIngrediens> pickExtra() {
        int numbOfIngr = rand.nextInt(1, 12);
        LinkedList<ExtraIngrediens> extra = new LinkedList<>();
        for(int i = 0; i < numbOfIngr; i++) {
            int pick = rand.nextInt(ExtraIngrediens.values().length);
            extra.add(ExtraIngrediens.values()[pick]);
        }
        return extra;
    }
}
