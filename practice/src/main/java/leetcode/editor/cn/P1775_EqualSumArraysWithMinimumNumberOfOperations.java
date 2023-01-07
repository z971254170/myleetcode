//给你两个长度可能不等的整数数组 nums1 和 nums2 。两个数组中的所有值都在 1 到 6 之间（包含 1 和 6）。 
//
// 每次操作中，你可以选择 任意 数组中的任意一个整数，将它变成 1 到 6 之间 任意 的值（包含 1 和 6）。 
//
// 请你返回使 nums1 中所有数的和与 nums2 中所有数的和相等的最少操作次数。如果无法使两个数组的和相等，请返回 -1 。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2]
//输出：3
//解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
//- 将 nums2[0] 变为 6 。 nums1 = [1,2,3,4,5,6], nums2 = [6,1,2,2,2,2] 。
//- 将 nums1[5] 变为 1 。 nums1 = [1,2,3,4,5,1], nums2 = [6,1,2,2,2,2] 。
//- 将 nums1[2] 变为 2 。 nums1 = [1,2,2,4,5,1], nums2 = [6,1,2,2,2,2] 。
// 
//
// 示例 2： 
//
// 输入：nums1 = [1,1,1,1,1,1,1], nums2 = [6]
//输出：-1
//解释：没有办法减少 nums1 的和或者增加 nums2 的和使二者相等。
// 
//
// 示例 3： 
//
// 输入：nums1 = [6,6], nums2 = [1]
//输出：3
//解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
//- 将 nums1[0] 变为 2 。 nums1 = [2,6], nums2 = [1] 。
//- 将 nums1[1] 变为 2 。 nums1 = [2,2], nums2 = [1] 。
//- 将 nums2[0] 变为 4 。 nums1 = [2,2], nums2 = [4] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 10⁵ 
// 1 <= nums1[i], nums2[i] <= 6 
// 
//
// Related Topics 贪心 数组 哈希表 计数 👍 58 👎 0


package leetcode.editor.cn;

/**
 * 通过最少操作次数使数组的和相等
 * @author ZSW
 * @date 2022-12-07 00:39:56
 */
public class P1775_EqualSumArraysWithMinimumNumberOfOperations{
    public static void main(String[] args) {
	 	 //测试代码
        Solution solution = new P1775_EqualSumArraysWithMinimumNumberOfOperations().new Solution();
    }
	 
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (6 * len1 < len2 || 6 * len2 < len1) {
            return -1;
        }
        int d = 0;
        for (int x : nums2) {
            d += x;
        }
        for (int x : nums1) {
            d += x;
        }
        if (d < 0) {
            d = -d;
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp; // 交换，统一让nums1的数变大，nums2的数变小
        }
        int[] cnt = new int[6]; // 统计每个数的最大变化量
        for (int x : nums1) {
            ++cnt[6- x]; // nums1 的变成6
        }
        for (int x : nums2) {
            ++cnt[x - 1]; // nums2 的变成 1
        }
        for (int i = 5, ans = 0; ;i--) {
            if (i * cnt[i] >= d) {
                return ans + (d + i - 1) / i;
            }
            ans += cnt[i];
            d -= i * cnt[i];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}