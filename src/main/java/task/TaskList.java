package task;
import java.util.ArrayList;
import java.lang.StringBuilder;

public class TaskList {
    private final ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public Task get(int idx) {
        return this.tasks.get(idx);
    }

    public int size() {
        return tasks.size();
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }
    public void add(Task task) {
        this.tasks.add(task);
    }

    public void delete(int idx) {
        tasks.remove(idx);
    }

    @Override
    public String toString() {
        if (tasks.isEmpty()) {
            return "no tasks yet. get to work";
        }
        StringBuilder sb = new StringBuilder("Your Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            sb.append("\n")
                    .append(i + 1)
                    .append(". ")
                    .append(tasks.get(i).toString());
        }
        return sb.toString();
    }
}