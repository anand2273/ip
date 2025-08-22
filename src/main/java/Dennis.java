import java.util.Scanner;
import tasks.Task;
import tasks.TaskList;

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
        String indentation = "_______________________________________\n";
        String message = (indentation
                + "this is DENNIS. What can I do for you?\n"
                + indentation);
        System.out.println(logo + message);

        while (true) {
            String line = sc.nextLine();
            String[] parts = line.split("\\s+");
            String cmd = parts[0].toLowerCase();
            int idx;
            switch (cmd) {
                case "bye":
                    System.out.println(indentation + "Catch you later!\n" + indentation);
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
                default:
                    Task newTask = new Task(cmd);
                    String output = taskList.add(newTask);
                    System.out.println(indentation + output + "\n" + indentation);
                    break;
            }
        }
    }
}
