剑指offer-21 调整数组顺序使奇数位于偶数前面

题目虽然简单，挺考验编程经验和功底的。建议多尝试几种新的写法

粘个别人的代码

```java
class Solution {
    public int[] exchange(int[] nums) {
        int p = 0;
        int len = nums.length;
        for(int i = 0; i < len; i ++){
            if((nums[i]&1)==1){
                int tmp = nums[i];
                nums[i] = nums[p];
                nums[p++] = tmp;
            }
        }
        return nums;
    }
}
```

