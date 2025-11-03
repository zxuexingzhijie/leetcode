import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class problem78 {
    public static void main(String[] args) {
        Solution78 solution78 = new Solution78();
        String s = "leetcode";
        ArrayList<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        boolean option = solution78.wordBreak(s, wordDict);
        System.out.println(option);
    }
}

class Solution78 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}