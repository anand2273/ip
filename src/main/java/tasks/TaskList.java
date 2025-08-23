package tasks;
import java.util.ArrayList;
import java.lang.StringBuilder;
import ui.Ui;

public class TaskList {
    private final ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }

    public Task get(int idx) {
        return this.tasks.get(idx);
    }
    public String add(Task task) {
        this.tasks.add(task);
        return "added: " + task.toString();
    }

    public String delete(int idx) {
        Task task = tasks.get(idx);
        tasks.remove(idx);
        int size = tasks.size();
        return "Noted. Removed this task\n" + task + "\n" + String.format("There are %d tasks left", size);
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

//    public static void main(String[] args) {
//        TaskList tasks = new TaskList();
//        Task task1 = new Task("Eat");
//        Task task2 = new Task("clean");
//        tasks.add(task1);
//        tasks.add(task2);
//
//        System.out.println(tasks.toString());
//    }
//
//}