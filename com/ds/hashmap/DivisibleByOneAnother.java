package com.ds.hashmap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * InnerDivisibleByOneAnother
 */
class InnerDivisibleByOneAnother {
    static Set<Integer> findSpecialNumbers(List<Integer> list) {
        Set<Integer> hashSet = new HashSet<>();
        int maxValue = Integer.MIN_VALUE;
        for (Integer integer : list) {
            hashSet.add(integer);
            maxValue = Math.max(maxValue, integer);
        }
        Set<Integer> resultSet = new HashSet<Integer>();
        for (Integer integer : list) {
            if (integer > 0) {
                for (int j = integer*2; j <= maxValue; j+=integer) {
                    if(hashSet.contains(j)) resultSet.add(j);
                }
            }
        }
        return resultSet;
    }
}

/**
 * DivisibleByOneAnother
 * link https://www.geeksforgeeks.org/divisibility-check/
 */
public class DivisibleByOneAnother {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 3, 8, 6, 9, 10);
        System.out.println(InnerDivisibleByOneAnother.findSpecialNumbers(list));
    }
}