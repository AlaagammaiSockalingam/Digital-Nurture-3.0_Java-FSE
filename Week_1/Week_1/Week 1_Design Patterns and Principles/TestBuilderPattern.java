class Computer {
    private String cpu;
    private int ram;
    private int storage;
    private String gpu;
    private String os;

    // Private constructor to prevent direct instantiation
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.gpu = builder.gpu;
        this.os = builder.os;
    }

    // Static nested Builder class
    public static class Builder {
        private String cpu;
        private int ram;
        private int storage;
        private String gpu;
        private String os;

        // Mandatory parameters
        public Builder(String cpu, int ram) {
            this.cpu = cpu;
            this.ram = ram;
        }

        // Optional parameters
        public Builder withStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public Builder withGpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public Builder withOs(String os) {
            this.os = os;
            return this;
        }

        // build() method returns an instance of Computer
        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram=" + ram +
                ", storage=" + storage +
                ", gpu='" + gpu + '\'' +
                ", os='" + os + '\'' +
                '}';
    }
}

public class TestBuilderPattern {
    public static void main(String[] args) {
        // Create a basic computer with CPU and RAM
        Computer basicComputer = new Computer.Builder("Intel Core i5", 8)
                .build();
        System.out.println("Basic Computer: " + basicComputer);

        // Create a gaming computer with CPU, RAM, Storage, GPU, and OS
        Computer gamingComputer = new Computer.Builder("AMD Ryzen 9", 16)
                .withStorage(1024)
                .withGpu("NVIDIA GeForce RTX 3080")
                .withOs("Windows 11")
                .build();
        System.out.println("Gaming Computer: " + gamingComputer);
    }
}