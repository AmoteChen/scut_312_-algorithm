// 给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。

// 数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder MyStringBuilder1 = new StringBuilder();
        StringBuilder MyStringBuilder2 = new StringBuilder();
        int len1 =word1.length;
        int len2 = word2.length;
        for(int i=0;i<len1;i++)
        {
            MyStringBuilder1.append(word1[i]);
        }
        for(int i=0;i<len2;i++)
        {
            MyStringBuilder2.append(word2[i]);
        }
        String a=MyStringBuilder1.toString();
        String b=MyStringBuilder2.toString();
        return a.equals(b);
    }
}