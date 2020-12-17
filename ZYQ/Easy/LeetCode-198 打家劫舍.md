### LeetCode-198 打家劫舍

#### [198. 打家劫舍](https://leetcode-cn.com/problems/house-robber/)

```java
class Solution {
    public int rob(int[] nums) {
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

动态规划+滚动数组优化空间就好了，思路一定要清晰，不清晰就多刷几次。

dp[i] = max{ dp[i-1], dp[i-2] + nums[i] }

dp[i]表示偷取前k个房间的最高金额