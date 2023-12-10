import java.util.*;

/**
 * * The following class is the main library member system
 * * We utilize multiple different classes and methods
 * 
 * !Done By:
 * !Khadija Saeed Albasri - 202200734
 * !Abdulrahman Khaled - 202200729
 */

public class LibMember {
    private String firstName;
    private String lastName;
    private char gender;
    private String cprNumStr;
    private long cprNum;
    private String teleNum;
    private Book[] booksIssued;
    private int numBooksIssued;

    /**
     * default constructor to initialize all the data members to their default
     * values
     */
    public LibMember() {
        firstName = null;
        lastName = null;
        gender = ' ';
        cprNum = 0;
        teleNum = null;
        booksIssued = new Book[10];
        numBooksIssued = 0;
    }

    /**
     * constructor with parameters to initialize all data members to the passed
     * parameters, except the array booksIssued and the number of booksIssued
     * 
     * @param fN
     * @param lN
     * @param g
     * @param cN
     * @param tN
     */
    public LibMember(String fN, String lN, char g, long cN, String tN) {
        firstName = fN;
        lastName = lN;
        gender = g;
        cprNum = cN;
        teleNum = tN;
        booksIssued = new Book[10];
        numBooksIssued = 0;
    }

    /**
     * set first Name
     * 
     * @param fN
     */
    public void setFirstName(String fN) {
        firstName = fN;
    }

    /**
     * set Last Name
     * 
     * @param lN
     */
    public void setLastName(String lN) {
        lastName = lN;
    }

    /**
     * set str cpr
     * @param cprNumStr
     */
    public void setCprNumStr(String cprNumStr) {
        this.cprNumStr = cprNumStr;
    }

    /* set gender
     */

    public void setGender(char g) {
        gender = g;
    }
    /* set cprNum
     */
    public void setCprNum(long cN) {
        cprNum = cN;
    }
    /* set teleNum
     */
    public void setTeleNum(String tN) {
        teleNum = tN;
    }
    /* set booksIssued
     */
    public void setBooksIssued(Book[] bI) {
        booksIssued = bI;
    }
    /* set numBooksIssued
     */
    public void setNumBooksIssued(int nBI) {
        numBooksIssued = nBI;
    }
    /* get firstName
     */
    public String getFirstName() {
        return firstName;
    }
    /* get lastName
     */
    public String getLastName() {
        return lastName;
    }
    /* get gender
     */
    public char getGender() {
        return gender;
    }

    /**
     * 
     * @return cprNum in string
     */
    public String getCprNumStr() {
        return cprNumStr;
    }

    /* get cprNum
     */
    public long getCprNum() {
        return cprNum;
    }
    /* get teleNum
     */
    public String getTeleNum() {
        return teleNum;
    }
    /* get booksIssued
     */
    public Book[] getBooksIssued() {
        return booksIssued;
    }

    /**
     * Add a new book to the issued book list
     * 
     * @param a
     * @return new bookArray after addition
     */
    public Book[] appendBookList(Book newBook) {
        // int length = booksIssued.length;
        // Book[] newArray = Arrays.copyOf(booksIssued, length + 1);
        booksIssued[getNumBooksIssued()] = newBook;
        numBooksIssued++;
        return booksIssued;
    }

    /**
     * remove a book from the issued book list
     * 
     * @param a - book to be removed
     * @return new bookarray after removal
     * @throws IllegalArgumentException if book isnt issued to
     */
    public Book[] removeBookList(int index) {
        if (index < 0 || index > numBooksIssued) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        // Book returnValue = booksIssued[index];
        // shift data in the array to delete element
        for (int i = index + 1; i < numBooksIssued; i++) {
            booksIssued[i - 1] = booksIssued[i];
        }
        booksIssued[numBooksIssued - 1] = null;
        numBooksIssued--;
        return booksIssued;
    }

    /**
     * @return number of books issued to member
     */
    public int getNumBooksIssued() {
        return numBooksIssued;
    }

    /**
     * @param libMember
     * @return
     */
    public boolean equals(LibMember libMember) {
        /* equals method to see if the libMember is equal to the passed libMember parameter
        *
         */
        if (this == libMember) {
            return true;
        }
        if (libMember == null) {
            return false;
        }
        if (!this.getFirstName().equalsIgnoreCase(libMember.getFirstName())) {
            return false;
        } else if (!this.getLastName().equalsIgnoreCase(libMember.getLastName())) {
            return false;
        } else if (this.getGender() != libMember.getGender()) {
            return false;
        } else if (this.getCprNum() != libMember.getCprNum()) {
            return false;
        } else if (!this.getTeleNum().equalsIgnoreCase(libMember.getTeleNum())) {
            return false;
        } else if (!Arrays.toString(this.getBooksIssued())
                .equalsIgnoreCase(Arrays.toString(libMember.getBooksIssued()))) {
            return false;
        } else if (this.getNumBooksIssued() != libMember.getNumBooksIssued()) {
            return false;
        }
        return true;
    }

    public String issuedBooks() {
        if (this.getNumBooksIssued() == 0) {
            return "No Books Issued";
        }
        String a = "";
        for (Book book : booksIssued) {
            a += book.getTitle() + " ";
        }
        return a;
    }

    public String toString() {
        return String.format(
                "First name: %s\nLast Name: %s\nCPR Num: %s\nGender: %s\nTeleNum: %s\nBooks Issued:%s\n",
                firstName, lastName, getCprNumStr(), gender, teleNum, issuedBooks());
    }
}
