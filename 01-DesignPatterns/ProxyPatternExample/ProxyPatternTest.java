public class ProxyPatternTest {

    public static void main(String[] args) {

        Image image =
            new ProxyImage("cat.jpg");

        image.display();

        System.out.println();

        image.display();
    }
}