package LinkedInQuestions.Strings;

import java.util.Set;

/**
 * Created by rmukherj on 8/12/16.
 */
public class WordBreak {

    /*
    Naive Approach
     */

    public boolean wordBreak(String s, Set<String> dict){
        return wordBreakHelper(s,dict,0);
    }

    private boolean wordBreakHelper(String s, Set<String> dict, int start){
        if(start == s.length()){
            return true;
        }

        for(String a: dict) {
            int len = a.length();
            int end = start + len;

            //end index should be <= string length

            if(end>s.length())
                continue;

            if(s.substring(start, start+len).equals(a))
                if(wordBreakHelper(s,dict,start+len))
                    return true;
        }

        return false;
    }

    public static void main(String[] args) {

    }

}
