// 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
// 示例 1：

// 输入：m = 2, n = 3, k = 1
// 输出：3
//要保证有去无回，需要对走过的地方进行记录，然后从（0,0）开始走，明显只有向右或者向下是前进，所以遍历这两个方向就行。
//其它的满足题目要求即可！
class Solution {
    int count=0;
    boolean[][] result;
    public int movingCount(int m, int n, int k) {
        this.result=new boolean[m][n]; 
        Count(m,n,k,0,0);
        return count;
    }
    public int Count(int m,int n,int k,int i,int j)
    {
        if(i<0||j<0||i==m||j==n||countInt(i)+countInt(j)>k||result[i][j]==true)
            return 0;
        count++;
        result[i][j]=true;
        Count(m,n,k,i+1,j);
        Count(m,n,k,i,j+1);
        return 0;
    }
    public int countInt(int x)
    {
        int c = 0;
        int y=x;
        while(y!=0)
        {
            c+=y%10;
            y=y/10;
        }
        return c;
    }
}