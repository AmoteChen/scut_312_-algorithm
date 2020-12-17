// 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

// 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

//  

// 示例 1:

// 输入: [7,1,5,3,6,4]
// 输出: 7
// 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
//方法一：每天有赚就每天买第二天卖，在这道题可以这样取巧
class Solution {
    public int maxProfit(int[] prices) {
        int price = 0;
        for(int i=1;i<prices.length;i++)
        {
            int x= prices[i]-prices[i-1];
            if(x>0)
            {
                price+=x;
            }
        }
        return price;
    }
}
//方法二：简单的动态规划，空间简化版。第二天持有状态由第一天持有或者第一天不持有第二天买入转换而来。第二天不持有由第一天持有第二天卖出或第一天不持有转换而来
//取最大值就行啦
class Solution{
    public int maxProfit(int[]prices)
    {
        int len = prices.length;
        int[]dp = new int[2];
        dp[0] = 0;
        dp[1] = -prices[0];
        for(int i=1;i<len;i++)
        {
            int tmp = dp[0];
            dp[0] = Math.max(dp[0],dp[1]+prices[i]);
            dp[1] = Math.max(dp[1],tmp-prices[i]);
        }
        return dp[0];
    }
}