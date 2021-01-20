// 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。

// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

// 示例 1：

// 输入：target = 9
// 输出：[[2,3,4],[4,5]]
class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> result = new ArrayList<int[]>();
        for(int i =1;i<=(target-1)/2;i++)
        {
            int j = i;
            int count = i;
            while(count<=target)
            {
                if(count==target)
                {
                    int[] res = new int[j - i + 1];
                    for (int k = i; k <= j; ++k) {
                        res[k - i] = k;
                    }
                    result.add(res);
                    break;
                }
                j++;
                count+=j;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}