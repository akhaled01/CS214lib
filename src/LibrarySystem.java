import java.util.*;

/**
 * * The following class is the main library backend system
 * * We utilize multiple different classes and methods
 * !Done By:
 * !Abdulrahman Khaled - 202200729
 * !Khadija Saeed Abdulla Albasri - 202200734
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
    public boolean deleteBook(int AccessionNumber) {
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
     * @param targetCPR
     * @return library member, null if not exist
     */
    private LibMember getMemberByCPR(int targetCPR) {
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
     * delete member from memberlist
     * @param CPR
     * @return true on deletion, xcpet if member doesn't exist, or has books issued to him 
     */
    public boolean deletemember(int CPR) {
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
     * @param AccessionNumber
     * @return index of book if found, else -1
     */
    public int searchBook(int AccessionNumber) {
        return BookList.indexOf(getBookBYAccsNumber(AccessionNumber));
    }

    /**
     * method to get Book by accession number
     * @param accessionNumber
     * @return
     */
    private Book getBookBYAccsNumber(int accessionNumber) {
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
     * search member by his/her CPR number
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

    
}
