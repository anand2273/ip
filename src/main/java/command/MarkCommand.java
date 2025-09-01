package command;

import task.Task;
import task.TaskList;

import ui.Ui;

public class MarkCommand extends Command {
    private final int pos;
    private final String cmd;

    public MarkCommand(int pos, String cmd) {
        this.pos = pos;
        this.cmd = cmd;
    }

    @Override
    public String execute(TaskList tasks, Ui ui) {
        Task task = tasks.get(pos);
        String message;
        if (cmd.equals("mark")) {
            boolean marked = task.markDone();
            message = marked
                ? "Task has been marked as done, Master Bruce.\n"
                : "Task has already been marked as done, Master Bruce.\n";
        } else {
            boolean marked = task.markUndone();
            message = marked
                ? "Task has been marked as undone, Master Bruce.\n"
                : "Task has already been marked as undone, Master Bruce.\n";
        }
        message += task.toString();
        return message;
    }
}