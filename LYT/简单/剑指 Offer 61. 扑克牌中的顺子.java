// 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
//判断条件：1.max-min<5   2.牌不重复   就可以包括所有的情况了！  
class Solution {
    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0; int min = 14;
        for(int i =0;i<5;i++)
        {
            if(nums[i]==0)
                continue;
            if(set.contains(nums[i]))
                return false;
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[i]);
            set.add(nums[i]);
        }
        if(max-min<5)
            return true;
        return false;
    }
}