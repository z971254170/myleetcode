package leetcode.editor.cn;

//你打算利用空闲时间来做兼职工作赚些零花钱。 
//
// 这里有 n 份兼职工作，每份工作预计从 startTime[i] 开始到 endTime[i] 结束，报酬为 profit[i]。 
//
// 给你一份兼职工作表，包含开始时间 startTime，结束时间 endTime 和预计报酬 profit 三个数组，请你计算并返回可以获得的最大报酬。 
//
// 注意，时间上出现重叠的 2 份工作不能同时进行。 
//
// 如果你选择的工作在时间 X 结束，那么你可以立刻进行在时间 X 开始的下一份工作。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
//输出：120
//解释：
//我们选出第 1 份和第 4 份工作， 
//时间范围是 [1-3]+[3-6]，共获得报酬 120 = 50 + 70。
// 
//
// 示例 2： 
//
// 
//
// 输入：startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60
//]
//输出：150
//解释：
//我们选择第 1，4，5 份工作。 
//共获得报酬 150 = 20 + 70 + 60。
// 
//
// 示例 3： 
//
// 
//
// 输入：startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// 1 <= startTime.length == endTime.length == profit.length <= 5 * 10^4 
// 1 <= startTime[i] < endTime[i] <= 10^9 
// 1 <= profit[i] <= 10^4 
// 
//
// Related Topics 数组 二分查找 动态规划 排序 👍 325 👎 0

import java.util.Arrays;
import java.util.Comparator;

public class MaximumProfitInJobScheduling{
	public static void main(String[] args) {
		Solution solution = new MaximumProfitInJobScheduling().new Solution();
//		int[] startTime = new int[]{1,2,3,3};
//		int[] endTime = new int[]{3,4,5,6};
//		int[] profit = new int[]{50,10,40,70};
		int[] startTime = new int[]{4,2,4,8,2};
		int[] endTime = new int[]{5,5,5,10,8};
		int[] profit = new int[]{1,2,8,10,4};
		solution.jobScheduling(startTime,endTime,profit);

	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		int len = profit.length;
		int[][] jobs = new int[len][3];
		for (int i = 0; i < len; i++) {
			jobs[i][0] = startTime[i];
			jobs[i][1] = endTime[i];
			jobs[i][2] = profit[i];
		}
		Arrays.sort(jobs, Comparator.comparingInt((int[] arr) -> arr[1]));
		int[] dp = new int[len + 1];

		for (int i = 1; i < len + 1; i++) {
			int k = getIdx(jobs,jobs[i - 1][0],i - 1);
			dp[i] = Math.max(dp[i-1], jobs[i-1][2] + dp[k+1]);
			//System.out.println(Arrays.toString(dp));
		}
		return dp[len];
    }

	private int getIdx(int[][] jobs, int target, int idx) {
		for (int i = idx - 1; i >= 0; i--) {
			if (jobs[i][1] <= target) {
				return i;
			}
		}
		return -1;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}