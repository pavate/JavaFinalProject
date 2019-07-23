

package bookdatabase;

/**
 *
 * @author acer
 */
public class Books {
    private int ISBN;
    private String title;
     private String author;
    private String publisher;
    private int edition;
    private String category;

    public Books(int ISBN, String title, String author, String publisher, int edition, String category) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.edition = edition;
        this.category = category;
    }

    public Books() {
    }
    @Override()
    public String toString() {
         String format = "%s     (   %s    )  ,       QOH: %s       Price:     %s ";
        return String.format(format, author, title,category, publisher);
    }
   
    

}
