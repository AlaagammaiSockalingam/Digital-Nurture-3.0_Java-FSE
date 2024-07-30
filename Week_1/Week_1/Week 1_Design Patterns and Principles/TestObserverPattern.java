import java.util.List;
import java.util.ArrayList;

// Subject Interface
interface Stock {
    void registerObserver(Observer observer);

    void deregisterObserver(Observer observer);

    void notifyObservers();
}

// Concrete Subject
class StockMarket implements Stock {
    private List<Observer> observers;
    private double stockPrice;

    public StockMarket() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockPrice);
        }
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
        notifyObservers();
    }
}

// Observer Interface
interface Observer {
    void update(double stockPrice);
}

// Concrete Observer
class MobileApp implements Observer {
    @Override
    public void update(double stockPrice) {
        System.out.println("Mobile App: Received update. New stock price is " + stockPrice);
    }
}

// Concrete Observer
class WebApp implements Observer {
    @Override
    public void update(double stockPrice) {
        System.out.println("Web App: Received update. New stock price is " + stockPrice);
    }
}

// Test Class
public class TestObserverPattern {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setStockPrice(100.0);

        stockMarket.deregisterObserver(webApp);

        stockMarket.setStockPrice(150.0);
    }
}