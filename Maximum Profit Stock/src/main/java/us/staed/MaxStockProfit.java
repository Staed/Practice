package us.staed;

import java.util.*;
import java.util.stream.*;
import javafx.util.Pair;

public class MaxStockProfit {
    public static void main(String ...args) {
        List<List<Integer>> testCases = Arrays.asList(
            Arrays.asList(100, 180, 260, 310, 40, 535, 695)
        );

        testCases.stream()
            .forEach(MaxStockProfit::difference);
    }

    private static void difference(List<Integer> list) {
        System.out.println(
            list.stream()
                .collect(StringBuilder::new, (a,b) -> a.append(", " + b), StringBuilder::append)
                .delete(0,2).toString()
        );

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
        if (curList.isEmpty()) curList.add(0);
        if (subarrays.isEmpty()) subarrays.add(curList);

        Map<Integer, Integer> pair = new HashMap<>();

        // O(n)
        // Stream through it
        int maxValue = subarrays.stream()
            .filter(a -> a.size() > 1)
            .map(b -> {
                int max = b.stream().max(Integer::max).get();
                int min = b.stream().min(Integer::min).get();
                pair.put(max - min, b.indexOf(min));
                return max - min;
            })
            .filter(a -> a > 0)
            .max(Integer::max).get();
        
        System.out.println(maxValue);

        // Need to access Optional, after it is set to return an actual value
        // Use some other lambda

        // int end = pair.get(maxValue);
        // int start = list.subList(0, end).lastIndexOf(maxValue);
        
        // System.out.println(start + ", " + pair.get(maxValue.get()));
    }
}