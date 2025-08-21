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
            String input = sc.nextLine();
            if (input.equals("bye")) {
                System.out.println(indentation + "Catch you later!\n" + indentation);
                break;
            } else if (input.equals("list")) {
                System.out.println((taskList.toString()));
            } else {
                Task newTask = new Task(input);
                String output = taskList.add(newTask);
                System.out.println(indentation + output + "\n" + indentation);
            }
        }
        sc.close();
    }
}
