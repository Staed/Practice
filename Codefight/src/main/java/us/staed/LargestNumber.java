package us.staed;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LargestNumber {
    public static void main(String ...args) {
        List<Integer> testCases = Arrays.asList(2, 4, 1, 0);

        testCases.stream()
            .map(LargestNumber::largestNumber)
            .forEach(System.out::println);
    }

    private static int largestNumber(int n) {
        if (n < 1) return 0;

        return Integer.parseInt(
            Stream.generate(() -> 9)
            .limit(n)
            .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
            .toString()
        );
    }
}