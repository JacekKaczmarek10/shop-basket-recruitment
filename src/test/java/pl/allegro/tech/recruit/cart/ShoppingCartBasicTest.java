package pl.allegro.tech.recruit.cart;

import org.junit.Test;
import pl.allegro.tech.recruit.product.AdditionalService;
import pl.allegro.tech.recruit.product.Product;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static pl.allegro.tech.recruit.cart.TestFactory.anOffer;

public class ShoppingCartBasicTest {

    private final ShoppingCart cart = new ShoppingCart();

    Product sampleProduct = anOffer("offer-1", 10, Collections.emptyList(), Duration.ZERO);

    @Test
    public void shouldAddOneOffer() {
        //when
        cart.addProduct(sampleProduct, 1);

        //then
        Summary summary = cart.getSummary();
        assertEquals(1, summary.getItems().size());
        assertEquals("offer-1", summary.getItems().get(0).getProduct().getProductId());
        assertEquals(10, summary.getTotalPrice());
    }

    @Test
    public void shouldRemoveOneOffer() {
        //given
        cart.addProduct(sampleProduct, 2);

        //when
        cart.removeProduct(sampleProduct, 1);

        //then
        Summary summary = cart.getSummary();
        assertEquals(1, summary.getItems().size());
        assertEquals("offer-1", summary.getItems().get(0).getProduct().getProductId());
        assertEquals(10, summary.getTotalPrice());
    }

    @Test
    public void shouldAddExtraServiceToOffer() {
        //given
        AdditionalService service = new AdditionalService("Gift packaging", 1);
        Product productWithService = anOffer("offer-1", 10, Collections.singletonList(service), Duration.ZERO);
        cart.addProduct(productWithService, 1);

        //when
        cart.addExtraService(productWithService, service);

        //then
        Summary summary = cart.getSummary();
        assertEquals(service.getName(), summary.getItems().get(0).getProduct().getServices().get(0).getName());
        assertEquals(11, summary.getTotalPrice());
    }

    @Test
    public void shouldAddExtraServiceToOffers() {
        //given
        AdditionalService service = new AdditionalService("Gift packaging", 1);
        Product productWithService = anOffer("offer-1", 10, Collections.singletonList(service), Duration.ZERO);
        cart.addProduct(productWithService, 2);

        //when
        cart.addExtraService(productWithService, service);

        //then
        Summary summary = cart.getSummary();
        assertEquals(service.getName(), summary.getItems().get(0).getProduct().getServices().get(0).getName());
        assertEquals(22, summary.getTotalPrice());
    }

    @Test
    public void shouldAddTwoExtraServicesToOffer() {
        //given
        AdditionalService giftPackaging = new AdditionalService("Gift packaging", 1);
        AdditionalService assemblyService = new AdditionalService("Assembly", 2);

        Product productWithService = anOffer("offer-1", 10, Arrays.asList(giftPackaging, assemblyService), Duration.ZERO);
        cart.addProduct(productWithService, 1);

        //when
        cart.addExtraService(productWithService, giftPackaging);
        cart.addExtraService(productWithService, assemblyService);

        //then
        Summary summary = cart.getSummary();
        assertEquals(2, summary.getItems().get(0).getAdditionalServices().size());
        assertEquals(13, summary.getItems().get(0).getPrice());
        assertEquals(13, summary.getTotalPrice());
    }

    @Test
    public void shouldAddDelivery() {
        //given
        Delivery delivery = new Delivery("Fast-ship inc.", 5, Duration.of(1, ChronoUnit.DAYS));
        cart.addProduct(sampleProduct, 1);

        //when
        cart.setDelivery(delivery);

        //then
        Summary summary = cart.getSummary();
        assertEquals(delivery.getPrice(), summary.getDelivery().getPrice());
        assertEquals(15, summary.getTotalPrice());
    }
}
