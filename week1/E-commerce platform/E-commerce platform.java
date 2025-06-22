import java.util.Arrays;
import java.util.Comparator;

class Product {
    private String productId;
    private String productName;
    private String category;
    private double price;

    public Product(String productId, String productName, String category, double price) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
    }

    // Getters
    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return String.format("ID: %-6s | Name: %-15s | Category: %-10s | Price: $%.2f",
                productId, productName, category, price);
    }
}

class ProductSearch {
    private Product[] products;
    private Product[] sortedProducts; // For binary search

    public ProductSearch(Product[] products) {
        this.products = products;
        // Create a sorted copy for binary search
        this.sortedProducts = Arrays.copyOf(products, products.length);
        Arrays.sort(sortedProducts, Comparator.comparing(Product::getProductId));
    }

    // Linear Search - O(n)
    public Product linearSearchById(String productId) {
        System.out.println("\nPerforming Linear Search for ID: " + productId);
        int comparisons = 0;
        for (Product product : products) {
            comparisons++;
            if (product.getProductId().equals(productId)) {
                System.out.println("Comparisons made: " + comparisons);
                return product;
            }
        }
        System.out.println("Comparisons made: " + comparisons);
        return null;
    }

  
    public Product binarySearchById(String productId) {
        System.out.println("\nPerforming Binary Search for ID: " + productId);
        int comparisons = 0;
        int left = 0;
        int right = sortedProducts.length - 1;

        while (left <= right) {
            comparisons++;
            int mid = left + (right - left) / 2;
            int comparisonResult = sortedProducts[mid].getProductId().compareTo(productId);

            if (comparisonResult == 0) {
                System.out.println("Comparisons made: " + comparisons);
                return sortedProducts[mid];
            } else if (comparisonResult < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("Comparisons made: " + comparisons);
        return null;
    }

    
    public void displayProducts() {
        System.out.println("\nAvailable Products:");
        for (Product product : products) {
            System.out.println(product);
        }
    }

 
    public void displaySortedProducts() {
        System.out.println("\nProducts Sorted by ID (for Binary Search):");
        for (Product product : sortedProducts) {
            System.out.println(product);
        }
    }
}

public class ECommerceSearch {
    public static void main(String[] args) {
        // Create sample products
        Product[] productArray = {
            new Product("P1003", "Wireless Mouse", "Electronics", 24.99),
            new Product("P1001", "Bluetooth Speaker", "Electronics", 59.99),
            new Product("P1005", "Mechanical Keyboard", "Electronics", 89.99),
            new Product("P1002", "Yoga Mat", "Fitness", 29.99),
            new Product("P1004", "Water Bottle", "Fitness", 12.99)
        };

        ProductSearch searchEngine = new ProductSearch(productArray);

        // Display products
        searchEngine.displayProducts();
        searchEngine.displaySortedProducts();

        // Search demonstrations
        System.out.println("\n--- Search Performance Comparison ---");

        // Best case scenario (first element)
        System.out.println("\n[Best Case Scenario - First Element]");
        Product linearResult1 = searchEngine.linearSearchById("P1001");
        System.out.println("Linear Search Result: " + linearResult1);
        Product binaryResult1 = searchEngine.binarySearchById("P1001");
        System.out.println("Binary Search Result: " + binaryResult1);

        // Average case scenario
        System.out.println("\n[Average Case Scenario]");
        Product linearResult2 = searchEngine.linearSearchById("P1003");
        System.out.println("Linear Search Result: " + linearResult2);
        Product binaryResult2 = searchEngine.binarySearchById("P1003");
        System.out.println("Binary Search Result: " + binaryResult2);

        // Worst case scenario (last element or not present)
        System.out.println("\n[Worst Case Scenario - Last Element]");
        Product linearResult3 = searchEngine.linearSearchById("P1005");
        System.out.println("Linear Search Result: " + linearResult3);
        Product binaryResult3 = searchEngine.binarySearchById("P1005");
        System.out.println("Binary Search Result: " + binaryResult3);

        // Not found scenario
        System.out.println("\n[Not Found Scenario]");
        Product linearResult4 = searchEngine.linearSearchById("P9999");
        System.out.println("Linear Search Result: " + linearResult4);
        Product binaryResult4 = searchEngine.binarySearchById("P9999");
        System.out.println("Binary Search Result: " + binaryResult4);

        // Complexity analysis
        System.out.println("\n--- Algorithm Analysis ---");
        System.out.println("Linear Search Time Complexity:");
        System.out.println("- Best case: O(1) (first element)");
        System.out.println("- Average case: O(n/2) ≈ O(n)");
        System.out.println("- Worst case: O(n) (last element or not present)");

        System.out.println("\nBinary Search Time Complexity:");
        System.out.println("- Best case: O(1) (middle element)");
        System.out.println("- Average case: O(log n)");
        System.out.println("- Worst case: O(log n)");

        System.out.println("\nRecommendation:");
        System.out.println("For an e-commerce platform with a large product catalog:");
        System.out.println("- Binary search is preferable for its O(log n) performance");
        System.out.println("- Requires initial sorting (O(n log n)) but worth the investment");
        System.out.println("- Consider using a hash-based structure (O(1)) if only searching by ID");
    }
}
