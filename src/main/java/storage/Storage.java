package storage;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import task.*;

public class Storage {
    private final String filePath;

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

    public TaskList load() {
        File f = new File(filePath);
        ArrayList<Task> loadedTasks = new ArrayList<>();

        if (!f.exists()) {
            try {
                f.getParentFile().mkdirs(); // make directories
                f.createNewFile();          // make empty file
            } catch (IOException e) {
                System.out.println("Could not create save file: " + e.getMessage());
            }
            return new TaskList(); // empty task list
        }

        try (Scanner sc = new Scanner(f)) { // try-with-resources auto-closes
            while (sc.hasNextLine()) {
                String storedTask = sc.nextLine();
                try {
                    Task parsedTask = parseTask(storedTask);
                    loadedTasks.add(parsedTask);
                } catch (IllegalArgumentException e) {
                    System.out.println("Skipping bad task line: " + storedTask);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found, starting with empty task list.");
        }
        return new TaskList(loadedTasks);
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
                LocalDate by = LocalDate.parse(parts[3].trim());
                return new DeadlineTask(taskName, isDone, by);
            case "E":
                LocalDate from = LocalDate.parse(parts[3].trim());
                LocalDate to = LocalDate.parse(parts[4].trim());
                return new EventTask(taskName, isDone, from, to);
        }
        throw new IllegalArgumentException(); // maybe throw some exception
    }
}