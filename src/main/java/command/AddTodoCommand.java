package command;
import tasks.TaskList;
import tasks.TodoTask;
import ui.Ui;

public class AddTodoCommand extends Command {
    private final String description;

    public AddTodoCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute(TaskList tasks, Ui ui) {
        TodoTask todoTask = new TodoTask(description);
        tasks.add(todoTask);
        ui.showAddedTask(todoTask);
    }
}
