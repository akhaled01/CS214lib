import java.util.*;

public class LibMember {
    private String firstName;
    private String lastName;
    private char gender;
    private long cprNum;
    private String teleNum;
    private Book[] booksIssued;
    private int numBooksIssued;

    public LibMember() {
        // default constructor to initialize all the data members to their default
        // values
        firstName = null;
        lastName = null;
        gender = ' ';
        cprNum = 0;
        teleNum = null;
        booksIssued = new Book[10];
        numBooksIssued = 0;
    }

    public LibMember(String fN, String lN, char g, long cN, String tN) {
        // constructor with parameters to initialize all data members to the passed
        // parameters, except the array booksIssued and the number of booksIssued
        firstName = fN;
        lastName = lN;
        gender = g;
        cprNum = cN;
        teleNum = tN;
        booksIssued = new Book[10];
        numBooksIssued = 0;
    }

    public void setFirstName(String fN) {
        firstName = fN;
    }

    public void setLastName(String lN) {
        lastName = lN;
    }

    public void setGender(char g) {
        gender = g;
    }

    public void setCprNum(long cN) {
        cprNum = cN;
    }

    public void setTeleNum(String tN) {
        teleNum = tN;
    }

    public void setBooksIssued(Book[] bI) {
        booksIssued = bI;
    }

    public void setNumBooksIssued(int nBI) {
        numBooksIssued = nBI;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public char getGender() {
        return gender;
    }

    public long getCprNum() {
        return cprNum;
    }

    public String getTeleNum() {
        return teleNum;
    }

    public Book[] getBooksIssued() {
        return booksIssued;
    }

    /**
     * @return
     */
    public int getNumBooksIssued() {
        return numBooksIssued;
    }

    /**
     * @param libMember
     * @return
     */
    public boolean equals(LibMember libMember) {
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
        String a = "";
        for (Book book : booksIssued) {
            a += book.getTitle() + " ";
        }
        return a;
    }

    public String toString() {
        return String.format(
                "First name: %s\n Last Name: %s\n CPR Num: %s\n Gender: %s\n TeleNum: %x\n Books Issued: %s\n",
                firstName, lastName, cprNum, gender, teleNum, issuedBooks());
    }
}
