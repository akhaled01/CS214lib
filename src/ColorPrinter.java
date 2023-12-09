public class ColorPrinter {

    // Reset the text formatting
    private static final String ANSI_RESET = "\u001B[0m";

    // Bold text
    private static final String ANSI_BOLD = "\u001B[1m";

    // Colors
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_ORANGE = "\u001B[33m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_MAGENTA = "\u001B[35m";

    // Print text in blue color
    public static void printBlue(String text) {
        System.out.println(ANSI_BLUE + ANSI_BOLD + text + ANSI_RESET);
    }

    // Print text in green color
    public static void printGreen(String text) {
        System.out.println(ANSI_GREEN + ANSI_BOLD + text + ANSI_RESET);
    }

    // Print text in red color
    public static void printRed(String text) {
        System.out.println(ANSI_RED + ANSI_BOLD + text + ANSI_RESET);
    }

    // Print text in orange color
    public static void printOrange(String text) {
        System.out.println(ANSI_ORANGE + ANSI_BOLD + text + ANSI_RESET);
    }

    // Print text in yellow color
    public static void printYellow(String text) {
        System.out.println(ANSI_YELLOW + ANSI_BOLD + text + ANSI_RESET);
    }

    // Print text in magenta color
    public static void printMagenta(String text) {
        System.out.println(ANSI_MAGENTA + ANSI_BOLD + text + ANSI_RESET);
    }

}