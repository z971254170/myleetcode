//一个正整数如果能被 a 或 b 整除，那么它是神奇的。 
//
// 给定三个整数 n , a , b ，返回第 n 个神奇的数字。因为答案可能很大，所以返回答案 对 10⁹ + 7 取模 后的值。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：n = 1, a = 2, b = 3
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：n = 4, a = 2, b = 3
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁹ 
// 2 <= a, b <= 4 * 10⁴ 
// 
//
// 
//
// Related Topics 数学 二分查找 👍 194 👎 0


package leetcode.editor.cn;

/**
 * 第 N 个神奇数字
 * @author ZSW
 * @date 2022-11-22 23:11:26
 */
public class P878_NthMagicalNumber{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P878_NthMagicalNumber().new Solution();
		 int gcd = solution.gcd(2, 3);

	 }


	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	static final int MOD = 1000000007;
    public int nthMagicalNumber(int n, int a, int b) {
    	long left = Math.min(a, b);
    	long right = (long) n * Math.max(a, b);
    	int c = lcm(a, b);
    	while (left <= right) {
    		long mid = (left + right) / 2;
    		long cnt = mid / a + mid / b - mid / c;
    		if (cnt >= n) {
    			right = mid - 1;
			} else {
    			left = mid + 1;
			}
		}
		return (int) ((right + 1) % MOD);
    }
    private int lcm(int a, int b) {
    	return a * b /gcd(a, b);
	}

	private int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
