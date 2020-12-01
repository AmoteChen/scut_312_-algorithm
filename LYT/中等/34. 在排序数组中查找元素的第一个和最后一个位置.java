// 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

// 如果数组中不存在目标值 target，返回 [-1, -1]。

// 进阶：

// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？

//用二分查找法，方法不难，要注意细节！先找到target 然后再左右慢慢扩展去找。容易理解且好用

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0)
            return new int[]{-1, -1};
        int find = findtarget(nums,target);
        if(find==-1)
            return new int[]{-1, -1};
        int left = find-1;
        int right = find +1;
        while(left>=0&&nums[left]==target)
            left--;
        while(right<=nums.length-1&&nums[right]==target)
            right++;
        return new int[]{left+1,right-1};
    }
    public int findtarget(int[] nums,int target)
    {
        int left=0;
        int right=nums.length-1;
        int mid = 0;
        while(left<=right){
            mid = left+(right-left)/2;
            if(target>nums[mid])
                left = mid+1;
            else{
                if(target<nums[mid])
                    right=mid-1;
                else
                    return mid;
            }
        }
        return -1;
    }
}

