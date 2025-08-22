package ui;

public class Ui {
    public static final String INDENTATION = "_______________________________________\n";

    public static String wrapText(String msg) {
        return INDENTATION + msg + "\n" + INDENTATION;
    }
}