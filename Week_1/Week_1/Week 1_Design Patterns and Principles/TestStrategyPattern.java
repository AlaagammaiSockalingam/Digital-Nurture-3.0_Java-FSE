// Strategy Interface
interface PaymentStrategy {
    void pay(double amount);
}

// Concrete Strategy
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;
    private String expirationDate;

    public CreditCardPayment(String cardNumber, String cardHolderName, String expirationDate) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expirationDate = expirationDate;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " using credit card " + cardNumber);
    }
}

// Concrete Strategy
class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " using PayPal account " + email);
    }
}

// Context Class
class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        paymentStrategy.pay(amount);
    }
}

// Test Class
public class TestStrategyPattern {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext(null);

        // Using credit card payment
        paymentContext.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456", "John Doe", "12/25"));
        paymentContext.executePayment(100.0);

        // Using PayPal payment
        paymentContext.setPaymentStrategy(new PayPalPayment("abc@example.com"));
        paymentContext.executePayment(200.0);
    }
}
