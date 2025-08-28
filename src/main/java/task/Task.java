package task;

public abstract class Task {
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

    public abstract String toStorage();

    public String toString() {
        String doneMark = "[] ";
        if (isDone) {
            doneMark = "[X] ";
        }
        return doneMark + taskName;
    }
}