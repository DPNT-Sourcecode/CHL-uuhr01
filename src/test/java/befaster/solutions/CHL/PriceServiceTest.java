package befaster.solutions.CHL;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PriceServiceTest {

    PriceService priceService;
    ProductList productList;

    @Before
    public void setup() {
        priceService = new PriceService();
        productList = new ProductList();
    }

    @Test
    public void getOffer() {
        Optional<Offer> offer = priceService.getOffer(productList.getProduct('A'));
        assertThat(offer.isPresent(), is(true));

        assertThat(offer.get().getOfferPrice(), is(130f));
    }

    @Test
    public void getTotalProductPrice() {
        Product product = productList.getProduct('A');

        assertThat(priceService.getTotalProductPrice(product, 1), is(50f));
        assertThat(priceService.getTotalProductPrice(product, 2), is(100f));
        assertThat(priceService.getTotalProductPrice(product, 3), is(130f));
        assertThat(priceService.getTotalProductPrice(product, 4), is(180f));
        assertThat(priceService.getTotalProductPrice(product, 5), is(230f));
        assertThat(priceService.getTotalProductPrice(product, 6), is(260f));
    }
}
