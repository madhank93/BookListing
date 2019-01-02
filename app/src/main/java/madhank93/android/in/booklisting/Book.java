package madhank93.android.in.booklisting;

import java.util.List;

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

    public List getAuthors() {
        return authors;
    }

    public void setAuthors(List authors) {
        this.authors = authors;
    }

    private String bookImageURL;
    private String bookTitle;
    private List authors;

    public Book (String bookImageURL, String bookTitle, List authors) {
        this.bookImageURL = bookImageURL;
        this.bookTitle = bookTitle;
        this.authors = authors;
    }

}
