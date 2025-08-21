package tasks;

public class Task {
    private final String taskName;
    private boolean done;

    public Task(String taskName) {
        this.taskName = taskName;
        this.done = false;
    }

    public void markComplete() {
        this.done = true;
    }

    public String toString() {
        return this.taskName;
    }
}