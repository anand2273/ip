package command;
import task.Task;
import task.TaskList;
import ui.Ui;

public class DeleteCommand extends Command {
    private final int pos;

    public DeleteCommand(int pos) {
        this.pos = pos;
    }

    @Override
    public void execute(TaskList tasks, Ui ui) {
        Task deleteTask = tasks.get(pos);
        tasks.delete(pos);
        ui.showDelete(tasks, deleteTask);
    }
}
