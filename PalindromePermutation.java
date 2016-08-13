package LinkedInQuestions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by rmukherj on 8/7/16.
 */
public class PalindromePermutation {

    private int[] buildCharFrequencyTable(String phrase) {
        int[] table =
                new int[
                        Character.getNumericValue('z') -
                        Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);

            if (x != -1) {
                table[x]++;
            }
        }

        return table;
    }

    // Map each character to a number a-0, b-1 etc
    private int getCharNumber(Character c){
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if(a<=val && val<=z){
            return val - a;
        }

        return -1;
    }

    private boolean checkMaxOneAdd(int[] table){
        boolean foundOdd = false;
        for(int count: table){
            if(count%2 ==1){
                if(foundOdd){
                    return false;
                }
                foundOdd = true;
            }
        }

        return true;

    }

    protected boolean isPermutationOfPalindrome(String phrase){
        int[] table = buildCharFrequencyTable(phrase);
        return checkMaxOneAdd(table);

    }

    //--------------buttercolasolution
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);

            if (map.containsKey(letter)) {
                int count = map.get(letter) + 1;
                map.put(letter, count);
            } else {
                map.put(letter, 1);
            }
        }

        int tolerance = 0;
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();

            if ((int) pair.getValue() % 2 != 0) {
                tolerance++;
            }
        }

        if (s.length() % 2 == 0) {
            return tolerance == 0;
        } else {
            return tolerance == 1;
        }
    }
    //---------------end
    public static void main(String[] args) {
        String ph = "Tact Coa";
        PalindromePermutation pp = new PalindromePermutation();
        boolean isTrue = pp.isPermutationOfPalindrome(ph);
    }

}
