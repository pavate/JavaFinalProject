

package bookdatabase;

/**
 *
 * @author acer
 */
public class Books {
    private int ISBN;
    private String title;

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
    private String author;
    private String publisher;
    private int edition;
    private String category;
    

}
