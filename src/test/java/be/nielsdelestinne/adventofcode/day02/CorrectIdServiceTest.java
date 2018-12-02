package be.nielsdelestinne.adventofcode.day02;

import be.nielsdelestinne.adventofcode.FileReader;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class CorrectIdServiceTest {

    @Test
    void givenInputDataOfIds_whenCalculatingMatchingIds_thenCorrectChecksumShouldBeReturned() throws URISyntaxException {
        IdMatchingService service = new IdMatchingService(new FileReader());

        var resultingId = service
                .findFormattedMatchingBoxId(Paths.get(getClass().getResource("/" + "Day2SampleInputChallenge2DataFile.txt").toURI()));

        assertEquals("fgij", resultingId);
    }

    @Test
    void day2Challenge2_happyPath() throws URISyntaxException {
        IdMatchingService service = new IdMatchingService(new FileReader());

        var resultingId = service
                .findFormattedMatchingBoxId(Paths.get(getClass().getResource("/" + "Day2InputDataFile.txt").toURI()));

        assertEquals("icxjvbrobtunlelzpdmfkahgs", resultingId);
    }

}