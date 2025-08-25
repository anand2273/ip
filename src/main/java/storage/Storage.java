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

    private Task parseTask(String storedTask) {
        String[] parts = storedTask.split(" \\| ");
        String type = parts[0].trim();
        boolean isDone = parts[1].trim().equals("1");
        System.out.println(parts[1].trim());
        System.out.println(parts[2]);
        String taskName = parts[2].trim();
        switch (type) {
            case "T":
                return new TodoTask(taskName, isDone);
            case "D":
                String by = parts[3].trim();
                return new DeadlineTask(taskName, isDone, by);
            case "E":
                String from = parts[3].trim();
                String to = parts[4].trim();
                return new EventTask(taskName, isDone, from, to);
        }
        throw new IllegalArgumentException(); // maybe throw some exception
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