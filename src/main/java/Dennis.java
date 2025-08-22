import java.util.Scanner;

import tasks.*;
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
                    System.out.println((Ui.wrapText(taskList.toString())));
                    break;
                case "mark":
                    idx = Integer.parseInt(parts[1]) - 1;
                    System.out.println(Ui.wrapText(taskList.get(idx).markDone()));
                    break;
                case "unmark":
                    idx = Integer.parseInt(parts[1]) - 1;
                    System.out.println(Ui.wrapText(taskList.get(idx).markUndone()));
                    break;
                case "todo":
                    String taskName = parts[1];
                    TodoTask todoTask = new TodoTask(taskName);
                    String todoMsg = taskList.add(todoTask);
                    System.out.println(Ui.wrapText(todoMsg));
                    break;
                case "deadline":
                    String[] remainder = parts[1].split("/by");
                    DeadlineTask deadlineTask = new DeadlineTask(remainder[0].trim(), remainder[1].trim());
                    String deadlineMsg = taskList.add(deadlineTask);
                    System.out.println(Ui.wrapText(deadlineMsg));
                    break;
                case "event":
                    String[] rest = parts[1].split("/from");
                    String[] timeline = rest[1].split("/to");
                    EventTask eventTask = new EventTask(rest[0].trim(), timeline[0].trim(), timeline[1].trim());
                    String eventMsg = taskList.add(eventTask);
                    System.out.println(Ui.wrapText(eventMsg));
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
