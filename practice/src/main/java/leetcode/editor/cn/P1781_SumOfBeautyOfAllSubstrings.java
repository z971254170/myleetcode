//一个字符串的 美丽值 定义为：出现频率最高字符与出现频率最低字符的出现次数之差。 
//
// 
// 比方说，"abaacc" 的美丽值为 3 - 1 = 2 。 
// 
//
// 给你一个字符串 s ，请你返回它所有子字符串的 美丽值 之和。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aabcb"
//输出：5
//解释：美丽值不为零的字符串包括 ["aab","aabc","aabcb","abcb","bcb"] ，每一个字符串的美丽值都为 1 。 
//
// 示例 2： 
//
// 
//输入：s = "aabcbaa"
//输出：17
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// s 只包含小写英文字母。 
// 
//
// Related Topics 哈希表 字符串 计数 👍 77 👎 0


package leetcode.editor.cn;

/**
 * 所有子字符串美丽值之和
 * @author ZSW
 * @date 2022-12-12 23:02:37
 */
public class P1781_SumOfBeautyOfAllSubstrings{
    public static void main(String[] args) {
	 	 //测试代码
        Solution solution = new P1781_SumOfBeautyOfAllSubstrings().new Solution();
    }
	 
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int beautySum(String s) {
        int res = 0;
        for (int i = 0;i < s.length();i++) {
            int[] cnt = new int[26];
            int maxFreq = 0;
            for (int j = i; j < s.length(); j++) {
                cnt[s.charAt(j) - 'a']++;
                maxFreq = Math.max(maxFreq, cnt[s.charAt(j) - 'a']);
                int minFreq = s.length();
                for (int k = 0; k < 26; k++) {
                    if (cnt[k] > 0) {
                        minFreq = Math.min(minFreq, cnt[k]);
                    }
                }
                res += maxFreq - minFreq;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}