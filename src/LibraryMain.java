/**
 * !ENTRY POINT TO THE APPLICATION
 * 
 * ! PLEASE READ THE README.md FILE FOR MORE DETAILS
 * 
 * !DONE BY: 
 * ! Abdulrahman Khaled - 202200729
 * ! Khadija Saeed Albasri - 202200734
 */
public class LibraryMain {
    /**
     * This is where the system is launched, it redirects
     * to an instance of the main menu
     * @param args
     */
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
