package us.staed;

import java.util.List;

import javax.lang.model.util.ElementScanner6;

import java.util.Arrays;

public class PhoneCall {
    public static void main(String ...args) {
        List<Integer[]> testCases = Arrays.asList(
            new Integer[] {3, 1, 2 ,20},
            new Integer[] {2, 2, 1, 2}
        );

        testCases.stream()
            .map(a -> phoneCall(a[0], a[1], a[2], a[3]))
            .forEach(System.out::println);
    }

    private static int phoneCall(int min1, int min2_10, int min11, int s) {
        int fst = s >= min1 ? 1 : 0;
        int sec = Math.min(9, Math.max(0, (s - min1)/min2_10));
        int thr = Math.max(0, (s - (9*min2_10 + min1))/min11);

        return fst + sec + thr;
    }
}