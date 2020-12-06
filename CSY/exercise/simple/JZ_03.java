import java.util.HashMap;

/***
 * 剑指offer03找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 */


public class JZ_03 {
    public int findRepeatNumber(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
              if(nums[i]==nums[j]){
                return nums[j];}
            }
        }
        return 0;

        /***
         * Set<Integer> set = new HashSet<Integer>();
         *         int repeat = -1;
         *         for (int num : nums) {
         *             if (!set.add(num)) {
         *                 repeat = num;
         *                 break;
         *             }
         *         }
         *         return repeat;
         *     }
         *
         */
    }

    public static void main(String[] args) {
        JZ_03 tester = new JZ_03();
        int[]test = {0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        System.out.println(tester.findRepeatNumber(test));

    }
}
