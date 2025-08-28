package command;

import task.TaskList;
import ui.Ui;

public abstract class Command {
    public abstract void execute(TaskList tasks, Ui ui);

    public boolean isExit() {
        return false;
    }
}