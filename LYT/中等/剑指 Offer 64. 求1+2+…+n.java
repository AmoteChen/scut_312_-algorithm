// 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
//这里用到&的短路思想，前一个数为false则之后的数不会执行
class Solution {
    int res = 0;
    public int sumNums(int n) {
        boolean x = n>1&&sumNums(n-1)>0;
        res+=n;
        return res;
    }
}