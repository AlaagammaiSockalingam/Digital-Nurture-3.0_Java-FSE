import java.util.HashMap;
import java.util.Map;

class Product {
    private int productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
};

public class InventoryManagementSystem {
    private Map<Integer, Product> products;

    public InventoryManagementSystem() {
        this.products = new HashMap<>();
    }

    // Add a new product to the inventory
    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    // Update an existing product in the inventory
    public void updateProduct(Product product) {
        if (products.containsKey(product.getProductId())) {
            products.put(product.getProductId(), product);
        } else {
            System.out.println("Product not found in inventory.");
        }
    }

    // Delete a product from the inventory
    public void deleteProduct(int productId) {
        if (products.containsKey(productId)) {
            products.remove(productId);
        } else {
            System.out.println("Product not found in inventory.");
        }
    }

    // Print all products in the inventory
    public void printInventory() {
        for (Product product : products.values()) {
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Quantity: " + product.getQuantity());
            System.out.println("Price: " + product.getPrice());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem inventory = new InventoryManagementSystem();

        // Add some products to the inventory
        inventory.addProduct(new Product(1, "Apple iPhone", 10, 999.99));
        inventory.addProduct(new Product(2, "Samsung TV", 5, 1299.99));
        inventory.addProduct(new Product(3, "Nike Shoes", 20, 79.99));

        // Print the initial inventory
        System.out.println("Initial Inventory:");
        inventory.printInventory();

        // Update a product
        Product updatedProduct = new Product(2, "Samsung TV", 10, 1499.99);
        inventory.updateProduct(updatedProduct);

        // Print the updated inventory
        System.out.println("Updated Inventory:");
        inventory.printInventory();

        // Delete a product
        inventory.deleteProduct(1);

        // Print the final inventory
        System.out.println("Final Inventory:");
        inventory.printInventory();
    }
}