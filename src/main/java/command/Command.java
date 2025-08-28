package command;

import tasks.TaskList;
import ui.Ui;

public abstract class Command {
    public abstract void execute(TaskList tasks, Ui ui);
}