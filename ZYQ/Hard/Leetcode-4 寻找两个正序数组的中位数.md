Leetcode-4 寻找两个正序数组的中位数

困难题就算思路清晰都未必能做得对。背答案多刷几次吧。至少原理懂了。

思路：要寻找第k大的数，我们只需要对比两个正序数组的第k/2个数：如果a.[k/2-1] > b.[k/2-1]，那么可以肯定第k大的数肯定不在b[k/2-1]里面。依据这个思路用二分法求解：每次排除k/2个数.总时间复杂度：O(long(m+n));（O(logk)，而k=m+n/2）

```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int n=nums1.length;
            int m = nums2.length;
            int k1=(n+m+1)/2;
            int k2=(n+m+2)/2;
            return (findKth(nums1,0,n-1,nums2,0,m-1,k1) + findKth(nums1,0,n-1,nums2,0,m-1,k2)) * 0.5;

    }
    private int findKth(int [] nums1,int start1,int end1,int[] nums2,int start2,int end2,int k){
        int len1 = (end1-start1+1);
        int len2 = (end2-start2+1);
        if(len1>len2) return findKth(nums2,start2,end2,nums1,start1,end1,k);
        if(len1==0)return nums2[start2+k-1];
        if(k==1) return Math.min(nums1[start1],nums2[start2]);

        int i=start1 + Math.min(k/2,len1) -1;//由于k/2可能超过数组的长度，因此需要对比。然后计算得到的i和j是实际的位置
        int j = start2 + Math.min(k/2,len2) -1;

        if(nums1[i]>nums2[j]){
            return findKth(nums1,start1,end1,nums2,j+1,end2,k-(j-start2+1));
        }
        else{
            return findKth(nums1,i+1,end1,nums2,start2,end2,k-(i-start1+1));
        }
    }
}
```

很多边界条件要考虑：

1. k1和k2的取值：要让k1和k2避免奇偶性问题，使得无论m+n是偶数还是奇数，(find(k1)+find(k2))/2 的结果都是正确的。
2. 传值的时候，要注意传的右边界是length-1，而不是length；
3. 边界判断：k/2可能比数组还大。这个时候我们要将指针指向短数组的末尾。即len-1。
4. 巧妙地根据len1和len2的大小关系交换两个数组的位置，确保len1<len2会很好操作
5. 对比时思路要清晰：每次排除后，将start的值勇敢地更新到i+1或j+1，这个是不会越界的。因为之前我们会做判断：if(len1==0) return nums2[start2+k-1]; len1==0说明start=end+1，即此时虽然start已经越界了，但我们不会用它来访问数组。