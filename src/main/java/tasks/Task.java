package tasks;

public class Task {
    private final String taskName;
    private boolean isDone;
    private final String INDENTATION = "_______________________________________\n";

    public Task(String taskName) {
        this.taskName = taskName;
        this.isDone = false;
    }

    public String markDone() {
        if (this.isDone) {
            return INDENTATION + "task is already marked as done\n" + this.toString() + "\n" + INDENTATION;
        }
        this.isDone = true;
        return INDENTATION + "task is marked as done!\n" + this.toString() + "\n" + INDENTATION;
    }

    public String markUndone() {
        if (!this.isDone) {
            return INDENTATION + "task is already marked as undone\n" + this.toString() + "\n" + INDENTATION;
        }
        this.isDone = false;
        return INDENTATION + "task is marked as undone.\n" + this.toString() + "\n" + INDENTATION;
    }

    public String toString() {
        String doneMark = "[] ";
        if (this.isDone) {
            doneMark = "[X] ";
        }
        return doneMark + this.taskName;
    }
}