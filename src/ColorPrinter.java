/**
 * Class that contains methods to print colors
 * 
 * ! DONE BY:
 * ! Abdulrahman Khaled - 202200729
 * ! Khadija Saeed Albasri - 202200734
 */

public class ColorPrinter {

    /**
     * predefined colors and properties
     * Each color has an ansi code, which manipulates how 
     * things are displayed on terminal
     */

    // Reset the text formatting
    private static final String ANSI_RESET = "\u001B[0m";

    private static final String ANSI_BOLD = "\u001B[1m";
    
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_ORANGE = "\u001B[33m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_MAGENTA = "\u001B[35m";

    /**
     * Print text in blue color
     * @param text
     */
    public static void printBlue(String text) {
        System.out.println(ANSI_BLUE + ANSI_BOLD + text + ANSI_RESET);
    }

    /**
     * Print text in green color
     * @param text
     */
    public static void printGreen(String text) {
        System.out.println(ANSI_GREEN + ANSI_BOLD + text + ANSI_RESET);
    }

    /**
     * Print text in red color
     * @param text
     */
    public static void printRed(String text) {
        System.out.println(ANSI_RED + ANSI_BOLD + text + ANSI_RESET);
    }

    /**
     * Print text in orange color
     * @param text
     */
    public static void printOrange(String text) {
        System.out.println(ANSI_ORANGE + ANSI_BOLD + text + ANSI_RESET);
    }
    /**
     * Print text in yellow color
     * @param text
     */
    public static void printYellow(String text) {
        System.out.println(ANSI_YELLOW + ANSI_BOLD + text + ANSI_RESET);
    }

    /**
     * Print text in magenta color
     * @param text
     */
    public static void printMagenta(String text) {
        System.out.println(ANSI_MAGENTA + ANSI_BOLD + text + ANSI_RESET);
    }

}