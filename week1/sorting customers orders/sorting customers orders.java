import java.util.Arrays;

class Order {
    private String orderId;
    private String customerName;
    private double totalPrice;

    public Order(String orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    // Getters
    public String getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public double getTotalPrice() { return totalPrice; }

    @Override
    public String toString() {
        return String.format("Order ID: %-6s | Customer: %-15s | Total: $%,8.2f",
                orderId, customerName, totalPrice);
    }
}

class OrderSorter {
    // Bubble Sort implementation - O(n²)
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (orders[j].getTotalPrice() > orders[j+1].getTotalPrice()) {
                    // Swap orders[j] and orders[j+1]
                    Order temp = orders[j];
                    orders[j] = orders[j+1];
                    orders[j+1] = temp;
                }
            }
        }
    }

    // Quick Sort implementation - O(n log n) average case
    public static void quickSort(Order[] orders) {
        quickSort(orders, 0, orders.length - 1);
    }

    private static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);

            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() < pivot) {
                i++;
                // Swap orders[i] and orders[j]
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        // Swap orders[i+1] and orders[high] (pivot)
        Order temp = orders[i+1];
        orders[i+1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    // Helper method to display orders
    public static void displayOrders(String title, Order[] orders) {
        System.out.println("\n" + title);
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}

public class OrderSortingSystem {
    public static void main(String[] args) {
        // Create sample orders
        Order[] orders = {
            new Order("O1001", "John Smith", 1250.50),
            new Order("O1002", "Emma Johnson", 450.75),
            new Order("O1003", "Michael Brown", 3200.00),
            new Order("O1004", "Sarah Davis", 875.25),
            new Order("O1005", "David Wilson", 150.00)
        };

        // Make copies for each sorting algorithm
        Order[] ordersForBubbleSort = Arrays.copyOf(orders, orders.length);
        Order[] ordersForQuickSort = Arrays.copyOf(orders, orders.length);

        // Display original orders
        OrderSorter.displayOrders("Original Orders (Unsorted):", orders);

        // Bubble Sort demonstration
        System.out.println("\n--- Bubble Sort ---");
        long bubbleStartTime = System.nanoTime();
        OrderSorter.bubbleSort(ordersForBubbleSort);
        long bubbleEndTime = System.nanoTime();
        OrderSorter.displayOrders("After Bubble Sort (Ascending by Total Price):", ordersForBubbleSort);
        System.out.printf("Bubble Sort executed in %d nanoseconds\n", bubbleEndTime - bubbleStartTime);

        // Quick Sort demonstration
        System.out.println("\n--- Quick Sort ---");
        long quickStartTime = System.nanoTime();
        OrderSorter.quickSort(ordersForQuickSort);
        long quickEndTime = System.nanoTime();
        OrderSorter.displayOrders("After Quick Sort (Ascending by Total Price):", ordersForQuickSort);
        System.out.printf("Quick Sort executed in %d nanoseconds\n", quickEndTime - quickStartTime);

        // Algorithm analysis
        System.out.println("\n--- Sorting Algorithm Analysis ---");
        System.out.println("Bubble Sort:");
        System.out.println("- Time Complexity: O(n²) in all cases (worst, average, best)");
        System.out.println("- Space Complexity: O(1) (in-place sorting)");
        System.out.println("- Stable: Yes (maintains relative order of equal elements)");
        System.out.println("- Adaptive: Yes (efficient for nearly sorted data)");

        System.out.println("\nQuick Sort:");
        System.out.println("- Time Complexity: O(n log n) average case, O(n²) worst case");
        System.out.println("- Space Complexity: O(log n) (stack space for recursion)");
        System.out.println("- Stable: Typically no (standard implementations are unstable)");
        System.out.println("- Adaptive: No");

        System.out.println("\nWhy Quick Sort is generally preferred:");
        System.out.println("1. Faster average case performance (O(n log n) vs Bubble Sort's O(n²))");
        System.out.println("2. More efficient for large datasets");
        System.out.println("3. Cache-efficient due to good locality of reference");
        System.out.println("4. In practice, rarely hits worst-case O(n²) with proper pivot selection");
        System.out.println("5. Widely used in standard libraries (Arrays.sort() in Java uses a variant)");

        System.out.println("\nWhen Bubble Sort might be preferred:");
        System.out.println("- Extremely small datasets");
        System.out.println("- When simplicity of implementation is more important than performance");
        System.out.println("- When working with nearly sorted data (adaptive property)");
    }
}
