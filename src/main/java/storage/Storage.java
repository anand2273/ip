package storage;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import tasks.TaskList;
import tasks.Task;

public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public void save(ArrayList<Task> tasks) {
        return; // implement later
    }

    public void load() {
        return; // implement this later
    }


}