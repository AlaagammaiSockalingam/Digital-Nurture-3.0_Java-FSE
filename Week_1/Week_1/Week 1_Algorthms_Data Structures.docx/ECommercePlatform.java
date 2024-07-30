import java.util.Arrays;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Product Name: " + productName + ", Category: " + category;
    }
}

public class ECommercePlatform {
    public static Product linearSearch(Product[] products, String target) {
        for (Product product : products) {
            if (product.productName.equals(target)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String target) {
        Arrays.sort(products, (p1, p2) -> p1.productName.compareTo(p2.productName));
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (products[mid].productName.equals(target)) {
                return products[mid];
            } else if (products[mid].productName.compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Create products
        Product product1 = new Product(1, "Apple Watch", "Electronics");
        Product product2 = new Product(2, "Samsung TV", "Electronics");
        Product product3 = new Product(3, "Nike Shoes", "Fashion");
        Product product4 = new Product(4, "Adidas Jacket", "Fashion");
        Product product5 = new Product(5, "Sony Headphones", "Electronics");

        // Store products in an array for linear search
        Product[] linearSearchProducts = { product1, product2, product3, product4, product5 };

        // Store products in a sorted array for binary search
        Product[] binarySearchProducts = { product1, product2, product3, product4, product5 };
        Arrays.sort(binarySearchProducts, (p1, p2) -> p1.productName.compareTo(p2.productName));

        // Test linear search
        String targetProduct = "Nike Shoes";
        Product result = linearSearch(linearSearchProducts, targetProduct);
        if (result != null) {
            System.out.println("Linear search found: " + result);
        } else {
            System.out.println("Linear search did not find " + targetProduct);
        }

        // Test binary search
        targetProduct = "Samsung TV";
        result = binarySearch(binarySearchProducts, targetProduct);
        if (result != null) {
            System.out.println("Binary search found: " + result);
        } else {
            System.out.println("Binary search did not find " + targetProduct);
        }
    }
}