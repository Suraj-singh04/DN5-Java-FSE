public class Test {
    public static void main(String[] args) {

        DocumentFactory factory;

        factory = new WordFactory();
        factory = new PdfFactory();

        Document document = factory.createDocument();

        document.open();
    }
}