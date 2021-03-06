package DynamicProgramming.TwoSequencesDP;

/**
 * Created by yizhao on 5/18/15.
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(LCS("ABCD", "EDCA")); // 1, the LCS is "A" (or "D", "C"), return 1.
        System.out.println(LCS("ABCD", "EACB")); // 2, the LCS is "AC", return 2.
        System.out.println(LCS("ABCBDAB", "BDCABA")); // 4, the LCS is "BDAB" , return 4.
    }

    public static int LCS(String S, String T) {
        int m = S.length(), n = T.length();
        // state:f[i][j]表示前i个字符配上前j个字符的LCS的长度
        int[][] f = new int[m + 1][n + 1];
        // function: f[i][j] = f[i-1][j-1] + 1 when a[i] == b[j]
        //                   = MAX(f[i-1][j],f[i][j-1]) when a[i]!=b[j]
        // 这里的f[i-1][j]代表i不在LCS中
        // 这里的f[i][j-1]代表j不在LCS中
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }
        return f[m][n];
    }
}
