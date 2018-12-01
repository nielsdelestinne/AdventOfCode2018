package be.nielsdelestinne.adventofcode.day01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileReader {

    public Stream<String> readFromFile(Path path) throws IOException {
        return Files.lines(path);
    }

}
