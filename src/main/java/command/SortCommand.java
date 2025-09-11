package command;

public class SortCommand extends Command {
    @Override
    public String execute(task.TaskList tasks, ui.Ui ui) {
        tasks.sortTasks();
        return "Tasks have been sorted by description.";
    }
}
