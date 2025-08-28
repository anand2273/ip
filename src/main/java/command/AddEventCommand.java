package command;
import java.time.LocalDate;
import tasks.EventTask;
import tasks.TaskList;
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
    public void execute(TaskList tasks, Ui ui) {
        if (!from.isBefore(to)) {
            System.out.println("The end of the event should be after it starts, Master Bruce.");
            return;
        }
        EventTask eventTask = new EventTask(description, from, to);
        tasks.add(eventTask);
        ui.showAddedTask(eventTask);
    }
}
