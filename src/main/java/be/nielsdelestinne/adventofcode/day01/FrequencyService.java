package be.nielsdelestinne.adventofcode.day01;

import java.io.IOException;
import java.nio.file.Path;

class FrequencyService {

    private final FileReader fileReader;
    private final Interpreter interpreter;

    FrequencyService(FileReader fileReader, Interpreter interpreter) {
        this.fileReader = fileReader;
        this.interpreter = interpreter;
    }

    Frequency day1Challenge1(Path pathToFileWithChanges) {
        Frequency frequency = new Frequency();

        try {
            frequency.addChangesToFrequency(
                    interpreter.interpret(
                            fileReader.readFromFile(pathToFileWithChanges)));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return frequency;
    }

    Integer day1Challenge2(Path pathToFileWithChanges) {
        try {
            Frequency frequency = new Frequency();
            if (isAFrequencyReachedTwice(pathToFileWithChanges, frequency)) {
                return frequency.getFirstValueReachedTwice();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private boolean isAFrequencyReachedTwice(Path pathToFileWithChanges, Frequency frequency) throws IOException {
        return frequency.findFirstFrequencyReachedTwice(
                interpreter.interpret(
                        fileReader.readFromFile(pathToFileWithChanges)));
    }


}
