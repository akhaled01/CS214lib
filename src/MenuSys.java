import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.Console;

/**
 * MenuSys class is the TUI for the applications, all methods are implemented
 * here
 * !DONE BY:
 * ! Abdulrahman Khaled - 202200729
 * ! Khadija Saeed Albasri - 202200734
 */

@SuppressWarnings("unused")
public class MenuSys {
    protected static Console console = System.console();
    protected static Scanner in = new Scanner(System.in);
    protected static LibrarySystem LibSys = new LibrarySystem();

    public static void clearTerminal() {
        // Checking operating system
        String os = System.getProperty("os.name").toLowerCase();

        try {
            if (os.contains("win")) {
                // For Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Init() methods creates a Menu instance that will be the
     * UI for the user
     * 
     * @throws InterruptedException
     */
    public static void Init() throws InterruptedException {
        if (console == null) {
            System.err.println("No console available");
            in.close();
            System.exit(1);
            return;
        }

        clearTerminal();
        int option;
        ColorPrinter.printMagenta("\n\t\t\t\t\tWelcome to LibSys\t\t\t\t\n");
        System.out.println("Choose an Option");
        System.out.println();
        ColorPrinter.printBlue("[1] Add a member");
        ColorPrinter.printBlue("[2] Add A book to library");
        ColorPrinter.printBlue("[3] issue a Book to a Member");
        ColorPrinter.printBlue("[4] return a book");
        ColorPrinter.printBlue("[5] get information about a book");
        ColorPrinter.printBlue("[6] get information about a member");
        ColorPrinter.printBlue("[7] get information about issued Books");
        ColorPrinter.printBlue("[8] Remove member");
        ColorPrinter.printBlue("[9] Remove Book Fron Lib");
        ColorPrinter.printBlue("[Anything] exit");

        try {
            option = in.nextInt();
            switch (option) {
                case 1:
                    AddNewMemberSys();
                    Init();
                case 2:
                    AddNewBookToLibSys();
                    Init();
                case 3:
                    IssueBookToMemberSys();
                    Init();
                case 4:
                    ReturnBookSys();
                    Init();
                case 5:
                    getBookInfo();
                    Init();
                case 6:
                    getMemInfo();
                    Init();
                case 7:
                    getIssuedSys();
                    Init();
                case 8:
                    removeMemSys();
                    Init();
                case 9:
                    removeBookSys();
                    Init();
                default:
                    clearTerminal();
                    System.exit(0);
                    Init();
            }
        } catch (InputMismatchException e) {
            clearTerminal();
            ColorPrinter.printOrange("Input mismatch...");
            Thread.sleep(1500);
            clearTerminal();
            System.exit(0);
        }

        in.close();
    }

    private static void getIssuedSys() throws InterruptedException {
        ColorPrinter.printOrange("Enter Member CPR: ");
        LibSys.printBooksIssued(in.nextLong());
        int o = in.nextInt();
        return;
    }

    private static void removeBookSys() throws InterruptedException {
        ColorPrinter.printOrange("Enter Book Accession Numeber: ");
        long AccessionNumber = in.nextLong();
        if (LibSys.deleteBook(AccessionNumber)) {
            ColorPrinter.printGreen("book successfully removed");
        } else {
            ColorPrinter.printRed("book removal failed");
        }
        Thread.sleep(1500);
        return;
    }

    private static void removeMemSys() throws InterruptedException {
        ColorPrinter.printOrange("Enter Member CPR: ");
        long cpr = in.nextLong();
        if (LibSys.deletemember(cpr)) {
            ColorPrinter.printGreen("member successfully removed");
        } else {
            ColorPrinter.printRed("Member removal failed");
        }
        Thread.sleep(1500);
        return;
    }

    private static void getMemInfo() throws InterruptedException {
        clearTerminal();
        ColorPrinter.printOrange("Enter Member CPR: ");
        long cpr = in.nextLong();
        LibMember a = LibSys.getMemberByCPR(cpr);
        ColorPrinter.printGreen(a.toString());
        int o = in.nextInt();
        return;
    }

    private static void getBookInfo() throws InterruptedException {
        clearTerminal();
        ColorPrinter.printOrange("Enter Book Accession Number: ");
        long accs = in.nextLong();
        Book a = LibSys.getBookBYAccsNumber(accs);
        ColorPrinter.printGreen(a.toString());
        int o = in.nextInt();
        return;
    }

    private static void ReturnBookSys() throws InterruptedException {
        clearTerminal();
        ColorPrinter.printBlue("Enter Book Accession Number: ");
        long accs = in.nextLong();
        if (LibSys.returnBook(accs)) {
            ColorPrinter.printGreen("Book returned successfully");
        } else {
            ColorPrinter.printRed("This book either doesnt exist, or was never issued");
        }
        Thread.sleep(1500);
        return;
    }

    private static void IssueBookToMemberSys() throws InterruptedException {
        clearTerminal();
        ColorPrinter.printBlue("Enter Book Accession Number: ");
        long accs = in.nextLong();
        if (LibSys.isBookIssued(accs)) {
            ColorPrinter.printRed("Book is issued to a member already");
            in.nextInt();
            return;
        }
        ColorPrinter.printBlue("Enter Member CPR Number: ");
        long cpr = in.nextLong();
        if (LibSys.issueBook(accs, cpr)) {
            ColorPrinter.printGreen("Book Issued Successfully!");
        } else {
            ColorPrinter.printRed("Book is either issued, or doesnt exist, or member doesnt exist");
        }
        Thread.sleep(1500);
        return;
    }

    private static void AddNewBookToLibSys() throws InterruptedException {
        clearTerminal();

        String title;
        String author1;
        String author2;
        String publisher;
        int yearPublication;
        String isbn;
        long accessionNum;

        ColorPrinter.printYellow("Please provide the following information:");

        ColorPrinter.printBlue("Title: ");
        title = in.next();

        ColorPrinter.printBlue("Author 1: ");
        author1 = in.next();

        ColorPrinter.printBlue("Author 2: ");
        author2 = in.next();

        ColorPrinter.printBlue("Publisher: ");
        publisher = in.next();

        ColorPrinter.printBlue("Year of Publication: ");
        yearPublication = in.nextInt();

        ColorPrinter.printBlue("ISBN: ");
        isbn = in.next();

        ColorPrinter.printBlue("Accession Number: ");
        accessionNum = in.nextLong();

        Book tobeAdded = new Book(title, author1, author2, publisher, yearPublication, isbn, accessionNum);
        LibSys.addBook(tobeAdded);
        ColorPrinter.printGreen("Memeber Added Successfullly");
        Thread.sleep(1500);
        return;
    }

    private static void AddNewMemberSys() throws InterruptedException {
        clearTerminal();
        String firstName;
        String lastName;
        long cprNum;
        String teleNum;

        ColorPrinter.printYellow("Please provide the following information:");

        ColorPrinter.printBlue("First Name: ");
        firstName = in.next();

        ColorPrinter.printBlue("Last Name: ");
        lastName = in.next();

        ColorPrinter.printBlue("Gender (M/F): ");
        String c = in.next();

        ColorPrinter.printBlue("CPR Number: ");
        cprNum = in.nextLong();
        in.nextLine(); // Consume the newline character after reading a long

        ColorPrinter.printBlue("Telephone Number: ");
        teleNum = in.nextLine();

        LibMember tLibMember = new LibMember(firstName, lastName, c.charAt(0), cprNum, teleNum);
        LibSys.addMember(tLibMember);
        ColorPrinter.printGreen("Member Added Successfully!");
        Thread.sleep(1500);
        return;
    }
}
