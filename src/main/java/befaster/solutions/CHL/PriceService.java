package befaster.solutions.CHL;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PriceService {
    private ProductList productList;
    private List<Offer> offers;

    // this all assumes this data would come from somewhere else and not the constructor...
    public PriceService() {
        this.productList = new ProductList();
        this.offers = new ArrayList<>();
        this.offers.add(new Offer('A', 3, 130f));
        this.offers.add(new Offer('B', 2, 45f));
    }

    public Optional<Offer> getOffer(Product product) {
        return offers.stream()
                .filter(offer -> offer.getSku().equals(product.getSku()))
                .findFirst();
    }

    public Float getTotalProductPrice(Product product, int qty) {
        Optional<Offer> offer = getOffer(product);
        float offerPrice = 0f;

        if (offer.isPresent()) {
            int qtyOnOffer = qty / offer.get().getQty();
            offerPrice += offer.get().getOfferPrice() * qtyOnOffer;
            qty = qty - (qtyOnOffer * offer.get().getQty());
        }

        return offerPrice + product.getPrice() * qty;
    }
}

