package us.staed;

import java.util.Arrays;
import java.util.List;

public class LateRide {
    public static void main(String... args) {
        List<Integer> testCases = Arrays.asList(240, 808, 1439, 0);

        testCases.stream()
            .map(LateRide::lateRide)
            .forEach(System.out::println);

    }

    private static int lateRide(int n) {
        return Arrays.asList(n%60, n/60).stream()
            .map(a -> (a + "").chars()
                .mapToObj(b -> (char) b)
                .map(b -> b + "")
                .mapToInt(Integer::parseInt)
                .reduce((u,v) -> u + v)
            )
            .mapToInt(a -> a.getAsInt())
            .sum();
    }
}