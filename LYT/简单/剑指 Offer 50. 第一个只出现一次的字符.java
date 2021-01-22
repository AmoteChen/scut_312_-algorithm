// 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

// 示例:

// s = "abaccdeff"
// 返回 "b"

class Solution {
    public char firstUniqChar(String s) {
        char[] e = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for(char c:e)
        {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(char c:e)
        {
            if(map.get(c)==1)
                return c;
        }
        return ' ';
    }
}