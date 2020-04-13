package pl.allegro.tech.recruit.cart;

import pl.allegro.tech.recruit.product.AdditionalService;
import pl.allegro.tech.recruit.product.Product;

import java.time.Duration;
import java.util.List;

public class TestFactory {
    static Product anOffer(String offerId, int price, List<AdditionalService> services, Duration expectedSendingTime) {
        return new Product(offerId, price, services, expectedSendingTime);
    }

}
