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
    public String execute(TaskList tasks, Ui ui) {
        assert tasks != null;
        assert ui != null;
        assert pos >= 0;
        assert pos < tasks.size();

        Task deleteTask = tasks.get(pos);
        tasks.delete(pos);
        String message = "Noted, Master Bruce. This task has been successfully deleted:\n" + deleteTask + "\n";
        message += "There are " + tasks.size() + " tasks left.";
        return message;
    }
}
