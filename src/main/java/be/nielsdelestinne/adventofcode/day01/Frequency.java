package be.nielsdelestinne.adventofcode.day01;

import java.util.Arrays;

public class Frequency {

    private int currentValue;

    public int getCurrentValue() {
        return currentValue;
    }

    public void addChangesToFrequency(Integer... changes) {
        currentValue += Arrays.stream(changes)
                .mapToInt(Integer::intValue)
                .sum();
    }

}
