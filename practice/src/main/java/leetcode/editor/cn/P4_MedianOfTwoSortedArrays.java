package leetcode.editor.cn;

//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 分治 👍 6083 👎 0

import java.util.Arrays;

public class P4_MedianOfTwoSortedArrays{
	public static void main(String[] args) {
		Solution solution = new P4_MedianOfTwoSortedArrays().new Solution();
		int[] ints = {1, 2};
		int[] ints1 = {3, 4};
		solution.findMedianSortedArrays(ints, ints1);
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		int[] arr = new int[len1 + len2];
		int idx1 = 0;
		int idx2 = 0;
		for (int i = 0; i < len1 + len2; i++) {
			if (idx1 < len1) {
				arr[i] = nums1[idx1++];
			} else {
				arr[i] = nums2[idx2++];
			}
		}
		Arrays.sort(arr);
		if ((len1 + len2) % 2 == 0) {
			return ((double) arr[(len1 + len2) / 2] + (double) arr[(len1 + len2) / 2 - 1]) / 2;
		}
		return arr[(len1 + len2) / 2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}