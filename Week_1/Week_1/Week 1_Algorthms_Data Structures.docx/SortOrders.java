class Order {
    private int orderId;
    private String customerName;
    private double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}

public class SortOrders {
    public static void bubbleSortOrders(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    // Swap orders
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSortOrders(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSortOrders(orders, low, pi - 1);
            quickSortOrders(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        Order pivot = orders[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot.getTotalPrice()) {
                i++;
                // Swap orders
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        // Swap pivot with the element at the correct position
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    public static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println("Order ID: " + order.getOrderId() + ", Customer Name: " + order.getCustomerName()
                    + ", Total Price: " + order.getTotalPrice());
        }
    }

    public static void main(String[] args) {
        Order[] orders = new Order[] {
                new Order(1, "John Doe", 100.0),
                new Order(2, "Jane Doe", 50.0),
                new Order(3, "Bob Smith", 200.0),
                new Order(4, "Alice Johnson", 150.0),
                new Order(5, "Mike Brown", 75.0)
        };

        System.out.println("Before sorting:");
        printOrders(orders);

        System.out.println("Sorting using Bubble Sort:");
        bubbleSortOrders(orders);
        printOrders(orders);

        // Reset the orders array
        orders = new Order[] {
                new Order(1, "John Doe", 100.0),
                new Order(2, "Jane Doe", 50.0),
                new Order(3, "Bob Smith", 200.0),
                new Order(4, "Alice Johnson", 150.0),
                new Order(5, "Mike Brown", 75.0)
        };

        System.out.println("Sorting using Quick Sort:");
        quickSortOrders(orders, 0, orders.length - 1);
        printOrders(orders);
    }
}