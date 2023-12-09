/**
 * !ENTRY POINT TO THE APPLICATION
 * 
 * ! PLEASE READ THE README.md FILE FOR MORE DETAILS
 */
public class LibraryMain {
    public static void main(String[] args) {
        try {
            MenuSys.Init();
        } catch (InterruptedException e) {
            System.out.println("Signal Interruption Detected, exiting...");
            MenuSys.clearTerminal();
            System.exit(0);
        }
        MenuSys.clearTerminal();
    }
}
