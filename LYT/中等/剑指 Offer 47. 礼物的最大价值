//在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
//你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？

//输入: 
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 12
//解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
//动态规划
class Solution {
    public int maxValue(int[][] grid) {     //由于 dp[i][j]dp[i][j] 只与 dp[i-1][j]dp[i−1][j] , dp[i][j-1]dp[i][j−1] , grid[i][j]grid[i][j] 有关系，因此可以将原矩阵 gridgrid 用作 dpdp 矩阵，即直接在 gridgrid 上修改即可。
        int m = grid.length, n = grid[0].length;  
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) continue;  //当 i = 0 且 j = 0 时，为起始元素；
                if(i == 0) grid[i][j] += grid[i][j - 1] ;   //当 i = 0 且 j != 0 时，只可从左边到达；
                else if(j == 0) grid[i][j] += grid[i - 1][j]; //当i!=0 且j=0 时，只可从上面到达
                else grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);   //可以从上面和左边到达，需要进行比较
            }
        }
        return grid[m - 1][n - 1];
    }
}