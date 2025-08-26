package tasks;

public class TodoTask extends Task {

    public TodoTask(String taskName) {
        super(taskName);
    }

    public TodoTask(String taskName, boolean isDone) {
        super(taskName, isDone);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    public String toStorage() {
        String doneMark = isDone ? "1" : "0";
        return "T | " + doneMark + " | " + taskName;
    }
}