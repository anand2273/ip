package command;

import task.Task;
import task.TaskList;
import ui.Ui;

public class FindCommand extends Command {
    private final String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }
    @Override
    public void execute(TaskList tasks, Ui ui) {
        TaskList matches = new TaskList();
        String kw = keyword.toLowerCase();

        for (Task t : tasks.getTasks()) {
            if (t.getName().toLowerCase().contains(kw)) {
                matches.add(t);
            }
        }
        ui.showFind(matches);
    }
}
