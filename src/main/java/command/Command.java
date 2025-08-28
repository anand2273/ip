package command;

import tasks.TaskList;
import ui.Ui;

public abstract class Command {
    abstract void execute(TaskList tasks, Ui ui);
}