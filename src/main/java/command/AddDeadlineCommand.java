package command;

import java.time.LocalDate;

import task.DeadlineTask;
import task.TaskList;
import ui.Ui;

public class AddDeadlineCommand extends Command {
    private final String description;
    private final LocalDate by;
    public AddDeadlineCommand(String description, LocalDate by) {
        this.description = description;
        this.by = by;
    }

    public void execute(TaskList tasks, Ui ui) {
        DeadlineTask deadlineTask = new DeadlineTask(description, by);
        tasks.add(deadlineTask);
        ui.showAddedTask(deadlineTask);

    }
}