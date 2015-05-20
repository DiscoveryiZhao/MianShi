package DynamicProgramming.TwoSequences;

/**
 * Created by yizhao on 5/18/15.
 */
public class InterleavingString {
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";

        String s3 = "aadbbcbcac";
        String s4 = "aadbbbaccc";

        System. out.println(isInterleave(s1, s2, s3)); // true
        System. out.println(isInterleave(s1, s2, s4)); // false
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        if (n1 + n2 != n3) {
            return false ;
        } else {
            boolean[][] dp = new boolean[n1 + 1][n2 + 1];
            dp[0][0] = true; // Handles when both s1 == "" && s2 == ""
            for (int i = 0; i < n1 + 1; i++) {
                for (int j = 0; j < n2 + 1; j++) {
                    if (i == 0 && j > 0) { // Handles when s1 = ""
                        dp[0][j] = s2.charAt(j - 1) == s3.charAt(j - 1) && dp[0][j - 1] ? true : dp[0][j];
                    } else if (i > 0 && j == 0) { // Handles when s2 = ""
                        dp[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][0] ? true : dp[i][0];
                    } else if (i > 0 && j > 0) {
                        dp[i][j] = s1.charAt(i - 1) == s3.charAt(i - 1 + j) && dp[i - 1][j] ? true : dp[i][j];
                        dp[i][j] = s2.charAt(j - 1) == s3.charAt(i - 1 + j) && dp[i][j - 1] ? true : dp[i][j];
                    }
                }
            }
            return dp[n1][n2];
        }
    }

}