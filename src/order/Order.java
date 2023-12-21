package order;

import java.util.LinkedList;

import pizza.Pizza;
import customer.Customer;


public class Order {

    private final Customer customer;
    private OrderStatus orderStatus;
    private final LinkedList<Pizza> orderItems;
    @SuppressWarnings("unused")
    private final int orderPrice;
    private final int orderEstimatedTime;

    public Order(Customer customer, OrderStatus orderStatus, LinkedList<Pizza> orderItems) {
        this.customer = customer;
        this.orderStatus = orderStatus;
        this.orderItems = orderItems;
        this.orderPrice = calculateOrderPrice();
        this.orderEstimatedTime = calculateOrderEstimatedTime();

    }



    private int calculateOrderEstimatedTime() {
        return this.customer.getEstimatedDeliveryTime();
    }
    @SuppressWarnings("unused")
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;

    }

    private int calculateOrderPrice() {
        int orderPrice = 0;
        for (Pizza pizza : orderItems) {
            orderPrice += pizza.getPizzaPrice();
        }

        return orderPrice;
    }

    public int getOrderPrice() {
        return orderPrice;
    }
    public  int getOrderEstimatedTimeInMinutes() {
        return orderEstimatedTime;
    }
    @SuppressWarnings("unused")
    public LinkedList<Pizza> getOrderItems (){
        return orderItems;
    }

    @SuppressWarnings("unused")
    public void printOrderItems() {
        System.out.println("======================================================================");

        System.out.println("Order Price: " + calculateOrderPrice());
        System.out.println("Order Estimated Time: " + calculateOrderEstimatedTime());
        System.out.println("Order Status: " + orderStatus);
        System.out.println("Customer: " + customer.toString());
        System.out.println("Order Items:");
        for (Pizza pizza : orderItems) {
            System.out.println("____________________________________");
            System.out.println(pizza.printPizza());

        }
        System.out.println("======================================================================");
    }
}
