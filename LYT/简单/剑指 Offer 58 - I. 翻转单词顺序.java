// 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。

// 示例 1：

// 输入: "the sky is blue"
// 输出: "blue is sky the"
class Solution {
    public String reverseWords(String s) {
        String[]a = s.trim().split(" ");
        StringBuilder result = new StringBuilder();
        for(int i=a.length-1;i>=0;i--)
        {
            if(a[i].equals(""))
                continue;
            if(i!= 0)
                result.append(a[i].trim()+" ");
            else
                result.append(a[i].trim());
        }
        return result.toString();
    }
}