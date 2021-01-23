// 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。

// 示例:

// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
// 输出: [3,3,5,5,6,7] 
// 解释: 

//   滑动窗口的位置                最大值
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7
//方法一：模拟实现
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        int[] result = new int[nums.length-k+1];
        for(int i=0;i<=nums.length-k;i++)
        {
            int max = nums[i];
            for(int j=i+1;j<i+k;j++)
            {
                if(max<nums[j])
                    max=nums[j];
            }
            result[i]=max;
        }
        return result;
    }
}
//方法二：存放优先级队列，最大值放在队列头。 可以减去比较的时间消耗
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for(int i=0;i<k;i++)
        {
            while(!deque.isEmpty()&&deque.peekLast()<nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        for(int i=k;i<nums.length;i++)
        {
            if(nums[i-k]==deque.peekFirst())
                deque.removeFirst();
            while(!deque.isEmpty()&&deque.peekLast()<nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
            res[i-k+1]=deque.peekFirst();
        }
        return res;
    }
}