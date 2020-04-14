package pl.allegro.tech.recruit.cart;

import pl.allegro.tech.recruit.product.AdditionalService;
import pl.allegro.tech.recruit.product.Product;

import java.util.List;

public class CartItem {
        Product product;
        List<AdditionalService> additionalServices;
        int quantity;
        int price; // <- hint: calkowita cena, czyli: (cena produktu + ceny uslug dodatkowych) * liczba sztuk

        public CartItem(Product product, List<AdditionalService> additionalServices, int quantity, int price) {
                this.product = product;
                this.additionalServices = additionalServices;
                this.quantity = quantity;
                this.price = price;
        }

        public Product getProduct() {
                return product;
        }

        public List<AdditionalService> getAdditionalServices() {
                return additionalServices;
        }

        public int getQuantity() {
                return quantity;
        }

        public int getPrice() {
                return price;
        }

        public void setPrice(int price) {
                this.price = price;
        }

        public void setQuantity(int quantity) {
                this.quantity = quantity;
        }

        public void addAdditionalServices(AdditionalService additionalService) {
                additionalServices.add(additionalService);
        }

        public void deleteAdditionalServices(AdditionalService additionalService) {
                additionalServices.remove(additionalService);
        }
}
