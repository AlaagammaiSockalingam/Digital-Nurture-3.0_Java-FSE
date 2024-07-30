// Subject Interface
interface Image {
    void display();
}

// Real Subject Class
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading " + filename);
        // Simulate loading image from remote server
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void display() {
        System.out.println("Displaying " + filename);
    }
}

// Proxy Class
class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;
    private boolean isLoaded = false;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (!isLoaded) {
            realImage = new RealImage(filename);
            isLoaded = true;
        }
        realImage.display();
    }
}

// Test Class
public class TestProxyPattern {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        // Image will be loaded and displayed only when display() is called
        image1.display();
        image1.display(); // Loaded image will be displayed from cache
        image2.display();
    }
}