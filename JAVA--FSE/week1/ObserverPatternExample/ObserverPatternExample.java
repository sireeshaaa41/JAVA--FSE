
interface Stock {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
}
interface Observer {
    void update(String stockName, double price);
}
}
import java.util.ArrayList;
import java.util.List;

class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double stockPrice;

    public void setStockPrice(String stockName, double price) {
        this.stockName = stockName;
        this.stockPrice = price;
        notifyObservers();
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(stockName, stockPrice);
        }
    }
}


class MobileApp implements Observer {
    private String user;

    public MobileApp(String user) {
        this.user = user;
    }

    public void update(String stockName, double price) {
        System.out.println("MobileApp [" + user + "] - " + stockName + " price updated to ₹" + price);
    }
}

class WebApp implements Observer {
    private String user;

    public WebApp(String user) {
        this.user = user;
    }

    public void update(String stockName, double price) {
        System.out.println("WebApp [" + user + "] - " + stockName + " price updated to ₹" + price);
    }
}
public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        Observer mobileUser = new MobileApp("Alice");
        Observer webUser = new WebApp("Bob");

        market.registerObserver(mobileUser);
        market.registerObserver(webUser);

        market.setStockPrice("TCS", 3500.0);
        market.setStockPrice("INFY", 1480.5);

        
        market.removeObserver(mobileUser);

        market.setStockPrice("WIPRO", 450.75);
    }
}
