package befaster.solutions.CHL;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PriceService {
    private List<Offer> offers;

    // this all assumes this data would come from somewhere else and not the constructor...
    public PriceService() {
        this.offers = new ArrayList<>();
        this.offers.add(new Offer('A', 3, 130f));
        this.offers.add(new Offer('A', 5, 200f));
        this.offers.add(new Offer('B', 2, 45f));
    }

    public Optional<Offer> getOffer(Product product, int qty) {
        Offer chosenOffer = null;

        for (Offer offer : offers) {
            if (!offer.getSku().equals(product.getSku())) {
                continue;
            }

            if (offer.getQty() <= qty) {
                if (chosenOffer != null && chosenOffer.getOfferPrice() > offer.getOfferPrice()) {
                    continue;
                }
                chosenOffer = offer;
            }
        }

        return Optional.ofNullable(chosenOffer);
    }

    public Float getTotalProductPrice(Product product, int qty) {
        Optional<Offer> offer = getOffer(product, qty);
        float offerPrice = 0f;

        while (offer.isPresent()) {
            int qtyOnOffer = qty / offer.get().getQty();
            offerPrice += offer.get().getOfferPrice() * qtyOnOffer;
            qty = qty - (qtyOnOffer * offer.get().getQty());
            offer = getOffer(product, qty);
        }

        return offerPrice + product.getPrice() * qty;
    }
}





