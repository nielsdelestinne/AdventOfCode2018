package be.nielsdelestinne.adventofcode.day01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

class FileReader {

    Stream<String> readFromFile(Path path) throws IOException {
        return Files.lines(path);
    }

}
