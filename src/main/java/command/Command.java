package command;

import task.TaskList;
import ui.Ui;

public abstract class Command {
    /**
     * Executes this command against the given task list and UI.
     *
     * @param tasks the task list to read from or mutate
     * @param ui    the UI used to present results or messages
     */
    public abstract void execute(TaskList tasks, Ui ui);

    /**
     * Indicates whether executing this command should terminate the application loop.
     *
     * @return {@code true} if this command signals exit; {@code false} otherwise
     */
    public boolean isExit() {
        return false;
    }
}
