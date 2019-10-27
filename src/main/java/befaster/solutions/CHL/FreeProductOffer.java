package befaster.solutions.CHL;

public class FreeProductOffer {
    private Character sku;
    private int requiredQty;
    private Character offerSku;
    private int offerQty;

    public FreeProductOffer(Character sku, int requiredQty, Character offerSku, int offerQty) {
        this.sku = sku;
        this.requiredQty = requiredQty;
        this.offerSku = offerSku;
        this.offerQty = offerQty;
    }

    public Character getSku() {
        return sku;
    }

    public void setSku(Character sku) {
        this.sku = sku;
    }

    public int getRequiredQty() {
        return requiredQty;
    }

    public void setRequiredQty(int requiredQty) {
        this.requiredQty = requiredQty;
    }

    public Character getOfferSku() {
        return offerSku;
    }

    public void setOfferSku(Character offerSku) {
        this.offerSku = offerSku;
    }

    public int getOfferQty() {
        return offerQty;
    }

    public void setOfferQty(int offerQty) {
        this.offerQty = offerQty;
    }
}
