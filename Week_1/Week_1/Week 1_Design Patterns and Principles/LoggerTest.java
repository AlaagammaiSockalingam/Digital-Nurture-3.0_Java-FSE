
class Logger {
    // Private static instance of Logger
    private static Logger instance;

    // Private constructor to prevent instantiation
    private Logger() {
    }

    // Public static method to get the instance of Logger
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // Logging method (example)
    public void log(String message) {
        System.out.println("Logger: " + message);
    }
}

public class LoggerTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Verify that both logger1 and logger2 are the same instance
        System.out.println("Logger 1: " + logger1);
        System.out.println("Logger 2: " + logger2);

        // Log some messages using both instances
        logger1.log("Hello from logger 1!");
        logger2.log("Hello from logger 2!");
    }
}