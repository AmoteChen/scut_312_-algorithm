剑指 Offer 53 - II. 0～n-1中缺失的数字

#### [剑指 Offer 53 - II. 0～n-1中缺失的数字](https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/)

二分法的一次简单实践

```java
class Solution {
    public int missingNumber(int[] nums) {
        int left=0;
        int right = nums.length-1;

        while(left<right){
            int middle = left+((right-left)>>1);
            if(nums[middle]>middle){
                right=middle-1;
            }
            else{
                left=middle+1;
            }
        }
        if(nums[left]>left){
            return left;
        }
        else{
            return left+1;
        }

    }
}
```

