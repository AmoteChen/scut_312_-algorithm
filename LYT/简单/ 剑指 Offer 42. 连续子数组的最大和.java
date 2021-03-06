// 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。

// 要求时间复杂度为O(n)。
// 示例1:

// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
// 输出: 6
// 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int tmp = nums[0];
        for(int i = 1;i<nums.length;i++)
        {
            tmp = Math.max(tmp+nums[i],nums[i]);
            if(tmp>max)
                max = tmp;
        }
        return max;
    }
}