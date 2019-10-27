package befaster.solutions.CHL;

import befaster.runner.SolutionNotImplementedException;

import java.util.HashMap;
import java.util.Map;

public class CheckliteSolution {

    private ProductList productList;
    private PriceService priceService;
    private FreeProductOfferService freeProductOfferService;

    public CheckliteSolution() {
        this.productList = new ProductList();
        this.priceService = new PriceService();
        this.freeProductOfferService = new FreeProductOfferService();
    }

    public Float checklite(String skus) {
        Float cartPrice = 0f;

        Map<Product, Integer> cart = new HashMap<>();

        for (int i = 0; i < skus.length(); i++) {
            Character sku = skus.charAt(i);

            Product product = productList.getProduct(sku);
            if (product == null) {
                return -1f;
            }

            cart.put(product, cart.getOrDefault(product, 0) + 1);
        }

        // we need to remove the qty for free product offers from the cart
        cart = freeProductOfferService.getDiscountedCart(cart);

        for (Map.Entry<Product, Integer> cartProduct : cart.entrySet()) {
            cartPrice += priceService.getTotalProductPrice(cartProduct.getKey(), cartProduct.getValue());
        }

        return cartPrice;
    }
}

