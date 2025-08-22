package tasks;

public class TodoTask extends Task {

    public TodoTask(String taskName) {
        super(taskName);
    }

    @Override
    public String toString() {
        String tag = "[T][] ";
        if (isDone) {
            tag = "[T][X] ";
        }
        return tag + taskName;
    }


}