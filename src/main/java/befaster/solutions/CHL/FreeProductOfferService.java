package befaster.solutions.CHL;

import java.util.*;

public class FreeProductOfferService {
    private List<FreeProductOffer> freeProductOffers;
    private ProductList productList; // dependency on product list should be moved out

    public FreeProductOfferService() {
        this.productList = new ProductList();
        this.freeProductOffers = new ArrayList<>();
        this.freeProductOffers.add(new FreeProductOffer('E', 2, 'B', 1));
        this.freeProductOffers.add(new FreeProductOffer('F', 3, 'F', 1));
        this.freeProductOffers.add(new FreeProductOffer('N', 3, 'M', 1));
        this.freeProductOffers.add(new FreeProductOffer('R', 3, 'Q', 1));
        this.freeProductOffers.add(new FreeProductOffer('U', 4, 'U', 1));
    }

    public Optional<FreeProductOffer> getFreeProductOffer(Character sku, int requiredQty) {
        for (FreeProductOffer freeProductOffer : freeProductOffers) {
            if (freeProductOffer.getSku().equals(sku) && requiredQty >= freeProductOffer.getRequiredQty()) {
                return Optional.of(freeProductOffer);
            }
        }

        return Optional.empty();
    }

    public Map<Product, Integer> getDiscountedCart(final Map<Product, Integer> cart) {
        Map<Product, Integer> newCart = new HashMap<>();

        for (Map.Entry<Product, Integer> cartProduct : cart.entrySet()) {
            Product product = cartProduct.getKey();

            if (newCart.containsKey(product)) {
                // product already processed
                continue;
            }

            Integer qty = cartProduct.getValue();

            Optional<FreeProductOffer> freeProductOffer = getFreeProductOffer(product.getSku(), qty);

            if (freeProductOffer.isPresent() && qty >= freeProductOffer.get().getRequiredQty()) {
                Product freeProduct = productList.getProduct(freeProductOffer.get().getOfferSku());

                if (cart.containsKey(freeProduct)) {
                    // 4 E == 2B free
                    int eligibleOfferCount = qty / freeProductOffer.get().getRequiredQty();

                    // we will get this amount of free product
                    int qtyFree = eligibleOfferCount * freeProductOffer.get().getOfferQty();
                    int qtyToPay = cart.get(freeProduct) - qtyFree;
                    if (qtyToPay < 0) {
                        qtyToPay = 0;
                    }

                    newCart.put(freeProduct, qtyToPay);
                }
            }

            if (!newCart.containsKey(product)) {
                newCart.put(product, qty);
            }
        }

        return newCart;
    }
}

