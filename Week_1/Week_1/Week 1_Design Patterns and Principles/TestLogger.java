class Logger {
    // Step 1: Create a private static instance of the class
    private static Logger instance;

    // Step 2: Make the constructor private to prevent instantiation
    private Logger() {

    }

    // Step 3: Provide a public static method to get the instance of the class
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

public class TestLogger {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        System.out.println("Are logger1 and logger2 the same instance? " + (logger1 == logger2));
        logger1.log("Hello, world!");
        logger2.log("This is another log message.");
    }
}