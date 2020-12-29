// 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

// 说明：解集不能包含重复的子集。
//经典回溯法
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result= new ArrayList<>();
        dfs(nums,0,result,new ArrayList<Integer>());
        return result;
    }
    public void dfs(int[]nums,int start,List<List<Integer>>result,ArrayList<Integer>map)
    {
          //走过的所有路径都是子集的一部分，所以都要加入到集合中
        result.add(new ArrayList(map));
        for(int i=start;i<nums.length;i++)
        {
            //做出选择
            map.add(nums[i]);
            //递归
            dfs(nums,i+1,result,map);
            //撤销选择
            map.remove(map.size()-1);
        }
    }
}