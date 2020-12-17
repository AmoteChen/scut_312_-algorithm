### LeetCode-213 打家劫舍II

#### [213. 打家劫舍 II](https://leetcode-cn.com/problems/house-robber-ii/)

```java
/**
你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。

给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
*/


class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length <= 0) return 0;
        else if(nums.length <= 1) return nums[0];
        return Math.max(robby(Arrays.copyOfRange(nums,0,nums.length-1)),robby(Arrays.copyOfRange(nums,1,nums.length)));
    }
    public int robby(int[] nums) {
        if(nums == null || nums.length <= 0) return 0;
        else if(nums.length <= 1) return nums[0];
    
        int max = Math.max(nums[0],nums[1]);
        int pre = nums[0];

        for(int i=2; i<nums.length;i++){
            int temp = max;
            max=Math.max(pre+nums[i],max);
            pre=temp;
        }
        return max;
    }
}
```



robby 其实就是之前写的，滚动数组优化的动态规划解法。

这道题的精髓在于分析出 第一个房屋和最后一个房屋只能二选一打劫。就这么简单，分两种情况就好了。这个Arrays.copyOfRange(nums, 0 , nums.length-1) 可以记一下，挺巧妙的