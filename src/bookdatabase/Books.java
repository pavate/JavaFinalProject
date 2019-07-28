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
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.category = category;
        
    }

    @Override()
    public String toString() {
        String format = " %d    %d    %s    %s    %s    %s ";
        return String.format(format, ISBN, edition, author, title, category, publisher);
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
