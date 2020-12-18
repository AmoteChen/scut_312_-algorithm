// 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。

// 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。

// 示例 1：

// 输入：arr = [1,2,2,1,1,3]
// 输出：true
// 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
//先排序，然后把相同的数出现个数进行计算，将计算结果放入hashset中，每次放入前先判断是set中是否存在相同的
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        Set<Integer> result = new HashSet<>();
        int count = 1;     
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]==arr[i-1])
                count++;
            else
            {
                if(result.contains(count))
                    return false;
                result.add(count);
                count=1;
            }
        }
        if(result.contains(count))
            return false;
        return true;
    }
}