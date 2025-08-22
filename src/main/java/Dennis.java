import java.util.Scanner;
import tasks.Task;
import tasks.TaskList;
import tasks.TodoTask;
import ui.Ui;

public class Dennis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskList taskList = new TaskList();

        String logo = "██████╗ ███████╗███╗   ██╗███╗   ██╗██╗███████╗\n"
                    + "██╔══██╗██╔════╝████╗  ██║████╗  ██║██║██╔════╝\n"
                    + "██║  ██║█████╗  ██╔██╗ ██║██╔██╗ ██║██║███████╗\n"
                    + "██║  ██║██╔══╝  ██║╚██╗██║██║╚██╗██║██║╚════██║\n"
                    + "██████╔╝███████╗██║ ╚████║██║ ╚████║██║███████║\n"
                    + "╚═════╝ ╚══════╝╚═╝  ╚═══╝╚═╝  ╚═══╝╚═╝╚══════╝\n";
        String message = "this is DENNIS. What can I do for you?";

        System.out.println(logo + Ui.wrapText(message));

        while (true) {
            String line = sc.nextLine();
            String[] parts = line.split("\\s+", 2);
            String cmd = parts[0].toLowerCase();
            int idx;
            switch (cmd) {
                case "bye":
                    System.out.println(Ui.wrapText("Catch ya later!"));
                    sc.close();
                    return;
                case "list":
                    System.out.println((taskList.toString()));
                    break;
                case "mark":
                    idx = Integer.parseInt(parts[1]) - 1;
                    System.out.println(taskList.get(idx).markDone());
                    break;
                case "unmark":
                    idx = Integer.parseInt(parts[1]) - 1;
                    System.out.println(taskList.get(idx).markUndone());
                    break;
                case "todo":
                    String taskName = parts[1];
                    TodoTask todoTask = new TodoTask(taskName);
                    String todoMsg = taskList.add(todoTask);
                    System.out.println(Ui.wrapText(todoMsg));
                    break;
                default:
                    Task task = new Task(cmd);
                    String output = taskList.add(task);
                    System.out.println(Ui.wrapText(output));
                    break;
            }
        }
    }
}
