public class BuilderPatternTest {
    public static void main(String[] args) {

        Computer computer = new Computer.Builder()
                .setCpu("Intel i5")
                .setRam("8GB")
                .setStorage("512GB SSD")
                .build();
                
        computer.showSpecs();
    }
}