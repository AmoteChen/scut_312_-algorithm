### Leetcode-11 盛最多水的容器

#### [11. 盛最多水的容器](https://leetcode-cn.com/problems/container-with-most-water/)

我觉得这种题记住套路就行了，不用过多地去纠结为什么这样是对的，为什么要这样想。

双指针法：从头和尾开始计算面积。每次把小的那边的指针向中间移动。

我们可以考虑暴力搜索：遍历所有的元素，计算每个元素和其他元素所组成的面积。我们会发现，对于相同的一对元素，我们计算了两次他们之间的面积，因此会导致复杂度达到O(n²)。

因此我们就思考一些套路，如何只计算一次。

然后想到了双指针。面试就这么鬼扯吧。

```java
public int maxArea(int[] height) {
    int left = 0;
    int right = height.length-1;
    int maxAr=0;

    while(left<right){
        if(height[left]<height[right]){
            maxAr=Math.max(maxAr,height[left]*(right-left));
            left++;
        }
        else{
            maxAr=Math.max(maxAr,height[right]*(right-left));
            right--;
        }
    }
    return maxAr;
}
```