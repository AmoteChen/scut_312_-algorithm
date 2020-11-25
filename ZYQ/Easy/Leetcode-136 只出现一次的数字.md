Leetcode-136 只出现一次的数字

#### [136. 只出现一次的数字](https://leetcode-cn.com/problems/single-number/)

```java
class Solution {
    public int singleNumber(int[] nums) {
        int n=0;
        for(int i=0;i<nums.length;i++){
            n=n^nums[i];
        }
        return n;
    }
}
```

玩玩异或