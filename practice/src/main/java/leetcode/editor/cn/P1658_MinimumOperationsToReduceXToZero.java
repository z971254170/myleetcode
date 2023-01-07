package leetcode.editor.cn;

//给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改
// 数组以供接下来的操作使用。 
//
// 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,4,2,3], x = 5
//输出：2
//解释：最佳解决方案是移除后两个元素，将 x 减到 0 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,6,7,8,9], x = 4
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,2,20,1,1,3], x = 10
//输出：5
//解释：最佳解决方案是移除后三个元素和前两个元素（总共 5 次操作），将 x 减到 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁴ 
// 1 <= x <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 二分查找 前缀和 滑动窗口 👍 216 👎 0

public class P1658_MinimumOperationsToReduceXToZero{
	public static void main(String[] args) {
		Solution solution = new P1658_MinimumOperationsToReduceXToZero().new Solution();
		int[] arr1 = new int[]{1,1,4,2,3};
		solution.minOperations(arr1, 5);
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minOperations(int[] nums, int x) {
		int left = 0;
		int right = nums.length - 1;
		int count = 0;

		while (left < nums.length - 1 && right >= 0 && left < right) {
			count++;
			int leftNum = -1;
			int rightNum = -1;
			if (nums[left] <= x || nums[right] <= x) {
				if (nums[left] <= x) {
					leftNum = Math.abs(x - nums[left]);
				}
				if (nums[right] <= x) {
					rightNum= Math.abs(x - nums[right]);
				}

				if (leftNum == 0 || rightNum == 0) {
					return count;
				}
				if (leftNum < rightNum) {
					x = leftNum;
					left++;
				} else {
					x = rightNum;
					right--;
				}
			} else {
				break;
			}
		}
		return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}