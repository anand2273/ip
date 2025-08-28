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

    public void execute(TaskList tasks, Ui ui) {
        Task task = tasks.get(pos);
        if (cmd.equals("mark")) {
            ui.showMarked(task, task.markDone());
        } else {
            ui.showUnmarked(task, task.markUndone());
        }
    }
}