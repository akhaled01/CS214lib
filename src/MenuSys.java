import java.util.Scanner;
import java.io.Console;

/**
 * MenuSys class is the TUI for the applications, all methods are implemented
 * here
 * !DONE BY:
 * ! Abdulrahman Khaled - 202200729
 * ! Khadija Saeed Albasri - 202200734
 */

public class MenuSys {
    protected static Console console = System.console();
    protected static Scanner in = new Scanner(System.in);
    protected static LibrarySystem LibSys = new LibrarySystem();

    private static void noecho(Console console) {
        console.flush();
        console.writer().write("\033[8m"); // Send escape sequence to disable echo
    }

    private static void enableecho(Console console) {
        console.flush();
        console.writer().write("\033[0m"); // Send escape sequence to enable echo
    }

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

    public static void Init() {
        if (console == null) {
            System.err.println("No console available");
            in.close();
            System.exit(1);
            return;
        }

        clearTerminal();
        ColorPrinter.printMagenta("\n\t\t\t\t\tWelcome to LibSys\t\t\t\t\n");
        System.out.println("\n\t\tChoose an Option\n\t\t");
        noecho(console);
        ColorPrinter.printBlue("[1] Add a member");
        ColorPrinter.printBlue("[2] Add A book to library");
        ColorPrinter.printBlue("[3] issue a Book to a Member");
        ColorPrinter.printBlue("[4] return a book");
        ColorPrinter.printBlue("[5] get information about a book");
        ColorPrinter.printBlue("[6] get information about a member");
        ColorPrinter.printBlue("[7] exit");

        int option = in.nextInt();

        switch (option) {
            case 1:
                AddNewMemberSys();
                break;
            case 2:
                AddNewBookToLibSys();
                break;
            case 3:
                IssueBookToMemberSys();
                break;
            case 4:
                ReturnBookSys();
                break;
            case 5:
                getBookInfo();
                break;
            case 6:
                getMemInfo();
                break;
            case 7:
                System.exit(0);
                break;
            default:
                System.exit(1);
                break;
        }

        in.close();
    }

    private static void getMemInfo() {
        enableecho(console);
        clearTerminal();
        ColorPrinter.printOrange("Enter Member CPR: ");
        long cpr = in.nextLong();
        LibMember a = LibSys.getMemberByCPR(cpr);
        ColorPrinter.printGreen(a.toString());
        noecho(console);
        in.nextInt();
        Init();
    }

    private static void getBookInfo() {
        enableecho(console);
        clearTerminal();
        ColorPrinter.printOrange("Enter Book Accession Number: ");
        long accs = in.nextLong();
        Book a = LibSys.getBookBYAccsNumber(accs);
        ColorPrinter.printGreen(a.toString());
        in.nextInt();
        Init();
    }

    private static void ReturnBookSys() {
        enableecho(console);
        clearTerminal();
        ColorPrinter.printBlue("Enter Book Accession Number: ");
        long accs = in.nextLong();
        if (LibSys.returnBook(accs)) {
            ColorPrinter.printGreen("Book returned successfully");
        } else {
            ColorPrinter.printRed("This book either doesnt exist, or was never issued");
        }
        in.nextInt();
        Init();
    }

    private static void IssueBookToMemberSys() {
        enableecho(console);
        clearTerminal();
        ColorPrinter.printBlue("Enter Book Accession Number: ");
        long accs = in.nextLong();
        if (LibSys.isBookIssued(accs)) {
            ColorPrinter.printRed("Book is issued to a member already");
            in.nextInt();
            Init();
            return;
        }
        ColorPrinter.printBlue("Enter Member CPR Number: ");
        long cpr = in.nextLong();
        if (LibSys.issueBook(accs, cpr)) {
            ColorPrinter.printGreen("Book Issued Successfully!");
        } else {
            ColorPrinter.printRed("Book is either issued, or doesnt exist, or member doesnt exist");
        }
        in.nextInt();
        Init();
    }

    private static void AddNewBookToLibSys() {
        enableecho(console);
        clearTerminal();

        String title;
        String author1;
        String author2;
        String publisher;
        int yearPublication;
        String isbn;
        long accessionNum;

        System.out.println("Please provide the following information:");

        System.out.print("Title: ");
        title = in.nextLine();

        System.out.print("Author 1: ");
        author1 = in.nextLine();

        System.out.print("Author 2: ");
        author2 = in.nextLine();

        System.out.print("Publisher: ");
        publisher = in.nextLine();

        System.out.print("Year of Publication: ");
        yearPublication = in.nextInt();
        in.nextLine(); // Consume the
                       // newline character
                       // after reading an
                       // int

        System.out.print("ISBN: ");
        isbn = in.nextLine();

        System.out.print("Accession Number: ");
        accessionNum = in.nextLong();
        in.nextLine(); // Consume the newline
                       // character after
                       // reading a long

        Book tobeAdded = new Book(title, author1, author2, publisher, yearPublication, isbn, accessionNum);
        LibSys.addBook(tobeAdded);
    }

    private static void AddNewMemberSys() {
        enableecho(console);
    }
}
