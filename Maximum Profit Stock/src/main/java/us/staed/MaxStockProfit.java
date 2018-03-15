package us.staed;

import java.util.*;
import java.util.stream.*;
import javafx.util.Pair;

public class MaxStockProfit {
    public static void main(String ...args) {
        List<List<Integer>> testCases = Arrays.asList(
            Arrays.asList(100, 180, 260, 310, 40, 535, 695),
            Arrays.asList(10, 18, 26, 31, 40, 53, 12)
        );

        testCases.stream()
            .map(MaxStockProfit::difference)
            .map(a -> "(" + a.getKey() + ", " + a.getValue() + ")")
            .forEach(System.out::println);
    }

    private static Pair<Integer, Integer> difference(List<Integer> list) {
        // Approach the problem by breaking the array into subarrays, 
        // divided by the local maximums. Then compute the largest
        // difference in each subarray and compare the subarray results

        List<List<Integer>> subarrays = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        int curMax = Integer.MIN_VALUE;

        // O(n)
        // Divide into sub-arrays by local maximums
        for (Integer i : list) {
            if (i > curMax) {
                curMax = i;
                if (!curList.isEmpty())
                    subarrays.add(curList);
                curList = new ArrayList<>();
            }
            curList.add(i);
        }

        // O(1)
        // Handle empty list case
        if (curList.isEmpty() && subarrays.isEmpty()) {
            curList.add(0);
            subarrays.add(curList);
        } else {
            subarrays.add(curList);
        }

        Map<Integer, List<Integer>> section = new HashMap<>();
        Map<Integer, Integer> minMap = new HashMap<>();

        // O(n)
        // Stream through it
        int maxDiff = subarrays.stream()
            .filter(a -> a.size() > 1)
            .map(b -> {
                int max = b.get(0);
                int min = b.stream().min(Integer::min).get();

                section.put(max - min, b);
                minMap.put(max - min, min);

                return max - min;
            })
            .filter(a -> a > 0)
            .max(Integer::max).orElse(-1);
        
        // Return the indices of the best stock buy/sell or (-1,-1) if it doesn't exist
        if (maxDiff < 0) {
            return new Pair<>(-1,-1);
        } else {
            List<Integer> sub = section.get(maxDiff);
            int start = Collections.indexOfSubList(list, sub);
            int end = start + list.subList(start, start + sub.size()).indexOf(minMap.get(maxDiff));

            return new Pair<>(start, end);
        }
    }
}