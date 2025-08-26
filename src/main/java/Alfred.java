import java.io.IOException;
import java.util.Scanner;
import storage.Storage;
import tasks.*;
import ui.Ui;

public class Alfred {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Storage storage = new Storage("data/alfred.txt");
        TaskList taskList = storage.load();

        String logo = " █████╗ ██╗     ███████╗██████╗ ███████╗██████╗\n" +
                      "██╔══██╗██║     ██╔════╝██╔══██╗██╔════╝██╔══██╗\n" +
                      "███████║██║     █████╗  ██████╔╝█████╗  ██║  ██║\n" +
                      "██╔══██║██║     ██╔══╝  ██╔══██╗██╔══╝  ██║  ██║\n" +
                      "██║  ██║███████╗██║     ██║  ██║███████╗██████╔╝\n" +
                      "╚═╝  ╚═╝╚══════╝╚═╝     ╚═╝  ╚═╝╚══════╝╚═════╝\n";

        String message = "Good day, Master Bruce. How may I assist you?";

        System.out.println(logo + Ui.wrapText(message));

        while (true) {
            String line = sc.nextLine();
            String[] parts = line.split("\\s+", 2);
            String cmd = parts[0].toLowerCase();
            int idx;
            switch (cmd) {
                case "bye":
                    try {
                        storage.save(taskList);
                    } catch (IOException e) {
                        System.out.println(Ui.wrapText("Catch ya later!"));
                        sc.close();
                        return;
                    }
                    System.out.println(Ui.wrapText("Catch ya later!"));
                    sc.close();
                    return;
                case "list":
                    System.out.println((Ui.wrapText(taskList.toString())));
                    break;
                case "mark":
                case "unmark":
                    try {
                        idx = Integer.parseInt(parts[1]) - 1;
                        Task task = taskList.get(idx);
                        String result = cmd.equals("mark") ? task.markDone() : task.markUndone();
                        System.out.println(Ui.wrapText(result));
                    }
                    catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println(Ui.wrapText("Please specify the task number in the following format: 'mark 1'"));
                    } catch (NumberFormatException nfe) {
                        System.out.println(Ui.wrapText("Please specify a numerical value for the task number in the following format: 'mark 1'"));
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(Ui.wrapText("That task number does not exist. Please use the list command for task numbers."));
                    }
                    break;
                case "todo":
                    try {
                        String taskName = parts[1];
                        TodoTask todoTask = new TodoTask(taskName);
                        String todoMsg = taskList.add(todoTask);
                        System.out.println(Ui.wrapText(todoMsg));
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Please specify a task.");
                    }
                    break;
                case "deadline":
                    try {
                        String[] remainder = parts[1].split("/by");
                        DeadlineTask deadlineTask = new DeadlineTask(remainder[0].trim(), remainder[1].trim());
                        String deadlineMsg = taskList.add(deadlineTask);
                        System.out.println(Ui.wrapText(deadlineMsg));
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Invalid input. Please follow the prescribed format.");
                    }
                    break;
                case "event":
                    try {
                        String[] rest = parts[1].split("/from");
                        String[] timeline = rest[1].split("/to");
                        EventTask eventTask = new EventTask(rest[0].trim(), timeline[0].trim(), timeline[1].trim());
                        String eventMsg = taskList.add(eventTask);
                        System.out.println(Ui.wrapText(eventMsg));
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Invalid input. Please follow the prescribed format.");
                    }
                    break;
                case "delete":
                    int pos = Integer.parseInt(parts[1]) - 1;
                    String deleteMsg = taskList.delete(pos);
                    System.out.println(Ui.wrapText(deleteMsg));
                    break;
                default:
                    Task task = new Task(line);
                    String output = taskList.add(task);
                    System.out.println(Ui.wrapText(output));
                    break;
            }
        }
    }
}
