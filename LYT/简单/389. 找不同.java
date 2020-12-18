// 给定两个字符串 s 和 t，它们只包含小写字母。

// 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。

// 请找出在 t 中被添加的字母。

//  

// 示例 1：

// 输入：s = "abcd", t = "abcde"
// 输出："e"
// 解释：'e' 是那个被添加的字母。
//你打乱我就再排回来呗！
class Solution {
    public char findTheDifference(String s, String t) {
        char[]a = s.toCharArray();
        char[]b = t.toCharArray();
        if(a.length==0)
            return b[0];
        Arrays.sort(a);
        Arrays.sort(b);
        for(int i=0;i<a.length;i++)
        {
            if(a[i]!=b[i])
                return b[i];
        }
        return b[b.length-1];
    }
}