
//  Test Class
public class Main {

    public static void main(String[] args) {

        System.out.println("===== Factory Method Pattern - Document Management System =====");

        DocumentFactory factory;

        factory = new WordDocumentFactory();
        factory.handleDocument();

        factory = new PdfDocumentFactory();
        factory.handleDocument();

        factory = new ExcelDocumentFactory();
        factory.handleDocument();

        System.out.println("\nAll documents created successfully using Factory Method Pattern!");
    }
}