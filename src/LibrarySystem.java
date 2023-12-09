import java.util.*;

/**
 * * The following class is the main library backend system
 * * We utilize multiple different classes and methods
 * !Done By:
 * !Abdulrahman Khaled - 202200729
 */

public class LibrarySystem {
    /**
     * Init Linkedlists to prepare for operations
     * We will be using Java's original Linked List implementation
     */
    private LinkedList<Book> BookList;
    private LinkedList<LibMember> memberList;
    /**
     * Other variable initialization
     * like booksListSize, memberListSize
     */
    int booksListSize, memberListSize;

    /**
     * Constructors for the Library system
     * We initialize both linked lists to perform operations'
     * related to a library system
     */
    public LibrarySystem() {
        BookList = new LinkedList<Book>();
        memberList = new LinkedList<LibMember>();
        booksListSize = memberListSize = 0;
    }

    /**
     * Method to add book to BookList
     * 
     * @param item
     * @return true on addiiton to bookList, or false
     */

    public boolean addBook(Book item) {
        if (BookList.indexOf(item) != -1) {
            return false;
        }
        BookList.add(item);
        booksListSize++;
        return true;
    }

    /**
     * Method to remove book from bookList
     * 
     * @param AccessionNumber
     * @return true if item ia found, not issued, and is removed, otherwise false
     */
    public boolean deleteBook(long AccessionNumber) {
        Iterator<Book> a = BookList.iterator();
        while (a.hasNext()) {
            Book temp = a.next();
            if (!temp.getIssuedTo().equals(null) && temp.getAccessionNum() == AccessionNumber) {
                a.remove();
                booksListSize--;
                return true;
            }
        }
        return false;
    }

    /**
     * add member to member list
     * 
     * @param nMember
     * @return true, except if member already exists
     */
    public boolean addMember(LibMember nMember) {
        if (memberList.indexOf(nMember) != -1) {
            return false;
        }
        memberList.add(nMember);
        memberListSize++;
        return true;
    }

    /**
     * private Method to get member by cpr
     * 
     * @param targetCPR
     * @return library member, null if not exist
     */
    protected LibMember getMemberByCPR(long targetCPR) {
        Iterator<LibMember> a = memberList.iterator();
        while (a.hasNext()) {
            LibMember tMember = a.next();
            if (tMember.getCprNum() == targetCPR) {
                return tMember;
            }
        }
        return null;
    }

    /**
     * method to get Book by accession number
     * 
     * @param accessionNumber
     * @return
     */
    protected Book getBookBYAccsNumber(long accessionNumber) {
        Iterator<Book> a = BookList.iterator();
        while (a.hasNext()) {
            Book tBook = a.next();
            if (tBook.getAccessionNum() == accessionNumber) {
                return tBook;
            }
        }
        return null;
    }

    /**
     * delete member from memberlist
     * 
     * @param CPR
     * @return true on deletion, xcpet if member doesn't exist, or has books issued
     *         to him
     */
    public boolean deletemember(long CPR) {
        Iterator<LibMember> a = memberList.iterator();
        if (getMemberByCPR(CPR) == null) {
            return false;
        }
        while (a.hasNext()) {
            LibMember temp = a.next();
            if (temp.equals(getMemberByCPR(CPR))) {
                if (temp.getBooksIssued().length == 0) {
                    return false;
                }
                a.remove();
                memberListSize--;
                return true;
            }
        }
        return false;
    }

    /**
     * search book by accession number
     * 
     * @param AccessionNumber
     * @return index of book if found, else -1
     */
    public int searchBook(int AccessionNumber) {
        return BookList.indexOf(getBookBYAccsNumber(AccessionNumber));
    }

    /**
     * search member by his/her CPR number
     * 
     * @param cprNum
     * @return index of member id found, else -1
     */
    public int searchMember(int cprNum) {
        return memberList.indexOf(getMemberByCPR(cprNum));
    }

    /**
     * @return if booklist is empty
     */
    public boolean isEmptyBooksList() {
        return BookList.isEmpty();
    }

    /**
     * @return if memberList is empty
     */
    public boolean isEmptyMembersList() {
        return memberList.isEmpty();
    }

    /**
     * @return size of booklist
     */
    public int sizeBooksList() {
        return booksListSize;
    }

    /**
     * @return size of member list
     */
    public int sizeMembersList() {
        return memberListSize;
    }

    /**
     * Method to issue book to members
     * 
     * @param accessionNum
     * @param cpr
     * @return True if both member and book exist, and book isnt issued, and member
     *         has less than 10 books issued
     */
    public boolean issueBook(long accessionNum, long cpr) {
        LibMember toBeIssued = getMemberByCPR(cpr);
        Book lendedBook = getBookBYAccsNumber(accessionNum);
        if (BookList.indexOf(getBookBYAccsNumber(accessionNum)) == -1 || lendedBook.equals(null)
                || toBeIssued.equals(null)
                || memberList.indexOf(getMemberByCPR(cpr)) == -1) {
            return false;
        } else if (!getBookBYAccsNumber(accessionNum).getIssuedTo().equals(null)) {
            return false;
        } else if (getMemberByCPR(cpr).getNumBooksIssued() == 10) {
            return false;
        }

        lendedBook.setIssuedTo(toBeIssued);
        // auto increments by numBookList by 1
        toBeIssued.setBooksIssued(toBeIssued.appendBookList(lendedBook));;

        return true;
    }

    /**
     * Method to return book to library
     * 
     * @param accessionNum
     * @return true if book exists and is issued, otherwise false
     */
    public boolean returnBook(long accessionNum) {
        Book a = getBookBYAccsNumber(accessionNum);
        if (a.equals(null) || BookList.indexOf(a) == -1 || a.getIssuedTo().equals(null)
                || memberList.indexOf(a.getIssuedTo()) == -1) {
            return false;
        }
        LibMember temp = a.getIssuedTo();
        // auto decrements numBooksIssued by 1
        temp.setBooksIssued(temp.removeBookList(a));;
        a.setIssuedTo(null);
        return true;
    }

    /**
     * Method to check if a book is issued
     * 
     * @param accessionNum
     * @return True if Book exists, in bookList, and is issued to someone
     */
    public boolean isBookIssued(long accessionNum) {
        return !getBookBYAccsNumber(accessionNum).equals(null)
                && BookList.indexOf(getBookBYAccsNumber(accessionNum)) != -1
                && !(getBookBYAccsNumber(accessionNum).getIssuedTo() == null);
    }

    /**
     * Prints Books issued to a member
     * @param cpr
     */
    public void printBooksIssued(long cpr) {
        LibMember mem = getMemberByCPR(cpr);
        Book[] list = mem.getBooksIssued();
        System.out.println("BOOKS ISSUED TO : " + mem.getFirstName() + " " + mem.getLastName());
        for (Book book : list) {
            System.out.println(book.toString());
            System.out.println("=================");
        }
        System.out.println("<==========>");
    }
} // end of Library System
