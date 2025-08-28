package command;
import tasks.TaskList;
import tasks.TodoTask;
import ui.Ui;

public class ExitCommand extends Command {

    @Override
    public void execute(TaskList tasks, Ui ui) {
        ui.showBye();
    }
}
