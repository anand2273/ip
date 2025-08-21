package tasks;
import java.util.ArrayList;
import java.lang.StringBuilder;

public class TaskList {
    private final ArrayList<Task> tasks;
    private final String INDENTATION = "_______________________________________\n";

    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }

    public String add(Task task) {
        this.tasks.add(task);
        return "added: " + task.toString();
    }

    @Override
    public String toString() {
        if (tasks.isEmpty()) {
            return INDENTATION + "no tasks yet. get to work\n" + INDENTATION;
        }
        StringBuilder sb = new StringBuilder(INDENTATION + "Your Tasks:\n");
        for (int i = 0; i < tasks.size(); i++) {
            sb.append(i + 1)
                    .append(". ")
                    .append(tasks.get(i).toString())
                    .append("\n");
        }
        return sb.append(INDENTATION).toString();
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