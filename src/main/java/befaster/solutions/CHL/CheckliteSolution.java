package befaster.solutions.CHL;

import befaster.runner.SolutionNotImplementedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckliteSolution {

    private ProductList productList;
    private PriceService priceService;

    public CheckliteSolution() {
        this.productList = new ProductList();
        this.priceService = new PriceService();
    }

    public Float checklite(String skus) {
        Float cartPrice = 0f;

        Map<Product, Integer> cartProducts = new HashMap<>();

        for (int i = 0; i < skus.length(); i++) {
            Character sku = skus.charAt(i);

            Product product = productList.getProduct(sku);
            if (product == null) {
                return -1f;
            }

            cartProducts.put(product, cartProducts.getOrDefault(product, 0) + 1);
        }

        for (Map.Entry<Product, Integer> cartProduct : cartProducts.entrySet()) {
            cartPrice += priceService.getTotalProductPrice(cartProduct.getKey(), cartProduct.getValue());
        }

        return cartPrice;
    }
}
