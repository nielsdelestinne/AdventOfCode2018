package be.nielsdelestinne.adventofcode.day01;

import be.nielsdelestinne.adventofcode.FileReader;

import java.nio.file.Path;

class FrequencyService {

    private final FileReader fileReader;
    private final Interpreter interpreter;

    FrequencyService(FileReader fileReader, Interpreter interpreter) {
        this.fileReader = fileReader;
        this.interpreter = interpreter;
    }

    Frequency day1Challenge1(Path pathToFileWithChanges) {
        return new Frequency()
                .addChangesToFrequency(
                        interpreter.interpret(
                                fileReader.readFromFile(pathToFileWithChanges)));
    }

    Integer day1Challenge2(Path pathToFileWithChanges) {
        Frequency frequency = new Frequency();
        if (isAFrequencyReachedTwice(pathToFileWithChanges, frequency)) {
            return frequency.getFirstValueReachedTwice();
        }
        return null;
    }

    private boolean isAFrequencyReachedTwice(Path pathToFileWithChanges, Frequency frequency) {
        return frequency.findFirstFrequencyReachedTwice(
                interpreter.interpret(
                        fileReader.readFromFile(pathToFileWithChanges)));
    }


}
