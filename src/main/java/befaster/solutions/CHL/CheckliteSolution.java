package befaster.solutions.CHL;

import befaster.runner.SolutionNotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class CheckliteSolution {

    private ProductList productList;

    public CheckliteSolution() {
        this.productList = new ProductList();
    }

    public Float checklite(String skus) {
        Float cart = 0f;
        String testSkus = skus.toUpperCase();

        // count products by sku
        // check price (with offer) for sku


        for (int i = 0; i < testSkus.length(); i++) {
            Character sku = testSkus.charAt(i);


            Product product = productList.getProduct(sku);
            if (product != null) {
                cart += product.getPrice();
            } else {
                return -1f;
            }
        }

        return cart;
    }
}

