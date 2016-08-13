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


 class LongestPalinderomeSubString{
    private int lo, maxlen;
    public String longestPalindromeSubString(String str){
        int len = str.length();
        if(len<2){
            return str;
        }

        for(int i=0;i<len-1;i++){
            extendPalindrome(str,i,i); // assume odd length, try to extend the palindrome as possible.
            extendPalindrome(str,i,i+1); // assume even length.
        }

        return str.substring(lo, lo+maxlen);
    }

    private void extendPalindrome(String s, int left, int right){
        while(left>=0&& right<s.length()&& s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }

        if(maxlen<right-left-1){
            lo=left+1;
            maxlen = right-left-1;
        }
    }

    public static void main(String[] args) {
        LongestPalinderomeSubString lps = new LongestPalinderomeSubString();
        String str = "Rmanambiibiib";
        String result = lps.longestPalindromeSubString(str);
        System.out.println(result);


    }
    /*
    public class PalindromeLongestSubstring{
        int lo, maxlen;
        public String palindromeLongestSubstring(String str){
            int len = str.length();
            if(len <2){
                return str;
            }

            for(int i=0;i<len-1;i++){
                expandPalindrome(str,i,i); //even
                expandPalindrome(str, i, i+1); //odd
            }

            return str.substring(lo,lo+maxlen)
        }

        public void extendPalindrome(String s, int left, int right){
            while(left>=0 && right<str.length&& str.charAt(left) n== str.charAt(right)){
                left--;
                right++;
            }

            if(maxlen<right-left-1){
                lo=left+1;
                maxlen= right-left-1;
            }
        }

    }
     */

}