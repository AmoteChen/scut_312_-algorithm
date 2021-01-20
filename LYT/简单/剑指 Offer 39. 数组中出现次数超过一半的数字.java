// 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。

// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。

// 示例 1:

// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
// 输出: 2

class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int result = nums[0];
        for(int i = 1;i<nums.length;i++)
        {
            if(result==nums[i])
            {
                count++;
            }
            else{
                if(count==1)
                {
                    result = nums[i];
                    count = 1;
                }
                else{
                    count--;
                }
            }
        }
        return result;
    }
}