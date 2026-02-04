package api;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import static java.nio.file.Files.walk;
import ui.showOptions;

public class LocalLibManager {
    private final Path LocalLib;

    public LocalLibManager() {
    this.LocalLib = Paths.get(System.getProperty("user.home"), ".user-library");
        try {
            Files.createDirectories(LocalLib);
        } catch (IOException e) {
            System.err.println("Failed to create local user lib directory: " + LocalLib);
            e.printStackTrace();
        }

    }

}
