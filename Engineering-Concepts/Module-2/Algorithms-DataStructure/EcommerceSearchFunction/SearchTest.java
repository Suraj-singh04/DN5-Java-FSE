public class SearchTest {

    public static void main(String[] args) {

        Product[] products = {

            new Product(
                    1,
                    "Apple",
                    "Electronics"),

            new Product(
                    2,
                    "Keyboard",
                    "Electronics"),

            new Product(
                    3,
                    "Laptop",
                    "Electronics"),

            new Product(
                    4,
                    "Monitor",
                    "Electronics"),

            new Product(
                    5,
                    "Speaker",
                    "Electronics")
        };

        Product result1 =
                SearchAlgorithms
                        .linearSearch(
                                products,
                                "Monitor"
                        );

        if(result1 != null) {

            System.out.println(
                    "Linear Search Found: "
                            + result1.productName
            );
        }

        Product result2 =
                SearchAlgorithms
                        .binarySearch(
                                products,
                                "Monitor"
                        );

        if(result2 != null) {

            System.out.println(
                    "Binary Search Found: "
                            + result2.productName
            );
        }
    }
}