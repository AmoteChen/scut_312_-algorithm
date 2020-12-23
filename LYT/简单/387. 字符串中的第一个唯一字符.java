// 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

// 示例：

// s = "leetcode"
// 返回 0

// s = "loveleetcode"
// 返回 2
//先用一个int[26]数组来分别计算各个字母出现的次数，统计完后再到string中按顺序进行比较。次数为1就输出当前的序号
class Solution {
    public int firstUniqChar(String s) {
        char[] a = s.toCharArray();
        int[] b = new int[26];
        for(int i=0;i<a.length;i++)
        {
            b[a[i]-'a']++;
        }
        for(int i=0;i<a.length;i++)
        {
            if(b[a[i]-'a']==1)
                return i; 
        }
        return -1;
    }
}