package LinkedInQuestions;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public final static Map<Character, Integer> romanNumberMap =
            new HashMap<Character, Integer>(){
                {
                    this.put('I', 1);
                    this.put('V', 5);
                    this.put('X', 10);
                    this.put('L', 50);
                    this.put('C', 100);
                    this.put('D', 500);
                    this.put('M', 1000);
                }
            };



    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("I="+ romanNumber("I"));
        System.out.println("III=" + romanNumber("III"));
        System.out.println("VI=" + romanNumber("VI"));
        System.out.println("XVI=" + romanNumber("XVI"));
        System.out.println("IV=" + romanNumber("IV"));
        System.out.println("IX=" + romanNumber("IX"));
        System.out.println("XIV=" + romanNumber("XIV"));
        System.out.println("LXCIV=" + romanNumber("LXCIV"));
    }

    private static int romanNumber(String roman) {
        // TODO Auto-generated method stub
        int result =0;
        char[] romanChars= roman.toCharArray();
        char prevChar = '\0';
        for(Character c : romanChars) {
            if(!romanNumberMap.containsKey(c)) {
                throw new IllegalArgumentException("Not a vlaid roman number");
            }

            result +=romanNumberMap.get(c);
            if(prevChar != '\0' && romanNumberMap.get(prevChar)<romanNumberMap.get(c)) {
                result -=romanNumberMap.get(prevChar)*2;
            }

            prevChar =c;
        }
        return result;
    }

}

