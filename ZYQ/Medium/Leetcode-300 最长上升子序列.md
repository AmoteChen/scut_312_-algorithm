### Leetcode-300 经典DP题：最长上升子序列（也叫最长递增子序列）

#### [300. 最长上升子序列](https://leetcode-cn.com/problems/longest-increasing-subsequence/)

```java
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 1) return 1;
        else if(nums.length == 0 || nums==null)return 0;
        // dp思路1 dp[i] 表示以nums[i]结尾的最大上升子序列。一定要包括nums[i]
        // dp[i]={dp[j]+1,j是i前面比i小的第一个数，+1表示包括nums[i]在内}
        int [] dp = new int [nums.length];
        dp[0]=1;
        int max=dp[0];
        for(int i=1;i<nums.length;i++){
            dp[i]=1;
           for(int j=0;j<i;j++){
               if(nums[j]<nums[i])
                dp[i] = Math.max(dp[i],dp[j]+1);
           }
            max = Math.max(dp[i],max);
        }
        return max;
    }
}
```

只击败了6%的玩家。再见了xdm我倒下了。

最优解是用贪心策略+二分查找