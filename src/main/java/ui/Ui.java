package ui;
import tasks.TaskList;
import tasks.Task;

public class Ui {
    public static final String INDENTATION = "_______________________________________\n";

    private static final String LOGO = " █████╗ ██╗     ███████╗██████╗ ███████╗██████╗\n" +
                                       "██╔══██╗██║     ██╔════╝██╔══██╗██╔════╝██╔══██╗\n" +
                                       "███████║██║     █████╗  ██████╔╝█████╗  ██║  ██║\n" +
                                       "██╔══██║██║     ██╔══╝  ██╔══██╗██╔══╝  ██║  ██║\n" +
                                       "██║  ██║███████╗██║     ██║  ██║███████╗██████╔╝\n" +
                                       "╚═╝  ╚═╝╚══════╝╚═╝     ╚═╝  ╚═╝╚══════╝╚═════╝";
    public static String wrapText(String msg) {
        return INDENTATION + msg + "\n" + INDENTATION;
    }

    public void showWelcome() {
        String message = LOGO + "Good day, Master Bruce. How may I assist you?";
        System.out.println(Ui.wrapText(message));
    }

    public void showList(TaskList tasks) {
        System.out.println(Ui.wrapText(tasks.toString()));
    }

    public void showMarked(Task task) {
        String message = "Task has been marked as done.";
        System.out.println(message + task.toString());
    }

    public void showUnmarked(Task task) {
        String message = "Task has been marked as undone";
        System.out.println(message + task.toString());
    }

}