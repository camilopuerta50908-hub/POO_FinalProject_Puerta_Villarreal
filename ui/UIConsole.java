package ui;
import java.util.Scanner;

/**
 * Concrete implementation of the UI contract tailored for standard console interaction.
 */
public class UIConsole implements UI {
    private Scanner keyboard = new Scanner(System.in);

    /**
     * Requests text input from the terminal after displaying a custom prompt.
     */
    @Override
    public String inputText(String prompt) {
        System.out.print(prompt + " ");
        return keyboard.nextLine();
    }

    /**
     * Requests an integer value from the keyboard input buffer.
     */
    @Override
    public int inputInt(String prompt) {
        System.out.print(prompt + " ");
        return Integer.parseInt(keyboard.nextLine());
    }

    /**
     * Captures and handles double-precision floating-point entry for price components.
     */
    @Override
    public double inputDouble(String prompt) {
        System.out.print(prompt + " ");
        return Double.parseDouble(keyboard.nextLine());
    }

    /**
     * Standardizes standard output operations by printing strings or objects onto the terminal screen.
     */
    @Override
    public void showText(Object message) {
        System.out.println(message);
    }
}