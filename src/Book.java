/**
 * * The following class is the main library Book system
 * * We utilize multiple different classes and methods
 * !Done By:
 * !Khadija Saeed Albasri - 202200734
 */

public class Book {
    // this class contains information about the book in the library system
    private String title;
    private String author1;
    private String author2;
    private String publisher;
    private int yearPublication;
    private String isbn;
    private long accessionNum;
    private LibMember issuedTo;
    private static int AccessionCounter = 0;

    public Book() {
        // default constructor initializing each data member to default values
        title = null;
        author1 = null;
        author2 = null;
        publisher = null;
        yearPublication = 0;
        isbn = "0000000000000";
        accessionNum = 1000;
        issuedTo = null;
    }

    public Book(String t, String a1, String a2, String p, int yP, String ISBN, long aN) {
        // constructor with parameters assigning the passed parameters to each of the
        // data members
        title = t;
        author1 = a1;
        author2 = a2;
        publisher = p;
        yearPublication = yP;
        // checking if the ISBN passed is 13-digits, otherwise setting it to default
        // value
        if (ISBN.length() == 13) {
            isbn = ISBN;
        } else {
            isbn = "0000000000000";
        }
        // checking if the aN passed is more than 1000, otherwise setting it to default
        // value
        if (aN > 1000) {
            accessionNum = aN;
        } else {
            accessionNum = 1000 + AccessionCounter;
            AccessionCounter++;
        }
        issuedTo = null;
    }

    public void setTitle(String t) {
        // set method for title
        title = t;
    }

    public void setAuthor1(String a1) {
        // set method for author1
        author1 = a1;
    }

    public void setAuthor2(String a2) {
        // set method for author2
        author2 = a2;
    }

    public void setPublisher(String p) {
        // set method for publisher
        publisher = p;
    }

    public void setYearPublication(int yP) {
        // set method for yearPublication
        yearPublication = yP;
    }

    public void setIsbn(String ISBN) {
        // set method for isbn, checks if ISBN is 13-digits first, otherwise sets it to
        // default value
        if (ISBN.length() == 13) {
            isbn = ISBN;
        } else {
            isbn = "0000000000000";
        }
    }

    public void setAccessionNum(long aN) {
        // set method for accessionNum, checks if aN is more than 1000, otherwise sets
        // it to default value
        if (aN > 1000) {
            accessionNum = aN;
        } else {
            accessionNum = 1000;
        }
    }

    public void setIssuedTo(LibMember iT) {
        // set method for issuedTo
        issuedTo = iT;
    }

    public String getTitle() {
        // get method to return the title
        return title;
    }

    public String getAuthor1() {
        // get method to return author1
        return author1;
    }

    public String getAuthor2() {
        // get method to return author2
        return author2;
    }

    public String getPublisher() {
        // get method to return the publisher
        return publisher;
    }

    public int getYearPublication() {
        // get method to return the year publication
        return yearPublication;
    }

    public String getIsbn() {
        // get method to return the isbn
        return isbn;
    }

    public long getAccessionNum() {
        // get method to return accessionNum
        return accessionNum;
    }

    public LibMember getIssuedTo() {
        // get method to return who the book is issuedTo
        return issuedTo;
    }

    public boolean equals(Book book) {
        // equals method to see if the passed book equals this book
        if (this == book) {
            return true;
        }
        if (book == null) {
            return false;
        }
        if (!this.getTitle().equalsIgnoreCase(book.getTitle())) {
            return false;
        } else if (!this.getAuthor1().equalsIgnoreCase(book.getAuthor1())) {
            return false;
        } else if (!this.getAuthor2().equalsIgnoreCase(book.getAuthor2())) {
            return false;
        } else if (!this.getPublisher().equalsIgnoreCase(book.getPublisher())) {
            return false;
        } else if (this.getYearPublication() != book.getYearPublication()) {
            return false;
        } else if (!this.getIsbn().equalsIgnoreCase(book.getIsbn())) {
            return false;
        } else if (this.getAccessionNum() != book.getAccessionNum()) {
            return false;
        } else if (this.getIssuedTo() != book.getIssuedTo()) {
            return false;
        }
        return true;
    }

    public String toString() {
        return String.format(
                "Book Title: %s\nauthor1: %s\nauthor2: %s\npublisher: %s\nISBN: %s\npublished in: %d\n",
                title, author1, author2, publisher, isbn, yearPublication);
    }
}
