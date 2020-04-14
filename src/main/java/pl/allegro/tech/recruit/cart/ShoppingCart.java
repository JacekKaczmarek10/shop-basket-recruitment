package pl.allegro.tech.recruit.cart;

import pl.allegro.tech.recruit.product.AdditionalService;
import pl.allegro.tech.recruit.product.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class ShoppingCart {

    List<CartItem> list;

    private Delivery delivery;
    private GiftCard giftCard;
    int price=0;

    //Important: leave the default constructor
    public ShoppingCart() {
        this.list=new ArrayList<CartItem>();
    }

    //Important: implement the method. Otherwise you won't be able to pass tests.
    Summary getSummary() {

        for (final CartItem item : list)
            price+=item.getPrice();
//        int days = delivery.getExpectedDeliveryTime().hashCode()/86400;
//        LocalDate localDate = LocalDate.now();
//        localDate.plusDays(days);
        Summary summary = new Summary(list,price,this.giftCard,
                price,this.delivery,
                LocalDate.now(),LocalDate.now());
        return summary;
//        throw new RuntimeException("Method must be implemented to verify assertions.");
    }

    void addProduct(Product product, int quantity) {
        boolean productExist = false;
        for (final CartItem item : list) {
            if (item.product.getProductId().equals(product.getProductId()) == true) {
                productExist = true;
                item.setQuantity(item.getQuantity() + quantity);
                item.setPrice(product.getPrice() + quantity * product.getPrice());
                int index = this.getLocationOfProductWithinShoppingCart(product).getAsInt();
                this.list.set(index, item);
            }
        }
            if(productExist==false) {
                CartItem cartItem = new CartItem(product,new ArrayList<>(), quantity, product.getPrice() * quantity);
                list.add(cartItem);
        }
    }

    void removeProduct(Product product, int quantity) {
        for (final CartItem item : list) {
            if (item.product.getProductId().equals(product.getProductId()) == true) {
                if (item.getQuantity() >= quantity) {
                    item.setQuantity(item.getQuantity() + quantity * -1);
                    item.setPrice(quantity * product.getPrice());
                    int index = this.getLocationOfProductWithinShoppingCart(product).getAsInt();
                    this.list.set(index, item);
                }
            }
        }
    }
    void addExtraService(Product product, AdditionalService service) {
        for (final CartItem item : list) {
            if (item.product.getProductId().equals(product.getProductId())) {
                item.addAdditionalServices(service);
                item.setPrice(item.getPrice() + service.getPrice() * item.getQuantity());
                int index = this.getLocationOfProductWithinShoppingCart(product).getAsInt();
                this.list.set(index, item);
            }
        }
    }

    void removeExtraService(Product product, AdditionalService service) {
        for (final CartItem item : list) {
            if (item.product.getProductId().equals(product.getProductId())) {
                item.deleteAdditionalServices(service);
                item.setPrice(item.getPrice() - service.getPrice());
                int index = this.getLocationOfProductWithinShoppingCart(product).getAsInt();
                this.list.set(index, item);
            }
        }
    }

    void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        price+=delivery.getPrice();
    }

    void addGiftCard(GiftCard giftCard) {
        this.giftCard = giftCard;
    }

    OptionalInt getLocationOfProductWithinShoppingCart(Product product) {
        return IntStream.range(0, this.list.size())
                .filter(i -> list.get(i).getProduct() == product)
                .findFirst();
    }

    public List<CartItem> getList() {
        return list;
    }
}






