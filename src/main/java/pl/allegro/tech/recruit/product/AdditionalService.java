package pl.allegro.tech.recruit.product;


public class AdditionalService {
    private final String name;
    private final int price;

    public AdditionalService(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
