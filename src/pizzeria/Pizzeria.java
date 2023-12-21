package pizzeria;

import order.Order;
import order.OrderStatus;
import java.util.LinkedList;

public class Pizzeria {

    @SuppressWarnings("FieldCanBeLocal")
    private LinkedList<Order> receivedOrders = new LinkedList<>();
    private final LinkedList<Order> deliveredOrders = new LinkedList<>();
    private int revenue = 0;
    private int numberOfOrders = 0;
    private int numberOfDeliveredOrders = 0;

    private DeliveryLocation deliveryLocation = DeliveryLocation.Pizzeria;
    @SuppressWarnings({"unused", "FieldCanBeLocal"})
    private final PizzaPriority pizzaPriority;

    public Pizzeria(PizzaPriority pizzaPriority) {
        this.pizzaPriority = pizzaPriority;

    }

    public void setReceivedOrders(LinkedList<Order> ord) {
        this.receivedOrders = ord;
        this.numberOfOrders = this.receivedOrders.size();
    }

    public void deliverOrder(Order order) {

        order.setOrderStatus(OrderStatus.OrderEnRoute);
        if(getDeliveryLocation().equals(DeliveryLocation.enRoute)) {
            System.out.println(" Delivery guy of: "+ Thread.currentThread() + "\t Is on the go!");
        }
        else {

            System.out.println(Thread.currentThread() +" Delivery of:\t"+ order +" Started!");
            setDeliveryLocation(DeliveryLocation.enRoute);
            deliveredOrders.add(order);

            try {
                Thread.sleep(2000L * order.getOrderEstimatedTimeInMinutes());
            } catch (InterruptedException e) {
                System.out.println("Error: " + e.getMessage());
            }

            order.setOrderStatus(OrderStatus.OrderDelivered);
            numberOfDeliveredOrders++;
            System.out.println(Thread.currentThread() +" Delivery of\t"+ order + " Completed!");
            //System.out.println("Delivery\t " + order.getOrderPrice()+"$");
            this.revenue += order.getOrderPrice();
            setDeliveryLocation(DeliveryLocation.Pizzeria);
        }

    }

    public void prepareOrder(Order order) {
        order.setOrderStatus(OrderStatus.OrderInPreparation);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }

        order.setOrderStatus(OrderStatus.OrderWaitingForDelivery);
    }

    public int getRevenue() {
        return revenue;
    }

    public int getNumberOfOrders() {
        return numberOfOrders;
    }

    public int getNumberOfDeliveredOrders() {
        return numberOfDeliveredOrders;
    }

    public DeliveryLocation getDeliveryLocation() {
        return deliveryLocation;
    }

    public void setDeliveryLocation(DeliveryLocation deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }


}
