// 给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0 。
// 输入：n = 5
// 输出：[-7,-1,1,3,4]
// 解释：这些数组也是正确的 [-5,-1,1,2,3]，[-3,-1,2,-2,4]。
class Solution {
    public int[] sumZero(int n) {
        int[]result =new int[n];
        if(n%2==0){
            for(int i=1;i<=n/2;i++){
                result[i-1]=i;
                result[n/2+i-1]=-i;
            }
        }
        else{
            for(int i=1;i<=(n-1)/2;i++){
                result[i-1]=i;
                result[(n-1)/2+i-1]=-i;
            }
            result[n-1]=0;            
        }
        return result;
    }
}