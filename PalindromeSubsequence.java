package LinkedInQuestions;

/**
 * Created by rmukherj on 7/29/16.
 */
public class PalindromeSubsequence {

    public static void main(String[] args) {
        int arr[] = new int[] {4,1,2,3,4,5,6,5,4,3,4,4,4,4,4,4,4};
        System.out.println(maxLengthPalindrome(arr, 0, arr.length-1));
    }

    public static int maxLengthPalindrome(int[] values, int i, int j) {
        //check if indexes cross each other
        //return 1 if index overlap for else condition below
        //return 0 if index i<j for condition if below
        if(j<=i) return j-i+1;
        if(values[i]==values[j]) return 2 + maxLengthPalindrome(values, i+1, j-1);
        else return Math.max(
                maxLengthPalindrome(values, i+1, j),
                maxLengthPalindrome(values, i, j-1));
    }

}

class A {
    public static void main(String[] args){
        int arr[] = new int[] {6,5,4,1,4,5,6, 2,3,4};
        System.out.println(maxLengthPalindrome(arr,0,arr.length-1));
        System.out.println(dpLps(arr, 0, arr.length-1, new Integer[arr.length][arr.length]));

    }

    public static int maxLengthPalindrome(int[] values, int i, int j){
        //check if indexes cross each other
        //return 1 if index overlap for else condition below
        //return 0 if index i<j for condition if below
        if(j<=i) return j-i+1;
        if(values[i] == values[j]){
            return 2 + maxLengthPalindrome(values, i+1, j-1);
        } else {
            return Math.max(maxLengthPalindrome(values, i+1, j), maxLengthPalindrome(values,i,j-1));
        }
    }

    public static int dpLps(int[] a, int i, int j, Integer[][] lps) {
        if (i > j)
            return 0;
        if (lps[i][j] == null) {
            if (i == j) {
                lps[i][j] = 1;
            } else {
                if (a[i] == a[j]) {
                    lps[i][j] = 2 + dpLps(a, i + 1, j - 1, lps);
                } else {
                    lps[i][j] = Math.max(dpLps(a, i + 1, j, lps),
                            dpLps(a, i, j - 1, lps));
                }
            }
        }
        return lps[i][j];
    }
}



