package be.nielsdelestinne.adventofcode.day01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Frequency {

    private static final int MAX_AMOUNT_OF_REMAINING_ATTEMPTS = 500;

    private int currentValue;
    private Integer firstValueReachedTwice;
    private Set<Integer> previousValues;

    Frequency() {
        previousValues = new HashSet<>();
        previousValues.add(0);
    }

    int getCurrentValue() {
        return currentValue;
    }

    public Integer getFirstValueReachedTwice() {
        return firstValueReachedTwice;
    }

    Frequency addChangesToFrequency(Integer... changes) {
        currentValue += Arrays.stream(changes)
                .mapToInt(Integer::intValue)
                .sum();
        return this;
    }

    /**
     * @return  true  | if a duplicate frequency was found
     *          false | if no duplicate frequency was found
     *                | after {@link #MAX_AMOUNT_OF_REMAINING_ATTEMPTS the max amount of attempts}
     */
    boolean findFirstFrequencyReachedTwice(Integer... changes) {
        var performedAttempts = 0;
        while(performedAttempts < MAX_AMOUNT_OF_REMAINING_ATTEMPTS) {
            for (var change: changes) {
                currentValue += change;
                if(previousValues.contains(currentValue)) {
                    firstValueReachedTwice = currentValue;
                    return true;
                } else {
                    previousValues.add(currentValue);
                }
            }
            ++performedAttempts;
        }
        return false;
    }

}
