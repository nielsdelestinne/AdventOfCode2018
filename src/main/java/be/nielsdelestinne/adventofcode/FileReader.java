package be.nielsdelestinne.adventofcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileReader {

    public Stream<String> readFromFile(Path path) {
        try {
            return Files.lines(path);
        } catch (IOException e) {
            return null; // Don't want to deal with this now.
        }
    }

}
