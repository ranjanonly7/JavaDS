package LinkedInQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by rmukherj on 8/1/16.
 * /*Suppose you have a long flowerbed in which some of the plots are planted and
 * some are not. However, flowers cannot be planted in adjacent plots -
 * they would compete for water and both would die.
 * Given a flowerbed (represented as an array containing booleans),
 * return if a given number of new flowers can be planted in it without
 * violating the no-adjacent-flowers rule
 Sample inputs

 Input: 1,0,0,0,0,0,1,0,0

 3 => true
 4 => false
 Input: 1,0,0,1,0,0,1,0,0

 1 => true
 2 => false
 input: 0

 1 => true
 2 => false */

public class CanbePlaced {

    public static boolean canPlaceFlowers(List<Boolean> flowerbed, int numberToPlace) {
        int capacity = 0;
        int size = flowerbed.size();
        for (int i = 0; i < size; i++) {
            if(flowerbed.get(i)) {
                i ++;
            } else {
                if (i == size - 1 || !flowerbed.get(i + 1)) {
                    capacity ++;
                    i ++;
                }
            }
        }

        return numberToPlace <= capacity;
    }

    public static void main(String[] args) {
        List<Integer> asList = new ArrayList<>();
        Integer arr[] = {0,0,1,0,0,1,0,0};
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(arr));

        System.out.println(canPlaceFlowers(toBools(list), 2));
    }

    private static List<Boolean> toBools(List<Integer> integers) {
        return integers.stream().map(e -> e == 1).collect(Collectors.toList());
    }
}
