import java.util.HashMap;
import java.util.Map;

class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

    public void setProductName(String productName) { this.productName = productName; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return String.format("ID: %s, Name: %s, Quantity: %d, Price: $%.2f",
                productId, productName, quantity, price);
    }
}

class InventoryManager {
    private Map<String, Product> inventory;

    public InventoryManager() {
  
        inventory = new HashMap<>();
    }

   
    public void addProduct(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            System.out.println("Product with ID " + product.getProductId() + " already exists.");
        } else {
            inventory.put(product.getProductId(), product);
            System.out.println("Product added: " + product);
        }
    }

  
    public void updateProduct(String productId, String newName, int newQuantity, double newPrice) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.setProductName(newName);
            product.setQuantity(newQuantity);
            product.setPrice(newPrice);
            System.out.println("Product updated: " + product);
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

   
    public void deleteProduct(String productId) {
        if (inventory.remove(productId) != null) {
            System.out.println("Product with ID " + productId + " removed.");
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

  
    public Product getProduct(String productId) {
        return inventory.get(productId);
    }

    public void displayInventory() {
        System.out.println("\nCurrent Inventory:");
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            inventory.values().forEach(System.out::println);
        }
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

       
        manager.addProduct(new Product("P100", "Laptop", 50, 999.99));
        manager.addProduct(new Product("P200", "Smartphone", 100, 699.99));
        manager.addProduct(new Product("P300", "Headphones", 200, 149.99));

      
        manager.displayInventory();

     
        manager.updateProduct("P200", "Premium Smartphone", 80, 799.99);

      
        manager.addProduct(new Product("P100", "Tablet", 30, 399.99));

        manager.deleteProduct("P300");

      
        manager.displayInventory();

      
        System.out.println("\nOperation Time Complexities:");
        System.out.println("Add: O(1) average case");
        System.out.println("Update: O(1) average case");
        System.out.println("Delete: O(1) average case");
        System.out.println("Search: O(1) average case");
        System.out.println("Display All: O(n)");
    }
}
