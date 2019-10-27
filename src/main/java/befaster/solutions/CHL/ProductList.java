package befaster.solutions.CHL;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
    private List<Product> products;

    public ProductList() {
        this.products = new ArrayList<>();
        this.products.add(new Product('A', 50f));
        this.products.add(new Product('B', 30f));
        this.products.add(new Product('C', 20f));
        this.products.add(new Product('D', 10f));
    }

    public boolean isProduct(Character sku) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getSku().equals(sku)) {
                return true;
            }
        }

        return false;
    }
}

