// 统计一个数字在排序数组中出现的次数。

// 示例 1:

// 输入: nums = [5,7,7,8,8,10], target = 8
// 输出: 2
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0)
            return 0;
        // 搜索右边界 right
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= target) i = m + 1;
            else j = m - 1;
        }
        // 若数组中无 target ，则提前返回
        if((j >= 0 && nums[j] != target)||(j<0)) 
            return 0;
        int right = j;
        int count = 1;
        for(int k = right-1;k>=0;k--)
        {
            if(nums[k]==nums[right])
                count++;
            else
                break;
        }
        return count;
    }
}