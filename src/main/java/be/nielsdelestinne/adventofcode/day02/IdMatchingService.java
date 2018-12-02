package be.nielsdelestinne.adventofcode.day02;

import be.nielsdelestinne.adventofcode.FileReader;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class IdMatchingService {


    private final FileReader fileReader;

    public IdMatchingService(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public String findFormattedMatchingBoxId(Path pathToFile) {
        return removeNonMatchingCharacter(
                calculateHammingDistanceBetweenAllBoxIds(pathToFile).stream()
                    .min(Comparator.comparingInt(result -> result.hammingDistance))
                    .orElseThrow(() -> new RuntimeException("Something went wrong ey...")));
    }

    private String removeNonMatchingCharacter(BoxIdComparison bestMatchingBoxIdComparison) {
        for (int i = 0; i < bestMatchingBoxIdComparison.firstBoxId.length(); i++) {
            if (bestMatchingBoxIdComparison.firstBoxId.charAt(i) != bestMatchingBoxIdComparison.secondBoxId.charAt(i)) {
                return bestMatchingBoxIdComparison.firstBoxId.substring(0, i)
                        + bestMatchingBoxIdComparison.firstBoxId.substring(i + 1);
            }
        }
        throw new RuntimeException("Something went wrong again, oh ow...");
    }

    private List<BoxIdComparison> calculateHammingDistanceBetweenAllBoxIds(Path pathToFile) {
        var boxIdDistanceComparisons = new ArrayList<BoxIdComparison>();
        var boxIds = fileReader.readFromFile(pathToFile).collect(toList());

        for (int i = 0; i < boxIds.size() - 1; i++) {
            for (int j = 1; j < boxIds.size(); j++) {
                if (areBoxIdsDifferent(boxIds.get(i), boxIds.get(j))) {
                    boxIdDistanceComparisons
                            .add(new BoxIdComparison(
                                    boxIds.get(i),
                                    boxIds.get(j),
                                    hammingDistance(boxIds.get(i), boxIds.get(j))));
                }
            }
        }
        return boxIdDistanceComparisons;
    }

    private boolean areBoxIdsDifferent(String firstBoxId, String secondBoxId) {
        return !firstBoxId.equals(secondBoxId);
    }

    private int hammingDistance(String firstBoxId, String secondBoxId) {
        var distance = 0;
        for (int i = 0; i < firstBoxId.length(); i++) {
            if (firstBoxId.charAt(i) != secondBoxId.charAt(i)) distance++;
        }
        return distance;
    }

    public static class BoxIdComparison {
        private final String firstBoxId;
        private final String secondBoxId;
        private final int hammingDistance;

        public BoxIdComparison(String firstId, String secondId, int hammingDistance) {
            this.firstBoxId = firstId;
            this.secondBoxId = secondId;
            this.hammingDistance = hammingDistance;
        }
    }

}
