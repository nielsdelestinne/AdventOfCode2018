package be.nielsdelestinne.adventofcode.day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FrequencyServiceTest {

    private FrequencyService frequencyService;

    @BeforeEach
    void serviceSetup() {
        frequencyService = new FrequencyService(new FileReader(), new Interpreter());
    }

    @Test
    void day1Challenge1_happyPath() throws URISyntaxException {
        Frequency frequency = frequencyService
                .day1Challenge1(Paths.get(getClass().getResource("/"+"Day1InputDataFile.txt").toURI()));

        assertEquals(592, frequency.getCurrentValue());
    }

    @Test
    void day1Challenge2_happyPath() throws URISyntaxException {
        var actualResult = frequencyService
                .day1Challenge2(Paths.get(getClass().getResource("/"+"Day1InputDataFile.txt").toURI()));

        assertEquals(241, actualResult.intValue());
    }
}