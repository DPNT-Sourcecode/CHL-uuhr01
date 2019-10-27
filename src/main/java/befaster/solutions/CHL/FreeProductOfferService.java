package befaster.solutions.CHL;

import java.util.*;

public class FreeProductOfferService {
    private List<FreeProductOffer> freeProductOffers;
    private ProductList productList; // dependency on product list should be moved out

    public FreeProductOfferService() {
        this.productList = new ProductList();
        this.freeProductOffers = new ArrayList<>();
        this.freeProductOffers.add(new FreeProductOffer('E', 2, 'B', 1));
    }

    public Optional<FreeProductOffer> getFreeProductOffer(Character sku, int requiredQty) {
        for (FreeProductOffer freeProductOffer : freeProductOffers) {
            if (freeProductOffer.getSku().equals(sku) && freeProductOffer.getRequiredQty() == requiredQty) {
                return Optional.of(freeProductOffer);
            }
        }

        return Optional.empty();
    }

    /**
     * discount price is the amount of money that you can discount _if_ you have the discounted product in your cart
     *
     * @param cart
     * @return
     */
    public Float getPriceDiscount(final Map<Product, Integer> cart) {
        Float discount = 0f;

        for (Map.Entry<Product, Integer> cartProduct : cart.entrySet()) {
            Product product = cartProduct.getKey();
            Integer qty = cartProduct.getValue();
            Integer eligibleOfferCount = 0;

            Optional<FreeProductOffer> freeProductOffer = getFreeProductOffer(product.getSku(), qty);
            if (!freeProductOffer.isPresent()) {
                continue;
            }

            if (qty < freeProductOffer.get().getRequiredQty()) {
                continue;
            }


            if (cart.containsKey(freeProductOffer.get().getOfferSku())) {
                // 4 E == 2B free
                eligibleOfferCount = qty / freeProductOffer.get().getRequiredQty();

                int freeQty = qty - (eligibleOfferCount * freeProductOffer.get().getOfferQty());
                if (freeQty < 0) {
                    freeQty = 0;
                }

                // we have 4 in B, 2 will be free
                discount += (productList.getProduct(freeProductOffer.get().getOfferSku()).getPrice() * freeQty);
            }

        }

        return discount;
    }
}
