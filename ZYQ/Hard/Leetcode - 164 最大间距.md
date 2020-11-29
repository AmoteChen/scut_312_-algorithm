Leetcode - 164 最大间距

不要跟老夫说什么O(n)，什么线性复杂度，什么基数排序，桶排序

我只是个无情的AC机器！Arrays.sort()万岁！

```java
class Solution {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int max=0;
        for(int i=0;i<nums.length-1;i++){
            max = (int)Math.max(Math.abs(nums[i]-nums[i+1]),max);
        }
        return max;
    }
}
```

