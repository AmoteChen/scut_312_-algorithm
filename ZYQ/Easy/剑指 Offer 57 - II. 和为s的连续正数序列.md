### 剑指 Offer 57 - II. 和为s的连续正数序列

#### [剑指 Offer 57 - II. 和为s的连续正数序列](https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/)

```java
class Solution {
    public int[][] findContinuousSequence(int target) {
        // if(target <=0) return null;
        int left = 1;
        int right=1;
        List<int []> list = new ArrayList();
        int sum=0;
        while(left<=target/2){
            if(sum<target){
                sum+=right;
                right++;
            }
            else if(sum>target){
                sum-=left;
                left++;
            }
            else{
                int [] temp = new int [right-left];
                for(int i=left;i<right;i++){
                    temp[i-left]=i;
                }
                list.add(temp);
                sum-=left;
                left++;
            }
        }
        return list.toArray(new int [list.size()][]);
    }
}
```

滑动窗口。

记录一次结果后，千万不要忘了

移动左边界移动左边界移动左边界移动左边界移动左边界移动左边界

移动左边界

移动左边界

移动左边界