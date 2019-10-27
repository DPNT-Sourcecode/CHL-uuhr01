package befaster.solutions.CHL;

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
}


