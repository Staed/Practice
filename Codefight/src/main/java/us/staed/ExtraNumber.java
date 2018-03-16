package us.staed;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class ExtraNumber {
    public static void main(String ...args) {
        List<Integer[]> testCases = Arrays.asList(
            new Integer[] {2, 7, 2},
            new Integer[] {3, 2, 2},
            new Integer[] {5, 5, 1},
            new Integer[] {3, 6, 6, 3, 7, 3}
        );

        testCases.stream()
            .map(ExtraNumber::extraNumber)
            .forEach(System.out::println);
    }

    private static int extraNumber(Integer ...ints) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        
        Arrays.asList(ints).stream()
            .forEach(e -> {
                if (seen.contains(e))
                    duplicates.add(e);
                else
                    seen.add(e);
            });
        
        seen.removeAll(duplicates);
            
        return seen.stream().findAny().get();
    }
}