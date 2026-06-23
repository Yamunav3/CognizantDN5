import java.util.*;

public class ProductSearch {
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product p : products) { // visit every element
            if (p.getProductId() == targetId) {
                return p; // found — early exit
            }
        }
        return null; // not found
    }

    public static Product binarySearch(Product[] sortedProducts, int targetId) {
        int low = 0;
        int high = sortedProducts.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // avoids integer overflow by using low+high/2
            int midId = sortedProducts[mid].getProductId();

            if (midId == targetId) {
                return sortedProducts[mid]; // exact match
            } else if (midId < targetId) {
                low = mid + 1; // target in right half
            } else {
                high = mid - 1; // target in left half
            }
        }
        return null; // not found
    }

    public static void main(String[] args) {

        Product[] catalogue = {
                new Product(104, "Wireless Mouse", "Electronics"),
                new Product(201, "Running Shoes", "Footwear"),
                new Product(033, "Java Programming", "Books"),
                new Product(155, "Coffee Maker", "Kitchen"),
                new Product(900, "Yoga Mat", "Sports"),
                new Product(312, "Bluetooth Speaker", "Electronics"),
                new Product(007, "Notebook", "Stationery"),
                new Product(250, "Laptop Stand", "Electronics"),
        };
        Product[] sortedCatalogue = catalogue.clone();
        Arrays.sort(sortedCatalogue); // sorts by productId (compareTo)

        System.out.println("=== E-commerce Platform Search Demo ===\n");

        // --- Linear Search tests ------------------------------
        int[] testIds = { 155, 007, 999 };

        System.out.println("-- Linear Search --");
        for (int id : testIds) {
            Product result = linearSearch(catalogue, id);
            System.out.printf("  Search ID %03d → %s%n", id,
                    result != null ? result : "NOT FOUND");
        }

        // --- Binary Search tests ------------------------------
        System.out.println("\n-- Binary Search (sorted array) --");
        System.out.println("  Sorted order: ");
        for (Product p : sortedCatalogue) {
            System.out.printf("    %s%n", p);
        }
        System.out.println();

        for (int id : testIds) {
            Product result = binarySearch(sortedCatalogue, id);
            System.out.printf("  Search ID %03d → %s%n", id,
                    result != null ? result : "NOT FOUND");
        }

        // --- Complexity summary -------------------------------
        System.out.println("\n=== Time-Complexity Summary ===");
        System.out.println("  Algorithm      | Best  | Average | Worst");
        System.out.println("  ---------------|-------|---------|------");
        System.out.println("  Linear Search  | O(1)  | O(n)    | O(n) ");
        System.out.println("  Binary Search  | O(1)  | O(log n)| O(log n)");

    }

}
