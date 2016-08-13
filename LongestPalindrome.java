package LinkedInQuestions.Strings;

/**
 * Created by rmukherj on 8/11/16.
 */
public class LongestPalindrome {

    public String longestPalindrome(String str){
        int start = 0, end=0;
        for(int i=0;i<str.length();i++){
            int len1 = expandAroundCenter(str,i,i);
            int len2 = expandAroundCenter(str,i,i+1);
            int len = Math.max(len1,len2);
            if(len>end-start){
                start = i-(len-1)/2;
                end = i+(len/2);
            }
        }

        return  str.substring(start, end+1);

    }


    private int expandAroundCenter(String s, int left, int right){

        while(left>=0&& right <s.length()&& s.charAt(left)== s.charAt(right)){
            left--;
            right++;
        }

        return left-right-1;
    }

}


