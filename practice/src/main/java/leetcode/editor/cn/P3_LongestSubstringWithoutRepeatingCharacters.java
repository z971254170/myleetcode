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

import java.util.HashMap;
import java.util.Map;

public class P3_LongestSubstringWithoutRepeatingCharacters{
	public static void main(String[] args) {
		Solution solution = new P3_LongestSubstringWithoutRepeatingCharacters().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
		if ("".equals(s)) {
			return 0;
		}
		String trim = s.trim();
		if ("".equals(s)) {
			return 1;
		}
		Map<Character, Integer> map = new HashMap<>();
		char[] chs = trim.toCharArray();
		int left = 0;
		int res = 1;
		for (int i = 0; i < chs.length; i++) {
			if (map.containsKey(chs[i])) {
				left = Math.max(left, map.get(chs[i]) + 1);
			}
			map.put(chs[i], i);
			res = Math.max(res, i - left + 1);
		}
		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}