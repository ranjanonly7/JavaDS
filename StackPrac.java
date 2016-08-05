package tryingsomething;

import java.util.Stack;

/**
 * Created by rmukherj on 7/26/16.
 */

public final class Something{
    public String Obvious(String name){
        return "Ranjan";
    }
}

public class StackPrac {
    public static String sbu = "Harry has a heart";
    public static Stack<String> sb = new Stack<>();

    public static void reverse(String s1){
        int i=0;
        String[] arr = sbu.split(" ");
        for (String a: arr
             ) {
            sb.push(a);
            sb.push(" ");

        }

        while(!sb.isEmpty()){
            s1 += sb.pop();
        }

        System.out.println(s1);
    }

    public static void wordRotate(String word, Integer length){
        if(length>0) {
            //for(int i =word.length();i>0;i--) {
            Character first = word.charAt(0);
            String s = word.substring(1);
            //String rem = s + first;
            String rem = s + first;
            System.out.println(rem);
            wordRotate(rem, length - 1);
        }

    }

    public static String wordReverse(String word){
        if(null == word || word.length()<=1){
            return word;
        }

        return wordReverse(word.substring(1))+word.charAt(0);
    }

    public static void pascalTriangle(int n){

    }

    public static void main(String[] args){
        StackPrac spi= new StackPrac();

        spi.reverse("");

        String w = "ranjan";
        wordRotate(w, w.length());

       String str = wordReverse(w);
        System.out.println("The reverse string passed is "+str);
        Something s = new Something();
        String c = s.Obvious("Hello");
        System.out.println(c);
        s = new Something();
    }


}

