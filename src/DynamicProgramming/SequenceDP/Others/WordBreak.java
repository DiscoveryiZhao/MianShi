package DynamicProgramming.SequenceDP.Others;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yizhao on 5/18/15.
 */
public class WordBreak {
    public static void main(String[] args) {
        Set<String> test1 = new HashSet<>();
        test1.add("leet");
        test1.add("code");
        System.out.println(wordBreak("leetcode", test1)); // true

        Set<String> test2 = new HashSet<>();
        test2.add("a");
        System.out.println(wordBreak("a", test2)); // true

        Set<String> test3 = new HashSet<>();
        test3.add("aaaa");
        test3.add("aa");
        System.out.println(wordBreak("aaaaaaa", test3)); // false

        Set<String> test4 = new HashSet<>();
        test4.add("a");
        test4.add("b");
        System.out.println(wordBreak("ab", test4)); // true

        Set<String> test5 = new HashSet<>();
        test5.add("pear");
        test5.add("apple");
        test5.add("peach");
        System.out.println(wordBreak("apple", test5)); // true

        Set<String> test6 = new HashSet<String>();
        String[] test6StringA = {"cbc", "bcda", "adb", "ddca", "bad", "bbb", "dad", "dac", "ba", "aa", "bd", "abab", "bb", "dbda", "cb", "caccc", "d", "dd", "aadb", "cc", "b", "bcc", "bcd", "cd", "cbca", "bbd", "ddd", "dabb", "ab", "acd", "a",
                "bbcc", "cdcbd", "cada", "dbca", "ac", "abacd", "cba", "cdb", "dbac", "aada", "cdcda", "cdc", "dbc", "dbcb", "bdb", "ddbdd", "cadaa", "ddbc", "babb"};
        for (String s : test6StringA)
            test6.add(s);
        System.out.println(wordBreak("bccdbacdbdacddabbaaaadababadad", test6)); // true

        Set<String> test7 = new HashSet<>();
        test7.add("a");
        test7.add("b");
        System.out.println(wordBreak("aabaaa", test7));// true

        Set<String> test8 = new HashSet<>();
        test8.add("a");
        test8.add("c");
        System.out.println(wordBreak("aaabaac", test8)); // false

        Set<String> test9 = new HashSet<String>();
        // "cat", "cats", "and", "sand", "dog"
        test9.add("cat");
        test9.add("cats");
        test9.add("and");
        test9.add("sand");
        test9.add("dog");
        System.out.println(wordBreak("catsanddog", test9)); // true
    }

    public static boolean wordBreak(String s, Set<String> dict) {
        return wordBreakDP(s, dict);
    }

    public static boolean wordBreakDP(String s, Set<String> dict) {
        int n = s.length();
        // state: f[i]表示“前i”个字符能否被dict完美切分
        boolean[] f = new boolean[n + 1]; //
        // intialize for worst case: case for s = ""
        f[0] = true;
        // function: f[i] = true when j < i && f[j] = true && j..i-1是一个dict里的单词
        // f[j]代表reuse旧的，看下0..j-1是一个dict里的单词
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] && dict.contains(s.substring(j, i))) {
                    f[i] = true;
                }
                //dp[i] = dp[j] && dict.contains(s.substring(j, i)) ? true : dp[i];
            }
        }
        return f[n];
    }

    public static boolean dfs(String s, Set<String> dict) {
        int n = s.length();
        if (n == 0) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            if (dict.contains(s.substring(0, i + 1))) {
                if (dfs(s.substring(i + 1), dict)) {
                    return true;
                }
            }
        }
        return false;
    }
}
