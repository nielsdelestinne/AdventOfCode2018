package be.nielsdelestinne.adventofcode.day01;

import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FrequencyServiceTest {

    @Test
    void applyFrequencyChanges() throws URISyntaxException {
        FrequencyService frequencyService = new FrequencyService(new FileReader(), new Interpreter());

        Frequency frequency = frequencyService
                .ApplyFrequencyChanges(Paths.get(getClass().getResource("/"+"FileWithTestChanges.txt").toURI()));

        assertEquals(592, frequency.getCurrentValue());
    }
}