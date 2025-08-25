package tasks;

public class TodoTask extends Task {

    public TodoTask(String taskName) {
        super(taskName);
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