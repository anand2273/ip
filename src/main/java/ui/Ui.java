package ui;
import tasks.TaskList;
import tasks.Task;

public class Ui {
    public static final String INDENTATION = "_______________________________________\n";

    private static final String LOGO = "\n █████╗ ██╗     ███████╗██████╗ ███████╗██████╗\n" +
                                       "██╔══██╗██║     ██╔════╝██╔══██╗██╔════╝██╔══██╗\n" +
                                       "███████║██║     █████╗  ██████╔╝█████╗  ██║  ██║\n" +
                                       "██╔══██║██║     ██╔══╝  ██╔══██╗██╔══╝  ██║  ██║\n" +
                                       "██║  ██║███████╗██║     ██║  ██║███████╗██████╔╝\n" +
                                       "╚═╝  ╚═╝╚══════╝╚═╝     ╚═╝  ╚═╝╚══════╝╚═════╝\n";
    public static String wrapText(String msg) {
        return INDENTATION + msg + "\n" + INDENTATION;
    }

    public void showWelcome() {
        String message = LOGO + "Good day, Master Bruce. How may I assist you?";
        System.out.println(wrapText(message));
    }

    public void showList(TaskList tasks) {
        System.out.println(wrapText(tasks.toString()));
    }

    public void showMarked(Task task, boolean marked) {
        String message = marked
                        ? "Task has been marked as done, Master Bruce.\n"
                        : "Task has already been marked as done, Master Bruce.\n";
        message += task.toString();
        System.out.println(wrapText(message));
    }

    public void showUnmarked(Task task, boolean marked) {
        String message = marked
                ? "Task has been marked as undone, Master Bruce.\n"
                : "Task has already been marked as undone, Master Bruce.\n";
        message += task.toString();
        System.out.println(wrapText(message));
    }

    public void showAddedTask(Task task) {
        String message = "This task has been successfully added:\n" + task;
        System.out.println(wrapText(message));
    }

    public void showDelete(TaskList tasks, Task task) {
        String message = "Noted, Master Bruce. This task has been successfully deleted:\n" + task + "\n";
        message += "There are " + tasks.size() + " tasks left.";
        System.out.println(Ui.wrapText(message));
    }

    public void showDefault() {
        System.out.println("Good Evening, Master Bruce. Please use the commands to continue.");
    }

    public void showError(String message) {
        System.out.println(Ui.wrapText(message));
    }

    public void showBye() {
        System.out.println(Ui.wrapText("Thank you, Master Bruce. See you soon."));
    }

}