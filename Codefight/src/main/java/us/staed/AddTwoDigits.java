package us.staed;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class AddTwoDigits {
    public static void main(String ...args) {
        List<Integer> testCases = Arrays.asList(29, 34, 81);
        testCases.stream()
            .map(AddTwoDigits::addTwoDigits)
            .collect(ArrayList::new, List::add, List::addAll)
            .stream()
            .peek(System.out::println)
            .count();
    }

    private static int addTwoDigits(int n) {
        return (n + "").chars().mapToObj(i -> (char)i)
            .map(a -> a + "")
            .mapToInt(Integer::parseInt).sum();
    }
}