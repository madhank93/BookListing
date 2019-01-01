package madhank93.android.in.booklisting;

public class Book {

    public String getBookImageURL() {
        return bookImageURL;
    }

    public void setBookImageURL(String bookImageURL) {
        this.bookImageURL = bookImageURL;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    private String bookImageURL;
    private String bookTitle;
    private String authors;

    public Book (String bookImageURL, String bookTitle, String authors) {
        this.bookImageURL = bookImageURL;
        this.bookTitle = bookTitle;
        this.authors = authors;
    }

}
