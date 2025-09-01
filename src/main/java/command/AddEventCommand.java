package command;

import java.time.LocalDate;

import task.EventTask;
import task.TaskList;
import ui.Ui;

public class AddEventCommand extends Command {
    private final String description;
    private final LocalDate from;
    private final LocalDate to;

    public AddEventCommand(String description, LocalDate from, LocalDate to) {
        this.description = description;
        this.from = from;
        this.to = to;
    }

    @Override
    public String execute(TaskList tasks, Ui ui) {
        if (!from.isBefore(to)) {
            return Ui.wrapText("The end of the event should be after it starts, Master Bruce.");
        }
        EventTask eventTask = new EventTask(description, from, to);
        tasks.add(eventTask);
        return "This task has been successfully added:\n";
    }
}