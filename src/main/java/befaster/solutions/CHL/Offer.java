package befaster.solutions.CHL;

public class Offer {

    // this could have been Product...
    private Character sku;

    private int qty;

    private Float offerPrice;

    public Offer(Character sku, int qty, Float offerPrice) {
        this.sku = sku;
        this.qty = qty;
        this.offerPrice = offerPrice;
    }

    public Character getSku() {
        return sku;
    }

    public void setSku(Character sku) {
        this.sku = sku;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Float getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(Float offerPrice) {
        this.offerPrice = offerPrice;
    }
}
