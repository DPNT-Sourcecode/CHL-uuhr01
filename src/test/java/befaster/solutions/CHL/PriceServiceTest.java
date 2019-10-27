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
        assertThat(priceService.getOffer(productList.getProduct('A'), 2).isPresent(), is(false));
        assertThat(priceService.getOffer(productList.getProduct('A'), 3).get().getOfferPrice(), is(130f));
        assertThat(priceService.getOffer(productList.getProduct('A'), 4).get().getOfferPrice(), is(130f));
        assertThat(priceService.getOffer(productList.getProduct('A'), 5).get().getOfferPrice(), is(200f));
        assertThat(priceService.getOffer(productList.getProduct('A'), 6).get().getOfferPrice(), is(200f));
    }

    @Test
    public void getTotalProductPrice() {
        Product product = productList.getProduct('A');

        assertThat(priceService.getTotalProductPrice(product, 1), is(50f));
        assertThat(priceService.getTotalProductPrice(product, 2), is(100f));
        assertThat(priceService.getTotalProductPrice(product, 3), is(130f));
        assertThat(priceService.getTotalProductPrice(product, 4), is(180f));
        assertThat(priceService.getTotalProductPrice(product, 5), is(200f));
        assertThat(priceService.getTotalProductPrice(product, 6), is(250f));
        assertThat(priceService.getTotalProductPrice(product, 7), is(300f));
        assertThat(priceService.getTotalProductPrice(product, 8), is(330f));
        assertThat(priceService.getTotalProductPrice(product, 9), is(380f));
        assertThat(priceService.getTotalProductPrice(product, 10), is(400f));
        assertThat(priceService.getTotalProductPrice(product, 11), is(450f));
    }
}




