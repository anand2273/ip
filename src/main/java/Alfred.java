import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.time.LocalDate;

import command.*;
import storage.Storage;
import tasks.*;
import ui.Ui;

public class Alfred {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Storage storage = new Storage("data/alfred.txt");
        TaskList taskList = storage.load();
        Ui ui = new Ui();

        ui.showWelcome();

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
                        ui.showBye();
                        sc.close();
                        return;
                    }
                    ui.showBye();
                    sc.close();
                    return;
                case "list":
                    Command listCommand = new ListCommand();
                    listCommand.execute(taskList, ui);
                    break;
                case "mark":
                case "unmark":
                    try {
                        idx = Integer.parseInt(parts[1]) - 1;
                        Command markCommand = new MarkCommand(idx, cmd);
                        markCommand.execute(taskList, ui);
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
                        AddTodoCommand atc = new AddTodoCommand(taskName);
                        atc.execute(taskList, ui);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Please specify a task.");
                    }
                    break;
                case "deadline":
                    try {
                        String[] remainder = parts[1].split("/by");
                        String b = remainder[1].trim();
                        LocalDate by = LocalDate.parse(b);
                        AddDeadlineCommand adc = new AddDeadlineCommand(remainder[0].trim(), by);
                        adc.execute(taskList, ui);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println(Ui.wrapText("Invalid input. Please follow the prescribed format."));
                    } catch (DateTimeParseException e) {
                        System.out.println(Ui.wrapText("Master Bruce, please enter the date in the following format: YYYY-MM-DD."));
                    }
                    break;
                case "event":
                    try {
                        String[] rest = parts[1].split("/from");
                        String[] timeline = rest[1].split("/to");
                        LocalDate from = LocalDate.parse(timeline[0].trim());
                        LocalDate to = LocalDate.parse(timeline[1].trim());
                        AddEventCommand aec = new AddEventCommand(rest[0].trim(), from, to);
                        aec.execute(taskList, ui);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Invalid input. Please follow the prescribed format.");
                    } catch (DateTimeParseException e) {
                        System.out.println("Please enter the correct format, Master Bruce.");
                    }
                    break;
                case "delete":
                    int pos = Integer.parseInt(parts[1]) - 1;
                    DeleteCommand dc = new DeleteCommand(pos);
                    dc.execute(taskList, ui);
                    break;
                default:
                    ui.showDefault();
                    break;
            }
        }
    }
}
