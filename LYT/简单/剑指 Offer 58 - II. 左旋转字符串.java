// 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
// 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
class Solution {
    public String reverseLeftWords(String s, int n) {
        char[]a = s.toCharArray();
        int len = a.length;
        char[]c = new char[len];
        if(len<n)
            return "";
        int index = 0;
        for(int i=n;i<len;i++)
        {
            c[index++]=a[i];
        }
        for(int i=0;i<n;i++)
        {
            c[index++]=a[i];
        }
        return new String(c);
    }
}