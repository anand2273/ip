package command;
import tasks.TaskList;
import ui.Ui;

public class ListCommand extends Command {

    @Override
    public void execute(TaskList tasks, Ui ui) {
        ui.showList(tasks);
    }
}
