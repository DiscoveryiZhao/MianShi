package DynamicProgramming.TwoSequences;

/**
 * Created by yizhao on 5/18/15.
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System. out.println(LCS( "ABCBDAB", "BDCABA" )); // 4
    }

    public static int LCS(String S, String T) {
        int m = S.length(), n = T.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math. max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}