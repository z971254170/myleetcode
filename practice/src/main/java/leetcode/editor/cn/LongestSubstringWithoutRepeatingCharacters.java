package leetcode.editor.cn;

//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 8426 👎 0

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters{
	public static void main(String[] args) {
		Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
		int temp = ' ';
		System.out.println(temp);
		temp = '1';
		System.out.println(temp);
		temp = '2';
		System.out.println(temp);
		char c = 0;
		System.out.println(c);
		solution.lengthOfLongestSubstring("abcabcbb");
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
		if ("".equals(s)) {
			return 0;
		}
		String trim = s.trim();
		if ("".equals(trim)) {
			return 1;
		}
		char[] chs = trim.toLowerCase().toCharArray();
		int len = chs.length;
		int[] arr = new int[128];
		Arrays.fill(arr, -1);
		int left = 0;
		int right = 0;
		int res = 1;
		boolean flag = false;
		while (right < len) {
			if (arr[chs[right] - '0'] != -1) {
				res = Math.max(right - left, res);
				left = arr[chs[right] - '0'] + 1;
				flag = true;
			}
			arr[chs[right] - '0'] = right;
			right++;
		}
		return flag ? res : right - left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}