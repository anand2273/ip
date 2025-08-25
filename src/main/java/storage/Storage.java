package storage;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import tasks.DeadlineTask;
import tasks.TaskList;
import tasks.Task;
import tasks.TodoTask;

public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public void save(TaskList tasks) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        String textToAdd = "";
        for (Task t : tasks.getTasks()) {
            textToAdd += t.toStorage() + System.lineSeparator();
        }
        fw.write(textToAdd);
        fw.close();
    }

    public void load() {
        return; // implement this later
    }

    private ArrayList<Task> parseTask(String storedTasks) {
        return null; // implement this later
    }

    public static void main(String[] args) throws IOException {
        Task task1 = new TodoTask("Eat");
        Task task2 = new DeadlineTask("eat", "tomorrow");
        TaskList taskList = new TaskList();
        taskList.add(task1);
        taskList.add(task2);
        Storage storage = new Storage("data/dennis.txt");
        storage.save(taskList);
        System.out.println("done");
    }


}