package customer;

import order.DeliveryTime;

public class Customer {
    @SuppressWarnings({"unused", "FieldCanBeLocal"})
    private final String name;
    private final DeliveryTime zipCode;
    private final int estimatedDeliveryTime;

    public Customer(String name, DeliveryTime zipCode) {
        this.name = name;
        this.zipCode = zipCode;
        this.estimatedDeliveryTime = setEstimatedDeliveryTime();
    }

    private int setEstimatedDeliveryTime() {
        return switch (this.zipCode) {
            case A5Minutes -> 5;
            case B10Minutes -> 10;
            case C15Minutes -> 15;
        };
    }

    public int getEstimatedDeliveryTime() {
        return estimatedDeliveryTime;
    }
}
