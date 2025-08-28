package command;
import task.TaskList;
import ui.Ui;

public class ExitCommand extends Command {

    @Override
    public void execute(TaskList tasks, Ui ui) {
        ui.showBye();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
