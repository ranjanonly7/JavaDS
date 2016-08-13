package LinkedInQuestions.DynamicProgramming;

/**
 * Created by rmukherj on 8/11/16.
 */
public class LongestCommonSubstring {

    public static int getLogestCommonSubstring(String a, String b){
        int m = a.length();
        int n = b.length();

        int max =0;

        int[][]dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(a.charAt(i) == b.charAt(j)){
                    if(i==0 || j==0){
                        dp[i][j]=1;
                    } else{
                        dp[i][j]=dp[i-1][j-1]+1;
                    }

                    if(max < dp[i][j]){
                        max = dp[i][j];
                    }
                }
            }
        }

        return max;
    }

    //longest substring with with two distinct
    public int lengthOfLongestSubstringTwoDistinct(String s){
        int i=0, j= -1 , maxlen=0;
        for(int k=0;k<s.length();k++){
            if(s.charAt(k) == s.charAt(k-1)) continue;;
            if(j>=0 && s.charAt(j)!=s.charAt(k)) {
                maxlen = Math.max(k-1, maxlen);
                i=j+1;
            }
            j=k-1;



            }

            return Math.max(s.length()-1,maxlen);
        }

    public static int getLongestCommonSubsequence(String a, String b){
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m+1][n+1];

        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }else if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }
    }


/*
public class LongestCommonSubstring {
    public static int getLongestCommonSubstring(String a, String b){
        int m = a.length();
        int n = b.length();
        int max = 0;

        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(a.charAt(i) == b.charAt(j)){
                    if(i==0 || j=0)
                    {
                        dp[i][j]=0;
                    } else {
                        dp[i][j[] = dp[i-1][j-1]+1;
                    }

                    if(max<dp[i][j])
                    max=dp[i][j]

                }
            }
        }

        return max;
    }

}
 */
