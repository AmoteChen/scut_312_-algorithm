// 整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。

// 示例1:

//  输入：A = 29 （或者0b11101）, B = 15（或者0b01111）
//  输出：2

class Solution {
    public int convertInteger(int A, int B) {
        int temp = A ^ B;
        int count = 0;
        while (temp != 0) {
            temp &= (temp - 1);  // 去掉二进制表示的最右边的1
            count++;
        }
        return count;
    }
}