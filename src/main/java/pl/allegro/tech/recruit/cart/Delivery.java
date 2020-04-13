package pl.allegro.tech.recruit.cart;

import java.time.Duration;

public class Delivery {

    private final String name;
    private final int price;
    private final Duration expectedDeliveryTime;

    public Delivery(String name, int price, Duration expectedDeliveryTime) {
        this.name = name;
        this.price = price;
        this.expectedDeliveryTime = expectedDeliveryTime;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Duration getExpectedDeliveryTime() {
        return expectedDeliveryTime;
    }
}
