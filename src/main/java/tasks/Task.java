package tasks;
import ui.Ui;

public class Task {
    protected final String taskName;
    protected boolean isDone;

    public Task(String taskName) {
        this.taskName = taskName;
        this.isDone = false;
    }

    public String markDone() {
        String msg;
        if (isDone) {
            msg = "task is already marked as done\n" + this.toString();
        } else {
            isDone = true;
            msg = "task is marked as done\n" + this.toString();
        }
        return Ui.wrapText(msg);
    }

    public String markUndone() {
        String msg;
        if (!isDone) {
            msg = "task is already marked as undone\n" + this.toString();
        } else {
            isDone = false;
            msg = "task is marked as undone\n" + this.toString();
        }
        return Ui.wrapText(msg);
    }

    public String toString() {
        String doneMark = "[] ";
        if (isDone) {
            doneMark = "[X] ";
        }
        return doneMark + this.taskName;
    }
}