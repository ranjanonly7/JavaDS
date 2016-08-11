package LinkedInQuestions;

/**
 * Created by rmukherj on 7/29/16.
 */
class PalindeRomeDP {
    int [] values;
    int [][] solved;

    PalindeRomeDP(int [] values) {
        this.values = values;
        // provide correct order of execution
        solved = new int[values.length][values.length];

    }

    public int solve() {

        // solve problems in correct order
        for (int len = 2; len <= values.length; len++) {
            for (int i = 0; i < values.length - len; i++) {
                solve(i, i+len-1);
            }
        }
        // solve final problem
        return solve(0, values.length-1);
    }

    private int solve(int i, int j) {
        //check if indexes cross each other
        //return 1 if index overlap for else condition below
        //return 0 if index i<j for condition if below
        if(j == i) return 1;
        if (j < i) return 0;
        if (solved[i][j] > 0) return solved[i][j];

        int solution;
        if (values[i] == values[j]) solution = 2 + solve(i+1,j-1);
        else solution = Math.max(solve(i+1, j), solve(i, j-1));
        solved[i][j] = solution;
        return solution;

    }

   /*

    */
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++; }
        return R - L - 1;
    }


    public static void main(String[] args) {
        int arr[] = new int[] {6,5,4,1,4,5,6, 2,3,4};
        PalindeRomeDP pal = new PalindeRomeDP(arr);
        System.out.println(pal.solve());
    }

}

