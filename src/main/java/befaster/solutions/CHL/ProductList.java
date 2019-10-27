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
        this.addProduct('G', 20f);
        this.addProduct('H', 10f);
        this.addProduct('I', 35f);
        this.addProduct('J', 60f);
        this.addProduct('K', 80f);
        this.addProduct('L', 90f);
        this.addProduct('M', 15f);
        this.addProduct('N', 40f);
        this.addProduct('O', 10f);
        this.addProduct('P', 50f);
        this.addProduct('Q', 30f);
        this.addProduct('R', 50f);
        this.addProduct('S', 30f);
        this.addProduct('T', 20f);
        this.addProduct('U', 40f);
        this.addProduct('V', 50f);
        this.addProduct('W', 20f);
        this.addProduct('X', 90f);
        this.addProduct('Y', 10f);
        this.addProduct('Z', 50f);
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

