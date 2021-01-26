// 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
// 示例 1：

// 输入：nums = [3,4,3,3]
// 输出：4

//求出每位的和，然后除以3，就是剩下的那个数了
class Solution {
    public int singleNumber(int[] nums) {
        int[]counts = new int[32];
        for(int num:nums){
            for(int i=0;i<32;i++)
            {
                counts[i]+=num&1;
                num>>>=1;
            }
        }
        int res = 0; int m = 3;
        for(int i=0;i<32;i++)
        {
            res<<=1;
            res |= (counts[31-i]%3);
        }
        return res;
    }
}