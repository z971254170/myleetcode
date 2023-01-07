//全字母句 指包含英语字母表中每个字母至少一次的句子。 
//
// 给你一个仅由小写英文字母组成的字符串 sentence ，请你判断 sentence 是否为 全字母句 。 
//
// 如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：sentence = "thequickbrownfoxjumpsoverthelazydog"
//输出：true
//解释：sentence 包含英语字母表中每个字母至少一次。
// 
//
// 示例 2： 
//
// 
//输入：sentence = "leetcode"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= sentence.length <= 1000 
// sentence 由小写英语字母组成 
// 
//
// Related Topics 哈希表 字符串 👍 64 👎 0


package leetcode.editor.cn;

/**
 * 判断句子是否为全字母句
 * @author ZSW
 * @date 2022-12-13 23:39:37
 */
public class P1832_CheckIfTheSentenceIsPangram{
    public static void main(String[] args) {
	 	 //测试代码
        Solution solution = new P1832_CheckIfTheSentenceIsPangram().new Solution();
    }
	 
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkIfPangram(String sentence) {
        char[] chs = sentence.toCharArray();
        int[] ints = new int[26];
        for (char ch : chs) {
            ints[ch - 'a'] = 1;
        }
        for (int num : ints) {
            if (num == 0) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}