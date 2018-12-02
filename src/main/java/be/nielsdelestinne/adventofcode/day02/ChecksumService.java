package be.nielsdelestinne.adventofcode.day02;

import be.nielsdelestinne.adventofcode.FileReader;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ChecksumService {

    private final FileReader fileReader;

    public ChecksumService(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public int calculateCheckSum(Path pathToFileContainingIds) {
         return fileReader.readFromFile(pathToFileContainingIds)
                .map(id -> id.chars()
                        .mapToObj(charCodePoint -> String.valueOf((char) charCodePoint))
                        .collect(Collectors.groupingBy(idAsString -> idAsString)))
                 .map(this::calculateResult)
                 .reduce((result1, result2) -> new Result(result1.amountOfPairs + result2.amountOfPairs,
                         result1.amountOfTriplets + result2.amountOfTriplets))
                 .orElseThrow(() -> new RuntimeException("Something went wrong"))
                 .getChecksum();
    }

    private Result calculateResult(Map<String, List<String>> mapGroupedByLetter) {
        var result = new Result(0,0);
        for (var distinctChar: mapGroupedByLetter.values()) {
            if(bothPairAndTripletFound(result)) { break; }
            if(pairFound(result, distinctChar)) { result.amountOfPairs = 1; }
            else if(tripletFound(result, distinctChar)) { result.amountOfTriplets = 1; }
        }
        return result;
    }

    private boolean tripletFound(Result result, List<String> distinctChar) {
        return distinctChar.size() == 3 && result.amountOfTriplets == 0;
    }

    private boolean pairFound(Result result, List<String> distinctChar) {
        return distinctChar.size() == 2 && result.amountOfPairs == 0;
    }

    private boolean bothPairAndTripletFound(Result result) {
        return result.amountOfPairs != 0 && result.amountOfTriplets != 0;
    }

    private static class Result {

        private int amountOfPairs;
        private int amountOfTriplets;

        Result(int amountOfPairs, int amountOfTriplets) {
            this.amountOfPairs = amountOfPairs;
            this.amountOfTriplets = amountOfTriplets;
        }

        int getChecksum() {
            return amountOfPairs * amountOfTriplets;
        }

    }
}