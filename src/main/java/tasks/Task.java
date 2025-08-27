package tasks;
import ui.Ui;

public class Task {
    protected final String taskName;
    protected boolean isDone;

    public Task(String taskName) {
        this.taskName = taskName;
        this.isDone = false;
    }

    public Task(String taskName, boolean isDone) {
        this.taskName = taskName;
        this.isDone = isDone;
    }

    public boolean markDone() {
        if (isDone) {
            return false;
        }
        isDone = true;
        return true;
    }

    public boolean markUndone() {
        if (!isDone) {
            return false;
        }
        isDone = false;
        return true;
    }

    public String toStorage() {
        String doneMark = isDone ? "1" : "0";
        return "N | " + doneMark + " | " + taskName;
    }

    public String toString() {
        String doneMark = "[] ";
        if (isDone) {
            doneMark = "[X] ";
        }
        return doneMark + taskName;
    }
}