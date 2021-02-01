// 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。

// 示例:

// 输入: [1,2,3,4,5]
// 输出: [120,60,40,30,24]

//结题思路是分两次乘，第一次乘下三角的数，第二次乘上三角的数。
class Solution {
    public int[] constructArr(int[] a) {
        if(a.length==0) return new int[0];
        int[] result = new int[a.length];
        result[0] = 1;
        int tmp = 1;
        for(int i=1;i<a.length;i++)
        {
            result[i] = result[i-1]*a[i-1];
        }
        for(int i = a.length-2;i>=0;i--)
        {
            tmp *= a[i+1];
            result[i] *=tmp;
        }
        return result;
    }
}