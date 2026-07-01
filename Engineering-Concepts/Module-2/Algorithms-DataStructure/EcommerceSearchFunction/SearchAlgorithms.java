public class SearchAlgorithms {
    public static Product linearSearch(Product[] products, String target) {

        for(Product product: products) {
            if(product.productName.equalsIgnoreCase(target)) {
                return product;
            }
        }
        
        return null;
    }

    public static Product binarySearch(Product[] products, String target) {
        
        int low = 0;
        int high = products.length - 1;

        while(low <= high) {

            int mid =
                    low + (high - low) / 2;

            int comparison =
                    products[mid]
                            .productName
                            .compareToIgnoreCase(target);

            if(comparison == 0) {

                return products[mid];
            }

            else if(comparison < 0) {

                low = mid + 1;
            }

            else {

                high = mid - 1;
            }
        }

        return null;
    }
}
