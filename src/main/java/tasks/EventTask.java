package tasks;

public class EventTask extends Task {
    protected String from;
    protected String to;

    public EventTask(String taskName, String from, String to) {
        super(taskName);
        this.from = from;
        this.to = to;
    }

    public String toStorage() {
        String doneMark = isDone ? "1" : "0";
        return "E | " + doneMark + " | " + taskName + " | from " + from + " | to " + to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }
}