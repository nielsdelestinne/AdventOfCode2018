package be.nielsdelestinne.adventofcode.day01;

import java.io.IOException;
import java.nio.file.Path;

public class FrequencyService {

    private final FileReader fileReader;
    private final Interpreter interpreter;

    public FrequencyService(FileReader fileReader, Interpreter interpreter) {
        this.fileReader = fileReader;
        this.interpreter = interpreter;
    }

    public Frequency ApplyFrequencyChanges(Path pathToFileWithChanges) {
        Frequency frequency = new Frequency();

        try {
            frequency.addChangesToFrequency(
                    interpreter.interpret(
                            fileReader.readFromFile(pathToFileWithChanges)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return frequency;
    }

}
