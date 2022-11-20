package leetcode.editor.cn;

//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 5916 👎 0

public class P5_LongestPalindromicSubstring{
	public static void main(String[] args) {
		Solution solution = new P5_LongestPalindromicSubstring().new Solution();
		solution.longestPalindrome("babad");
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
		int maxLen = 0;
		int[] range = new int[2];
    public String longestPalindrome(String s) {
		char[] chs = s.toCharArray();
		int len = chs.length;
		// dp[i][j] 表示，i到j的最长回文
		int[][] dp = new int[len + 1][len + 1];
		for (int i = 0; i < len - 1; i++) {
			method1(chs, i, i);
			method1(chs, i, i + 1);
		}
		return s.substring(range[0], range[1] + 1);
    }

	private void method1(char[] chs, int left, int right) {
		while (left >= 0 && right < chs.length) {
			if (chs[left] == chs[right]) {
				left--;
				right++;
			} else {
				break;
			}
		}
		int cur = right - left + 1;
		if (cur > maxLen) {
			maxLen = cur;
			range[0] = left + 1;
			range[1] = right - 1;
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}