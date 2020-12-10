// 给你一个整数数组 arr ，请你删除最小 5% 的数字和最大 5% 的数字后，剩余数字的平均值。

// 与 标准答案 误差在 10-5 的结果都被视为正确结果。
//奇奇怪怪的题？
class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int len1 = n/20;
        double sum = 0;
        double count = (n - 2 * len1);
        for(int i = len1;i < n - len1;i++){
            sum += arr[i];
        }

        return sum/count;
        
    }
}