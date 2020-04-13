package pl.allegro.tech.recruit.product;

import java.time.Duration;
import java.util.List;

public class Product {
    private final String productId;
    private final int price;
    private final List<AdditionalService> services;
    private final Duration expectedSendingTime;

    public Product(String productId, int price, List<AdditionalService> services, Duration expectedSendingTime) {
        this.productId = productId;
        this.price = price;
        this.services = services;
        this.expectedSendingTime = expectedSendingTime;
    }

    public String getProductId() {
        return productId;
    }

    public int getPrice() {
        return price;
    }

    public List<AdditionalService> getServices() {
        return services;
    }

    public Duration getExpectedSendingTime() {
        return expectedSendingTime;
    }
}

