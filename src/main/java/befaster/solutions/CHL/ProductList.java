package befaster.solutions.CHL;

import java.util.HashMap;
import java.util.Map;

public class ProductList {
    private Map<Character, Product> products;

    public ProductList() {
        this.products = new HashMap<>();
        this.addProduct('A', 50f);
        this.addProduct('B', 30f);
        this.addProduct('C', 20f);
        this.addProduct('D', 15f);
        this.addProduct('E', 40f);
        this.addProduct('F', 10f);
    }

    public void addProduct(Character sku, Float price) {
        this.products.put(sku, new Product(sku, price));
    }

    public boolean isProduct(Character sku) {
        return products.containsKey(sku);
    }

    public Product getProduct(Character sku) {
        return products.getOrDefault(sku, null);
    }
}
