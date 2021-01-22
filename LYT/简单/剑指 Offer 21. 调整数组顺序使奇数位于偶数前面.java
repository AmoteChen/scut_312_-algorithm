// 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
//方法一：新建数组双指针操作
class Solution {
    public int[] exchange(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length-1;
        for(int num:nums){
            if(num%2==1)
                result[left++]=num;
            else
                result[right--]=num;
        }
        return result;
    }
}
//方法二：在原数组双指针操作
class Solution {
    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1, tmp;
        while(i < j) {
            while(i < j && (nums[i] & 1) == 1) i++;
            while(i < j && (nums[j] & 1) == 0) j--;
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }
}