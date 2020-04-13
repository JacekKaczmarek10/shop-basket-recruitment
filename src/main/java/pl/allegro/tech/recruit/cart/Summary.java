package pl.allegro.tech.recruit.cart;

import java.time.LocalDate;
import java.util.List;

public class Summary {
    private final List<CartItem> items;
    private final int totalPrice;
    private final GiftCard giftCard;
    private final int leftToPay;
    private final Delivery delivery;
    private final LocalDate expectedShippingDate;
    private final LocalDate expectedDeliveryDate;

    public Summary(List<CartItem> items, int totalPrice, GiftCard giftCard, int leftToPay, Delivery delivery, LocalDate expectedShippingDate, LocalDate expectedDeliveryDate) {
        this.items = items;
        this.totalPrice = totalPrice;
        this.giftCard = giftCard;
        this.leftToPay = leftToPay;
        this.delivery = delivery;
        this.expectedShippingDate = expectedShippingDate;
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public int getLeftToPay() {
        return leftToPay;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public LocalDate getExpectedShippingDate() {
        return expectedShippingDate;
    }

    public LocalDate getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public GiftCard getGiftCard() {
        return giftCard;
    }
}
