package LinkedInQuestions.bc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by rmukherj on 7/21/16.
 */
public class Romans2Integer {

    static final List<Mapping> mapping = new ArrayList<Mapping>() {{
        add(new Mapping('I',1));
        add(new Mapping('V',5));
        add(new Mapping('X',10));
        add(new Mapping('L',50));
        add(new Mapping('C',100));
        add(new Mapping('D',500));
        add(new Mapping('M',1000));
    }};

    public static int getInteger(String symbol){

        int curVal;
        int oldVal = 0;
        int result = 0;
//add validation

        for(int i=symbol.length() - 1;i>=0;i--){
            curVal =  getMappingValue(symbol.charAt(i));

            if ( curVal < oldVal)
                result = result - curVal;
            else
                result = result + curVal;

            oldVal = curVal;
        }

        return result;
    }

    private static int getMappingValue(char input){
        Optional<Mapping> result = mapping.stream().filter(map -> map.getSymbol() == input).findAny();
        return (result.isPresent()? result.get().getValue():0);
    }

    public static void main(String[] args) {
        System.out.println(Romans2Integer.getInteger("MCMLXXXIV"));//1984
        System.out.println(Romans2Integer.getInteger("IL"));//49
        System.out.println(Romans2Integer.getInteger("CIV"));//104
        System.out.println(Romans2Integer.getInteger("MCMIV"));//1904
        System.out.println(Romans2Integer.getInteger("MCMLIV"));//1954
        System.out.println(Romans2Integer.getInteger("MCMXC"));//1990
        System.out.println(Romans2Integer.getInteger("MMXIV"));//2014
    }


}
