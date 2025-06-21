

class Computer {
  
    private final String CPU;
    private final String RAM;

  
    private final String storage;
    private final String graphicsCard;
    private final boolean hasWiFi;


    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.hasWiFi = builder.hasWiFi;
    }

    
    public static class Builder {
        private final String CPU;
        private final String RAM;
        private String storage = "256GB SSD"; // default
        private String graphicsCard = "Integrated";
        private boolean hasWiFi = false;

        public Builder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder setWiFiEnabled(boolean hasWiFi) {
            this.hasWiFi = hasWiFi;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    public void displayConfig() {
        System.out.println("Computer Configuration:");
        System.out.println("CPU: " + CPU);
        System.out.println("RAM: " + RAM);
        System.out.println("Storage: " + storage);
        System.out.println("Graphics Card: " + graphicsCard);
        System.out.println("WiFi Enabled: " + hasWiFi);
        System.out.println("--------------------------");
    }
}

public class BuilderPatternExample {
    public static void main(String[] args) {
        
        Computer basicComputer = new Computer.Builder("Intel i3", "4GB")
            .build();

      
        Computer gamingComputer = new Computer.Builder("Intel i7", "16GB")
            .setStorage("1TB SSD")
            .setGraphicsCard("NVIDIA RTX 3060")
            .setWiFiEnabled(true)
            .build();

      
        Computer officeComputer = new Computer.Builder("AMD Ryzen 5", "8GB")
            .setStorage("512GB SSD")
            .setWiFiEnabled(true)
            .build();

        
        basicComputer.displayConfig();
        gamingComputer.displayConfig();
        officeComputer.displayConfig();
    }
}
