//Abstract Creator
public abstract class DocumentFactory {
    public abstract Document createDocument();   // factory method

    public void handleDocument() {
        Document doc = createDocument();
        System.out.println("\n--- " + doc.getType() + " ---");
        doc.open();
        doc.save();
    }
}