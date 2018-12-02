package be.nielsdelestinne.adventofcode.day02;

import be.nielsdelestinne.adventofcode.FileReader;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChecksumServiceTest {

    @Test
    void givenInputDataOfIds_whenCalculatingCheckSum_thenCorrectChecksumShouldBeReturned() throws URISyntaxException {
        ChecksumService checksumService = new ChecksumService(new FileReader());

        int actualChecksum = checksumService
                .calculateCheckSum(Paths.get(getClass().getResource("/" + "Day2SampleInputDataFile.txt").toURI()));

        assertEquals(12, actualChecksum);
    }

    @Test
    void day1Challenge1_happyPath() throws URISyntaxException {
        ChecksumService checksumService = new ChecksumService(new FileReader());

        int actualChecksum = checksumService
                .calculateCheckSum(Paths.get(getClass().getResource("/" + "Day2InputDataFile.txt").toURI()));

        assertEquals(6888, actualChecksum);
    }
}