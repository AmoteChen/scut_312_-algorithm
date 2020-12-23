// 给你一个数字数组 arr 。

// 如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。

// 如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int x = arr[1]-arr[0];
        for(int i=2;i<arr.length;i++)
        {
            if(arr[i]-arr[i-1]!=x)
                return false;
        }
        return true;
    }
}