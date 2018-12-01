package be.nielsdelestinne.adventofcode.day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FrequencyUnitTest {

    private Frequency frequency;

    @BeforeEach
    void setupFrequency() {
        frequency = new Frequency();
    }

    @Test
    void givenNewFrequency_thenCurrentValueIsEqualToZero() {
        assertEquals(0, frequency.getCurrentValue());
    }

    @Test
    void givenNewFrequency_whenAddingAChangeToFrequency_thenCurrentValueIsEqualToChange() {
        frequency.addChangesToFrequency(5);

        assertEquals(5, frequency.getCurrentValue());
    }

    @ParameterizedTest
    @CsvSource({"1,1,1,3", "1,1,-2,0", "-1,-2,-3,-6"})
    void givenNewFrequency_whenAddingMultipleChangesToFrequency_thenFinalCurrentValueOfFrequencyIsCorrect(int firstChange, int secondChange, int thirdChange, int expectedFrequencyValue) {
        frequency.addChangesToFrequency(firstChange, secondChange, thirdChange);

        assertEquals(expectedFrequencyValue, frequency.getCurrentValue());
    }
}