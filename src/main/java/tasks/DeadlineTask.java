package tasks;

public class DeadlineTask extends Task {
    protected String by;

    public DeadlineTask(String taskName, String by) {
        super(taskName);
        this.by = by;
    }

    @Override
    public String toStorage() {
        String doneMark = isDone ? "1" : "0";
        return "T | " + doneMark + " | " + taskName + " | " + by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}