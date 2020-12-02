// 统计所有小于非负整数 n 的质数的数量。

//这题可真不简单。。
//首先最优解是一种空间换时间的做法，要注意三个点
//1.首先验证素数只需要验证到，n的平方根就好了，这点可以自己验证一下
//2.素数的倍数都不是素数，这点可以提前算出来！
//3.在去除素数的倍数不是素数时，还有优化方法，那就是从i*i开始计算，这样可以除去2*i 3*i这样的冗余
class Solution {
int countPrimes(int n) {
    boolean[] isPrim = new boolean[n];
    Arrays.fill(isPrim, true);
    for (int i = 2; i * i < n; i++) 
        if (isPrim[i]) 
            for (int j = i * i; j < n; j += i) 
                isPrim[j] = false;
    
    int count = 0;
    for (int i = 2; i < n; i++)
        if (isPrim[i]) count++;
    
    return count;
}
}