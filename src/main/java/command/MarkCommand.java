package command;
import java.time.LocalDate;
import tasks.Task;
import tasks.DeadlineTask;
import tasks.TaskList;
import ui.Ui;

public class MarkCommand extends Command {
    private int pos;
    private String cmd;

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