//给你一个整数数组 nums 和两个整数：left 及 right 。找出 nums 中连续、非空且其中最大元素在范围 [left, right] 内的子数组
//，并返回满足条件的子数组的个数。 
//
// 生成的测试用例保证结果符合 32-bit 整数范围。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,1,4,3], left = 2, right = 3
//输出：3
//解释：满足条件的三个子数组：[2], [2, 1], [3]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,9,2,5,6], left = 2, right = 8
//输出：7
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 0 <= left <= right <= 10⁹ 
// 
//
// Related Topics 数组 双指针 👍 319 👎 0


package leetcode.editor.cn;

/**
 * 区间子数组个数
 *
 * @author ZSW
 * @date 2022-11-24 23:21:07
 */
public class P795_NumberOfSubarraysWithBoundedMaximum {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P795_NumberOfSubarraysWithBoundedMaximum().new Solution();
        int[] arr = new int[]{2,1,4,3};
        int[] arr2 = new int[]{2,9,2,5,6};
        int max = solution.numSubarrayBoundedMax(arr2, 2, 8);
        System.out.println(max);
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubarrayBoundedMax(int[] nums, int left, int right) {
            // dp[i] 前i个元素组成的数组满足条件的子数组个数
            int len = nums.length;
            int[] dp = new int[len + 1];
            int preNumPos = 2;
            for (int i = 1; i < len + 1; i++) {
                int curNumPos = numPosition(nums[i - 1], left, right);
                if (curNumPos == 0) {
                    dp[i] = preNumPos == 2 ? dp[i - 1] + 1
                            : dp[i - 1] + 2;
                } else if (curNumPos == 1) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = dp[i - 1];
                }
                preNumPos = curNumPos;
            }
            return dp[len];
        }

        private int numPosition(int num, int left, int right) {
            if (left <= num && num <= right) {
                return 0;
            }
            if (num < left) {
                return 1;
            }
            return 2;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
