package befaster.solutions.CHL;

import java.util.Objects;

public class Product {
    private Character sku;
    private Float price;

    public Product(Character sku, Float price) {
        this.sku = sku;
        this.price = price;
    }

    public Character getSku() {
        return sku;
    }

    public void setSku(Character sku) {
        this.sku = sku;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return sku.equals(product.sku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku);
    }
}

