package pl.allegro.tech.recruit.cart;

import pl.allegro.tech.recruit.product.AdditionalService;
import pl.allegro.tech.recruit.product.Product;

public class ShoppingCart {

    //Important: leave the default constructor
    public ShoppingCart() {
    }

    //Important: implement the method. Otherwise you won't be able to pass tests.
    Summary getSummary() {
        //TODO implement
        throw new RuntimeException("Method must be implemented to verify assertions.");
    }

    void addProduct(Product product, int quantity) {
        //TODO implement
    }

    void removeProduct(Product product, int quantity) {
        //TODO implement
    }

    void addExtraService(Product product, AdditionalService service) {
        //TODO implement
    }

    void removeExtraService(Product product, AdditionalService service) {
        //TODO implement
    }

    void setDelivery(Delivery delivery) {
        //TODO implement
    }

    void addGiftCard(GiftCard giftCard) {
        //TODO implement
    }
}
