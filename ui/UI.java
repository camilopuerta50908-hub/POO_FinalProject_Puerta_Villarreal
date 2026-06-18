package ui;

/**
 * Interface that defines the standard input and output operations for the user interface.
 */
public interface UI {
    String inputText(String prompt);
    int inputInt(String prompt);
    double inputDouble(String prompt);
    void showText(Object message);
}