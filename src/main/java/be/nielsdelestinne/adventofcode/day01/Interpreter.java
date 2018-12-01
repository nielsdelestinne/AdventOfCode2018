package be.nielsdelestinne.adventofcode.day01;

import java.util.stream.Stream;

public class Interpreter {

    public Integer[] interpret(Stream<String> changesAsString) {
        return changesAsString
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }

}
