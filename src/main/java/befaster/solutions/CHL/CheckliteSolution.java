package befaster.solutions.CHL;

import befaster.runner.SolutionNotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class CheckliteSolution {

    private ProductList productList;

    public CheckliteSolution() {
        this.productList = new ProductList();
    }

    public Integer checklite(String skus) {
        int count = 0;
        String testSkus = skus.toUpperCase();

        for (int i = 0; i < testSkus.length(); i++) {
            Character sku = testSkus.charAt(i);
            if (productList.isProduct(sku)) {
                count++;
            } else {
                return -1;
            }
        }

        return count;
    }
}
