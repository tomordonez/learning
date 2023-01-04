package com.tom.S5_Abstraction.abstractfilereader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public abstract class AbstractFileReader {
    private final Path filePath;

    protected AbstractFileReader(Path filePath) throws IOException {
        this.filePath = filePath;
    }

    public Path getFilePath() {
        return filePath;
    }

    public static ArrayList<String> readFile(String path) throws IOException {
        Path filePath = Path.of(path);
        return (ArrayList<String>) Files.readAllLines(filePath);
    }
}
