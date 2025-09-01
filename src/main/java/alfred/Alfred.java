import java.io.IOException;
import java.util.Scanner;

import command.Command;
import exceptions.AlfredException;
import parser.Parser;
import storage.Storage;
import task.TaskList;
import ui.Ui;

public class Alfred {
    public static void main(String[] args) {
        Ui ui = new Ui();
        Storage storage = new Storage("data/alfred.txt");
        TaskList tasks = storage.load();              // load tasks at startup

        ui.showWelcome();

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                if (!sc.hasNextLine()) break;        // EOF ends program cleanly
                String line = sc.nextLine();

                try {
                    Command cmd = Parser.parse(line); // parse user input → Command
                    cmd.execute(tasks, ui);           // perform action (no Storage here)

                    if (cmd.isExit()) {
                        // Save once, right before exiting
                        try {
                            storage.save(tasks);
                        } catch (IOException e) {
                            ui.showError("Failed to save tasks: " + e.getMessage());
                        }
                        ui.showBye();
                        break;
                    }
                } catch (AlfredException de) {
                    ui.showError(de.getMessage());    // friendly domain errors
                } catch (Exception e) {
                    ui.showError("Unexpected error: " + e.getMessage());
                }
            }
        }
    }

    public String getResponse(String input) {
        return "Alfred heard: " + input;
    }
}
