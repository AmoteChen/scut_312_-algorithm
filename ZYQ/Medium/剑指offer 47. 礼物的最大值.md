### 剑指offer 47. 礼物的最大值

#### [剑指 Offer 47. 礼物的最大价值](https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/)

解法一：最简单粗暴原始dp解法

```java
class Solution {
    public int maxValue(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0){
            return -1;
        }
        // dp[i][j] = max{dp[i-1][j],dp[i][j-1]}  dp[0][0] = grid[0][0];
        int lengthx = grid.length;
        int lengthy = grid[0].length;
        int [][] dp = new int [lengthx][lengthy];
        int sumx=0;
        int sumy=0;
        for(int m=0;m<lengthx;m++){
            sumx+= grid[m][0];
            dp[m][0] =sumx;
        }
        for(int n=0;n<lengthy;n++){
            sumy+=grid[0][n];
            dp[0][n] = sumy;
        }
        for(int i=1;i<lengthx;i++){
            for (int j=1;j<lengthy;j++){
                dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j])+grid[i][j];
            }
        }
        return dp[lengthx-1][lengthy-1];
    }
}
```



可以直接在grid上修改。优化空间复杂度。但是实际上提交的时候反而内存消耗更多。



解法二 贪心算法。

日后再补充吧