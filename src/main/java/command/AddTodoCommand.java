package command;

import task.TaskList;
import task.TodoTask;
import ui.Ui;

public class AddTodoCommand extends Command {
    private final String description;

    public AddTodoCommand(String description) {
        this.description = description;
    }

    @Override
    public String execute(TaskList tasks, Ui ui) {
        TodoTask todoTask = new TodoTask(description);
        tasks.add(todoTask);
        return "This task has been successfully added:\n" + todoTask;
    }
}