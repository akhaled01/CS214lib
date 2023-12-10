/**
 * * The following class is the main library Book system
 * * We utilize multiple different classes and methods
 * !Done By:
 * !Khadija Saeed Albasri - 202200734
 * !Abdulrahman Khaled - 202200729
 */

public class Book {
    /* this class contains information about the book in the library system
    *
     */
    private String title;
    private String author1;
    private String author2;
    private String publisher;
    private int yearPublication;
    private String isbn;
    private long accessionNum;
    private LibMember issuedTo;
    private static int AccessionCounter = 1;

    /**
     * default constructor initializing each data member to default values
     */
    public Book() {
        title = null;
        author1 = null;
        author2 = null;
        publisher = null;
        yearPublication = 0;
        isbn = "0000000000000";
        accessionNum = 1000;
        issuedTo = null;
    }

    /**
     * constructor with parameters assigning the passed parameters to each of the
     * data members
     * 
     * @param t
     * @param a1
     * @param a2
     * @param p
     * @param yP
     * @param ISBN
     * @param aN
     */
    public Book(String t, String a1, String a2, String p, int yP, String ISBN, long aN) {
        title = t;
        author1 = a1;
        author2 = a2;
        publisher = p;
        yearPublication = yP;
        /* checking if the ISBN passed is 13-digits, otherwise setting it to default
         value*/
        if (ISBN.length() == 13) {
            isbn = ISBN;
        } else {
            isbn = "0000000000000";
        }
        /* checking if the aN passed is more than 1000, otherwise setting it to default
         value, and incrememnt static accession countr by 1*/
        if (aN > 1000) {
            accessionNum = aN;
        } else {
            accessionNum = 1000 + AccessionCounter;
            AccessionCounter++;
        }
        issuedTo = null;
    }

    /**
     * set method for title
     * 
     * @param t - title to set
     */
    public void setTitle(String t) {
        title = t;
    }

    /**
     * set method for author 1
     * 
     * @param t - author1 to set
     */
    public void setAuthor1(String a1) {
        author1 = a1;
    }

    /**
     * set method for author2
     * 
     * @param a2
     */
    public void setAuthor2(String a2) {
        author2 = a2;
    }

    /**
     * set method for publisher
     * 
     * @param p
     */
    public void setPublisher(String p) {
        publisher = p;
    }

    /**
     * set method for yearPublication
     * 
     * @param yP
     */
    public void setYearPublication(int yP) {
        yearPublication = yP;
    }

    /**
     * set method for isbn, checks if ISBN is 13-digits first, otherwise sets it to
     * default value
     * 
     * @param ISBN
     */
    public void setIsbn(String ISBN) {
        if (ISBN.length() == 13) {
            isbn = ISBN;
        } else {
            isbn = "0000000000000";
        }
    }

    /**
     * set method for accessionNum, checks if aN is more than 1000, otherwise sets
     * it to default value
     * 
     * @param aN
     */
    public void setAccessionNum(long aN) {
        if (aN > 1000) {
            accessionNum = aN;
        } else {
            accessionNum = 1000 + AccessionCounter;
            AccessionCounter++;
        }
    }

    /**
     * set method for issuedTo
     * 
     * @param iT
     */
    public void setIssuedTo(LibMember iT) {
        issuedTo = iT;
    }

    /**
     * get method to return the title
     * 
     * @return title of book
     */
    public String getTitle() {
        return title;
    }

    /**
     * get method to return the title
     * 
     * @return title of book
     */
    public String getAuthor1() {
        // get method to return author1
        return author1;
    }

    /**
     * get method to return the title
     * 
     * @return title of book
     */
    public String getAuthor2() {
        return author2;
    }

    /**
     * get method to return the title
     * 
     * @return title of book
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * get method to return the year of publication
     * 
     * @return year of publication of book
     */
    public int getYearPublication() {
        return yearPublication;
    }

    /**
     * get method to return the ISBN
     * 
     * @return ISBN of book
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * get method to return the Accession Number
     * 
     * @return Accession Number of book
     */
    public long getAccessionNum() {
        return accessionNum;
    }

    /**
     * get method to return issedto
     * 
     * @return member to who is the book is issued
     */
    public LibMember getIssuedTo() {
        return issuedTo;
    }

    /**
     * Custom Equals method
     * 
     * @param book
     * @return true if both books are deep equals otherwise false
     */
    public boolean equals(Book book) {
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

    /**
     * Build a string from the Book object
     */
    public String toString() {
        String issu;
        if (getIssuedTo() == null) {
            issu = "no one";
        } else {
            issu = getIssuedTo().getFirstName() + " " + getIssuedTo().getLastName();
        }
        return String.format(
                "Book Title: %s\nauthor1: %s\nauthor2: %s\npublisher: %s\nISBN: %s\npublished in: %d\n",
                title, author1, author2, publisher, isbn, yearPublication) + "is issued to "
                + issu;
    }
}
