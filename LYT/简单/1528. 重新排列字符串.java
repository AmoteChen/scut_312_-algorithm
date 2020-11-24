// 给你一个字符串 s 和一个 长度相同 的整数数组 indices 。

// 请你重新排列字符串 s ，其中第 i 个字符需要移动到 indices[i] 指示的位置。

// 返回重新排列后的字符串。
// 输入：s = "codeleet", indices = [4,5,6,7,0,2,1,3]
// 输出："leetcode"
// 解释：如图所示，"codeleet" 重新排列后变为 "leetcode" 。

class Solution {
    public String restoreString(String s, int[] indices) {
        char[] a = s.toCharArray();
        int len = indices.length;
        char[] b = new char[len];
        for(int i=0;i<len;i++){
            b[indices[i]] = a[i];
        }
        String result =String.valueOf(b);
        return result;
    }
}